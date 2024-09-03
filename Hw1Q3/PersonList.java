package Hw1Q3;
import Hw1Q2.Person;
import java.io.*;
import java.util.LinkedList;

public class PersonList {

    private LinkedList<Person> list;

    // Constructor
    public PersonList() {
        list = new LinkedList<>();
    }

    // Method to store persons from an input stream into the list
    public void store(InputStream input) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String firstName = parts[0].trim();
                    String lastName = parts[1].trim();
                    String id = parts[2].trim();
                    Person person = new Person(firstName, lastName, id);
                    list.add(person);
                } else {
                    System.out.println("Please enter data in the correct format: firstName,lastName,id");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading input.");
        }
    }

    // Method to display the list of persons
    public void display(PrintStream output) {
        for (int i = 0; i < list.size(); i++) {
            output.println(list.get(i));
        }
    }

    // Method to find a person by their ID
    public int find(String sid) {
        for (int i = 0; i < list.size(); i++) {
            Person person = list.get(i);
            if (person.getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }
}
