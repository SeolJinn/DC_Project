package bench;

import timing.ITimer;

public class SleepBenchmark implements IBenchmark {
    private long sleepTime;
    private volatile boolean running = true;

    @Override
    public void run() {
        running = true;
        try {
            for(int i=0; i<sleepTime && running; i++)
            {
                Thread.sleep(1);
            }
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
        running = true;
    }

    @Override
    public void clean() {
        // No cleanup needed
    }

    @Override
    public void cancel() {
        running = false;
    }

    @Override
    public void run(Object... params) {
        run(); // Since the sleep time is set in initialize, there's no need for additional parameters
    }
}
