package de.redstoneworld.redutilities.misc;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter {

    /**
     * This method returns the date object in the desired formatting.
     *
     * @param date (Date) the target date object
     * @param format (String) the format definition
     * @return (String) the formatted time string
     */
    public static String getTimeString(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    /**
     * This method returns the timestamp in the desired formatting.
     * 
     * @param timestamp (long) the target timestamp
     * @param format (String) the format definition
     * @return (String) the formatted time string
     */
    public static String getTimeString(long timestamp, String format) {
        Date date = new Date(timestamp);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }
    
}
