package csc3.Checkout;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import csc3.Book.Book;
import csc3.Data.BookDB;
import csc3.Book.Date;
import java.time.LocalDate;



//@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/cbook.jsp";
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/cbook.jsp";    // the "join" page
        } 
        else if (action.equals("add")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String bookTitle = request.getParameter("bookTitle");
            
            LocalDate date = null;
            date = Date.setDate(date);
            
            // store data in Book object
            
            Book book = new Book(firstName, lastName, email, bookTitle, date);

            // validate the parameters
            String message;
            if (firstName == null || lastName == null || email == null ||
                    bookTitle == null ||firstName.isEmpty() || 
                    lastName.isEmpty()|| email.isEmpty() || bookTitle.isEmpty()){
                message = "Please fill out all three text boxes.";
                url = "/cbook.jsp";
            } 
            else {
                message = "";
                url = "/thanks.jsp";
                BookDB.insert(book);
            }
            request.setAttribute("book", book);
            request.setAttribute("message", message);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}