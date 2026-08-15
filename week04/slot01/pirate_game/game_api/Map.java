package pirate_game.game_api;

import pirate_game.game_api.interfaces.Consumable;
import pirate_game.game_api.interfaces.Placeable;
import pirate_game.game_api.weapons.Weapon;

public class Map {

    public final static String DIRECTION_UP = "up";
    public final static String DIRECTION_DOWN = "down";
    public final static String DIRECTION_LEFT = "left";
    public final static String DIRECTION_RIGHT = "right";
    private final static int DEFAULT_SIZE = 5;
    private Placeable[][] arena;

    public Map(int width, int height) {
        if(width <= 0) {
            width = DEFAULT_SIZE;
        }
        if(height <= 0) {
            height = DEFAULT_SIZE;
        }
        arena = new Placeable[width][height];
    }

    public void addPirate(int x, int y, Pirate newPirate) {
        if(newPirate != null && 
            checkCoordinate(x, y)
        ) {
            arena[x][y] = newPirate;
        }
    }

    public void addPlaceable(int x, int y, Placeable newPlaceable) {
        if(newPlaceable != null && 
            checkCoordinate(x, y)
        ) {
            arena[x][y] = newPlaceable;
        }
    }

    public Pirate selectPirate(int x, int y) {
        if(checkCoordinate(x, y) && arena[x][y] instanceof Pirate) {
            return (Pirate) arena[x][y];
        }
        return null;
    }

    public Placeable selectPlaceable(int x, int y) {
        if(checkCoordinate(x, y)) {
            return arena[x][y];
        }
        return null;
    }

    public void movePirateUp(int currentX, int currentY) {
        movePirate(currentX, currentY, DIRECTION_UP);
    }

    public void movePirateDown(int currentX, int currentY) {
        movePirate(currentX, currentY, DIRECTION_DOWN);
    }

    public void movePirateLeft(int currentX, int currentY) {
        movePirate(currentX, currentY, DIRECTION_LEFT);
    }

    public void movePirateRight(int currentX, int currentY) {
        movePirate(currentX, currentY, DIRECTION_RIGHT);
    }

    private void movePirate(int currentX, int currentY, String direction) {
        if(DIRECTION_UP.equals(direction)) {
            movePirate(currentX, currentY, currentX, currentY-1);
        }
        if(DIRECTION_DOWN.equals(direction)) {
            movePirate(currentX, currentY, currentX, currentY+1);
        }
        if(DIRECTION_LEFT.equals(direction)) {
            movePirate(currentX, currentY, currentX-1, currentY);
        }
        if(DIRECTION_RIGHT.equals(direction)) {
            movePirate(currentX, currentY, currentX+1, currentY);
        }
    }

    private void movePirate(int currentX, int currentY, int newX, int newY) {
        if(checkCoordinate(currentX, currentY) && checkCoordinate(newX, newY)) {
            Pirate selectedPirate = selectPirate(currentX, currentY);
            Placeable moveLocation = selectPlaceable(newX, newY);
            if(selectedPirate == null) {
                return;
            }
            if(moveLocation == null) {
                // Move that pirate to the move location
                occupyLocation(currentX, currentY, newX, newY, selectedPirate);
            } else {
                if(moveLocation instanceof Pirate) {
                    // There is a pirate in the move location
                    // Attack that pirate
                    Pirate otherPirate = (Pirate) moveLocation;
                    selectedPirate.attackPirate(otherPirate);
                    if(otherPirate.getHealth() <= 0) {
                        occupyLocation(currentX, currentY, newX, newY, selectedPirate);
                    }
                }
                else if(moveLocation instanceof Weapon) {
                    selectedPirate.equipWeapon((Weapon) moveLocation);
                    occupyLocation(currentX, currentY, newX, newY, selectedPirate);
                }
                else if(moveLocation instanceof Consumable) {
                    Consumable consumable = (Consumable) moveLocation;
                    int newHealth = consumable.doHealing(selectedPirate);
                    selectedPirate.setHealth(newHealth);
                    occupyLocation(currentX, currentY, newX, newY, selectedPirate);
                }
            }
        }
    }

    private void occupyLocation(int currentX, int currentY, int newX, int newY, Pirate pirate) {
        if(pirate != null && checkCoordinate(currentX, currentY) && checkCoordinate(newX, newY)) {
            arena[newX][newY] = pirate;
            arena[currentX][currentY] = null;
        }
    }

    public boolean checkCoordinate(int x, int y) {
        return x >= 0 && x < arena.length && y >= 0 && y < arena[0].length;
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
