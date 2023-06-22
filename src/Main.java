interface HavingSuperAbility {
    void applySuperAbility();
}

abstract class Hero implements HavingSuperAbility {
    private int health;
    private int damage;
    private String superAbility;

    public Hero(int health, int damage, String superAbility) {
        this.health = health;
        this.damage = damage;
        this.superAbility = superAbility;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public String getSuperAbility() {
        return superAbility;
    }
}

class Magic extends Hero {
    public Magic(int health, int damage, String superAbility) {
        super(health, damage, superAbility);
    }

    public void applySuperAbility() {
        System.out.println("Magic применил суперспособность " + getSuperAbility());
    }
}

class Medic extends Hero {
    private int healPoints;

    public Medic(int health, int damage, String superAbility, int healPoints) {
        super(health, damage, superAbility);
        this.healPoints = healPoints;
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void increaseExperience() {
        healPoints += healPoints * 0.1;
    }

    public void applySuperAbility() {
        System.out.println("Medic применил суперспособность " + getSuperAbility());
    }
}

class Warrior extends Hero {
    public Warrior(int health, int damage, String superAbility) {
        super(health, damage, superAbility);
    }

    public void applySuperAbility() {
        System.out.println("Warrior применил суперспособность " + getSuperAbility());
    }
}

public class Main {
    public static void main(String[] args) {
        Hero[] heroes = new Hero[3];
        heroes[0] = new Magic(100, 20, "Teleportation");
        heroes[1] = new Medic(150, 10, "Healing", 50);
        heroes[2] = new Warrior(200, 30, "Critical Damage");

        for (Hero hero : heroes) {
            hero.applySuperAbility();
            if (hero instanceof Medic) {
                ((Medic) hero).increaseExperience();
            }
        }
    }
}