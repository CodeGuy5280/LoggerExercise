import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String username = "root";
        String password = "yearup2025";
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sakila",
                username,
                password);

        String query = "SELECT * FROM actor";

        Statement statement = connection.createStatement();

        ResultSet results = statement.executeQuery(query);

        while (results.next()) {
            String firstName = results.getString("first_name");
            System.out.println(firstName);
        }

        connection.close();
    }
}
