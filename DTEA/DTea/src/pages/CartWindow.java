package pages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import main.Main;

public class CartWindow {
	
	private ObservableList<String> cartTea = FXCollections.observableArrayList();
	private User currUser;
	
	Stage stage;
	BorderPane bp;
	ScrollPane teaList;
	File file;
	Media media;
	MediaPlayer mp;
	
	// onAction
	Image img;
	ImageView imgView;
	Label namelbl, pricelbl;
	VBox vb1;
	HBox hb1;
	
	//	LEMON
	Image lemonimg;
	ImageView lemonView;
	Label lemonlbl, priceLemon, stockLemon, descLemon;
	VBox lemonDetails, lemonContainer;
	Button lemon;
	
	//	BLACK
	Image blackimg;
	ImageView blackView;
	Label blacklbl, priceBlack, stockBlack, descBlack;
	VBox blackDetails, blackContainer;
	Button black;
	
	//	APPLE
	Image appleimg;
	ImageView appleView;
	Label applelbl, priceApple, stockApple, descApple;
	VBox appleDetails, appleContainer;
	Button apple;
	
	//	HONEY
	Image honeyimg;
	ImageView honeyView;
	Label honeylbl, priceHoney, stockHoney, descHoney;
	VBox honeyDetails, honeyContainer;
	Button honey;
	
	//	MILK
	Image milkimg;
	ImageView milkView;
	Label milklbl, priceMilk, stockMilk, descMilk;
	VBox milkDetails, milkContainer;
	Button milk;
	
	// CART WINDOW
	Label title;
	HBox row1, row2, row3;
	HBox hb, cartWindow;
	GridPane gp;
	
	Label  purchase_title;
	VBox  teaBox, cartBox, vblo, vbt, vbpt, vbpu, container;
	VBox cart;
	Button logout, purchase;
	
	Scene sc;
	
	public void initialize() {
		
		title = new Label("Enjoy our tea");
		teaList = new ScrollPane();
		
		// onAction
		vb1 = new VBox();
		hb1 = new HBox();
		
		//----------------------------------- Lemon Tea ------------------------------------------
		lemonimg = new Image(getClass().getResourceAsStream("/pages/asset/lemon_tea.jpg"));
		lemonView = new ImageView();
		lemon = new Button();
		
		lemonlbl = new Label(Main.tea.get(0).getName());
		priceLemon = new Label("Price: Rp " + String.format("%.2f", Main.tea.get(0).getPrice()));
		stockLemon = new Label("Stock: " + Main.tea.get(0).getStock());
		descLemon = new Label(Main.tea.get(0).getDescription());
		
		lemonDetails = new VBox();
		lemonContainer = new VBox();
		
		//----------------------------------- Black Tea ------------------------------------------
		blackimg = new Image(getClass().getResourceAsStream("/pages/asset/black_tea.jpg"));
		blackView = new ImageView();
		black = new Button();
				
		blacklbl = new Label(Main.tea.get(1).getName());
		priceBlack = new Label("Price: Rp " + String.format("%.2f", Main.tea.get(1).getPrice()));
		stockBlack = new Label("Stock: " + Main.tea.get(1).getStock());
		descBlack = new Label(Main.tea.get(1).getDescription());
				
		blackDetails = new VBox();
		blackContainer = new VBox();
		
		//----------------------------------- Apple Tea ------------------------------------------
		appleimg = new Image(getClass().getResourceAsStream("/pages/asset/apple_tea.jpg"));
		appleView = new ImageView();
		apple = new Button();
				
		applelbl = new Label(Main.tea.get(2).getName());
		priceApple = new Label("Price: Rp " + String.format("%.2f", Main.tea.get(2).getPrice()));
		stockApple = new Label("Stock: " + Main.tea.get(2).getStock());
		descApple = new Label(Main.tea.get(2).getDescription());
				
		appleDetails = new VBox();
		appleContainer = new VBox();
		
		//----------------------------------- Honey Tea ------------------------------------------
		honeyimg = new Image(getClass().getResourceAsStream("/pages/asset/honey_tea.jpg"));
		honeyView = new ImageView();
		honey = new Button();
				
		honeylbl = new Label(Main.tea.get(3).getName());
		priceHoney = new Label("Price: Rp " + String.format("%.2f", Main.tea.get(3).getPrice()));
		stockHoney = new Label("Stock: " + Main.tea.get(3).getStock());
		descHoney = new Label(Main.tea.get(3).getDescription());
				
		honeyDetails = new VBox();
		honeyContainer = new VBox();
		
		//----------------------------------- Milk Tea ------------------------------------------
		milkimg = new Image(getClass().getResourceAsStream("/pages/asset/milk_tea.jpg"));
		milkView = new ImageView();
		milk = new Button();
				
		milklbl = new Label(Main.tea.get(4).getName());
		priceMilk = new Label("Price: Rp " + String.format("%.2f", Main.tea.get(4).getPrice()));
		stockMilk = new Label("Stock: " + Main.tea.get(4).getStock());
		descMilk = new Label(Main.tea.get(4).getDescription());
				
		milkDetails = new VBox();
		milkContainer = new VBox();
		
		// -----------------------------------------------------------
		
		// CART WINDOW
		row1 = new HBox();
		row2 = new HBox();
		row3 = new HBox();
		
		purchase_title = new Label("Your Cart");
		teaBox = new VBox();
		cartBox = new VBox();
		logout = new Button("Logout");
		purchase = new Button("Purchase");
		
		hb = new HBox();
		cartWindow = new HBox();
		vblo = new VBox();
		vbt = new VBox();
		vbpt = new VBox();
		vbpu = new VBox();
		
		cart = new VBox();
		
		gp = new GridPane();
		
		String audioFileName = "piano.mp3";
		file = new File(audioFileName);
		media = new Media(file.toURI().toString());
		mp = new MediaPlayer(media);
		
		bp = new BorderPane();
		sc = new Scene(bp, 850, 600);
	}
	
