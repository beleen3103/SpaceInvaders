package tp2.weapon;

import tp2.Game;

public class Bomba extends Weapon{
	public Bomba(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}
	public String toString() {
		return "  .  ";
	}
	public void move() {
		if(y == 7) live = 0;
		else y++;
	}
	
	public boolean receiveMissileAttack(int damage) {
		this.getDamage(damage);
		return true;
	}
	public String toStringify() {
		return "\nB;" + x + ";" + y;
	}
	public boolean receiveBombAttack(int damage) {return false;}
	public int getDmg() {return 0;}
}
