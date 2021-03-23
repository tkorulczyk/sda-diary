package com.sda.diary.frontend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {
    private final Scanner scanner = new Scanner(System.in);

    int getAndValidateInt() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println(Colors.RED + ">>> Please enter a number using only the digits 1 to 3 <<<");
            }
        }
    }

    String getAndValidateString() {
        String warning = Colors.RED + ">>> Please type longer entry! <<<" + Colors.RESET;
        while (true) {
            String location = scanner.next();
            if (location.length() >= 5) {
                return location;
            } else {
                scanner.reset();
                scanner.nextLine();
                System.out.println(warning);
            }
        }
    }
}
