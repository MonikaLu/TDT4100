package app;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Gamecontroller {
	
	//De ulike knappene
	@FXML
	Button start, tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8, tile9, savebtn, resumebtn, rdybtn;
	
	//Tekst for hvem som vinner
	@FXML
	TextField p1, p2, winner;
	
	private Gameboard game;
	private Player player1;
	private Player player2;
	private boolean gameOver = false;
	private SaveGame save;

	//Inputfields with the playernames
 	@FXML	
	public void playerInput(ActionEvent Event) {
		this.player1.setPlayername(p1.getText());
		this.player2.setPlayername(p2.getText());
		winner.setText("Welcome! " + this.player1.getPlayername() + " and " + this.player2.getPlayername());
		p1.setEditable(false);
		p2.setEditable(false);
	}
	
 	//Save the game status
	@FXML
	public void saveGame(ActionEvent e) {
		this.save.writeToFile(this.game.brett);
		winner.setText("The game is saved!");
	}
	
	//metoden som gjør det mulig å fortsette å spille.
	//denne metoden er koblet til "resume" knappen i SceneBuilder.
	//men hvis spillet allerede er over, så er det bare mulig å lagre spillet, men ikke fortsette å spille senere.
	//det vil også komme opp en melding som oppplyser dette.
	//fant ikke en bedre måte å skrive denne kodeblokken på, så det ble litt hardcode.
	//problem: jeg får opp nullPointerException når placeMark(null) kjøres. og det går på at jeg setter inn null som parameter.
	//men vet ikke hvordan jeg ellers kan reuse en event metode utenom å sette inn null istedenfor ActionEvent.
	@FXML
	public void resumeGame(ActionEvent e) {
		if (this.game.checkWin()) {
			winner.setText("Game over! Can't resume :( ");
		}
		else if (this.game.checkTied()) {
			winner.setText("Game over! Can't resume! ");
		}
		else {
		this.save.readFile();
		winner.setText("The game is resumed!");
		tile1.setText(this.game.brett[0]);
		tile2.setText(this.game.brett[1]);
		tile3.setText(this.game.brett[2]);
		tile4.setText(this.game.brett[3]);
		tile5.setText(this.game.brett[4]);
		tile6.setText(this.game.brett[5]);
		tile7.setText(this.game.brett[6]);
		tile8.setText(this.game.brett[7]);
		tile9.setText(this.game.brett[8]);
		placeMark(null);
		}
	}
	
	
	//metoden for at et nytt game skal kunne starte uavhengig av forrige spill.
	@FXML
	public void newGame() {
			tile1.setText(" ");
			tile2.setText(" ");
			tile3.setText(" ");
			tile4.setText(" ");
			tile5.setText(" ");
			tile6.setText(" ");
			tile7.setText(" ");
			tile8.setText(" ");
			tile9.setText(" ");
			placeMark(null);
			gameFlow();
			this.gameOver = false;
			for(int i = 0; i<9; i++) {
				this.game.brett[i] = "-";
			}
			winner.setText(" ");
			//må fjerne alle brikkene i filen
		}
	
	//method for checking if anybody have won, and keep changing the mark if the game is still going on.
	@FXML
	public void gameFlow() {
		if (game.checkWin()) {
			winner.setText("The game is ended!");
			this.gameOver = true;
		}
		else if (this.game.checkTied()) {
			winner.setText("It's tied! Nice play!");
			return;
		}
		game.changeMark();
	}
	
	//method for placing the mark.
	//lage en ny metode som jeg kan reuse istedenfor å  bruke placeMark(MouseEvent event).
	@FXML
	public void placeMark(MouseEvent event) {
		if(this.gameOver == false) {
		Node btn = (Node) event.getSource();
		if (((Labeled) btn).getText() == "X" || ((Labeled) btn).getText() == "O") {
			return;
		}
		
		if(btn == tile1) {
			this.game.placeMark(0);
			((Labeled) btn).setText(game.currentPlayerMark);
			
		}
		if(btn == tile2) {
			this.game.placeMark(1);
			((Labeled) btn).setText(game.currentPlayerMark);
		}
		if(btn == tile3) {
			this.game.placeMark(2);
			((Labeled) btn).setText(game.currentPlayerMark);
		}
		if(btn == tile4) {
			this.game.placeMark(3);
			((Labeled) btn).setText(game.currentPlayerMark);
		}
		if(btn == tile5) {
			this.game.placeMark(4);
			((Labeled) btn).setText(game.currentPlayerMark);
		}
		if(btn == tile6) {
			this.game.placeMark(5);
			((Labeled) btn).setText(game.currentPlayerMark);
		}
		if(btn == tile7) {
			this.game.placeMark(6);
			((Labeled) btn).setText(game.currentPlayerMark);
		}
		if(btn == tile8) {
			this.game.placeMark(7);
			((Labeled) btn).setText(game.currentPlayerMark);
		}
		if(btn == tile9) {
			this.game.placeMark(8);
			((Labeled) btn).setText(game.currentPlayerMark);
		}
		gameFlow();
	}
	}
	
	//the method that keeps the restart button functioning.
	@FXML
	public void pressStart(ActionEvent Event) {
		newGame();
		placeMark(null);
	} 
	
	
}