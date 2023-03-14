package medved.main.repository;

import medved.main.model.Person;
import medved.main.util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryImpl implements PersonRepository{

    @Override
    public boolean create(Person person) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement =
                    connection.prepareStatement("INSERT INTO person (access, username, password, " +
                            "lastAndFirstName, email, dateBirthday, dateCreated) VALUES (?,?,?,?,?,?,?)");
            statement.setString(1, person.getAccess());
            statement.setString(2, person.getUsername());
            statement.setString(3, person.getPassword());
            statement.setString(4, person.getLastAndFirstName());
            statement.setString(5, person.getEmail());
            statement.setString(6, person.getDateBirthday());
            statement.setString(7, person.getDateCreated());
            statement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Person getById(Long id) {
        return null;
    }

    @Override
    public Person getByUsername(String username) {
        try (Connection connection = ConnectionManager.open()) {
            Person person = new Person();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM person WHERE username=?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                person.setId(id);
                person.setUsername(username);
                person.setPassword(password);
                person.setEmail(email);
            }
            return person;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM person");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                Person person = new Person();
                person.setId(id);
                person.setUsername(username);
                person.setPassword(password);
                person.setEmail(email);
                persons.add(person);
            }
            return persons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Person update(Person person, Long id) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM person WHERE id=?");
            statement.setLong(1, id);
            return statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
