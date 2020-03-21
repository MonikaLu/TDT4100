package app;

public class Gameboard {
	public String currentPlayerMark = "X";
	public String[] brett = {"-", "-", "-", "-", "-", "-", "-", "-", "-"};
	
	
	public void placeMark(int position) {
		brett[position] = currentPlayerMark;
	}
	
	
	public boolean isBoardFull() {
		
		for (int j = 0; j < 9; j++) {
			if (brett[j] == "-") {
				return false;				
			}
		}
		return true;
		//sjekke om brettet er fullt
	}
	
	public boolean checkWin() {
	for (int a = 0; a < 8; a++) {
		String line = null;
		switch (a) {
			case 0:
				line = brett[0] + brett[1] + brett[2]; //Sjekker top vannrett
				break;
			case 1:
				line = brett[3] + brett[4] + brett[5]; //Sjekker midten vannrett
				break;
			case 2:
				line = brett[6] + brett[7] + brett[8]; //Sjekker bunn vannrett
				break;
			case 3:
				line = brett[0] + brett[3] + brett[6]; //Sjekker venstre loddrett
				break;
			case 4:
				line = brett[1] + brett[4] + brett[7]; //Sjekker midten loddrett
				break;
			case 5:
				line = brett[2] + brett[5] + brett[8]; //Sjekker h�yre loddrett
				break;
			case 6:
				line = brett[0] + brett[4] + brett[8]; //Sjekker fra top venstre til bunn h�yere diagonal
				break;
			case 7:
				line = brett[2] + brett[4] + brett[6]; //Sjekker fra top h�yre til bunn venstre diagonal
				break;
		}
		
		if (line.equals("XXX")) {
			return true;
		}
		else if (line.equals("OOO")) {
			return true;
		}
	}
	return false;
}
	
	public boolean checkTied() {
		if (checkWin() == false && isBoardFull()) {
			return true;
		}
		return false;
	}
	
	public void changeMark() {
		if (currentPlayerMark == "X") {
			currentPlayerMark = "O";
		}
		else {
			currentPlayerMark = "X";
		}
	} 
	
	public String getCurrentPlayerMark() {
		return this.currentPlayerMark;
	}
	
	@Override
	public String toString() {
		String tekst = "";
		for(int i = 0; i < 9; i++) {
			tekst += brett[i];
		}
		return tekst;
	}
	
	
}
	