	public void layout() {
		
		mp.setAutoPlay(true);
		mp.setCycleCount(MediaPlayer.INDEFINITE);
		
		//----------------------------------- Lemon Tea ------------------------------------------
		lemonView.setImage(lemonimg);
		lemonView.setFitHeight(200);
		lemonView.setPreserveRatio(true);
		lemonView.setSmooth(true);
		lemon.setGraphic(lemonView);
		
		descLemon.setWrapText(true);
		
		lemonContainer.setPrefWidth(240);
		lemonlbl.setFont(Font.font(24));
		
		lemonDetails.getChildren().addAll(priceLemon, stockLemon);
		lemonContainer.getChildren().addAll(lemon, lemonlbl, lemonDetails, descLemon);
		
		lemonContainer.setSpacing(10);
		lemonContainer.setPadding(new Insets(10, 10, 10, 10));
		lemonContainer.setStyle("-fx-border-width: 1; -fx-border-color: #C5C2BF; -fx-border-radius: 5;");
		
		//----------------------------------- Black Tea ------------------------------------------
		blackView.setImage(blackimg);
		blackView.setFitHeight(200);
		blackView.setPreserveRatio(true);
		blackView.setSmooth(true);
		black.setGraphic(blackView);
		
		descBlack.setWrapText(true);
		
		blackContainer.setPrefWidth(240);
		blacklbl.setFont(Font.font(24));
				
		blackDetails.getChildren().addAll(priceBlack, stockBlack);
		blackContainer.getChildren().addAll(black, blacklbl, blackDetails, descBlack);
		
		blackContainer.setSpacing(10);
		blackContainer.setPadding(new Insets(10, 10, 10, 10));
		blackContainer.setStyle("-fx-border-width: 1; -fx-border-color: #C5C2BF; -fx-border-radius: 5;");
				
		//----------------------------------- Apple Tea ------------------------------------------
		appleView.setImage(appleimg);
		appleView.setFitHeight(200);
		appleView.setPreserveRatio(true);
		appleView.setSmooth(true);
		apple.setGraphic(appleView);
				
		descApple.setWrapText(true);
		
		appleContainer.setPrefWidth(240);
		applelbl.setFont(Font.font(24));
		
		appleDetails.getChildren().addAll(priceApple, stockApple);
		appleContainer.getChildren().addAll(apple, applelbl, appleDetails, descApple);
		
		appleContainer.setSpacing(10);
		appleContainer.setPadding(new Insets(10, 10, 10, 10));
		appleContainer.setStyle("-fx-border-width: 1; -fx-border-color: #C5C2BF; -fx-border-radius: 5;");
		
		//----------------------------------- Honey Tea ------------------------------------------
		honeyView.setImage(honeyimg);
		honeyView.setFitHeight(200);
		honeyView.setPreserveRatio(true);
		honeyView.setSmooth(true);
		honey.setGraphic(honeyView);
			
		descHoney.setWrapText(true);
		
		honeyContainer.setPrefWidth(240);
		honeylbl.setFont(Font.font(24));
		
		honeyDetails.getChildren().addAll(priceHoney, stockHoney);
		honeyContainer.getChildren().addAll(honey, honeylbl, honeyDetails, descHoney);
		
		honeyContainer.setSpacing(10);
		honeyContainer.setPadding(new Insets(10, 10, 10, 10));
		honeyContainer.setStyle("-fx-border-width: 1; -fx-border-color: #C5C2BF; -fx-border-radius: 5;");
		
		//----------------------------------- Milk Tea ------------------------------------------
		milkView.setImage(milkimg);
		milkView.setFitHeight(200);
		milkView.setPreserveRatio(true);
		milkView.setSmooth(true);
		milk.setGraphic(milkView);
		
		descMilk.setWrapText(true);
		
		milkContainer.setPrefWidth(240);
		milklbl.setFont(Font.font(24));
		
		milkDetails.getChildren().addAll(priceMilk, stockMilk);
		milkContainer.getChildren().addAll(milk, milklbl, milkDetails, descMilk);
		
		milkContainer.setSpacing(10);
		milkContainer.setPadding(new Insets(10, 10, 10, 10));
		milkContainer.setStyle("-fx-border-width: 1; -fx-border-color: #C5C2BF; -fx-border-radius: 5;");
		
		row1.getChildren().addAll(lemonContainer, blackContainer);
		row1.setPadding(new Insets(10, 10, 10, 10));
		row1.setSpacing(10);
		
		row2.getChildren().addAll(appleContainer, honeyContainer);
		row2.setPadding(new Insets(10, 10, 10, 10));
		row2.setSpacing(10);
		
		row3.getChildren().add(milkContainer);
		row3.setPadding(new Insets(10, 10, 10, 10));
		row3.setSpacing(10);
		
		teaBox.getChildren().addAll(row1,row2,row3);
		teaBox.setAlignment(Pos.CENTER);
		teaList.setContent(teaBox);
		teaList.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		teaList.setPrefWidth(580);
		teaList.setPrefViewportHeight(500);
		teaList.setPadding(new Insets(10, 10, 10, 10));
		
		purchase_title.setFont(Font.font("Poppins", FontWeight.NORMAL, 24));
		vbpt.getChildren().add(purchase_title);
		vbpt.setAlignment(Pos.TOP_CENTER);
		vbpt.setPadding(new Insets(10));
		
		cart.setPrefHeight(500);
		
		vbpu.getChildren().add(purchase);
		purchase.setPadding(new Insets(5));
		purchase.setPrefSize(290, 36);
		purchase.setStyle("-fx-background-color:#14B6B9;" + "-fx-text-fill: #F0F8FF; " + "-fx-font-size: 16px;");
		vbpu.setPadding(new Insets(20));
		vbpu.setAlignment(Pos.BOTTOM_CENTER);
		
		cartBox.getChildren().addAll(vbpt, cart, vbpu);
		cartBox.setPrefWidth(320);
		cartBox.setAlignment(Pos.CENTER);
		cartBox.setSpacing(10);
		cartBox.setPadding(new Insets(10));
		cartBox.setStyle("-fx-border-width: 1; -fx-border-color: #C5C2BF;  -fx-border-radius: 5;");
		
		hb.getChildren().addAll(teaList, cartBox);
		hb.setSpacing(10);
		cartWindow.getChildren().addAll(hb);
		cartWindow.setPadding(new Insets(10));
		
		title.setFont(Font.font("Poppins", FontWeight.MEDIUM, 32));
		vbt.getChildren().add(title);
		vbt.setAlignment(Pos.CENTER);
		vbt.setPadding(new Insets(10));
		bp.setTop(vbt);
		
		bp.setCenter(cartWindow);
		
		vblo.getChildren().add(logout);
		logout.setPadding(new Insets(5));
		logout.setStyle("-fx-background-color:#14B6B9;" + "-fx-text-fill: #F0F8FF;");
		vblo.setPadding(new Insets(20));
		vblo.setAlignment(Pos.BOTTOM_RIGHT);
		
		bp.setBottom(vblo);
	}
	
