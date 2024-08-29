package pages;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.DataFormat;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import main.Main;

public class WelcomeCustomer {
	
	private User currUser;
	
	Stage stage;
	Scene scene;
	BorderPane bp;
	Label title;
	Button butt;
	
	VBox vb;
	
	File file;
	Media media;
	MediaPlayer mp;
	MediaView mv;
	
	
	public void initialize() {
		
		title = new Label("Welcome to DTea " + currUser.getName() + "!");
		title.setFont(Font.font("Poppins", FontWeight.MEDIUM, 36));
		butt = new Button("Continue");
		butt.setPrefSize(400,  36);
		butt.setStyle("-fx-background-color:#14B6B9;" + "-fx-text-fill: #F0F8FF;" + "-fx-font-size: 16px;");
		
		file = new File("video.mp4");
		media = new Media(file.toURI().toString());
		mp = new MediaPlayer(media);
		mv = new MediaView(mp);
		mp.setAutoPlay(true);
		mp.setCycleCount(mp.INDEFINITE);
		
		bp = new BorderPane();
		
		vb = new VBox();
		vb.getChildren().addAll(title, mv, butt);
		vb.setAlignment(Pos.CENTER);
		vb.setSpacing(20);
		
		bp.setCenter(vb);
		
		mp.setOnReady(()->{
			mv.setFitHeight(media.getHeight());
			mv.setFitWidth(media.getHeight()-300);
		});
		
		scene = new Scene(bp, 850, 600);

	}
	
	public void onAction() {
		butt.setOnMouseClicked(e->{
			mp.stop();
			new CartWindow(stage, currUser);
		});
	}

	public WelcomeCustomer(Stage stage, User user) {
		if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
		
		this.stage = stage;
		this.currUser = user;
		
		initialize();
		onAction();
		
		Image icon = new Image("logo.png");
		stage.getIcons().add(icon);
		stage.setTitle("Dtea Application");
		stage.setScene(scene);
		stage.show();
		
		
	}

}
