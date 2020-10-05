package playerClasses;
public class Tank extends PlayerClass{

	private String name;
	private int shieldBashLvl = 0;
	private int shieldThrowLvl = 0;
	private int reflectLvl = 0;
	
	public Tank(String name) {
		this.name = name;
		
		System.out.println("Welcome " + name + " you are a Tank..");
		health = 250;
		damage = 15;  
		blockCritChance = 19;// Out of 100%
		hitChance = 80;// Out of 100%
		maxHealth = 250;
		skillOne = "Shield Bash";
		skillTwo = "Shield Throw";
		skillThree = "Reflect";

	}
	
	//Method to increase any skill's level
		public void skillLevelAdd(String skillName){
			if(skillName.equalsIgnoreCase("skillOne")) shieldBashLvl++;
			if(skillName.equalsIgnoreCase("skillTwo")) shieldThrowLvl++;
			if(skillName.equalsIgnoreCase("skillThree")) reflectLvl++;
			if(skillName.equalsIgnoreCase("all")) shieldBashLvl++; shieldThrowLvl++; reflectLvl++;
			
			System.out.println("Crush Level: " + shieldBashLvl + "\nFlurry Level: "+ shieldThrowLvl+ "\nGS Level: "+ reflectLvl);
		}

		//Skills
		void shieldBash(){
			int stunChance = 50; //50%
			if(shieldBashLvl <= 0) System.out.println("Skill is currently unavailable!"); 
			if(shieldBashLvl == 1){}
			if(shieldBashLvl == 2){}
			if(shieldBashLvl == 3){}
			if(shieldBashLvl == 4){}
			if(shieldBashLvl == 5){}
		}
		void shieldThrow(){
			if(shieldThrowLvl <= 0) System.out.println("Skill is currently unavailable!"); 
			if(shieldThrowLvl == 1){}
			if(shieldThrowLvl == 2){}
			if(shieldThrowLvl == 3){}
			if(shieldThrowLvl == 4){}
			if(shieldThrowLvl == 5){}
		}
		void reflect(){
			if(reflectLvl <= 0) System.out.println("Skill is currently unavailable!"); 
			if(reflectLvl == 1){}
			if(reflectLvl == 2){}
			if(reflectLvl == 3){}
			if(reflectLvl == 4){}
			if(reflectLvl == 5){}
		}

}
