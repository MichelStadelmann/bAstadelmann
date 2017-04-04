package tictactoe;

import javafx.scene.input.MouseButton;
import tictactoe.ServiceLocator;


public class Controller {
	
	ServiceLocator serviceLocator;
	private Client client;
	private View view;
	

	public Controller(Client client, View view) {
		this.client = client;
		this.view = view;
		
		
		//create a tile object as inner class that the controller can
		//do the drawing
		//the logger checks if there is an object
		
		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("tile ist:" +view.getTile());		
//		
//		
//		//register ourselves to listen for mouse clicks
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
