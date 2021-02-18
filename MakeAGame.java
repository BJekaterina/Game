package Updated;

import java.util.Scanner;

public class MakeAGame {

    public static void main(String[] args) {
        System.out.println(" -== Welcome to the GAME! ==- ");
        System.out.println("Test your vocabulary by guessing letters one at a time to solve the name of animal!");
        System.out.println("You will have 6 attempts to safe the Hangman's life.");
        System.out.println();

        String lettersNotUsed = "abcdefghijklmnopqrstuvwxyz"; //string representing all letters of the alphabet available for the guess
        String[] words = new String[] { "mouse", "elephant", "koala", "rhino", "turtle", "penguin", "camel", "puma",
                "tiger", "pig", "dog", "jaguar", "cat", "hedgehog", "sheep", "goat", "squirrel", "kangaroo", "horse",
                "monkey", "hippo", "panda", "zebra", "giraffe", "rabbit", "snake", "cow", "leopard", "wolf",
                "alligator", "bear", "lion", "raccoon" }; // choose from mystery word list
        String randomWord = words[(int) (Math.random() * words.length)]; // to show how many letters are in the mystery
        // word

        System.out.println("There are " + randomWord.length() + " letters in the word!");

        char[] letters = new char[randomWord.length()]; // this represents the mystery word with low dashes instead of letters
        for (int i = 0; i < letters.length; i++) {
            letters[i] = '_';
        }

        int lives = 6; //we set that a gamer will have 6 attempts to guess to word
        while (lives > 0) {
            System.out.print("Lives left: ");
            for (int i = 0; i < lives; i++) { //then use 'for' loop, to represent the number of attempts left
                System.out.print("|"); //each stick represents an attempt :D
            }

            System.out.println(); //then, we use a scanner to get the gamer's input (guess)
            Scanner myScanner = new Scanner(System.in);
            System.out.println("Your guess: ");
            String guess = myScanner.nextLine();

            char letter = guess.charAt(0);
            boolean guessIsCorrect = false;
            for (int i = 0; i < randomWord.length(); i++) {
                char l = randomWord.charAt(i);
                if (l == letter) {
                    letters[i] = l;
                    guessIsCorrect = true;
                    System.out.println();
                    System.out.println("Right!");
                    System.out.println();
                }
            }

            if (!guessIsCorrect) { //if guess is wrong, then the number of attempts decreases by 1
                lives = lives - 1; //as well as picture of hangman is beggining to appear
                System.out.println();
                System.out.println("Wrong letter. Try again!");
                System.out.println();
                drawHangman(lives);
            }

            boolean gameFinished = true; //if the gamer guessed the whole word, then game is finished and we can see the name of animal
            System.out.print("Word: ");

            /////// for (int i = 0; i < letters.length; i++) {
            // if (letters[i] == '_') {
            // gameFinished = false;
            // }////
            ////// replaced as advised by IntelliJ Idea
            for (char c : letters) {
                if (c == '_') {
                    gameFinished = false;
                }
                System.out.print(c);
            }

            System.out.println();

            lettersNotUsed = lettersNotUsed.replace(letter, '_'); // shows which letter is used
            System.out.println("Letters not used: " + lettersNotUsed);
            System.out.println("--------------------------------------------");
            System.out.println("-------------------------------------------");

            if (gameFinished) {
                System.out.println("-==Congratulations! You saved the Hangman==- ");
                System.out.println("     ☺         ☺         ☺         ☺       ");
                System.out.println("          ☺        ☺           ☺           ");
                break;
            }
        }

        if (lives <= 0) { //if number of lives is less then 0 , is means that the game is lost
            System.out.println("Oooh no, Hangman is dead. The word was: " + randomWord);
            System.out.println("     ☹        ☹          ☹         ☹       ");
            System.out.println("          ☹         ☹          ☹            ");
        }
    }

    public static void drawHangman(int l) {
        if (l == 6) {
            System.out.println("|----------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 5) {
            System.out.println("|----------");
            System.out.println("|    |");
            System.out.println("|    O ");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 4) {
            System.out.println("|----------");
            System.out.println("|    |");
            System.out.println("|    O");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 3) {
            System.out.println("|----------");
            System.out.println("|    |");
            System.out.println("|    O");
            System.out.println("|   -|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 2) {
            System.out.println("|----------");
            System.out.println("|    |");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 1) {
            System.out.println("|----------");
            System.out.println("|    |");
            System.out.println("|  (oo)");
            System.out.println("|   -|-");
            System.out.println("|   / ");
            System.out.println("|");
            System.out.println("|");
        } else {
            System.out.println("|----------");
            System.out.println("|    |");
            System.out.println("|  (XX)");
            System.out.println("|   -|-");
            System.out.println("|   // ");
            System.out.println("|");
            System.out.println("|");

        }
    }
}
