package tp2;

import java.util.Random;

import tp2.Exception.ParameterDifficultException;
import tp2.Exception.ParameterNumberException;

public class Main {
	
	public static void main(String[] args) {
		Level level;
		Random random;
		try {
			if(args.length > 2 || args.length < 1) numberException();
			
			//Choose level parameter//
			level = Level.parse(args[0]);
			if(level == null) difficultException();
			
			//Choose random or seed//
			if(args.length > 1) random = new Random (Long.valueOf(args[1]));
			else random = new Random (System.currentTimeMillis());
			
			//Create game & controller objects//
			Game game = new Game(level, random);
			Controller controlador = new Controller(game);
			
			//Run Game//
			controlador.run();
		}
		catch(ParameterNumberException | ParameterDifficultException e ) {
			System.err.format(e +  e.getMessage());
		}
		catch(RuntimeException e) {
			System.err.format(e + "\nUsage: Main <EASY|HARD|INSANE> [seed]: the seed must be a number");
		}
		
	}
	private static void numberException() throws ParameterNumberException{
		throw new ParameterNumberException("\nUsage: Main <EASY|HARD|INSANE> [seed]");
	}
	private static void difficultException() throws ParameterDifficultException{
		throw new ParameterDifficultException("\nUsage: Main <EASY|HARD|INSANE> [seed]: level must be one of: EASY, HARD, INSANE");
	}
}

