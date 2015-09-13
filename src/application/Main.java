package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
	        Button btn2 = new Button();
	        btn2.setText("Easy");
	        btn2.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	StackPane root = new StackPane();
	    	        root.setId("pane");
	    			Scene scene = new Scene(root,900,466);
	    			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	    			primaryStage.setScene(scene);
	    			primaryStage.show();
	            }
	        });
	        Button btn3 = new Button();
	        btn3.setText("Medium");
	        btn3.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	StackPane root = new StackPane();
	    	        root.setId("pane");
	    			Scene scene = new Scene(root,900,466);
	    			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	    			primaryStage.setScene(scene);
	    			primaryStage.show();
	            }
	        });
	        Button btn4 = new Button();
	        btn4.setText("Hard");
	        btn4.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	StackPane root = new StackPane();
	    	        root.setId("pane");
	    			Scene scene = new Scene(root,900,466);
	    			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	    			primaryStage.setScene(scene);
	    			primaryStage.show();
	            }
	        });
	        Button btn = new Button();
	        btn.setText("Start");
	        btn.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	StackPane root = new StackPane();
	    	        root.setId("pane");
	    	        BorderPane border = new BorderPane();
	    	        border.setPadding(new Insets(20, 0, 20, 20));
	    	        VBox vbButtons = new VBox();
	    	        vbButtons.setSpacing(100);
	    	        vbButtons.setPadding(new Insets(110, 20, 10, 20)); 
	    	        vbButtons.getChildren().addAll(btn2,btn3,btn4);
	    	        root.getChildren().add(vbButtons);
	    			Scene scene = new Scene(root,900,466);
	    			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	    			primaryStage.setScene(scene);
	    			primaryStage.show();
	            }
	        });
			StackPane root = new StackPane();
	        root.setId("pane");
			Scene scene = new Scene(root,900,466);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			root.getChildren().add(btn);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
