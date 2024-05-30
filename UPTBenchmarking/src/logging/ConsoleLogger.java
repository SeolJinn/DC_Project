package logging;

public class ConsoleLogger implements ILogger {

    @Override
    public void write(long value) {
        System.out.println(value);
    }

    @Override
    public void write(String value) {
        System.out.println(value);
    }

    @Override
    public void write(Object... values) {
        StringBuilder sb = new StringBuilder();
        for (Object value : values) {
            sb.append(value).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    @Override
    public void write(long value, TimeUnit unit) {
        long convertedValue = TimeUnit.convert(value, TimeUnit.NANO, unit);
        System.out.println(convertedValue + " " + unit.name());
    }

    @Override
    public void write(String string, long value, TimeUnit unit) {
        long convertedValue = TimeUnit.convert(value, TimeUnit.NANO, unit);
        System.out.println(string + " " + convertedValue + " " + unit.name());
    }


    @Override
    public void close() {
        // No resources to close for console logging
    }
}
