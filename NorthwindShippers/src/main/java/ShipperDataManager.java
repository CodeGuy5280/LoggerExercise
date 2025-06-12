import java.sql.*;

public class ShipperDataManager {

    private final String url = "jdbc:mysql://localhost:3306/northwind";
    private final String user = "root";
    private final String password = "yearup2025";

    public int insertShipper(Shipper shipper) {
        String sql = "INSERT INTO Shippers (CompanyName, Phone) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, shipper.getShipperName());
            stmt.setString(2, shipper.getShipperPhone());

            int shipperRows = stmt.executeUpdate();

            if (shipperRows == 0) {
                throw new SQLException("Inserting shipper failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Inserting shipper failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
