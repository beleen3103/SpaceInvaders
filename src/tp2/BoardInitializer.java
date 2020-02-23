package tp2;

import tp2.naves.AlienShip;
import tp2.naves.DestroyerAliens;
import tp2.naves.Ovni;
import tp2.naves.RegularAliens;

public class BoardInitializer {
	
	private Level level;
	private GameObjectBoard board;
	private Game game;
	
	public GameObjectBoard initialize(Game game, Level level) {
		this.level = level;
		this.game = game;
		board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);

		initializeOvni();
		initializeRegularAliens();
		initializeDestroyerAliens();
		return board;
	}
	
	private void initializeOvni() {
		Ovni ovni = new Ovni(game, 9, 0, 1, 25);
		board.add(ovni);
	}
	
	private void initializeRegularAliens() {
		RegularAliens rAlien;
		for(int i = 0; i < level.getNumRegularAliensPerRow(); i++) {
			rAlien = new RegularAliens(game, i + 3, 1, 2, 5);
			board.add(rAlien);
			AlienShip.remainingAliens++;
		}
		if(level.getNumRowsOfRegularAliens() == 2) {
			for(int i = 0; i < level.getNumRegularAliensPerRow(); i++) {
				rAlien = new RegularAliens(game, i + 3, 2, 2, 5);
				board.add(rAlien);
				AlienShip.remainingAliens++;
			}
		}
	}
	
	private void initializeDestroyerAliens() {
		int y, x;
		DestroyerAliens dAlien;
		if(level.getNumRowsOfRegularAliens() == 1) y = 2;
		else y = 3;
		if(level.getNumDestroyerAliens() == 2) x = 4;
		else x = 3;
		for(int i = 0; i < level.getNumDestroyerAliens(); i++) {
			dAlien = new DestroyerAliens(game, i + x, y, 1, 10);
			board.add(dAlien);
			AlienShip.remainingAliens++;
		}
	}
}
