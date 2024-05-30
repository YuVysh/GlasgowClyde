import java.util.Scanner;
import java.util.Arrays;

public class LinearSearchAlgorithm {
    public static void main(String[] args) {
        int value;
        Scanner in = new Scanner(System.in);

        //Get array size
        System.out.println("How many words would you like to store in the array: ");
        int numOfWords = Integer.parseInt(in.nextLine());
        String [] wordsList = new String[numOfWords]; //set the size of array

        //Populate with user input until end of array (length) is reached
        System.out.println("Enter " + numOfWords + " word(s): ");
        for (value = 0; value < numOfWords; value++) {
            wordsList[value] = in.nextLine();
        }

        //Get word to be searched
        System.out.println("Enter word to find: ");
        String search = in.nextLine();

        //linear search:
        for(value = 0; value < numOfWords; value++) //for each item in the array
        {
            if (wordsList[value].equals(search)){
                System.out.println(search + " word belongs to this array");
                break;
            }
        }
        if (value == numOfWords){
            System.out.println(search + " isn't present in the array");
            System.out.println(Arrays.toString(wordsList)); //print array to see the position inside array (check result)
        }
    }
}
