
package lab2;

public class Warrior extends GameCharacter implements Attacker {
    private int armor;

    public Warrior(String name, int level, int maxHealth, int armor) {
        super(name, level, maxHealth);
        this.armor = armor;
    }

    @Override
    public int calculatePower() {
        return getLevel() * 10 + armor * 2;
    }

    @Override
    public int takeDamage(int damage) {
        int reducedDamage = damage - (armor / 2);
        if (reducedDamage < 1) {
            reducedDamage = 1;
        }
        return super.takeDamage(reducedDamage);
    }

    @Override
    public int attack(GameCharacter target) {
        if (!this.isAlive() || target == null || !target.isAlive()) {
            return 0;
        }
        int damage = calculatePower() / 4;
        return target.takeDamage(damage);
    }

    @Override
    public String getCharacterInfo() {
        return "Warrior - Name: " + getName() + ", Level: " + getLevel() + 
               ", Health: " + getHealth() + "/" + getMaxHealth() + 
               ", Armor: " + armor + ", Power: " + calculatePower();
    }
}