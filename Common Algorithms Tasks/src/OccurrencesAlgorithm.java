//accept user input to populate an array
//search for given element (find occurrences)

import java.util.Scanner;
public class OccurrencesAlgorithm {
    public static void main(String[] args) {

        int count = 0; //variable for number of occurrences
        Scanner in = new Scanner(System.in);

        //Get array size
        System.out.println("How many numbers would you like to input?");
        int numOfElements = in.nextInt();
        int [] numList = new int[numOfElements];

        //Populate array with user input until end of array (length) is reached
        System.out.println("Please enter your number: ");
        for (int value = 0; value <numOfElements; value++){
            numList [value] = in.nextInt();
        }

        //Get number to be searched
        System.out.println("Please enter the number you're looking for to check number of occurrences...");
        int search = in.nextInt();

        //for loop to traverse array
        for (int i = 0; i < numList.length; i++){
            //if statement to check each value against our search
            if (numList[i] == search){
                count++; //if true add one to value of variable count
            }

        }
        System.out.println("Number of occurrences of the element: " + search + " is " + count);
    }
}
