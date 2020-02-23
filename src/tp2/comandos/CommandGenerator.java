package tp2.comandos;

import tp2.Exception.CommandParseException;

public class CommandGenerator {
	private static Command[] availableCommand = {
			new ListCommand("list", "l", "List", "Prints the list of available ships."),
            new HelpCommand("help", "h", "Help", "Prints this help message."),
            new ResetCommand("reset", "r", "Reset", "Starts a new game."),
            new ExitCommand("exit", "e", "Exit", "Terminates the program."),
            new NoneCommand("none", "n", "None", "Skips one cycle."),
            new ShootCommand("shoot", "s", "Shoot", "UCM-Ship launches a missile."),
            new MoveCommand("move", "m", "Move <1|2> <left|right>", "Moves UCM-Ship to the indicated direction."),
            new ShockwaveCommand("shockwave", "w", "shockWave", "UCM-Ship releases a shock wave."),
            new BuySuperMisilCommand("buy", "b", "Buy", "Buy a SuperMissile for 20 points."),
            new StringifyCommand("stringify","sf","StringiFy","Print stringify game"),
            new ListPrinterCommand("listPrinters","lp","ListPrinters","Prints the list of available printers"),
            new SaveCommand("save", "sv", "SaVe", "Save the Game in a File")
	};
	
	public static Command parseCommand(String[] commandWords) throws CommandParseException {
		try {
			for(int i = 0; i < availableCommand.length; i++) {
				if(availableCommand[i].parse(commandWords) != null) {
					return availableCommand[i];
				}
			}
			exception();
			return null;
		}
		catch(CommandParseException e) {
			throw new CommandParseException("unknownCommandMsg", e);
		}
	}
	
	private static void exception() throws CommandParseException{
		throw new CommandParseException();
	}
	
	public static String commandHelp() {
		String aux = "";
		
		for(int i = 0; i < availableCommand.length; i++) {
			aux += availableCommand[i].helpText();
		}
		return aux;
	}
}