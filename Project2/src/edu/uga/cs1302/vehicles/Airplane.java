package edu.uga.cs1302.vehicles;

public class Airplane extends Vehicle implements Flyable {

    // declaration of instance variables
    private int numEngines;
    private int maxAltitude;
    private int maxRange;
    private int maxPassengers;
    private int topSpeed;

    // default constructor
    public Airplane() {
	super(); // call to parent default constructor
	numEngines = 0; // assigning instance variable to zero
    }

    // constructor with parameters
    public Airplane(String name, String manufacturer, int yrOfManufacture, int numEngines, int maxAltitude,
		    int maxRange, int maxPassengers, int topSpeed) {
	super(name, manufacturer, yrOfManufacture); // call to parent constructor with parameters
	this.numEngines = numEngines;
	this.maxAltitude = maxAltitude;
	this.maxRange = maxRange;
	this.maxPassengers = maxPassengers;
	this.topSpeed = topSpeed;
    }

    // getters and setters
    public int getNumEngines() {
	return numEngines;
    }

    public void setNumEngines(int numEngines) {
	this.numEngines = numEngines;
    }

    // overriden methods from Vehicle and flyable since Airplane extends Vehicle and
    // implements Flyable
    @Override
	public int getMaxAltitude() {
	return maxAltitude;
    }

    @Override
	public void setMaxAltitude(int maxAltitude) {

	this.maxAltitude = maxAltitude;
    }

    @Override
	public int getMaxRange() {
	return maxRange;
    }

    @Override
	public void setMaxRange(int maxRange) {
	this.maxRange = maxRange;

    }

    @Override
	public int getMaxPassengers() {

	return maxPassengers;
    }

    @Override
	public void setMaxPassengers(int maxPassengers) {
	this.maxPassengers = maxPassengers;

    }

    @Override
	public int getTopSpeed() {

	return topSpeed;
    }

    @Override
	public void setTopSpeed(int topSpeed) {
	this.topSpeed = topSpeed;

    }

}
