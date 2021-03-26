package com.company;

import java.awt.*;

public abstract class Entity
{
    protected float x,y;
    protected int width, height;
    protected int xB, yB;
    protected int widthB, heightB;

    public Entity(float x, float y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setBounds(int x, int y, int width, int height)
    {
        this.xB = x;
        this.yB = y;
        this.widthB = width;
        this.heightB = height;
    }

    public Rectangle getBounds()
    {
        return new Rectangle((int)this.x+this.xB,(int)this.y+this.yB,this.width+this.widthB,this.height+this.heightB);
    }

    public abstract void tick();

    public abstract void render(Graphics g);
}