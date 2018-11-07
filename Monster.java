import java.util.Random;
import java.util.*;

/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public final class Monster
{
    public final String name;
    public final String description;
    private int hitPoints;
    private final int minDamage;
    private final int maxDamage;
    private final static Random random = new Random();
    private final static HashSet<Integer> monstersSeen = new HashSet<Integer>();
    private final static int NUM_MONSTERS = 6;

    public static Monster newRandomInstance() 
    {
        if (monstersSeen.size() == NUM_MONSTERS) {
            monstersSeen.clear();
        }
        int i;
        do {
            i = random.nextInt(NUM_MONSTERS);
        } while (monstersSeen.contains(i));
        monstersSeen.add(i);

        if (i == 0) {
            return new Monster("Harpy", "A bird-like creature with a vicious claw attack.", 30, 6, 12);
        } else if (i == 1) {
            return new Monster("Imp", "A lesser demon with a weak attack.", 26, 4, 6);
        } else if (i == 2) {
            return new Monster("Orc", "A brutish warrior with a powerful attack.", 40, 8, 14);
        } else if (i == 3) {
            return new Monster("Succubus", "A sex demon that will suck the life out of you.", 50, 9, 17);
        } else if (i == 4) {
            return new Monster("Melvin", "That horny pervert that sits behind you in math class.", 33, 0, 5);
        } else {
            return new Monster("Lich", "An undead mage who can control the dead.", 65, 10, 20);  
        }
    }

    public static Monster newBossInstance() 
    {
        return new Monster("Death Knight", "A paladin that fell from grace." 
            + "\nPrepare for the ultimate battle!", 85, 15, 40);
    }

    private Monster(String name, String description, int hitPoints, int minDamage, int maxDamage) 
    {
        this.name = name;
        this.description = description;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.hitPoints = hitPoints;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public String getStatus()
    {
        return "Monster HP: " + hitPoints;
    }

    public int attack() {
        return random.nextInt(maxDamage - minDamage + 1) + minDamage;
    }

    public void defend(Player player) {
        int attackStrength = player.attack();
        hitPoints = (hitPoints > attackStrength) ? hitPoints - attackStrength : 0;
        System.out.printf("%s hits %s for %d HP of damage (%s) \n", player, name, attackStrength, getStatus());
        if (hitPoints == 0) {
            System.out.println(player + " has defeated " + name + ". \n");
        }
    }

    public boolean isAlive()
    {
        return hitPoints > 0;
    }
}
