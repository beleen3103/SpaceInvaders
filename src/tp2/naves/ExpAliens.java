package tp2.naves;

import tp2.Game;
import tp2.weapon.Weapon;

public class ExpAliens extends AlienShip{

	public ExpAliens(Game game, int x, int y, int live, int pts) {
		super(game, x, y, live, pts);
	}
	@Override
	public void onDelete() {
		game.getPlayer().receivePoints(pts);
		/*
		for(int j = objects[i].getX() - 1; j <= objects[i].getX() + 1; j++) {
			for(int w = objects[i].getY() - 1; w <= objects[i].getY() + 1; w++) {
				if(getObjectInPosition(j, w) != null) {
					getObjectInPosition(j, w).getDamage(1);
				}
			}
		}
	}*///ON DELETE
	}
	
	public String toString() {
		return " E[" + live + "] ";
	}
	public String toStringify() {
		return "\nE;" + x + ";" + y + ";" + live + ";" + mov + ";" + right;
	}
	public void computerAction() {}
	public void deleteWeapon() {}
	public Weapon getWeapon() {return null;}
	public boolean receiveBombAttack(int damage) {return false;}

}
