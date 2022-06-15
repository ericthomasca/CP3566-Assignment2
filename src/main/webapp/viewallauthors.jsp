<%@ page import="java.util.List" %>
<%@ page import="com.example.assignment2.Book" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="com.example.assignment2.Author" %>
<%@ page import="com.example.assignment2.DBConnection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>View all Authors</title>
    </head>
    <body>
        <h1>All Books From Database</h1>

        <%
            LinkedList<Author> authorList = null;
            try {
                authorList = DBConnection.getAllAuthors();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        %>

        <table>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
            </tr>

            <%
                for (Author author : authorList) {
                    out.println("<tr>");
                    out.println("<td>" + author.getId() + "</td>");
                    out.println("<td>" + author.getFirstName() + "</td>");
                    out.println("<td>" + author.getLastName() + "</td>");
                    out.println("</tr>");
                }
            %>

        </table>
    </body>
</html>
