package logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements ILogger {
    private PrintWriter writer;

    public FileLogger(String filePath) throws IOException {
        writer = new PrintWriter(new FileWriter(filePath, true));
    }

    @Override
    public void write(long value) {
        writer.println(value);
        writer.flush();
    }

    @Override
    public void write(String value) {
        writer.println(value);
        writer.flush();
    }

    @Override
    public void write(Object... values) {
        for (Object value : values) {
            writer.print(value + " ");
        }
        writer.println();
        writer.flush();
    }

    @Override
    public void write(long value, TimeUnit unit) {
        long convertedValue = TimeUnit.convert(value, TimeUnit.NANO, unit);
        writer.println(convertedValue + " " + unit.name());
        writer.flush();
    }

    @Override
    public void write(String string, long value, TimeUnit unit) {
        long convertedValue = TimeUnit.convert(value, TimeUnit.NANO, unit);
        writer.println(string + " " + convertedValue + " " + unit.name());
        writer.flush();
    }

    @Override
    public void close() {
        writer.close();
    }
}
