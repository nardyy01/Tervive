package playerClasses;
import enemies.Enemies;
import myTools.PercentHandler;

public class Attacker extends PlayerClass{
	PercentHandler percent = new PercentHandler();
	int cooldown;
	
	public Attacker(String name) {

		System.out.println("Welcome " + name + " you are an Attacker..");
		health = 100;
		damage = 50;  
		critChance = 1; // Out of 100%
		hitChance = 75;// Out of 100%
		dodgeChance = 1;// Out of 100%
		maxHealth = 100;
		maxDamage = 50;
		skillOne = "Crush";
		skillTwo = "Flurry";
		skillThree = "Grand Swing";
		priceSkillOne = 412;
		priceSkillTwo = 404;
		priceSkillThree = 499;
	}
	
	
	//Skills
	@SuppressWarnings("static-access")
	public int skillOne(Enemies enemy){
		int stunChance = 50; 
		double damagePercent = 0.20;
		if(skillOneLevel <= 0) System.out.println("Skill is currently unlearned!");
		else System.out.println("Jumping as high as possible, you sling your sword down onto the enemy!");
		if(skillOneLevel == 1){
			//80 + (20% dmg) | cd = 10 turns
			cooldown = 10;
			System.out.println("*!*CRUSH*!*: " + ((int)(65 + (damage*damagePercent))) + " DMG");
			enemy.getAttacked(((int)(65 + (damage*damagePercent))),percent.inThisRange100(stunChance)); //Deal the damage and stun if successful
			return cooldown;
		}
		if(skillOneLevel == 2){
			//100 + (20% dmg) | cd = 7 turns
			cooldown = 7;
			System.out.println("*!*CRUSH*!*: " + ((int)(85 + (damage*damagePercent))) + " DMG");
			enemy.getAttacked(((int)(85 + (damage*damagePercent))),percent.inThisRange100(stunChance)); //Deal the damage and stun if successful
			return cooldown;
		}
		if(skillOneLevel == 3){
			//120 + (20% dmg) | cd = 6 turns
			cooldown = 6;
			System.out.println("*!*CRUSH*!*: " + ((int)(105 + (damage*damagePercent))) + " DMG");
			enemy.getAttacked(((int)(105 + (damage*damagePercent))),percent.inThisRange100(stunChance)); //Deal the damage and stun if successful
			return cooldown;
		}
		if(skillOneLevel == 4){
			//140 + (20% dmg) | cd = 5 turns
			cooldown = 5;
			System.out.println("*!*CRUSH*!*: " + ((int)(126 + (damage*damagePercent))) + " DMG");
			enemy.getAttacked(((int)(126 + (damage*damagePercent))),percent.inThisRange100(stunChance)); //Deal the damage and stun if successful
			return cooldown;
		}
		if(skillOneLevel == 5){
			//160 + (20% dmg) | cd = 4 turns
			cooldown = 4;
			System.out.println("*!*CRUSH*!*: " + ((int)(144 + (damage*damagePercent))) + " DMG");
			enemy.getAttacked(((int)(144 + (damage*damagePercent))),percent.inThisRange100(stunChance)); //Deal the damage and stun if successful
			return cooldown;
		}
		return -1;
	}
	@SuppressWarnings("static-access")
	public int skillTwo(Enemies enemy){
		double damagePercent = 0.40;
		if(skillTwoLevel <= 0) System.out.println("Skill is currently unlearned!");
		else System.out.println("You quickly move around the enemy inflicting two swift cuts!");
		if(skillTwoLevel == 1){
			cooldown = 6;
			System.out.println("*SWOOP*: " + ((int)(9 + (damage*damagePercent))) + " DMG" + " || *SLASH*: " + ((int)(5 + (damage*damagePercent))) + " DMG");
			enemy.getAttacked(((int)(9 + (damage*damagePercent)))); //First attack 
			enemy.getAttacked(((int)(5 + (damage*damagePercent)))); //second attack
			return cooldown;
		}
		if(skillTwoLevel == 2){
			cooldown = 5;
			System.out.println("*SWOOP*: " + ((int)(15 + (damage*damagePercent))) + " DMG" + " || *SLASH*: " + ((int)(8 + (damage*damagePercent))) + " DMG");
			enemy.getAttacked(((int)(15 + (damage*damagePercent)))); //First attack
			enemy.getAttacked(((int)(8 + (damage*damagePercent)))); //2nd attack
			return cooldown;
		}
		if(skillTwoLevel == 3){
			cooldown = 4;
			System.out.println("*SWOOP*: " + ((int)(21 + (damage*damagePercent))) + " DMG" + " || *SLASH*: " + ((int)(11 + (damage*damagePercent))) + " DMG");
			enemy.getAttacked(((int)(21 + (damage*damagePercent)))); //1st attack
			enemy.getAttacked(((int)(11 + (damage*damagePercent)))); //2nd attack
			return cooldown;
		}
		if(skillTwoLevel == 4){
			cooldown = 3;
			System.out.println("*SWOOP*: " + ((int)(27 + (damage*damagePercent))) + " DMG" + " || *SLASH*: " + ((int)(14 + (damage*damagePercent))) + " DMG");
			enemy.getAttacked(((int)(27 + (damage*damagePercent)))); //1st attack
			enemy.getAttacked(((int)(14 + (damage*damagePercent)))); //2nd attack
			return cooldown;
		}
		if(skillTwoLevel == 5){
			cooldown = 3;
			System.out.println("*SWOOP*: " + ((int)(35 + (damage*damagePercent))) + " DMG" + " || *SLASH*: " + ((int)(17 + (damage*damagePercent))) + " DMG");
			enemy.getAttacked(((int)(35 + (damage*damagePercent)))); //1st attack
			enemy.getAttacked(((int)(17 + (damage*damagePercent)))); //2nd attack
			return cooldown;
		}
		return -1;
	}
	@SuppressWarnings("static-access")
	public int skillThree(Enemies enemy){
		if(skillThreeLevel <= 0) System.out.println("Skill is currently unlearned!");
		else System.out.println("You thrust your sword towards the ground piercing anything in its path!");
		if(skillThreeLevel == 1){
			cooldown = 15;
			System.out.println("PIERCE: " + ((int)(100)) + " DMG");
			enemy.getAttacked(((int)(100))); //Deal the damage 
			System.out.println("YOUR DAMAGE PERMANENTLY INCREASED FROM *" + maxDamage + "* TO **" + (maxDamage+(maxDamage*0.01) + "**"));
			maxDamage += (maxDamage*0.01); //Increase damage by 1%
			
			damage = maxDamage;
			return cooldown;
		}
		if(skillThreeLevel == 2){
			cooldown = 12;
			System.out.println("PIERCE: " + ((int)(200)) + " DMG");
			enemy.getAttacked(((int)(200))); //Deal the damage 
			System.out.println("YOUR DAMAGE PERMANENTLY INCREASED FROM *" + maxDamage + "* TO **" + (maxDamage+(maxDamage*0.01) + "**"));
			maxDamage += (maxDamage*0.01); //Increase damage by 1%
			damage = maxDamage;
			return cooldown;
		}
		if(skillThreeLevel == 3){
			cooldown = 10;
			System.out.println("PIERCE: " + ((int)(300)) + " DMG");
			enemy.getAttacked(((int)(300))); //Deal the damage 
			System.out.println("YOUR DAMAGE PERMANENTLY INCREASED FROM *" + maxDamage + "* TO **" + (maxDamage+(maxDamage*0.01) + "**"));
			maxDamage += (maxDamage*0.01); //Increase damage by 1%
			damage = maxDamage;
			return cooldown;
		}
		return -1;
	}

