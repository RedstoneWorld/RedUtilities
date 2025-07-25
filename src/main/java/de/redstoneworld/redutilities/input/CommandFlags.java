package de.redstoneworld.redutilities.input;

import java.util.stream.IntStream;

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

    /**
     * This method checks whether the specified flag was found
     * for the target argument.
     *
     * The use of wildcards (*) is supported for the end of the
     * string. This is useful for flags with arguments
     * (Example: '-target:*').
     *
     * @param args The array with the command argument input
     * @param flag The flag to be checked
     * @param arg The number (Array index) of the argument to be analysed
     * @return (Boolean) 'true', if the flag was found here
     */
    public static boolean isFlag(String[] args, String flag, int arg) {
        return isFlag(args, flag, arg, arg);
    }

    /**
     * This method checks whether the specified flag was found
     * for the target arguments.
     *
     * The use of wildcards (*) is supported for the end of the
     * string. This is useful for flags with arguments
     * (Example: '-target:*').
     *
     * @param args The array with the command argument input
     * @param flag The flag to be checked
     * @param minArg The minimal number (Array index) of the arguments to be analysed
     * @param maxArg The maximal number (Array index) of the arguments to be analysed
     * @return (Boolean) 'true', if the flag was found here
     */
    public static boolean isFlag(String[] args, String flag, int minArg, int maxArg) {
        return IntStream.rangeClosed(minArg, maxArg)
                .filter(i -> args.length > i)
                .mapToObj(i -> args[i])
                .anyMatch(s -> {

                    if (flag.endsWith("*")) {
                        return s.startsWith(flag.replace("*", ""));
                    } else {
                        return s.equalsIgnoreCase(flag);
                    }

                });
    }

}
