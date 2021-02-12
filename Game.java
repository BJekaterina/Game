package FinalProject;
import java.util.Scanner;
public class Game {

    //lives |||||| - maybe to change this to numerals, simply 6, then descending
    //draw hangman
    //to make the design more attractive

    public static void main(String[] args) {
        System.out.println(" -== Welcome to the GAME! ==- ");
        System.out.println("Test your vocabulary by guessing letters one at a time to solve the name of animal!");
        System.out.println("You will have 6 attempts to safe the Hangman's life.");
        System.out.println();

        String lettersNotUsed = "abcdefghijklmnopqrstuvwxyz";
        String[] words = new String[] {"mouse", "elephant", "koala", "rhino", "penguin", "camel", "puma", "tiger", "pig", "dog", "cat", "hedgehog", "sheep", "goat", "squirrel", "kangaroo", "horse", "monkey", "hippo", "panda", "zebra", "giraffe", "leopard", "wolf", "alligator", "bear", "raccoon"};
        String randomWord = words[(int) (Math.random() * words.length)];
        System.out.println("The word has " + randomWord.length() + " letters!");

        char[] letters = new char[randomWord.length()];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = '_';
        }

        int lives = 6;
        while (lives > 0) {
            System.out.print("Lives left: ");

            for (int i = 0; i < lives; i++) {
                System.out.print("|");
            }

            System.out.println();
            Scanner myScanner = new Scanner(System.in);
            System.out.println("Your guess: ");
            String input = myScanner.nextLine();

            char letter = input.charAt(0);
            boolean answerIsCorrect = false;
            for (int i = 0; i < randomWord.length(); i++) {
                char l = randomWord.charAt(i);
                if (l == letter) {
                    letters[i] = l;
                    answerIsCorrect = true;
                    System.out.println();
                    System.out.println("Right!");
                    System.out.println();
                }
            }

            if (!answerIsCorrect) {
                lives = lives - 1;
                System.out.println();
                System.out.println("Wrong letter. Try again!");
                System.out.println();
            }

            boolean gameFinished = true;
            System.out.print("Word: ");

            ///////for (int i = 0; i < letters.length; i++) {
            //                if (letters[i] == '_') {
            //                    gameFinished = false;
            //                }////
            ////// replaced as advised by IntelliJ Idea
            for (char c : letters) {
                if (c == '_') {
                    gameFinished = false;
                }
                System.out.print(c);
            }

            System.out.println();

            lettersNotUsed = lettersNotUsed.replace(letter, '_');
            System.out.println("Letters not used: " + lettersNotUsed);
            System.out.println("--------------------------------------------");

            if (gameFinished) {
                System.out.println("-==Congratulations! You saved the Hangman==- ");
                break;
            }
        }

        if (lives <=0 ) {
            System.out.println("Oooh no, Hangman is dead. The word was: " + randomWord);
        }
    }
}
