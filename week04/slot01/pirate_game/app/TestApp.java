package pirate_game.app;

import pirate_game.game_api.Pirate;
import pirate_game.game_api.weapons.*;
import pirate_game.game_api.Map;

public class TestApp {
    public static void main(String[] args) {
        Map map = new Map(5, 6);
        map.addPlaceable(0, 0, new Pirate("Abu", 5, 1));
        map.addPlaceable(0, 1, new Gun(6, 1));
        map.addPlaceable(1, 1, new Pirate("Bakar", 7, 2));
        map.addPlaceable(0, 2, new Sword(3));
        map.addPlaceable(1, 2, new Pirate("Curi", 3, 0));
        System.out.println(map);

        map.movePirateDown(0, 0);
        System.out.println(map);

        map.movePirateRight(0, 1);
        System.out.println(map);

        map.movePirateDown(0, 1);
        System.out.println(map);

        map.movePirateRight(0, 2);
        System.out.println(map);
    }
}
