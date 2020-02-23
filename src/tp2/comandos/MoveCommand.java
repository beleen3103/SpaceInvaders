package tp2.comandos;

import tp2.Game;
import tp2.Exception.CommandExecuteException;
import tp2.Exception.CommandParseException;

public class MoveCommand extends Command{
	private String dir;
	private int numCells;
	public MoveCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}
	public boolean execute(Game game) throws CommandExecuteException{
		try {
			if(!game.move(numCells, dir)) exception();
		}
		catch(CommandExecuteException e) {
			throw new CommandExecuteException("No has podido moverte en esa direccion. Revisa el comando con 'Help'", e);
		}
		return true;
	}
	private void exception() throws CommandExecuteException{
		throw new CommandExecuteException();
	}
	private void parseException() throws CommandParseException{
		throw new CommandParseException();
	}
	public Command parse(String[] commandWords) throws CommandParseException {
		try {
			if(commandWords[0].equals(name) || commandWords[0].equals(shortcut)) {
				if(commandWords.length != 3) parseException();
				numCells = Integer.valueOf(commandWords[1]);
				dir = commandWords[2];
				return this;
			}
		}
		catch(CommandParseException e) {
			throw new CommandParseException("El numero de parametros es incorrecto", e);
		}
		
		return null;
	}

}
