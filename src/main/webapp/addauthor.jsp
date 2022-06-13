<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 6/2/2022
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Java Library - Add Author</title>
    </head>
    <body>
        <h1>Add Author</h1>
        <br/>
        <form action="library-data" method="POST">
            <input type="hidden" id="form_type" name="form_type" value="author">
            <label>ID:
                <input type="text" name="id">
            </label>
            <br/>
            <label>First Name:
                <input type="text" name="first_name"/>
            </label>
            <br/>
            <label>Last Name:
                <input type="text" name="last_name"/>
            </label>
            <br/>
            <input type="submit" value="Submit"/>
        </form>
        <br/>
        <h3><a href="${pageContext.request.contextPath}/index.jsp">Home</a></h3>
    </body>
</html>
