import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class InternSimplByteTask2 {
    private static String[] words = {"apple", "banana", "orange", "mango", "grape"};
    private static String selectedWord;
    private static char[] currentGuess;
    private static int attemptsLeft = 6;

    public static void main(String[] args) {
        selectRandomWord();
        initializeCurrentGuess();

        System.out.println("Welcome to the Word Guessing Game!");
        System.out.println("Guess the letters to complete the word.");
        System.out.println("You have " + attemptsLeft + " attempts.");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nCurrent Guess: " + Arrays.toString(currentGuess));
            System.out.print("Enter a letter: ");
            String input = scanner.nextLine();
            if (input.length() != 1) {
                System.out.println("Please enter a single letter.");
                continue;
            }
            char guessedLetter = input.charAt(0);

            if (checkLetter(guessedLetter)) {
                System.out.println("Correct guess!");
                if (isWordGuessed()) {
                    System.out.println("Congratulations! You guessed the word correctly: " + selectedWord);
                    break;
                }
            } else {
                attemptsLeft--;
                System.out.println("Incorrect guess! Attempts left: " + attemptsLeft);
                if (attemptsLeft == 0) {
                    System.out.println("Game over! You ran out of attempts. The word was: " + selectedWord);
                    break;
                }
            }
        }
        scanner.close();
    }

    private static void selectRandomWord() {
        Random random = new Random();
        int index = random.nextInt(words.length);
        selectedWord = words[index];
    }

    private static void initializeCurrentGuess() {
        currentGuess = new char[selectedWord.length()];
        Arrays.fill(currentGuess, '_');
    }

    private static boolean checkLetter(char letter) {
        boolean isCorrectGuess = false;
        for (int i = 0; i < selectedWord.length(); i++) {
            if (selectedWord.charAt(i) == letter) {
                currentGuess[i] = letter;
                isCorrectGuess = true;
            }
        }
        return isCorrectGuess;
    }

    private static boolean isWordGuessed() {
        for (char letter : currentGuess) {
            if (letter == '_') {
                return false;
            }
        }
        return true;
    }
}
