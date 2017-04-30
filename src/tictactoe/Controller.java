package tictactoe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controller {

	ServiceLocator serviceLocator;
	private Model model;
	private View view;

	protected Controller(Model model, View view) {
		this.model = model;
		this.view = view;

		/**
		 * First implementation with a for loop to avoid DRY. Because of later
		 * problems uncommented
		 * 
		 */

		// register ourselves to listen for button clicks
		// for (int i = 0; i < 9; i++) {
		// view.btn[i].setOnAction(new EventHandler<ActionEvent>() {
		// @Override
		// public void handle(ActionEvent event) {
		// System.out.println("Hello World");
		//
		// }
		// });
		// }

		// register ourselves to listen for button clicks

		int index = 0;
		view.btn[0].setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World");
				view.drawSymbol(index);
				model.update(index, view.btn[0].getText());

			}
		});

		int index2 = 1;

		view.btn[1].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World");
				// model.update();
				view.drawSymbol(index2);
				model.update(index2, view.btn[1].getText());
			}
		});

		int index3 = 2;
		view.btn[2].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World");
				// model.update();
				view.drawSymbol(index3);
				model.update(index3, view.btn[2].getText());

			}
		});

		int index4 = 3;
		view.btn[3].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World");
				// model.update();
				view.drawSymbol(index4);
				model.update(index4, view.btn[3].getText());

			}
		});

		int index5 = 4;
		view.btn[4].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World");
				// model.update();
				view.drawSymbol(index5);
				model.update(index5, view.btn[4].getText());

			}
		});

		int index6 = 5;
		view.btn[5].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World");
				// model.update();
				view.drawSymbol(index6);
				model.update(index6, view.btn[5].getText());

			}
		});

		int index7 = 6;
		view.btn[6].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World");
				// model.update();
				view.drawSymbol(index7);
				model.update(index7, view.btn[6].getText());

			}
		});

		int index8 = 7;
		view.btn[7].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World");
				// model.update();
				view.drawSymbol(index8);
				model.update(index8, view.btn[7].getText());

			}
		});

		int index9 = 8;
		view.btn[8].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World");
				// model.update();
				view.drawSymbol(index9);
				model.update(index9, view.btn[8].getText());
			}
		});

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

}
