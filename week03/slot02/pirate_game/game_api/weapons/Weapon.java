package pirate_game.game_api.weapons;

import pirate_game.game_api.Pirate;

public class Weapon {
    
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

    public int doDamage(Pirate pirate) {
        if(pirate != null) {
            int newDamage = damage - pirate.getDefence();
            return newDamage > 0 ? newDamage : 0;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Weapon(" + damage + "dmg)";
    }

}
