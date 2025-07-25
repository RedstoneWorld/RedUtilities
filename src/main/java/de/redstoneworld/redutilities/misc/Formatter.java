package de.redstoneworld.redutilities.misc;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Formatter {

    /**
     * This method returns the date object in the desired formatting.
     *
     * @param date (Date) the target date object
     * @param format (String) the format definition (based of the SimpleDateFormat)
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
     * @param format (String) the format definition (based of the SimpleDateFormat)
     * @return (String) the formatted time string
     */
    public static String getTimeString(long timestamp, String format) {
        Date date = new Date(timestamp);

        return getTimeString(date, format);
    }

    /**
     * This method reforms the rational number spelling and convert it
     * to a double number. Flexible inputs are allowed, which improves
     * the usability.
     *
     * @param cmdInput the rational number with one of all supported spellings
     * @return (double) the formatted rational number (decimal value)
     */
    public static double getRationalNumberValue(String cmdInput) {

        // replace decimal separator of DE
        cmdInput = cmdInput.replace(",", ".");

        // replace decimal input as short write-style without zero at beginning
        // (e.g. "/speed .4" --> "/speed 0.4")
        if (cmdInput.matches("^[-\\+]?[\\.,][0-9]+$")) {
            cmdInput = cmdInput.replace(".", "0.");
        }

        // convert the string to a double number
        return Double.parseDouble(cmdInput);
    }

    /**
     * This method outputs the rational number as a string.
     *
     * This method uses the provided {@link Locale} to format the number according to
     * its specific decimal separator, digit grouping logic and the grouping separator.
     *
     * Example:
     * <ul>
     *   <li>Germany (de_DE): 12.345.678,9</li>
     *   <li>US (en_US): 12,345,678.9</li>
     *   <li>India (hi_IN): 1,23,45,678.9</li>
     * </ul>
     *
     * Large numeric values (such as values >= 10 million) are formatted in standard decimal form,
     * not scientific notation (e.g., "10000000" instead of "1.0E7"), ensuring readability.
     *
     * @param locale (Locale) the Locale object for the specific micro-typography
     * @param floatValue (float) the rational number
     * @param grouping (boolean) Should the character grouping be used?
     * @param minFractionDigits (int) The minimum number of decimal digits to show
     * @return (String) the formatted string
     */
    public static String getRationalNumberMsg(Locale locale, float floatValue, boolean grouping, int minFractionDigits) {
        NumberFormat nf = NumberFormat.getNumberInstance(locale);
        nf.setGroupingUsed(grouping);
        nf.setMaximumFractionDigits(10);
        nf.setMinimumFractionDigits(minFractionDigits);

        return nf.format(floatValue);
    }

    /**
     * This method outputs the rational number as a string.
     *
     * This method uses the provided {@link Locale} to format the number according to
     * its specific decimal separator, digit grouping logic and the grouping separator.
     *
     * Example:
     * <ul>
     *   <li>Germany (de_DE): 12.345.678,9</li>
     *   <li>US (en_US): 12,345,678.9</li>
     *   <li>India (hi_IN): 1,23,45,678.9</li>
     * </ul>
     *
     * Large numeric values (such as values >= 10 million) are formatted in standard decimal form,
     * not scientific notation (e.g., "10000000" instead of "1.0E7"), ensuring readability.
     *
     * @param locale (Locale) the Locale object for the specific micro-typography
     * @param doubleValue (double) the rational number
     * @param grouping (boolean) Should the character grouping be used?
     * @param minFractionDigits (int) The minimum number of decimal digits to show
     * @return (String) the formatted string
     */
    public static String getRationalNumberMsg(Locale locale, double doubleValue, boolean grouping, int minFractionDigits) {
        NumberFormat nf = NumberFormat.getNumberInstance(locale);
        nf.setGroupingUsed(grouping);
        nf.setMaximumFractionDigits(10);
        nf.setMinimumFractionDigits(minFractionDigits);

        return nf.format(doubleValue);
    }

}