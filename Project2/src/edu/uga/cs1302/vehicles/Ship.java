package edu.uga.cs1302.vehicles;

public class Ship extends Vehicle implements Floatable {

    // declaration of variables
    private int tonnage;
    private String lineOwner;
    private int maxPassengers;
    private int topSpeed;

    // default constructor
    public Ship() {
	super();// call to parent default constructor
	lineOwner = null; // assignment of instance variable
    }

    // constructor with parameters
    public Ship(String name, String manufacturer, int yrOfManufacture, int tonnage, String lineOwner, int maxPassengers,
		int topSpeed) {
	super(name, manufacturer, yrOfManufacture); // call to parent constructor w/parameters
	this.tonnage = tonnage;
	this.lineOwner = lineOwner;
	this.maxPassengers = maxPassengers;
	this.topSpeed = topSpeed;

    }

    // getters and setters
    public String getLineOwner() {
	return lineOwner;
    }

    public void SetLineOwner(String lineOwner) {
	this.lineOwner = lineOwner;
    }

    // The following methods have to be overriden bc Ship extends Vehicle implements
    // Floatable with abstract methods
    @Override
	public int getTonnage() {
	return tonnage;
    }

    @Override
	public void setTonnage(int tonnage) {
	this.tonnage = tonnage;

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
