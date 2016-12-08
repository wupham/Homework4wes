<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>Frontpage Library</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/cbook.css">
    </head>
    <body>
        <header>
            <img src="images/belk-02.jpg" alt="belk-pic" width="540" height="170">
            <h1>Belk Library</h1>
        </header>
        <main>
            <h2>Checkout a book</h2>
            <form action="checkout" method="post">
        <input type="hidden" name="action" value="add">        
        <label class="firstName">First Name:</label>
        <input type="text" name="firstName" value="${book.firstName}" required><br>
        <label class="lastName">Last Name:</label>
        <input type="text" name="lastName" value="${book.lastName}" required><br>
        <label class="email">Email:</label>
        <input type="email" name="email" value="${book.email}" required><br>
        <label class="bookTitle">Book Title:</label>
        <input class ="bookTitle2" type="text" name="bookTitle" value="${book.bookTitle}" required><br>        
        <label>&nbsp;</label>
        <input type="submit" value="Checkout" class="checkout">
    </form>
        </main>
        <footer>
            <p>	&copy;2016, Nick Richu & Wes Upham</p>
        </footer>
            
    </body>
</html>