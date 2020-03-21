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
	
	private Gameboard game = new Gameboard();
	private Player player1 = new Player();
	private Player player2 = new Player();
	private boolean gameOver = false;
	private SaveGame save = new SaveGame();

	
 	@FXML	
	public void playerInput(ActionEvent Event) {
		this.player1.setPlayername(p1.getText());
		this.player2.setPlayername(p2.getText());
		winner.setText("Welcome! " + this.player1.getPlayername() + " and " + this.player2.getPlayername());
		p1.setEditable(false);
		p2.setEditable(false);
	}
	
	@FXML
	public void saveGame(ActionEvent e) {
		this.save.writeToFile(this.game.brett);
		winner.setText("The game is saved!");
	}
	
	@FXML
	public void resumeGame(ActionEvent e) {
		if (this.game.checkWin()) {
			winner.setText("Game over! Can't resume :( ");
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
			//må fjerne alle brikkene i filen
		}
	

	
	@FXML
	void gameFlow() {
		if (game.checkWin()) {
			winner.setText("The game is ended!");
			this.gameOver = true;
		}
		else if (this.game.checkTied()) {
			winner.setText("It's tied!");
			return;
		}
		game.changeMark();
	}
	
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
	
	@FXML
	public void pressStart(ActionEvent Event) {
		newGame();
		placeMark(null);
		winner.setText(" ");
	} 
	
	
}
