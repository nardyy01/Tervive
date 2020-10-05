package paths;
import java.util.Random;
import java.util.Scanner;
import paths.pathWays.*;
import player.Player;

public class Paths {
	private Random random = new Random();
	private Scanner input = new Scanner(System.in);
	Fight fightPath = new Fight();
	Shop shopPath = new Shop();
	Trap trapPath = new Trap();
	
	@SuppressWarnings("static-access")
	public void startPathing(Player player){
		fightPath.startFight(player, false);
		if (player.isDead()){
			//Do something maybe
		}
		player.seePlayerStats();
		while(!player.isDead()){
			int choice = random.nextInt(100);
			if(choice <= 32) fightPath.startFight(player, false);
			else if(choice <= 65) {
				shopPath.openShop(player);
				//Show inventory after shopping to allow player to equip gear
				player.showInventory(); int index = 99;
				while(index != 0){
					index = input.nextInt();
					player.equipItem(index);
				}
			}
			else if(choice <= 98) {
				choice = random.nextInt(3);
				if(trapPath.getRiddle()) {
					//Reward
					if (choice == 0) {
						player.setBoneShards(player.getBoneShards()+1000);
						System.out.println("You earned 1000 Boneshards!");
					}else if(choice == 1){
						player.setDamage(player.getDamage()+20);
						System.out.println("For being smart, your damage has increased by 20 permenantly!");
					}else{
						player.setArmor(player.getArmor()+20);
						System.out.println("The Gene of this question has blessed you with protection. Armor is increased by 20 forever!");
					}
				}else{
					//Punishment
					if (choice == 0) {player.setHealth(player.getHealth()-10); System.out.println("\nYou lost 10hp!");}
					else if (choice == 1) fightPath.startFight(player, false);
					else {player.setBoneShards(player.getBoneShards() - 50); System.out.println("\nYou lost 50 Boneshards!");}
				}
			}
			else fightPath.startFight(player, true);
			
			player.seePlayerStats();
		}
	}
	
}
