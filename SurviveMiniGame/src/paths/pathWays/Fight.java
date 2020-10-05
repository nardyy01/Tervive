package paths.pathWays;
import myTools.*;
import paths.Paths;

import java.util.Scanner;
import enemies.Enemies;
import enemies.LowMobs.*;
import enemies.MedMobs.*;
import enemies.BossMobs.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import player.Player;
import playerClasses.PlayerClass;

public class Fight{
/* 
 * Load in enemies
 * Start the fight
 * Randomly pick an enemy
 * (decide who attacks first)
 * Handle damage is enemy hits first
 * Prompt player to pick an action
 * Handle players choice
 * Enemy's turn
 * Player's turn
 * etc..
 */
	private Scanner input = new Scanner(System.in);
	private Random random = new Random();
	private PercentHandler percent = new PercentHandler();
	private Delay seconds = new Delay();
	private boolean monsterIsAlive = true;
	private boolean playerIsAlive = true;
	private int blockedAttack = 0;
	private Enemies thisEnemy;
	private int cooldown;
	private double criticalModifier = 1.7;
	//Low level enemies
	private Enemies jeckler = new Jeckler();
	private Enemies moth = new Moth();
	private Enemies ranbit = new Ranbit();
	private Enemies slouch = new Slouch();
	//Medium level enemies
	private Enemies orth = new Orth();
	private Enemies randactol = new Randactol();
	private Enemies reckoless = new Reckoless();
	//Boss level enemies
	private Enemies collector = new Collector();
	private Enemies luther = new Luther();
	private Enemies swanmoth = new SwanMoth();
	
	List<Enemies> enemyListLow = new ArrayList<>();
	List<Enemies> enemyListMed = new ArrayList<>();
	List<Enemies> enemyListBoss = new ArrayList<>();
	
	//Load enemies into respective Lists
	public void loadEnemies(){
		enemyListLow.add(jeckler);
		enemyListLow.add(moth);
		enemyListLow.add(ranbit);
		enemyListLow.add(slouch);
		enemyListMed.add(orth);
		enemyListMed.add(randactol);
		enemyListMed.add(reckoless);
		enemyListBoss.add(collector);
		enemyListBoss.add(luther);
		enemyListBoss.add(swanmoth);
	}

