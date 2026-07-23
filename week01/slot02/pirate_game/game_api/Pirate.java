package pirate_game.game_api;

public class Pirate {

    // Instance Variable
    private String name;
    private int health;

    // Constructor     //Parameter Variable
    public Pirate(String pName, int pHealth) {
        // System.out.println("Pirate object created " + pName);
        if(pName == null || pName.equals("")) {
            pName = "Pirate";
        }
        name = pName;
        // if(pHealth <= 0) {
        //     pHealth = 3;
        // }
        // health = pHealth;
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
            pHealth = 3;
        }
        health = pHealth;
    }

    public String toString() {
        return "[" + name + ", " + health + "]";
    }

}
