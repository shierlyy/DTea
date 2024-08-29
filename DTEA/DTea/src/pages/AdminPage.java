package pages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import main.Main;

public class AdminPage{
	
	Stage adminStage;
	BorderPane bp; 
	GridPane gp;
	Image apple, black, honey, lemon, milk;
	ImageView appleView, blackView, honeyView, lemonView, milkView;
	
	Label title;
	
	// LEMON
	Label lemonlbl, namelemon, pricelemon, stocklemon, desclemon;
	TextField itemLemon, priceLemon;
	TextArea descLemon;
	Spinner<Integer> stockLemon;
	VBox vbLemon, vbnamelemon, vbpricelemon, vbstocklemon, vblemonbtn;
	HBox hbLemon;
	Button lemonbtn, imgLemon;
	BorderPane lemonbp;
	
	// BLACK
	Label blacklbl, nameblack, priceblack, stockblack, descblack;
	TextField itemBlack, priceBlack;
	TextArea descBlack;
	Spinner<Integer> stockBlack;
	VBox vbBlack, vbnameblack, vbpriceblack, vbstockblack, vbblackbtn;
	HBox hbBlack;
	Button blackbtn, imgBlack;
	BorderPane blackbp;
	
	// APPLE
	Label applelbl, nameapple, priceapple, stockapple, descapple;
	TextField itemApple, priceApple;
	TextArea descApple;
	Spinner<Integer> stockApple;
	VBox vbApple, vbnameapple, vbpriceapple, vbstockapple, vbapplebtn;
	HBox hbApple;
	Button applebtn, imgApple;
	BorderPane applebp;
	
	// HONEY
	Label honeylbl, namehoney, pricehoney, stockhoney, deschoney;
	TextField itemHoney, priceHoney;
	TextArea descHoney;
	Spinner<Integer> stockHoney;
	VBox vbHoney, vbnamehoney, vbpricehoney, vbstockhoney, vbhoneybtn;
	HBox hbHoney;
	Button honeybtn, imgHoney;
	BorderPane honeybp;
	
	// MILK
	Label milklbl, namemilk, pricemilk, stockmilk, descmilk;
	TextField itemMilk, priceMilk;
	TextArea descMilk;
	Spinner<Integer> stockMilk;
	VBox vbMilk, vbnamemilk, vbpricemilk, vbstockmilk, vbmilkbtn;
	HBox hbMilk;
	Button milkbtn, imgMilk;
	BorderPane milkbp;
	
	VBox vbt, vb1, vblo;
	HBox hb1;
	ScrollPane list;
	
	Button logout;
	
	Scene scene;
	
