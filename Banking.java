import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.text.DecimalFormat;
//added
import javax.swing.JOptionPane;

/**********************
 * Final project
 * A banking application
 * Nguyen Tran, Rashmi Naidu, Maxwell Dudley
 * 4/22/19
 * CMSC 255 002 
 ***********************************/

public class Banking extends Application {
	
    @Override
    public void start(Stage primaryStage) {
    	//constructing the buttons, textboxes, and stuff for the first page
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 700, 500);
        ArrayList <IDInfo> IDList = new ArrayList<IDInfo>();
        //call the method for the login screen
        loginScreen(root,IDList);
        //show the primary stage
        primaryStage.setTitle("NRM Banking");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**************************
     * This method draws the screen that allows you to deposit or withdraw money
     *************************/
    public void withdrawDepositScreen(StackPane root, IDInfo ID,ArrayList <IDInfo> IDList) {
		//added
		Label Info = new Label();
		Label TextBox = new Label("Amount $:");
		Label Balance_1 = new Label("Balance:");
    	//setting up the button labels and textfields
        Button withdraw = new Button();
        Button deposit = new Button();
        Button exit = new Button("Exit");
        Label money = new Label();
        Label bank = new Label("NRM Banking");
        DecimalFormat df = new DecimalFormat("#.00"); 
        
        TextField amount = new TextField();

        //setting where the nodes will be on the screen
        bank.setFont(new Font("Arial",24));
        bank.setTranslateY(-80);
        
        money.setFont(new Font("Arial", 18));
        money.setTranslateY(-35);
		Balance_1.setFont(new Font("Arial",18));
		Balance_1.setTranslateY(-35);
		Balance_1.setTranslateX(-100);
		money.setText(df.format(ID.getBalance()));
		
		Info.setTranslateX(-280);
		Info.setTranslateY(-210);
		Info.setMaxHeight(200);
		Info.setText(ID.getIDNum() + "\n"+ ID.getIDName() + "\n"+ ID.getIDBirthday() + "\n"+ ID.getIDType());
        
		TextBox.setTranslateY(-5);
		TextBox.setTranslateX(-130);
        amount.setMaxWidth(200);
        amount.setTranslateY(-5);
        
        withdraw.setTranslateY(50);
        withdraw.setTranslateX(-75);
        withdraw.setMaxWidth(100);
        withdraw.setMaxHeight(50);
        withdraw.setText("Withdraw");
        
        deposit.setTranslateY(50);
        deposit.setTranslateX(75);
        deposit.setMaxWidth(100);
        deposit.setMaxHeight(50);
        deposit.setText("Deposit");
        
        exit.setTranslateX(-200);
    	exit.setTranslateY(90);
    	exit.setMaxHeight(55);
    	exit.setMaxWidth(55);
		
		withdraw.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				//checking to make sure the user entered in the fields correctly
					 if ((Double.parseDouble(amount.getText()) < 0)) {
						 JOptionPane.showMessageDialog(null,"You cannot withdraw a negative number");
				        } 
					 else if(Double.parseDouble(amount.getText()) > ID.getBalance()) {
						 JOptionPane.showMessageDialog(null,"You cannot withdraw from your account");
					 }
				//calling the withdrawal method and then setting the label to display the new amount
				ID.withdrawal(Double.parseDouble(amount.getText()));
				money.setText(df.format(ID.getBalance()));

					 
			}
		});
	    //Set the deposit button action
		deposit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				//checking to make sure the user entered in the fields correctly
				if ((Double.parseDouble(amount.getText()) < 0)) {
					 JOptionPane.showMessageDialog(null,"You cannot deposit a negative number");
			        } 
				ID.deposit(Double.parseDouble(amount.getText()));
				money.setText(df.format(ID.getBalance()));

			}
		});
    	
		//Set the exit button action
    	exit.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
        		loginScreen(root,IDList);
           }
        });

        
        //clearing the root and adding the children to the scene
        root.getChildren().clear();
        root.getChildren().add(exit);
        root.getChildren().add(withdraw);
        root.getChildren().add(deposit);
        root.getChildren().add(amount);
        root.getChildren().add(bank);
        root.getChildren().add(money);
		root.getChildren().add(TextBox);
		root.getChildren().add(Info);
		root.getChildren().add(Balance_1);
    }
    
    /******************
    *This method is set up to create new accounts
    ***************/
    private void createAccountScreen(StackPane root, ArrayList<IDInfo> IDList) {
		//added
		Label ID2 = new Label("Enter your new ID");
		Label DOBL = new Label ("MM/DD/YYYY");
	  	Label bank = new Label("NRM Banking");
    	Label IDLabel = new Label("ID:");
    	Label birthdayLabel = new Label("DOB:");
		Label NameLabel = new Label("Name:");
		TextField DOB = new TextField();
		TextField DOB1 = new TextField();
		TextField DOB2 = new TextField();
		TextField ID = new TextField();
		TextField NameText = new TextField();

    	//set up label textfield and radiobuttons
    	Button createAccount = new Button("Create Account");
    	Button exit = new Button("exit");
    	
    	RadioButton savings = new RadioButton("Savings account");
    	RadioButton checking = new RadioButton("Checking account");
    	
    	//add radiobuttons to the same togglegroup so only one can be selected
    	ToggleGroup savingsChecking = new ToggleGroup();
    	savings.setToggleGroup(savingsChecking);
    	checking.setToggleGroup(savingsChecking);
    	
    	//set up where the nodes will be on the screen
    	bank.setFont(new Font("Arial", 24));
    	bank.setTranslateY(-220);
    	
    	
    	ID.setTranslateX(-190);
    	ID.setTranslateY(-150);
    	ID.setMaxWidth(125);
		ID2.setTranslateX(-200);
		ID2.setTranslateY(-170);
		IDLabel.setTranslateX(-265);
		IDLabel.setTranslateY(-150);
		
		birthdayLabel.setTranslateX(-270);
		birthdayLabel.setTranslateY(-110);
		DOBL.setTranslateX(-210);
		DOBL.setTranslateY(-90);
		DOB.setTranslateX(-240);
		DOB.setTranslateY(-110);
		DOB.setMaxWidth(30);
		DOB1.setTranslateX(-205);
		DOB1.setTranslateY(-110);
		DOB1.setMaxWidth(30);
		DOB2.setTranslateX(-155);
		DOB2.setTranslateY(-110);
		DOB2.setMaxWidth(60);
		
		NameLabel.setTranslateX(-275);
		NameLabel.setTranslateY(-60);
		NameText.setTranslateX(-190);
		NameText.setTranslateY(-60);
		NameText.setMaxWidth(125);
    	
    	savings.setTranslateX(-205);
    	savings.setTranslateY(-30);
    	checking.setTranslateX(-200);
    	checking.setTranslateY(0);
    	
    	createAccount.setTranslateX(50);
    	createAccount.setTranslateY(-100);
    	createAccount.setMaxHeight(100);
    	
    	exit.setTranslateX(-200);
    	exit.setTranslateY(60);
    	exit.setMaxHeight(55);
    	exit.setMaxWidth(55);
		
    	//Set the createAccount button action
    	createAccount.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				IDInfo newID = new IDInfo();
				int index = 0;
				//checks to make sure the user entered in the fields correctly
				if((ID.getText().length())!=7){
					JOptionPane.showMessageDialog(null,"Please enter 7 digit number");
				}
				else if(ID.getText().length() == 0 || DOB.getText().length() == 0|| DOB1.getText().length() == 0||DOB2.getText().length() == 0 || NameText.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"Make sure no field is empty ");
				}
				else if(Integer.parseInt(DOB.getText()) < 0 ||Integer.parseInt(DOB1.getText()) < 0||Integer.parseInt(DOB2.getText()) < 0) {
					JOptionPane.showMessageDialog(null,"Please enter a positive number for the date");
				}
				else if(Integer.parseInt(DOB.getText()) < 0 ) {
					JOptionPane.showMessageDialog(null,"Please enter a positive number for the ID");
				}
				else if(Integer.parseInt(DOB.getText()) < 1|| (Integer.parseInt(DOB.getText()) > 12)){
					JOptionPane.showMessageDialog(null,"Month has to be between 1 and 12");
				}
				else if(Integer.parseInt(DOB1.getText()) < 1||  Integer.parseInt(DOB1.getText()) > 31) {
					JOptionPane.showMessageDialog(null,"Day has to be between 1 and 31 ");
				}
				else if(Integer.parseInt(DOB2.getText()) < 1930||  Integer.parseInt(DOB2.getText()) > 2019) {
					JOptionPane.showMessageDialog(null,"The year has to be a reasonable number");
				}
				else {
					//creating the new ID object and storing it in the list
					IDList.add(newID);
					index = IDList.indexOf(newID);
					IDList.get(index).setIDNum(Integer.parseInt(ID.getText()));
					IDList.get(index).setBirth(Integer.parseInt(DOB.getText()),Integer.parseInt(DOB1.getText()),Integer.parseInt(DOB2.getText()));
					IDList.get(index).setName(NameText.getText());
					if(savings.isSelected()){
						IDList.get(index).setType("Savings");
					}
					else if(checking.isSelected()){
						IDList.get(index).setType("Checking");
					}
					//switching to the withdraw and deposit screen after the new account is created
					withdrawDepositScreen(root, IDList.get(index),IDList);
				}
				
			}
		});
		
    	//Set the exit button action 
    	exit.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
        		loginScreen(root,IDList);
           }
        });

    	//add nodes to the scene
    	root.getChildren().clear();
    	root.getChildren().add(exit);
    	root.getChildren().add(createAccount);
    	root.getChildren().add(ID);
    	root.getChildren().add(savings);
    	root.getChildren().add(checking);
    	root.getChildren().add(bank);
		root.getChildren().add(IDLabel);
		root.getChildren().add(ID2);
		root.getChildren().add(DOBL);
		root.getChildren().add(DOB1);
		root.getChildren().add(DOB2);
		root.getChildren().add(DOB);
		root.getChildren().add(birthdayLabel);
		root.getChildren().add(NameLabel);
		root.getChildren().add(NameText);
    }
    
    /***********************
     * This method constructs the login screen
     **************************/
    private void loginScreen(StackPane root, ArrayList <IDInfo> IDList) {
    	//set up labels textfield and button
    	Button login = new Button();
        Label bank = new Label("NRM Banking");
		//added
		Label bank2 = new Label("Enter your seven digit ID(ex: 7193241)");
		Label bank3 = new Label("ID");
        TextField ID = new TextField();
        ID.setMaxWidth(200);
        login.setTranslateY(75);
        bank.setTranslateY(-35);
		bank2.setTranslateY(25);
		bank3.setTranslateX(-110);
        login.setMaxWidth(100);
        login.setMaxHeight(50);
        login.setText("Login");
        
        //set the login button action to change the page
        login.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event ) {
			boolean flag = false;
			
			//added
			int position = 0;
			if((ID.getText().length())!=7){
				JOptionPane.showMessageDialog(null,"Please enter a 7 digit number");
			}
			else if(Integer.parseInt(ID.getText()) < 0){
				JOptionPane.showMessageDialog(null,"Please enter a positive number");
			}
			//looping through the arraylist to see if there is a match if there is a match then set flag to true
			for (int i = 0; i < IDList.size();i++){
				if(Integer.parseInt(ID.getText()) == IDList.get(i).getIDNum()){
					flag = true;
					position = i;
				}					
			}
			//selecting whether to create an account or go directly to the withdraw/deposit screen	
			if(flag) {
        		withdrawDepositScreen(root,IDList.get(position),IDList);
        	}
        	else {
        		createAccountScreen(root,IDList);
        	}
			}
        });
        
        //clear root before adding the children
        root.getChildren().clear();
        root.getChildren().add(login);
        root.getChildren().add(ID);
        root.getChildren().add(bank);
		root.getChildren().add(bank2);
		root.getChildren().add(bank3);
    }
	
    public static void main (String [] args){
		launch(args);
	}
	
}