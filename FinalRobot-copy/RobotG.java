import java.lang.*;
import java.util.*;
import java.util.Random;

public abstract class RobotG {
    private String name;
    private int xPosition;
    private int yPosition;
    private String direction;
    private static final Random random = new Random();
    private CanvasRobot canvasRobot; 
    //This attribute is the minimum position of the canvas
    private static final int MIN_POSITION = 0;
    //This attribute is the maximum position of the canvas
    private static final int MAX_POSITION = 11; 
    //This attribute used the Color class to define a color to the body of the robot
    private Colour colour;
    //This attribute allows to use the Canvas class to display a 2D world
    private Canvas canvas;
    //This attribute is used to define the color of the robot's body
    private String colourBody;
    //Define a WorldOfRobot in which the robots will be displayed
    private WorldOfRobot worldR;

    public RobotG (String newName,int x, int y, WorldOfRobot worldR) {
        setName(newName);
        this.worldR = worldR;
        if (worldR.getNumberOfRobots() < 122)
            setPosition(x,y);
        this.canvasRobot = new CanvasRobot(colourBody);
    }

    // Méthode pour définir un nom valide
    public void setName(String name) {
        this.name = name;
    }

    // Méthode pour récupérer le nom du robot
    public String getName() {
        return name;
    }

    // Position aléatoire lors de la création
    private void setPosition(int nx, int ny) {
        boolean search = false;
        while (!search){
            if(this.canItMove(nx,ny) && this.canItDisplay(nx,ny)){
                this.xPosition = nx;
                this.yPosition = ny;
                search = true;
            }
            else {
                nx = (int) (Math.random()*MAX_POSITION);
                ny = (int) (Math.random()*MAX_POSITION);
            }
        }
    }

    // Getter pour la position en X
    public int getXPosition() {
        return xPosition;
    }

    // Setter pour la position en X
    public void setXPosition(int x) {
        this.xPosition = x;
    }

    // Getter pour la position en Y
    public int getYPosition() {
        return yPosition;
    }

    // Setter pour la position en Y
    public void setYPosition(int y) {
        this.yPosition = y;
    }

    /**
     * Set a colour for the robot's body
     * @param colour
     */
    public void setColourBody(String colour){
        this.colourBody = colour;
        canvasRobot.setColourBody(colour);
    }
    
    // Méthode pour obtenir la direction actuelle
    public String getDirection() {
        return direction;
    }

    // Méthode pour changer la direction
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /*// Définir une direction aléatoire
    private void setRandomDirection() {
        String[] directions = {"haut", "bas", "gauche", "droite"};
        this.direction = directions[random.nextInt(directions.length)];
    }
    */
    // Déclaration d'une méthode abstraite move que chaque sous-classe devra implémenter
    public abstract void move();
    
    /**
     * Dessine le robot sur le canevas à la position actuelle.
     */
    public void drawRobot() {
        canvasRobot.setColourBody(colour.toString());
        canvasRobot.drawRobot(xPosition,yPosition);
    }
    
    
    /**
     * Tells if the position the robot tries to move in is already occupied
     * @param x, horizontal robot position
     * @param y, vertical robot position
     * @return true or false
     */
    public boolean canItMove(int x, int y){
        return worldR.canItMove(x, y);
    }

    /**
     * Tells if the position the robot tries to move in is included in the canvas
     * @param x, horizontal robot position
     * @param y, vertical robot position
     * return true/false, the robot's position has a value between [0;10]
     */
    public boolean canItDisplay(int x, int y){
        if ((x >= MIN_POSITION) && (x <= MAX_POSITION) && (y >= MIN_POSITION) && (y <= MAX_POSITION)){
             return true;                   
            }
        else return false;    
    }
}