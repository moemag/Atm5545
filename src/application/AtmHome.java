package application;
import java.util.LinkedList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AtmHome {
	
		static int i=-1;
	static LinkedList<String> history = new LinkedList<String>();
	static int j;

	public static void menu(Account acc) {
	
	VBox grid = new VBox(10);
	 Scene mainScene = new Scene(grid,600,400);
    
	Stage window2= new Stage ();

	window2.initModality(Modality.APPLICATION_MODAL);
	window2.setTitle("ATM");
	Label head = new Label("Welcome");
        head.setFont(new Font( null ,40 ));
		Button bEnq = new Button();
		bEnq.setText("Balance Enquiry");
		grid.getChildren().addAll(head,bEnq);
		Button back = new Button("Back");
   		back.setOnAction(e -> {
   			i=-1;
   		window2.setScene(mainScene);
   		});

		bEnq.setOnAction(new EventHandler<ActionEvent>() {
   	@Override
			public void handle(ActionEvent enquire) {
   		VBox enq = new VBox(8);
   		Label Balance = new Label("Current Balance: " + Double.toString(acc.getBalance())+" EGP" );
       Balance.setFont(new Font( null ,30 ));
     		 enq.getChildren().addAll(Balance, back);
   		 enq.setAlignment(Pos.CENTER);
   		 Scene enqScene = new Scene(enq,600,400);    
   		window2.setScene(enqScene);
   	
   	
   	}		
		});
		
		Button withdrawB = new Button();
		withdrawB.setText("Withdraw");
		grid.getChildren().add(withdrawB);
		withdrawB.setOnAction(new EventHandler<ActionEvent>() {


			@Override
			public void handle(ActionEvent withdrw) {
			VBox wd = new VBox(8);
				Label command = new Label("Enter Amount");				
				TextField mon = new TextField();
	            Button act = new Button();
	            act.setOnAction(e -> {
	            	
	          double amount = Double.valueOf(mon.getText());
	              if ( amount<=acc.getBalance()) {
	                acc.withdraw(amount);
                    history.addFirst(amount+" withdrawn");
                    j++;
	             if(history.size()>5) {
	            	 history.removeLast();
	             j--;
	             }
	          
	                window2.setScene(mainScene);
                   
	              } 
	              else { error("Insufficient funds, Please try again.");
	              }
	          
	            });
				act.setText("Withdraw");
				wd.getChildren().addAll(command,mon,act,back);

				wd.setAlignment(Pos.CENTER);
				Scene wdScene = new Scene(wd,400,300);
	   		window2.setScene(wdScene);
	   		
			}
			
		});
		
		Button dpst = new Button();
		dpst.setText("Deposit");
		grid.getChildren().add(dpst);
		dpst.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent deposit) {
			VBox wd = new VBox(8);
				Label command = new Label("Enter Amount");				
				TextField mon = new TextField();
	            Button act = new Button();
	            act.setOnAction(e -> {
	            	double amount = Double.parseDouble(mon.getText());
	                
	                     	acc.deposit(amount);
	            	
	                history.addFirst(amount+" Deposited");
	                j++;
	                if(history.size()>5) {
		            	 history.removeLast();   
	                j--;
	                }
	                window2.setScene(mainScene);
	                
	                
	            });
	        	act.setText("Deposit");
				wd.getChildren().addAll(command,mon,act,back);
    wd.setAlignment(Pos.CENTER);
		   		 Scene wdScene = new Scene(wd,400,300);
		   		window2.setScene(wdScene);
		   		
				}
				
			});
		Button trans = new Button("Transactions");		
		trans.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent Transact) {

				VBox tr = new VBox(10);		
				Scene trScene = new Scene(tr,400,300);	    
				Button prev = new Button("previous");
				Button next = new Button("Next");
				tr.getChildren().addAll(prev,next,back);
				Label label = new Label();
				prev.setOnAction(e -> {
					if(i<5) {
						if(i!=j-1) {
							i++;
						}
						
					label.setText(history.get(i));
						tr.getChildren().add(label);
					
		window2.setScene(trScene);
		//transact(1,tr); 
		}
	});
	next.setOnAction(e -> { 
		if(i>0) { 
			if(i!=0) {
				i--;
			}
			label.setText(history.get(i));
		tr.getChildren().add(label);
		window2.setScene(trScene);
		//transact(2,tr);
		}
		});
		        
				
		
				
			tr.setAlignment(Pos.CENTER);
				
			   		window2.setScene(trScene);
				

			}	
						
	});
		
		
		grid.getChildren().add(trans);
		
		Button close = new Button("Exit");
		close.setOnAction(e -> window2.close());
		grid.getChildren().add(close);

		grid.setAlignment(Pos.CENTER);
		window2.setScene(mainScene);
		window2.showAndWait();

	}
  public static void error (String err) {
		
	VBox grid = new VBox(10);
	 Scene mainScene = new Scene(grid,300,200);
    
	Stage window3= new Stage ();
	window3.initModality(Modality.APPLICATION_MODAL);
	window3.setTitle("ERROR");
	Label head = new Label(err);
        Button close = new Button("Ok");
		close.setOnAction(e -> window3.close());
		grid.getChildren().addAll(head,close);
        grid.setAlignment(Pos.CENTER);
		window3.setScene(mainScene);
		window3.showAndWait();
        
}
}