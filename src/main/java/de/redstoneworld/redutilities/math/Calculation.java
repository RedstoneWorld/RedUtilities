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

    /**
     * This method rounds up the input to the desired accuracy. The normal 
     * round function of Math always rounds up or down to "1".
     * 
     * @param input value
     * @param x rounding accuracy (e.g. "0.5")
     * @return the rounded value
     */
    private static float roundToX(float input, int x) {
        return (Math.round(input / x)) * x;
    }
}
