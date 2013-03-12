package org.agoncal.book.javaee7.chapter14;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@WebServlet(urlPatterns = "/servletEJBConsumerWithCDI")
public class ServletEJBConsumerWithCDI extends HttpServlet {

  @Inject
  private EJBConsumerWithCDI ejbConsumer;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter out = resp.getWriter();
    out.print("<h1>Servlet Consumer</h1><br/>");

    CreditCard creditCard = new CreditCard();
    creditCard.setNumber("12341234");
    creditCard.setExpiryDate("10/12");
    creditCard.setType("VISA");
    creditCard.setControlNumber(1234);

    out.print(ejbConsumer.validate(creditCard) + "<br/>");

    creditCard.setNumber("12341233");
    out.print(ejbConsumer.validate(creditCard) + "<br/>");
  }
}
