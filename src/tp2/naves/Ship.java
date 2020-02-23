package tp2.naves;

import tp2.Game;
import tp2.GameObject;
import tp2.weapon.Weapon;

public abstract class Ship extends GameObject {
	protected int pts;
	public Ship(Game game, int x, int y, int live, int pts) {
		super(game, x, y, live);
		this.pts = pts;
	}
	public Weapon getWeapon() {
		return null;
	}
	
	public int getPts() {
		return this.pts;
	}	
	public int getDmg() {return 0;}
}
