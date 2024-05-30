package FileExercise;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class JavaExercise {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);

        System.out.print("Input file: "); //ask user for the name of the file to read and assign to variable
        String inputFileName = console.next();

        System.out.print("Output file: "); //ask user for the name of the file to write to and assign to variable
        String outputFileName = console.next();

        // ...........Construct the Scanner and PrintWriter objects for reading and writing:
        File inputFile = new File(inputFileName); // create new file object
        Scanner in = new Scanner(inputFile); // create new scanner object to read from file
        PrintWriter out = new PrintWriter(outputFileName); // create new Print_writer object to write to file

        // ............Read the input and write the output:

        double total = 0; //initialise variable to hold total value

        while (in.hasNextDouble())
            //use while loop to capture all values from input file as long as there is a next value to read
        {
            double value = in.nextDouble(); //assign each value read to variable
            out.printf("%15.2f\n",value); // output each value read in from input file to output file
            total = total + value; //add the values together to get total value
        }

        //this is outside of our for loop
        out.printf("Total: %8.2f\n",total); //output total value after the individual values have been read out

        //print message to user
        System.out.println("File operation complete.......");
        System.out.println("Please see output file for results.");

        in.close();
        out.close(); //close input / output streams
    }
}