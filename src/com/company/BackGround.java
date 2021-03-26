package com.company;

import java.awt.*;

public class BackGround extends Entity
{
    public BackGround(int width, int height) {
        super(0, 0, width, height);
    }

    @Override
    public void tick()
    {
    }

    @Override
    public void render(Graphics g)
    {
        create(g);
    }

    public void create(Graphics g)
    {
        for (int i=0;i<=10;i++)
            for (int j=0;j<=3;j++)
                g.drawImage(Assets.tile,(i*width),(j*height),this.width,this.height,null);
    }
}
