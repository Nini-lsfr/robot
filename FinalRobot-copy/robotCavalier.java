import java.lang.*;
import java.util.*;
import java.util.Random;

public class robotCavalier extends RobotG
{
    private int x;
    private int y;
    private CanvasRobot canvasRobot; // Canvas pour dessiner le robot
    private Colour colour;
    private int direction;
    private boolean trace;

    // Constructeur : initialisation du robot à une position donnée
    public robotCavalier(String name, int x, int y, WorldOfRobot worldR) {
        super(name, x ,y, worldR);
        this.x = x;
        this.y = y;
        this.direction = 0; // Par défaut, le robot pointe vers le Nord
        this.canvasRobot = new CanvasRobot("blue"); // Initialisation du CanvasRobot
        this.colour = Colour.BLUE;
        worldR.addRobot(this);
        this.drawRobot();
    }

    /**
     * Dessine le robot sur le canevas à la position actuelle.
     */
    public void drawRobot() {
        canvasRobot.setColourBody(colour.toString());
        canvasRobot.drawRobot(x,y);
    }
    
    public void move() {
        Random random = new Random();
        int lateral = random.nextInt(2);// 0=Déplacement à droite, 1=Déplacement à gauche
        
        switch (direction) {
            case 0: // Nord
                x -= 2;
                if (lateral == 0) {
                    y += 1;  // Droite
                } else {
                    y -= 1;  // Gauche
                }
                break;
            case 1: // Est
                y += 2;
                if (lateral == 0) {
                    x += 1;  // Droite
                } else {
                    x -= 1;  // Gauche
                }
                break;
            case 2: // Sud
                x += 2;
                if (lateral == 0) {
                    y += 1;  // Droite
                } else {
                    y -= 1;  // Gauche
                }
                break;
            case 3: // Ouest
                y -= 2;
                if (lateral == 0) {
                    x += 1;  // Droite
                } else {
                    x -= 1;  // Gauche
                }
                break;
        }
        
        // Après chaque mouvement, on redessine le robot à sa nouvelle position
        this.drawRobot();
    }

    // Méthode pour afficher la position actuelle du robot
    public void afficherPosition() {
        System.out.println("Position actuelle du Robot Cavalier: (" + x + ", " + y + ")");
    }

    /**
    * M?hode permettant de tourner, dans le sens des aiguilles d'une montre
     */
    public void turn()
    {
        direction++;
        if(direction == 4)
            direction = 0;
    }

    public void afficherEtat()
    {
        System.out.println("Le cavalier est en x:" + x + ", y:" + y + ", et en direction : " + direction);
        if(trace)
            System.out.println("Le cavalier trace");
        else
            System.out.println("Le cavalier ne trace pas");
    }

    /**
     * M?hode utilitaire d'affichage de segment
     * @param  ox oy   coordonn?s initiales du segment
     * @param  x y   coordonn?s finales du segment
     */
    public void afficherSegment(int ox, int oy, int x, int y)
    {
        System.out.println("segment (" + ox + "," + oy + "),(" + x + "," + y + ")");
    }

    /**
     * M?hode permettant de tracer ou non
     * Remarque : cette impl?entation n'est pas correcte : elle ne garantit pas
     * un appel correct des m?hodes ; on peut appeler deux fois de suite
     * tracer(true) par exemple
     * @param  mode   bool?n repr?entant le mode de trace (vrai ou faux)
     */
    public void tracer(boolean mode)
    {
        trace = mode;
        afficherEtat();
    }
    
    /**
     * Affichage de la tortue
     
    public void afficherRobot() {
        switch(direction) {
            case 0:
                CanvasRobot.robotEst(x, y);
                break;
            case 1:
                CanvasRobot.robotSud(x, y);
                break;
            case 2:
                CanvasRobot.robotOuest(x, y);
                 break;
            case 3:
                CanvasRobot.robotNord(x, y);
        }
    }*/
}