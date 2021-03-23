package com.sda.diary.frontend;

import com.sda.diary.backend.EntryController;
import lombok.Data;

@Data
public class UserInterface {
    private final EntryController entryController;
    private final InputValidator inputValidator;

    public void runApp() {
        String INVITATION = "Welcome to the electronic diary, what do you want to do? \n" +
                Colors.BLUE + "1. Add a new diary entry \n" +
                Colors.BLUE + "2. Read existing entries \n" +
                Colors.RED + "3. Close the application" + Colors.RESET;
        String LINE_SEPARATOR ="\n" + Colors.RESET + generateSeparationLine(56);

        while (true) {
            System.out.println(LINE_SEPARATOR);
            System.out.println(INVITATION);
            int input = inputValidator.getAndValidateInt();

            switch (input) {
                case 1:
                    addNewEntry();
                    break;
                case 2:
                    readAllEntries();
                    break;
                case 3:
                    System.out.println("\nThank you for your time,\n" + "Good bye!");
                    return;
                default:
                    System.out.println(Colors.RED + "Please enter a number using only the digits 1 to 3");
            }
        }
    }

    void addNewEntry() {
        System.out.println(Colors.RESET + "Enter a title for the new entry:");
        String title = inputValidator.getAndValidateString();
        System.out.println("Specify the content of the new entry:");
        String content = inputValidator.getAndValidateString();
        String response = entryController.createNewEntry(title, content);
        System.out.println("Complete... entry saved!\n");
        System.out.println("New entry has been added:" + response);
    }

    void readAllEntries() {
        String response = entryController.readAllEntries();
        System.out.println("Retrieving entries... please wait!\n");
        System.out.println("Retrieved Entries:" + response);
    }


    String generateSeparationLine(int charactersNumber) {
        return "=".repeat(Math.max(0, charactersNumber-1 + 1));
    }

}

