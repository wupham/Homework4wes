<!DOCTYPE html>
<%-- 
    Document   : index
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
            <h2>Checkout a book</h2>
            <form action="test" method="post">
        <input type="hidden" name="action" value="add">        
        <label class="pad_top">First Name:</label>
        <input type="text" name="firstName" value="${user.firstName}"><br>
        <label class="pad_top">Last Name:</label>
        <input type="text" name="lastName" value="${user.lastName}"><br>
        <label class="pad_top">Email:</label>
        <input type="email" name="email" value="${user.email}"><br>
        <label class="pad_top">Book Title:</label>
        <input type="text" name="bookTitle" value="${user.bookTitle}"><br>        
        <label>&nbsp;</label>
        <input type="submit" value="Checkout" class="margin_left">
    </form>
        </main>
        <footer>
            <p>	&copy;2016, Nick Richu</p>
        </footer>
            
    </body>
</html>