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

    /**
     * This method reforms the rational number spelling and convert it 
     * to a float number. Flexible inputs are allowed, which improves 
     * the usability.
     * 
     * @param cmdInput the rational number with one of all supported spellings
     * @return (float) the formatted rational number (decimal value)
     */
    public static float getRationalNumberValue(String cmdInput) {

        // replace decimal separator of DE
        cmdInput = cmdInput.replace(",", ".");

        // replace decimal input as short write-style without zero at beginning
        // (e.g. "/speed .4" --> "/speed 0.4")
        if (cmdInput.matches("^[-\\+]?[\\.,][0-9]+$")) {
            cmdInput = cmdInput.replace(".", "0.");
        }

        // convert the string to a float number
        return Float.parseFloat(cmdInput);
    }

    /**
     * This method outputs the rational number as a string.
     * The decimal separator remains at the point (".") .
     * 
     * @param floatValue the rational number
     * @return (String) the formatted string.
     */
    public static String getRationalNumberMsg(float floatValue) {
        return getRationalNumberMsg(floatValue, ".");
    }

    /**
     * This method outputs the rational number as a string.
     * The decimal separator remains at the point (".") .
     * 
     * @param doubleValue the rational number
     * @return (String) the formatted string.
     */
    public static String getRationalNumberMsg(Double doubleValue) {
        return getRationalNumberMsg(doubleValue, ".");
    }

    /**
     * This method outputs the rational number as a string.
     * The decimal separator can also be specified.
     * 
     * @param floatValue the rational number
     * @param decimalSeparator the decimal separator
     * @return (String) the formatted string.
     */
    public static String getRationalNumberMsg(float floatValue, String decimalSeparator) {
        return String.valueOf(floatValue).replace(".", decimalSeparator);
    }

    /**
     * This method outputs the rational number as a string.
     * The decimal separator can also be specified.
     * 
     * @param doubleValue the rational number
     * @param decimalSeparator the decimal separator
     * @return (String) the formatted string.
     */
    public static String getRationalNumberMsg(Double doubleValue, String decimalSeparator) {
        return String.valueOf(doubleValue).replace(".", decimalSeparator);
    }
    
}
