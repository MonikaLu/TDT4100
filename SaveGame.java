package app;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

public class SaveGame implements SaveGameInterface {
	
	
	public void createFile(){
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
		//BufferedWriter skriver tekst til outputstream.
		//OutputStreamWriter er en bridge fra character streams til byte streams. new BufferedWriter(new OutputStreamWriter) går alltid sammen.
				new FileOutputStream("filename.txt"), "utf-8"))) {
		//FileOutputStream extends OutputStream. skriver data til en fil eller FileDescriptor.
		}
		//Try tillatter oss til å definere en blokk med koder som tester om det er error.
		//catch blokken definerer hva som skjer hvis det skjer feil i try blokken.
		//finally er en kodeblokk som kjøres etter try-catch uansett hva som skjer
		catch (IOException ex) {
			System.out.println("It doesn't work!");
		}
	}
	
	public void readFile() {
		Scanner in;
		try {
			in = new Scanner(new FileReader("filename.txt"));
			
			while(in.hasNext()) {
				String line = in.nextLine();
				System.out.println(line);
			}
			in.close();
		}
		catch (FileNotFoundException e) {
			System.err.println("Error: the file could not be opened!");
			System.exit(1);
		}
	}
	
	public void writeToFile(String[] gamestate) {
		try {
			PrintWriter outFile = new PrintWriter("filename.txt");
			for(int i = 0; i < gamestate.length; i++) {
				outFile.append(gamestate[i]);
			}
			outFile.close();
		}
		catch (FileNotFoundException e) {
			System.err.println("Error: This doesn't work!");
			System.exit(1);
		}
	}

	@Override
	public void writeToFile() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
