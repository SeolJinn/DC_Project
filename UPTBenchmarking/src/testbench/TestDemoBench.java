package testbench;

import bench.DemoBenchmark;
import logging.ILogger;
import logging.ConsoleLogger;
import timing.ITimer;
import timing.Timer;
import bench.IBenchmark;

public class TestDemoBench {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILogger logger = new ConsoleLogger();
        IBenchmark benchmark = new DemoBenchmark();

        benchmark.initialize(100000);
        timer.start();
        benchmark.run();
        long time = timer.stop();

        logger.write("Finished in: " + time + "ns");
        benchmark.clean();
        logger.close();
    }
}