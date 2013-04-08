package org.agoncal.book.javaee7.chapter02.ex19;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class JDBCConnectionProducer {

  @Produces
  private Connection createConnection() {
    Connection conn = null;
    try {
      Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
      conn = DriverManager.getConnection("jdbc:derby://localhost:1527/chapter02DB;create=true", "APP", "APP");

    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
    return conn;
  }

  public void closeConnection(@Disposes Connection conn) throws SQLException {
    conn.close();
  }
}
