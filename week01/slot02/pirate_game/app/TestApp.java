package pirate_game.app;

import pirate_game.game_api.Pirate;

public class TestApp {
    public static void main(String[] args) {
        Pirate pirate1 = new Pirate("Antah", -10);
        // pirate1.name = "Antah";
        Pirate pirate2 = new Pirate("Berantah", 5);
        // pirate2.name = "Berantah";
        // System.out.println(pirate1.name + " " + pirate1.health);
        // System.out.println(pirate2.name + " " + pirate2.health);
        
        pirate1.setHealth(-10);
        System.out.println(pirate1.getName() + " " + pirate1.getHealth());
        System.out.println(pirate2.getName() + " " + pirate2.getHealth());
        System.out.println(pirate1);
        System.out.println(pirate2);
    }
}
