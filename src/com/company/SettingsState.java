package com.company;

import java.awt.*;

public class SettingsState extends State
{

    public SettingsState(Game game)
    {
        super(game);
    }

    @Override
    public void tick()
    {
        if (game.getKeyManager().enter)
            State.setState(game.getMenuState());
        if (game.getKeyManager().left)
            game.getPlayer().setPlayerAssets(Assets.player);
        if (game.getKeyManager().up)
            game.getPlayer().setPlayerAssets(Assets.zombie);
        if (game.getKeyManager().right)
            game.getPlayer().setPlayerAssets(Assets.player2);
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(Assets.tile,0,0,700,300,null);
        g.setColor(Color.red);
        g.drawImage(Assets.player,200,100,80,80,null);
        g.drawImage(Assets.buttonLeft,220,200,40,40,null);
        g.drawImage(Assets.zombie,300,100,80,80,null);
        g.drawImage(Assets.buttonUp,320,200,40,40,null);
        g.drawImage(Assets.player2,400,100,80,80,null);
        g.drawImage(Assets.buttonRight,420,200,40,40,null);
        g.setFont(new Font("arial",1,18));
        g.drawString("Press Enter - Select",500,280);
    }
}
