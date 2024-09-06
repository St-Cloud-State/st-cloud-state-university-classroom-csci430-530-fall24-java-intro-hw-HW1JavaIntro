package Hw1Q2;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
//import linked list class
import java.util.LinkedList;

public class Person {

  //string fields
  private String firstName;
  private String lastName;
  private int Id;

  //constructor
  public Person(String fname, String lname, int id){
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
    return "First Name: " + firstName + " Last Name: " + lastName + " Id:" + Id ;
  }
}

class MyMain {
    public static void store (Scanner scanner, LinkedList<Person> list)
    {
      while (scanner.hasNextLine()) {
          String[] parts = scanner.nextLine().split(",");
          list.add(new Person(parts[0], parts[1], Integer.parseInt(parts[2])));
      }
    }

    public static void display (PrintStream outputStream, LinkedList<Person> list)
    {
        for (int i = 0; i < list.size(); i++) { 
            outputStream.println(list.get(i).toString()); 
        }
    }
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
    public static void main(String[] args) throws FileNotFoundException {
      String fileName1, outFileName;
      File dataFile1, outFile;
      boolean hasNext1 = false, hasNext2 = false;
      LinkedList<Person> personList = new LinkedList<>();
      Scanner keyScanner = new Scanner(System.in);
      System.out.println("Please enter the input file name: ");
      fileName1 = keyScanner.nextLine();
      System.out.println("Please enter the output file name: ");
      outFileName = keyScanner.nextLine();		
      dataFile1 = new File(fileName1);
      outFile = new File(outFileName);
      Scanner fileScanner1 = new Scanner(dataFile1);
      PrintStream printer = new PrintStream(outFile);
      store(fileScanner1, personList);
      System.out.println("Displaying all persons:");
      display(printer, personList);
      int[] testIds = {12345, 67890, 11111};
      for (int id : testIds) {
        int index = find(id, personList);
        if (index != -1) {
            System.out.println("Person with Id " + id + " was found: "+ personList.get(index).toString());
        } else {
            System.out.println("Person with Id " + id + " not found.");
        }
      }
    }
}
