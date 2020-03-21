package app;

public interface SaveGameInterface {
	public void createFile();
	public void readFile();
	public void writeToFile();
	
	public static void main(String[] args) {
		SaveGame test = new SaveGame();
		test.createFile();
		test.writeToFile();			//skal ta inn board som parameter og save den til filen.
		test.readFile();
	}
}
