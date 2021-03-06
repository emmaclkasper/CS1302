package edu.uga.cs1302.vehicles;

import java.util.Scanner;

public class VehicleDriver {

    // method to print out the menu
    public static void menu() {

	System.out.println("Press 1 to see how many vehicles are in the system.\n"
			   + "Press 2 to see the name and kind of each Vehicle. \n" + "Press 3 to see which vehicles can fly. \n"
			   + "Press 4 to see which vehicles can float.\n" + "Press 5 to see which vehicles can float AND fly. \n"
			   + "Press 6 to see a description of each vehicle.\n"
			   + "Press h to see a brief help information for your system.\n" + "Press q to terminate the program.");
	System.out.println("");

    }

    // vehicle stored in a static variable because it does not need to be changed
    // and must be shared across all classes
    static Vehicle[] vehicle = new Vehicle[15];

    // static method because we are using a static variable, checks that the vehicle
    // at i index is an instance of Vehicle class, if so prints the Type and name of
    // vehicle and index i
    public static void instanceOfVehicle() {

	for (int i = 0; i < vehicle.length; i++) {

	    if (vehicle[i] instanceof Vehicle) {

		System.out.println("Type: " + vehicle[i].getClass().getSimpleName() + "\n" + "Name: "
				   + vehicle[i].getName() + "\n");

	    }

	    else {
		continue;
	    }

	}

    }

    // static method because we are using a static variable, checks that the vehicle
    // at i index is an instance of Flyable, if so prints the Type and name of
    // vehicle and index i
    public static void instanceOfFlyable() {

	for (int i = 0; i < vehicle.length; i++) {

	    if (vehicle[i] instanceof Flyable) {
		System.out.println("Type: " + vehicle[i].getClass().getSimpleName() + "\n" + "Name: "
				   + vehicle[i].getName() + "\n");
	    }

	    else {
		continue;
	    }

	}

    }

    // static method because we are using a static variable, checks that the vehicle
    // at i index is an instance of Floatable, if so prints the Type and name of
    // vehicle and index i
    public static void instanceOfFloatable() {

	for (int i = 0; i < vehicle.length; i++) {

	    if (vehicle[i] instanceof Floatable) {
		System.out.println("Type: " + vehicle[i].getClass().getSimpleName() + "\n" + "Name: "
				   + vehicle[i].getName() + "\n");
	    }

	    else {
		continue;
	    }

	}

    }

    // static method because we are using a static variable, checks that the vehicle
    // at i index is an instance of Flyable and Floatable, if so prints the Type and
    // name of vehicle and index i
    public static void instanceOfFlyableAndFloatable() {

	for (int i = 0; i < vehicle.length; i++) {

	    if (vehicle[i] instanceof Flyable && vehicle[i] instanceof Floatable) {
		System.out.println("Type: " + vehicle[i].getClass().getSimpleName() + "\n" + "Name: "
				   + vehicle[i].getName() + "\n");
	    }

	    else {
		continue;
	    }

	}

    }


