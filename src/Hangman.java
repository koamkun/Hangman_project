import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:/Users/User/OneDrive/Documents/words_alpha.txt"));
        Scanner keyboard = new Scanner(System.in);

        List<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }

        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));

        List<Character> playerGuesses = new ArrayList<>();
        int wrongCount = 0;

        while (true) {
            PrintHangedMan(wrongCount);

            if (wrongCount >= 6) {
                System.out.println("You lose!!!");
                System.out.println("The word is: "+ word);
                break;
            }

            PrintWord(word, playerGuesses);

            if (!getPlayerGuess(keyboard, playerGuesses, word)) {
                wrongCount++;
            }

            if (PrintWord(word, playerGuesses)) {
                System.out.println("You win!!!");
                break;
            }

            System.out.println("Guess the word:");

            if (keyboard.nextLine().equals(word)) {
                System.out.println("You win!!!");
                break;
            } else {
                System.out.println("Try again!!!");
            }
        }
    }

    private static void PrintHangedMan(int wrongCount) {
        System.out.println(" _______");
        System.out.println(" |      |");

        if (wrongCount >= 1) {
            System.out.println(" O");
        }

        if (wrongCount >= 2) {
            System.out.print("\\ ");
            if (wrongCount >= 3) {
                System.out.println("/");
            } else {
                System.out.println("");
            }
        }

        if (wrongCount >= 4) {
            System.out.println(" |");
        }

        if (wrongCount >= 5) {
            System.out.print("/ ");
            if (wrongCount >= 6) {
                System.out.println("\\");
            } else {
                System.out.println("");
            }
        }
    }

    private static boolean getPlayerGuess(Scanner keyboard, List<Character> playerGuesses, String word) {
        System.out.println("Please guess a letter: ");
        String guess = keyboard.nextLine();
        playerGuesses.add(guess.charAt(0));

        return word.contains(guess);
    }

    private static boolean PrintWord(String word, List<Character> playerGuesses) {
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctCount++;
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
        return (word.length() == correctCount);
    }
}