package bench;

import timing.ITimer;

public class SleepBenchmark implements IBenchmark {
    private long sleepTime;

    @Override
    public void run() {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            // Ignore interruption
        }
    }

    @Override
    public void initialize(Object... params) {
        if (params.length > 0 && params[0] instanceof Long) {
            sleepTime = (Long) params[0];
        } else {
            throw new IllegalArgumentException("Expected a long value for sleep time.");
        }
    }

    @Override
    public void clean() {
        // No cleanup needed
    }

    @Override
    public void cancel() {
        // Not needed for this benchmark
    }

    @Override
    public void run(Object... params) {
        run(); // Since the sleep time is set in initialize, there's no need for additional parameters
    }
}
