package pirate_game.game_api;

public class Map {

    private final static int DEFAULT_SIZE = 5;
    private Pirate[][] arena;

    public Map(int width, int height) {
        if(width <= 0) {
            width = DEFAULT_SIZE;
        }
        if(height <= 0) {
            height = DEFAULT_SIZE;
        }
        arena = new Pirate[width][height];
    }

    public void addPirate(int x, int y, Pirate newPirate) {
        if(newPirate != null && 
            x >= 0 && x < arena.length &&
            y >= 0 && y < arena[0].length
        ) {
            arena[x][y] = newPirate;
        }
    }

    public String toString() {
        String output = "";
        for(int y = 0; y < arena[0].length; y++) {
            String line = "";
            for(int x = 0; x < arena.length; x++) {
                line = line + arena[x][y] + "\t";
            }
            output = output + line + "\n";
        }
        output = output + "****************";
        return output;
    }

}
