package Hw1Q3;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
//import linked list class
import java.util.LinkedList;
import java.util.stream.Stream;

import Hw1Q2.Person;

public class PersonList {
    
    //list variable on the class
    private LinkedList<Person> list;
    
    //constructor
    PersonList()
    {
        list = new LinkedList<Person>();
    }

    //Access method for the list
    public LinkedList<Person> getList()
    {
        return list;
    }

    //store method used in other question as method
    public void store (Scanner scanner)
    {
      while (scanner.hasNextLine()) {
          String[] parts = scanner.nextLine().split(",");
          list.add(new Person(parts[0], parts[1], Integer.parseInt(parts[2])));
      }
    }

    //display method used in other question as a method
    public void display (PrintStream outputStream)
    {
        for (int i = 0; i < list.size(); i++) { 
            outputStream.println(list.get(i).toString()); 
        }
    }

    //find function used in other question as a method
    public int find (int sid) 
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
}

class MyMainQ3 {
    public static void main(String[] args) throws FileNotFoundException {
      String fileName1, outFileName;
      File dataFile1, outFile;
      //Create the inital person list object
      PersonList personList = new PersonList();
      Scanner keyScanner = new Scanner(System.in);
      //Get neede files
      System.out.println("Please enter the input file name: ");
      fileName1 = keyScanner.nextLine();
      System.out.println("Please enter the output file name: ");
      outFileName = keyScanner.nextLine();		
      dataFile1 = new File(fileName1);
      outFile = new File(outFileName);
      Scanner fileScanner1 = new Scanner(dataFile1);
      PrintStream printer = new PrintStream(outFile);
      //Call store to fill the personList object
      personList.store(fileScanner1);
      System.out.println("Displaying all persons:");
      //Call display to print personList object on document
      personList.display(printer);
      int[] testIds = {12345, 67890, 11111};
      for (int id : testIds) {
        int index = personList.find(id);
        if (index != -1) {
            System.out.println("Person with Id " + id + " was found: "+ personList.getList().get(index).toString());
        } else {
            System.out.println("Person with Id " + id + " not found.");
        }
      }
    }
}
