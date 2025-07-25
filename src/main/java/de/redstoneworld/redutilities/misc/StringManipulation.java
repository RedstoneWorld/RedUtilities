package de.redstoneworld.redutilities.misc;

public class StringManipulation {

    /**
     * This method removes the whitespaces at the end of the specified String.
     *
     * @param input (String) the original String
     * @return the new String
     */
    public static String removeWhitespaceEnd(String input) {
        return input.replaceAll("\\s+$", "");
    }

}
