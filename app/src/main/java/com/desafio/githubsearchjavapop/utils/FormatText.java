package com.desafio.githubsearchjavapop.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatText {

    public static String formatDate(String date){
        SimpleDateFormat apiType = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat presentationType = new SimpleDateFormat("dd/MM/yyyy");
        String formatDate = "";
        try {
            Date dateT = apiType.parse(date);
            formatDate = presentationType.format(dateT);
        } catch (ParseException e) {
            e.getMessage();
        }
        return formatDate;
    }
}
