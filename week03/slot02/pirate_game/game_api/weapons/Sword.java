package pirate_game.game_api.weapons;

public class Sword extends Weapon {
    
    public Sword(int damage) {
        super(damage);
    }

    @Override
    public String toString() {
        return "Sword(" + getDamage() + "dmg)";
    }

}
