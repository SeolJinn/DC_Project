package logging;

public interface ILogger {
    void write(long value);
    void write(String value);
    void write(Object... values);
    void write(long value, TimeUnit unit);
    void write(String string, long value, TimeUnit unit);
    void close();
}
