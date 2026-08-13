package pirate_game.game_api.weapons;

import pirate_game.game_api.Pirate;
import pirate_game.game_api.interfaces.Placeable;

public abstract class Weapon implements Placeable {
    
    private int damage;

    public Weapon(int damage) {
        if(damage < 1) {
            damage = 1;
        }
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public abstract int doDamage(Pirate pirate);

    @Override
    public String toString() {
        return "Weapon(" + damage + "dmg)";
    }

}
