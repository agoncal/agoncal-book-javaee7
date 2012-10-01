package org.agoncal.book.javaee7.chapter21.ex16;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@WebService(name = "CardValidator16", portName = "ValidatorPort")
public class CardValidator16 implements CCValidator16 {

    // ======================================
    // =            Constructors            =
    // ======================================
    @Resource
    private WebServiceContext context;

    // ======================================
    // =           Public Methods           =
    // ======================================

    @WebMethod(operationName = "ValidateCreditCard")
    @WebResult(name = "IsValid")
    public boolean validate(@WebParam(name = "CreditCard") CreditCard16 creditCard) {

        Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

        if (Integer.parseInt(lastDigit.toString()) % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }

    @WebMethod(exclude = true)
    public void validate(String ccNumber) {

    }
}