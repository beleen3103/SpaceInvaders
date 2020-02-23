package tp2;

public enum Level {
	easy(0.1, 3, 0.5, 4, 2, 1), hard(0.3, 2, 0.2, 8, 2, 2), insane(0.5, 1, 0.1, 8, 4, 2);

	private double shootFrequeny;
	private int numCyclesToMoveOneCell, numRegularAliens, numDestroyerAliens, numRowsOfRegularAliens;
	private double ovniFrequency, turnExplodeFrequency = 0.05;
	
	private Level(double shootFrequeny, int numCyclesToMoveOneCell, double ovniFrequency, int numRegularAliens, int numDestroyerAliens, int numRowsOfRegularAliens) {
		this.shootFrequeny = shootFrequeny;
		this.numCyclesToMoveOneCell = numCyclesToMoveOneCell;
		this.ovniFrequency = ovniFrequency;
		this.numRegularAliens = numRegularAliens;
		this.numDestroyerAliens = numDestroyerAliens;
		this.numRowsOfRegularAliens = numRowsOfRegularAliens;
	}
	
	public double getTurnExplodeFrequency() {
		return turnExplodeFrequency;
	}
	
	public double getShootFrequeny() {
		return shootFrequeny;
	}
	
	public double getOvniFrequency() {
		return ovniFrequency;
	}
	
	public int getNumCyclesToMoveOneCell() {
		return numCyclesToMoveOneCell;
	}
	
	public int getNumRegularAliens() {
		return numRegularAliens;
	}
	
	public int getNumDestroyerAliens() {
		return numDestroyerAliens;
	}
	
	public int getNumRowsOfRegularAliens() {
		return numRowsOfRegularAliens;
	}
	
	public int getNumRegularAliensPerRow(){
		return numRegularAliens/numRowsOfRegularAliens;
	}
	
	public static Level parse(String entrada) {
		for(Level level : Level.values()) {
			if(level.name().equalsIgnoreCase(entrada)) return level;
		}
		return null;
	}
}
