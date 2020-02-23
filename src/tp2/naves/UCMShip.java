package tp2.naves;

import tp2.Game;
import tp2.weapon.*;
public class UCMShip extends Ship{
	int availableSuper = 0;
	Game game;
	Misil misil;
	Shockwave shock;
	public UCMShip(Game game, int x, int y) {
		super(game, x, y, 3, 0);
		this.game = game;
	}
	public boolean move(int numCells, String dir) {
		if(numCells == 1 || numCells == 2) {
			if(dir.equalsIgnoreCase("right")) {
				if(x + numCells < 9) {
					x += numCells;
				}
				else return false;
			}
			else if (dir.equalsIgnoreCase("left")) {
				if(x - numCells > -1) {
					x -= numCells;
				}
				else return false;
			}
			return true;
		}
		else return false;
	}
	
	public boolean shootMissile() {
		if (misil == null) {
			if(availableSuper > 0) {
				misil = new Misil(game, x, y, 1, 2);
				availableSuper--;
			}
			else misil = new Misil(game, x, y, 1, 1);
			game.addObject(misil);
			return true;
		}
		else return false;
	}
	public void enableShockWave() {
		if (shock == null) {
			shock = new Shockwave(game, 0, 0, 1);
			game.addObject(shock);
		}
	}
	public boolean shockWave() {
		if(shock != null) {
			shock = null;
			return true;
		}
		else return false;
	}
	public String toString() {
		if(live > 0) return " ^__^ ";
		else return " !xx! ";
	}
	
	public void receivePoints(int points) {
		pts += points;
	}
	@Override
	public Weapon getWeapon() {
		if(misil != null) return misil;
		else return null;
	}
	public void deleteWeapon() {
		misil = null;
	}
	
	public boolean receiveBombAttack(int damage) {
		this.getDamage(damage);
		return true;
	}
	public Weapon getShock() {
		if(shock != null) return shock;
		else return null;
	}
	public int getSuper() {
		return availableSuper;
	}
	public boolean buySuper() {
		if(pts >= 20) {
			availableSuper++;
			pts -= 20;
			return true;
		}
		else return false;
	}
	public boolean receiveShockWaveAttack(int damage) {return false;}
	
	public String toStringify() {
		return "\nP;" + x + ";" + y + ";" + live + ";" + pts + ";" + getShock() + ";" + availableSuper;
	}
	public boolean receiveMissileAttack(int damage) {return false;}
	
	public boolean receiveExplosion(int damage) {return false;}
	public boolean getRight() {return false;}
	public void computerAction() {}
	public void onDelete() {}
	public void move() {}
	public void bajar() {}
}
