package players;

import boss.Boss;

import java.util.Random;

public class Berserk extends Hero {
    public Berserk(int health, int damage) {
        super(health, damage, Ability.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void useSuperPower(Hero[] heroes, Boss boss) {
        int randomShoot = 2 + (int) (Math.random() * 4);
        heroes[3].setDamage(getDamage() * randomShoot);
    }
}
