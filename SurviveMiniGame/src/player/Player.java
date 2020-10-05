package player;

import java.util.ArrayList;
import java.util.List;
import items.Items;

public class Player {

	//Variables
    private static int boneShards = 1200; // Money
    private static int exp = 0;
    private static int level = 1;
    private static double requiredExp = 100;
    private static List<Items> inventory = new ArrayList<Items>();
    private static List<Items> equipedItems = new ArrayList<Items>();
    
    //Armor and weapon variable checkers
    int armorEQ = 0, weaponEQ = 0;
     
    //Class Handled Variables
    protected static int health = 100;
    protected static int damage = 25;  
    protected static int critChance = 0;
    protected static int hitChance = 60;
    protected static int dodgeChance = 0;
    protected static int maxHealth = 100;
    protected static int maxDamage = 50;
    protected static int blockCritChance = 0;
    protected static int armor = 10;
    
	 //Getters and Setters
    public static int getHealth()
    {
        return health;
    }
    public static void setHealth(int hp)
    {
        health = hp;
    }
    public static int getDamage()
    {
        return damage;
    }
    public static void setDamage(int dmg)
    {
        damage = dmg;
    }
    public static int getBoneShards()
    {
        return boneShards;
    }
    public static void setBoneShards(int bShards)
    {
        boneShards = bShards;
    }
    public static int getExp()
    {
        return exp;
    }
    public static void setExp(int experience)
    {
        exp = experience;
    }
    public static int getCritChance()
    {
        return critChance;
    }
    public static int getDodgeChance()
    {
        return dodgeChance;
    }
    public static int getHitChance()
    {
        return hitChance;
    }
    public static int getLevel()
    {
        return level;
    }
    public static int getMaxDamage(){
    	return maxDamage;
    }
    public static void setMaxDamage(int mDamage){
    	maxDamage = mDamage;
    }
    public static void setArmor(int pArmor){
    	armor = pArmor;
    }
    public static int getArmor(){
    	return armor;
    }
    public static void setBlockCritChance(int bcChance){
    	blockCritChance = bcChance;
    }
    public static int getBlockCritChance(){
    	return blockCritChance;
    }
    public static int getInventorySize(){
    	return inventory.size();
    }  
    public static void purchaseToInventory(Items item, int price){
    	boneShards -= price;
    	System.out.println("Bought " + item.getName() + "  [BoneShards: " + boneShards + "]");
    	if(inventory.contains(item)){
    		//Increase item's stack
    		item.increaseStackAmount();
    	}else inventory.add(item);
    }
    public static void addToInventory(Items item){
    	inventory.add(item);
    }
    public static void showInventory(){
    	for(int i = 0; i < inventory.size(); i++){
    		System.out.println(i + ".) " + inventory.get(i).getDescription()
    				+ "\nBoneShards: " + inventory.get(i).getPrice()/3
    				+ "\n-------------");
    	}
    }
    public static void removeFromInventory(int index){
    	inventory.remove(index);
    }
    public static void soldFromInventory(int index){
    	boneShards += inventory.get(index).getPrice()/3;
    	inventory.remove(index);
    }
    public static void LevelUp(){
    	if(exp >= requiredExp){
    		restorePlayerStats();
    		level++;
    		requiredExp *= 3.4532;
    	}
    }
    public static void seePlayerStats(){
    	System.out.println("\nHealth: " + health + "/" + maxHealth
    					+ "\nDamage: " + damage
    					+ "\nArmor: " + armor
    					+ "\nBoneShards: " + boneShards
    					+ "\n\nLevel: " + level + "\n");
    }
    public static boolean isDead(){
    	if(health <= 0) return true;
    	else return false;
    }
    public static void restorePlayerStats(){
    	health = maxHealth;
    }
    public static void equipItem(int index){
    	//Check if item is equipped already
    	if(equipedItems.contains(inventory.get(index).getName())) System.out.println("Items is already equipped.");
    	else{
    		armor += inventory.get(index).getAddedArmor();
    		damage += inventory.get(index).getAddedDamage();
    		maxHealth += inventory.get(index).getAddedHealth(); health += inventory.get(index).getAddedHealth();
    		hitChance += inventory.get(index).getAddedHitRate();
    		critChance += inventory.get(index).getCriticalChance();
    	}
    }
}
