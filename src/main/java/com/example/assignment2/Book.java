package com.example.assignment2;

import java.io.PrintStream;

/**
 * Simple class to store all book information. The information will not change.
 *
 * @author Josh
 */
public class Book {

    private String isbn;
    private String title;
    private int editionNumber;
    private String copyright;
    //private List<Author> authorList;

    /**
     * Create a book
     * @param isbn
     * @param title
     * @param editionNumber
     * @param copyright
     */
    public Book(String isbn, String title, int editionNumber, String copyright) {
        this.isbn = isbn;
        this.title = title;
        this.editionNumber = editionNumber;
        this.copyright = copyright;
    }

    /**
     * Get the ISBN
     * @return isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Get the title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the edition number as an integer
     * @return edition number
     */
    public int getEditionNumber() {
        return editionNumber;
    }

    /**
     * Get the copyright
     * @return copyright
     */
    public String getCopyright() {
        return copyright;
    }

//    /**
//     * Get the list of Authors
//     * @return list of Authors
//     */
//    public List<Author> getAuthorList() {
//        return authorList;
//    }
//
//    /**
//     * Set the list of Authors
//     * @param authorList list of Authors
//     */
//    public void setAuthorList(List<Author> authorList) {
//        this.authorList = authorList;
//    }

    /**
     * Print out the book information
     * @param printStream
     */
    public void printBookInformation(PrintStream printStream){
        printStream.printf("\nISBN: %s \t\t Title: %-80s \t\t Edition #: %d \t\t Copyright: %s",
                this.getIsbn(), this.getTitle(), this.getEditionNumber(), this.getCopyright());
    }

}
