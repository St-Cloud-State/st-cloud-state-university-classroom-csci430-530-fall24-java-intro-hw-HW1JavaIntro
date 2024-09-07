/*
CSCI 430
Homework #1
Question #2
Data Type Person
Written By: John Belair
*/

public class Person{
    private String firstName;
    private String lastName;
    private String id;

    public Person(String firstName, String lastName, String id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getID(){
        return id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setID(String id){
        this.id = id;
    }

    @Override public String toString() {
        return "Person:" + "\n  -First Name: " + firstName + "\n  -Last Name: " + lastName + "\n  -ID: " + id;
    }
}