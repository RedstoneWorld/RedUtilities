package de.redstoneworld.redutilities.math;

public class Calculation {

    public static long getMillisFromServerTicks(long serverTicks) {
        // server-ticks * 50 ≙ time in ms (20 ST ≙ 1000 ms)
        return serverTicks * 50;
    }

    public static long getServerTicksFromMillis(long millis) {
        // time in ms : 50 ≙ server-ticks (1000 ms ≙ 20 ST)
        float result = millis / 50F;
        // round up the result:
        return (long) Math.ceil(result);
    }

    /**
     * This method rounds up the input to the desired accuracy. The normal
     * round function of Math always rounds up or down to "1".
     *
     * @param input (double) value
     * @param x (double) rounding accuracy (e.g. "0.5")
     * @return (double) the rounded value
     */
    public static double roundToX(double input, double x) {
        return Math.round(input / x) * x;
    }

    /**
     * This method checks whether a specific value is within a range of values.
     * 
     * Two limit values are used as interval limits, whose order (MIN, MAX) 
     * is irrelevant.
     * 
     * The limit is included ("Closed Interval"), if 'inclusiveLimitValues' is 'true'. 
     * Otherwise, the limit is exclusive ("Open Interval").
     * 
     * @param value (Double) the target value for the check
     * @param limitA (Double) the first interval limit
     * @param limitB (Double) the second interval limit
     * @param inclusiveLimitValues (Boolean) 'true', if the interval limits are included in the range
     * @return (Boolean) 'true', if the target values is a part of the specified interval
     */
    public static boolean isBetween(double value, double limitA, double limitB, boolean inclusiveLimitValues) {
        
        double min = Math.min(limitA, limitB);
        double max = Math.max(limitA, limitB);
        
        if (inclusiveLimitValues) {
            if ((value == min) || (value == max)) return true;
        }
        
        return ((value > min) && (value < max));
    }
    
}