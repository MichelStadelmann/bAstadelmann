package tictactoe;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import server.ServerModel;

public class Controller {

	ServiceLocator serviceLocator;
	private Model model;
	private View view;
	private int index;

	protected Controller(Model model, View view) {
		this.model = model;
		this.view = view;

		/**
		 * First implementation with a for loop to avoid DRY. Because of later
		 * problems uncommented
		 * 
		 */

		// register ourselves to listen for button clicks

		index = 0;
		view.btn[0].setOnAction(new EventHandler<ActionEvent>() {

			private ServerModel serverModel = new ServerModel();

			@Override
			public void handle(ActionEvent event) {
				view.drawSymbol(index);
				model.sendMessage(index, view.btn[0].getText());
				// System.out.println(Integer.toString(model.getCounter()));
				// if (model.getCounter() == 1 || model.getCounter() == 3 ||
				// model.getCounter() == 5
				// || model.getCounter() == 7) {
				// String y = new String();
				// model.sendMessage(y);
				// }
				// if (model.getCounter() == 2 || model.getCounter() == 4 ||
				// model.getCounter() == 6
				// || model.getCounter() == 8) {
				// String x = new String();
				// model.sendMessage(x);
				// }
				// for (int i = 0; i < 9; i++) {
				// view.btn[i].setDisable(true);
				// }
			}
		});

		int index2 = 1;

		view.btn[1].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				view.drawSymbol(index2);
				// model.sendMessage(index2, view.btn[1].getText());
				// System.out.println(Integer.toString(model.getCounter()));
				// if (model.getCounter() == 1 || model.getCounter() == 3 ||
				// model.getCounter() == 5
				// || model.getCounter() == 7) {
				// String x = new String();
				// model.sendMessage(x);
				// }
				// if (model.getCounter() == 0 || model.getCounter() == 2 ||
				// model.getCounter() == 4
				// || model.getCounter() == 6) {
				// String y = new String();
				// model.sendMessage(y);
				// }
			}
		});

		int index3 = 2;
		view.btn[2].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				view.drawSymbol(index3);
				model.sendMessage(index3, view.btn[2].getText());

			}
		});

		int index4 = 3;
		view.btn[3].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				view.drawSymbol(index4);
				model.sendMessage(index4, view.btn[3].getText());

			}
		});

		int index5 = 4;
		view.btn[4].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				view.drawSymbol(index5);
				model.sendMessage(index5, view.btn[4].getText());

			}
		});

		int index6 = 5;
		view.btn[5].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				view.drawSymbol(index6);
				model.sendMessage(index6, view.btn[5].getText());

			}
		});

		int index7 = 6;
		view.btn[6].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				view.drawSymbol(index7);
				model.sendMessage(index7, view.btn[6].getText());

			}
		});

		int index8 = 7;
		view.btn[7].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				view.drawSymbol(index8);
				model.sendMessage(index8, view.btn[7].getText());

			}
		});

		int index9 = 8;
		view.btn[8].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				view.drawSymbol(index9);
				model.sendMessage(index9, view.btn[8].getText());

			}
		});

		view.getStage().setOnCloseRequest(event -> model.disconnect());

		/**
		 * Following code uses a thread to update the gui view: Avoid throwing
		 * IllegalStateException by running from a non-JavaFX
		 * https://stackoverflow.com/questions/17850191/why-am-i-getting-java-lang-illegalstateexception-not-on-fx-application-thread
		 * 
		 * To do that, it takes the sent board messages with the help of change
		 * listener In addition, the thread is used to update the model (check
		 * win conditions; change turn booleans)
		 */
		model.actualIndex.addListener((o, oldValue, newValue) -> model.setButtonIndex((newValue)));
		model.newestMessage.addListener((o, oldValue, newValue) -> Platform.runLater(new Runnable() {
			@Override
			public void run() {
				view.btn[(int) model.getButtonIndex()].setText(newValue);
				view.btn[(int) model.getButtonIndex()].setDisable(true);
				model.update((int) model.getButtonIndex(), view.btn[(int) model.getButtonIndex()].getText());

			}
		}));

		// model.updateTurn.addListener((o, oldValue, newValue) ->
		// model.changeTurn((newValue)));
		System.out.println(model.getTurnX());

	}

	// String test = view.getButtonId();
	// serviceLocator = ServiceLocator.getServiceLocator();
	// serviceLocator.getLogger().info("test");

	// view.button.setOnAction(new EventHandler<ActionEvent>() {
	//
	// @Override
	// public void handle(ActionEvent event) {
	// client.addSymbol();
	// String newText = Integer.toString(client.getValue());
	//
	// }
	// });

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
