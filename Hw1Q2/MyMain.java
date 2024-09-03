package Hw1Q2;
import java.io.*;
import java.util.LinkedList;

public class MyMain {

    public static void store(InputStream input, LinkedList<Person> list) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String firstName = parts[0];
                    String lastName = parts[1];
                    String id = parts[2];
                    Person person = new Person(firstName, lastName, id);
                    list.add(person);
                } else {
                    System.out.println("Invalid input format, please use 'firstName,lastName,id'");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading input.");
        }
    }

    public static void display(PrintStream output, LinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            Person person = list.get(i);
            output.println(person.toString());
        }
    }

    public static int find(String sid, LinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            Person person = list.get(i);
            if (person.getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinkedList<Person> persons = new LinkedList<>();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter person data (firstName,lastName,id). Type 'done' when finished:");

        try {
            String inputLine;
            inputLine = consoleReader.readLine();
            while (!inputLine.equalsIgnoreCase("done")) {
                InputStream input = new ByteArrayInputStream(inputLine.getBytes());
                store(input, persons);
                inputLine = consoleReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading input.");
        }

        display(System.out, persons);

        try {
            String searchId;
            System.out.println("Enter an ID to search for (type 'exit' to quit):");
            searchId = consoleReader.readLine();
            while (!searchId.equalsIgnoreCase("exit")) {
                int index = find(searchId, persons);
                if (index != -1) {
                    System.out.println("Person with ID " + searchId + " found at index " + index);
                } else {
                    System.out.println("Person with ID " + searchId + " not found.");
                }
                System.out.println("Enter an ID to search for (type 'exit' to quit):");
                searchId = consoleReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading input.");
        }
    }
}