package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import messages.Message;
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
	ServiceLocator serviceLocator;
	public volatile boolean stop = false;
	private int userCounter = 0;

	// List for the current clients
	protected final ObservableList<Client> clients = FXCollections.observableArrayList();

	public void startServer(int port) throws IOException {
		try {
			listener = new ServerSocket(port, 2, null);
			serviceLocator = ServiceLocator.getServiceLocator();
			serviceLocator.getLogger().info("Server started - waiting for Player");
			Runnable r = new Runnable() {

				@Override
				public void run() {
					while (!stop) {
						try {
							Socket socket = listener.accept();
							// Client vs Clientcommunication
							Client client = new Client(ServerModel.this, socket);

							clients.add(client);
							userCounter++;
							if (userCounter == 1) {
								// startGame();
							}

							for (Client i : clients) {
								System.out.println((i));
								serviceLocator = ServiceLocator.getServiceLocator();
								serviceLocator.getLogger().info(clients.toString());

							}

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

	public void broadcast(Message msg) {
		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Broadcasting message to clients");
		for (Client c : clients) {
			c.send(msg);
			System.out.println("allen Spielern");
		}

	}

	public ObservableList<Client> getClients() {
		return clients;
	}

	// public void startGame() {
	// serviceLocator = ServiceLocator.getServiceLocator();
	// serviceLocator.getLogger().info("2 player connected - game may start");
	// Message msg = new GameMsg(true);
	// clients.get(0).send(msg);
	//
	// }

}
