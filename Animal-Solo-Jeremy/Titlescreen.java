import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Titlescreen.
 * 
 * Jeremy 
 * @version (March 2019)
 */
public class Titlescreen extends World
{
    Label titleLabel = new Label("Hungry Elephant", 60);
    /**
     * Constructor for objects of class Titlescreen.
     * 
     */
    public Titlescreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setBackground("elephant background.jpg");

        addObject(titleLabel, 240, 50);
        prepare();
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant, 520, 60);
        Label label = new Label("Press<space> to start", 40);
        addObject(label,219,219);
        label.setLocation(260,288);
        Label label2 = new Label("Use \u2190 and \u2192 to Move", 40);
        addObject(label2,247,215);
        label2.setLocation(369,241);
        label2.setLocation(339,236);
        label2.setLocation(269,235);
    }
}
