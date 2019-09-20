package tp02;

import java.util.Observable;
import java.util.Observer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class VueCelcius2 implements Observer {

	private Slider slider;

	public VueCelcius2() {
		slider = new Slider(-20, 100, 20);
		slider.setOrientation(Orientation.VERTICAL);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(10);
		slider.setMinorTickCount(5);
		slider.valueProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue arg0, Object arg1, Object arg2) {
				VueCelcius.model.setTemperature(slider.getValue());
			}
		});
		Scene scene = new Scene(slider);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Celcius");
		stage.show();
	}

	@Override
	public void update(Observable obs, Object o) {
		slider.setValue(((TemperatureModel) obs).getTemperature());
		if (((TemperatureModel) obs).getTemperature() >= 40) {
			slider.setStyle("-fx-background-color: orange;");
		} else if (((TemperatureModel) obs).getTemperature() <= 0) {
			slider.setStyle("-fx-background-color: blue;");
		} else {
			slider.setStyle("-fx-background-color: white;");
		}
	}
}
