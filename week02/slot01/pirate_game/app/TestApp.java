package pirate_game.app;

import pirate_game.game_api.Pirate;
import pirate_game.game_api.Map;

public class TestApp {
    public static void main(String[] args) {
        Map map = new Map(5, 6);
        System.out.println(map.arena.length);
        System.out.println(map.arena[0].length);
        map.arena[2][3] = new Pirate("Abu", 4);
        map.arena[3][1] = new Pirate("Bakar", 3);
        map.arena[0][5] = new Pirate("Curi", 6);
        System.out.println(map);
    }
}
