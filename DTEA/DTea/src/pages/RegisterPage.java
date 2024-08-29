package pages;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import main.Main;

public class RegisterPage {
//	ArrayList<User> registedUser = new ArrayList<User>();
//	User currUser = null;
	
	Stage stage;
	Scene scene;
	BorderPane bp;
	
	GridPane gp;
	HBox hbox;
	VBox container;
	VBox registbox;
	StackPane r;
	FlowPane pane;
	AnchorPane anchor_pane;
	
	Label title, email, name, pass, confirmpass; 
	TextField emailTF, nameTF; 
	PasswordField passPF, confirmPF; 
	Button registerbtn;
	Hyperlink login;
	
	public void initialize() {
		title = new Label("Register");
		title.setFont(Font.font("Poppins", FontWeight.MEDIUM, 32));
//		title.setStyle("-fx-text-fill: #0A295B;");
		
		email = new Label("Email");
//		email.setStyle("-fx-text-fill: #0A295B;");
		emailTF = new TextField();
		emailTF.setPrefHeight(36);
		
		name = new Label("Name");
//		name.setStyle("-fx-text-fill: #0A295B;");
		nameTF = new TextField();
		nameTF.setPrefHeight(36);
		
		pass = new Label("Password");
//		pass.setStyle("-fx-text-fill: #0A295B;");
		passPF = new PasswordField();
		passPF.setPrefHeight(36);
		
		confirmpass = new Label("Confirm Password");
//		confirmpass.setStyle("-fx-text-fill: #0A295B;");
		confirmPF = new PasswordField();
		confirmPF.setPrefHeight(36);
		
		registerbtn = new Button("Register");	
//		registerbtn.setFont(Font.font("Poppins", FontWeight.NORMAL, 12));
		registerbtn.setAlignment(Pos.CENTER);
		registerbtn.setPrefSize(250, 36);
		registerbtn.setStyle("-fx-background-color:#14B6B9;" + "-fx-text-fill: #F0F8FF;"+"-fx-font-size: 16px;");
		
		login = new Hyperlink("Already a member? Login");
		login.setStyle("-fx-text-fill: #14B6B9;"); 
		
		gp = new GridPane();
		bp = new BorderPane();
		hbox = new HBox();
		scene = new Scene(bp, 450, 600);
		container = new VBox();
		registbox = new VBox();
		
		registbox.getChildren().addAll(email, emailTF,name,nameTF ,pass, passPF, confirmpass,confirmPF);
		container.getChildren().addAll(title, registbox, registerbtn, login);
		registbox.setSpacing(5);
		container.setMaxWidth(250);
		container.setSpacing(20);
		email.setMaxWidth(250);
		pass.setMaxWidth(250);
		name.setMaxWidth(250);
		confirmpass.setMaxWidth(250);
		container.setAlignment(Pos.CENTER);

	}
	
	public void layout () {
		bp.setPadding(new Insets(30, 20, 60, 30));
		bp.setCenter(container);
		
	}
	
	public void registerAction() {
		registerbtn.setOnMouseClicked(e->{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			String email = emailTF.getText();
			String name = nameTF.getText();
			String pass = passPF.getText();
			String confirmPass = confirmPF.getText();
			
			if (email.isEmpty()) {
				alert.setTitle("Error");
				alert.setContentText("Email must be filled");
				alert.show();
			}else if(!email.contains("@")) {
				alert.setTitle("Error");
				alert.setContentText("Email must contains '@' ");
				alert.show();
			}else if(!(email.chars().filter(ch -> ch == '@').count()==1)) {
				alert.setTitle("Error");
				alert.setContentText("Email must only have one '@' ");
				alert.show();
			}else if (!email.endsWith(".com")) {
				alert.setTitle("Error");
				alert.setContentText("Email must endswith '.com' ");
				alert.show();
			}else if (name.isEmpty()) {
				alert.setTitle("Error");
				alert.setContentText("Name must be filled");
				alert.show();
			}else if (pass.isEmpty()) {
				alert.setTitle("Error");
				alert.setContentText("Password must be filled");
				alert.show();
			}else if (confirmPass.isEmpty()) {
				alert.setTitle("Error"); 
				alert.setContentText("Confirm password must be filled");
				alert.show();
			}else if (!confirmPass.equals(pass)) {
				alert.setTitle("Error");
				alert.setContentText("Confirm Password do not match");
				alert.show();
			}else {
				Integer check = 0;
				for(User user : Main.registedUser) {
					if (email.equals(user.getEmail())) {
						check = 1;
						break;
					}
				}
				if (check == 1) {
					alert.setContentText("Email already registed");
					alert.show();
				}else {
					Main.registedUser.add(new User(email, pass, name));
					Alert  success = new Alert(Alert.AlertType.INFORMATION);
					success.setContentText("New User Registed");
					new LoginPage(stage);
				}
			}
		});
		
		login.setOnAction(e->{
			new LoginPage(stage);
		});
	}

	public RegisterPage(Stage stage) {
		
		this.stage = stage;
		
		initialize();
		layout();
		registerAction();
		
		stage.setScene(scene);
		stage.show();
		
		
	}


}