	public void skillOneDescription(int addedLevels){
		if(skillOneLevel != 5){
		System.out.print("1." + skillOne.toUpperCase() + " Lv." + (skillOneLevel+addedLevels) + " >> ");
			if((skillOneLevel + addedLevels) == 1)System.out.println("Damage: 65 + (20% Attack)  |  Stun Chance: 50%  | Cooldown: 10 Turns"); 
			if((skillOneLevel + addedLevels) == 2)System.out.println("Damage: 85 + (20% Attack)  |  Stun Chance: 50%  | Cooldown: 7 Turns");
			if((skillOneLevel + addedLevels) == 3)System.out.println("Damage: 105 + (20% Attack) |  Stun Chance: 50%  | Cooldown: 6 Turns");
			if((skillOneLevel + addedLevels) == 4)System.out.println("Damage: 126 + (20% Attack) |  Stun Chance: 50%  | Cooldown: 5 Turns");
			if((skillOneLevel + addedLevels) == 5)System.out.println("Damage: 144 + (20% Attack) |  Stun Chance: 50%  | Cooldown: 4 Turns");
		}else {
			System.out.println("Skill has reached max level!");
			priceSkillOne = 0;
		}
	}
	public void skillTwoDescription(int addedLevels){
		if(skillTwoLevel != 5){
		System.out.print("2." + skillTwo.toUpperCase() + " Lv." + (skillTwoLevel+addedLevels) + " >> ");
			if((skillTwoLevel + addedLevels) == 1)System.out.println("Hit One: 9 + (40% Attack)  |  Hit Two: 5 + (40% Attack)   | Cooldown: 6 Turns"); 
			if((skillTwoLevel + addedLevels) == 2)System.out.println("Hit One: 15 + (40% Attack) |  Hit Two: 8 + (40% Attack)   | Cooldown: 5 Turns");
			if((skillTwoLevel + addedLevels) == 3)System.out.println("Hit One: 21 + (40% Attack) |  Hit Two: 11 + (40% Attack)  | Cooldown: 4 Turns");
			if((skillTwoLevel + addedLevels) == 4)System.out.println("Hit One: 27 + (40% Attack) |  Hit Two: 14 + (40% Attack)  | Cooldown: 3 Turns");
			if((skillTwoLevel + addedLevels) == 5)System.out.println("Hit One: 35 + (40% Attack) |  Hit Two: 17 + (40% Attack)  | Cooldown: 3 Turns");
		}else {
			System.out.println("Skill has reached max level!");
			priceSkillTwo = 0;
		}
	}
	public void skillThreeDescription(int addedLevels){
		if(skillThreeLevel != 3){
			System.out.print("3." + skillThree.toUpperCase() + " Lv." + (skillThreeLevel+addedLevels) + " >> ");
			if((skillThreeLevel + addedLevels) == 1)System.out.println("Damage: 100  |  Damage Perm. Increased: 1%  | Cooldown: 15 Turns"); 
			if((skillThreeLevel + addedLevels) == 2)System.out.println("Damage: 200  |  Damage Perm. Increased: 1%  | Cooldown: 12 Turns");
			if((skillThreeLevel + addedLevels) == 3)System.out.println("Damage: 300  |  Damage Perm. Increased: 1%  | Cooldown: 10 Turns");
		}else {
			System.out.println("Skill has reached max level!");
			priceSkillThree = 0;
		}
	}
}