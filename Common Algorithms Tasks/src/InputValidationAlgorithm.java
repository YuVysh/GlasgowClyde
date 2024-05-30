import java.util.Scanner;

public class InputValidationAlgorithm {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String password;
        while (true){
            System.out.println("Please enter password: ");
            password = input.nextLine();
            if(password.equals("buddy123"))
            {
                System.out.println("Welcome back!");
                break;
            }
            else{
                System.out.println("Incorrect Password. Try again");
            }
        }
    }
}
