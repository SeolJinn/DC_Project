package logging;

public enum TimeUnit {
    NANO(1),
    MICRO(1_000),
    MILLI(1_000_000),
    SEC(1_000_000_000);

    private final long factor;

    TimeUnit(long factor) {
        this.factor = factor;
    }

    /**
     * Convert a time value from one unit to another.
     *
     * @param value    The time value to convert.
     * @param fromUnit The unit of the input value.
     * @param toUnit   The unit to convert the value to.
     * @return The converted time value.
     */
    public static long convert(long value, TimeUnit fromUnit, TimeUnit toUnit) {
        // Convert the value to nanoseconds first, then to the target unit
        return (value * fromUnit.factor) / toUnit.factor;
    }
}
