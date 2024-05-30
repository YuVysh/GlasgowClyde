import java.io.File;
import java.io.FileNotFoundException; //import appropriate in-built java packages / classes
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class CSVFileExample {

    public static PrintWriter out;
    public static File fileName; //declare global variables i.e. the PrintWriter, File and scanner can be used
    public static Scanner sc; // (or seen) by any method in the class StringSplitExample

    // As we are going to be reading in from a file, in case the file is not found we must
    // make use of the java FileNotFoundException class (method call is inside main)
    public static void main(String[] args)throws FileNotFoundException  {

        readFile(); //call method readFile from main method
    }
    // As we are going to be reading in from a file, in case the file is not found we must
    // make use of the java FileNotFoundException class
    public static void readFile()throws FileNotFoundException  {

        String nameOfFile = "C:\\Users\\User\\IdeaProjects\\CSVFileExample\\names-1.csv"; // declare and assign the file (i.e. location and name of file) to variable nameOfFile
        fileName = new File(nameOfFile); // create file object and pass the name of the file (assigned to variable nameOfFile) to file object
        sc = new Scanner(fileName); // create scanner object and pass the file object to the scanner object

        int max = 0;
        String title = null; //declare and initialise the variables that will be used to hold values read in from the file
        String forename = null;
        String surname= null;

        while(sc.hasNext()){ // use a while loop which will loop as long as there are values to be read

            String allWords = sc.next(); // assign every word read (including commas) from the file to variable allWords
            System.out.println(allWords); // I have added in a print to console just so you can see what has been assigned
            // to the variable allWords

            String[] Words = allWords.split (",");//Use the Split method on the String allWords to split the string at each comma and
            // assign each word into a String Array i.e. each individual word will now be one element of the array
            for(String word: Words){
                System.out.println(word); //I have printed out the array after splitting strings, so you can see what has been done
            }
            System.out.println(Arrays.toString(Words));//printed out as it looks inside array i.e. each element of array holds a separate value

            int[] age = new int[Words.length]; // in order to access and assign the String element that contains the age we have to set
            // up an array of Integer objects(i.e. use new keyword)so we can use the Words.Length java method
            // this method can only be used for an Integer object and not a primitive int value
            //length has a value of 4 for each line read in from file i.e. [Miss,Jane,Morrison,45]


            age[3]= Integer.parseInt(Words[3]);//Because the original value found is still a string we have to parse or convert this to an Integer
            // value in order to find the maximum. Each age value found at index 3 as it iterates around file read in.

            if(age[3]>max){// we now use an if statement to check the value contained in age in order to find the max value.

                max = age[3];// value contained in age is assigned to variable max

                //when max is found we can then use the indexes to find corresponding values
                title = Words[0];// index is used to find the title value in array i.e. 0

                forename = Words[1];// index is used to find the first name value in array i.e. 1

                surname = Words[2];// index is used to find the second name value in array i.e. 2

            }

        }
        output(max, title, surname, forename);// pass the values contained in max, title, surname and forename to another method
        // output () in order to create / print out file
    }
    //note no FileNotFoundException as we are going to use a try/catch bloc
    public static void output(int max,String title,String surname,String forename) {


        try{ //use a try/catch block for any possible errors i.e. to test this change the name of the output file to "" and see what happens

            //create new PrintWriter object and name the location and name of file to be printed
            out = new PrintWriter("src/OldestPerson.txt");

            // tell the PrintWriter Object what is to be printed in the output file
            out.print("The oldest person is:  " + title + " " + forename + " " + surname + " who is "+ max);

            System.out.println("The oldest person is:  " + title + " " + forename + " " + surname + " who is " + max); // output to console

            out.close(); //close PrinterWriter
        }
        catch (Exception e) //generic catch block for any errors encountered when trying to print file
        {
            System.out.println("Unexpected error: Please run the program again."); // output message to the console if error occurs
        }

    }

}