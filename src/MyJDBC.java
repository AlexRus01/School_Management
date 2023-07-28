import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;

public class MyJDBC {
    public static void main(String[] args){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alexbaza", "root", "Hailaspoon123!");

            Statement statement = connection.createStatement();

//            ResultSet resultSet = statement.executeQuery("select * from subject");
//
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("name"));
//            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
