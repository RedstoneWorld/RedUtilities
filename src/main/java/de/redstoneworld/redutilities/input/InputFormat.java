package de.redstoneworld.redutilities.input;

public class InputFormat {

    /**
     * This method validate the input string and check if it's a
     * valid natural number without a signum of a permutation, and 
     * it's also greater than zero.
     *
     * @return 'true' if the input is a natural number
     */
    public static boolean isPositiveNaturalNumber(String cmdInput) {
        if (cmdInput.matches("^[0-9]+$")) {
            if (Integer.parseInt(cmdInput) > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method validate the input string and check if it's a
     * valid rational number.
     *
     * @return 'true' if the input is a rationale number
     */
    public static boolean isRationaleNumber(String cmdInput) {

        if (cmdInput.matches("^[-\\+]?[0-9]*[\\.,]?[0-9]+$")) {
            return true;
        }
        return false;
    }
    
}
