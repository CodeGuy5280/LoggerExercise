import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String username = "root";
        String password = "yearup2025";
        String url = "jdbc:mysql://localhost:3306/northwind";
        String query = "SELECT productname FROM products;";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String productName = results.getString("productname");
                System.out.println(productName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
