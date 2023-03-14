package medved.main.controller;

import medved.main.service.PersonService;
import medved.main.service.PersonServiceImpl;

import java.util.Scanner;

public class PersonController {

    private static final Scanner scanner = new Scanner(System.in);
    private final PersonService personService = new PersonServiceImpl();

    public void startMenu() {
        System.out.print("""
                Добро пожаловать в наш кинетеатр!
                1 - Зарегистрироваться.
                2 - Войти.
                0 - Выход.
                """);
//        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                personService.create();
                break;
            case "2":
                System.out.println("2");
                break;
            case "0":
                System.out.println("Выход из программы.");
                break;
            default:
                System.out.println("Вы ввели Некорректные данные!");
                startMenu();
        }

    }
}
