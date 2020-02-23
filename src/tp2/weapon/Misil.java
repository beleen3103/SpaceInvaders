package tp2.weapon;

import tp2.Game;

public class Misil extends Weapon{
	private int damage;
	public Misil(Game game, int x, int y, int live, int damage) {
		super(game, x, y, live);
		this.damage = damage;
	}
	public String toString() {
		return " oo ";
	}
	public void move() {
		if(y == 0) live = 0;
		else y--;
	}
	public boolean receiveBombAttack(int damage) {
		this.getDamage(damage);
		return true;
	}
	public int getDmg() {
		return damage;
	}
	public String toStringify() {
		return "\nM;" + x + ";" + y + ";" + damage;//dmg distingue Misil/Super
	}
	public boolean receiveMissileAttack(int damage) {return false;}
}
