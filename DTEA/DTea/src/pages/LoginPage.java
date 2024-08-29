package pages;

import java.util.ArrayList;

//import javafx.geometry.HPos;
import javafx.geometry.Insets;
//import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
//import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
//import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
//import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import main.Main;

public class LoginPage {
//	ArrayList<User> registedUser = new ArrayList<>();
//	User currUser = null;
	
	private User currUser;
	
	Stage loginStage; 
	Scene scene; 
	BorderPane bp; 
	MenuBar mb;
	GridPane gp;
	HBox hbox;
	VBox container;
	VBox registbox;
	StackPane r;
	
	Label title, email, pass; 
	TextField emailTF; 
	PasswordField passPF; 
	Button loginbtn, registerbtn;
	Hyperlink regist;
	
	
	public void init() {
		title = new Label("Login");
		title.setFont(Font.font("Poppins", FontWeight.MEDIUM, 32));

		email = new Label("Email");
		emailTF = new TextField();
		emailTF.setPrefHeight(36);
		email.setStyle("-fx-font-size: 13px;");

		
		pass = new Label("Password");
		passPF = new PasswordField();
		passPF.setPrefHeight(36);
		pass.setStyle("-fx-font-size: 13px;");
		
		loginbtn = new Button("Login");	
		loginbtn.setAlignment(Pos.CENTER);
		loginbtn.setPrefSize(250, 36);
		loginbtn.setStyle("-fx-background-color:#14B6B9;" + "-fx-text-fill: #F0F8FF;" +"-fx-font-size: 16px;");
		
		regist = new Hyperlink("Not a member? Register");
		regist.setStyle("-fx-text-fill: #14B6B9;"); 

		gp = new GridPane();
		bp = new BorderPane();
		hbox = new HBox();
		scene = new Scene(bp, 450, 600);
		container = new VBox();
		registbox = new VBox();
		
		registbox.getChildren().addAll(email, emailTF, pass, passPF);
		registbox.setSpacing(5);
		container.getChildren().addAll(title, registbox, loginbtn, regist);
		container.setSpacing(20);
		container.setMaxWidth(250);
		email.setMaxWidth(250);
		pass.setMaxWidth(250);
		container.setAlignment(Pos.CENTER);
		loginbtn.setMaxHeight(100);;
	}
	
	public void styling() {
		title.setAlignment(Pos.TOP_CENTER);
	}
	
	public void layout () {
		bp.setPadding(new Insets(30, 20, 60, 30));
		bp.setCenter(container);
		
	}
	
	private void loginUser(String email, String pass) {
		for(User user : Main.registedUser) {
			if(user.getEmail().equals(email) && user.getPass().equals(pass)) {
				Main.currUser = user;
				new WelcomeCustomer(loginStage, user);
				return;
			}
		}
	}
	
	public void loginAction() {
		loginbtn.setOnMouseClicked(e->{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			String email = emailTF.getText();
			String pass = passPF.getText();
			
			if(email.isEmpty()) {
				alert.setTitle("Error");
				alert.setContentText("Email cannot be empty");
				alert.show();
			}else if (pass.isEmpty()) {
				alert.setTitle("Error");
				alert.setContentText("Password cannt be empty!");
				alert.show();
			}else if(email.contentEquals("admin") && pass.contentEquals("admin123")){
				new AdminPage(loginStage);
			}
			else {
				loginUser(email,pass);
				Integer check = 0; 
				for (User user : Main.registedUser) {
					if(email.equals(user.getEmail()) && pass.equals(user.getPass())){
						check = 1;
						Main.currUser = user;
						break;
					}
				}
				if (check == 1) {
					loginUser(email,pass);
				}else {
					alert.setContentText("Wrong Credentials");
					alert.show();
				}
			}
		});
	
		regist.setOnAction(e->{
			new RegisterPage(loginStage);
		});
		
	}
	
	public LoginPage(Stage loginStage) {
		this.loginStage = loginStage;
		
		init();
		layout();
		styling();
		loginAction();
		
		Image icon = new Image("logo.png"); 
		loginStage.setScene(scene);
		loginStage.getIcons().add(icon);
		loginStage.setTitle("Dtea Application");
		loginStage.show();
		
	}
}
