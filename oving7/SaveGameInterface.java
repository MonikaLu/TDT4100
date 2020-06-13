package app;

public interface SaveGameInterface {
	public void createFile();
	public void readFile();
	public void writeToFile(String[] gamestate);

}
