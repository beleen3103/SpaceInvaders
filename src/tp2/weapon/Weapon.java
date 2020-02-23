package tp2.weapon;

import tp2.Game;
import tp2.GameObject;

public abstract class Weapon extends GameObject{

	public Weapon(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}
	
	
	public boolean move(int numCells, String dir) {return false;}
	public boolean shootMissile() {return false;}
	public boolean shockWave() {return false;}
	public boolean getRight() {return false;}
	public boolean receiveShockWaveAttack(int damage) {return false;}
	public boolean receiveExplosion(int damage) {return false;}
	public Weapon getWeapon() {return null;}
	public int getPts() {return 0;}
	public void receivePoints(int points) {}
	public void enableShockWave() {}
	public void enableMissile() {}
	public void computerAction() {}
	public void onDelete() {}
	public void bajar() {}
	public void deleteWeapon() {}
}
