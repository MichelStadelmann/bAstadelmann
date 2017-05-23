package tictactoe;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Logger;

import javafx.beans.property.SimpleStringProperty;
import messages.BoardMsg;
import messages.Message;
import server.Client;

public class Model {

	private String[] board = new String[9];

	// Player X begins the game
	private Boolean turnX = true;
	private Boolean turnY = false;
	
	private volatile boolean stop = false;

	private int counter = 0;

	private GameStat gamy;

	private ServiceLocator serviceLocator;

	private Socket socket;

	private String name;
	private Logger logger = Logger.getLogger("");

	protected SimpleStringProperty newestMessage = new SimpleStringProperty();

	private View view;

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

		// toDo: examine switch statement for less code

		// vertical win condition

		checkVictory(state);

		// if (board[0] == "X" && board[1] == "X" && board[2] == "X") {
		// System.out.println("Player 1 has won");
		// }
		//
		// if (board[4] == "X" && board[5] == "X" && board[6] == "X") {
		// System.out.println("Player 1 has won");
		// }
		//
		// if (board[7] == "X" && board[8] == "X" && board[9] == "X") {
		// System.out.println("Player 1 has won");
		// }
		//
		// // horizontal win condition
		//
		// if (board[0] == "X" && board[4] == "X" && board[7] == "X") {
		// System.out.println("Player 1 has won");
		// }
		//
		// if (board[1] == "X" && board[5] == "X" && board[8] == "X") {
		// System.out.println("Player 1 has won");
		// }
		//
		// if (board[2] == "X" && board[6] == "X" && board[9] == "X") {
		// System.out.println("Player 1 has won");
		// }
		//
		// // diagonal win condition
		//
		// if (board[0] == "X" && board[5] == "X" && board[9] == "X") {
		// System.out.println("Player 1 has won");
		// }
		//
		// if (board[2] == "X" && board[5] == "X" && board[7] == "X") {
		// System.out.println("Player 1 has won");
		// }
		//
		// //
		//
		// if (board[0] == "Y" && board[1] == "Y" && board[2] == "Y") {
		// System.out.println("Player 2 has won");
		// }

		// else if (counter == 9) {
		// System.out.println("Tie Game!");
		// }

	}

	private void checkVictory(String state) {

		if (board[0] == "X" && board[1] == "X" && board[2] == "X") {
			System.out.println("Player 1 has won");
		}

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
						BoardMsg bMsg;
						try {
							bMsg = (BoardMsg) Message.receive(socket);
							System.out.println("Client empfängt Nachricht von Server");
							newestMessage.set(bMsg.getSign());
							System.out.println(bMsg.getSign());
							System.out.println("Update newest message");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// Message msg = Message.receive(socket);
						// if (msg instanceof BoardMsg) {
						// System.out.println("Client empfängt Nachricht von
						// Server");
						// newestMessage.set(((ChangeMsg) msg).getIndex());

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

	public void sendMessage(String message) {
		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Client sends Board-Message");
		serviceLocator.getLogger().info(name);
		Message boardMsg = new BoardMsg(name, message);
		boardMsg.send(socket);
	}

	public void definePlayer() {
		Client client;
		
		
	}
}