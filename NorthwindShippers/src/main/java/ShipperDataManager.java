import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShipperDataManager {

    private final DataSource dataSource;

    public ShipperDataManager (DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Shipper> findShipperByName() throws SQLException{
        List<Shipper> shippers = new ArrayList<>();

        String sql = "SELECT CompanyName, Phone FROM shippers WHERE CompanyName = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, shipperName);
            statement.setString(2, shipperPhone);

            ResultSet results = statement.executeQuery();

            while (results.next()) {
                int actorId = results.getInt("shipperName");
                String firstName = results.getString("shipperPhone");

                shippers.add(new Shipper(shipperName, shipperPhone));
            }
        }
        return shippers;
    }
}
