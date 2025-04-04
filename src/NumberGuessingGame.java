import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        while (true) {
            welcomeUser();
            int chances = difficulty();
            int random = makeRandomInt();
            while (true) {
                boolean over = trackOfChance(chances);
                if (over) {
                    System.out.println("You dont have any try!\nYou lose!");
                    break;
                }
                int guessedNumber = ask();
                boolean trueOrFalse = verifierHigherOrLower(guessedNumber, random, chances);
                if (trueOrFalse) {
                    break;
                } else {
                    chances--;
                    continue;
                }
            }
            boolean turn = askUser();
            if (turn) {
                System.out.println("Tanks for plying our game!\nHope you like it!");
                break;
            }else {
                System.out.println("We starting a new round!");
            }
        }



    }

    static void welcomeUser() {
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
    }

    static int difficulty() {
        Scanner ins = new Scanner(System.in);
        System.out.println("Please select the difficulty level:");
        System.out.println("1. Easy (10 chances)");
        System.out.println("2. Medium (5 chances)");
        System.out.println("3. Hard (3 chances)");
        System.out.println();
        int choice;
        while (true) {
            System.out.println("Enter your choice: ");
            choice = ins.nextInt();
            if ((choice == 1 || choice == 2 || choice == 3)) {
                break;
            } else {
                System.out.println("please enter a number of your choice (1, 2, 3): ");
            }
        }
        if (choice == 1) {
            System.out.println("\n" + "Great! You have selected the Easy difficulty level.\nyou have 10 try to guess the number.");
            System.out.println("Let's start the game!\n");
            return 10;
        } else if (choice == 2) {
            System.out.println("\n" + "Great! You have selected the Medium difficulty level.\nyou have 5 try to guess the number");
            System.out.println("Let's start the game!\n");
            return 5;
        } else {
            System.out.println("\n" + "Great! You have selected the Hard difficulty level.\nyou have 3 try to guess the number");
            System.out.println("Let's start the game!\n");
            return 3;
        }
    }

    static int makeRandomInt() {
        Random number = new Random();
        return number.nextInt(100) + 1;
    }

    static boolean verifierHigherOrLower(int guess, int exactNumber, int attempts) {
        if (guess == exactNumber) {
            System.out.println("Congratulations! You guessed the correct number in " + attempts +" attempts.");
            return true;
        }else if (guess > exactNumber) {
            System.out.println("Incorrect! The number is less than " + guess + " .\nYou have " + attempts + "left.\n");
            return false;
        }else {
            System.out.println("Incorrect! The number is greater than " + guess + " .\nYou have " + attempts + "left.\n");
            return false;
        }
    }

    static boolean trackOfChance(int chance) {
        return chance == 0;
    }

    static boolean askUser() {
        Scanner ask = new Scanner(System.in);
        System.out.println("Do you want to try again (yes or no)?");
        while (true) {
            String input = ask.nextLine();
            if (Objects.equals(input.toLowerCase(), "yes")) {
                return false;
            }else if (Objects.equals(input.toLowerCase(), "no")){
                return true;
            }else {
                System.out.println("please enter a coin of your choice (yes or no): ");
            }
        }
    }

    static int ask(){
        Scanner ask = new Scanner(System.in);
        System.out.println("Enter your guess: ");
        while (true) {
            int decision = ask.nextInt();
            if (decision >= 0 && decision <= 100) {
                return decision;
            } else {
                System.out.println("Please enter the number in the range of 0 to 100");
            }
        }
    }
}
