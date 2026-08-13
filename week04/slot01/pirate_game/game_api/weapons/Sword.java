package pirate_game.game_api.weapons;

import pirate_game.game_api.Pirate;

public class Sword extends Weapon {
    
    public Sword(int damage) {
        super(damage);
    }

    @Override
    public String toString() {
        return "Sword(" + getDamage() + "dmg)";
    }

    @Override
    public int doDamage(Pirate pirate) {
        if(pirate != null) {
            int newDamage = getDamage() - pirate.getDefence();
            return newDamage > 0 ? newDamage : 0;
        }
        return 0;
    }

}
