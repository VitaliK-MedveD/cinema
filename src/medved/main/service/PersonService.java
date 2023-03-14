package medved.main.service;

import medved.main.model.Person;

import java.util.List;

/**
 * Сервис для работы с пользователем.
 */
public interface PersonService {

    /**
     * Сохранение пользователя в базу данных.
     */
    boolean create();

    /**
     * Получение пользователя по логину.
     */
    Person getByUsername(String username);

    /**
     * Получение пользователя по ID.
     */
    Person getById(Long id);

    /**
     * Получение всех пользователей.
     */
    List<Person> getAllPesons();

    /**
     * Обновление пользователя по ID.
     */
    boolean updatePersonById(Long id, Person person);

    /**
     * Удаление пользователя по ID из базы данных.
     */
    boolean deleteById(Long id);


}
