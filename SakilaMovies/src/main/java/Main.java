import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, RuntimeException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String username = "root";
        String password = "yearup2025";
        String url = "jdbc:mysql://localhost:3306/sakila";

        // Create and configure the DataSource
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);

        SakilaDataManager dataManager = new SakilaDataManager(dataSource);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the last name of the actor: ");
        String lastName = scanner.nextLine();

        List<Actor> actorMatch = dataManager.findActorsByLastName(lastName);

        if(actorMatch.isEmpty()) {
            System.out.println("No actors were found with that last name.");
            return;
        }

        System.out.println("Matching actors: ");
        for (Actor actor : actorMatch) {
            System.out.println(actor);
        }

        System.out.println("Enter the ID of the actor to see their films: ");

                    System.out.println("Displaying actors...");
                    String query = "SELECT last_name FROM actor;";
                    try (Connection connection = dataSource.getConnection()) {
                        Statement statement = connection.createStatement();
                        ResultSet results = statement.executeQuery(query);

                        while (results.next()) {
                            String actorLastName = results.getString("last_name");
                            System.out.printf("\nActor Last Name " + actorLastName + "\n-------------------");
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Invalid input, try again.");
            }
        }