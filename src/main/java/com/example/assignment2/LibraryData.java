package com.example.assignment2;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String view = req.getParameter("view");

        if (Objects.equals(view, "books")) {
            LinkedList<Book> bookList;
            try {
                bookList = DBConnection.getAllBooks();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            out.println("<h1>Books</h1>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>ISBN</th>");
            out.println("<th>Title</th>");
            out.println("<th>Edition</th>");
            out.println("<th>Copyright</th>");
            out.println("</tr>");

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

        } else if (Objects.equals(view, "authors")) {
            LinkedList<Author> authorList;
            try {
                authorList = DBConnection.getAllAuthors();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            out.println("<h1>Authors</h1>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>First Name</th>");
            out.println("<th>Last Name</th>");
            out.println("</tr>");

            for (Author author: authorList) {
                out.println("<tr>");
                out.println("<td>" + author.getId() + "</td>");
                out.println("<td>" + author.getFirstName() + "</td>");
                out.println("<td>" + author.getLastName() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");

        } else {
            out.println("<h1>No data for \"" + view + "\" in database.</h1>");
            out.println("<h3><a href=\"index.jsp\">Home</a></h3>");
        }
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

            out.println("<html><body>");
            out.println("<h1>Book Submitted!!</h1>");
            out.println("<h2>Book Details</h2>");
            out.println("ISBN: " + isbn + "<br/>");
            out.println("Title: " + title + "<br/>");
            out.println("Edition Number: " + editionNumber + "<br/>");
            out.println("Copyright: " + copyright);
            out.println("</body></html>");

        } else if (Objects.equals(formType, "author")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String firstName = req.getParameter("first_name");
            String lastName = req.getParameter("last_name");

            try {
                DBConnection.addAuthor(new Author(id, firstName, lastName));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            out.println("<html><body>");
            out.println("<h1>Author Submitted!!</h1>");
            out.println("<h2>Author Details</h2>");
            out.println("ID: " + id + "<br/>");
            out.println("First Name: " + firstName + "<br/>");
            out.println("Last Name: " + lastName);
            out.println("</body></html>");
        } else {
            out.println("<h1>Incorrect form type.</h1>");
        }

    }
}
