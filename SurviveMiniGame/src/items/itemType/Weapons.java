package items.itemType;
import java.util.ArrayList;
import java.util.List;
import items.Items;

public class Weapons extends Items{
	
	//Create instances of each weapon and adds them to a List for return
	public List<Items> getItemList(){
		Weapons broadSword = new Broadsword();
		Weapons razorEdge = new Razoredge();
		Weapons whisper = new Whisper();
		List<Items> items = new ArrayList();
		items.add(broadSword);
		items.add(razorEdge);
		items.add(whisper);
		return items;
	}
	private static class Broadsword extends Weapons{
		public Broadsword(){
			name = "Broadsword";
			addedDamage = 30;
			addedHitRate = 5;
			description = (name + ":  " + addedDamage +" DMG | " + addedHitRate + " Hit Rate");
			price = 50;
		}
	}
	private static class Razoredge extends Weapons{
		public Razoredge(){
			name = "Razoredge";
			addedDamage = 50;
			criticalChance = 20;
			addedHitRate = 8;
			description = (name + ":  " + addedDamage +" DMG | " + criticalChance + " Crit Chance | "
					+ addedHitRate + " Hit Rate");
			price = 150;
		}
	}
	private static class Whisper extends Weapons{
		public Whisper(){
			name = "Whisper";
			addedDamage = 75;
			criticalChance = 25;
			addedHitRate = 10;
			description = (name + ":  " + addedDamage +" DMG | " + criticalChance + " Crit Chance | "
					+ addedHitRate + " Hit Rate");
			price = 350;
		}
	}
}

