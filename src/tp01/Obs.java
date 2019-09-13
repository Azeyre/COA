package tp01;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tp01.Main.Sub;

public class Obs implements Observer {

	Sub sub;
	protected TextArea txtArea;

	public Obs(Sub sub){
		VBox vbox = new VBox();
		txtArea = new TextArea();
		txtArea.setEditable(false);
		vbox.setVgrow(txtArea, Priority.ALWAYS);
		vbox.getChildren().addAll(txtArea);
		Scene scene = new Scene(vbox);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Radio chat");
		stage.show();
		this.sub = sub;
		sub.attach(this);
	}

	@Override
	public void update() {
		txtArea.setText(sub.getText());
	}
}