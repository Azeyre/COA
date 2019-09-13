package tp01;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerWindow {

	Button btAuditeur;
	TextArea textArea;
	TextField textField;

	public void initialize(){

	}

	public void nouveauAuditeur(){
		newWindow();
	}

	private void newWindow() {
		try{
			 URL fxmlUrl = new File("src/tp01/main.fxml").toURL();
			 Parent window = FXMLLoader.load(fxmlUrl);
			 Stage stage = new Stage();
			 stage.setScene(new Scene(window));
			 stage.setTitle("Radio Tchat"); stage.show();
		} catch(IOException e){
			e.printStackTrace();
		}
	}

}
