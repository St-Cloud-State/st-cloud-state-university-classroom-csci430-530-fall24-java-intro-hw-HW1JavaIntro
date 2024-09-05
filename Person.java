import java.io.*;
//import linked list class
import java.util.LinkedList;
import java.util.stream.Stream;
public class Person {

  //string fields
  private String firstName;
  private String lastName;
  private Int Id;

  //constructor
  public person(String firstName, String lastName, Int id){
    firstName = fname;
    lastName = lname;
    Id = id;
  }

//Accessor methods
  public String getFirstName(){
    return fname;
  }
  public String getLastName(){
    return lname;
  }
  public String getID(){
    return id;
  }

  //to string method
  public String toString(){
    return "First Name:" + firstName + " Last Name:" + lastName + " Id:" + Id;
  }
}

public class MyMain {

    public static void store (InputStream istream, LinkedList<Person> list)
    {
        BufferedReader reader = new BufferedReader (newInputStreamReader (istream));
        string line;
        while ((line = reader.readLine()) != null) 
        {
            string[] parts = line.split(",");
            list.add(new Person(fname, lname, id));
        }
    }

    public static void display (PrintStream outputStream, LinkedList<Person> list)
    {
        for (int i = 0; i < linkedList.size(); i++) { 
            outputStream.print(linkedList.get(i).toString() + "/n"); 
        }
    }

    public static int find (String sid, LinkedList<Person> list) 
    {
        for (int i=0; i < list.size(); i++)
        {
            if (list.get(i).getID().equals(sid)) 
            {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinkedList<Person> personList = new LinkedList<>();

        String dataFilePath = "data.txt";
        try (InputStream inputStream = new FileInputStream(dataFilePath)) {
            store(inputStream, personList);
        } catch (IOException e) {
            System.out.println("Error reading data file: " + e.getMessage());
        }

        System.out.println("Displaying all persons: /n");
        display(System.out, personList);

        String[] testIds = {"12345", "67890", "11111"};
        for (String id : testIds) {
            int index = find(id, personList);
            if (index != -1) {
                System.out.println("Person with ID " + id + " found at index " + index + ": " + personList.get(index));
            } else {
                System.out.println("Person with ID " + id + " not found.");
            }
        }
    }
}
