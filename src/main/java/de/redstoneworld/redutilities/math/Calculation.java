package de.redstoneworld.redutilities.math;

public class Calculation {

    private static long getMillisFromServerTicks(long serverTicks) {
        // server-ticks * 50 ≙ time in ms (20 ST ≙ 1000 ms)
        return serverTicks * 50;
    }

    private static long getServerTicksFromMillis(long millis) {
        // time in ms : 50 ≙ server-ticks (1000 ms ≙ 20 ST)
        float result = millis / 50F;
        // round up the result:
        return (long) Math.ceil(result);
    }
    
}
