package de.redstoneworld.redutilities.input;

public class CommandFlags {

    /**
     * This method checks if the given argument is the flag for 
     * hiding the teleport message.
     */
    public static boolean isHideFlag(String cmdInput) {
        if (cmdInput.equalsIgnoreCase("-s")) {
            return true;
        }
        return false;
    }
    
}
