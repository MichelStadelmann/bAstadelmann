package tictactoe;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tictactoe.ServiceLocator;

public class View {

	
	private Stage stage;
	private Client client;
	private Scene scene;
	private ServiceLocator serviceLocator;
	protected Tile tile;

	
	public View(Stage stage, Client client) {
		this.stage = stage;
		this.client = client;
	
		
		stage.setTitle("Tic Tac Toe");
		
		scene = create_GUI();
		stage.setScene(scene);
		
		
		
		
		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Application view initialized");
		
	}



	
	protected Scene create_GUI(){
		
		Pane root = new Pane();
		root.setPrefSize(600, 600);
		
		for (int i = 0; i < 3; i++){
			for (int j = 0; j <3; j++){
				Tile tile = new Tile();
				tile.setTranslateX(j*200);
				tile.setTranslateY(i *200);
				
				root.getChildren().add(tile);
				
			}
		}
		
		Scene scene = new Scene(root);
		return scene;
		
		
	}
	
//	public class Tile extends StackPane {
//		
//		private Text text = new Text();
//		private Tile tile;
//		
//		
//		public Tile(){	
//			
//			Rectangle border = new Rectangle(200,200);
//			border.setFill(null);
//			border.setStroke(Color.BLACK);
//			
//			text.setFont(Font.font(72));
//			
//			setAlignment(Pos.CENTER);
//			getChildren().addAll(border, text);
//			
//			setOnMouseClicked(event ->{
//				if(event.getButton() == MouseButton.PRIMARY){
//					drawX();
//				}
//				else if (event.getButton()== MouseButton.SECONDARY){
//					drawO();
//				}	
//			});
//			
//			
//			
//		}
//		
//		protected void drawX(){
//			text.setText("X");
//		}
//		
//		protected void drawO(){
//			text.setText("O");
//		}
//		
//	
//
//}
	
	
	
	public void start() {
		stage.show();
		
	}

	public void stop() {
		// TODO Auto-generated method stub
		
	}
	
	public Tile getTile(){
		return tile;
	}
	
	public void setTile (Tile tile){
		this.tile = tile;
	}


}
