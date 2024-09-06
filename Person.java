import java.io.*;
//import linked list class
import java.util.LinkedList;
import java.util.stream.Stream;
public class Person {

  //string fields
  private String firstName;
  private String lastName;
  private int Id;

  //constructor
  Person(String fname, String lname, int id){
    firstName = fname;
    lastName = lname;
    Id = id;
  }

//Accessor methods
  public String getFirstName(){
    return firstName;
  }
  public String getLastName(){
    return lastName;
  }
  public int getId(){
    return Id;
  }

  //to string method
  public String toString(){
    return "First Name:" + firstName + " Last Name:" + lastName + " Id:" + Id;
  }
}

class MyMain {
  /* 
    public static void store (InputStream istream, LinkedList<Person> list)
    {
        BufferedReader reader = new BufferedReader (new FileReader ("data.txt"));
        String line;
        while ((line = reader.readLine()) != null) 
        {
            String[] parts = line.split(",");
            list.add(new Person(parts[0], parts[1], Integer.parseInt(parts[2])));
        }
        reader.close();
    }

    public static void display (PrintStream outputStream, LinkedList<Person> list)
    {
        for (int i = 0; i < list.size(); i++) { 
            outputStream.print(list.get(i).toString() + "/n"); 
        }
    }
        */
    public static int find (int sid, LinkedList<Person> list) 
    {
        for (int i=0; i < list.size(); i++)
        {
            if (list.get(i).getId() == sid) 
            {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
      LinkedList<Person> personList = new LinkedList<>();
      /* 
      String dataFilePath = "data.txt";
      try (InputStream inputStream = new FileInputStream(dataFilePath)) {
          store(inputStream, personList);
      } catch (IOException e) {
          System.out.println("Error reading data file: " + e.getMessage());
      }
      */
      System.out.println("Displaying all persons: /n");
      //display(System.out, personList);
      int[] testIds = {12345, 67890, 11111};
      for (int id : testIds) {
        int index = find(id, personList);
        if (index != -1) {
            System.out.println("Person with ID " + id + " found at index " + index + ": " + personList.get(index));
        } else {
            System.out.println("Person with ID " + id + " not found.");
        }
      }
    }
}
