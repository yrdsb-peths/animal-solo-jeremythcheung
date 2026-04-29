import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The elehant our hero.
 *
 * @author (Jeremy)
 * @version (April 2026)
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("ElevenLabs_Low_growl_of_an_elephant,_conveying_strength_and_presence.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[5];
    GreenfootImage[] idleLeft = new GreenfootImage[5];
    int frame = 0;
    int frameDelay = 0;
    String facing = "right";

    /**
     * Constructor - The code that gets run one time when object is created
     */
    public Elephant()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("elephant_" + (i+1) + ".png");
            idleRight[i].scale(100, 100);
        }
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("elephant_" + (i+1) + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }
        setImage(idleRight[0]);
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("left")){
            move(-5);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right")){
            move(5);
            facing = "right";
        }

        eat();
        animate();
    }

    public void animate()
    {
        frameDelay++;
        if(frameDelay >= 5)
        {
            frameDelay = 0;
            frame = (frame + 1) % idleRight.length;
            if(facing.equals("right"))
            {
                setImage(idleRight[frame]);
            }
            else
            {
                setImage(idleLeft[frame]);
            }
        }
    }

    public void eat()
    {
        if(isTouching(Apple.class)){
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            elephantSound.play();
        }
    }
}
