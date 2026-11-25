
package lab2;

public class Mage extends GameCharacter implements Attacker, Supporter {
    private int mana;

    public Mage(String name, int level, int maxHealth, int mana) {
        super(name, level, maxHealth);
        this.mana = mana;
    }

    @Override
    public int calculatePower() {
        return getLevel() * 8 + mana;
    }

    @Override
    public int attack(GameCharacter target) {
        if (!this.isAlive() || target == null || !target.isAlive()) {
            return 0;
        }
        if (mana < 20) {
            System.out.println(getName() + " does not have enough mana to attack!");
            return 0;
        }
        int currentPower = calculatePower();
        mana -= 20;
        int damage = currentPower / 3;
        return target.takeDamage(damage);
    }

    @Override
    public int heal(GameCharacter target) {
        if (!this.isAlive() || target == null || !target.isAlive()) {
            return 0;
        }
        if (mana < 15) {
            System.out.println(getName() + " does not have enough mana to heal!");
            return 0;
        }
        mana -= 15;
        int amount = getLevel() * 2;
        return target.restoreHealth(amount);
    }

    @Override
    public String getCharacterInfo() {
        return "Mage - Name: " + getName() + ", Level: " + getLevel() + 
               ", Health: " + getHealth() + "/" + getMaxHealth() + 
               ", Mana: " + mana + ", Power: " + calculatePower();
    }
}
