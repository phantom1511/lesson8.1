package game;

import boss.Boss;
import players.*;

public class RpgGame {
    public static void StartGame() {
        Boss boss = new Boss(400, 30);
        Hero[] heroes = getHeroesArray();
        while (!isFinished(heroes, boss)) {
            round(heroes, boss);
        }
    }

    private static void round(Hero[] heroes, Boss boss) {
        heroesApplySuperPower(heroes, boss);
        bossHit(heroes, boss);
        heroesHit(heroes, boss);
        showStatistics(heroes, boss);
    }

    private static boolean isFinished(Hero[] heroes, Boss boss) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes WON!");
            return true;
        }

        boolean allHeroesDied = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDied = false;
                break;
            }
        }

        if (allHeroesDied) {
            System.out.println("Boss WON");
        }
        return allHeroesDied;
    }

    private static Hero[] getHeroesArray() {
        Medical medical = new Medical(100, 10);
        Hero[] heroes = {
                new Warrior(100, 10),
                medical,
                new Magical(100, 10),
                new Berserk(100, 10)};
        return heroes;
    }

    private static void bossHit(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
        }
    }

    private static void heroesHit(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static void heroesApplySuperPower(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].useSuperPower(heroes, boss);
        }
    }

    private static void showStatistics(Hero[] heroes, Boss boss) {
        System.out.println("................................");
        System.out.println("Boss health: " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println("Hero " + heroes[i].getClass().getSimpleName() + ": " + heroes[i].getHealth());
        }
        System.out.println("................................");
    }

}
