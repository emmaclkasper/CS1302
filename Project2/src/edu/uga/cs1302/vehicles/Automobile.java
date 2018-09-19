package edu.uga.cs1302.vehicles;

public class Automobile extends Vehicle {

    // declaration of instance variables
    private int horsepower;
    private int maxPassengers;
    private int topSpeed;

    // default constructor
    public Automobile() {
	super(); // call to parent default constructor
	horsepower = 0; // assigning instance variable to zero
    }

    // constructor with parameters
    public Automobile(String name, String manufacturer, int yrOfManufacture, int horsepower, int maxPassengers,
		      int topSpeed) {
	super(name, manufacturer, yrOfManufacture); // call to parent constructor with parameters
	this.horsepower = horsepower;
	this.maxPassengers = maxPassengers;
	this.topSpeed = topSpeed;
    }

    // getters and setters
    public int getHorsepower() {
	return horsepower;
    }

    public void setHorsepower(int horsepower) {
	this.horsepower = horsepower;
    }

    // methods overriden from transporter since Automobile extends Vehicle which
    // implements Transporter
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
