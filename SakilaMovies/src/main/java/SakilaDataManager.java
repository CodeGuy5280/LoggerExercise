import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SakilaDataManager {

    private DataSource dataSource;

    public SakilaDataManager (DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Actor> getAllActors() throws SQLException {
        List<Actor> actors = new ArrayList<>();

        String sql = "SELECT actorId " + "firstName " + "lastName" + "FROM actor";

        Connection conn = dataSource.getConnection();

        PreparedStatement statement = conn.prepareStatement(sql);

        ResultSet results = statement.executeQuery(sql);

        while (results.next()){
            int actorId = results.getInt("actor_id");
            String firstName = results.getString("first_name");
            String lastName = results.getString("last_name");

            Actor actor = new Actor(actorId, firstName, lastName);
            actor.add(actor);
        }
        return actors;
    }


}
