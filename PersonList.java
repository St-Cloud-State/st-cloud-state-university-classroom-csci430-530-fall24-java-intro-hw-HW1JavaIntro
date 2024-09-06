import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
//import linked list class
import java.util.LinkedList;
import java.util.stream.Stream;

public class PersonList {
    
    private LinkedList<Person> list;
    
    PersonList()
    {
        list = new LinkedList<Person>();
    }

    public LinkedList<Person> getList()
    {
        return list;
    }

    public void store (Scanner scanner)
    {
      while (scanner.hasNextLine()) {
          String[] parts = scanner.nextLine().split(",");
          list.add(new Person(parts[0], parts[1], Integer.parseInt(parts[2])));
      }
    }

    public void display (PrintStream outputStream)
    {
        for (int i = 0; i < list.size(); i++) { 
            outputStream.println(list.get(i).toString()); 
        }
    }
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
      boolean hasNext1 = false, hasNext2 = false;
      PersonList personList = new PersonList();
      Scanner keyScanner = new Scanner(System.in);
      System.out.println("Please enter the input file name: ");
      fileName1 = keyScanner.nextLine();
      System.out.println("Please enter the output file name: ");
      outFileName = keyScanner.nextLine();		
      dataFile1 = new File(fileName1);
      outFile = new File(outFileName);
      Scanner fileScanner1 = new Scanner(dataFile1);
      PrintStream printer = new PrintStream(outFile);
      personList.store(fileScanner1);
      System.out.println("Displaying all persons:");
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
