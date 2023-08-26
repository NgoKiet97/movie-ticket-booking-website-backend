package com.example.movieticketbooking.utils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelperUtils {
    public String formatDateToString(Date date){
        Format formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(date);
    }
}
