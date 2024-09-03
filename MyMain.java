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
                    Person person = new Person(parts[0], parts[1], parts[2]);
                    list.add(person);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void display(PrintStream output, LinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            output.println(list.get(i));
        }
    }

    public static int find(String sid, LinkedList<Person> list) {
        int foundIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            Person person = list.get(i);
            if (person.getId().equals(sid)) {
                foundIndex = i;
                break;
            }
        }
        return foundIndex;
    }

    public static void main(String[] args) {
        LinkedList<Person> persons = new LinkedList<>();

        String data = "John,Doe,12345\nJane,Smith,67890\nAlice,Jones,13579\n";
        InputStream input = new ByteArrayInputStream(data.getBytes());

        store(input, persons);
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
