package tp2.naves;

import tp2.Game;
import tp2.weapon.Weapon;

public class RegularAliens extends AlienShip{
	public RegularAliens(Game game, int x, int y, int live, int pts) {
		super(game, x, y, live, pts);
	}
	public String toString() {
		return " C[" + live + "] ";
	}
	public String toStringify() {
		return "\nR;" + x + ";" + y + ";" + live + ";" + mov + ";" + right;
	}
	public boolean receiveBombAttack(int damage) {return false;}
	public Weapon getWeapon() {return null;}
	public void computerAction() {}
	public void deleteWeapon() {}
}
