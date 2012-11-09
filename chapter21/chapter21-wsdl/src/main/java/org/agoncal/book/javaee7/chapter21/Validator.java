package org.agoncal.book.javaee7.chapter21;

import javax.jws.WebService;

@WebService
public interface Validator {

  public boolean validate(CreditCard creditCard);

}