	public void initialize() {
		
		title = new Label("Manage Items");
		vbt = new VBox();
		vblo = new VBox();
		
		//----------------------------------- Lemon Tea ------------------------------------------
		lemon = new Image(getClass().getResourceAsStream("/pages/asset/lemon_tea.jpg"));
		lemonView = new ImageView();
		
		lemonlbl = new Label("Lemon Tea");
		namelemon = new Label("Item Name");
		pricelemon = new Label("Item Price");
		stocklemon = new Label("Item Stock");
		desclemon = new Label("Description");
		
		itemLemon = new TextField(Main.tea.get(0).getName());
		priceLemon = new TextField(String.valueOf(Main.tea.get(0).getPrice()));
		stockLemon = new Spinner<>(0, 1000, Main.tea.get(0).getStock());
		descLemon = new TextArea(Main.tea.get(0).getDescription());
		
		vbLemon = new VBox();
		vbnamelemon = new VBox();
		vbpricelemon = new VBox();
		vbstocklemon = new VBox();
		vblemonbtn = new VBox();
		hbLemon = new HBox();
		lemonbp = new BorderPane();
		lemonbtn = new Button("Save Changes");
		imgLemon = new Button();
		
		//----------------------------------- Black Tea ------------------------------------------
		black = new Image(getClass().getResourceAsStream("/pages/asset/black_tea.jpg"));
		blackView = new ImageView();
		
		blacklbl = new Label("Black Tea");
		nameblack = new Label("Item Name");
		priceblack = new Label("Item Price");
		stockblack = new Label("Item Stock");
		descblack = new Label("Description");
		
		itemBlack = new TextField(Main.tea.get(1).getName());
		priceBlack = new TextField(String.valueOf(Main.tea.get(1).getPrice()));
		stockBlack = new Spinner<>(0, 1000, Main.tea.get(1).getStock());
		descBlack = new TextArea(Main.tea.get(1).getDescription());
		
		vbBlack = new VBox();
		vbnameblack = new VBox();
		vbpriceblack = new VBox();
		vbstockblack = new VBox();
		vbblackbtn = new VBox();
		hbBlack = new HBox();
		blackbp = new BorderPane();
		blackbtn = new Button("Save Changes");
		imgBlack = new Button();
		
		//----------------------------------- Apple Tea ------------------------------------------
		apple = new Image(getClass().getResourceAsStream("/pages/asset/apple_tea.jpg"));
		appleView = new ImageView();
		
		applelbl = new Label("Apple Tea");
		nameapple = new Label("Item Name");
		priceapple = new Label("Item Price");
		stockapple = new Label("Item Stock");
		descapple = new Label("Description");
		
		itemApple = new TextField(Main.tea.get(2).getName());
		priceApple = new TextField(String.valueOf(Main.tea.get(2).getPrice()));
		stockApple = new Spinner<>(0, 1000, Main.tea.get(2).getStock());
		descApple = new TextArea(Main.tea.get(2).getDescription());
		
		vbApple = new VBox();
		vbnameapple = new VBox();
		vbpriceapple = new VBox();
		vbstockapple = new VBox();
		vbapplebtn = new VBox();
		hbApple = new HBox();
		applebp = new BorderPane();
		applebtn = new Button("Save Changes");
		imgApple = new Button();
		
		//----------------------------------- Honey Tea ------------------------------------------
		honey = new Image(getClass().getResourceAsStream("/pages/asset/honey_tea.jpg"));
		honeyView = new ImageView();
		
		honeylbl = new Label();
		
		namehoney = new Label("Item Name");
		pricehoney = new Label("Item Price");
		stockhoney = new Label("Item Stock");
		deschoney = new Label("Description");
		
		itemHoney = new TextField(Main.tea.get(3).getName());
		priceHoney = new TextField(String.valueOf(Main.tea.get(3).getPrice()));
		stockHoney = new Spinner<>(0, 1000, Main.tea.get(3).getStock());
		descHoney = new TextArea(Main.tea.get(3).getDescription());
		
		vbHoney = new VBox();
		vbnamehoney = new VBox();
		vbpricehoney = new VBox();
		vbstockhoney = new VBox();
		vbhoneybtn = new VBox();
		hbHoney = new HBox();
		honeybp = new BorderPane();
		honeybtn = new Button("Save Changes");
		imgHoney = new Button();
		
		//----------------------------------- Milk Tea ------------------------------------------
		milk = new Image(getClass().getResourceAsStream("/pages/asset/milk_tea.jpg"));
		milkView = new ImageView();
		
		milklbl = new Label("Milk Tea");
		namemilk = new Label("Item Name");
		pricemilk = new Label("Item Price");
		stockmilk = new Label("Item Stock");
		descmilk = new Label("Description");
		
		itemMilk = new TextField(Main.tea.get(4).getName());
		priceMilk = new TextField(String.valueOf(Main.tea.get(4).getPrice()));
		stockMilk = new Spinner<>(0, 1000, Main.tea.get(4).getStock());
		descMilk = new TextArea(Main.tea.get(4).getDescription());
		
		vbMilk = new VBox();
		vbnamemilk = new VBox();
		vbpricemilk = new VBox();
		vbstockmilk = new VBox();
		vbmilkbtn = new VBox();
		hbMilk = new HBox();
		milkbp = new BorderPane();
		milkbtn = new Button("Save Changes");
		imgMilk = new Button();
		
		bp = new BorderPane();
		vb1 = new VBox();
		list = new ScrollPane();
		list.setPrefViewportHeight(500);
		list.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		
		logout= new Button("Logout");
		
		scene = new Scene(bp, 850, 600);
	}
	
