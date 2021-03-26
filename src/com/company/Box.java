package com.company;

import java.awt.*;

public class Box extends Creature
{
    public Box(int width, int height) {
        super(700, 200, width, height);
    }

    @Override
    public void tick()
    {
        xMove = -speed;
        move();
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(Assets.plate,(int)this.x,(int)this.y,this.width,this.height,null);
    }
}
