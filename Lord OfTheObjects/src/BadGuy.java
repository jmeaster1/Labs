
public class BadGuy extends Players {

	
	public void attack(Players player) {
		player.setHealth(player.getHealth()-weapon.getDamage());//Keeps running total of total player damage/health
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	
}
