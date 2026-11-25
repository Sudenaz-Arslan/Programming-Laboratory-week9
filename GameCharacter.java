
package lab2;

public abstract class GameCharacter {
    private String name;
    private int level;
    private int health;
    private int maxHealth;

    public GameCharacter(String name, int level, int maxHealth) {
        this.name = name;
        
        if (level < 1 || level > 100) {
            System.out.println("Warning: Invalid level! Setting level to 1.");
            this.level = 1;
        } else {
            this.level = level;
        }

        if (maxHealth <= 0) {
            System.out.println("Warning: Invalid maxHealth! Setting maxHealth to 100.");
            this.maxHealth = 100;
        } else {
            this.maxHealth = maxHealth;
        }

        this.health = this.maxHealth;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int takeDamage(int damage) {
        if (damage < 0) {
            damage = 0;
        }
        int oldHealth = health;
        health -= damage;
        if (health < 0) {
            health = 0;
        }
        return oldHealth - health;
    }

    public int restoreHealth(int amount) {
        if (!isAlive() || amount <= 0) {
            return 0;
        }
        int oldHealth = health;
        health += amount;
        if (health > maxHealth) {
            health = maxHealth;
        }
        return health - oldHealth;
    }

    public abstract String getCharacterInfo();
    
    public abstract int calculatePower();
    
}
