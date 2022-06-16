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

        //LOAD BOOKS
        LinkedList<Book> bookList;
        try {
            bookList = DBConnection.getAllBooks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //PRINT HEADERS
        out.println("<h1>Books</h1><br />");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>ISBN</th>");
        out.println("<th>Title</th>");
        out.println("<th>Edition</th>");
        out.println("<th>Copyright</th>");
        out.println("</tr>");

        // PRINT BOOKS
        for (Book book : bookList) {
            out.println("<tr>");
            out.println("<td>" + book.getIsbn() + "</td>");
            out.println("<td>" + book.getTitle() + "</td>");
            out.println("<td>" + book.getEditionNumber() + "</td>");
            out.println("<td>" + book.getCopyright() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("<br /><br />");

        // LOAD AUTHORS
        LinkedList<Author> authorList;
        try {
            authorList = DBConnection.getAllAuthors();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // PRINT HEADERS
        out.println("<h1>Authors</h1><br />");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>First Name</th>");
        out.println("<th>Last Name</th>");
        out.println("</tr>");

        // PRINT AUTHORS
        for (Author author: authorList) {
            out.println("<tr>");
            out.println("<td>" + author.getId() + "</td>");
            out.println("<td>" + author.getFirstName() + "</td>");
            out.println("<td>" + author.getLastName() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("<br /><br />");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String formType = req.getParameter("form_type");

        if (Objects.equals(formType, "book")) {
            String isbn = req.getParameter("isbn");
            String title = req.getParameter("title");
            int editionNumber = Integer.parseInt(req.getParameter("edition_number"));
            String copyright = req.getParameter("copyright");

            try {
                DBConnection.addBook(new Book(isbn, title, editionNumber, copyright));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            out.print("<html><body>");
            out.print("<h1>Book Submitted!!</h1><br/>");
            out.print("<h2>Book Details</h2><br/>");
            out.print("ISBN: " + isbn + "<br/>");
            out.print("Title: " + title + "<br/>");
            out.print("Edition Number: " + editionNumber + "<br/>");
            out.print("Copyright: " + copyright);
            out.print("</body></html>");

        } else if (Objects.equals(formType, "author")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String firstName = req.getParameter("first_name");
            String lastName = req.getParameter("last_name");

            try {
                DBConnection.addAuthor(new Author(id, firstName, lastName));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            out.print("<html><body>");
            out.print("<h3>Author Submitted!!</h3><br/>");
            out.print("<h2>Author Details</h2><br/>");
            out.print("ID: " + id + "<br/>");
            out.print("First Name: " + firstName + "<br/>");
            out.print("Last Name: " + lastName);
            out.print("</body></html>");
        }
    }
}
