<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <link href="https://unpkg.com/nes.css@latest/css/nes.min.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Press+Start+2P" rel="stylesheet">
        <title>Java Library - Add Book</title>
    </head>
    <body>
        <h1>Add Book</h1>
        <form action="library-data" method="POST">
            <input type="hidden" id="form_type" name="form_type" value="book">
            <label>ISBN:
                <input type="text" name="isbn">
            </label>
            <br/>
            <label>Title:
                <input type="text" name="title"/>
            </label>
            <br/>
            <label>Edition Number:
                <input type="text" name="edition_number"/>
            </label>
            <br/>
            <label>Copyright:
                <input type="text" name="copyright"/>
            </label>
            <br/>
            <input type="submit" value="Add Book"/>
        </form>
        <h3><a href="index.jsp">Home</a></h3>
    </body>
</html>
