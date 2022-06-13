package com.example.assignment2;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Handles connections to the database
 * @author Eric Thomas
 */
public class DBConnection {

    /**
     * Get a connection to the book database
     * @return connection
     * @throws SQLException can't connect to database
     */
    public static Connection initDatabase() throws SQLException {
        return DriverManager.getConnection(
                BookDatabase.DB_URL,
                BookDatabase.USER,
                BookDatabase.PASS);
    }

    /**
     * Inner class for database information
     */
    private static class BookDatabase {
        public static final String DB_URL = "jdbc:mariadb://localhost:3306/books";
        public static final String USER = "root";
        public static final String PASS = "Q5obBNgUy4";

        public static final String BOOK_TABLE_NAME = "titles";
        public static final String BOOK_COL_NAME_ISBN = "isbn";
        public static final String BOOK_COL_NAME_TITLE = "title";
        public static final String BOOK_COL_NAME_EDITION_NUMBER = "editionNumber";
        public static final String BOOK_COL_NAME_COPYRIGHT = "copyright";

        public static final String AUTHOR_TABLE_NAME = "authors";
        public static final String BOOK_COL_NAME_AUTHOR_ID = "authorID";
        public static final String BOOK_COL_NAME_FIRST_NAME = "firstName";
        public static final String BOOK_COL_NAME_LAST_NAME = "lastName";
    }

//    /**
//     * Retrieve all the books from the database into a LinkedList.
//     * Note: this method is dangerous if the database is large. In our example it isn't.
//     * @return List of Book objects
//     */
//    public static List<Book> getAllBooks(){
//        LinkedList bookList = new LinkedList();
//        try (
//                Connection connection = getBooksDBConnection();
//                Statement statement = connection.createStatement();
//        ) {
//            String sqlQuery = "SELECT * from " + DBConnection2.BooksDatabaseSQL.BOOK_TABLE_NAME;
//            ResultSet resultSet = statement.executeQuery(sqlQuery);
//
//            while(resultSet.next()) {
//                bookList.add(
//                        new Book(
//                                resultSet.getString(DBConnection2.BooksDatabaseSQL.BOOK_COL_NAME_ISBN),
//                                resultSet.getString(DBConnection2.BooksDatabaseSQL.BOOK_COL_NAME_TITLE),
//                                resultSet.getInt(DBConnection2.BooksDatabaseSQL.BOOK_COL_NAME_EDITION_NUMBER),
//                                resultSet.getString(DBConnection2.BooksDatabaseSQL.BOOK_COL_NAME_COPYRIGHT)
//                        )
//                );
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return bookList;
//    }
}