	//Start the fight
	@SuppressWarnings("static-access")
	public void startFight(Player player, boolean boss){
		//Load enemies into the arrays if it hasn't been done already.
		if(enemyListLow.isEmpty()) loadEnemies();
		
		if(boss == true){
			//Choose random enemy from enemyListBoss
			thisEnemy = enemyListBoss.get(random.nextInt(enemyListBoss.size()));
		}else{
			//Choose random enemy from enemyListLow or enemyListMed
			if(random.nextInt(2)== 0) thisEnemy = enemyListLow.get(random.nextInt(enemyListLow.size()));
			else if(random.nextInt(1000) == 0) thisEnemy = enemyListBoss.get(random.nextInt(enemyListBoss.size()));
			else thisEnemy = enemyListMed.get(random.nextInt(enemyListMed.size()));
		}
		
		int currentTurn = 0;
		boolean t1 = true, t2 = true, t3 = true; //Booleans to make sure enemy health warnings only show once
		//Make sure monster is ready to fight (check status)
		if(thisEnemy.isDead()) thisEnemy.resetStats();
		monsterIsAlive = true;
		
		System.out.println("It's a " + thisEnemy.getName() +"! Prepare yourself..");
		while(monsterIsAlive && playerIsAlive){
			currentTurn++;//Turn counter
			handleSpecialItems(player, thisEnemy, currentTurn);
			//***********Player Action Area*************
			if(player.isDead()){
				System.out.println("\nYOU HAVE BEEN SLAYN...");
				playerIsAlive = false;
			}
			System.out.println("\n1.Attack | 2.Defend | 3.Skills | 4.Run   [" + player.getHealth() + "]HP");
			String decision = input.nextLine();			
			if(decision.contains("1") || decision.equalsIgnoreCase("attack") || decision.toLowerCase().contains("att")){
				//Check to see if player hits (check hit percentage)
				if(percent.inThisRange100(player.getHitChance())){
					//If player hits, check to see if they critically hit or not
					if(percent.inThisRange100(player.getCritChance())){
						//Subtract player damage + critical modifier from enemy health
						System.out.println("YOU HEAVILY STRIKE: " + ((int) (player.getDamage()*criticalModifier)) + " DMG!"); seconds.delay(0.5);
						thisEnemy.getAttacked((int) (player.getDamage()*criticalModifier));
					}else{
						//Subtract player damage from enemy health
						System.out.println("YOU DEALT: " + player.getDamage() + " DMG"); seconds.delay(0.5);
						thisEnemy.getAttacked(player.getDamage());
					}
				}else System.out.println("You Missed!"); seconds.delay(0.5);
				
			}else if (decision.contains("2") || decision.equalsIgnoreCase("defend") || decision.toLowerCase().contains("def")){
				
				//Check for critical block (block all dmg and punish enemy)
				if(percent.inThisRange100(((PlayerClass) player).getBlockCritChance())){
					System.out.println("Thrusting forward to block you struck the enemy!!!\nYOU DEALT: " + ((int) thisEnemy.getDamage()*0.45)); seconds.delay(0.5);
					thisEnemy.getAttacked((int) (thisEnemy.getDamage()*0.45)); //Consider damage as punish dmg
					blockedAttack = 1;
				}else{
					//Block some of the damage
					blockedAttack = 2;
				}
			}else if (decision.contains("3") || decision.equalsIgnoreCase("skills") || decision.toLowerCase().contains("ski")){
				String[] skillList = ((PlayerClass) player).getSkills();
				System.out.println ("1." + skillList[0] + " | 2." + skillList[1] + " | 3." + skillList[2] + " | 4.Back");
				decision = input.nextLine();
				if (decision.contains("1") || decision.toLowerCase().contains(skillList[0].toLowerCase())){
					if(((PlayerClass) player).getCooldownOne() <= 0){ //If there is no cool down
						cooldown = ((PlayerClass) player).skillOne(thisEnemy); //Execute skill and hold returned cool down in variable
						if(cooldown == -1) continue; //If returned cool down is -1 then skill was not learned yet
						else ((PlayerClass) player).setCooldownOne(cooldown);
					} else {
						System.out.println("Cooldown: " + ((PlayerClass) player).getCooldownOne() + " turns"); //Tell player skill was on cool down
						continue;
					}
				}else if (decision.contains("2") || decision.toLowerCase().contains(skillList[1].toLowerCase())){
					if(((PlayerClass) player).getCooldownTwo() <= 0){ //If there is no cool down
						cooldown = ((PlayerClass) player).skillTwo(thisEnemy); //Execute skill and hold returned cool down in variable
						if(cooldown == -1) continue; //If returned cool down is -1 then skill was not learned yet
						else ((PlayerClass) player).setCooldownTwo(cooldown);
					} else {
						System.out.println("Cooldown: " + ((PlayerClass) player).getCooldownTwo() + " turns"); //Tell player skill was on cool down
						continue;
					}
				}else if (decision.contains("3") || decision.toLowerCase().contains(skillList[2].toLowerCase())){
					if(((PlayerClass) player).getCooldownThree() <= 0){ //If there is no cool down
						cooldown = ((PlayerClass) player).skillThree(thisEnemy); //Execute skill and hold returned cool down in variable
						if(cooldown == -1) continue; //If returned cool down is -1 then skill was not learned yet
						else ((PlayerClass) player).setCooldownThree(cooldown);
					} else {
						System.out.println("Cooldown: " + ((PlayerClass) player).getCooldownThree() + " turns"); //Tell player skill was on cool down
						continue;
					}
				}else if (decision.contains("4") || decision.toLowerCase().contains("bac")){
					continue; //Return to previous menu
				}
				
			}else if (decision.contains("4") || decision.equalsIgnoreCase("run") || decision.toLowerCase().contains("run")){
				//If run is successful end the fight if not (buff enemy or back attack player)
				if(random.nextInt(2) == 1) {
					System.out.println("You got away successfully.\n"); seconds.delay(0.5);
					break;
				} else {
					//Buff enemy
					thisEnemy.runBuff();
					System.out.println("ESCAPE FAILED!"); seconds.delay(0.8);
					System.out.println(thisEnemy.getName() + " senses your fear and BUFFS itself!!"); seconds.delay(0.8);
				}
			} else continue;
			
			//*********Monster Action Area***********
			
			if(thisEnemy.isDead()){
				System.out.println("You have slayn the "+ thisEnemy.getName()+ ""); seconds.delay(0.5);
				//Handle rewards, reset enemy/player, and end the fight
				thisEnemy.rewardAll(player); seconds.delay(1);
				thisEnemy.resetStats();
				player.LevelUp();
				((PlayerClass) player).resetAllCooldowns();
				monsterIsAlive = false;				
			}else{
				//Enemy Health Warnings			
				if(thisEnemy.getHealth() <= (int) (thisEnemy.getMaxHealth()*0.75) && thisEnemy.getHealth() > (int) (thisEnemy.getMaxHealth()*0.50) && t1){ //51-75%HP
					System.out.println("The " + thisEnemy.getName() +" is injured! \n"); t1 = false; seconds.delay(0.5);
				}else if(thisEnemy.getHealth() <= (int) (thisEnemy.getMaxHealth()*0.50) && thisEnemy.getHealth() > (int) (thisEnemy.getMaxHealth()*0.25) && t2){ //26-50%HP
					System.out.println("The " + thisEnemy.getName() + " is weak and fading! \n"); t2 = false; seconds.delay(0.5);
				}else if(thisEnemy.getHealth() <= (int) (thisEnemy.getMaxHealth()*0.25) && t3){ //25% or less HP
					System.out.println("The " + thisEnemy.getName() + " is bloody and afraid! \n"); t3 = false; seconds.delay(0.5);
				}
				
				//Check to see if the monster is stunned before allowing it to attack
				if(thisEnemy.getStunStatus()){
					thisEnemy.setStunStatus(false);
					continue;
				}
				
				//Monster attacks player (blockedAttack decides the damage taken if any)
				if(blockedAttack == 1) blockedAttack = 0; //Return value to 0
				else if(blockedAttack == 2){
					System.out.println("\n" + thisEnemy.getName() + " attacks you."); seconds.delay(0.5);
					player.setHealth(thisEnemy.Attack(player.getHealth(), true, player.getArmor()));
					blockedAttack = 0;
				}else{
					System.out.println("\n" + thisEnemy.getName() + " strikes you."); seconds.delay(0.5);
					player.setHealth(thisEnemy.Attack(player.getHealth(), false, player.getArmor()));
				}
			}
			
			//************Handle Cool Downs**************
			if(cooldown == -1) continue;
			else ((PlayerClass) player).reduceAllCooldowns(); //Subtracts 1 from each cool down timer (End 
		}
	}
	
	public void handleSpecialItems(Player player, Enemies enemy, int currentTurn){
		//If player has specific item, activate its effect
		
	}
}
