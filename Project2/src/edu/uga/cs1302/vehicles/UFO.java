package edu.uga.cs1302.vehicles;

public class UFO extends Vehicle implements Flyable {

    // declaration of variables
    private String homePlanet;
    private int maxAltitude;
    private int maxRange;
    private int numEngines;

    private int maxPassengers;
    private int topSpeed;

    // UFO default constructor
    public UFO() {
	super();
	homePlanet = null;
    }

    // UFO constuctor with parameters
    public UFO(String name, String manufacturer, int yrOfManufacture, String homePlanet, int numEngines,
	       int maxAltitude, int maxRange, int maxPassengers, int topSpeed) {
	super(name, manufacturer, yrOfManufacture); // call to the parent constructor
	this.homePlanet = homePlanet;
	this.numEngines = numEngines;
	this.maxPassengers = maxPassengers;
	this.topSpeed = topSpeed;
	this.maxAltitude = maxAltitude;
	this.maxRange = maxRange;

    }

    // getters and setters
    public String getHomePlanet() {
	return homePlanet;
    }

    public void setHomePlanet(String homePlanet) {
	this.homePlanet = homePlanet;
    }

    public int getNumEngines() {
	return numEngines;
    }

    public void setNumEngines(int numEngines) {
	this.numEngines = numEngines;
    }

    // The following methods have to be overriden bc UFO extends Vehicle and
    // implements Flyable which both have abstract methods
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

}
