package Hw1Q3;
import java.io.*;

public class MyMain {

    public static void createFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("persons.txt"))) {
            writer.println("John,Doe,12345");
            writer.println("Jane,Smith,67890");
            writer.println("Alice,Jones,13579");
            writer.println("Bob,Brown,24680");
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // create and fill the file 
        createFile();

        PersonList persons = new PersonList();
        try {
            FileInputStream fileInput = new FileInputStream("persons.txt");
            persons.store(fileInput);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // display the list of persons
        persons.display(System.out);

        // explicit/hardcoded example of finding a person by their ID
        String searchId = "67890";
        int index = persons.find(searchId);
        if (index != -1) {
            System.out.println("Person with ID " + searchId + " found at index " + index);
        } else {
            System.out.println("Person with ID " + searchId + " not found.");
        }
    }
}
