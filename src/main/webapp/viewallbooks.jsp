<%@ page import="com.example.assignment2.Book" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="com.example.assignment2.DBConnection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>View all Books</title>
    </head>
    <body>
        <h1>All Books From Database</h1>

        <%
            LinkedList<Book> bookList = null;
            try {
                bookList = DBConnection.getAllBooks();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        %>

        <table>
            <tr>
                <th>ISBN</th>
                <th>Title</th>
                <th>Edition</th>
                <th>Copyright</th>
            </tr>

            <%
                for (Book book : bookList) {
                    out.println("<tr>");
                    out.println("<td>" + book.getIsbn() + "</td>");
                    out.println("<td>" + book.getTitle() + "</td>");
                    out.println("<td>" + book.getEditionNumber() + "</td>");
                    out.println("<td>" + book.getCopyright() + "</td>");
                    out.println("</tr>");
                }
            %>

        </table>
    </body>
</html>
