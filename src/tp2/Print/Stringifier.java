package tp2.Print;

import tp2.Game;

public class Stringifier extends GamePrinter{
	Game game;
	public Stringifier(Game game) {
		this.game = game;
	}
	public Stringifier() {}

	public String toString() {
		String aux = "--- Space Invaders v2.0 ---\n\n";
		aux += game.toStringify();

		return aux;
	}
}
