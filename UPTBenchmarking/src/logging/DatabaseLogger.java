package logging;

public class DatabaseLogger implements ILogger {
    private String connectionString;
    private String username;
    private String password;

    public DatabaseLogger(String connectionString, String username, String password) {
        this.connectionString = connectionString;
        this.username = username;
        this.password = password;
    }

    @Override
    public void write(long value) {

    }

    @Override
    public void write(String message) {
        // Write the message to the database
        System.out.println("Writing message to the database: " + message);
    }

    @Override
    public void write(Object... values) {

    }

    @Override
    public void close() {
        // Close the database connection
        System.out.println("Closing database connection...");
    }
}