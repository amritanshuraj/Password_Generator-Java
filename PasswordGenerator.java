import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String[] args) {
        int passwordLength = getUserInput();
        String generatedPassword = generatePassword(passwordLength);

        System.out.println("Generated Password: " + generatedPassword);
    }

    private static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int length;

        do {
            try {
                System.out.print("Enter the length of the password: ");
                length = scanner.nextInt();

                if (length <= 0) {
                    System.out.println("Please enter a valid password length.");
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for password length.");
                scanner.next();
                length = 0;
            }

        } while (length <= 0);

        return length;
    }

    private static String generatePassword(int length) {
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String numberChars = "0123456789";
        String specialChars = "!@#$%^&*()-_+=<>?";

        String characters = uppercaseChars + lowercaseChars + numberChars + specialChars;

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }
}
