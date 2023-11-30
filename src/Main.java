import java.util.Scanner;               // Import the Scanner class
import java.util.regex.Matcher;          // Import the Matcher class
import java.util.regex.Pattern;          // Import the Pattern class

public class Main {

    public static final int MINIMUM_ALLOWED_NUMBER = 13;     // Declare a constant for the minimum allowed number

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);            // Create a Scanner object to read user input

        System.out.println("Enter a valid sentence: ");
        String sentence = scanner.nextLine();               // Read the user's input and store it in the 'sentence'

        isValid(sentence);                                  // Call the isValid method to check the validity of the sentence
    }

    public static void isValid(String sentence) {       // Check various conditions to determine the validity of the sentence

        if (capital(sentence) && quotation(sentence) && endsWith(sentence) && period(sentence) && thirteen(sentence)) {
            System.out.println("Valid sentence");       // Print "Valid sentence" if all conditions are met
        } else {
            System.out.println("Invalid sentence");      // Print "Invalid sentence" if any condition is not met
        }
    }

    public static boolean capital(String sentence) {    // Check if the first letter of the sentence is uppercase
        return (Character.isUpperCase(sentence.charAt(0)));
    }

    public static boolean quotation(String sentence) {  // Check if quotes are even
        return (retrieveCount(sentence, '"') % 2) == 0;
    }

    public static boolean endsWith(String sentence) {   // Check what punctuation the sentence ends with
        return (sentence.endsWith(".") || sentence.endsWith("?") || sentence.endsWith("!"));
    }

    public static boolean period(String sentence) {     // Check if the sentence ends with a single period
        return sentence.charAt(sentence.length() - 1) == '.' && retrieveCount(sentence, '.') == 1;
    }

    public static boolean thirteen(String sentence) {   // Check if any numeric values in the sentence are greater than or equal to 13
        Pattern pattern = Pattern.compile("\\b\\d+\\b"); // Define a regex pattern to find all occurrences of numbers
        Matcher matcher = pattern.matcher(sentence);     // Create a Matcher object to find matches in the sentence

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group()); // Convert each matched number to an integer

            if (number < MINIMUM_ALLOWED_NUMBER) {
                return false;      // Return false if any number is less than the minimum allowed number
            }
        }

        return true;             // Return true if all numbers are greater than or equal to the minimum allowed number
    }

    public static int retrieveCount(String sentence, Character charToCount) { // Count the occurrences of a specified character
        int counter = 0;
        for (char c : sentence.toCharArray()) {
            if (c == charToCount) {
                counter++;
            }
        }
        return counter;
    }
}
