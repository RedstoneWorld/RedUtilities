package de.redstoneworld.redutilities.input;

import de.redstoneworld.redutilities.misc.Formatter;
import org.bukkit.Bukkit;

public class ValueAnalyzer {

    public static boolean isValidYaw(String cmdInput) {
        if (!InputFormat.isRationalNumber(cmdInput)) return false;
        double yaw = Formatter.getRationalNumberValue(cmdInput);

        if ((yaw > -180) && (yaw <= 180)) {
            return true;
        }
        return false;
    }

    public static boolean isValidPitch(String cmdInput) {
        if (!InputFormat.isRationalNumber(cmdInput)) return false;
        double pitch = Formatter.getRationalNumberValue(cmdInput);

        if ((pitch >= -90) && (pitch <= 90)) {
            return true;
        }
        return false;
    }

    public static boolean isValidWorld(String cmdInput) {
        if (Bukkit.getWorld(cmdInput) != null) return true;
        return false;
    }

}
