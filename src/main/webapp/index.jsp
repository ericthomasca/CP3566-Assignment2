<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Java Library</title>
    </head>
    <body>
        <h1>Java Library</h1>
        <br/>
        <ul>
            <li><a href="${pageContext.request.contextPath}/addbook.jsp">Add Book</a>
            </li>
            <li><a href="${pageContext.request.contextPath}/addauthor.jsp">Add Author</a>
            </li>
            <li><a href="library-data">View Books</a>
            </li>
            <li><a href="library-data">View Authors</a>
            </li>
        </ul>
    </body>
</html>