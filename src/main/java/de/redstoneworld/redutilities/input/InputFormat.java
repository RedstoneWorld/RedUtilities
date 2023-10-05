package de.redstoneworld.redutilities.input;

public class InputFormat {

    /**
     * This method validate the input string and check if it's a
     * valid natural number without a signum of a permutation.
     *
     * @return 'true' if the input is a natural number
     */
    public static boolean isNaturalNumber(String cmdInput) {
        if (cmdInput.matches("^[0-9]+$")) {
            return true;
        }
        return false;
    }

    /**
     * This method validate the input string and check if it's a
     * valid natural number without a signum of a permutation, and 
     * it's also greater than zero.
     *
     * @return 'true' if the input is a positive natural number
     */
    public static boolean isPositiveNaturalNumber(String cmdInput) {
        if (isNaturalNumber(cmdInput)) {
            if (Integer.parseInt(cmdInput) > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method validate the input string and check if it's a
     * valid integer.
     *
     * @return 'true' if the input is an integer
     */
    public static boolean isInteger(String cmdInput) {
        if (cmdInput.matches("^[-\\+]?[0-9]+$")) {
            return true;
        }
        return false;
    }

    /**
     * This method validate the input string and check if it's a
     * valid rational number. Flexible inputs are allowed, which 
     * improves the usability.
     * 
     * (Input-Formatter: 'Formatter.getRationaleNumberValue')
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
