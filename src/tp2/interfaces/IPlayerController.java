package tp2.interfaces;

public interface IPlayerController {
	// Player actions
	public boolean move (int numCells, String dir);
	public boolean shootMissile();
	public boolean shockWave();
	// Callbacks
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();
}
