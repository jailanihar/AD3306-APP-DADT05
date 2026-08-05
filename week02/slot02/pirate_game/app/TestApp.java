package pirate_game.app;

import pirate_game.game_api.Pirate;
import pirate_game.game_api.Map;

public class TestApp {
    public static void main(String[] args) {
        Map map = new Map(5, 6);
        map.addPirate(2, 3, new Pirate("Abu", 4));
        Pirate bakarPirate = new Pirate("Bakar", 3);
        map.addPirate(3, 1, bakarPirate);
        map.addPirate(0, 5, new Pirate("Curi", 6));
        System.out.println(map);

        map.selectPirate(0, 5).attackPirate(map.selectPirate(2, 3));
        Pirate curi = map.selectPirate(0, 5);
        Pirate abu = map.selectPirate(2, -1);
        curi.attackPirate(abu);
        System.out.println(map);

        map.movePirate(0, 5, 0, 2);
        System.out.println(map);

        map.movePirate(0, 2, 2, 3);
        map.movePirate(0, 2, 2, 3);
        map.movePirate(0, 2, 2, 3);
        map.movePirate(0, 2, 2, 3);
        map.movePirate(0, 2, 2, 3);
        System.out.println(map);
    }
}
