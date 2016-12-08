<!DOCTYPE html>
<%-- 
    Document   : thanks
    Created on : Dec 5, 2016, 11:30:06 AM
    Author     : nick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Frontpage Library</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/frontpage.css">
    </head>
    <body>
        <header>
            <img src="images/belk-02.jpg" alt="belk-pic" width="540" height="170">
            <h1>Belk Library</h1>
        </header>
        <main>
            <p>Thank you for your patrongage of the Belk Library. You've succesfully
            checked out the book, ${book.bookTitle}. Please note that this book is 
            due back on ${book.date}. A friendly email reminder will be sent to you if
            your book becomes overdue.</p>
            <a href="index.jsp">Return to front page</a>
        </main>
        <footer>
            <p>	&copy;2016, Nick Richu</p>
        </footer>
            
    </body>
</html>