//accept user input to populate an array
//indicate min/max value entered

import java.util.Scanner;

public class MinMaxAlgorithm {
    public static void main(String[] args) {
        int value; // counter for each item placed in the array
        Scanner in = new Scanner(System.in);
        System.out.println("How many numbers would you like to add?");
        int numOfElements = in.nextInt();
        int [] numList = new int[numOfElements];

        System.out.println("Please enter your number: ");
        for(value = 0; value < numOfElements; value++)
            numList[value] = in.nextInt();

       //calling max method (pass array as argument)
        int maximum = maxNumber(numList);
        System.out.println("Maximum value: " + maximum);

        // calling min method (pass array as argument)
        int minimum = minNumber(numList);
        System.out.println("Minimum value: " + minimum);
    }

    public static int maxNumber(int[] arr) {
        int maximumValue = arr[0]; //set the first item to be maximum

        // for each item (starting with the second)
        for (int a = 1; a < arr.length; a++){
            if (arr[a] > maximumValue){ //if the current item is more than the max
                maximumValue = arr[a];  //set the current item to be max
            }
        }
        return maximumValue; //return to caller
    }
    public static int minNumber (int [] arr){
        int minimumValue = arr[0]; //set the first item to be minimum

        //for each item (starting with the second)
        for (int a = 1; a < arr.length; a++) {
            if (arr[a] < minimumValue){
                minimumValue = arr[a]; //set current item to be min
            }
        }
        return minimumValue;
    }
}


