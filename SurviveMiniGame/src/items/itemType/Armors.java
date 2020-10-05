package items.itemType;
import java.util.ArrayList;
import java.util.List;

import items.Items;

public class Armors extends Items{
	
	
	public List<Items> getItemList(){	
		Armors clothArmor = new ClothArmor();
		Armors chainMail = new ChainMail();
		Armors tarinsPlate = new TarinsPlate();	
		List<Items> items = new ArrayList();
		items.add(clothArmor);
		items.add(chainMail);
		items.add(tarinsPlate);
		return items;
	}
	private static class ClothArmor extends Armors {
		public ClothArmor(){
			name = "Cloth Armor";
			addedArmor = 15;
			addedHealth = 50;
			description = (name + ":  " + addedArmor +" Armor | " + addedHealth + " Health" );
			price = 75;
		}
	}
	private static class ChainMail extends Armors{
		public ChainMail(){
			name = "Chainmail";
			addedArmor = 40;
			addedHealth = 30;
			description = (name + ":  " + addedArmor +" Armor | " + addedHealth + " Health" );
			price = 150;
		}
	}
	private static class TarinsPlate extends Armors{
		public TarinsPlate(){
			name = "Tarin's Plate";
			addedArmor = 66;
			addedHealth = 55;	
			//restoredHealth = 5;//Restores health every other turn
			description = (name + ":  " + addedArmor +" Armor | " + addedHealth + " Health" );
			price = 325;
		}
		public int healEveryOtherTurn(int currentTurnCount){
			if(currentTurnCount%2 == 0) return restoredHealth;
			else return 0;
		}
	}

}

