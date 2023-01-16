import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number = (int)(Math.random()* 101);

        System.out.println("Guess a magic number between 0 and 100: ");

        int guess = -1;

        while (guess != number){
            System.out.println("\n Please enter your guess: ");
            guess = input.nextInt();

            if (guess == number){
                System.out.println("Correct. Your number is: " + number);
            }
            else if(guess > number){
                System.out.println("Your guess is too high. Please try again...");
            }
            else{
                System.out.println("Your guess is too low. Please try again...");
            }
        }

    }
}