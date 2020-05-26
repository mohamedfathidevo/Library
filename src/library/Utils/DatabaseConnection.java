/*
 * this fuction to connect application to database
 */
package library.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mohamedfathidevo
 */
public class DatabaseConnection {

    private static final String url = "jdbc:mysql://localhost:3306/event_driven";
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "";
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver not found.");
        }
        return con;
    }

}
