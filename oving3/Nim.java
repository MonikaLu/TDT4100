package encapsulation;

public class Nim {
	
	public int pile1;
	public int pile2;
	public int pile3;
	public int targetPile;
	
	public void removePieces(int number, int targetPile) {
		this.targetPile = targetPile;
		if (number <= 1) {
			throw new IllegalStateException("The number needs to be 1 or more than 1!");
		}
		if (targetPile > 2) {
			throw new IllegalStateException("You can only choose between 0, 1 and 2.");
		}
		else if (targetPile < 0) {
			throw new IllegalStateException("You can only choose between 0, 1 and 2.");
		}
		if (isGameOver() == true) {
			throw new IllegalStateException("The game is over!");
		}
		switch(targetPile) {
		case 0:
			pile1 -= number;
			break;
		case 1:
			pile2 -= number;
			break;
		case 2:
			pile3 -= number;
		}

	}
	
	public boolean isValidMove(int number, int targetPile) {
		if (number >= 1) {
			return true;
		}
		else if (pile1 == 0) {
			return false;
		}
		else if (pile2 == 0) {
			return false;
		}
		else if (pile3 == 0) {
			return false;
		}
		else {
			return false;
		}
	}
	
	public boolean isGameOver() {
		if (pile1 == 0) {
			return true;
		}
		else if (pile2 == 0) {
			return true;
		}
		else if (pile3 == 0) {
			return true;
		}
		return false;
	}
	
	public int getPile(int targetPile) {
		if(targetPile > 2) {
			throw new IllegalStateException("not a valid pile");
		}
		this.targetPile = targetPile;
		switch(targetPile) {
		case 0:
			return pile1;
		case 1:
			return pile2;
		case 2:
			return pile3;
		}
		return -1;
	}
	
	@Override
	public String toString() {
		if (isGameOver() == true) {
			System.out.println("The game is over!");
		}
		else System.out.println("The game is not over!");
		
		String ln2 = "There are " + pile1 + " in the first pile.\n";
		String ln3 = "There are " + pile2 + " in the second pile.\n";
		String ln4 = "There are " + pile3 + " in the third pile.\n";
		return ln2 + ln3 + ln4;
	}
	
	public Nim(int pileSize) {
		this.pile1 = pileSize;
		this.pile2 = pileSize;
		this.pile3 = pileSize;
	}
	
	public Nim() {
		this.pile1 = 10;
		this.pile2 = 10;
		this.pile3 = 10;
	}
	
	public static void main(String[] args) {
		Nim test1 = new Nim(5);
		test1.removePieces(3,2);
		test1.isValidMove(3,2);
		test1.isGameOver();
		test1.getPile(1);
		System.out.println(test1);
	}
	
	
	
}
