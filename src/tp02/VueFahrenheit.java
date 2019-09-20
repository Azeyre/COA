package tp02;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VueFahrenheit implements Observer {

	private TextField txtField;
	private TemperatureModel model;

	public VueFahrenheit(Observable o) {
		model = (TemperatureModel) o;
		model.addObserver(this);
		VBox vbox = new VBox();
		Label label = new Label("Temperature Fahrenheit");
		txtField = new TextField("68");
		txtField.setOnAction(e -> model.setTemperature(getCelcius()));
		Button plus = new Button("+");
		Button moins = new Button("-");
		HBox hbox = new HBox();
		hbox.getChildren().addAll(plus, moins);
		plus.setOnAction(e -> model.incrementeFahrenheit(1));
		moins.setOnAction(e -> model.incrementeFahrenheit(-1));
		txtField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue.matches("[\\-]?[0-9]*[\\.]?[0-9]*")) {
				txtField.setText(oldValue);
			}
		});

		vbox.getChildren().addAll(label, txtField, hbox);
		Scene scene = new Scene(vbox);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Temperature en Fahrenheit");
		stage.show();
	}

	private double getCelcius() {
		return (Double.valueOf(txtField.getText()) - 32) / 1.8;
	}

	@Override
	public void update(Observable obs, Object o) {
		double temp = ((TemperatureModel) obs).getTemperature();
		temp = (temp * 1.8) + 32;
		txtField.setText("" + temp);
		if (((TemperatureModel) obs).getTemperature() >= 40) {
			txtField.setStyle("-fx-background-color: orange;");
		} else if (((TemperatureModel) obs).getTemperature() <= 0) {
			txtField.setStyle("-fx-background-color: blue;");
		} else {
			txtField.setStyle("-fx-background-color: white;");
		}
	}

}
