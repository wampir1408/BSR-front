package bsr.front.controllers;

import bsr.front.models.AccountChoiceBoxModel;
import bsr.front.singletonInstances.ServerConnection;
import bsr.front.utils.DialogsUtil;
import bsr.server.innerservices.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.util.List;

/**
 * Created by Impresyjna on 01.01.2017.
 */

/**
 * Controller for deposit money fragment
 */
public class DepositMoneyFragmentController {
    @FXML
    private javafx.scene.control.ChoiceBox<AccountChoiceBoxModel> accountChoiceBox;
    @FXML
    private TextField amountTextField;
    @FXML
    private TextField titleTextField;

    /**
     * Triggered when view is shown
     */
    @FXML
    public void initialize() {
        getAccountsFromServer();
    }

    /**
     * Action triggered when button pushed
     * @param event Which button pushed
     */
    @FXML
    public void depositAction(ActionEvent event) {
        String selectedBankAccountNumber = accountChoiceBox.getValue().getKey();
        String amount = amountTextField.getText();
        String title = titleTextField.getText();
        System.out.println(selectedBankAccountNumber);
        try {
            Operation newOperation = null;
            newOperation = ServerConnection.getInstance().getAccountService().depositMoney(title, amount, selectedBankAccountNumber);
            DialogsUtil.showSuccess("Deposit succeeded \n Account balance: " + (double) newOperation.getBalanceAfter()/100 + "$");
            clearFormAndRefresh();
        } catch (AccountServiceException_Exception | NotValidException_Exception | OperationException_Exception | SessionException_Exception | AccountException_Exception | UserException_Exception  e) {
            DialogsUtil.showException(e.getMessage());
        }
    }

    /**
     * Clears all textFields and choiceBox
     */
    private void clearFormAndRefresh() {
        accountChoiceBox.valueProperty().set(null);
        amountTextField.clear();
        titleTextField.clear();
        getAccountsFromServer();
    }

    /**
     * Method to get accounts list from server and prepare data to be shown in checkboxes
     */
    private void getAccountsFromServer() {
        accountChoiceBox.getItems().clear();
        ServerConnection serverConnection = ServerConnection.getInstance();
        try {
            List<Account> accountsList;
            accountsList = serverConnection.getAccountService().getAccounts();
            ObservableList<AccountChoiceBoxModel> accountModels = FXCollections.observableArrayList();
            for (Account account : accountsList)
                accountModels.add(new AccountChoiceBoxModel(account.getAccountNumber(), "Name: " + account.getTitleOFAccount() + "\nNumber: " + account.getAccountNumber() + "\nBalance: " + (double) account.getBalance()/100 + " $"));
            accountChoiceBox.setItems(accountModels);
        } catch (SessionException_Exception | UserException_Exception e) {
            e.printStackTrace();
        }
    }
}
