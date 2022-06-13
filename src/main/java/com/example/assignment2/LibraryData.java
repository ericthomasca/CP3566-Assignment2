package com.example.assignment2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "libraryData", value = "/library-data")
public class LibraryData extends HttpServlet {

    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String formType = req.getParameter("form_type");

        if (Objects.equals(formType, "book")) {
            String isbn = req.getParameter("isbn");
            String title = req.getParameter("title");
            int editionNumber = Integer.parseInt(req.getParameter("edition_number"));
            String copyright = req.getParameter("copyright");

            writer.print("<html><body>");
            writer.print("<h1>Book Details</h1><br/>");
            writer.print("ISBN: "+ isbn + "<br/>");
            writer.print("Title: "+ title +"<br/>");
            writer.print("Edition Number: "+ editionNumber +"<br/>");
            writer.print("Copyright: "+ copyright);
            writer.print("</body></html>");

        } else if (Objects.equals(formType, "author")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String firstName = req.getParameter("first_name");
            String lastName = req.getParameter("last_name");

            writer.print("<html><body>");
            writer.print("<h3>Author Details</h3><br/>");
            writer.print("ID: "+ id + "<br/>");
            writer.print("First Name: "+ firstName +"<br/>");
            writer.print("Last Name: "+ lastName);
            writer.print("</body></html>");

        } else {
            System.out.println("Problem with form type");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.print("<html><body>");
        writer.print("<h3>Author Details</h3><br/>");
        writer.print("ID: T3ST <br/>");
        writer.print("First Name: Testie <br/>");
        writer.print("Last Name: Tester");
        writer.print("</body></html>");
    }

    public void destroy() {
    }
}