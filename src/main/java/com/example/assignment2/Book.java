package com.example.assignment2;

import java.io.PrintStream;
import java.util.List;

/**
 * Store all book information.
 *
 * @author Eric Thomas
 */
public class Book {

    private String isbn;
    private String title;
    private int editionNumber;
    private String copyright;
    private List<Author> authorList;

    /**
     * Create a book
     *
     * @param isbn          isbn
     * @param title         book title
     * @param editionNumber edition number
     * @param copyright     copyright year
     */
    public Book(String isbn, String title, int editionNumber, String copyright) {
        this.isbn = isbn;
        this.title = title;
        this.editionNumber = editionNumber;
        this.copyright = copyright;
    }

    /**
     * Create a book with all the authors
     *
     * @param isbn          isbn
     * @param title         book title
     * @param editionNumber edition number
     * @param copyright     copyright year
     * @param authorList    list of authors
     */
    public Book(String isbn, String title, int editionNumber, String copyright, List<Author> authorList) {
        this(isbn, title, editionNumber, copyright);
        this.authorList = authorList;
    }

    /**
     * Get the ISBN
     *
     * @return isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Get the title
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the edition number as an integer
     *
     * @return edition number
     */
    public int getEditionNumber() {
        return editionNumber;
    }

    /**
     * Get the copyright
     *
     * @return copyright
     */
    public String getCopyright() {
        return copyright;
    }


}
