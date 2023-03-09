package medved.main.repository;

import medved.main.model.Person;
import java.util.List;

public interface PersonRepository {

    boolean create(Person person);

    Person getPerson(Integer id);

    List<Person> getAllPersons();

    Person update(Person person, Integer id);
}
