package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import messages.GameMsg;
import tictactoe.ServiceLocator;

/**
 * 
 * tbd
 * 
 * @author mosta
 *
 */

public class ServerModel {

	private ServerSocket listener;
	private Socket socket;
	private static int client_id = 0;
	ServiceLocator serviceLocator;
	public volatile boolean stop = false;

	// List for the current clients
	protected final ObservableList<Client> clients = FXCollections.observableArrayList();

	public static void setUpUser(String player, String ip, int port) {

	}

	public void startServer(int port) throws IOException {
		try {
			listener = new ServerSocket(port, 2, null);
			serviceLocator = ServiceLocator.getServiceLocator();
			serviceLocator.getLogger().info("Server started - waiting for Player");
			Runnable r = new Runnable() {
				@Override
				public void run() {
					while (!stop && client_id < 2) {
						try {
							Socket socket = listener.accept();
							// Client vs Clientcommunication
							Client client = new Client(client_id, socket);
							clients.add(client);
							client_id++;
						} catch (Exception e) {
							serviceLocator = ServiceLocator.getServiceLocator();
							serviceLocator.getLogger().info(e.toString());
						}
					}

				}
			};
			Thread t = new Thread(r, "Server Socket");
			t.start();
		} catch (IOException e) {
			serviceLocator = ServiceLocator.getServiceLocator();
			serviceLocator.getLogger().info(e.toString());

		}

	}

	// else {
	// serviceLocator = ServiceLocator.getServiceLocator();
	// serviceLocator.getLogger().info("Let the games begin");
	// break;
	// }
	// }
	// } catch (BindException e) {
	// serviceLocator = ServiceLocator.getServiceLocator();
	// serviceLocator.getLogger().info("This port is already in use");

	// }

	public void stopServer() {
		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Stop all clients");
		for (Client c : clients)
			c.stop();

		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Stop the server");
		stop = true;
		if (listener != null) {
			try {
				listener.close();
			} catch (IOException e) {

			}
		}

	}

	public void broadcast(GameMsg outMsg) {
		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Broadcasting message to clients");
		for (Client c : clients) {
			c.send(outMsg);
		}

	}

}