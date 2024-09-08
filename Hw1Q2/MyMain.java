package Hw1Q2;
import java.io.*;
import java.util.LinkedList;

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

    public static void store(InputStream input, LinkedList<Person> list) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                Person person = new Person(parts[0].trim(), parts[1].trim(), parts[2].trim());
                list.add(person);
            }
        }
    }

    public static void display(PrintStream output, LinkedList<Person> list) {
        for (Person person : list) {
            output.println(person);
        }
    }

    public static int find(String sid, LinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // create and fill file 
        createFile();

        LinkedList<Person> persons = new LinkedList<>();
        try {
            FileInputStream fileInput = new FileInputStream("persons.txt");
            store(fileInput, persons);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // display the list of persons
        display(System.out, persons);

        // explicit/hardcoded example of finding a person by their ID
        String searchId = "67890";
        int index = find(searchId, persons);
        if (index != -1) {
            System.out.println("Person with ID " + searchId + " found at index " + index);
        } else {
            System.out.println("Person with ID " + searchId + " not found.");
        }
    }
}
