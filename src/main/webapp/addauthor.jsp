<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Java Library - Add Author</title>
    </head>
    <body>
        <h1>Add Author</h1>
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
        <h3><a href="index.jsp">Home</a></h3>
    </body>
</html>
