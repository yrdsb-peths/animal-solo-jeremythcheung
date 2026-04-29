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
    GreenfootImage[] idle = new GreenfootImage[5];
    int frame = 0;
    int frameDelay = 0;
    /**
     * Constructor - The code that gets run one time when object is created
     */
    public Elephant()
    {
        for(int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("elephant_" + (i+1) + ".png");
        }
        setImage(idle[0]);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("left")){
            move(-5);
        }
        else if(Greenfoot.isKeyDown("right")){
            move(5);
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
            frame = (frame + 1) % idle.length;
            setImage(idle[frame]);
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
