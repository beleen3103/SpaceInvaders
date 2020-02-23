package tp2.naves;

import tp2.Game;
import tp2.interfaces.IExecuteRandomActions;
import tp2.weapon.Weapon;

public class Ovni extends EnemyShip implements IExecuteRandomActions{
	private boolean exist = false;
	
	public Ovni(Game game, int x, int y, int live, int pts) {
		super(game, x, y, live, pts);
	}
	private void respawn() {
		x = 9;
		y = 0;
		live = 1;
		exist = false;
	}
	public String toString() {
		if(exist) return " O[" + live + "] ";
		else return "";
	}
	public void onDelete() {
		if(!isAlive() || isOnPosition(0, 0)) {
			respawn();
			game.getPlayer().receivePoints(pts);
			game.getPlayer().enableShockWave();
		}
	}
	public void move() {
		x--;
	}
	public void computerAction() {
		if(IExecuteRandomActions.canGenerateRandomOvni(game) && exist == false) {
			exist = true;
		}
	}
	public String toStringify() {
		return "\nO;" + x + ";" + y + ";" + live; 
	}
	public boolean receiveBombAttack(int damage) {return false;}
	public boolean receiveExplosion(int damage) {return false;}
	public boolean getRight() {return false;}
	public Weapon getWeapon() {return null;}
	public void bajar() {}
	public void deleteWeapon() {}
	
}
