package csc3.Data;

import csc3.Book.Book;
import java.sql.*;
import java.util.ArrayList;
import static csc3.Book.DateCalculator.returnDate;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BookDB {

    public static int insert(Book book) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO w.books (firstName, lastName, email, bookTitle, dueDate) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, book.getFirstName());
            ps.setString(2, book.getLastName());
            ps.setString(3, book.getEmail());
            ps.setString(4, book.getBookTitle());
            String wes = book.toString();
            System.out.println(wes);
            ps.setDate(5, returnDate());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int delete(String bookTitle) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM books "
                + "WHERE bookTitle = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, bookTitle);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }    
    public static ArrayList<Book> selectUsers() throws ParseException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM w.books";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Book> users = new ArrayList<Book>();
            while (rs.next())
            {
                Book book = new Book();
                book.setFirstName(rs.getString("firstName"));
                book.setLastName(rs.getString("lastName"));
                book.setEmail(rs.getString("email"));
                book.setBookTitle(rs.getString("bookTitle"));
                book.setDate(rs.getString("dueDate"));
                Date todayDate = null;
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                todayDate = calendar.getTime();
                 String dueDate = book.getDate();
                 String dateFormat = "MM-dd-YYYY";
                
                 SimpleDateFormat df = new SimpleDateFormat(dateFormat);
                 Date newDueDate = df.parse(dueDate);
                 String status = "";
                 System.out.println(todayDate + "<-CHECK"  + "CHECK->" +newDueDate);
                 if (todayDate.after(newDueDate)){
                     status = "Not Overdue";
                 }
                 book.setStatus(status);
                 users.add(book);
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }    
}

