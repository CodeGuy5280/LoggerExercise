import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String username = "root";
        String password = "yearup2025";
        String url = "jdbc:mysql://localhost:3306/northwind";

        // Create and configure the DataSource
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);

        Scanner scanner = new Scanner(System.in);

        boolean start = true;
        System.out.println("What is the last name of an actor you like?");
        while (start) {
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Displaying all actors...");
                    String query = "SELECT last_name FROM actors;";
                    try (Connection connection = dataSource.getConnection()) {
                        Statement statement = connection.createStatement();
                        ResultSet results = statement.executeQuery(query);

                        while (results.next()) {
                            String actorLastName = results.getString("lastname");
                            System.out.printf("\nActor " + actorLastName + "\n-------------------");
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
        }
    }
}