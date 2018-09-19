package edu.uga.cs1302.vehicles;

public class FP extends Vehicle implements Flyable, Floatable {

    // declaration of variables
    private int tonnage;
    private int maxAltitude;
    private int maxRange;

    private int numEngines;
    private String port;

    private int maxPassengers;
    private int topSpeed;

    // default constructor
    public FP() {
	super(); // call to parent default constructor
	numEngines = 0;// assignment of instance variables
	port = null;
    }

    // constructor with parameters
    public FP(String name, String manufacturer, int yrOfManufacture, int numEngines, int maxAltitude, int maxRange,
	      String port, int tonnage, int maxPassengers, int topSpeed) {
	super(name, manufacturer, yrOfManufacture); // call to parent constructor w/ parameters
	this.numEngines = numEngines;
	this.port = port;
	this.maxPassengers = maxPassengers;
	this.topSpeed = topSpeed;
	this.maxAltitude = maxAltitude;
	this.maxRange = maxRange;
	this.tonnage = tonnage;
    }

    // getters and setters
    public int getNumEngines() {
	return numEngines;
    }

    public void setNumEngines(int numEngines) {
	this.numEngines = numEngines;
    }

    public String getPort() {
	return port;
    }

    public void setPort(String port) {
	this.port = port;
    }

    // The following methods have to be overriden bc FP extends Vehicle and
    // implements Flyable and Floatable which all have abstract methods
    @Override
	public int getTonnage() {
	return tonnage;
    }

    @Override
	public void setTonnage(int tonnage) {
	this.tonnage = tonnage;
    }

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
