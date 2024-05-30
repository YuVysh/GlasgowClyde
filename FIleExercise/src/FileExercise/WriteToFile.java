package FileExercise;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {
        try{
            FileWriter myWriter = new FileWriter("C:\\Users\\User\\IdeaProjects\\FIleExercise\\File1.txt");
            myWriter.write("Java is cool");
            myWriter.close();
            System.out.println("Successfully wrote to the file!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
