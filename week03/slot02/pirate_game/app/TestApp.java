package pirate_game.app;

import pirate_game.game_api.Pirate;
import pirate_game.game_api.weapons.*;
import pirate_game.game_api.Map;

public class TestApp {
    public static void main(String[] args) {
        Map map = new Map(5, 6);
        map.addPirate(2, 3, new Pirate("Abu", 4));
        Pirate bakarPirate = new Pirate("Bakar", 3);
        map.addPirate(3, 1, bakarPirate);
        map.addPirate(1, 3, new Pirate("Curi", 6, 2));
        System.out.println(map);

        Pirate abuPirate = map.selectPirate(2, 3);
        abuPirate.equipWeapon(new Axe(4));
        map.movePirateLeft(1, 3);
        map.movePirateLeft(2, 3);
        System.out.println(map);

        map.movePirateLeft(0, 3);
        map.movePirateLeft(1, 3);
        System.out.println(map);
    }
}
