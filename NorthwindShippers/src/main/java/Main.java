import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShipperDataManager dataManager = new ShipperDataManager();

        System.out.println("Enter new Shipper name:");
        String name = scanner.nextLine();

        System.out.println("Enter phone number:");
        String phone = scanner.nextLine();

        Shipper shipper = new Shipper(name, phone);
        int newId = dataManager.insertShipper(shipper);

        if (newId != -1) {
            System.out.println("New Shipper added with ID: " + newId);
        } else {
            System.out.println("Failed to insert new shipper.");
        }

        scanner.close();
    }
}
