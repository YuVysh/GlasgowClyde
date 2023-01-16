/*     Bank transaction simulation
Two accounts: checking, savings:
(1) Ask for initial balances of both + reject negative balances
(2) Ask for the transaction type (deposit/withdrawal/transfer)
(3) Ask for the account (checking/savings)
(4) Ask for the amount + reject transactions that overdraw an account
(5) Print the balances of the BOTH ACCOUNTS */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double checkBalance;
        double savBalance;
        double amount;

        do {
            System.out.println("Checking account balance: ");
            checkBalance = input.nextDouble();

            System.out.println("Savings account balance: ");
            savBalance = input.nextDouble();

            if (checkBalance < 0 && savBalance < 0){
                System.out.println("Negative Balance: Rejected");
            }
        }while (checkBalance < 0 && savBalance < 0);

        System.out.println();
        System.out.println("1. Checking");
        System.out.println("2. Savings");
        System.out.println("Press your account number: ");
        int account = input.nextInt();

        if (account == 1){
            System.out.println();
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("Press your transaction number: ");
            int transaction = input.nextInt();

            if (transaction == 1){
                System.out.println("Input the amount of transaction: ");
                amount = input.nextDouble();
                checkBalance += amount;
            }
            else if (transaction == 2){
                System.out.println("Input the amount of transaction: ");
                amount = input.nextDouble();
                if (amount < checkBalance){
                    checkBalance -= amount;
                }
                else{
                    System.out.println("Non-sufficient funds: Rejected");
                    return;
                }
            }
            else if (transaction == 3){
                System.out.println("Input the amount of transaction: ");
                amount = input.nextDouble();
                if (amount < checkBalance){
                    checkBalance -= amount;
                }
                else{
                    System.out.println("Non-sufficient funds: Rejected");
                    return;
                }
            }
            else {
                System.out.println("Choose correct number: 1. Deposit || 2. Withdraw || 3. Transfer");
            }
        }
        else if  (account == 2){
            System.out.println();
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("Press your transaction number: ");
            int transaction = input.nextInt();

            if (transaction == 1){
                System.out.println("Input the amount of transaction: ");
                amount = input.nextDouble();
                savBalance += amount;
            }
            else if (transaction == 2 ){
                System.out.println("Input the amount of transaction: ");
                amount = input.nextDouble();
                if (amount < savBalance){
                    savBalance -= amount;
                }
                else{
                    System.out.println("Non-sufficient funds: Rejected");
                    return;
                }
            }
            else if (transaction == 3){
                System.out.println("Input the amount of transaction: ");
                amount = input.nextDouble();
                if (amount < savBalance){
                    savBalance -= amount;
                }
                else{
                    System.out.println("Non-sufficient funds: Rejected");
                    return;
                }
            }
            else {
                System.out.println("Choose correct transaction number: 1. Deposit || 2. Withdraw || 3. Transfer");
                return;
            }
        }
        else {
            System.out.println("Choose correct account number: 1. Checking || 2. Savings");
            return;
        }
        System.out.println("Checking account BALANCE: " + String.format("%.2f", checkBalance));
        System.out.println("Savings account BALANCE: " + String.format("%.2f", savBalance));

    }
}
