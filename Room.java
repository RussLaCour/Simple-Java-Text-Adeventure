import java.util.Random;
import java.util.*;
/**
 * Write a description of class Room here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public final class Room
{
    private final String description;
    private final Monster monster;
    private final boolean isBossRoom;
    private final static Random random = new Random();
    private final static HashSet<Integer> roomsSeen = new HashSet<Integer>();
    private final static int NUM_ROOMS = 7;

    private Room(String description, Monster monster, boolean isBossRoom) 
    {
        this.description = description;
        this.monster = monster;
        this.isBossRoom = isBossRoom;
    }

    public static Room newRegularInstance()
    {
        if (roomsSeen.size() == NUM_ROOMS) {
            roomsSeen.clear();
        }
        int i;
        do {
            i = random.nextInt(NUM_ROOMS);
        } while (roomsSeen.contains(i));
        roomsSeen.add(i);
        
        String roomDescription = null;
        if (i == 0) {
            roomDescription = "a dark, dank room riddled with foul beasts";
        } else if (i == 1) {
            roomDescription = "an endless mountain range where eagles soar looking for prey";
        } else if (i == 2) {
            roomDescription = "a murky swamp with a foul smelling odor";
        } else if (i == 3) {
            roomDescription = "a volcano with rivers of lava at all sides";
        } else if (i == 4) {
            roomDescription = "a thick forest where strange voices call out from the trees high above";
        } else if (i == 5) {
            roomDescription = "an old abandoned ship, filled with the remains of its unlucky crew";
        } else if (i == 6) {
            roomDescription = "a cafe filled with hipsters begging to be burned to death";
        } else {
        }
        return new Room(roomDescription, Monster.newRandomInstance(), false);
    }

    public static Room newBossInstance() 
    {
        return new Room("a huge cavern thick with the stench of sulfur", Monster.newBossInstance(), true);
    }

    public boolean isBossRoom() 
    {
        return isBossRoom;
    }

    public boolean isComplete() 
    {
        return !monster.isAlive();
    }

    @Override
    public String toString()
    {
        return description;
    }

    public void enter(Player player)
    {
        System.out.println("You are in " + description);
        if (monster.isAlive()) {
            new Battle(player, monster);
        }
    }
}
