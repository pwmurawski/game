package com.company;

import java.awt.*;

public class GameOverState extends State
{
    public GameOverState(Game game)
    {
        super(game);
    }

    @Override
    public void tick()
    {
        if (game.getKeyManager().enter)
        {
            game.newGameState();
            State.setState(game.getMenuState());
        }
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(Assets.tile,0,0,700,300,null);
        g.setColor(Color.red);
        g.setFont(new Font("arial",1,45));
        g.drawString("Game Over",230,100);
        g.drawString("Score: "+game.getPoint(),255,175);
        g.setFont(new Font("arial",1,18));
        g.drawString("Press Enter - Menu",500,280);
    }
}
