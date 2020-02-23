package tp2.comandos;

import tp2.Game;
import tp2.Print.*;

public class StringifyCommand extends Command{
	
	public StringifyCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}
	public boolean execute(Game game) {
		GamePrinter draw = new Stringifier(game);
		System.out.println(draw);
		return false;
	}
	public Command parse(String[] commandWords) {
		if(commandWords[0].equals(name) || commandWords[0].equals(shortcut)) {
			return this;
		}
		return null;
	}
}
