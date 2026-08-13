package pirate_game.game_api.weapons;

import pirate_game.game_api.Pirate;

// Gun is a Weapon
// When creating Gun object, it need damage and ammo
// When printing Gun object, it should print example: Gun(3dmg, 2ammo)
// When Gun object damaging a Pirate, it ignores the defence and just do damage base on Gun damage value
//                                    but if no ammo in gun, no damage given.

public class Gun extends Weapon {

    private int ammo;

    public Gun(int damage, int ammo) {
        super(damage);
        setAmmo(ammo);
    }

    public int doDamage(Pirate pirate) {
        if(pirate != null && ammo > 0) {
            int newDamage = getDamage();
            ammo--;
            return newDamage;
        }
        return 0;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        if(ammo <= 0) {
            ammo = 1;
        }
        this.ammo = ammo;
    }

    public String toString() {
        return "Gun(" + getDamage() + "dmg, " + ammo + "ammo)";
    }
    
}
