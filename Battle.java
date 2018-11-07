import java.util.Scanner;
/**
 * Write a description of class Battle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public final class Battle
{
    public Battle(Player player, Monster monster) 
    {
        System.out.println("\nYou encounter " + monster + ": " + monster.getDescription() + "\n");
        System.out.println("Commencing battle with " + monster + "(" + player.getStatus() + " / "
            + monster.getStatus() + ")");
        Scanner input = new Scanner(System.in);
        while (player.isAlive() && monster.isAlive()) {
            System.out.print("Attack (a) or heal (h)? ");
            String action = input.nextLine();
            if (action.equals("h")) {
                player.heal();
            } else {
                monster.defend(player);
            }
            if (monster.isAlive()) {
                player.defend(monster);
            }
       }
    }
}