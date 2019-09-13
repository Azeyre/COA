package tp01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	protected TextArea txtArea;

	public static void main(String[] args){
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		VBox vbox = new VBox();
		Sub sub = new Sub();

		Button btAuditeur = new Button("Nouveau Auditeur");
		txtArea = new TextArea();
		TextField txtField = new TextField();

		btAuditeur.setOnMouseClicked(e -> new Obs(sub) );

		txtArea.setEditable(false);

		txtField.setOnKeyPressed(e -> keyPressed(sub, txtArea, txtField, e) );

		btAuditeur.setMaxWidth(Double.MAX_VALUE);
		vbox.setVgrow(txtArea, Priority.ALWAYS);
		vbox.getChildren().addAll(btAuditeur, txtArea, txtField);

		Scene scene = new Scene(vbox);
		stage.setScene(scene);
		stage.setTitle("Radio chat");
		stage.show();
	}

	private void keyPressed(Sub sub, TextArea txtArea, TextField txtField, KeyEvent e) {
		if(e.getCode().equals(KeyCode.ENTER)){
			txtArea.setText(txtArea.getText() + "\n" + txtField.getText());
			txtField.setText("");
			sub.notifyObservers();
		}
	}

	public class Sub extends Subject {

		public String getText() {
			return txtArea.getText();
		}
	}
}
