package pirate_game.game_api;

import pirate_game.game_api.interfaces.Consumable;
import pirate_game.game_api.interfaces.Placeable;

public class Potion implements Placeable, Consumable {
    
    private int heal;

    public Potion(int heal) {
        if(heal < 1) {
            heal = 1;
        }
        this.heal = heal;
    }

    public int getHeal() {
        return heal;
    }

    @Override
    public int doHealing(Pirate pirate) {
        if(pirate != null) {
            int newHealth = pirate.getHealth() + heal;
            return newHealth;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Potion(" + heal + "hl)";
    }

}
