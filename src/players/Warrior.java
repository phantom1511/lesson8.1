package players;

import boss.Boss;

public class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, Ability.CRITICAL_DAMAGE);
    }

    @Override
    public void useSuperPower(Hero[] heroes, Boss boss) {
        /*if (getDamage() < 50) {
            heroes[0].setDamage(getDamage() + boss.getDamage());
        } else if (getDamage() == 50){
            heroes[0].setDamage(getDamage());
        } else{
            heroes[0].setDamage(getDamage() - boss.getDamage());
        }*/
        boss.setHealth(boss.getHealth() - boss.getDamage());
    }
}
