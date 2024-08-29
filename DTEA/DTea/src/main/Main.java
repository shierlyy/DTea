package main;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.input.DataFormat;
import javafx.stage.Stage;
import pages.LoginPage;
import pages.Tea;
import pages.User;

public class Main extends Application {
	
	public static ArrayList<User> registedUser = new ArrayList<>();
	public static User currUser;
	
	public static ArrayList<Tea> tea = new ArrayList<>(); 
	
	public static final DataFormat TEA_PRICE = new DataFormat("application/x-java-tea-price");
	public static final DataFormat TEA_NAME = new DataFormat("application/x-java-tea-name");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	private void add() {
		tea.add(new Tea("Lemon Tea", 20000, 10, "A refreshing infusion of black tea subtly brightened by the zesty essence of fresh lemons, offering a tangy and invigorating flavor profile"));
		tea.add(new Tea("Black Tea", 10000, 20, "A robust and full-bodied brew, characterized by its deep, malty notes and a bold, satisfying taste that makes it a classic choice for tea enthusiasts"));
		tea.add(new Tea("Apple Tea", 25000, 20, "A delightful infusion blending the sweetness of ripe apples with the comforting warmth of tea, creating a fruity and aromatic beverage that evokes the essence of a crisp autumn day"));
		tea.add(new Tea("Honey Tea", 30000, 20, "A soothing concoction that combines the natural sweetness of honey with the mellow tones of tea, resulting in a comforting and mildly sweetened drink that is perfect for relaxation"));
		tea.add(new Tea("Milk Tea", 35000, 0, "A rich and creamy fusion of tea and milk, offering a harmonious balance of bold tea flavors and the velvety smoothness of milk, creating a comforting and indulgent beverage enjoyed worldwide"));
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		add();
		new LoginPage(primaryStage);
	}

}
