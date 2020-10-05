package items.itemType;
import java.util.ArrayList;
import java.util.List;
import items.Items;

public class Potions extends Items{
	
	
	public List<Items> getItemList(){
		Potions healthPotion = new HealthPotion();
		Potions bottledExplosion = new BottledExplosion();
		Potions unholyFlask = new UnholyFlask();
		List<Items> items = new ArrayList();
		items.add(healthPotion);
		items.add(bottledExplosion);
		items.add(unholyFlask);
		return items;
	}
	
	private static class HealthPotion extends Potions{
		//Heals the player for X amount of health
		public HealthPotion(){
			name = "Health Potion";
			restoredHealth = 25;
			description = (name + ":  " + restoredHealth +" Health Restored");
			price = 125;
		}
	}

	private static class BottledExplosion extends Potions{
		//Deals X amount of damage to the targeted enemy
		public BottledExplosion(){
			name = "Bottled Explosion";
			extraDamage = 30;
			description = (name + ":  " + extraDamage +" Instant DMG");
			price = 200;
		}
	}
	private static class UnholyFlask extends Potions{
		//Grants extra damage but costs health
		public UnholyFlask(){
			name = "Unholy Flask";
			restoredHealth = -20;
			addedDamage = 25;
			duration = 3;
			description = (name + ":  " + addedDamage +" DMG | " + restoredHealth + " Health | "
					+ duration + " Turn Duration");
			price = 125;
		}
	}
}

