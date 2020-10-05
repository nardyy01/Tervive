package items;

public class Items {

	protected int stackAmount = 0; //Amount of the item currently held
	protected int addedDamage;
	protected int addedHealth;
	protected int restoredHealth;
	protected int damageOverTime; //Damage over time
	protected int criticalChance;
	protected int addedArmor;
	protected int reduceCooldown;
	protected int addedHitRate;
	protected int extraDamage;
	protected int duration; //Amount of time X lasts
	protected int price;
	protected String description;
	protected String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStackAmount() {
		return stackAmount;
	}
	//Stack will be increase or decreased. Not set!
	public void increaseStackAmount() {
		this.stackAmount++;
	}
	public void decreaseStackAmount() {
		this.stackAmount--;
	}
	public int getAddedDamage() {
		return addedDamage;
	}
	public void setAddedDamage(int addedDamage) {
		this.addedDamage = addedDamage;
	}
	public int getAddedHealth() {
		return addedHealth;
	}
	public void setAddedHealth(int addedHealth) {
		this.addedHealth = addedHealth;
	}
	public int getRestoredHealth() {
		return restoredHealth;
	}
	public void setRestoredHealth(int restoredHealth) {
		this.restoredHealth = restoredHealth;
	}
	public int getDamageOverTime() {
		return damageOverTime;
	}
	public void setDamageOverTime(int damageOverTime) {
		this.damageOverTime = damageOverTime;
	}
	public int getCriticalChance() {
		return criticalChance;
	}
	public void setCriticalChance(int criticalRate) {
		this.criticalChance = criticalRate;
	}
	public int getAddedArmor() {
		return addedArmor;
	}
	public void setAddedArmor(int addedArmor) {
		this.addedArmor = addedArmor;
	}
	public int getReduceCooldown() {
		return reduceCooldown;
	}
	public void setReduceCooldown(int reduceCooldown) {
		this.reduceCooldown = reduceCooldown;
	}
	public int getAddedHitRate() {
		return addedHitRate;
	}
	public void setAddedHitRate(int addedHitRate) {
		this.addedHitRate = addedHitRate;
	}
	public int getExtraDamage() {
		return extraDamage;
	}
	public void setExtraDamage(int extraDamage) {
		this.extraDamage = extraDamage;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
}
