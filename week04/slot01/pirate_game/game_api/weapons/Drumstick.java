package pirate_game.game_api.weapons;

import pirate_game.game_api.Pirate;
import pirate_game.game_api.interfaces.Consumable;

public class Drumstick extends Weapon implements Consumable {

    public Drumstick(int damage) {
        super(damage);
    }

    @Override
    public int doHealing(Pirate pirate) {
        if(pirate != null) {
            int newHealth = pirate.getHealth() + getDamage();
            return newHealth;
        }
        return 0;
    }

    @Override
    public int doDamage(Pirate pirate) {
        if(pirate != null && pirate.getDefence() > 0) {
            int newDamage = getDamage() * 2;
            return newDamage;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Drumstick(" + getDamage() + "dmg)";
    }

}
