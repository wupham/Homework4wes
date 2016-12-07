package csc3.Data;

import csc3.Book.Book;
import java.sql.*;
import java.util.ArrayList;

public class BookDB {

    public static int insert(Book book) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO books (firstName, lastName, email, bookTitle, dueDate) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, book.getFirstName());
            ps.setString(2, book.getLastName());
            ps.setString(3, book.getEmail());
            ps.setString(4, book.getBookTitle());
            ps.setString(5, book.getDate());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int delete(Book book) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM book "
                + "WHERE bookTitle = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, book.getBookTitle());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static Book selectUser(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM User "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            Book book = null;
            if (rs.next()) {
                book = new Book();
                book.setFirstName(rs.getString("firstName"));
                book.setLastName(rs.getString("lastName"));
                book.setEmail(rs.getString("email"));
                book.setBookTitle(rs.getString("bookTitle"));
                book.setDate(rs.getString("dueDate"));
            }
            return book;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static ArrayList<Book> selectUsers() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM books";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Book> users = new ArrayList<Book>();
            while (rs.next())
            {
                Book book = new Book();
                book.setFirstName(rs.getString("FirstName"));
                book.setLastName(rs.getString("LastName"));
                book.setEmail(rs.getString("Email"));
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

