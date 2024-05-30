package bench;

public class DummyBenchmark implements IBenchmark {
    @Override
    public void run() {
        // Perform a dummy operation (e.g., print a message)
        System.out.println("Dummy benchmark is running...");
    }

    @Override
    public void run(Object... params) {
        // Perform the same dummy operation as run()
        run();
    }

    @Override
    public void initialize(Object... params) {
        // Dummy initialization (no actual initialization needed)
    }

    @Override
    public void clean() {
        // Dummy clean-up (no actual clean-up needed)
    }

    @Override
    public void cancel() {
        // Dummy cancel (no cancel operation needed)
    }
}
