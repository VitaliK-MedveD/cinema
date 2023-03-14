package medved.main;

import medved.main.controller.PersonController;
import medved.main.model.Person;
import medved.main.service.PersonService;
import medved.main.service.PersonServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        PersonController personController = new PersonController();
//        personController.startMenu();
        PersonService personService = new PersonServiceImpl();
        List<Person> persons = personService.getAllPesons();
        persons.forEach(System.out::println);
        personService.deleteById(4l);
        persons = personService.getAllPesons();
        persons.forEach(System.out::println);
    }
}
