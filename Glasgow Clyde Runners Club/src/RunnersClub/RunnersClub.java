package RunnersClub;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class RunnersClub {

    public static File txtFile;
    public static Scanner in = new Scanner(System.in);
    public static String [][] dataArray = new String[16][3];
    public static String [] firstName = new String[16];
    public static String [] lastName = new String[16];
    public static int[] raceTime = new int[16];
    public static int option;

    public static void main(String[] args) throws FileNotFoundException {

        //Set password check
        String password = "clyderunners";
        int fail = 3; //set number of attempts
        do {
            System.out.println("""

                    Welcome to the Glasgow Clyde Runners Club App
                    
                    """);
            System.out.println("Please enter your password to continue: " + "\n");
            String login = in.nextLine();
            //if statement to validate password
            if (login.equals(password)) {
                System.out.println("\n" + "Welcome!");
                Menu(); //call menu() method
            } else {
                //take -1 attempt and repeat loop
                fail--;
                System.out.println("Incorrect password details");
                System.out.println("You have: " + fail + " attempts left");
            }
        } while (fail != 0);
        // exit loop after 3 attempts exceeded
        System.out.println("Number of attempts exceeded. You are now locked out");
        System.exit(0); //exit program
    }

    public static void Menu() throws FileNotFoundException {


        //do loop to allow the user to use menu until they choose "exit"
        do  {
            System.out.println("""

                    ********************* Glasgow Clyde Runners Club *********************
                    """);
            System.out.println("""
                    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Menu <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                    """);
            System.out.println("Please choose from the following options: " + "\n");
            System.out.println("1. Read the File");
            System.out.println("2. Find and Print Slowest recorded time");
            System.out.println("3. Find and Print Fastest recorded time");
            System.out.println("4. Sort and Print recorded time (from slowest to fastest)");
            System.out.println("5. Search for a time (seconds) in a race");
            System.out.println("6. Time Occurrences");
            System.out.println("7. Exit");

            try {
                System.out.println("\n" + "Input number from [1 to 7] to continue: ");
                option = in.nextInt();

                //if else statement to compare and execute user options
                if (option == 1) {
                    readFile();
                } else if (option == 2) {
                    findSlowestTime();
                } else if (option == 3) {
                    findFastestTime();
                } else if (option == 4) {
                    sortOrder();
                } else if (option == 5) {
                    linearSearch();
                } else if (option == 6) {
                    timeOccurrences();
                }
                else if (option == 7) {
                    in.close(); //close scanner object
                    System.out.println("""
                       ******************* Thank you for using Glasgow Clyde Runners App *****************
                        """);
                    System.exit(0);
                }
                else {
                    System.out.println("The entry must be a number between 1 and 7 accordingly");
                }

            } catch (InputMismatchException e) {
                System.out.println("Incorrect details. Please enter NUMBERS ONLY");
                in.next();
            }
        } while (option!=8);
    }
    public static void readFile() throws FileNotFoundException {
        //create file object to read from text file using scanner
        //create string object to contain name of file to read and assign value
        String fileName = "C:\\Users\\User\\IdeaProjects\\Glasgow Clyde Runners Club\\race results-1.txt";
        txtFile = new File(fileName);
        in = new Scanner(txtFile);

        //while loop to check for all data that is to be read
        while (in.hasNextLine()) {
            //for loop to add data to the 2D array called "dataArray" until the end of file is reaches
            //Accessing array elements using nested for loop
            for (int i = 0; i < dataArray.length; i++) {   // accessing rows
                String [] line = in.nextLine().split(" ");
                for (int j = 0; j < line.length; j++) {    // accessing columns
                    dataArray[i][j] = line[j];    //accessing array elements
                }
            }
        }
        //print out to check that data has been read and stored into 2D array
        System.out.println("Race results: " + "\n" + Arrays.deepToString(dataArray));

        //for loop to iterate over the 2D array and extract data for 1D array
        for (int i = 0; i < raceTime.length; i++) {
            raceTime[i] = Integer.parseInt(dataArray[i][2]);
            lastName[i] = dataArray[i][1];
            firstName[i] = dataArray[i][0];
        }

        //print out 1D array to check tha data has been captured
        System.out.println("\n" + "Names are: " + Arrays.toString(firstName));
        System.out.println("\n" + "Surnames are: " + Arrays.toString(lastName));
        System.out.println("\n" + "Race results are: " + Arrays.toString(raceTime));

        in.close(); //close scanner being used for file input streams
        in = new Scanner(System.in); //create new instance of scanner for reading user input
        System.out.println(" ");
    }

    //find max value (pass array as argument)
    public static void findFastestTime(){

        int fastestTime = raceTime[0]; //Set the first item to be the maximum
        String contestant = " ";

        //For each item (starting with the second)
        for (int a = 1; a < raceTime.length; a++) {
            if (raceTime[a] > fastestTime) {//If the current item is more than the maximum
                fastestTime = raceTime[a]; //set the current item to be the maximum
                contestant = firstName[a];
            }
        }
        System.out.println(" 🟢 Fastest recorded time of: " + fastestTime + " was achieved by " + contestant + "\n");

        //write result to another text file (1)
        try  (FileWriter myWriter = new FileWriter("C:\\Users\\User\\IdeaProjects\\Glasgow Clyde Runners Club\\race results (updated).txt", true);
              BufferedWriter bWriter = new BufferedWriter(myWriter);
              PrintWriter pWriter = new PrintWriter(bWriter))
        {
            pWriter.println(" 🟢 Fastest recorded time of: " + fastestTime + " was achieved by " + contestant + "\n");
            pWriter.close();
            System.out.println("\nSuccessfully wrote to the file!");
        } catch (IOException e) {
            System.out.println("\nAn error occurred");
            e.printStackTrace();
        }
    }

    //find min value (pass array as argument)
    public static void findSlowestTime(){

        int slowestTime = raceTime[0]; //Set the first item to be the minimum
        String contestant = " ";

        //For each item (starting with the second)
        for (int a = 1; a < raceTime.length; a++) {
            if (raceTime[a] < slowestTime) {//If the current item is less than the minimum
                slowestTime = raceTime[a]; //set the current item to be the minimum
                contestant = firstName[a];
            }
        }
        System.out.println(" 🔴 Slowest recorded time of: " + slowestTime + " was achieved by " + contestant + "\n");

        //write result to another text file (1)
        try  (FileWriter myWriter = new FileWriter("C:\\Users\\User\\IdeaProjects\\Glasgow Clyde Runners Club\\race results (updated).txt", true);
              BufferedWriter bWriter = new BufferedWriter(myWriter);
              PrintWriter pWriter = new PrintWriter(bWriter))
        {
            pWriter.println(" 🔴 Slowest recorded time of: " + slowestTime + " was achieved by " + contestant + "\n");
            pWriter.close();
            System.out.println("\nSuccessfully wrote to the file!");
        } catch (IOException e) {
            System.out.println("\nAn error occurred");
            e.printStackTrace();
        }
    }

    //Order race time from slowest to fastest
    public static void sortOrder() {

        //use .sort() method to sort an array in ascending order
        Arrays.sort(raceTime);
        System.out.println("\n🔴🟢The sorted recorded time (from slowest to fastest) is: ");

        //write result to another text file (3)
        try  (FileWriter myWriter = new FileWriter("C:\\Users\\User\\IdeaProjects\\Glasgow Clyde Runners Club\\race results (updated).txt", true);
              BufferedWriter bWriter = new BufferedWriter(myWriter);
              PrintWriter pWriter = new PrintWriter(bWriter))
        {
            pWriter.println("\n🔴🟢The sorted recorded time (from slowest to fastest) is: ");
            // traversing through array elements
            for (int j = 0; j < raceTime.length; j++) {
                System.out.println(raceTime[j] + " ");
                pWriter.println(raceTime[j] + " ");
            }
            pWriter.close();
            System.out.println("\nSuccessfully wrote to the file!");
        } catch (IOException e) {
            System.out.println("\nAn error occurred");
            e.printStackTrace();
        }
    }

    public static void linearSearch() {

        //Get time to be searched
        System.out.println("\nEnter time to find: ");
        int search = in.nextInt();
        int i = 0;

        //For loop to traverse array
        for (i = 0; i < raceTime.length; i++) {
            //if statement to check value against our search
            if (raceTime[i] == search){
                System.out.println(" ⌚ " + search + "s - time result you are looking for");
                break;
            }
        }
        if (i == raceTime.length) {
            System.out.println(search + " isn't present in this list");
            System.out.println(Arrays.toString(raceTime)); //print array to see the position inside array (check result)
        }
    }

    public static void timeOccurrences() {
        //Get time to be searched
        System.out.println("\nEnter time to find: ");
        int search = in.nextInt();
        int i = 0;
        int count = 0;

        //For loop to traverse array
        for (i = 0; i < raceTime.length; i++) {
            //if statement to check value against our search
            if (raceTime[i] == search) {
                count++; //if true add +1 to value of variable count
            }
        }
        System.out.println(count + " contestant(s) finished race at the given time: " + search + "\n");
    }
}
