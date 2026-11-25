
package lab2;

import java.util.ArrayList;

public class Team {
    private ArrayList<GameCharacter> members;

    public Team() {
        members = new ArrayList<>();
    }

    public void addCharacter(GameCharacter character) {
        if (findByName(character.getName()) != null) {
            System.out.println("Warning: A character named '" + character.getName() + "' already exists in the team!");
            return;
        }
        members.add(character);
        System.out.println(character.getName() + " joined the team.");
    }

    public void removeCharacter(String name) {
        GameCharacter found = findByName(name);
        if (found != null) {
            members.remove(found);
            System.out.println(name + " removed from the team.");
        } else {
            System.out.println("Warning: Character '" + name + "' not found!");
        }
    }

    public GameCharacter findByName(String name) {
        for (GameCharacter c : members) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public void attackAll(GameCharacter target) {
        for (GameCharacter c : members) {
            if (c.isAlive() && c instanceof Attacker) {
                Attacker attacker = (Attacker) c;
                int dmg = attacker.attack(target);
                System.out.println(c.getName() + " attacked " + target.getName() + " for " + dmg + " damage.");
            }
        }
    }

    public void healTeam() {
        for (GameCharacter c : members) {
            if (c.isAlive() && c instanceof Supporter) {
                GameCharacter lowestMember = null;
                double minRatio = 2.0;

                for (GameCharacter m : members) {
                    if (m.isAlive()) {
                        double ratio = (double) m.getHealth() / m.getMaxHealth();
                        if (ratio < minRatio) {
                            minRatio = ratio;
                            lowestMember = m;
                        }
                    }
                }

                if (lowestMember != null) {
                    Supporter supporter = (Supporter) c;
                    int healed = supporter.heal(lowestMember);
                    System.out.println(c.getName() + " healed " + lowestMember.getName() + " for " + healed + " HP.");
                }
            }
        }
    }

    public int getTotalPower() {
        int total = 0;
        for (GameCharacter c : members) {
            if (c.isAlive()) {
                total += c.calculatePower();
            }
        }
        return total;
    }

    public void displayTeam() {
        System.out.println("--- TEAM MEMBERS ---");
        for (GameCharacter c : members) {
            System.out.println(c.getCharacterInfo() + " | Alive: " + c.isAlive());
        }
        System.out.println("Total Alive Team Power: " + getTotalPower());
        System.out.println("--------------------");
    }
}