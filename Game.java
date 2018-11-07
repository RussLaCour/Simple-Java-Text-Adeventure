import java.util.Scanner;
import java.util.Random;
import java.util.*;
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public final class Game
{
    private final Player player = Player.newInstance();
    
    public void play() {
        System.out.println("You are " + player + " " + player.getDescription());
        Dungeon.newInstance().startQuest(player);
    }
    
    public static void main(String[] args) 
    {
        Game game = new Game();
        game.play();
    }
}
