package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Sep 4, 2017 
 */
public class Connector {
    private final static String driver = "com.mysql.jdbc.Driver";
    private final static String url = "jdbc:mysql://46.101.152.26:3306/opskrift";
    private final static String user = "opskriftuser";
    private final static String password = "opskriftmysql";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}
