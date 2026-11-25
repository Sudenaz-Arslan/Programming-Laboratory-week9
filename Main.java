
package lab2;

public class Main {
    public static void main(String[] args) {
        Team myTeam = new Team();

        System.out.println("--- Testing Invalid Inputs ---");
        Warrior w1 = new Warrior("Arthur", 150, -50, 20);
        Mage m1 = new Mage("Merlin", 10, 120, 50);
        Healer h1 = new Healer("Elise", 8, 100, 25);

        myTeam.addCharacter(w1);
        myTeam.addCharacter(m1);
        myTeam.addCharacter(h1);
        myTeam.addCharacter(new Warrior("Arthur", 5, 100, 10));

        myTeam.displayTeam();

        Warrior enemy = new Warrior("Golem", 20, 300, 30);
        System.out.println("Enemy Created -> " + enemy.getCharacterInfo());

        System.out.println("\n--- ROUND 1 ---");
        myTeam.attackAll(enemy);
        System.out.println("Golem attacks Arthur and Merlin!");
        System.out.println("Arthur took " + enemy.attack(w1) + " damage.");
        System.out.println("Merlin took " + enemy.attack(m1) + " damage.");
        myTeam.healTeam();
        myTeam.displayTeam();

        System.out.println("\n--- ROUND 2 ---");
        myTeam.attackAll(enemy);
        System.out.println("Golem attacks Elise!");
        System.out.println("Elise took " + enemy.attack(h1) + " damage.");
        myTeam.healTeam();
        myTeam.displayTeam();

        System.out.println("\n--- Search and Remove Test ---");
        GameCharacter searched = myTeam.findByName("Merlin");
        if (searched != null) {
            System.out.println("Found: " + searched.getCharacterInfo());
        } else {
            System.out.println("Character not found.");
        }

        myTeam.removeCharacter("Elise");
        myTeam.displayTeam();
    }
}