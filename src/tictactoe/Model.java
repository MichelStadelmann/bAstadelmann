package tictactoe;

import java.io.IOException;
import java.net.Socket;

import messages.ChangeMsg;
import messages.Message;

public class Model {

	private String[] board = new String[9];

	// Player X begins the game
	private Boolean turnX = true;
	private Boolean turnY = false;

	private int counter = 0;

	private GameStat gamy;

	private ServiceLocator serviceLocator;

	private Socket socket;

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

	// public void connect(String name, String ip, int port) {
	// logger.info("Connect");
	// this.name = name;
	// try {
	// socket = new Socket(ip, port);
	//
	// // Create thread to read incoming messages
	// Runnable r = new Runnable() {
	//
	// @Override
	// public void run() {
	// while (true) {
	//
	// GameMsg gMsg = (GameMsg) Message.receive(socket);
	// newestState.set(gMsg.getState());
	// }
	//
	// }
	//
	// };
	// Thread t = new Thread(r);
	// t.start();
	//
	// // Send game state update message to the server
	// Message msg = new GameMsg(controller.getIndex(),
	// view.getBtn()[1].getText());
	// msg.send(socket);
	//
	// } catch (Exception e) {
	// logger.warning(e.toString());
	// }
	//
	// }
	//
	// public void disconnect() {
	// logger.info("Disconnect");
	// if (socket != null)
	// try {
	// socket.close();
	// } catch (IOException e) {
	//
	// }
	//
	// }

	public void sendMessage(int index) throws IOException {
		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("send Boardchange");
		Message change = new ChangeMsg(index);
		Socket socket = new Socket("localhost", 22222);
		change.send(socket);
	}

}
