import java.util.Scanner;
public class ATM {
    public static void main(String[] args) {
        int pin = 1212;
        int attempts = 0;
        int entry;
        do{
            System.out.println("Enter your pin : ");

            Scanner atm = new Scanner(System.in);
            entry = atm.nextInt();

            attempts++;  // counter
            if (entry == pin){
                System.out.println("Correct. Welcome");
            }
            else{
                System.out.println("Incorrect PIN. " + (3-attempts) + " attempts left");
                if (attempts > 2){
                    System.out.println("Your bank card is blocked");
                }
            }
        }while(entry != pin && attempts<3);
    }
}