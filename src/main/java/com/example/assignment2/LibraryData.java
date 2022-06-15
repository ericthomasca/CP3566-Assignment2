package com.example.assignment2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Objects;

@WebServlet("/library-data")
public class LibraryData extends HttpServlet {


    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        LinkedList<Book> allBooks = null;
        try {
            allBooks = DBConnection.getAllBooks();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(allBooks);

        out.println("<h3>Welcome user</h3><br />");
        out.println("<p>" + allBooks + "</p>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String formType = req.getParameter("form_type");

        if (Objects.equals(formType, "book")) {
            String isbn = req.getParameter("isbn");
            String title = req.getParameter("title");
            int editionNumber = Integer.parseInt(req.getParameter("edition_number"));
            String copyright = req.getParameter("copyright");

            try {
                DBConnection.addBook(new Book(isbn, title, editionNumber, copyright));
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            writer.print("<html><body>");
            writer.print("<h1>Book Submitted!!</h1><br/>");
            writer.print("<h2>Book Details</h2><br/>");
            writer.print("ISBN: " + isbn + "<br/>");
            writer.print("Title: " + title + "<br/>");
            writer.print("Edition Number: " + editionNumber + "<br/>");
            writer.print("Copyright: " + copyright);
            writer.print("</body></html>");

        } else if (Objects.equals(formType, "author")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String firstName = req.getParameter("first_name");
            String lastName = req.getParameter("last_name");

            try {
                DBConnection.addAuthor(new Author(id, firstName, lastName));
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            writer.print("<html><body>");
            writer.print("<h3>Author Submitted!!</h3><br/>");
            writer.print("<h2>Author Details</h2><br/>");
            writer.print("ID: " + id + "<br/>");
            writer.print("First Name: " + firstName + "<br/>");
            writer.print("Last Name: " + lastName);
            writer.print("</body></html>");
        }
    }
}
