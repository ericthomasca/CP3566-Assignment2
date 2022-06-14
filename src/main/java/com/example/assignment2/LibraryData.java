package com.example.assignment2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/library-data")
public class LibraryData extends HttpServlet {

//    private String message;

//    public void init() {
//        message = "Library Servlet!";
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        //TODO Use a variable "view" to determine book or author query

        List<Book> bookList = DBConnection.getAllBooks();
        req.setAttribute("booklist", bookList);
        req.getRequestDispatcher("viewallbooks.jsp").forward(req, resp);

        //TODO add the list to the req

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        String isbn = req.getParameter("isbn");
        String title = req.getParameter("title");
        int editionNumber = Integer.parseInt(req.getParameter("edition_number"));
        String copyright = req.getParameter("copyright");
        Book newBook = new Book(isbn, title,editionNumber, copyright);

        //TODO Here I want to handle the New Author and New Book form posts


    }
}
