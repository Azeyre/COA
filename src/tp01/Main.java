package tp01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args){
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		VBox vbox = new VBox();

		Button btAuditeur = new Button("Nouveau Auditeur");
		TextArea txtArea = new TextArea();
		TextField txtField = new TextField();

		btAuditeur.setOnMouseClicked(e -> {
			openNewWindow();
		});

		btAuditeur.setMaxWidth(Double.MAX_VALUE);
		vbox.setVgrow(txtArea, Priority.ALWAYS);
		vbox.getChildren().addAll(btAuditeur, txtArea, txtField);

		Scene scene = new Scene(vbox);
		stage.setScene(scene);
		stage.setTitle("Radio chat");
		stage.show();
	}

	private void openNewWindow(){
		VBox vbox = new VBox();

		TextArea txtArea = new TextArea();
		TextField txtField = new TextField();

		vbox.setVgrow(txtArea, Priority.ALWAYS);
		vbox.getChildren().addAll(txtArea, txtField);

		Scene scene = new Scene(vbox);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Radio chat");
		stage.show();
	}
}
