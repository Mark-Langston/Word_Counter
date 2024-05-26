// CSC 262 Programming in JAVA
// Mark Langston     5/25/2024
import java.util.Scanner;

public class Main {

    /**
     * Finds the position of the next blank character in a String.
     * If none exists, the length of the string is returned.
     *
     * @param str string containing characters to search
     * @param from character position where the search starts
     * @return character position of the next blank character
     */
    public static int nextSpacePosition(String str, int from) {
        for (int i = from; i < str.length(); i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                return i;
            }
        }
        return str.length();
    }

    /**
     * Finds the position of the next non-blank character in a String.
     * If none exists, the length of the string is returned.
     *
     * @param str string containing characters to search
     * @param from character position where the search starts
     * @return character position of the next non-blank character
     */
    public static int nextNonSpacePosition(String str, int from) {
        for (int i = from; i < str.length(); i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return i;
            }
        }
        return str.length();
    }

    /**
     * Count the number of words in a given string.
     * A word is a sequence of characters separated by any number of spaces.
     *
     * @param str string to count words in
     * @return number of words in str
     */
    public static int countWords(String str) {
        int count = 0;
        int i = 0;

        while (i < str.length()) {
            // Locates the start of the next word
            i = nextNonSpacePosition(str, i);
            if (i < str.length()) {
                count++;
                // Locates the end of the current word
                i = nextSpacePosition(str, i);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for three different strings
        for (int i = 1; i <= 3; i++) {
            System.out.println("Enter string " + i + ":");
            String userInput = scanner.nextLine();
            int wordCount = countWords(userInput);
            System.out.println("Number of words in string " + i + ": " + wordCount);
        }

        scanner.close();
    }
}