import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SakilaDataManager {

    private DataSource dataSource;

    public SakilaDataManager (DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Actor> findActorsByLastName(String lastName) throws SQLException {
        List<Actor> actors = new ArrayList<>();

        String sql = "SELECT actorId,  firstName,  lastName FROM actor WHERE last_name = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, lastName);

            ResultSet results = statement.executeQuery();

            while (results.next()) {
                int actorId = results.getInt("actor_id");
                String firstName = results.getString("first_name");
                String lName = results.getString("last_name");

                actors.add(new Actor(actorId, firstName, lName));
            }
        }
        return actors;
    }


    public List<Film> findFilms() throws SQLException{
        List<Film> films = new ArrayList();
        String sql = "SELECT filmId,  + title,  + description, + releaseYear, + length + FROM film";

        Connection conn = dataSource.getConnection();

        PreparedStatement statement = conn.prepareStatement(sql);

        ResultSet results = statement.executeQuery();

        while (results.next()){
            int filmId = results.getInt("film_id");
            String title = results.getString("title");
            String description = results.getString("description");
            int releaseYear = results.getInt("release_year");
            int length = results.getInt("length");

            Film film = new Film(filmId, title, description,releaseYear, length);
            films.add(film);
        }
        return films;
    }
}


