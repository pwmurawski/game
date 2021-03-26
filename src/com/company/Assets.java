package com.company;

import java.awt.image.BufferedImage;

public class Assets
{
    private static final int width = 16, height = 16;
    private static final int width2 = 64, height2 = 64;
    private static final int width3 = 55, height3 = 52;
    private static final int width4 = 46, height4 = 46;
    public static BufferedImage player,player2,zombie,plate,tile,planet,planet2,planet3,planet4,buttonLeft,buttonUp,buttonDown,buttonRight;


    public static void init()
    {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spaceset.png"));
        player = sheet.crop(0,0,width,height);
        player2 = sheet.crop(0,16,width,height);
        zombie = sheet.crop(0,48,width,height);
        plate = sheet.crop(144,48,width,height);

        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/planets.png"));
        tile = sheet2.crop(144,131,width2,height2);
        planet = sheet2.crop(0,0,width3,height3);
        planet2 = sheet2.crop(55,0,width3,height3);
        planet3 = sheet2.crop(113,0,width3,height3);
        planet4 = sheet2.crop(170,0,width3,height3);

        SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/MenuButtons sprite.png"));
        buttonLeft = sheet3.crop(237,193,width4,height4);
        buttonRight = sheet3.crop(286,193,width4,height4);
        buttonUp = sheet3.crop(334,193,width4,height4);
        buttonDown = sheet3.crop(384,193,width4,height4);
    }
}