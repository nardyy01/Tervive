package playerClasses;
import player.Player;
import enemies.Enemies;
public class PlayerClass extends Player{
	
	protected String name;
	protected String skillOne;
	protected String skillTwo;
	protected String skillThree;
	protected int skillOneLevel = 0;
	protected int skillTwoLevel = 0;
	protected int skillThreeLevel = 0;
	protected int cooldownOne = 0;
	protected int cooldownTwo = 0;
	protected int cooldownThree = 0;
	protected int priceSkillOne = 100;
	protected int priceSkillTwo = 100;
	protected int priceSkillThree = 100; //Default skill prices
		
	
	//Method to increase any skill's level
	public void skillLevelAdd(String skillName){
		if(skillName.equalsIgnoreCase(skillOne)) skillOneLevel++;
		if(skillName.equalsIgnoreCase(skillTwo)) skillTwoLevel++;
		if(skillName.equalsIgnoreCase(skillThree)) skillThreeLevel++;
		if(skillName.equalsIgnoreCase("all")){skillOneLevel++; skillTwoLevel++; skillThreeLevel++;}
	}

	//Skills ( they return the skills cool down turn number)
	public int skillOne(Enemies enemy){
		return -1;
	}
	public int skillTwo(Enemies enemy){
		return -1;
	}
	public int skillThree(Enemies enemy){
		return -1;
	}
	public void skillOneDescription(int addedLevels){
		System.out.println("Skill is currently unavailable");
	}
	public void skillTwoDescription(int addedLevels){
		System.out.println("Skill is currently unavailable");
	}
	public void skillThreeDescription(int addedLevels){
		System.out.println("Skill is currently unavailable");
	}
	//Getters and setters 
	public void setCooldownOne(int cooldown){
		cooldownOne = cooldown;
	}
	public int getCooldownOne(){
		return cooldownOne;
	}
	public void setCooldownTwo(int cooldown){
		cooldownTwo = cooldown;
	}
	public int getCooldownTwo(){
		return cooldownTwo;
	}
	public void setCooldownThree(int cooldown){
		cooldownThree = cooldown;
	}
	public int getCooldownThree(){
		return cooldownThree;
	}
	
	public int getPriceSkillOne() {
		return priceSkillOne;
	}

	public int getPriceSkillTwo() {
		return priceSkillTwo;
	}

	public int getPriceSkillThree() {
		return priceSkillThree;
	}
	public int getSkillOneLevel() {
		return skillOneLevel;
	}

	public int getSkillTwoLevel() {
		return skillTwoLevel;
	}

	public int getSkillThreeLevel() {
		return skillThreeLevel;
	}

	//Returns an array of skills available
	public String[] getSkills(){
		//Load skills into array to make them selectable without knowing what they are
		String[] skillList = {skillOne, skillTwo, skillThree};
		return skillList;
		
	}
	
	//Stat Handlers
	
	public void reduceAllCooldowns(){
		cooldownOne--;
		cooldownTwo--;
		cooldownThree--;
	}
	public void resetAllCooldowns(){
		cooldownOne = 0;
		cooldownTwo = 0;
		cooldownThree = 0;
	}
}
