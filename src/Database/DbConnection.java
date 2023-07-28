package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class DbConnection {
    private static Connection con = null;

    static
    {
        String url = "jdbc:mysql://localhost:3306/alexbaza";
        String user = "root";
        String pass = "Hailaspoon123!";

        try{
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return con;
    }
}
