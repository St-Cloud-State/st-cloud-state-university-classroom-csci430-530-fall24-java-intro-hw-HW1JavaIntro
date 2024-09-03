import java.io.*;
import java.util.LinkedList;

public class MyMain {

    public static void store(InputStream input, LinkedList<Person> list) throws IOException {
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
        LinkedList<Person> persons = new LinkedList<>();
        
        
        String data = "John,Doe,12345\nJane,Smith,67890\nAlice,Jones,13579\n";
        InputStream input = new ByteArrayInputStream(data.getBytes());

        try {
            store(input, persons);
        } catch (IOException e) {
            System.err.println("Error storing data: " + e.getMessage());
        }

        display(System.out, persons);

        String searchId = "67890";
        int index = find(searchId, persons);
        if (index != -1) {
            System.out.println("Person with ID " + searchId + " found at index " + index);
        } else {
            System.out.println("Person with ID " + searchId + " not found.");
        }
    }
}
