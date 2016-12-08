package csc3.Checkout;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import csc3.Book.Book;
//import csc3.Data.BookDB;
import csc3.Book.DateCalculator;
import static csc3.Book.DateCalculator.checkOverdue;
import static csc3.Book.DateCalculator.setDate;

import java.util.Date;
import csc3.Data.BookDB;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;


public class CheckoutServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp";
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.jsp";    // the "join" page
        } 
        else if (action.equals("manage")){
            //call the db for array list
            //set the request attribute request.setattribute("users", users)
            //url
            ArrayList<Book> users = BookDB.selectUsers();
            request.setAttribute("users", users);
            url = "/cCBooks.jsp";
            
        }
        else if (action.equals("delete")){
            
            String bookTitle = request.getParameter("bookTitle");
            BookDB.delete(bookTitle);
            
        }
        else if (action.equals("add")) {
            try {
                // get parameters from the request
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String email = request.getParameter("email");
                String bookTitle = request.getParameter("bookTitle");
                
                //String date = null;
                String duedate = setDate();
                
                
                String status = checkOverdue();
                
                
                // store data in Book object
                
                Book book = new Book(firstName, lastName, email, bookTitle, duedate, status);
                
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
            } catch (ParseException ex) {
                Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
