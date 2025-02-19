import java.io.File; // For reading the word list from a file
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) throws FileNotFoundException {
        // Scanner to read words from a file
        Scanner scanner = new Scanner(new File("C:/Users/User/OneDrive/Documents/words_alpha.txt"));
        Scanner keyboard = new Scanner(System.in); // Scanner for user input

        List<String> words = new ArrayList<>(); // List to store words from the file

        // Reading words from the file and storing them in the list
        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }

        Random random = new Random(); // Random object to pick a word
        String word = words.get(random.nextInt(words.size())); // Select a random word from the list

        List<Character> playerGuesses = new ArrayList<>(); // List to store player's guessed letters
        int wrongCount = 0; // Counter for incorrect guesses

        while (true) {
            PrintHangedMan(wrongCount); // Print hangman figure based on incorrect guesses

            // Check if the player has lost
            if (wrongCount >= 6) {
                System.out.println("You lose!!!");
                System.out.println("The word is: "+ word);
                break;
            }

            PrintWord(word, playerGuesses); // Display the word with guessed letters

            // Get the player's guess and check if it's correct
            if (!getPlayerGuess(keyboard, playerGuesses, word)) {
                wrongCount++; // Increment wrong count if guess is incorrect
            }

            // Check if the player has guessed the full word
            if (PrintWord(word, playerGuesses)) {
                System.out.println("You win!!!");
                break;
            }

            System.out.println("Guess the word:");

            // Allow the player to guess the full word
            if (keyboard.nextLine().equals(word)) {
                System.out.println("You win!!!");
                break;
            } else {
                System.out.println("Try again!!!");
            }
        }
    }

    // Method to print the hangman figure based on incorrect guesses
    private static void PrintHangedMan(int wrongCount) {
        System.out.println(" _______");
        System.out.println(" |      |");

        if (wrongCount >= 1) {
            System.out.println(" O"); // Head
        }

        if (wrongCount >= 2) {
            System.out.print("\\ "); // Left arm
            if (wrongCount >= 3) {
                System.out.println("/"); // Right arm
            } else {
                System.out.println("");
            }
        }

        if (wrongCount >= 4) {
            System.out.println(" |"); // Body
        }

        if (wrongCount >= 5) {
            System.out.print("/ "); // Left leg
            if (wrongCount >= 6) {
                System.out.println("\\"); // Right leg
            } else {
                System.out.println("");
            }
        }
    }

    // Method to get player's guessed letter
    private static boolean getPlayerGuess(Scanner keyboard, List<Character> playerGuesses, String word) {
        System.out.println("Please guess a letter: ");
        String guess = keyboard.nextLine(); // Read the guessed letter
        playerGuesses.add(guess.charAt(0)); // Store the guessed letter

        return word.contains(guess); // Return true if the letter is in the word
    }

    // Method to print the word with guessed letters
    private static boolean PrintWord(String word, List<Character> playerGuesses) {
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i)); // Print correctly guessed letter
                correctCount++;
            } else {
                System.out.print("-"); // Print dash for unguessed letters
            }
        }
        System.out.println();
        return (word.length() == correctCount); // Return true if all letters are guessed
    }
}
