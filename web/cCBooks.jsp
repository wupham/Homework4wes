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
            <h1>Users</h1>

<table>

  <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th colspan="3">Email</th>
  </tr>

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <c:forEach var="book" items="${book}">
  <tr>
    <td>${book.firstName}</td>
    <td>${book.lastName}</td>
    <td>${book.email}</td>
    <td><a href="userAdmin?action=display_user&amp;email=${book.email}">Update</a></td>
    <td><a href="userAdmin?action=delete_user&amp;email=${book.email}">Delete</a></td>
  </tr>
  </c:forEach>

</table>
        </main>
        <footer>
            <p>	&copy;2016, Nick Richu</p>
        </footer>
            
    </body>
</html>