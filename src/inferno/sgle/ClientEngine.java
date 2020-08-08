package inferno.sgle;

public abstract class ClientEngine extends GameEngine {

    public abstract void render(float delta);

    public abstract void requestShutdown();
}
