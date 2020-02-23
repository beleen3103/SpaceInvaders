package tp2.comandos;

import tp2.Game;
import tp2.Exception.CommandExecuteException;

public class ShootCommand extends Command{
	public ShootCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}
	public boolean execute(Game game) throws CommandExecuteException{
		try {
			if(!game.shootMissile()) exception();
		}
		catch(CommandExecuteException e){
			throw new CommandExecuteException("No puedes disparar mas de un misil", e);
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
