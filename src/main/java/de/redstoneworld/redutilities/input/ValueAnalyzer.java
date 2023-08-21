package de.redstoneworld.redutilities.input;

import org.bukkit.Bukkit;

import static de.redstoneworld.redutilities.input.InputFormat.isRationaleNumber;

public class ValueAnalyzer {

    public static boolean isValidYaw(String cmdInput) {
        if (!isRationaleNumber(cmdInput)) return false;
        float yaw = Float.parseFloat(cmdInput);

        if ((yaw >= -179.9) && (yaw <= 180)) {
            return true;
        }
        return false;
    }

    public static boolean isValidPitch(String cmdInput) {
        if (!isRationaleNumber(cmdInput)) return false;
        float pitch = Float.parseFloat(cmdInput);

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
