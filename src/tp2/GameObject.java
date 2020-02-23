package tp2;

import tp2.interfaces.IAttack;
import tp2.weapon.*;

public abstract class GameObject implements IAttack {
	protected int x, y, live;
	protected Game game;
	public GameObject(Game game, int x, int y, int live) {
		this.x = x;
		this.y = y;
		this.game = game;
		this.live = live;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public boolean isAlive() {
		return this.live > 0;
	}
	public int getLive() {
		return this.live;
	}
	public boolean isOnPosition(int x, int y) {
		return this.x == x && this.y == y;
	}
	public void getDamage(int damage) {
		this.live = damage >= this.live ? 0 : this.live - damage;
	}
	public boolean isOut() {
		return !game.isOnBoard(x, y);
	}
	
	public abstract void computerAction();
	public abstract void onDelete();
	public abstract void move();
	public abstract String toString();
	
	
	
	
	public abstract boolean receiveMissileAttack(int damage);
	public abstract boolean receiveBombAttack(int damage);
	public abstract boolean receiveShockWaveAttack(int damage);
	public abstract boolean receiveExplosion(int damage);
	
	public abstract void receivePoints(int points);
	public abstract void enableShockWave();
	public abstract boolean move (int numCells, String dir);
	public abstract boolean shootMissile();
	public abstract boolean shockWave();
	
	
	public abstract void bajar();
	public abstract void deleteWeapon();
	public abstract Weapon getWeapon();
	public abstract int getPts();
	public abstract int getDmg();
	public abstract String toStringify();
	
}
