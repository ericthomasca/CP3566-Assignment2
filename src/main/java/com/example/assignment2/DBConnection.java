package com.example.assignment2;

import java.sql.*;
import java.util.LinkedList;

/**
 * Handles connections to the database
 *
 * @author Eric Thomas
 */
public class DBConnection {

    /**
     * Get a connection to the book database
     *
     * @return connection
     * @throws SQLException database connection issue
     */
    public static Connection initDatabase() throws SQLException {
        Driver driver = new org.mariadb.jdbc.Driver();
        DriverManager.registerDriver(driver);
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
        public static final String AUTHOR_COL_NAME_AUTHOR_ID = "authorID";
        public static final String AUTHOR_COL_NAME_FIRST_NAME = "firstName";
        public static final String AUTHOR_COL_NAME_LAST_NAME = "lastName";
    }

    /**
     * Retrieve all the books from the database into a LinkedList.
     *
     * @return List of Book objects
     */
    public static LinkedList<Book> getAllBooks() throws SQLException {
        LinkedList<Book> bookList = new LinkedList<>();
        Connection connection = initDatabase();
        Statement statement = connection.createStatement();

        String sqlQuery = "SELECT * from " + DBConnection.BookDatabase.BOOK_TABLE_NAME;
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        while (resultSet.next()) {
            bookList.add(
                new Book(
                    resultSet.getString(DBConnection.BookDatabase.BOOK_COL_NAME_ISBN),
                    resultSet.getString(DBConnection.BookDatabase.BOOK_COL_NAME_TITLE),
                    resultSet.getInt(DBConnection.BookDatabase.BOOK_COL_NAME_EDITION_NUMBER),
                    resultSet.getString(DBConnection.BookDatabase.BOOK_COL_NAME_COPYRIGHT)
                )
            );
        }
        return bookList;
    }

    /**
     * Retrieve all the authors from the database into a LinkedList.
     *
     * @return List of Author objects
     */
    public static LinkedList<Author> getAllAuthors() throws SQLException{
        Connection connection = initDatabase();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT * from " + BookDatabase.AUTHOR_TABLE_NAME;
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        LinkedList<Author> authorList = new LinkedList<>();
        while (resultSet.next()) {
            authorList.add(
                new Author(
                    resultSet.getInt(BookDatabase.AUTHOR_COL_NAME_AUTHOR_ID),
                    resultSet.getString(BookDatabase.AUTHOR_COL_NAME_FIRST_NAME),
                    resultSet.getString(BookDatabase.AUTHOR_COL_NAME_LAST_NAME)
                )
            );
        }
        return authorList;
    }

    /**
     * Add book to database
     *
     * @param book book
     */
    public static void addBook(Book book) throws SQLException{
        Connection connection = initDatabase();

        String query = "INSERT INTO " + BookDatabase.BOOK_TABLE_NAME + " VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, book.getIsbn());
        preparedStatement.setString(2, book.getTitle());
        preparedStatement.setInt(3, book.getEditionNumber());
        preparedStatement.setString(4, book.getCopyright());
        preparedStatement.executeUpdate();

        connection.close();
    }

    /**
     * Add author to database
     *
     * @param author author
     */
    public static void addAuthor(Author author) throws SQLException{
        Connection connection = initDatabase();

        String query = "INSERT INTO " + BookDatabase.AUTHOR_TABLE_NAME + " VALUES (default, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, author.getFirstName());
        preparedStatement.setString(2, author.getLastName());
        preparedStatement.executeUpdate();

        connection.close();
    }

}
