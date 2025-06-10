import java.sql.Connection;
import java.sql.DriverManager;
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

        Scanner scanner = new Scanner(System.in);

        boolean start = true;
        System.out.println("What do you want to do?");
        System.out.println("1) Display all products");
        System.out.println("2) Display all customers");
        System.out.println("3) Display all categories");
        System.out.println("0) Exit");

        while (start) {
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Displaying all products...");
                    String query = "SELECT productname, productid, unitprice, unitsinstock FROM products;";
                    try (Connection connection = DriverManager.getConnection(url, username, password)) {
                            Statement statement = connection.createStatement();
                            ResultSet results = statement.executeQuery(query);

                            while (results.next()) {
                                String productName = results.getString("productname");
                                int productId = results.getInt("productid");
                                double unitPrice = results.getDouble("unitprice");
                                int unitsInStock = results.getInt("unitsinstock");
                                System.out.printf("\nProduct ID " + productId + " \n Product Name: " + productName + "\n Unit Price: $" + unitPrice + "\n Units In Stock: " + unitsInStock + "\n-------------------");
                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                    }
                    break;
                case "2":
                    System.out.println("Displaying all customers...");
                    String query2 = "SELECT ContactName, CompanyName, City, Country, Phone FROM customers ORDER BY Country;";

                    try (Connection connection = DriverManager.getConnection(url, username, password)) {
                        Statement statement = connection.createStatement();
                        ResultSet results = statement.executeQuery(query2);

                        while (results.next()) {
                            String contactName = results.getString("ContactName");
                            String companyName = results.getString("CompanyName");
                            String city = results.getString("City");
                            String country = results.getString("Country");
                            String phoneNumber = results.getString("Phone");
                            System.out.printf("\nContact Name " + contactName + " \n Company Name: " + companyName + "\n City: " + city + "\n Country: " + country + "" + "\n Phone " + phoneNumber + "\n-------------------");
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "3":
                    System.out.println("3) Displaying all categories...");


                    break;
                case "0":
                    System.out.println("0) Exiting...");
                    start = false;
                    break;
                default:
                    System.out.println("Choose a valid input.");
            }
        }
        scanner.close();
    }
}
