import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your score: ");
        double score = input.nextDouble();
        if (score >= 60){
            System.out.println("Gongrats! You've passed the exam.");
            if (score >= 70){
                System.out.println("Your grade is A");
            }
            else {
                System.out.println("Your grade is B");
            }
        }
        else {
            System.out.println("Better luck next time...");
            if (score >= 50 && score <= 59){
                System.out.println("Your grade is C");
            }
            else if (score >= 40 && score <= 49){
                System.out.println("Your grade is D");
            }
            else {
                System.out.println("You've failed 😔");
            }
        }

        System.out.println("ODD/EVEN CHECK:");

        //checking whether the number is even or odd using modulo/remainder
        if (score % 2 == 0){
            System.out.println(score + " is EVEN");
        }
        else{
            System.out.println(score + " is ODD");
        }

    }
}