	public void layout() {
		
		title.setFont(Font.font("Poppins", FontWeight.MEDIUM, 32));
		vbt.getChildren().add(title);
		vbt.setAlignment(Pos.CENTER);
		vbt.setPadding(new Insets(10));
		bp.setTop(vbt);
		
		//----------------------------------- Lemon Tea ------------------------------------------
		lemonView.setImage(lemon);
		lemonView.setFitHeight(240);
		lemonView.setPreserveRatio(true);
		lemonView.setSmooth(true);
		
		lemonlbl.setFont(Font.font("Poppins", FontWeight.MEDIUM, 24));
		vbnamelemon.getChildren().addAll(namelemon, itemLemon);
		vbnamelemon.setPadding(new Insets(10,10,10,0));
		
		vbpricelemon.getChildren().addAll(pricelemon, priceLemon);
		vbpricelemon.setPadding(new Insets(10,10,10,0));
		
		vbstocklemon.getChildren().addAll(stocklemon, stockLemon);
		vbstocklemon.setPadding(new Insets(10,10,10,0));
		
		hbLemon.getChildren().addAll(vbnamelemon, vbpricelemon, vbstocklemon);
		descLemon.setWrapText(true);
		descLemon.setMaxHeight(60);
		
		vblemonbtn.getChildren().add(lemonbtn);
		vblemonbtn.setPadding(new Insets(10));
		vblemonbtn.setAlignment(Pos.BOTTOM_RIGHT);
		
		descLemon.setMaxWidth(480);
		
		lemonbtn.setPadding(new Insets(5));
		lemonbtn.setStyle("-fx-background-color:#14B6B9;" + "-fx-text-fill: #F0F8FF;");
		imgLemon.setGraphic(lemonView);
		
		vbLemon.getChildren().addAll(lemonlbl, hbLemon, desclemon, descLemon, vblemonbtn);
		vbLemon.setPadding(new Insets(20));
		
		lemonbp.setLeft(imgLemon);
		lemonbp.setRight(vbLemon);
		
		//----------------------------------- Black Tea ------------------------------------------
		blackView.setImage(black);
		blackView.setFitHeight(240);
		blackView.setPreserveRatio(true);
		blackView.setSmooth(true);
		
		blacklbl.setFont(Font.font("Poppins", FontWeight.MEDIUM, 24));
		vbnameblack.getChildren().addAll(nameblack, itemBlack);
		vbnameblack.setPadding(new Insets(10,10,10,0));
		
		vbpriceblack.getChildren().addAll(priceblack, priceBlack);
		vbpriceblack.setPadding(new Insets(10,10,10,0));
		
		vbstockblack.getChildren().addAll(stockblack, stockBlack);
		vbstockblack.setPadding(new Insets(10,10,10,0));
		
		hbBlack.getChildren().addAll(vbnameblack, vbpriceblack, vbstockblack);
		descBlack.setWrapText(true);
		descBlack.setMaxHeight(60);
		
		vbblackbtn.getChildren().add(blackbtn);
		vbblackbtn.setPadding(new Insets(10));
		vbblackbtn.setAlignment(Pos.BOTTOM_RIGHT);
		
		descBlack.setMaxWidth(480);
		
		blackbtn.setPadding(new Insets(5));
		blackbtn.setStyle("-fx-background-color:#14B6B9;" + "-fx-text-fill: #F0F8FF;");
		imgBlack.setGraphic(blackView);
		
		vbBlack.getChildren().addAll(blacklbl, hbBlack, descblack, descBlack, vbblackbtn);
		vbBlack.setPadding(new Insets(20));
		
		blackbp.setLeft(imgBlack);
		blackbp.setRight(vbBlack);
		
		//----------------------------------- Apple Tea ------------------------------------------
		appleView.setImage(apple);
		appleView.setFitHeight(240);
		appleView.setPreserveRatio(true);
		appleView.setSmooth(true);
		
		applelbl.setFont(Font.font("Poppins", FontWeight.MEDIUM, 24));
		vbnameapple.getChildren().addAll(nameapple, itemApple);
		vbnameapple.setPadding(new Insets(10,10,10,0));
		
		vbpriceapple.getChildren().addAll(priceapple, priceApple);
		vbpriceapple.setPadding(new Insets(10,10,10,0));
		
		vbstockapple.getChildren().addAll(stockapple, stockApple);
		vbstockapple.setPadding(new Insets(10,10,10,0));
		
		hbApple.getChildren().addAll(vbnameapple, vbpriceapple, vbstockapple);
		descApple.setWrapText(true);
		descApple.setMaxHeight(60);
		
		vbapplebtn.getChildren().add(applebtn);
		vbapplebtn.setPadding(new Insets(10));
		vbapplebtn.setAlignment(Pos.BOTTOM_RIGHT);
		
		descApple.setMaxWidth(480);
		
		applebtn.setPadding(new Insets(5));
		applebtn.setStyle("-fx-background-color:#14B6B9;" + "-fx-text-fill: #F0F8FF;");
		imgApple.setGraphic(appleView);
		
		vbApple.getChildren().addAll(applelbl, hbApple, descapple, descApple, vbapplebtn);
		vbApple.setPadding(new Insets(20));
		
		applebp.setLeft(imgApple);
		applebp.setRight(vbApple);
		
		//----------------------------------- Honey Tea ------------------------------------------
		honeyView.setImage(honey);
		honeyView.setFitHeight(240);
		honeyView.setPreserveRatio(true);
		honeyView.setSmooth(true);
		
		honeylbl.setFont(Font.font("Poppins", FontWeight.MEDIUM, 24));
		vbnamehoney.getChildren().addAll(namehoney, itemHoney);
		vbnamehoney.setPadding(new Insets(10,10,10,0));
		
		vbpricehoney.getChildren().addAll(pricehoney, priceHoney);
		vbpricehoney.setPadding(new Insets(10,10,10,0));
		
		vbstockhoney.getChildren().addAll(stockhoney, stockHoney);
		vbstockhoney.setPadding(new Insets(10,10,10,0));
		
		hbHoney.getChildren().addAll(vbnamehoney, vbpricehoney, vbstockhoney);
		descHoney.setWrapText(true);
		descHoney.setMaxHeight(60);
		
		vbhoneybtn.getChildren().add(honeybtn);
		vbhoneybtn.setPadding(new Insets(10));
		vbhoneybtn.setAlignment(Pos.BOTTOM_RIGHT);
		
		descHoney.setMaxWidth(480);
		
		honeybtn.setPadding(new Insets(5));
		honeybtn.setStyle("-fx-background-color:#14B6B9;" + "-fx-text-fill: #F0F8FF;");
		imgHoney.setGraphic(honeyView);
		
		vbHoney.getChildren().addAll(honeylbl, hbHoney, deschoney, descHoney, vbhoneybtn);
		vbHoney.setPadding(new Insets(20));
		
		honeybp.setLeft(imgHoney);
		honeybp.setRight(vbHoney);
		
		//----------------------------------- Milk Tea ------------------------------------------
		milkView.setImage(milk);
		milkView.setFitHeight(240);
		milkView.setPreserveRatio(true);
		milkView.setSmooth(true);
		
		milklbl.setFont(Font.font("Poppins", FontWeight.MEDIUM, 24));
		vbnamemilk.getChildren().addAll(namemilk, itemMilk);
		vbnamemilk.setPadding(new Insets(10,10,10,0));
		
		vbpricemilk.getChildren().addAll(pricemilk, priceMilk);
		vbpricemilk.setPadding(new Insets(10,10,10,0));
		
		vbstockmilk.getChildren().addAll(stockmilk, stockMilk);
		vbstockmilk.setPadding(new Insets(10,10,10,0));
		
		hbMilk.getChildren().addAll(vbnamemilk, vbpricemilk, vbstockmilk);
		descMilk.setWrapText(true);
		descMilk.setMaxHeight(60);
		
		vbmilkbtn.getChildren().add(milkbtn);
		vbmilkbtn.setPadding(new Insets(10));
		vbmilkbtn.setAlignment(Pos.BOTTOM_RIGHT);
		
		descMilk.setMaxWidth(480);
		
		milkbtn.setPadding(new Insets(5));
		milkbtn.setStyle("-fx-background-color:#14B6B9;" + "-fx-text-fill: #F0F8FF;");
		imgMilk.setGraphic(milkView);
		
		vbMilk.getChildren().addAll(milklbl, hbMilk, descmilk, descMilk, vbmilkbtn);
		vbMilk.setPadding(new Insets(20));
		
		milkbp.setLeft(imgMilk);
		milkbp.setRight(vbMilk);
		
		vb1.getChildren().addAll(lemonbp, blackbp, applebp, honeybp, milkbp);
		
		vb1.setPadding(new Insets(10));
		vb1.setMargin(lemonView, new Insets(10));
		vb1.setMargin(appleView, new Insets(10));
		vb1.setMargin(blackView, new Insets(10));
		vb1.setMargin(milkView, new Insets(10));
		vb1.setMargin(honeyView, new Insets(10));
	
		list.setContent(vb1);
		list.setMaxWidth(800);
		
		bp.setCenter(list);
		
		vblo.getChildren().add(logout);
		logout.setPadding(new Insets(5));
		logout.setStyle("-fx-background-color:#14B6B9;" + "-fx-text-fill: #F0F8FF;");
		vblo.setPadding(new Insets(20));
		vblo.setAlignment(Pos.BOTTOM_RIGHT);
		bp.setBottom(vblo);
		
	}
	
