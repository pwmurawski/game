package com.company;

import java.awt.*;
import java.util.Random;

public class GameState extends State
{
    private int point = 0;
    private int q = 1;
    private Random rand;

    private Player player;
    private Ground ground;
    private Box box;
    private BackGround bg;
    private Planets planets;

    public GameState(Game game)
    {
        super(game);
        rand = new Random();

        player = new Player(game,100,200);
        ground = new Ground(0,240,700,60);
        box = new Box(40,45);
        bg = new BackGround(64,64);
        planets = new Planets(700,100,64,64);
    }

    @Override
    public void tick()
    {
        planets.tick();
        collision();
        player.tick();
        box.tick();
        action();
    }

    public void action()
    {
        if (box.getX() <= 0)
        {
            this.point+=1;
            box.setX(700);
            box.setSpeed(box.speed += 0.25f);

        }

        if (planets.getX() <= 0)
        {
            planets.setX(700);
            planets.setY(rand.nextInt(165)+5);
            planets.setAssets(Planets.planets[this.q]);
            if (this.q==3)
                this.q=-1;
            this.q++;
        }
    }

    public void collision()
    {
        if(player.getBounds().intersects(box.getBounds()))
        {
            box.speed = 0;
            this.game.stop();
        }
        if (player.getBounds().intersects(ground.getBounds()))
            player.y = 200;
    }

    @Override
    public void render(Graphics g)
    {
        bg.render(g);
        ground.render(g);
        planets.render(g);
        box.render(g);
        player.render(g);

        g.setColor(Color.yellow);
        g.setFont(new Font("arial",1,15));
        g.drawString("Score: "+(this.point),590,20);
    }

    public int getPoint()
    {
        return point;
    }

    public Player getPlayer()
    {
        return player;
    }
}
