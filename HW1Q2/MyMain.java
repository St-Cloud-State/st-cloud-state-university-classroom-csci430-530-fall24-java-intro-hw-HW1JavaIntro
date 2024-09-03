/*
CSCI 430
Homework #1
Question #2
Class MyMain 
Written By: John Belair
*/

import java.util.LinkedList;
import java.io.*;

public class MyMain{

     public static void main(String[] args) {
        LinkedList<Person> personList = new LinkedList<>();
        String dataFile = "DataFile.csv";
        String sid;
        int personIndex;

        try{

          InputStream inputStream = new FileInputStream(dataFile);
          store(inputStream, personList);
          
          OutputStream outputStream = System.out;
          display(outputStream, personList);
        
          sid = "604";
          personIndex = find(sid, personList);
          System.out.println("Person 604 found at the index of: " + personIndex);

          sid = "902";
          personIndex = find(sid, personList);
          System.out.println("Person 902 found at the index of: " + personIndex);

          sid = "904";
          personIndex = find(sid, personList);
          System.out.println("Person 904 found at the index of: " + personIndex);

          sid = "503";
          personIndex = find(sid, personList);
          System.out.println("Person 503 found at the index of: " + personIndex);

          sid = "401";
          personIndex = find(sid, personList);
          System.out.println("Person 401 found at the index of: " + personIndex);

        }catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

     }

     public static void store(InputStream inputStream, LinkedList<Person> list) throws IOException{
          BufferedReader br = new BufferedReader(new FileReader("DataFile.csv"));
          String line;
          while ((line = br.readLine()) != null) {
               String[] data = line.split(",");
               Person person = new Person(data[0], data[1], data[2]);
               list.add(person);
          }
          br.close();
     }

     public static void display(OutputStream outputStream, LinkedList<Person> list){
          PrintWriter pr = new PrintWriter(new OutputStreamWriter(outputStream));
          for (Person person : list) {
               pr.println(person.toString());
          }
          pr.flush();
     }

     public static int find(String sid, LinkedList<Person> list){
          for (int i = 0; i < list.size(); i++){
               Person person = list.get(i);
               if (person.getID().equals(sid)){
                    return i;
               }
          }
          return -1;
     }
}