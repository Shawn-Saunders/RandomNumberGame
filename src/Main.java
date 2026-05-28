// Author: Shawn Saunders
// Date: 5/28/2026
// Description:
// Make a number guessing game, that generates a random number opens in new window
// between 1 and some other value and prints the result. The upper range of the die
// roll might be part of your program (i.e. a constant), or maybe it could be entered by the user.

import java.util.Scanner;

public class Main {
  /**
   * main method, runs a random number game
   * @author Shawn Saunders
   * @param args Unused
   */
  public static void main(String[] args) {

    // declare constants
    // Because I am evil you don't get 7 (you may cheat and make it easier by increasing this number ;) )
    final int NUMBER_OF_ATTEMPTS = 5;
    final int MAX = 100;
    final int MIN = 1;

    // declare variables
    int randomNumber = (int) (Math.random() * MAX) + 1;
    int min = MIN;
    int max = MAX;
    int userAttempts = 0;
    int userGuess = 0;
    boolean isGuessing = true;

    // Create user input Scanner object
    Scanner input = new Scanner(System.in);

    // Uncomment if you want to see the answer, you cheater
    // System.out.println("answer for testing purposes: " + randomNumber);

    // Input

    System.out.println("Welcome to the Guessing Algorithm! You will get " + NUMBER_OF_ATTEMPTS + " tries to find the correct number.");
    while (isGuessing && userAttempts < NUMBER_OF_ATTEMPTS) {
      System.out.print("Guess a number between " + min + " and " + max + ": ");

      // validate if user input is more than an int in size
      if (!input.hasNextInt()) {
        System.out.println("Error: Please enter a valid whole number (not too large!).");
        input.next(); // Clear the bad input
      }
      else {
        // Begin iteration by setting userGuess to be the user input
        userGuess = input.nextInt();

        // Check if the user guessed correctly
        if (randomNumber == userGuess) {
          System.out.println("You win!");
          isGuessing = false;
        }

        else {
          System.out.print("Wrong guess! ");

          if (userGuess >= min && userGuess <= max) {
            userAttempts++;

            if (randomNumber > userGuess) {
              System.out.println("Your number was too small!");
              min = userGuess + 1;
            }

            else {
              System.out.println("Your number was too big!");
              max = userGuess - 1;
            }

          }
          else {
            if (userGuess > max) {
              System.out.println("That number is too high!");
            }

            else {
              System.out.println("That number is too low!");
            }
          }
        }
      }
    }

    // Output

    System.out.println("You finished with " + userAttempts + " attempt(s).");
    System.out.println("The number was : " + randomNumber);
    if (userGuess == randomNumber) {
      System.out.println("Spot on!");
    }
    else if (userGuess > randomNumber){
      System.out.println("Your guess of " + userGuess + " was " + (userGuess - randomNumber) + " number(s) away!.");
    }
    else {
      System.out.println("Your guess of " + userGuess + " was " + (randomNumber - userGuess) + " number(s) away!");
    }
  }
}