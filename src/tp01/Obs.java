package tp01;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tp01.Main.Sub;

public class Obs implements Observer {

	Sub sub;
	protected TextArea txtArea;
	protected TextField txtField;

	public Obs(Sub sub){
		this.sub = sub;
		VBox vbox = new VBox();
		txtArea = new TextArea();
		txtField = new TextField();
		txtArea.setEditable(false);

		vbox.setVgrow(txtArea, Priority.ALWAYS);
		vbox.getChildren().addAll(txtArea, txtField);

		txtField.setOnAction(e -> sendMessage());

		Scene scene = new Scene(vbox);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Radio chat");
		stage.setOnCloseRequest(e -> sub.detach(this));
		stage.show();
		sub.attach(this);
	}

	private void sendMessage(){
		if(!txtField.getText().isEmpty()){
			sub.setText("Auditeur : " + txtField.getText());
			sub.notifyObservers();
			txtField.setText("");
		}
	}

	@Override
	public void update() {
		txtArea.setText(txtArea.getText() + sub.getText());
	}
}