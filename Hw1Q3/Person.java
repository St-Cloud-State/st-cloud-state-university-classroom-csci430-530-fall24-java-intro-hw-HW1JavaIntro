package Hw1Q3;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
//import linked list class
import java.util.LinkedList;

public class Person {

  //variable fields
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
    //store all read items into the list
    public static void store (Scanner scanner, LinkedList<Person> list)
    {
      //loop through while still lines in the code
      while (scanner.hasNextLine()) {
          String[] parts = scanner.nextLine().split(",");
          list.add(new Person(parts[0], parts[1], Integer.parseInt(parts[2])));
      }
    }

    //display the list to the output stream
    public static void display (PrintStream outputStream, LinkedList<Person> list)
    {
        //for each item in the list print the item
        for (int i = 0; i < list.size(); i++) { 
            outputStream.println(list.get(i).toString()); 
        }
    }
    //find the item in the list based on the id
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
      LinkedList<Person> personList = new LinkedList<>();
      Scanner keyScanner = new Scanner(System.in);
      //Get both of the files needed
      System.out.println("Please enter the input file name: ");
      fileName1 = keyScanner.nextLine();
      System.out.println("Please enter the output file name: ");
      outFileName = keyScanner.nextLine();		
      dataFile1 = new File(fileName1);
      outFile = new File(outFileName);
      Scanner fileScanner1 = new Scanner(dataFile1);
      PrintStream printer = new PrintStream(outFile);
      //Call the store function
      store(fileScanner1, personList);
      System.out.println("Displaying all persons:");
      //Call the display function the file
      display(printer, personList);
      //Create a list of Id to test find function
      int[] testIds = {12345, 67890, 11111};
      //loop through all id for the find fucntion
      for (int id : testIds) {
        int index = find(id, personList);
        if (index != -1) {
            //print function of found person
            System.out.println("Person with Id " + id + " was found: "+ personList.get(index).toString());
        } else {
            //if person wasnt found tell user
            System.out.println("Person with Id " + id + " not found.");
        }
      }
    }
}
