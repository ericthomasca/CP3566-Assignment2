package com.example.assignment2;

import java.sql.SQLException;
import java.util.List;

public class DBTester {

    public static void main(String[] args) throws SQLException {
        System.out.println("Database Tester");

        List<Book> bookList = DBConnection.getAllBooks();
        List<Author> authorList = DBConnection.getAllAuthors();

        for (Book book: bookList) {
            book.printBookInformation(System.out);
        }

        System.out.println();
        System.out.println("Author Test");

        for(Author author: authorList) {
            author.printAuthorInformation(System.out);
        }


    }

}
