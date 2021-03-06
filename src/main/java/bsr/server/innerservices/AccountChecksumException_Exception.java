
package bsr.server.innerservices;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "AccountChecksumException", targetNamespace = "http://innerServices.server.bsr/")
public class AccountChecksumException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private AccountChecksumException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public AccountChecksumException_Exception(String message, AccountChecksumException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public AccountChecksumException_Exception(String message, AccountChecksumException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: bsr.server.innerservices.AccountChecksumException
     */
    public AccountChecksumException getFaultInfo() {
        return faultInfo;
    }

}
