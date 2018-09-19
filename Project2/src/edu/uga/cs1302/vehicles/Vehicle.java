package edu.uga.cs1302.vehicles;

public abstract class Vehicle implements Transporter {

    // declaration of instance variables
    private int maxPassengers;
    private int topSpeed;

    private String name;
    private String manufacturer;
    private int yrOfManufacture;

    // variable is static because we want to keep count of how many times the
    // instance count is called and can be shared across all classes
    private static int instanceCount = 0;

    // default constructor
    public Vehicle() {
    }

    // constructor with parameters
    public Vehicle(String name, String manufacturer, int yrOfManufacture) {

	instanceCount++; // incrementing count so that when it is called in derived classes it is
	// recorded
	this.name = name;
	this.manufacturer = manufacturer;
	this.yrOfManufacture = yrOfManufacture;

    }

    // getters and setters for parent class
    public static int getInstanceCount() {
	return instanceCount;
    }

    public void setInstanceCount(int instanceCount) {
	instanceCount++;

    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getManufacturer() {
	return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
    }

    public int getYrOfManufacture() {
	return yrOfManufacture;
    }

    public void setYrOfManufacture(int yrOfManufacture) {
	this.yrOfManufacture = yrOfManufacture;
    }

    // methods that had to be overriden because vehicle implements transpoter, the
    // parent of the overriden methods
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
