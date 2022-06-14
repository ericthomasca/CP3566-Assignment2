package com.example.assignment2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "libraryData", value = "/library-data")
public class LibraryData extends HttpServlet {

    private String message;
    public void init() {
        message = "Library Servlet!";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        //TODO Use a variable "view" to determine book or author query

        List<Book> bookList = DBConnection.getAllBooks();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewallbooks.jsp");

        request.setAttribute("booklist", bookList);

        //TODO add the list to the request
        requestDispatcher.forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        //TODO Here I want to handle the New Author and New Book form posts


    }
}
