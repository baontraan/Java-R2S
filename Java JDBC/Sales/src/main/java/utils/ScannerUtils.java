package utils;

import exceptions.InvalidFields;

import java.util.Scanner;

public class ScannerUtils {

    // Methods

    public static String readNonEmpty(Scanner sc, String prompt) throws InvalidFields {
        System.out.print(prompt);

        String value = sc.nextLine().trim();

        if (!value.isEmpty()) return value;

        throw new InvalidFields("Value cannot be empty");
    }

    public static int readId(Scanner sc, String prompt) throws InvalidFields {
        System.out.print(prompt);
        String input = sc.nextLine().trim();

        if (!input.isEmpty()) return Integer.parseInt(input);

        throw new InvalidFields("Value cannot be empty");
        
    }
}
