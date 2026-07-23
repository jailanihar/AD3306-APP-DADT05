package pirate_game.game_api;

public class Pirate {

    // Instance Variable
    public String name;
    public int health;

    // Constructor     //Parameter Variable
    public Pirate(String pName, int pHealth) {
        // System.out.println("Pirate object created " + pName);
        name = pName;
        if(pHealth <= 0) {
            pHealth = 3;
        }
        health = pHealth;
    }

}
