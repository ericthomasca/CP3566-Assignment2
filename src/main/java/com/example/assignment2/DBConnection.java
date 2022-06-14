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
     * @throws SQLException can't connect to database
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
    public static LinkedList<Book> getAllBooks() {
        LinkedList<Book> bookList = new LinkedList<>();
        try (
                Connection connection = initDatabase();
                Statement statement = connection.createStatement()
        ) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    /**
     * Retrieve all the authors from the database into a LinkedList.
     *
     * @return List of Author objects
     */
    public static LinkedList<Author> getAllAuthors() {
        LinkedList<Author> authorList = new LinkedList<>();
        try (
                Connection connection = initDatabase();
                Statement statement = connection.createStatement()
        ) {
            String sqlQuery = "SELECT * from " + BookDatabase.AUTHOR_TABLE_NAME;
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                authorList.add(
                        new Author(
                                resultSet.getInt(BookDatabase.AUTHOR_COL_NAME_AUTHOR_ID),
                                resultSet.getString(BookDatabase.AUTHOR_COL_NAME_FIRST_NAME),
                                resultSet.getString(BookDatabase.AUTHOR_COL_NAME_LAST_NAME)
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authorList;
    }

    /**
     * Add book to database
     *
     * @param book book
     */
    public static void addBook(Book book) {
        try (
                Connection connection = initDatabase();
                Statement statement = connection.createStatement()
        ) {
            String query = "INSERT INTO " + BookDatabase.BOOK_TABLE_NAME +
                    " (" + BookDatabase.BOOK_COL_NAME_ISBN + ", " +
                    BookDatabase.BOOK_COL_NAME_TITLE + ", " +
                    BookDatabase.BOOK_COL_NAME_EDITION_NUMBER + ", " +
                    BookDatabase.BOOK_COL_NAME_COPYRIGHT + ") VALUES" +
                    " (" + book.getIsbn() + ", " +
                    book.getTitle() + ", " +
                    book.getEditionNumber() + ", " +
                    book.getCopyright() + ")";

            statement.executeUpdate(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Add author to database
     *
     * @param author author
     */
    public static void addAuthor(Author author) {
        try (
                Connection connection = initDatabase();
                Statement statement = connection.createStatement()
        ) {
            String query = "INSERT INTO " + BookDatabase.AUTHOR_TABLE_NAME +
                    " (" + "authorID" + ", " +
                    "firstName" + ", " +
                    "lastName" + ") VALUES" +
                    " (" + author.getId() + ", " +
                    author.getFirstName() + ", " +
                    author.getLastName() + ")";

            statement.executeUpdate(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
