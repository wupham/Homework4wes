/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc3.Book;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.text.SimpleDateFormat;

public class Date {
    public static LocalDate setDate(LocalDate today){
        
    //change format of date: IMPORTANT
    String dateFormat = "dd/MM/yyyy";
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    
        today = LocalDate.now();
        LocalDate next2Week = today.plus(2, ChronoUnit.WEEKS);
        System.out.println(sdf.format(next2Week));
        return next2Week;
        }
    }

