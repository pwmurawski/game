package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature
{
    private Game game;
    private BufferedImage playerAssets;

    public Player(Game game, float x, float y) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.game = game;
        setBounds(10,0,-20,0);
        playerAssets = Assets.player;
    }

    @Override
    public void tick()
    {
        getInput();
        move();
    }

    private void getInput()
    {
        if(y <= 100)
        {
            yMove = speed;
        }
        if (game.getKeyManager().up && y==200)
        {
            yMove = -speed;
        }
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(this.playerAssets,(int)this.x,(int)this.y,this.width,this.height,null);
    }

    public void setPlayerAssets(BufferedImage playerAssets)
    {
        this.playerAssets = playerAssets;
    }
}
