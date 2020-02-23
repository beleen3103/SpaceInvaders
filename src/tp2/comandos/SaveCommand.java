package tp2.comandos;

import tp2.Game;
import tp2.Print.GamePrinter;
import tp2.Print.Stringifier;

import java.io.*;

public class SaveCommand extends Command{
	String nombreFich, aux;
	public SaveCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}
	public boolean execute(Game game) {
		GamePrinter draw = new Stringifier(game);
		aux = nombreFich + ".dat";
		try(BufferedWriter output = new BufferedWriter(new FileWriter(aux))){
			output.write(draw.toString());
			System.out.println("Game successfully saved in file <" + nombreFich + ">.dat.");
		}
		catch(IOException e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
	public Command parse(String[] commandWords) {
		try {
			if(commandWords[0].equals(name) || commandWords[0].equals(shortcut)) {
				nombreFich = commandWords[1];
				return this;
			}
		}
		catch(IndexOutOfBoundsException e) {
			System.err.println("Aniade el nombre del fichero");
		}
		return null;
	}
}