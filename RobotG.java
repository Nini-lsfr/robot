public class RobotG {
    // Position de la robot
    private int x;
    private int y;
    private String name;
    private int direction;
    // Taille de la grille (12x12)
    protected final int GRID_SIZE = 12;

    /**
    * Constructor for objects of class robot
    */
    public RobotG() {
        x=0;
        y=0;
        direction = 1;
        this.name = name;
    }

    /**
     * Accesseur de la direction
     * @return     la valeur de la direction
     */
    public int getDirection() {
        return direction;
    }

    // Méthode pour déterminer la direction (Nord, Est, Sud, Ouest)
    public void determinerDirection(int direction) {
    // Vérifier si la direction est valide (0 = Nord, 1 = Est, 2 = Sud, 3 = Ouest)
        if (direction >= 0 && direction <= 3) {
            this.direction = direction;
        } else {
            System.out.println("Direction invalide !");
        }
    }

    public void control(int startX, int startY) {
        // Vérifier si les nouvelles coordonnées sont valides
        if (estDansGrille(startX, startY)) {
            x = startX;
            y = startY;
            } else {
            System.out.println("Le robot ne peut pas sortir de la grille !");
        }
    }
    
    /**
     * Vérifie si une position est dans les limites de la grille.
     * @param x La coordonnée x
     * @param y La coordonnée y
     * @return true si la position est dans la grille, false sinon
     */
    protected boolean estDansGrille(int x, int y) {
        return x >= 0 && x < GRID_SIZE && y >= 0 && y < GRID_SIZE;
    }
    
}