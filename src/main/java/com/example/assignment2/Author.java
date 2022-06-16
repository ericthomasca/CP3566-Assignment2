package com.example.assignment2;

import java.util.List;

/**
 * A book author
 *
 * @author Eric Thomas
 */
public class Author {
    private final int id;
    private final String firstName;
    private final String lastName;

    /**
     * A book author
     *
     * @param id        author id
     * @param firstName author's first name
     * @param lastName  author's last name
     */
    public Author(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns author id
     *
     * @return author id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns author's first name
     *
     * @return author's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns author's last name
     *
     * @return author's last name
     */
    public String getLastName() {
        return lastName;
    }

}




