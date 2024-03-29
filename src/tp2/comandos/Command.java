package tp2.comandos;

import tp2.Game;
import tp2.Exception.CommandExecuteException;
import tp2.Exception.CommandParseException;

public abstract class Command {
	protected final String name;
	

	protected final String shortcut;
	private final String details;
	private final String help;
	protected static final String incorrectNumArgsMsg = "Incorret argument number";
	protected static final String incorrectArgsMsg = "Incorret argument format";
	
	public Command(String name, String shortcut, String details, String help) {
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}
	
	public abstract boolean execute(Game game) throws CommandExecuteException;
	public abstract Command parse(String[] commandWords) throws CommandParseException;
	
	protected boolean matchCommandName(String name) {
		return this.shortcut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name);
	}
	
	public String helpText(){
		return details + " : " + help + "\n";
	}
	
	public String getName() {
		return name;
	}
}