	public void onAction() {
		
		
	//----------------------------------- Lemon Tea ------------------------------------------
		lemonbtn.setOnMouseClicked(e->{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			Alert success = new Alert(Alert.AlertType.INFORMATION);
			
			String name = itemLemon.getText();
			String price = priceLemon.getText();
			String desc = descLemon.getText();
			int stock = stockLemon.getValue();
			double priceL;
			
			try {
				priceL = Double.parseDouble(price);
			
			if(name.isEmpty()) {
				alert.setTitle("ERROR");
				alert.setContentText("Item Name Must Be Filled");
				alert.show();
			}else if(priceL < 10000) {
				alert.setTitle("ERROR");
	        	alert.setContentText("Item Price Must Be At Least 10000");
	        	alert.show();
			}else if(desc.length()<10){
				alert.setTitle("ERROR");
				alert.setContentText("Item Description Must Be At Least 10 Characters");
				alert.show();
			}else if(stock < 1) {
				alert.setTitle("ERROR");
				alert.setContentText("Item Stock Must Be At Least 1");
				alert.show();
			}else {
				Main.tea.set(0, new Tea(name, priceL, stock, desc));
				success.setTitle("Update Successed");
				success.setContentText("Lemon Tea Updated!");
				success.show();
			}
		}catch(NumberFormatException a) {
				alert.setTitle("ERROR");
				alert.setContentText("Item Price Must Be Numeric");
				alert.show();
		}
			
		});
	
	//----------------------------------- Black Tea ------------------------------------------
		blackbtn.setOnMouseClicked(e->{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			Alert success = new Alert(Alert.AlertType.INFORMATION);
			
			String name = itemBlack.getText();
			String price = priceBlack.getText();
			String desc = descBlack.getText();
			int stock = stockBlack.getValue();
			double priceB;
			
			try {
				priceB = Double.parseDouble(price);
			
			if(name.isEmpty()) {
				alert.setTitle("ERROR");
				alert.setContentText("Item Name Must Be Filled");
				alert.show();
			}else if(priceB < 10000) {
				alert.setTitle("ERROR");
	        	alert.setContentText("Item Price Must Be At Least 10000");
	        	alert.show();
			}else if(desc.length()<10){
				alert.setTitle("ERROR");
				alert.setContentText("Item Description Must Be At Least 10 Characters");
				alert.show();
			}else if(stock < 1) {
				alert.setTitle("ERROR");
				alert.setContentText("Item Stock Must Be At Least 1");
				alert.show();
			}else {
				Main.tea.set(1, new Tea(name, priceB, stock, desc));
				success.setTitle("Update Successed");
				success.setContentText("Black Tea Updated!");
				success.show();
			}
		}catch(NumberFormatException a) {
				alert.setTitle("ERROR");
				alert.setContentText("Item Price Must Be Numeric");
				alert.show();
		}
			
		});
		
	//----------------------------------- Apple Tea ------------------------------------------
		applebtn.setOnMouseClicked(e->{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			Alert success = new Alert(Alert.AlertType.INFORMATION);
			
			String name = itemApple.getText();
			String price = priceApple.getText();
			String desc = descApple.getText();
			int stock = stockApple.getValue();
			double priceA;
			
			try {
				priceA = Double.parseDouble(price);
			
			if(name.isEmpty()) {
				alert.setTitle("ERROR");
				alert.setContentText("Item Name Must Be Filled");
				alert.show();
			}else if(priceA < 10000) {
				alert.setTitle("ERROR");
	        	alert.setContentText("Item Price Must Be At Least 10000");
	        	alert.show();
			}else if(desc.length()<10){
				alert.setTitle("ERROR");
				alert.setContentText("Item Description Must Be At Least 10 Characters");
				alert.show();
			}else if(stock < 1) {
				alert.setTitle("ERROR");
				alert.setContentText("Item Stock Must Be At Least 1");
				alert.show();
			}else {
				Main.tea.set(2, new Tea(name, priceA, stock, desc));
				success.setTitle("Update Successed");
				success.setContentText("Apple Tea Updated!");
				success.show();
			}
		}catch(NumberFormatException a) {
				alert.setTitle("ERROR");
				alert.setContentText("Item Price Must Be Numeric");
				alert.show();
		}
			
		});
		
	//----------------------------------- Honey Tea ------------------------------------------
		honeybtn.setOnMouseClicked(e->{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			Alert success = new Alert(Alert.AlertType.INFORMATION);
			
			String name = itemHoney.getText();
			String price = priceHoney.getText();
			String desc = descHoney.getText();
			int stock = stockHoney.getValue();
			double priceH;
			
			try {
				priceH = Double.parseDouble(price);
			
			if(name.isEmpty()) {
				alert.setTitle("ERROR");
				alert.setContentText("Item Name Must Be Filled");
				alert.show();
			}else if(priceH < 10000) {
				alert.setTitle("ERROR");
	        	alert.setContentText("Item Price Must Be At Least 10000");
	        	alert.show();
			}else if(desc.length()<10){
				alert.setTitle("ERROR");
				alert.setContentText("Item Description Must Be At Least 10 Characters");
				alert.show();
			}else if(stock < 1) {
				alert.setTitle("ERROR");
				alert.setContentText("Item Stock Must Be At Least 1");
				alert.show();
			}else {
				Main.tea.set(3, new Tea(name, priceH, stock, desc));
				success.setTitle("Update Successed");
				success.setContentText("Honey Tea Updated!");
				success.show();
			}
		}catch(NumberFormatException a) {
				alert.setTitle("ERROR");
				alert.setContentText("Item Price Must Be Numeric");
				alert.show();
		}
			
		});
		
	//----------------------------------- Milk Tea ------------------------------------------
		milkbtn.setOnMouseClicked(e->{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			Alert success = new Alert(Alert.AlertType.INFORMATION);
			
			String name = itemMilk.getText();
			String price = priceMilk.getText();
			String desc = descMilk.getText();
			int stock = stockMilk.getValue();
			double priceM;
			
			try {
				priceM = Double.parseDouble(price);
			
			if(name.isEmpty()) {
				alert.setTitle("ERROR");
				alert.setContentText("Item Name Must Be Filled");
				alert.show();
			}else if(priceM < 10000) {
				alert.setTitle("ERROR");
	        	alert.setContentText("Item Price Must Be At Least 10000");
	        	alert.show();
			}else if(desc.length()<10){
				alert.setTitle("ERROR");
				alert.setContentText("Item Description Must Be At Least 10 Characters");
				alert.show();
			}else if(stock < 1) {
				alert.setTitle("ERROR");
				alert.setContentText("Item Stock Must Be At Least 1");
				alert.show();
			}else {
				Main.tea.set(4, new Tea(name, priceM, stock, desc));
				success.setTitle("Update Successed");
				success.setContentText("Milk Tea Updated!");
				success.show();
			}
		}catch(NumberFormatException a) {
				alert.setTitle("ERROR");
				alert.setContentText("Item Price Must Be Numeric");
				alert.show();
		}
			
		});
		
		logout.setOnMouseClicked(e->{
			new LoginPage(adminStage);
		});
		
	}
	
	public void imageClicked() {
		imgLemon.setOnMousePressed(e->{
			new LemonPopUp(adminStage);
		});
		imgBlack.setOnMouseClicked(e->{
			new BlackPopUp(adminStage);
		});
		imgApple.setOnMouseClicked(e->{
			new ApplePopUp(adminStage);
		});
		imgHoney.setOnMouseClicked(e->{
			new HoneyPopUp(adminStage);
		});
		imgMilk.setOnMouseClicked(e->{
			new MilkPopUp(adminStage);
		});
	}
	
	public AdminPage(Stage adminStage) {
		// TODO Auto-generated constructor stub
		this.adminStage = adminStage;
				
		initialize();
		layout();
		onAction();
		imageClicked();
		
		Image icon = new Image("logo.png");
		adminStage.setScene(scene);
		adminStage.getIcons().add(icon);
		adminStage.setTitle("Dtea Application");
		adminStage.show();
		
	}

}
