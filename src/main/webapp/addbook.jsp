<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 6/2/2022
  Time: 4:44 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Java Library - Add Book</title>
</head>
<body>
    <h1>Add Book</h1>
    <br />
    <form action="library-data" method="POST">
        <input type="hidden" id="form_type" name="form_type" value="book">
        <label>ISBN:
            <input type="text" name="isbn">
        </label>
        <br/>
        <label>Title:
            <input type="text" name="title"/>
        </label>
        <br />
        <label>Edition Number:
            <input type="text" name="edition_number"/>
        </label>
        <br />
        <label>Copyright:
            <input type="text" name="copyright"/>
        </label>
        <br />
        <input type="submit" value="Add Book"/>
    </form>
    <br />
    <h3><a href="index.jsp">Home</a></h3>
</body>
</html>
