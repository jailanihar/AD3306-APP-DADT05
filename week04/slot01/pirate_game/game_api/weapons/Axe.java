package pirate_game.game_api.weapons;

import pirate_game.game_api.Pirate;

// Subclass    // Superclass
public class Axe extends Weapon {
    
    public Axe(int damage) {
        super(damage);
    }

    @Override
    public int doDamage(Pirate pirate) {
        if(pirate != null) {
            return getDamage();
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Axe(" + getDamage() + "dmg)";
    }

}
