// MyMain.java
import java.io.*;

public class MyMain {

    public static void main(String[] args) {
        PersonList personList = new PersonList();  // Instantiate the PersonList object

        // Reading data from a file named "persons.txt"
        try (FileInputStream fis = new FileInputStream("persons.txt")) {
            personList.store(fis);  // Store data from file to linked list
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }

        // Displaying data to the console
        try {
            personList.display(System.out);  // Display all persons to the console
        } catch (IOException e) {
            System.out.println("Error writing to output: " + e.getMessage());
        }

        // Finding a person by ID and demonstrating the find method
        System.out.println("\nFind person with ID 'P123':");
        int index = personList.find("P123");
        if (index != -1) {
            System.out.println("Found: " + personList.getList().get(index));
        } else {
            System.out.println("Person not found.");
        }

        // Additional find method calls
        System.out.println("\nFind person with ID 'P999':");
        index = personList.find("P999");
        if (index != -1) {
            System.out.println("Found: " + personList.getList().get(index));
        } else {
            System.out.println("Person not found.");
        }
    }
}
