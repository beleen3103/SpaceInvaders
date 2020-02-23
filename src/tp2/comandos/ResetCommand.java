package tp2.comandos;

import tp2.Game;

public class ResetCommand extends Command{

	public ResetCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}
	public boolean execute(Game game) {
		game.reset();
		game = null;
		
		return true;
	}
	public Command parse(String[] commandWords) {
		if(commandWords[0].equals(name) || commandWords[0].equals(shortcut)) {
			return this;
		}
		return null;
	}

}
