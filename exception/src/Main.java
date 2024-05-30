
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int num1, num2, result;
        int retry = 0; //used to set the value for the do loop
        Scanner in = new Scanner(System.in);
        do { //use do loop so the try / catch will be executed at least once
            try {
                System.out.println("We are going to divide two numbers.");
                System.out.println("Please enter your first number: ");
                num1 = in.nextInt();
                //exception may occur here if user inputs a value of 0
                System.out.println("Please enter your second number: ");
                num2 = in.nextInt();
                result = num1 / num2;
                //exception will be thrown here if user entered 0 value or other data type other than int
                System.out.println("The result of " + num1 + " divided by " + num2
                        + " is " + result);
            } catch (ArithmeticException e) {
                /* This block will only execute if any Arithmetic exception
                 * occurs in try block
                 */
                System.out.println("You should not divide a number by zero. Please try again.");
                continue;//use continue to jump to while part of do / while loop
            }
            catch (Exception e) {
                /* This is a generic Exception handler which means it can handle
                 * all the exceptions. This will execute if the exception is not
                 * handled by previous catch blocks.
                 */
                System.out.println("Exception occurred");
            }
            retry = 1;//if try block executed successfully then retry will be given value of 1 i.e. escape while loop
            System.out.println("I'm out of try-catch block in Java.");
        }while (retry == 0);
    }
}
