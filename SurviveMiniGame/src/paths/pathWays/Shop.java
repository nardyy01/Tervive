package paths.pathWays;
import java.util.List;
import java.util.Scanner;
import items.Items;
import items.itemType.*;
import paths.Paths;
import player.Player;
import playerClasses.PlayerClass;

public class Shop{
	Scanner input = new Scanner(System.in);
	String decision;
	
	List<Items> weapons;
	List<Items> armors;
	List<Items> potions;
	
	//Allows player to see a list of items and move them into the inventory for bone-shards(in-game currency)
	@SuppressWarnings("static-access")
	public void openShop(Player player){
		if (weapons == null) getItemLists(); //Load items into arrays
		boolean playerInShop = true;
		System.out.println("Welcome to the store! What would you like to do?");
		while(playerInShop){
			System.out.println("1.BUY | 2.SELL | 3.LEAVE");
			decision = input.nextLine();
			
			if(decision.contains("1") || decision.equalsIgnoreCase("buy")){
				System.out.println("1.WEAPONS | 2.ARMOR | 3.POTIONS | 4.SKILLS | 5.BACK");
				decision = input.nextLine();
				
				if(decision.contains("1") || decision.equalsIgnoreCase("weapons") || decision.contains("wep") ){
					buyWeapons(player);
				} else if(decision.contains("2") || decision.equalsIgnoreCase("armor") || decision.contains("arm") ){
					buyArmor(player);
				} else if(decision.contains("3") || decision.equalsIgnoreCase("potions") || decision.contains("pot") ){
					buyPotions(player);
				} else if(decision.contains("4") || decision.equalsIgnoreCase("skills") || decision.contains("ski") ){
					buySkills(player);
				} else if(decision.contains("5") || decision.equalsIgnoreCase("back") || decision.contains("bac") ){
					continue;
				}			
			} else if(decision.contains("2") || decision.equalsIgnoreCase("sell")){
				sell(player);
			} else if(decision.contains("3") || decision.equalsIgnoreCase("leave")){
				break;
			} else System.out.println("Input not recognized.");
		}
	}
	public void buyWeapons(Player player){
		System.out.println("WEAPONS: Type the items number to purchase!");
		System.out.println("----------------------------------------------------------------\n");
		for (int i = 0; i < weapons.size(); i++){ //Loops through array of weapon items to show them
			System.out.println(i + ".) " + weapons.get(i).getDescription()
    				+ "\nBoneShards: " + weapons.get(i).getPrice()
    				+ "\n-------------");
		}
		System.out.println(weapons.size() + ".) BACK");
		//Handle weapon purchase
		decision = input.nextLine();
		if(decision.matches("[0-9]+")){
			if(Integer.parseInt(decision) < weapons.size()){
				if(player.getBoneShards() >= weapons.get(Integer.parseInt(decision)).getPrice()){
					player.purchaseToInventory(weapons.get(Integer.parseInt(decision)), weapons.get(Integer.parseInt(decision)).getPrice());
					weapons.remove(Integer.parseInt(decision));//Remove item from the list
				} else System.out.println("You do not have enough boneshards!  [" + player.getBoneShards() + "]" ); 
			} else if(Integer.parseInt(decision) == weapons.size()) {/* Do Nothing */}
		} else System.out.println("Invalid Input!");
	}
	public void buyArmor(Player player){
		System.out.println("ARMORS: Type the items number to purchase!");
		System.out.println("----------------------------------------------------------------\n");
		for (int i = 0; i < armors.size(); i++){ //Loops through array of armor items to show them
			System.out.println(i + ".) " + armors.get(i).getDescription()
    				+ "\nBoneShards: " + armors.get(i).getPrice()
    				+ "\n-------------");
		}
		System.out.println(armors.size() + ".) BACK");
		//Handle weapon purchase
		decision = input.nextLine();
		if(decision.matches("[0-9]+")){
			if(Integer.parseInt(decision) < armors.size()){
				if(player.getBoneShards() >= armors.get(Integer.parseInt(decision)).getPrice()){
					player.purchaseToInventory(armors.get(Integer.parseInt(decision)), armors.get(Integer.parseInt(decision)).getPrice());
					armors.remove(Integer.parseInt(decision));//Remove item from the list
				} else System.out.println("You do not have enough boneshards!  [" + player.getBoneShards() + "]" ); 
			}else if(Integer.parseInt(decision) == armors.size()) {/* Do Nothing */}
		} else System.out.println("Invalid Input!");
	}
	public void buyPotions(Player player){
		System.out.println("POTIONS: Type the items number to purchase!");
		System.out.println("----------------------------------------------------------------\n");
		for (int i = 0; i < potions.size(); i++){ //Loops through array of potion items to show them
			System.out.println(i + ".) " + potions.get(i).getDescription()
    				+ "\nBoneShards: " + potions.get(i).getPrice()
    				+ "\n-------------");
		}
		System.out.println(potions.size() + ".) BACK");
		//Handle weapon purchase
		decision = input.nextLine();
		if(decision.matches("[0-9]+")){
			if(Integer.parseInt(decision) < potions.size()){
				if(player.getBoneShards() >= potions.get(Integer.parseInt(decision)).getPrice()){
					player.purchaseToInventory(potions.get(Integer.parseInt(decision)), potions.get(Integer.parseInt(decision)).getPrice());
					potions.remove(Integer.parseInt(decision));//Remove item from the list
				} else System.out.println("You do not have enough boneshards!  [" + player.getBoneShards() + "]" ); 
			}else if(Integer.parseInt(decision) == potions.size()) {/*Do nothing*/}
		} else System.out.println("Invalid Input!");
	}
	public void buySkills(Player player){
		//Get current skills and their levels
		String[] skillList = ((PlayerClass) player).getSkills(); //Prints skills in order and returns an array of the skills
		//Display skills on their next level
		System.out.println("SKILLS: Type the skill's name or number to purchase it!");
		System.out.println("----------------------------------------------------------------\n");
		((PlayerClass) player).skillOneDescription(1);
		int price1 = (((PlayerClass) player).getPriceSkillOne()*(((PlayerClass) player).getSkillOneLevel()+1));
		System.out.print("BoneShards: " + price1
				+ "\n-------------------\n");
		((PlayerClass) player).skillTwoDescription(1);
		int price2 = (((PlayerClass) player).getPriceSkillTwo()*(((PlayerClass) player).getSkillTwoLevel()+1));
		System.out.print("BoneShards: " + price2
				+ "\n-------------------\n");
		((PlayerClass) player).skillThreeDescription(1);
		int price3 = (((PlayerClass) player).getPriceSkillThree()*(((PlayerClass) player).getSkillThreeLevel()+1));
		System.out.print("BoneShards: " + price3
				+ "\n-------------------\n");
		System.out.println("4.) BACK");
		//Handle skill upgrade if purchase is made
		decision = input.nextLine();
		if(decision.equalsIgnoreCase(skillList[0]) || decision.contains("1")){
			//Check if money held is greater than the cost listed
			if(player.getBoneShards() >= price1){
				((PlayerClass) player).skillLevelAdd(skillList[0]);
				player.setBoneShards(player.getBoneShards() - price1);
				System.out.println("Skill has been upgraded!  [BoneShards: " + player.getBoneShards() + "]");
			}else System.out.println("You don't have enough BoneShards!");
			
		}else if(decision.equalsIgnoreCase(skillList[1]) || decision.contains("2")){
			//Check if money held is greater than the cost listed
			if(player.getBoneShards() >= price2){
				((PlayerClass) player).skillLevelAdd(skillList[1]);
				player.setBoneShards(player.getBoneShards() - price2);
				System.out.println("Skill has been upgraded!  [BoneShards: " + player.getBoneShards() + "]");
			}else System.out.println("You don't have enough BoneShards!");
			
		}else if(decision.equalsIgnoreCase(skillList[2]) || decision.contains("3")){
			//Check if money held is greater than the cost listed
			if(player.getBoneShards() >= price3){
				((PlayerClass) player).skillLevelAdd(skillList[2]);
				player.setBoneShards(player.getBoneShards() - price3);
				System.out.println("Skill has been upgraded!  [BoneShards: " + player.getBoneShards() + "]");
			}else System.out.println("You don't have enough BoneShards!");
			
		}else if(decision.equalsIgnoreCase("back") || decision.contains("4")){
		}else System.out.println("Invalid Input!");
		
	}
	public void sell(Player player){
		String itemIndex;
		//Show List of items player currently has and remove items if requested. Increase player money by item value
		player.showInventory();
		
		if(player.getInventorySize() == 0) itemIndex = "0";
		else itemIndex = input.nextLine();
		
		if(itemIndex.matches("[0-9]+")){
			if(player.getInventorySize() > Integer.parseInt(itemIndex)) {
				player.soldFromInventory(Integer.parseInt(itemIndex)); // Removes item from inv and handles payment
				System.out.println("Item Sold! [BoneShards: " + player.getBoneShards() + "]" );
				
			} else System.out.println("No item found!");
		}
		else System.out.println("Please enter the item's number only!");
	}
	public void getItemLists(){
		Weapons weapons = new Weapons();
		Armors armors = new Armors();
		Potions potions = new Potions();
		
		this.weapons = weapons.getItemList();
		this.armors = armors.getItemList();
		this.potions = potions.getItemList();
	}
}
