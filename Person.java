// Person.java
public class Person {
    private String firstName;  // First name of the person
    private String lastName;   // Last name of the person
    private String id;         // Unique ID for the person

    // Constructor to initialize Person object with firstName, lastName, and id
    public Person(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    // Accessor method for firstName
    public String getFirstName() {
        return firstName;
    }

    // Accessor method for lastName
    public String getLastName() {
        return lastName;
    }

    // Accessor method for id
    public String getId() {
        return id;
    }

    // Overriding the toString() method to provide a string representation of a Person
    @Override
    public String toString() {
        return "Person [ID=" + id + ", First Name=" + firstName + ", Last Name=" + lastName + "]";
    }
}
