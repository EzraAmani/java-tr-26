package Excercises.javase013.Filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = null;

        try {
            String filename = args[0];
            reader = new BufferedReader(new FileReader(filename));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);

            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Please provide a filename as command line argument.");
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }

        System.out.println("\nProgram continues execution...");
    }

}
