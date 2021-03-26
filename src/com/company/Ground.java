package com.company;

import java.awt.*;

public class Ground extends Entity
{

    public Ground(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void tick()
    {
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.lightGray);
        g.fillRect((int)x,(int)y,width,height);
    }
}
