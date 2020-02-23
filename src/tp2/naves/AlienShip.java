package tp2.naves;

import tp2.Game;
import tp2.GameObject;

public abstract class AlienShip extends EnemyShip{
	public static boolean right = true, landed = false;
	public static int remainingAliens = 0;
	public static int mov;
	public AlienShip(Game game, int x, int y, int live, int pts) {
		super(game, x, y, live, pts);
		mov = game.getLevel().getNumCyclesToMoveOneCell() - 1;
	}
	public void move() {
		if(right) x++;
		else x--;
	}
	public void bajar() {
		y++;
		if(y == 7) landed = true;
	}
	public boolean receiveExplosion(int damage) {
		this.getDamage(damage);
		return true;
	}
	
	public static boolean allDead() {
		if(remainingAliens <= 0) return true;
		else return false;
	}
	
	public static boolean haveLanded() {
		return landed;
	}
	
	public void onDelete() {
		game.getPlayer().receivePoints(pts);
	}
}
