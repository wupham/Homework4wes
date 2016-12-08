/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc3.Book;

import java.util.ArrayList;
import csc3.Book.Book;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import javax.servlet.jsp.tagext.TagSupport;
/**
 *
 * @author wupham
 */
public class Library extends TagSupport {
private ArrayList<Book> books;
 
    
    
    	public void setBooks(ArrayList<Book> books) {
        this.books = books ;
    }
  
 @Override
    public int doStartTag() throws JspException {
      
 

        try {
            JspWriter out = pageContext.getOut();
            out.print(books);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
       
        return SKIP_BODY;
    }
}
