package tp2.interfaces;

import tp2.Game;

public interface IExecuteRandomActions {
	static boolean canGenerateRandomOvni(Game game) {
		return game.getRandom().nextDouble() < game.getLevel().getOvniFrequency();
	}
	static boolean canGenerateRandomBomb(Game game) {
		return game.getRandom().nextDouble() < game.getLevel().getShootFrequeny();
	}
	static boolean canTurnRegToExp(Game game) {
		return game.getRandom().nextDouble() < game.getLevel().getTurnExplodeFrequency();
	}
}
