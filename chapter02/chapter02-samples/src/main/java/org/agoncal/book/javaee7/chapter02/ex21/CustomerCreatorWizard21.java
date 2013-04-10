package org.agoncal.book.javaee7.chapter02.ex21;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@ConversationScoped
public class CustomerCreatorWizard21 implements Serializable {

  private Login login;
  private Account account;

  @Inject
  private CustomerService customerService;

  @Inject
  private Conversation conversation;

  public void saveLogin() {
    conversation.begin();

    login = new Login();
    // Set login properties
  }

  public void saveAccount() {
    account = new Account();
    // Set account properties
  }

  public void createCustomer() {
    Customer customer = new Customer();
    customer.setLogin(login);
    customer.setAccount(account);
    customerService.createCustomer(customer);

    conversation.end();
  }
}
