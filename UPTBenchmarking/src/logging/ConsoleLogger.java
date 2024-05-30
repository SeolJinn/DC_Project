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
    public void close() {
        // No resources to close for console logging
    }
}
