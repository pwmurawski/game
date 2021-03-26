package com.company;

import java.awt.*;

public class MenuState extends State
{

    public MenuState(Game game)
    {
        super(game);
    }

    @Override
    public void tick()
    {
        if (game.getKeyManager().up)
            State.setState(game.getGameState());
        if (game.getKeyManager().down)
            State.setState(game.getSettingState());
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(Assets.tile,0,0,700,300,null);
        g.setColor(Color.red);
        g.setFont(new Font("arial",1,30));
        g.drawString("Menu",300,80);
        g.setFont(new Font("arial",1,50));
        g.drawString("Start",280,150);
        g.drawImage(Assets.buttonUp,470,115,40,40,null);
        g.setFont(new Font("arial",1,50));
        g.drawString("Settings",235,220);
        g.drawImage(Assets.buttonDown,470,185,40,40,null);
    }
}
