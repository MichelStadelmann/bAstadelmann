package tictactoe;

import javafx.scene.input.MouseButton;

public class Controller {
	
	ServiceLocator serviceLocator;
	private Client client;
	private View view;

	public Controller(Client client, View view) {
		this.client = client;
		this.view = view;
		
		//register ourselves to listen for mouse clicks
		view.tile.setOnMouseClicked(event ->{
			if(event.getButton() == MouseButton.PRIMARY){
				view.tile.drawX();
			}
			else if (event.getButton()== MouseButton.SECONDARY){
				view.tile.drawO();
			}	
		});
			
	
		
	//  serviceLocator = ServiceLocator.getServiceLocator();
	//	serviceLocator = getLogger().info("Application controller initialized");	
		
	}
	
}
