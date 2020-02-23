package tp2.comandos;

import tp2.Game;

public class HelpCommand extends Command {

	public HelpCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}
	public boolean execute(Game game) {
		System.out.println(game.help());
		return false;
	}
	public Command parse(String[] commandWords) {
		if(commandWords[0].equals(name) || commandWords[0].equals(shortcut)) {
			return this;
		}
		return null;
	}
}
