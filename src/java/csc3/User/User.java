package csc3.User;

import java.io.Serializable;

public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String bookTitle;

    public User() {
        firstName = "";
        lastName = "";
        email = "";
        bookTitle= "";
    }

    public User(String firstName, String lastName, String email, String bookTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.bookTitle = bookTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
}
