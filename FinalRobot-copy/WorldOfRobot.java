import java.lang.*;
import java.util.*;
import java.util.ArrayList;

public class WorldOfRobot
{
    //Define an ArrayList called worldList which the robot's position will be stored
    private ArrayList<RobotG> worldList;
    //This attribute uses the CanvasRobot class to draw the robot on the canvas
    private CanvasRobot canvasRobot;
    private Colour colour;
    private int x;
    private int y;

    /**
     * Constructeur d'objets de classe WorldOfRobot
     */
    public WorldOfRobot()
    {
        this.worldList = new ArrayList<RobotG>(); 
        this.canvasRobot = canvasRobot; // Initialisation de CanvasRobot

    }
    
    /**
     * Returns the list of robots in the world     
     */
    public ArrayList<RobotG> getList(){
        return this.worldList;
    }

    /**
     * Get the number of robot objects in the list
     * @return size
     */
    public int getNumberOfRobots(){
        return this.worldList.size();
    }
    
    /**
     * Tells if the position the robot tries to move in is already occupied
     * @param x, horizontal robot position
     * @param y, vertical robot position
     * @return true or false
     */
    public boolean canItMove(int x, int y){
        for (RobotG r : this.worldList) {
            if (r.getXPosition() == x && r.getYPosition() == y) {
                return false;
            }
        }
        return true;
    }

    public void moveAll(){
        while(true) {
            for (RobotG rob : worldList) {
                rob.move();
                // Appeler la méthode pour redessiner chaque robot sur le canvas après le mouvement
                rob.drawRobot(); // Dessin du robot après mouvement
            }
            try {
                Thread.sleep(1000); // Delay for one second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Allows to move all robots one by one, w times, according to their specifications
     * @param w, number of moves of each robot
     */
        public void moveAutomatic(int w){
        for (int cpt = 0; cpt < w; cpt++) {
            for (RobotG rob : worldList) {
                rob.move();
                // Redessiner après chaque mouvement
                rob.drawRobot();
            }
            try {
                Thread.sleep(1000); // Delay for one second between moves
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } 
    }    
        
    /**
     * Add robots to the list of robots present in the world.
     */
    void addRobot(RobotG r){
        this.worldList.add(r);
    }
    
    
}