// PersonList.java
import java.io.*;
import java.util.LinkedList;

public class PersonList {
    private LinkedList<Person> list;  // LinkedList to store Person objects

    // Constructor to initialize the PersonList object
    public PersonList() {
        this.list = new LinkedList<>();
    }

    // Method to store data from input stream to the linked list
    public void store(InputStream inputStream) throws IOException {
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
    public void display(OutputStream outputStream) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        for (Person person : list) {
            writer.write(person.toString());  // Write each person's toString() to the output stream
            writer.newLine();
        }
        writer.flush();  // Ensure all data is written out
    }

    // Method to find a person by ID in the linked list
    public int find(String sid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {  // Check if the current person's id matches sid
                return i;  // Return index if found
            }
        }
        return -1;  // Return -1 if not found
    }

    // Accessor method to get the list (used for testing/display purposes)
    public LinkedList<Person> getList() {
        return list;
    }
}
