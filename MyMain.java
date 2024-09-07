// MyMain.java
import java.io.*;
import java.util.LinkedList;

public class MyMain {

    // Method to store data from input stream to the linked list
    public static void store(InputStream inputStream, LinkedList<Person> list) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");  // Assuming data is comma-separated: firstName,lastName,id
            if (data.length == 3) {  // Ensure data has all three parts
                Person person = new Person(data[0].trim(), data[1].trim(), data[2].trim());
                list.add(person);  // Add person to the linked list
            }
        }
    }

    // Method to display data from the linked list to the output stream
    public static void display(OutputStream outputStream, LinkedList<Person> list) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        for (Person person : list) {
            writer.write(person.toString());  // Write each person's toString() to the output stream
            writer.newLine();
        }
        writer.flush();  // Ensure all data is written out
    }

    // Method to find a person by ID in the linked list
    public static int find(String sid, LinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {  // Check if the current person's id matches sid
                return i;  // Return index if found
            }
        }
        return -1;  // Return -1 if not found
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        LinkedList<Person> list = new LinkedList<>();  // Create a linked list to store persons
        
        // Reading data from a file named "persons.txt"
        try (FileInputStream fis = new FileInputStream("persons.txt")) {
            store(fis, list);  // Store data from file to linked list
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }

        // Displaying data to the console
        try {
            display(System.out, list);  // Display all persons to the console
        } catch (IOException e) {
            System.out.println("Error writing to output: " + e.getMessage());
        }

        // Finding a person by ID and demonstrating the find method
        System.out.println("\nFind person with ID 'P123':");
        int index = find("P123", list);
        if (index != -1) {
            System.out.println("Found: " + list.get(index));
        } else {
            System.out.println("Person not found.");
        }

        // Additional find method calls
        System.out.println("\nFind person with ID 'P999':");
        index = find("P999", list);
        if (index != -1) {
            System.out.println("Found: " + list.get(index));
        } else {
            System.out.println("Person not found.");
        }
    }
}
