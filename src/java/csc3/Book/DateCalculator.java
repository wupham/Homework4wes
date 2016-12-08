/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc3.Book;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCalculator {

    public static String dateFormat = "MM-dd-YYYY";
    public static SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

    public static String setDate() {
        Date dueDate = null;
        int noOfDays = 14;
        //String newDueDate = "";
        //change format of date: IMPORTANT

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        //Date today = new Date();
        calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
        dueDate = calendar.getTime();

        String newDueDate = sdf.format(dueDate);

        return newDueDate;
    }

    public static String checkOverdue() throws ParseException {
        java.sql.Date today = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        //java.sql.Date sqlDate = new java.sql.Date(today.getTime());
        java.sql.Date OriginalDueDate = returnDate();
        // java.sql.Date sqlDueDate = new java.sql.Date(dueDate.getTime());
        String status = "Overdue";
        if (today.before(OriginalDueDate)) {
            status = "Not overdue";
            return status;
        }
        return status;
    }

    public static java.sql.Date returnDate() {
        java.sql.Date logicalDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(logicalDate);
        c.add(Calendar.DATE, 14);
        java.sql.Date properDate = new java.sql.Date(c.getTimeInMillis());
        return properDate;
    }
   
}