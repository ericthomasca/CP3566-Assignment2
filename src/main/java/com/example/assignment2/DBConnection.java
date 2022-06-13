package com.example.assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection initDatabase() throws SQLException {
        return DriverManager.getConnection(
                BookDatabase.DB_URL,
                BookDatabase.USER,
                BookDatabase.PASS);
    }

    private static class BookDatabase {
        public static final String DB_URL = "jdbc:mariadb://localhost:3306/books";
        public static final String USER = "root";
        public static final String PASS = "Q5obBNgUy4";
        public static final String BOOK_TABLE_NAME = "titles";
        public static final String BOOK_COL_NAME_ISBN = "isbn";
        public static final String BOOK_COL_NAME_TITLE = "title";
        public static final String BOOK_COL_NAME_EDITION_NUMBER = "editionNumber";
        public static final String BOOK_COL_NAME_COPYRIGHT = "copyright";
    }
}
