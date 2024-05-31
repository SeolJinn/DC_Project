# DC Benchmarking Project

### Team Members:
- [Manolache Alexandru]
- [Nan David]
- [Bledea Christian]
- [Brezovan Denis]
- [Agoci Roberto]
- [Crasovan Alexandru]

### Achievement:
We proudly completed the Capture The Flag (CTF), and as such we have only done the first 3 Assignments.

---

## Project Overview

This project is a benchmarking framework designed to evaluate the performance of various hardware components through different algorithms and metrics. The framework consists of three main packages: `bench`, `timing`, and `logging`. Each package is designed to be independent, promoting reusability and flexibility.

### Packages

1. **bench**
    - Contains the benchmarking logic and algorithms.
    - `IBenchmark`: Interface defining the core methods for benchmarking.
    - `DemoBenchmark`: A simple benchmark implementing a sorting algorithm.
    - `SleepBenchmark`: A benchmark that measures sleep durations to demonstrate timing accuracy and cancellation.

2. **timing**
    - Provides the tools to measure execution time.
    - `ITimer`: Interface defining methods for timing.
    - `Timer`: Implementation of `ITimer` using `System.nanoTime()` for precise time measurements.
    - `TimerState`: Enum representing the states of the timer (STOPPED, STARTED, PAUSED).

3. **logging**
    - Manages the logging of benchmark results.
    - `ILogger`: Interface defining methods for logging.
    - `ConsoleLogger`: Implementation of `ILogger` that logs to the console.
    - `FileLogger`: Implementation of `ILogger` that logs to a file.
    - `TimeUnit`: Enum defining time units (NANO, MICRO, MILLI, SEC).
