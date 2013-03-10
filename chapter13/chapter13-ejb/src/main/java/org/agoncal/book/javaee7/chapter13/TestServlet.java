package org.agoncal.book.javaee7.chapter13;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      out.println("<html>");
      out.println("<head>");
      out.println("<title>JMS Servlet</title>");
      out.println("</head>");
      out.println("<body>");

    } catch (Exception e) {
      e.printStackTrace(out);
    } finally {
      out.println("</body>");
      out.println("</html>");
      out.close();
    }
  }

}
