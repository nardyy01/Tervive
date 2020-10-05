import java.util.List;
import java.util.Scanner;
import paths.Paths;
import paths.pathWays.*;
import player.Player;
import playerClasses.*;
import items.*;
import items.itemType.*;
public class GameMain {
	private static Scanner input = new Scanner(System.in);
	private static String[] classList = {"Attacker","Tank","Assassin","Vampire"};
	private static boolean playing = true;
	protected static Player player;
	

	public static void main (String[] args){
		startGame();
		//Trap riddle = new Trap();
		//riddle.mapKeysToValues();
		/*while(true){
			System.out.println(riddle.test());
		}*/
		
		
	}
	public static void startGame(){
		//Story Introduction
		
				//Prompt for a name and store it
				System.out.println("\nPlease enter a name for your character.");
				String name = input.nextLine();
				
				//Prompt for class and store it
				System.out.println("Select a class. (1-2)\n"
						+ "1. Attacker \n"
						+ "2. Tank");
				int playerClassSelection = input.nextInt();
				
				//Handle class selection
				if(classList[playerClassSelection-1] == "Attacker"){
					 player = new Attacker(name);
				} else if (classList[playerClassSelection-1] == "Tank"){
					 player = new Tank(name);
				}
				
				/* 
				 * Handle Loading things if needed later * 
				 */
				//System.out.println(player.getHealth());
				//System.out.println(player.getBoneShards());
				//((PlayerClass) player).skillLevelAdd("all");
				//player.
				
				
				//Fight test = new Fight();
				//test.loadEnemies();
				Paths paths = new Paths();
				//while(playing){
					//Loop the paths
					paths.startPathing(player);
					//test.startFight(player, false);
				//}
	}
}
