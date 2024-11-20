import java.lang.*;
import java.util.*;
import java.util.ArrayList;

/**
 * The WorldOfRobot class is a class that will create the world in which the robots will be displayed.
 * 
 * @Group 9
 * @version 18/10/2023
 */
public class WorldOfRobot
{
    //Define an ArrayList called worldList which the robot's position will be stored
    private ArrayList<Robot> worldList;
    //This attribute uses the CanvasRobot class to draw the robot on the canvas
    private CanvasRobot canvasRobot;
    //This attributes defines the x position of the robot
    private int x;
    //This attributes defines the y position of the robot
    private int y;
    //Define an instance variable with the number of robots in the world
    private int numberOfRobots;
  
    /**
     * Constructeur d'objets de classe WorldOfRobot
     */
    public WorldOfRobot()
    {
        this.worldList = new ArrayList<RobotG>();        
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
        numberOfRobots = worldList.size();
        return numberOfRobots;
    }
    
    /**
     * Tells if the position the robot tries to move in is already occupied
     * @param x, horizontal robot position
     * @param y, vertical robot position
     * @return true or false
     */
    public boolean canItMove(int x, int y){
        if (this.worldList != null){
            for (RobotG r : this.worldList) {
                if (r.getX() == x && r.getY() == y){
                     return false;
                }
            }
        }
        return true;
    }

    
    /**
     * Allows to move all the robots present in the world at the same time
     */
    public void moveAll(){
        while(true) {
            for (RobotG rob : worldList)
            rob.move();
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
        int cpt=0;
        while(cpt<w){
            for (int i =0; i< worldList.size(); i++){
                worldList.get(i).move();
                        try
                {
                    Thread.sleep(1000);
                } 
                    catch (Exception e)
                {
                // ignoring exception at the moment
                }
            }
            cpt++;
        }   
    }    
        
    /**
     * Add robots to the list of robots present in the world.
     */
    void addRobot(Robot r){
        this.worldList.add(r);
    }
}