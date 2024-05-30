package studentmarks;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class StudentMarks {

    public static File fileName; //declared global variables which can be seen by all methods
    public static Scanner input;
    public static Scanner in = new Scanner(System.in); //create global scanner which can be seen and used by readFile() and reused for user input

    //declare global arrays which can be seen and accessed
    public static String[][] Marks = new String[10][4]; //2D array to store data read from file i.e. java array of records
    public static String[] firstNames = new String[10]; //1D Arrays to store individual data
    public static String [] secondNames = new String [10];
    public static int[] halfTermMarks = new int[10];
    public static int[] fullTermMarks = new int[10];


    public static int[] totalGrades = new int[10]; //1D array to store calculated data
    public static String [] award = new String[10];

    public static void main(String[] args) throws FileNotFoundException {


        String password = "glasgowclyde"; //set value for password
        int fail = 3; //set value for number of failed attempts

        //use loop to allow the user to input password multiple times
        do {
            System.out.println("Welcome to the Glasgow Clyde Student Grade App.");
            System.out.println("Please enter your password to continue: ");
            String login = in.nextLine();
            //use if else statement to validate password
            if (login.equals(password)) {
                System.out.println("Password Validated");
                Menu();//if password is validated call menu() method
            } else {
                //if password is not validated take one away from fail and repeat loop
                fail--;
                System.out.println("Your Password is incorrect");//print message to user
                System.out.println("You have: " + fail + " attempts left.");
            }

        } while (fail != 0); //set condition for loop
        //if the fail to input password correctly after 3 attempts loop will exit
        //and the following output will be shown to the user
        System.out.println("Number of attempts exceeded. You are now locked out.");
        System.exit(0); //program will exit

    }
    public static void Menu() throws FileNotFoundException{

        int option;
        //use do loop to allow the user to use menu until they choose to exit
        do {
            System.out.println("Please choose from the following options:");
            System.out.println("1. Read in File");
            System.out.println("2. Calculate Grade");
            System.out.println("3. Count Occurrence");
            System.out.println("4. Find Highest Grade");
            System.out.println("5. Find Lowest Grade");
            System.out.println("6. Exit ");
            option = in.nextInt();//capture users menu option

            //use if else to compare user option and execute associated method
            if (option == 1) {
                readFile(); //call method to read from the file
            } else if (option == 2) {
                calculateGrade();
            } else if (option == 3) {
                countOccurrence(award);
            } else if (option == 4) {
                findHighestGrade();
            } else if (option == 5) {
                findLowestGrade();
            } else if(option == 6){
                in.close(); //close scanner object
                System.out.println("Thank you for using the Cardonald College Grade App. Goodbye...");
                System.exit(0);
            }
        } while (option!=6);//condition for loop

    }
    public static void readFile()throws FileNotFoundException{

        //create file object which can read using scanner
        String nameOfFile = "C:\\Users\\User\\IdeaProjects\\Student Marks\\Student Marks.csv";
        fileName = new File(nameOfFile);
        in = new Scanner(fileName); //pass file over to Scanner

        //use while loop to check for all the data that is to be read in
        while (in.hasNextLine()) {
            //use for loop to add data to the 2D array until the end of file is reached
            for (int i = 0; i < Marks.length; i++) {
                String[] line = in.nextLine().split(",");
                for (int j = 0; j < line.length; j++) {
                    Marks[i][j] = line[j];
                }
            }
        }
        //print out to check that data has been read and stored into 2D array
        System.out.println("Students Grades: " + "\n" + Arrays.deepToString(Marks));

        //use for loop to iterate over the 2D array and extract data required for 1D arrays
        for (int i = 0; i < fullTermMarks.length; i++) {
            fullTermMarks[i] = Integer.parseInt(Marks[i][3]);
            halfTermMarks[i] = Integer.parseInt(Marks[i][2]);
            secondNames[i] = Marks[i][1];
            firstNames[i] = Marks[i][0];
        }
        //print out 1D array to check the data has been captured
        System.out.println("Names are: " + Arrays.toString(firstNames));
        System.out.println("Surnames are: " + Arrays.toString(secondNames));
        System.out.println("Course Grades are: " + Arrays.toString(halfTermMarks));
        System.out.println("Prelim Grades are: " + Arrays.toString(fullTermMarks));

        in.close(); //close scanner being used for file input
        in = new Scanner(System.in); //create new instance of scanner for reading in user input i.e. menu choice
        System.out.println(" ");
    }

    public static void calculateGrade(){

        //use for loop for each element of totalGrades
        for (int i = 0; i < totalGrades.length; i++) {
            ////use indexes for each array to find / calculate values
            //each total will be added to the index of totalGrades array
            totalGrades[i] = halfTermMarks[i] + fullTermMarks[i];

            //use if statement to check each element total to determine award
            if (totalGrades[i] >= 80 && totalGrades[i]<=100) {
                award[i] = "A"; //add award value to awardArray index
                System.out.println("Well done " + firstNames[i] + " you got an 'A'");

            } else if (totalGrades[i] >= 70 && totalGrades[i] < 80) {
                award[i] = "B";
                System.out.println("Well done " + firstNames[i] + " you got a 'B'");

            } else if (totalGrades[i] >= 60 && totalGrades[i] < 70) {
                award[i] = "C";
                System.out.println("Well done " + firstNames[i] + " you got a 'B'");

            } else if (totalGrades[i] >= 50 && totalGrades[i] < 60) {
                award[i] = "D";
                System.out.println("Well done " + firstNames[i] + " you got a 'C'");
            }
            else{
                award[i]= "No Award";
                System.out.println("Unfortunately " + firstNames[i]+ " you failed to receive a grade. Better luck next time.");
            }

        }
        System.out.println(Arrays.toString(totalGrades));
        System.out.println(Arrays.toString(award));
        System.out.println(" ");
    }
    public static void countOccurrence(String[]award){

        int count = 0;//initialise count

        //use for loop to iterate award array
        for(int i = 0; i < award.length; i++)
        {
            if(award[i].equals("A"))
            {
                count++; //add one to count for each 'A' found in award array
            }
        }
        System.out.println("There are: "+ count + " 'A' passes in the class.");
        System.out.println(" ");

    }
    public static void findHighestGrade(){

        int highestMark = totalGrades[0]; //Set the first item to be the maximum
        String student = " ";

        //For each item (starting with the second)
        for (int a = 1; a < totalGrades.length; a++) {
            if (totalGrades[a] > highestMark) {//If the current item is more than the maximum
                highestMark = totalGrades[a]; //set the current item to be the maximum
                student = firstNames[a];
            }

        }
        System.out.println("Highest mark of: " + highestMark + " was achieved by " + student);
        System.out.println(" ");
    }
    public static void findLowestGrade(){

        int lowestMark = totalGrades[0]; //Set the first item to be the minimum
        String student = " ";

        //For each item (starting with the second)
        for (int a = 1; a < totalGrades.length; a++) {
            if (totalGrades[a] < lowestMark) {//If the current item is less than the minimum
                lowestMark = totalGrades[a]; //set the current item to be the minimum
                student = firstNames[a];
            }

        }
        System.out.println("Lowest mark of: " + lowestMark + " was achieved by " + student);
        System.out.println(" ");
    }



}
