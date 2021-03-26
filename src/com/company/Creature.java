package com.company;

import java.awt.*;

public abstract class Creature extends Entity
{
    public static final float DEFAULT_SPEED = 8.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 40;
    public static final int DEFAULT_CREATURE_HEIGHT = 45;
    public static final Color DEFAULT_COLOR = Color.black;

    protected float speed;
    protected float xMove, yMove;
    protected Color color;

    public Creature(float x, float y, int width, int height) {
        super(x, y, width, height);

        this.color = DEFAULT_COLOR;
        this.speed = DEFAULT_SPEED;
        this.xMove = 0;
        this.yMove = 0;
    }

    public void move()
    {
        x+=xMove;
        y+=yMove;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }
}
