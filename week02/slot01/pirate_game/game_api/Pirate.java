package pirate_game.game_api;

public class Pirate {

    // Constant Class Variable
    private final static String DEFAULT_NAME = "Pirate";
    private final static int DEFAULT_HEALTH = 5;
    // Class or Static Variable
    private static int defaultPirateCounter = 0;
    // Instance Variable
    private String name;
    private int health;
    // public int pirateCounter = 0;

    // Constructor     //Parameter Variable
    public Pirate(String pName, int pHealth) {
        if(pName == null || pName.equals("")) {
            defaultPirateCounter++;
            pName = DEFAULT_NAME + defaultPirateCounter;
        }
        name = pName;
        setHealth(pHealth);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int pHealth) {
        if(pHealth <= 0) {
            pHealth = DEFAULT_HEALTH;
        }
        health = pHealth;
    }

    public String toString() {
        return "[" + name + ", " + health + "]";
    }

}
