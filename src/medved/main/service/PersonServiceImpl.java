package medved.main.service;

import medved.main.model.Person;
import medved.main.repository.PersonRepository;
import medved.main.repository.PersonRepositoryImpl;

import java.util.Scanner;

public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository = new PersonRepositoryImpl();

    @Override
    public boolean create() {
        Person person = new Person();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String username = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        person.setUsername(username);
        person.setPassword(password);
        System.out.println(personRepository.create(person));
        return personRepository.create(person);
    }
}
