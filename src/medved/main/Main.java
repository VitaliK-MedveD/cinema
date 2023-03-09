package medved.main;


import medved.main.controller.PersonController;

public class Main {
    public static void main(String[] args) {

        PersonController personController = new PersonController();
        personController.startMenu();

    }
}
