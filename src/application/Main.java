package application;
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Main extends Application {
	Account acc = new Account();
	Stage window1;
	GridPane grid = new GridPane();
	Scene scene = new Scene(grid,400,200);

	
	@Override
	public void start(Stage primaryStage) {
	
		window1=primaryStage;
	window1.setTitle("Atm Login");
		Label accnumlabel = new Label("Account Number: ");
            grid.add(accnumlabel, 0, 0);
    TextField anfield = new TextField();
            grid.add(anfield,1,0);
    Button login = new Button();
			login.setText("Login");
			grid.add(login,1,2);
		    login.setOnAction(new EventHandler<ActionEvent>() {
                
				@Override
				public void handle(ActionEvent event) {
				
					
					String Accnum = anfield.getText();
				  if (Accnum.equals(acc.getAccountNumber())) {
                   AtmHome.menu(acc);
				    }
				  else {
					  AtmHome.error("Account number not valid\n");
			       	   }
			}
		    	
		    });
		    Button close = new Button("Exit");
			close.setOnAction(e -> window1.close());
			grid.add(close,1,3);
		    grid.setAlignment(Pos.CENTER);
		window1.setScene(scene);
			window1.show();
	
	
	
	} 

	public static void main(String[] args) {
		launch(args);
		
	}
	


	
}