    // static method because we are using a static variable, checks that the vehicle
    // at i index is an instance of specified class, based on which class it prints
    // all
    // details pertaining to the vehicle at index i
    public static void allDetails() {
	for (int i = 0; i < vehicle.length; i++) {

	    if (vehicle[i] instanceof Automobile) {
		System.out.println("Type: \t\t\t" + vehicle[i].getClass().getSimpleName() + "\n" + "Name: \t\t\t"
				   + vehicle[i].getName() + "\n" + "Manufacturer: \t\t" + vehicle[i].getManufacturer() + "\n"
				   + "Manufacture Year: \t" + vehicle[i].getYrOfManufacture() + "\n" + "Engine Power: \t\t"
				   + ((Automobile) vehicle[i]).getHorsepower() + " hp" + "\n" + "Max Passengers: \t"
				   + vehicle[i].getMaxPassengers() + "\n" + "Top Speed: \t\t" + vehicle[i].getTopSpeed() + " mph"
				   + "\n");

		continue;
	    }

	    if (vehicle[i] instanceof Airplane) {
		System.out.println("Type: \t\t\t" + vehicle[i].getClass().getSimpleName() + "\n" + "Name: \t\t\t"
				   + vehicle[i].getName() + "\n" + "Manufacturer: \t\t" + vehicle[i].getManufacturer() + "\n"
				   + "Manufacture Year: \t" + vehicle[i].getYrOfManufacture() + "\n" + "Number of Engines: \t"
				   + ((Airplane) vehicle[i]).getNumEngines() + "\n" + "Max Altitude: \t\t"
				   + ((Airplane) vehicle[i]).getMaxAltitude() + " ft" + "\n" + "Max Range: \t\t"
				   + ((Airplane) vehicle[i]).getMaxRange() + " mi" + "\n" + "Max Passengers: \t"
				   + vehicle[i].getMaxPassengers() + "\n" + "Top Speed: \t\t" + vehicle[i].getTopSpeed() + " mph"
				   + "\n");
		continue;
	    }
	    if (vehicle[i] instanceof Ship) {
		System.out.println("Type: \t\t\t" + vehicle[i].getClass().getSimpleName() + "\n" + "Name: \t\t\t"
				   + vehicle[i].getName() + "\n" + "Manufacturer: \t\t" + vehicle[i].getManufacturer() + "\n"
				   + "Manufacture Year: \t" + vehicle[i].getYrOfManufacture() + "\n" + "Tonnage: \t\t"
				   + ((Ship) vehicle[i]).getTonnage() + " t" + "\n" + "Owner: \t\t\t"
				   + ((Ship) vehicle[i]).getLineOwner() + "\n" + "Max Passengers: \t"
				   + vehicle[i].getMaxPassengers() + "\n" + "Top Speed: \t\t" + vehicle[i].getTopSpeed() + " mph"
				   + "\n");
		continue;
	    }
	    if (vehicle[i] instanceof FP) {
		System.out.println("Type: \t\t\t" + vehicle[i].getClass().getSimpleName() + "\n" + "Name: \t\t\t"
				   + vehicle[i].getName() + "\n" + "Manufacturer: \t\t" + vehicle[i].getManufacturer() + "\n"
				   + "Manufacture Year: \t" + vehicle[i].getYrOfManufacture() + "\n" + "Number of Engines: \t"
				   + ((FP) vehicle[i]).getNumEngines() + "\n" + "Max Altitude: \t\t"
				   + ((FP) vehicle[i]).getMaxAltitude() + " ft" + "\n" + "Max Range: \t\t"
				   + ((FP) vehicle[i]).getMaxRange() + " mi" + "\n" + "Port: \t\t\t" + ((FP) vehicle[i]).getPort()
				   + "\n" + "Tonnage: \t\t" + ((FP) vehicle[i]).getTonnage() + " t" + "\n" + "Max Passengers: \t"
				   + vehicle[i].getMaxPassengers() + "\n" + "Top Speed: \t\t" + vehicle[i].getTopSpeed() + " mph"
				   + "\n");
		continue;
	    }

	    if (vehicle[i] instanceof UFO) {
		System.out.println("Type: \t\t\t" + vehicle[i].getClass().getSimpleName() + "\n" + "Name: \t\t\t"
				   + vehicle[i].getName() + "\n" + "Manufacturer: \t\t" + vehicle[i].getManufacturer() + "\n"
				   + "Manufacture Year: \t" + vehicle[i].getYrOfManufacture() + "\n" + "Home Planet:\t\t"
				   + ((UFO) vehicle[i]).getHomePlanet() + "\n" + "Number of Engines: \t"
				   + ((UFO) vehicle[i]).getNumEngines() + "\n" + "Max Altitude: \t\t"
				   + ((UFO) vehicle[i]).getMaxAltitude() + " ft" + "\n" + "Max Range: \t\t"
				   + ((UFO) vehicle[i]).getMaxRange() + " mi" + "\n" + "Max Passengers: \t"
				   + vehicle[i].getMaxPassengers() + "\n" + "Top Speed: \t\t" + vehicle[i].getTopSpeed()
				   + " light yrs/min " + "\n");
		continue;
	    }

	}
    }



    // main method
    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

	// boolean variable that controls switch statement loop
	boolean validInput = true;

