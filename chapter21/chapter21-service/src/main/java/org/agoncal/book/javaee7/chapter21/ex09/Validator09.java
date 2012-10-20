package org.agoncal.book.javaee7.chapter21.ex09;

import javax.jws.WebService;

@WebService(portName = "CreditCardValidator09", serviceName = "ValidatorService09")
public interface Validator09 {

  public boolean validate(CreditCard09 creditCard);

}
