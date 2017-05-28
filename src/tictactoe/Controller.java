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
				model.update(index, view.btn[0].getText());
				model.sendMessage(index, view.btn[0].getText());

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
				model.update(index2, view.btn[1].getText());
				model.sendMessage(index2, view.btn[1].getText());
			}
		});

		int index3 = 2;
		view.btn[2].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				view.drawSymbol(index3);
				model.update(index3, view.btn[2].getText());
				// model.sendMessage(view.btn[2].getText());

			}
		});

		int index4 = 3;
		view.btn[3].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				view.drawSymbol(index4);
				model.update(index4, view.btn[3].getText());
				// model.sendMessage(view.btn[3].getText());

			}
		});

		int index5 = 4;
		view.btn[4].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				view.drawSymbol(index5);
				model.update(index5, view.btn[4].getText());
				// model.sendMessage(view.btn[4].getText());

			}
		});

		int index6 = 5;
		view.btn[5].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				view.drawSymbol(index6);
				model.update(index6, view.btn[5].getText());
				// model.sendMessage(view.btn[5].getText());

			}
		});

		int index7 = 6;
		view.btn[6].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				view.drawSymbol(index7);
				model.update(index7, view.btn[6].getText());
				// model.sendMessage(view.btn[6].getText());

			}
		});

		int index8 = 7;
		view.btn[7].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				view.drawSymbol(index8);
				model.update(index8, view.btn[7].getText());
				// model.sendMessage(view.btn[7].getText());

			}
		});

		int index9 = 8;
		view.btn[8].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				view.drawSymbol(index9);
				model.update(index9, view.btn[8].getText());

			}
		});

		view.getStage().setOnCloseRequest(event -> model.disconnect());

		// Avoid throwing IllegalStateException by running from a non-JavaFX
		// thread
		// https://stackoverflow.com/questions/17850191/why-am-i-getting-java-lang-illegalstateexception-not-on-fx-application-thread
		model.actualIndex.addListener((o, oldValue, newValue) -> model.setButtonIndex((newValue)));
		model.newestMessage.addListener((o, oldValue, newValue) -> Platform.runLater(new Runnable() {
			@Override
			public void run() {
				view.btn[(int) model.getButtonIndex()].setText(newValue);
			}
		}));
		// model.actualIndex.addListener((o, oldValue, newValue) ->
		// view.btn[(newValue)]);

		model.updateTurn.addListener((o, oldValue, newValue) -> model.setTurnX(newValue));
		// model.updateButton.addListener((o, oldValue, newValue) ->
		// view.btn[(newValue)]);
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
