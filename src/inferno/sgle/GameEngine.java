package inferno.sgle;

public abstract class GameEngine {
    private boolean running;

    public abstract void run();

    public abstract void loop(float delta);

    public abstract void requestShutdown();

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
