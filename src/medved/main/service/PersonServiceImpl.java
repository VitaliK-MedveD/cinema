package medved.main.service;

import medved.main.model.Access;
import medved.main.model.Person;
import medved.main.model.Regex;
import medved.main.repository.PersonRepository;
import medved.main.repository.PersonRepositoryImpl;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonServiceImpl implements PersonService{

    private static final String MESSAGE_LOGIN = "логин";
    private static final String MESSAGE_PASSWORD = "пароль";
    private static final String MESSAGE_LAST_FIRST_NAME = "фамилию и имя";
    private static final String MESSAGE_EMAIL = "email адрес";
    private static final String MESSAGE_D_BIRTHDAY = "дату рождения в формате ГГГГ-ММ-ДД";
    private static final String REGEX_LOGIN = "^[A-Za-z]\\w{3,29}$";
    private final PersonRepository personRepository = new PersonRepositoryImpl();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public boolean create() {
        Person person = new Person();
        String username = keybordInput(MESSAGE_LOGIN, Regex.REGEX_LOGIN.getRegex());
        String password = keybordInput(MESSAGE_PASSWORD, Regex.REGEX_PASWORD.getRegex());
        String lastAndFirstName = keybordInput(MESSAGE_LAST_FIRST_NAME);
        String email = keybordInput(MESSAGE_EMAIL, Regex.REGEX_EMAIL.getRegex());
        String dateBirthday = keybordInput(MESSAGE_D_BIRTHDAY);
        person.setAccess(Access.user.toString());
        person.setUsername(username);
        person.setPassword(password);
        person.setLastAndFirstName(lastAndFirstName);
        person.setEmail(email);
        person.setDateBirthday(dateBirthday);
        return personRepository.create(person);
    }

    @Override
    public Person getByUsername(String username) {
        return personRepository.getByUsername(username);
    }

    @Override
    public Person getById(Long id) {
        return null;
    }

    @Override
    public List<Person> getAllPesons() {
        return personRepository.getAllPersons();
    }

    @Override
    public boolean updatePersonById(Long id, Person person) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return personRepository.deleteById(id);
    }


    private String keybordInput(String message, String regex) {
        String line;
        boolean isCheck;
        do {
            isCheck = false;
//            Scanner scanner = new Scanner(System.in);
            System.out.printf("Введите %s: ", message);
            line = scanner.nextLine();
            if (checkLine(line, regex)) {
            } else {
                isCheck = true;
            }
        } while (isCheck);
        return line;
    }

    private String keybordInput(String message) {
//        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите %s: ", message);
        String line = scanner.nextLine();
        return line;
    }

    private boolean checkLine(String line, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }
}
