package tp01;

import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args){
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		 URL fxmlUrl = new File("src/tp01/main.fxml").toURL();
		 Parent window = FXMLLoader.load(fxmlUrl); stage.setScene(new Scene(window));
		 stage.setTitle("Radio Tchat"); stage.show();
	}
}
