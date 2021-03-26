package com.company;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable
{
    private String title;
    private int width, height;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    private GameFrame gameFrame;
    private KeyManager keyManager;
    private MenuState menuState;
    private GameState gameState;
    private SettingsState settingsState;
    private GameOverState overState;

    public Game(String title, int width, int height)
    {
        this.title = title;
        this.width = width;
        this.height = height;

        keyManager = new KeyManager();
    }

    private void init()
    {
        gameFrame = new GameFrame(title,width,height);
        gameFrame.getFrame().addKeyListener(keyManager);
        Assets.init();
        menuState = new MenuState(this);
        gameState = new GameState(this);
        settingsState = new SettingsState(this);
        overState = new GameOverState(this);
        State.setState(gameState);
    }

    private void tick()
    {
        keyManager.tick();
        if (State.getState() != null)
            State.getState().tick();
    }

    private void render()
    {
        bs = gameFrame.getCanvas().getBufferStrategy();
        if (bs == null)
        {
            gameFrame.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0,0,width,height);


        if (State.getState() != null)
            State.getState().render(g);


        bs.show();
        g.dispose();
    }

    @Override
    public void run()
    {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        while (running)
        {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;

            if(delta >= 1)
            {
                tick();
                render();
                delta--;
            }
        }

        stop();
    }

    public KeyManager getKeyManager()
    {
        return keyManager;
    }

    public void start()
    {
        if (running)
            return;
        running = true;
        run();
    }

    public void stop()
    {
        if (!running)
            return;
        State.setState(overState);
    }

    public int getPoint()
    {
        return gameState.getPoint();
    }

    public State getMenuState()
    {
        return menuState;
    }

    public State getGameState()
    {
        return gameState;
    }

    public void newGameState()
    {
        this.gameState = new GameState(this);
    }

    public State getSettingState()
    {
        return settingsState;
    }

    public Player getPlayer()
    {
        return gameState.getPlayer();
    }
}
