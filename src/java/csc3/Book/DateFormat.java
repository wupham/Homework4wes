package csc3.Book;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;

public class DateFormat {

    public static void main(String[] args) {

        Calendar calendar = GregorianCalendar.getInstance();
        Date today = new Date();
        System.out.println("Today with Date is " + calendar.getTime());
        calendar.add(Calendar.WEEK_OF_YEAR, 2);
        System.out.println("Today with Calendar is " + calendar.getTime());
        Date dueDate = calendar.getTime();
        System.out.println("Due date is: " + dueDate);
        //Date has a before and after method
        if (today.before(dueDate)) {
            System.out.println("Book is not due");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        String prettyDate = sdf.format(dueDate);
        System.out.println(prettyDate);
        //Making a java.sql.Date from a java.util.date

        java.sql.Date sqlDate = new java.sql.Date(today.getTime());
        System.out.println("Java Sql date is " + sqlDate);
        

        //Making a java.util.Date from a java.sql.Date

        java.util.Date utilDate = new java.util.Date(sqlDate.getTime());

        System.out.println("Java Util date is " + sqlDate);

        

    }



}