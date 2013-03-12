package org.agoncal.book.javaee7.chapter14;

import javax.jws.WebService;

@WebService
public interface Validator {

  public boolean validate(CreditCard creditCard);

}
