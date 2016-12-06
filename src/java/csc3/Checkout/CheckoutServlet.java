package csc3.Checkout;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import csc3.User.User;


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
            String firstName = request.getParameter("FirstName");
            String lastName = request.getParameter("LastName");
            String email = request.getParameter("Email");
            
            // store data in User object
            User user = new User(firstName, lastName, email, bookTitle);

            // validate the parameters
            String message;
            if (firstName == null || lastName == null || email == null ||
                firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                message = "Please fill out all three text boxes.";
                url = "/cbook.jsp";
            } 
            else {
                message = "";
                url = "/thanks.jsp";
               
            }
            request.setAttribute("user", user);
            request.setAttribute("message", message);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}