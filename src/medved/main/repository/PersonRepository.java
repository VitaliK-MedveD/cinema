package medved.main.repository;

import medved.main.model.Person;
import java.util.List;

public interface PersonRepository {

    boolean create(Person person);

    Person getById(Long id);

    Person getByUsername(String username);

    List<Person> getAllPersons();

    Person update(Person person, Long id);

    boolean deleteById(Long id);
}
