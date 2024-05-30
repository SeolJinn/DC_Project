package testbench;

import bench.SleepBenchmark;
import logging.ILogger;
import logging.ConsoleLogger;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;
import bench.IBenchmark;

import java.sql.Time;

public class TestSleepBench {
    public static void main(String[] args) {
        final long workload = 100;
        SleepBenchmark benchmark = new SleepBenchmark();
        benchmark.initialize(workload);

        ITimer timer = new Timer();
        ILogger logger = new ConsoleLogger();
        timer.start();
        timer.pause();
        TimeUnit timeUnit = TimeUnit.MILLI;

        for(int i=0; i< 12; ++i)
        {
            timer.resume();
            benchmark.run();
            long time = timer.pause();
            logger.write("Run "+ i + ":" ,time, timeUnit);
        }
        logger.write("Finished in: ", timer.stop(), timeUnit);
    }
}