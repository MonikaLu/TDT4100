package patterns.delegation;

import java.util.Scanner;

public class HighscoreListProgram implements HighscoreListListener{
	
	private HighscoreList highscoreList;
	
	public void init() {
//		oppretter ny HighscoreList, setter maxSize til 5.
//		registrere HighscoreListProgram som lytter
		this.highscoreList = new HighscoreList(5);
//		bruker metoden fra highscoreList til å legge til dette objektet som listener
		highscoreList.addHighscoreListListener(this);
	}
	
	public void run() {
//		leser inn tall fra konsollet
		Scanner scanner = new Scanner(System.in);
//		så lenge den neste token i scanneren er en int, så skal score være nextInt.
//		legger deretter dette til i resultatet.
		while (scanner.hasNextInt()) {
			int score = scanner.nextInt();
			highscoreList.addResult(score);
		}
		
	}
	
	public void listChanged(HighscoreList list, int pos) {
		for (int i = 0; i < highscoreList.size(); i++) {
			System.out.println(highscoreList.getElement(i) + (pos == i ? (" <=== @ " + pos) : ""));
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		HighscoreListProgram program = new HighscoreListProgram();
		program.init();
		program.run();
	}
	
}
