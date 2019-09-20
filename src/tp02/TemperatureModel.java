package tp02;

import java.util.Observable;

public class TemperatureModel extends Observable {

	private double temperature = 20;
	private double fahr;

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
		setChanged();
		notifyObservers();
	}

	public void incrementTemperature(int i) {
		setTemperature(temperature + i);
	}

	public void incrementeFahrenheit(int i) {
		fahr = (temperature * 1.8) + 32 + i;
		setTemperature((fahr - 32) / 1.8);
	}

}
