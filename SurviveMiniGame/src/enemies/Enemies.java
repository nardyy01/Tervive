package enemies;
import items.Items;
import player.Player;

public class Enemies {
	
   protected String name ;
   protected static int damage = 10;
   protected static int maxDamage = 10;
   protected static int health = 400;
   protected static int maxHealth = 1000;
   protected static int dodgeChance = 0;
   protected static int critChance = 0; 
   protected static int expReward = 100;
   protected static int boneReward = 100;
   protected static Items itemReward;
   protected static boolean stunned = false;

    public static void getAttacked(int playerDamage) //Get attacked by the player
    {
        health =  health - playerDamage;
    }
    public static void getAttacked(int playerDamage, boolean stun){
    	health = health - playerDamage;
    	stunned = stun;
    	if (stun == true) System.out.println("ENEMY WAS STUNNED!");
    }
    public static int Attack(int playerHealth, boolean blockSome, int armor) //Attack the player
    {
        if(blockSome){
        	System.out.println("BLOCKED: " + (damage -((int)(damage*0.60)) + (0.20*armor)) + " DMG");
        	System.out.println("YOU TOOK: " + ((int)((damage*0.60)-(0.20*armor))) + " DMG");
        	return ((int) (playerHealth - ((damage*0.60)-(0.20*armor))));
        }else{
        	System.out.println("YOU TOOK: " + (damage-(0.20*armor)) + " DMG");
        	return ((int) (playerHealth - (damage-(0.20*armor))));
        }
    }
    public static void statCheck(int playerLevel) //Adjusts threat based on the level of the player 
    {

    }
    public static boolean isDead(){ //Check enemy health
    	if(health <= 0) return true;
    	else return false;
    }
    public static void resetStats(){ //Return enemy to unused state after the fight
    	health = maxHealth;
    	damage = maxDamage;
    	stunned = false;
    }
    public static void runBuff(){ //Buff if player tries to run and fails
    	damage = damage + (damage/2);
    }
    @SuppressWarnings("static-access")
	public static void rewardAll(Player player){
    	System.out.println("\n\n----Rewards---- \nBoneShards: " + boneReward + "\nExp: " + expReward + "\n\n");
    	player.setBoneShards(player.getBoneShards() + boneReward);
    	player.setExp(player.getExp() + expReward);
    }

    //getters
    public static int getHealth()
    {
        return health;
    }
    public static int getExpReward()
    {
        return expReward;
    }
    public String getName()
    {
        return name;
    }
    public static int getDamage()
    {
        return damage;
    }
    public static int getBoneReward(){
    	return boneReward;
    }
    public static int getMaxHealth(){
    	return maxHealth;
    }
    public static boolean getStunStatus(){
    	return stunned;
    }
    public static void setStunStatus(boolean stun){
    	stunned = stun;
    }
}
