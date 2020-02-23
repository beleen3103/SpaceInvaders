package tp2.comandos;

import tp2.Game;
import tp2.Exception.CommandExecuteException;

public class BuySuperMisilCommand extends Command {

	public BuySuperMisilCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}
	public boolean execute(Game game) throws CommandExecuteException {
		try {
			if(!game.buySuper()) exception();
		}
		catch(CommandExecuteException e) {
			throw new CommandExecuteException("Not enough points, SuperMissile = 20pts", e);
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
