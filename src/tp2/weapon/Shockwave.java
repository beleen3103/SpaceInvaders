package tp2.weapon;

import tp2.Game;

public class Shockwave extends Weapon{

	public Shockwave(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}
	public String toStringify() {
		return "";
	}
	public boolean receiveMissileAttack(int damage) {return false;}
	public boolean receiveBombAttack(int damage) {return false;}
	public void move() {}
	public String toString() {return " ";}
	public int getDmg() {return 0;}
}
