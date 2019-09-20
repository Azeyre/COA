package tp02;

import java.util.Observable;

public class TemperatureModel extends Observable {

	private double temperature = 20;

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
		setChanged();
		notifyObservers();
	}

}
