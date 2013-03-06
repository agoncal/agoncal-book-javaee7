package org.agoncal.book.javaee7.chapter09;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Antonio Goncalves
 *         APress Book07 - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
public class ItemEJB {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Resource(lookup="java:comp/DefaultDataSource")
//    @Resource(lookup="jdbc/__default")
    DataSource myDS;


    // ======================================
    // =           Public Methods           =
    // ======================================

    public void findBooks() throws SQLException {
        Connection conn = myDS.getConnection();
        Statement st = conn.createStatement();
        st.execute("select * from book01");
        conn.close();
    }
}