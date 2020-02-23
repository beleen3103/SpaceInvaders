package tp2;

import java.util.Scanner;

import tp2.Exception.*;
import tp2.Print.BoardPrinter;
import tp2.Print.GamePrinter;
import tp2.comandos.Command;
import tp2.comandos.CommandGenerator;
import tp2.naves.AlienShip;


public class Controller {
	
	Game game;
	Scanner myObj = new Scanner(System.in);
	
	public Controller(Game game) {
		this.game = game;
	}
	
	public void run() {
		
		while(!game.isFinished()) {
			boolean next = true, rst = false;
			
			//Print//
			if(next) {
				System.out.println(game.infoToString());
				GamePrinter draw = new BoardPrinter(game, 8, 9);
				System.out.println(draw);
			}
			
			//Take the command//
			System.out.println("Enter command:");
			String[] words = myObj.nextLine().toLowerCase().trim().split ("\\s+");
			try {
				Command command = CommandGenerator.parseCommand(words);
				if (command != null) {
					if (command.execute(game)) {
						next = true;
						System.out.println(AlienShip.remainingAliens);
						if(command.getName().equalsIgnoreCase("reset")) rst = true;
					}
					else next = false;	
				}
				else {
					//System.out.format("unknownCommandMsg\n");
					next = false;
				}
			}
			catch(CommandParseException | CommandExecuteException | NumberFormatException ex){
				System.err.format(ex + ex.getMessage());
				System.out.println("\n");
				next = false;
			}
			if(next && !rst) {
				game.update();
			}
			rst = false;
		}
		System.out.println(game.infoToString());
		GamePrinter draw = new BoardPrinter(game, 8, 9);
		System.out.println(draw);
		System.out.println(game.getWinnerMessage());//
	}
	/*public void run() {
		boolean next = true, rst = false;
		
		while (!game.isFinished()){
			if(next) {
				System.out.println(game.infoToString());
				GamePrinter draw = new BoardPrinter(game, 8, 9);
				System.out.println(draw);
			}
			System.out.println("Introduce comando:");
			String[] words = myObj.nextLine().toLowerCase().trim().split ("\\s+");
			try {
				Command command = CommandGenerator.parseCommand(words);
				if (command != null) {
					if (command.execute(game)) {
						//System.out.println(game);
						next = true;
						if(command.getClass() == ResetCommand.class) rst = true;
					}
					else next = false;	
				}
				else {
					System.out.format("unknownCommandMsg\n");
					next = false;
				}
			}
			catch(CommandParseException | CommandExecuteException | NumberFormatException ex){
				System.err.format(ex + ex.getMessage());
				System.out.println("\n");
				next = false;
			}
			if(next && !rst) {
				game.update();
			}
			rst = false;
		}
		System.out.println(game.infoToString());
		GamePrinter draw = new BoardPrinter(game, 8, 9);
		System.out.println(draw);
		System.out.println(game.getWinnerMessage());//
	}*/
}
