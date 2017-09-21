
public class Players {
	private String name;
	private int health;
	
	Weapon weapon; 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	public void attack(Players player) {
//		health = health - player.getDamage();
		player.setHealth(player.getHealth()-weapon.getDamage());
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hey, ");
		builder.append(name + " Have a look at your current status\n");
		builder.append("health=");
		builder.append(health + "\n" );
		builder.append("weapon=");
		builder.append(getWeapon().getName());
		builder.append("");
		return builder.toString();
	}
	

	
	
	

	

}
