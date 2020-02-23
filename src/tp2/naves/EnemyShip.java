package tp2.naves;

import tp2.Game;
import tp2.interfaces.IExecuteRandomActions;

public abstract class EnemyShip extends Ship implements IExecuteRandomActions{

	public EnemyShip(Game game, int x, int y, int live, int pts) {
		super(game, x, y, live, pts);
	}
	@Override
	public boolean isAlive() {
		if(this.live > 0) return true;
		else {
			AlienShip.remainingAliens--;
			return false;
		}
	}
	public boolean receiveMissileAttack(int damage) {
		this.getDamage(damage);
		return true;
	}
	public boolean receiveShockWaveAttack(int damage) {
		this.getDamage(damage);
		return true;
	}
	public boolean receiveBombAttack(int damage) {return false;}
	public boolean move (int numCells, String dir) {return false;}
	public boolean shootMissile() {return false;}
	public boolean shockWave() {return false;}
	public void receivePoints(int points) {}
	public void enableShockWave() {}
	
}
