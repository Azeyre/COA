package tp02;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VueCelcius extends Application implements Observer {

	public static void main(String[] args){
		model = new TemperatureModel();
		launch();
	}
	public static TemperatureModel model;
	private TextField txtField;

	@Override
	public void update(Observable obs, Object o) {
		txtField.setText("" + ((TemperatureModel) obs).getTemperature());
		if(((TemperatureModel) obs).getTemperature() >= 40){
			txtField.setStyle("-fx-background-color: orange;");
		} else if(((TemperatureModel) obs).getTemperature() <= 0){
			txtField.setStyle("-fx-background-color: blue;");
		} else {
			txtField.setStyle("-fx-background-color: white;");
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		VBox vbox = new VBox();
		Label label = new Label("Temperature Celcius");
		txtField = new TextField("20");
		txtField.setOnAction(e -> model.setTemperature(Double.valueOf(txtField.getText())));
		txtField.textProperty().addListener((observable, oldValue, newValue) -> {
        	if(!newValue.matches("[\\-]?[0-9]*[\\.]?[0-9]*")) {
        		txtField.setText(oldValue);
            }
        });
		HBox bts = new HBox();
		Button plus = new Button("+");
		Button moins = new Button("-");
		plus.setOnAction(e -> model.setTemperature(modif(1)));
		moins.setOnAction(e -> model.setTemperature(modif(-1)));
		bts.getChildren().addAll(plus, moins);

		vbox.getChildren().addAll(label, txtField, bts);
		Scene scene = new Scene(vbox);
		stage.setScene(scene);
		stage.setTitle("Temperature en Celcius");
		stage.show();

		VueFahrenheit vue = new VueFahrenheit();
		VueCelcius2 vue2 = new VueCelcius2();

		model.addObserver(this);
		model.addObserver(vue);
		model.addObserver(vue2);
	}

	private double modif(int i){
		return Double.valueOf(txtField.getText()) + i;
	}

}
