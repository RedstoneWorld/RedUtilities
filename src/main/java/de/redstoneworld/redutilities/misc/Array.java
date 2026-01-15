package de.redstoneworld.redutilities.misc;

import java.util.Arrays;

public class Array {

    /**
     * This method merges the Strings of a String array and outputs them as
     * a single String. The individual parts are connected with the separator.
     *
     * @param prefix (String) prefix for the result String
     * @param array (String[]) the String array, which is to be merged
     * @param separator (String) the separator
     * @return the result String; the prefix only if the array is empty
     */
    public static String appendStringArray(String prefix, String[] array, String separator) {
        if (array.length == 0) return prefix;

        StringBuilder targetString = new StringBuilder(prefix + array[0]);

        for (int i = 1; i <= (array.length - 1); i++) {
            targetString.append(separator).append(array[i]);
        }

        return targetString.toString();
    }

    /**
     * This method shifts a String array with the target amount of shifts and create
     * a new one with the rest of it.
     *
     * @param array (String[]) the original String array
     * @param shiftAmount (int) amount of shifts
     * @return a new array with the rest
     */
    public static String[] shiftArray(String[] array, int shiftAmount) {
        return Arrays.stream(array).skip(shiftAmount).toArray(String[]::new);
    }

    /**
     * This method concatenates two String arrays linear.
     *
     * @param array1 (String[]) 1. Array
     * @param array2 (String[]) 2. Array
     * @return a new array with the double size
     */
    public static String[] mergeArrays(String[] array1, String[] array2) {

        if (array1.length == 0) return array2;
        if (array2.length == 0) return array1;
        
        String splitSeparator = ":::redutilities-split:::";
        
        String mergedString = appendStringArray("", array1, splitSeparator) + splitSeparator 
                + appendStringArray("", array2, splitSeparator);
        return mergedString.split(splitSeparator);
    }

}
