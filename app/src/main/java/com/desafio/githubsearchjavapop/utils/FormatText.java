package com.desafio.githubsearchjavapop.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatText {

    public static String formatDate(String date){
        SimpleDateFormat serverType = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat userType = new SimpleDateFormat("dd/MM/yyyy");
        String formatDate = "";
        try {
            Date dateT = serverType.parse(date);
            formatDate = userType.format(dateT);
        } catch (ParseException e) {

        }
        return formatDate;
    }
}
