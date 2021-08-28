package main.java;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class PlayDate {
    public static void main(String[] args) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
////        String expireDate = simpleDateFormat.format(LocalDateTime.now().plusYears(5));
//        String expireDate;
//        Calendar c = Calendar.getInstance();
//        Date currentDate = new Date();
//        c.setTime(currentDate);
//        c.add(Calendar.YEAR, 1);
//        String date = simpleDateFormat.format(c);
//        System.out.println(date);
//        DateTimeFormatter newPattern = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        //LocalDateTime datetime = LocalDateTime.now().plusYears(1);
        String output = LocalDateTime.now().plusYears(1).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(output);

      }
}
