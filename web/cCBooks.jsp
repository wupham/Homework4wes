<!DOCTYPE html>
<%-- 
    Document   : thanks
    Created on : Dec 5, 2016, 11:30:06 AM
    Author     : nick
--%>
<!--Copyright © 2016 Wes Upham and Nick Richu-->


<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
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
    <th>Patron Name</th>
    <th>Email Address</th>
    <th>Book Title</th>
    <th>Due Date</th>
    <th>Overdue?</th>
    <th colspan="6"> </th>
  </tr>

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <td><b>Year</b><br><c:forEach var="i" begin="1" end="${users}">
            <c:out value="${users[i]}"/><br></c:forEach></p></td>
          <td><b>Value</b><br><c:forEach var="i" begin="1" end="${users}">
                    
  <tr>
    <td>${book.firstName}${book.lastName}</td>
    <td>${book.email}</td>
    <td>${book.bookTitle}</td>
    <td>${book.date}</td>
    <td>${book.overdue}</td>
    <td><input type="submit" value="Check In"></td>
  </tr>
  </c:forEach>

</table>
  <a href="index.jsp">Return to front page</a>
        </main>
        <footer>
            <p>	&copy;2016, Nick Richu</p>
        </footer>
            
    </body>
</html>