/*
CSCI 430
Homework #1
Question #3
Data Type PersonList
Written By: John Belair
*/

import java.util.LinkedList;
import java.io.*;

public class PersonList{
    private LinkedList<Person> list;

    public PersonList() {
        list = new LinkedList<>();
    }

    public void store(InputStream inputStream) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
          String line;
          while ((line = br.readLine()) != null) {
               String[] data = line.split(",");
               String firstName = data[0].trim();
               String lastName = data[1].trim();
               String id = data[2].trim();
               list.add(new Person(firstName, lastName, id));
          }
     }

     public void display(PrintStream outputStream){
          for (Person person : list) {
               outputStream.println(person);
          }
     }

     public int find(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}