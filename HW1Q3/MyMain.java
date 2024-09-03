/*
CSCI 430
Homework #1
Question #3
Class MyMain
Written By: John Belair
*/

import java.io.*;

public class MyMain{

    public static void main(String[] args) {
        PersonList personList = new PersonList();
        String sid;
        int personIndex;

        try{
            InputStream inputStream = new FileInputStream("DataFile.csv");
            personList.store(inputStream);

            personList.display(System.out);

            sid = "604";
            personIndex = personList.find(sid);
            System.out.println("Person 604 found at the index of: " + personIndex);

            sid = "902";
            personIndex = personList.find(sid);
            System.out.println("Person 902 found at the index of: " + personIndex);

            sid = "904";
            personIndex = personList.find(sid);
            System.out.println("Person 904 found at the index of: " + personIndex);

            sid = "503";
            personIndex = personList.find(sid);
            System.out.println("Person 503 found at the index of: " + personIndex);

            sid = "401";
            personIndex = personList.find(sid);
            System.out.println("Person 401 found at the index of: " + personIndex);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}