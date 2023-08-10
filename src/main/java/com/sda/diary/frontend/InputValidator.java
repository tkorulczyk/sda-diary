package com.sda.diary.frontend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {
  private final Scanner scanner = new Scanner(System.in);

  int getAndValidateInt() {
    while (true) {
      try {
        int number = scanner.nextInt();
        scanner.nextLine();  // Dodanie tej linii, aby pozbyć się znaku końca linii

        if (number >= 1 && number <= 3) {
          return number;
        } else {
          System.out.println(Colors.RED + ">>> Please enter a number using only the digits 1 to 3 <<<");
        }
      } catch (InputMismatchException e) {
        scanner.nextLine(); // Czyszczenie bufora
        System.out.println(Colors.RED + ">>> Please enter a valid number <<<");
      }
    }
  }

  String getAndValidateString() {
    String warning = Colors.RED + ">>> Please type longer entry! <<<" + Colors.RESET;
    while (true) {
      String entry = scanner.nextLine();
      if (entry.length() >= 5) {
        return entry;
      } else {
        scanner.reset();
        scanner.nextLine();
        System.out.println(warning);
      }
    }
  }
}
