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

	protected TextField txtField;
	protected TextArea txtArea;
	protected Sub sub;

	public static void main(String[] args){
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		VBox vbox = new VBox();
		sub = new Sub();
		Button btAuditeur = new Button("Nouveau Auditeur");
		txtArea = new TextArea();
		txtField = new TextField();

		btAuditeur.setOnMouseClicked(e -> new Obs(sub) );

		txtArea.setEditable(false);

		txtField.setOnAction(e -> sendMessage());

		btAuditeur.setMaxWidth(Double.MAX_VALUE);
		vbox.setVgrow(txtArea, Priority.ALWAYS);
		vbox.getChildren().addAll(btAuditeur, txtArea, txtField);

		Scene scene = new Scene(vbox);
		stage.setScene(scene);
		stage.setTitle("Radio chat");
		stage.show();
	}

	private void sendMessage() {
		if(!txtField.getText().isEmpty()){
			sub.setText("Principal : " + txtField.getText());
			sub.notifyObservers();
			txtField.setText("");
		}
	}

	public class Sub extends Subject {

		String txt;

		public void setText(String s){
			txtArea.setText(txtArea.getText() + "\n" + s);
			txt = s;
		}

		public String getText() {
			return txt + "\n";
		}
	}
}