	// Assignment of vehicle array with vehicle objects
	vehicle[0] = new Automobile("Mustang Shelby GT350R", "Ford", 2017, 526, 2, 175);
	vehicle[1] = new Automobile("G-Class", "Mercedes-Benz", 2018, 416, 5, 149);
	vehicle[2] = new Automobile("Unlimited Sahara", "Jeep Wrangler", 2018, 285, 5, 112);
	vehicle[3] = new Airplane("Boeing 787", "Boeing", 2014, 2, 43000, 8500, 280, 587);
	vehicle[4] = new Airplane("F-15E Strike Eagle", "Boeing", 2001, 2, 60000, 2400, 2, 1875);
	vehicle[5] = new Airplane("Cesna 210", "Cesna", 1986, 1, 2700, 900, 6, 235);
	vehicle[6] = new Ship("Queen Mary 2", "Chantiers de l'Atlantique", 2004, 148528, "Cunard Line", 2620, 34);
	vehicle[7] = new Ship("RMS Titanic", "Harland and Wolff, Belfast", 1912, 46328, "White Star Line", 3327, 28);
	vehicle[8] = new Ship("Black Pearl", "Caribbean Depp ", 1624, 3240, "Sparrow Line", 300, 24);
	vehicle[9] = new FP("HU-16 Albatross", "Grumman", 1949, 2, 32883, 2850, "Naval Station Guantanamo Bay", 30353,
			    10, 236);
	vehicle[10] = new FP("NC-4", "Curtiss Aeroplane and Motor Company", 1918, 3, 4500, 1470,
			     "Naval Station Key West", 27386, 5, 85);
	vehicle[11] = new FP("Felixstowe F.5", "Canadian Aeroplanes Limited", 1918, 2, 6800, 3240,
			     "Naval Station Barbers Point", 12682, 4, 142);
	vehicle[12] = new UFO("Milano", "Quil Enterprise", 1980, "Ego", 4, 10000000, 20000000, 8, 11000);
	vehicle[13] = new UFO("Ebon Hawk", "Sith LLC", 25053, "Suurja", 10, 175000000, 1000000, 20, 15000);
	vehicle[14] = new UFO("Ark", "Vanguard", 1984, "Cybertron", 4, 300000000, 123456789, 300, 20000);

	// do while loop that controls the switch statement, while true the loop ends,
	// while false the loop continues
	do {
	    menu(); // prints menu
	    System.out.print("Menu Selection: ");
	    String menuChoice = input.nextLine(); // user input
	    System.out.println("");

	    // control statement
	    switch (menuChoice) {

		// choice 1 prints the number of instances of Vehicle
	    case "1":
		System.out.println("There are " + Vehicle.getInstanceCount() + " instances of Vehicle");
		validInput = true;
		break;
		// choice 2 prints the type and name of EVERY vehicle in vehicle array
	    case "2":
		instanceOfVehicle(); // call to validate if an object is an instance of vehicle
		validInput = true;
		break;
		// choice 3 prints the type and name of EVERY vehicle that CAN fly
	    case "3":
		instanceOfFlyable();
		validInput = true;// call to validate if an object is an instance of flyable
		break;
		// choice 4 prints the type and name of EVERY vehicle that CAN float
	    case "4":
		instanceOfFloatable();// call to validate if an object is an instance of floatable
		validInput = true;
		break;
		// choice 5 prints the type and name of EVERY vehicle that CAN fly AND float
	    case "5":
		instanceOfFlyableAndFloatable();// call to validate if an object is an instance of vehicle
		validInput = true;
		break;
		// choice 6 prints all details of ALL vehicles in the the vehicle array
	    case "6":
		allDetails();// call to print all details for each vehicle
		validInput = true;
		break;
		// choice h prints an error message to reenter a valid menu option, repeats loop
		// until validInput is true
	    case "h":
		System.err.println("Please enter a valid menu option.");
		System.out.println();
		validInput = false;
		break;
		// choice q terminates the program
	    case "q":
		System.out.println("Goodbye!");
		validInput = true;
		System.exit(0);
		break;

		// default case if none of the above cases are selected is an error message to
		// reenter a valid menu option, repeats loop until validInput is true
	    default:
		System.err
		    .println("Please enter a number between 1 - 6 or the letters 'h' (for help) or 'q' (to quit)");
		System.out.println("");
		validInput = false;
	    }

	} while (validInput == false); // end of loop
	input.close(); // scanner close
    } // main
}// VehicleDriver class
