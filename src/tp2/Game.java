package tp2;

import java.util.Random;

import tp2.Print.PrinterTypes;
import tp2.comandos.CommandGenerator;
import tp2.interfaces.IPlayerController;
import tp2.naves.AlienShip;
import tp2.naves.UCMShip;


public class Game implements IPlayerController {
	public final static int DIM_X = 9;
	public final static int DIM_Y = 8;
	private int currentCycle;
	private Random rand;
	private Level level;
	GameObjectBoard board;
	private UCMShip player;
	private boolean doExit;
	private BoardInitializer initializer;
	
	public Game(Level level, Random random){
		this.level = level;
		this.rand = random;
		initializer = new BoardInitializer();
		initGame();		
	}
	
	public void initGame() {
		currentCycle = 0;
		board = initializer.initialize(this, level);
		player = new UCMShip(this, DIM_X/2, DIM_Y-1);
		board.add(player);
	}
	
	public Random getRandom() {
		return rand;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public void reset() {
		initGame();
	}
	
	public void addObject(GameObject object) {
		board.add(object);
	}
	
	public String positionToString(int x, int y) {
		return board.toString(x, y);
	}
	
	public boolean isFinished() {
		return playerWin() || aliensWin() || doExit;
	}
	
	public boolean aliensWin() {
		return !player.isAlive() || AlienShip.haveLanded();
	}
	
	public boolean playerWin() {
		return AlienShip.allDead();
	}
	
	public void update() {
		//board.computerAction();
		//board.update();
		//currentCycle++;
		currentCycle++;
		board.computerAction();
		board.update(currentCycle, level);
	}
	
	public boolean isOnBoard(int x, int y) {
		return board.getObjectInPosition(x, y) != null;
	}
	
	public void exit() {
		doExit = true;
	}
	
	public String infoToString() {
		String aux = "";
        aux += "Life: " + player.getLive();
        if(player.getShock() != null) aux += "\nShockWave: Yes";
        else aux += "\nShockWave: No";
        aux += "\nNumber of SuperMissiles: " + player.getSuper() +
        	   "\nNumber of cycles: " + currentCycle +
               "\nPoints: " + player.getPts() +
               "\nRemaining aliens: " + AlienShip.remainingAliens;	
        return aux;
	}
	
	public String getWinnerMessage() {
		if (playerWin()) return "Player win!";
		else if (aliensWin()) return "Aliens win!";
		else if (doExit) return "Player exits the game";
		else return "This should not happen";
	}
	
	//IPlayerController//
	public boolean move(int numCells, String dir) {
		if(player.move(numCells, dir)) return true;
		else return false;
	}
	
	public boolean shootMissile() {
		if(player.shootMissile()) return true;
		else return false;
	}
	
	public boolean shockWave() {
		if(player.shockWave()) {
			board.shockWave();
			return true;
		}
		else return false;
	}
	
	public void receivePoints(int points) {
		player.receivePoints(points);
		
	}

	public void enableShockWave() {
		// TODO Auto-generated method stub
		
	}

	public void enableMissile() {
		// TODO Auto-generated method stub
		
	}
	
	//OTROS//
	public UCMShip getPlayer() {
		return player;
	}
	
	public GameObjectBoard getBoard() {
		return board;
	}
	
	public boolean buySuper() {
		if(player.buySuper()) return true;
		else return false;
	}
	
	public String help() {
        return CommandGenerator.commandHelp();
    }
	
	public String list() {
        return "[R]egular Ship: Points: 5 - Harm: 0 - Shield: 2\n" + 
        	   "[E]xploding Ship: Points: 5 - Harm: 0 - Shield: 1\n" +
               "[D]estroyer Ship: Points: 10 - Harm: 1 - Shield: 1\n" + 
               "[O]vni: Points: 25 - Harm: 0 - Shield: 1\n"+
               "^__^: Harm: 1 - Shield: 3";
    }
	
	public String printerListToString() {
		return PrinterTypes.printerHelp(this);
	}
	
	public String toStringify() {
		return "G;" + currentCycle +
		       "\nL;" + getLevel() +
		       board.toStringify();
	}
}
