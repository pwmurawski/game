package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Planets extends Creature
{
    public static BufferedImage[] planets = new BufferedImage[4];
    private BufferedImage planetAssets;

    public Planets(float x, float y, int width, int height) {
        super(x, y, width, height);
        planetAssets = Assets.planet;
        planets[0] = Assets.planet;
        planets[1] = Assets.planet2;
        planets[2] = Assets.planet3;
        planets[3] = Assets.planet4;
    }

    @Override
    public void tick()
    {
        xMove = -1;
        move();
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(planetAssets,(int)this.x,(int)this.y,this.width,this.height,null);
    }

    public void setAssets(BufferedImage bufferedImage)
    {
        this.planetAssets = bufferedImage;
    }
}
