package org.agoncal.book.javaee7.chapter21.ex06;

import javax.jws.WebService;

@WebService
public interface Validator06 {

  public boolean validate(CreditCard06 creditCard);

}