	void updateStock(int idx) {
		switch(idx) {
		case 0:
			stockLemon.setText("Stock: " + Main.tea.get(idx).getStock());
			break;
		case 1:
			stockBlack.setText("Stock: " + Main.tea.get(idx).getStock());
			break;
		case 2:
			stockApple.setText("Stock: " + Main.tea.get(idx).getStock());
			break;
		case 3:
			stockHoney.setText("Stock: " + Main.tea.get(idx).getStock());
			break;
		case 4:
			stockMilk.setText("Stock: " + Main.tea.get(idx).getStock());
			break;
		}
	}
	
	private boolean isTeaInCart(String teaName) {
		for (Node node : cart.getChildren()) {
            if (node instanceof HBox) {
                HBox hbox = (HBox) node;
                for (Node child : hbox.getChildren()) {
                    if (child instanceof VBox) {
                        VBox vbox = (VBox) child;
                        for (Node vboxChild : vbox.getChildren()) {
                            if (vboxChild instanceof Label) {
                                Label label = (Label) vboxChild;
                                if (label.getText().equals(teaName)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
	}
	
	public void onAction() {
		
		Alert error = new Alert(Alert.AlertType.ERROR);
		Alert success = new Alert(Alert.AlertType.INFORMATION);
		
		lemon.setOnDragDetected(e->{
			
			if(Main.tea.get(0).getStock()>0 && !cartTea.contains(Main.tea.get(0).getName())) {
				Dragboard dragboard = lemon.startDragAndDrop(TransferMode.MOVE);
				ClipboardContent content = new ClipboardContent();
				content.putImage(lemonView.getImage());
				content.put(Main.TEA_NAME, Main.tea.get(0).getName());
				content.put(Main.TEA_PRICE, "Price: Rp " + String.format("%.2f", Main.tea.get(0).getPrice()));
				
				dragboard.setContent(content);
			}else if(Main.tea.get(0).getStock() <= 0) {
				error.setContentText("Sold Out!");
				error.show();
			}else {
				error.setContentText("Lemon Tea is already in your cart!");
				error.show();
			}
			
			e.consume();
			
		});
		
		black.setOnDragDetected(e->{
			
			if(Main.tea.get(1).getStock()>0 && !cartTea.contains(Main.tea.get(1).getName())) {
				Dragboard dragboard = black.startDragAndDrop(TransferMode.MOVE);
				ClipboardContent content = new ClipboardContent();
				content.putImage(blackView.getImage());
				content.put(Main.TEA_NAME, Main.tea.get(1).getName());
				content.put(Main.TEA_PRICE, "Price: Rp " + String.format("%.2f", Main.tea.get(1).getPrice()));
				
				dragboard.setContent(content);
			}else if(Main.tea.get(1).getStock() <= 0) {
				error.setContentText("Sold Out!");
				error.show();
			}else {
				error.setContentText("Black Tea is already in your cart!");
				error.show();
			}
			
			e.consume();
			
		});
		
		apple.setOnDragDetected(e->{
			
			if(Main.tea.get(2).getStock()>0 && !cartTea.contains(Main.tea.get(2).getName())) {
				Dragboard dragboard = apple.startDragAndDrop(TransferMode.MOVE);
				ClipboardContent content = new ClipboardContent();
				content.putImage(appleView.getImage());
				content.put(Main.TEA_NAME, Main.tea.get(2).getName());
				content.put(Main.TEA_PRICE, "Price: Rp " + String.format("%.2f", Main.tea.get(2).getPrice()));
				
				dragboard.setContent(content);
			}else if(Main.tea.get(2).getStock() <= 0) {
				error.setContentText("Sold Out!");
				error.show();
			}else {
				error.setContentText("Apple Tea is already in your cart!");
				error.show();
			}
			
			e.consume();
			
		});
		
		honey.setOnDragDetected(e->{
			
			if(Main.tea.get(3).getStock()>0 && !cartTea.contains(Main.tea.get(3).getName())) {
				Dragboard dragboard = honey.startDragAndDrop(TransferMode.MOVE);
				ClipboardContent content = new ClipboardContent();
				content.putImage(honeyView.getImage());
				content.put(Main.TEA_NAME, Main.tea.get(3).getName());
				content.put(Main.TEA_PRICE, "Price: Rp " + String.format("%.2f", Main.tea.get(3).getPrice()));
				
				dragboard.setContent(content);
			}else if(Main.tea.get(3).getStock() <= 0) {
				error.setContentText("Sold Out!");
				error.show();
			}else {
				error.setContentText("Honey Tea is already in your cart!");
				error.show();
			}
			
			e.consume();
			
		});
		
		milk.setOnDragDetected(e->{
			
			if(Main.tea.get(4).getStock()>0 && !cartTea.contains(Main.tea.get(4).getName())) {
				Dragboard dragboard = milk.startDragAndDrop(TransferMode.MOVE);
				ClipboardContent content = new ClipboardContent();
				content.putImage(milkView.getImage());
				content.put(Main.TEA_NAME, Main.tea.get(4).getName());
				content.put(Main.TEA_PRICE, "Price: Rp " + String.format("%.2f", Main.tea.get(4).getPrice()));
				
				dragboard.setContent(content);
			}else if(Main.tea.get(4).getStock() <= 0) {
				error.setContentText("Sold Out!");
				error.show();
			}else {
				error.setContentText("Milk Tea is already in your cart!");
				error.show();
			}
			
			e.consume();
			
		});
		
		cartBox.setOnDragOver(e->{
			if(e.getGestureSource() != cartBox && e.getDragboard().hasImage()) {
				e.acceptTransferModes(TransferMode.MOVE);
			}
			e.consume();
		});
		
		cartBox.setOnDragDropped(e->{
			Dragboard db = e.getDragboard();
		    boolean ok = false;
		    if (db.hasImage() && db.hasContent(Main.TEA_NAME) && db.hasContent(Main.TEA_PRICE)) {
		        String name = (String) db.getContent(Main.TEA_NAME);
		        String price = (String) db.getContent(Main.TEA_PRICE);
		        
		        if(!cartTea.contains(name)) {
		        	int idx = -1;
		        	for (int i = 0; i < Main.tea.size(); i++) {
		        		if (Main.tea.get(i).getName().equals(name)) {
		        			idx = i;
		        			break;
		        		}
		        	}

			        if (idx != -1) {
			            
			            Image img = db.getImage();
			            ImageView imgView = new ImageView(img);
			            imgView.setFitWidth(45);
			            imgView.setPreserveRatio(true);
	
			            Label namelbl = new Label(name);
			            Label pricelbl = new Label(price);
			            namelbl.setFont(Font.font(14));
			            pricelbl.setFont(Font.font(14));
			            
			            VBox vb1 = new VBox();
			            HBox hb1 = new HBox();
	
			            vb1.getChildren().addAll(namelbl, pricelbl);
			            hb1.getChildren().addAll(imgView, vb1);
			            hb1.setSpacing(5);
	
//			            if (!isTeaInCart(name)) { 
			                cart.getChildren().add(hb1); 
			                cart.setSpacing(10);
	//		                System.out.println("Added HBox for " + name );
			                cartTea.add(name); 
			                currUser.addTeaToCart(name);
			                Main.tea.get(idx).setStock(Main.tea.get(idx).getStock() - 1);
			                ok = true;
			                updateStock(idx); 
//			            } 
	//		            else {
	//		                System.out.println(name + " is already in the cartBox.");
	//		            }
			        }
		        }
		    }
		    e.setDropCompleted(ok);
		    e.consume();
		});
		
		purchase.setOnAction(e->{
			success.setContentText("Thankyou for Shopping !!");
			success.show();
			
//			for(String teaName : currUser.getCart()) {
//				for(Tea tea : Main.tea) {
//					if(tea.getName().equals(teaName)) {
//						tea.setStock(tea.getStock()-1);
//						break;
//					}
//				}
//			}
			currUser.clearCart();
			cart.getChildren().clear();
			cartTea.clear();
		});
		
		logout.setOnMouseClicked(e->{
			mp.stop();
			new LoginPage(stage);
		});
	}
	
	private void addItemToCart(String teaName) {
		int idx = -1;
		for(int i = 0; i<Main.tea.size(); i++) {
			if(Main.tea.get(i).getName().equals(teaName)) {
				idx = i;
				break;
			}
		}
		
		if(idx != -1) {
			 Image img = new Image(getClass().getResourceAsStream("/pages/asset/" + teaName.toLowerCase().replace(" ", "_") + ".jpg"));
	         ImageView imgView = new ImageView(img);
	         imgView.setFitWidth(45);
	         imgView.setPreserveRatio(true);

	         Label namelbl = new Label(teaName);
	         Label pricelbl = new Label("Price: Rp " + String.format("%.2f", Main.tea.get(idx).getPrice()));
	         namelbl.setFont(Font.font(14));
	         pricelbl.setFont(Font.font(14));

	         VBox vb1 = new VBox();
	         HBox hb1 = new HBox();

	         vb1.getChildren().addAll(namelbl, pricelbl);
	         hb1.getChildren().addAll(imgView, vb1);
	         hb1.setSpacing(5);

	         cart.getChildren().add(hb1);
	         cart.setSpacing(10);
		}
	}
	
	private void displayCart() {
		cart.getChildren().clear();
		if(currUser.getCart() != null) {
			for(String tea : currUser.getCart()) {
				addItemToCart(tea);
			}
		}
	}
	
	public void imageClicked() {
		lemon.setOnMouseClicked(e->{
			new LemonPopUp(stage);
		});
		black.setOnMouseClicked(e->{
			new BlackPopUp(stage);
		});
		apple.setOnMouseClicked(e->{
			new ApplePopUp(stage);
		});
		honey.setOnMouseClicked(e->{
			new HoneyPopUp(stage);
		});
		milk.setOnMouseClicked(e->{
			new MilkPopUp(stage);
		});
	}

	public CartWindow(Stage stage, User user) {
		// TODO Auto-generated constructor stub
		
		if(user == null) {
			throw new IllegalArgumentException("User cannot be null");
		}
		
		this.stage = stage;
		this.currUser = user;
		List<String> userCart = user.getCart();
		
		if(userCart == null) {
			userCart = new ArrayList<>();
		}
		this.cartTea = FXCollections.observableArrayList(user.getCart());
		
		initialize();
		layout();
		onAction();
		imageClicked();
		displayCart();
		
		Image icon = new Image("logo.png");
		stage.getIcons().add(icon);
		stage.setTitle("Dtea Application");
		stage.setScene(sc);
		stage.show();
	}

}
