package Hw1Q3;

import java.io.*;

public class MyMain {

    public static void main(String[] args) {
        PersonList persons = new PersonList();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter person data (firstName,lastName,id) one per line. Type 'done' to finish:");

        try {
            String inputLine;
            inputLine = consoleReader.readLine();
            while (!inputLine.equalsIgnoreCase("done")) {
                InputStream input = new ByteArrayInputStream(inputLine.getBytes());
                persons.store(input);
                inputLine = consoleReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading input.");
        }

        persons.display(System.out);

        try {
            String searchId;
            System.out.println("Enter an ID to search for (type 'exit' to quit):");
            searchId = consoleReader.readLine();
            while (!searchId.equalsIgnoreCase("exit")) {
                int index = persons.find(searchId);
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