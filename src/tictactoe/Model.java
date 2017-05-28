package tictactoe;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Logger;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import messages.BoardMsg;
import messages.GameMsg;
import messages.Message;

public class Model {

	private String[] board = new String[9];

	// Player X begins the game
	private Boolean turnX = true;
	private Boolean turnY = false;
	private Number buttonIndex = 0;

	private volatile boolean stop = false;

	private int counter = 0;

	private GameStat gamy;

	private ServiceLocator serviceLocator;

	private Socket socket;

	private String name;
	private Logger logger = Logger.getLogger("");

	protected SimpleStringProperty newestMessage = new SimpleStringProperty();
	protected SimpleIntegerProperty actualIndex = new SimpleIntegerProperty();
	protected SimpleStringProperty updateTurn = new SimpleStringProperty();

	private View view;

	/**
	 * The method update does two things: First it actualizes the state of
	 * board. It collects the drawn symbols in an String array. In a second step
	 * it compares the values in the array with the win combinations if there is
	 * already a winning combination.
	 * 
	 * Note: the tiles are counted from top down
	 * 
	 * @param index
	 * @param state
	 */

	public void update(int index, String state) {
		gamy = new GameStat(index, state);
		board[index] = state;
		for (String s : board)
			System.out.println(s);
		counter++;

		if (counter == 9) {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Unentschieden!");
			alert.setHeaderText("Spiel zu Ende");
			alert.setContentText("Kein Spieler konnte sich durchsetzen!");

			alert.showAndWait();

		}

		checkVictory();

	}

	/**
	 * This method checks all horizontal, vertical and diagonal win conditions
	 * and gives out an alert message to end the game
	 */

	private void checkVictory() {

		if (board[0] == "X" && board[1] == "X" && board[2] == "X"
				|| (board[3] == "X" && board[4] == "X" && board[5] == "X")
				|| (board[6] == "X" && board[7] == "X" && board[8] == "X")
				|| (board[0] == "X" && board[3] == "X" && board[6] == "X")
				|| (board[1] == "X" && board[4] == "X" && board[7] == "X")
				|| (board[2] == "X" && board[5] == "X" && board[8] == "X")
				|| (board[0] == "X" && board[4] == "X" && board[8] == "X")
				|| (board[2] == "X" && board[6] == "X" && board[6] == "X")) {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Spieler X hat gewonnen!");
			alert.setHeaderText("Spiel zu Ende");
			alert.setContentText("Spieler X hat gewonnen!");

			alert.showAndWait();
		}

		if (board[0] == "O" && board[1] == "O" && board[2] == "O"
				|| (board[3] == "O" && board[4] == "O" && board[5] == "O")
				|| (board[6] == "O" && board[7] == "O" && board[8] == "O")
				|| (board[0] == "O" && board[3] == "O" && board[6] == "O")
				|| (board[1] == "O" && board[4] == "O" && board[7] == "O")
				|| (board[2] == "O" && board[5] == "O" && board[8] == "O")
				|| (board[0] == "O" && board[4] == "O" && board[8] == "O")
				|| (board[2] == "O" && board[6] == "O" && board[6] == "O")) {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Spieler O hat gewonnen!");
			alert.setHeaderText("Spiel zu Ende");
			alert.setContentText("Spieler O hat gewonnen!");

			alert.showAndWait();
		}

		else {
		}
		;

	}

	/**
	 * Methods for Networking games
	 * 
	 * @param name
	 * @param ip
	 * @param port
	 */

	public void connect(String ip, int port, String name) {
		logger.info("Connect");
		this.name = name;

		try {
			socket = new Socket(ip, port);

			// Create thread to read incoming messages
			// Runnable r = new Runnable as an inner class
			Runnable r = new Runnable() {

				@Override
				public void run() {
					while (!stop) {
						try {
							Message msg = Message.receive(socket);
							if (msg instanceof BoardMsg) {
								newestMessage.set(((BoardMsg) msg).getSign());
								actualIndex.set(((BoardMsg) msg).getIndex());

							}
							if (msg instanceof GameMsg) {
								System.out.println("Client erhält Zug");
								updateTurn.set(((GameMsg) msg).getTurn());
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				}

			};
			Thread t = new Thread(r);
			t.start();

			// Send join message to the server
			Message msg = new messages.JoinMsg(name);
			msg.send(socket);

		} catch (Exception e) {
			logger.warning(e.toString());
		}

	}

	public void disconnect() {
		logger.info("Disconnect");
		stop = true;
		if (socket != null)
			try {
				socket.close();
				logger.info("Disconnected");
			} catch (IOException e) {

			}
	}

	// public void sendMessage(int index) throws IOException {
	// serviceLocator = ServiceLocator.getServiceLocator();
	// serviceLocator.getLogger().info("send Boardchange");
	// Message change = new ChangeMsg(index);
	// change.send(socket);
	// }

	public void sendMessage(int index, String message) {
		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Client sends Board-Message");
		serviceLocator.getLogger().info(name);
		Message boardMsg = new BoardMsg(name, index, message);
		boardMsg.send(socket);
	}

	public void sendMessage(String turn) {
		Message gameMsg = new GameMsg(turn);
		gameMsg.send(socket);
		System.out.println("Hello");
	}

	public void changeTurn(String turn) {
		String x = new String();
		String y = new String();
		if (turn == x) {
			turnX = true;
			turnY = false;
			System.out.println("Hello");
		}
		if (turn == y) {
			turnY = true;
			turnX = false;
		}

	}

	public Number getButtonIndex() {
		return buttonIndex;
	}

	public void setButtonIndex(Number newValue) {
		this.buttonIndex = newValue;
	}

	public GameStat getGamy() {
		return gamy;
	}

	public void setGamy(GameStat gamy) {
		this.gamy = gamy;
	}

	public Boolean getTurnY() {
		return turnY;
	}

	public void setTurnY(Boolean turnY) {
		this.turnY = turnY;
	}

	public Boolean getTurnX() {
		return turnX;
	}

	public void setTurnX(Boolean turnX) {
		this.turnX = turnX;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

}