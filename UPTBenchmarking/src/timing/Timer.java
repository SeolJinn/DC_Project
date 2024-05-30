package timing;

public class Timer implements ITimer {
    private long startTime;
    private long elapsedTime;
    private TimerState state;

    public Timer() {
        this.state = TimerState.STOPPED;
        this.elapsedTime = 0;
    }

    @Override
    public void start() {
        if (this.state != TimerState.STARTED) {
            this.startTime = System.nanoTime();
            this.elapsedTime = 0;
            this.state = TimerState.STARTED;
        }
    }

    @Override
    public long stop() {
        if (this.state == TimerState.STARTED) {
            long currentTime = System.nanoTime();
            this.elapsedTime += currentTime - this.startTime;
            this.state = TimerState.STOPPED;
            return this.elapsedTime;
        }
        if(this.state == TimerState.STOPPED || this.state == TimerState.PAUSED)
            return this.elapsedTime;
        return -1;
    }

    @Override
    public void resume() {
        if (this.state == TimerState.PAUSED) {
            this.startTime = System.nanoTime();
            this.state = TimerState.STARTED;
        }
    }

    @Override
    public long pause() {
        if (this.state == TimerState.STARTED) {
            long currentTime = System.nanoTime();
            this.elapsedTime += currentTime - this.startTime;
            this.state = TimerState.PAUSED;
            return currentTime-this.startTime;
        }
        return -1;
    }
}
