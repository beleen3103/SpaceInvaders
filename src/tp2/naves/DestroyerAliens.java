package tp2.naves;

import tp2.Game;
import tp2.interfaces.IExecuteRandomActions;
import tp2.weapon.Bomba;
import tp2.weapon.Weapon;

public class DestroyerAliens extends AlienShip implements IExecuteRandomActions{
	
	Bomba bomb;
	
	public DestroyerAliens(Game game, int x, int y, int live, int pts) {
		super(game, x, y, live, pts);
	}
	public String toString() {
		return " D[" + live + "] ";
	}	
	@Override
	public Weapon getWeapon() {
		if(bomb != null) return bomb;
		else return null;
	}
	public void deleteWeapon() {
		bomb = null;
	}
	public void computerAction() {
		if(IExecuteRandomActions.canGenerateRandomBomb(game) && bomb == null) {
			bomb = new Bomba(game, x, y, 1);
			game.addObject(bomb);
		}
	}
	public String toStringify() {
		return "\nD;" + x + ";" + y + ";" + live + ";" + mov + ";" + right;
	}
	public boolean receiveBombAttack(int damage) {return false;}
}
