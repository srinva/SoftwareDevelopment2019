package main.java.app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {

    public static void getDBString() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\Srinath\\com.srinath.coding\\SoftwareDevelopment2019\\SoftwareDev.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            Statement statement = conn.createStatement();

            System.out.println("Connection to SQLite has been established.");

            ResultSet rs = statement.executeQuery("select * from users");
            while(rs.next())
            {
                // read the result set
                System.out.println("username = " + rs.getString("username"));
                System.out.println("password = " + rs.getString("password"));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
