package tp2;

import tp2.interfaces.IExecuteRandomActions;
import tp2.naves.*;
import tp2.weapon.*;

public class GameObjectBoard implements IExecuteRandomActions{
	private GameObject[] objects;
	private int currentObjects;
	
	public GameObjectBoard(int width, int height) {
		objects = new GameObject[width * height];
		AlienShip.right = true;
	}
	
	private int getCurrentObjects() {
		return currentObjects;
	}
	
	public void add (GameObject object) {
		objects[getCurrentObjects()] = object;
		currentObjects++;
	}
	
	public GameObject getObjectInPosition(int x, int y) {
		for(int i = 0; i < getCurrentObjects(); i++) {
			if(objects[i].isOnPosition(x, y)) return objects[i];
		}
		return null;
	}
	
	private int getIndex(GameObject object) {
		for(int i = 0; i < getCurrentObjects(); i++) {
			if(objects[i] == object) return i;
		}
		
		return getCurrentObjects();
	}
	
	private void remove(GameObject object) {
		
		if(!object.isAlive()) {
			
			for(int i = getIndex(object); i < getCurrentObjects(); i++) {
				objects[i]= null;
				objects[i] = objects[i+1];
			}
			currentObjects--;
		}
		/*int pos = 0;
		if(object.getClass() == ExpAliens.class || object.getClass() == RegularAliens.class || object.getClass() == DestroyerAliens.class) {
			AlienShip.remainingAliens--;
			for(int i = 0; i < currentObjects; i++) {
				if(objects[i].getClass() == UCMShip.class) {
					objects[i].receivePoints(object.getPts());
				}
			}
		}
		for(int i = 0; i < currentObjects; i++) {
			if(object.getClass() == objects[i].getClass() && objects[i].isOnPosition(object.getX(), object.getY())) {
				pos = i;
			}
		}
		if(pos != 0) {
			for(int i = pos; i < currentObjects; i++) {
				objects[i] = null;
				objects[i] = objects[i+1];
			}
			currentObjects--;
		}*/
	}
	
	public void update(int currentCycle, Level level) {
		int naves = AlienShip.remainingAliens + 2;//Aliens + Ovni + Player
		if(AlienShip.mov == 0) {
			if(checkBajar(naves)) {
				for(int i = 0; i < naves; i++) {
					if(objects[i].getClass() == RegularAliens.class || objects[i].getClass() == DestroyerAliens.class || objects[i].getClass() == ExpAliens.class) {
						objects[i].bajar();
					}
					if(objects[i].getClass() == Ovni.class) {
						objects[i].move();
					}
				}
			}
			else {
				for(int i = 0; i < naves; i++) {
					if(objects[i].getClass() == RegularAliens.class || objects[i].getClass() == DestroyerAliens.class || objects[i].getClass() == ExpAliens.class) {
						objects[i].move();
					}
					if(objects[i].getClass() == Ovni.class) {
						objects[i].move();
					}
				}
			}
			AlienShip.mov = level.getNumCyclesToMoveOneCell() - 1;
		}
		else AlienShip.mov--;
		
		for(int i = naves; i < currentObjects; i++) {//
			if(objects[i].getClass() == Misil.class || objects[i].getClass() == Bomba.class) {
				objects[i].move();
				checkAttacks(objects[i]);
			}
		}
		for(int i = 0; i < naves; i++) {
			if(objects[i].getClass() == ExpAliens.class && !objects[i].isAlive()) {
				for(int j = objects[i].getX() - 1; j <= objects[i].getX() + 1; j++) {
					for(int w = objects[i].getY() - 1; w <= objects[i].getY() + 1; w++) {
						if(getObjectInPosition(j, w) != null) {
							getObjectInPosition(j, w).getDamage(1);
						}
					}
				}
				remove(objects[i]);
				i -= 2;
			}
		}
		removeDead();
	}
	
	private void checkAttacks(GameObject object) {
		for(int i = 0; i < currentObjects; i++) {
			if(object.getClass() == Misil.class && objects[i].getClass() != Misil.class) {
				if(objects[i].isOnPosition(object.getX(), object.getY())) {
					objects[i].receiveMissileAttack(object.getDmg());
					object.getDamage(1);
				}
			}
			else if(object.getClass() == Bomba.class && objects[i].getClass() != Bomba.class) {
				if(objects[i].isOnPosition(object.getX(), object.getY())) {
					objects[i].receiveBombAttack(1);
					object.getDamage(1);
				}
			}
		}
	}
	
	public void computerAction() {
		for(int i = 0; i < currentObjects; i++) {
			if(objects[i].getClass() == RegularAliens.class) {
				if(IExecuteRandomActions.canTurnRegToExp(objects[i].game)) {
					objects[i] = new ExpAliens(objects[i].game, objects[i].getX(), objects[i].getY(), objects[i].getLive(), objects[i].getPts());
				}
			}
			objects[i].computerAction();
		}
	}
	
	private void removeDead() {	
		for(int i = 0; i < AlienShip.remainingAliens + 2; i++) {
			if(objects[i].getWeapon() != null) {
				if(!objects[i].getWeapon().isAlive()) {
					remove(objects[i].getWeapon());
					objects[i].deleteWeapon();
				}
			}
			if(!objects[i].isAlive() && i < AlienShip.remainingAliens) {
				objects[i].onDelete();
				remove(objects[i]);
				i--;
			}
			else if(i > AlienShip.remainingAliens) {
				objects[i].onDelete();
			}
		}
	}
	
	public String toString(int x, int y) {
		GameObject aux = getObjectInPosition(x, y);
		if (aux == null) return "";
		else return aux.toString();
	}

	public void shockWave() {
		int naves = AlienShip.remainingAliens + 2;//Aliens + Ovni + Player
		for(int i = 0; i < naves; i++) {
			objects[i].receiveShockWaveAttack(1);
		}
	}
	
	private boolean checkBajar(int naves) {
		for (int i = 0; i < naves; i++) {
			if(objects[i].getClass() == RegularAliens.class || objects[i].getClass() == DestroyerAliens.class || objects[i].getClass() == ExpAliens.class) {
				if(objects[i].getX() == 8 && AlienShip.right || (objects[i].getX() == 0 && !AlienShip.right)) {
					if(AlienShip.right) AlienShip.right = false;
					else AlienShip.right = true;
					return true;
				}
			}
		}
		return false;
	}
	
	public String toStringify() {
		String aux = "";
		for(int i = 0; i < currentObjects; i++) {
			aux += objects[i].toStringify();
		}
		return aux;
	}
}
