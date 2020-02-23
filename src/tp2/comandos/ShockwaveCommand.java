package tp2.comandos;

import tp2.Game;
import tp2.Exception.CommandExecuteException;

public class ShockwaveCommand extends Command{
	public ShockwaveCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}
	public boolean execute(Game game) throws CommandExecuteException{
		try {
			if(!game.shockWave()) exception();
		}
		catch(CommandExecuteException e) {
			throw new CommandExecuteException("ShockWave no disponible, elimina un Ovni", e);
		}
		return true;
	}
	private void exception() throws CommandExecuteException{
		throw new CommandExecuteException();
	}
	public Command parse(String[] commandWords) {
		if(commandWords[0].equals(name) || commandWords[0].equals(shortcut)) {
			return this;
		}
		return null;
	}

}
