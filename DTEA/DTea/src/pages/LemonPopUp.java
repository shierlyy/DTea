package pages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class LemonPopUp {
    private Scene sc;
    private BorderPane bp;
    private Button ZI, ZO, RL, RR;
    private ImageView img;
    private Image LT_IMG;
    private HBox hb;
    private VBox vb;
    private Stage lemonStage;


	private void init() {
        bp = new BorderPane();
        sc = new Scene(bp, 600, 600);
        vb = new VBox();
        ZI = new Button("Zoom In");
        ZO = new Button("Zoom Out");
        RL = new Button("Rotate Left");
        RR = new Button("Rotate Right");
        hb = new HBox();
        img = new ImageView();
        LT_IMG = new Image(getClass().getResourceAsStream("/pages/asset/lemon_tea.jpg"));
    }

    private void layout() {
        img.setImage(LT_IMG);
        img.setFitHeight(300);
        img.setFitWidth(300);
        img.setPreserveRatio(true);
        img.setSmooth(true);

        hb.getChildren().addAll(ZI, ZO, RL, RR);
        hb.setPadding(new Insets(10));
        hb.setSpacing(10);
        hb.setAlignment(Pos.BOTTOM_CENTER);
        
        vb.getChildren().addAll(img, hb);
        vb.setAlignment(Pos.CENTER);

        bp.setCenter(vb);
    }

    private void buttonHandling() {
    	ZI.setOnMouseClicked(e -> {
        	double pivotX = img.getBoundsInLocal().getWidth() / 2;
            double pivotY = img.getBoundsInLocal().getHeight() / 2;
        	Scale scale = new Scale(1.2, 1.2, pivotX, pivotY);
        	img.getTransforms().add(scale);
        });

        ZO.setOnMouseClicked(e -> {
        	double pivotX = img.getBoundsInLocal().getWidth() / 2;
            double pivotY = img.getBoundsInLocal().getHeight() / 2;
        	Scale scale = new Scale(0.8, 0.8, pivotX, pivotY);
        	img.getTransforms().add(scale);
        });

        RL.setOnMouseClicked(e -> {
            img.setRotate(img.getRotate() - 90);
        });

        RR.setOnMouseClicked(e -> {
            img.setRotate(img.getRotate() + 90);
        });
    }
  
    public void showPopUp() {
        init();
        layout();
        buttonHandling();
    }
    
    public LemonPopUp(Stage adminStage) {
		// TODO Auto-generated constructor stub
    	showPopUp();
        lemonStage = new Stage();
        Image icon = new Image("logo.png");
    	lemonStage.getIcons().add(icon);
        lemonStage.setScene(sc);
        lemonStage.setTitle("Image Preview");
        lemonStage.show();
	}
}