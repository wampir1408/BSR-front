
package bsr.server.innerservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "UserService", targetNamespace = "http://innerServices.server.bsr/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UserService {


    /**
     * 
     * @return
     *     returns bsr.server.innerservices.User
     * @throws UserException_Exception
     * @throws SessionException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUser", targetNamespace = "http://innerServices.server.bsr/", className = "bsr.server.innerservices.GetUser")
    @ResponseWrapper(localName = "getUserResponse", targetNamespace = "http://innerServices.server.bsr/", className = "bsr.server.innerservices.GetUserResponse")
    @Action(input = "http://innerServices.server.bsr/UserService/getUserRequest", output = "http://innerServices.server.bsr/UserService/getUserResponse", fault = {
        @FaultAction(className = SessionException_Exception.class, value = "http://innerServices.server.bsr/UserService/getUser/Fault/SessionException"),
        @FaultAction(className = UserException_Exception.class, value = "http://innerServices.server.bsr/UserService/getUser/Fault/UserException")
    })
    public User getUser()
        throws SessionException_Exception, UserException_Exception
    ;

    /**
     * 
     * @param password
     * @param clientNumber
     * @return
     *     returns int
     * @throws ServerException_Exception
     * @throws NotValidException_Exception
     * @throws AuthException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://innerServices.server.bsr/", className = "bsr.server.innerservices.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://innerServices.server.bsr/", className = "bsr.server.innerservices.LoginResponse")
    @Action(input = "http://innerServices.server.bsr/UserService/loginRequest", output = "http://innerServices.server.bsr/UserService/loginResponse", fault = {
        @FaultAction(className = AuthException_Exception.class, value = "http://innerServices.server.bsr/UserService/login/Fault/AuthException"),
        @FaultAction(className = NotValidException_Exception.class, value = "http://innerServices.server.bsr/UserService/login/Fault/NotValidException"),
        @FaultAction(className = ServerException_Exception.class, value = "http://innerServices.server.bsr/UserService/login/Fault/ServerException")
    })
    public int login(
        @WebParam(name = "clientNumber", targetNamespace = "")
        String clientNumber,
        @WebParam(name = "password", targetNamespace = "")
        String password)
        throws AuthException_Exception, NotValidException_Exception, ServerException_Exception
    ;

}