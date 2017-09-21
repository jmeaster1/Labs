package com.skilldistillery.jets;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JetsApp {
	Hangar hangar;
	Barracks barracks;

	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApp jetsApp = new JetsApp();
		jetsApp.runApp();
	}
	
	public void runApp() {// sets user menu
		hangar = new Hangar();
		barracks = new Barracks();
		initializeHangarAndBarracks();
		String choice;
		int intChoice;
		do {// display menu
			System.out.println("(1)List Fleet");
			System.out.println("(2)View Fastest Jet");
			System.out.println("(3)View Jet With Longest Range");
			System.out.println("(4)Add A Custom Jet To Fleet");
			System.out.println("(5)Add Custom Pilot to Barracks");
			System.out.println("(6)Show Available Pilots");
			System.out.println("(7)Quit");
			System.out.println("Please choose a menu option.");
			choice = kb.next();
			try {// switch statement to execute menu choice
				intChoice = Integer.parseInt(choice);
				switch (intChoice) {
				case 1:
					listFleet();
					break;
				case 2:
					showFastestJet();
					break;
				case 3:
					showMaxRangeJet();
					break;
				case 4:
					addJet(kb);
					break;
				case 5:
					addPilot(kb);
					break;
				case 6:
					displayBarracks();
					break;
				case 7:
					quit();
					break;
				}
			} catch (NumberFormatException e) {
				intChoice = 1;
				System.out.println("Please enter an integer:");
			}
		} while (intChoice > 0 && intChoice < 7);

	}

	public void initializeHangarAndBarracks() {// adds pilots to barracks and jets to hangar. Generates random pilot for
												// each jet.

		hangar = new Hangar();
		Jet[] jets = new Jet[5];
		Pilot[] pilots = new Pilot[5];

		pilots[0] = new Pilot("Maverick", 31, 8);
		pilots[1] = new Pilot("Goose", 30, 7);
		pilots[2] = new Pilot("Ice Man", 32, 10);
		pilots[3] = new Pilot("Red Baron", 45, 20);
		pilots[4] = new Pilot("Launchpad McQuack", 42, 30);

		jets[0] = new Jet("C-130", 368.0, 2361.0, 60_000);
		jets[1] = new Jet("C-17", 500.0, 6456.0, 181_054);
		jets[2] = new Jet("C-5", 500.0, 7273.1, 240_000);
		jets[3] = new Jet("KC-135", 580.0, 1503.0, 203_000);
		jets[4] = new Jet("B-52", 644.0, 8800.0, 312_197);

		// create new array to store yes (1) or no(0)
		int[] arr = new int[5];

		// iterate over array to store no(0) in each element spot
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}

		// iterate over jets array to set pilots
		for (int i = 0; i < jets.length; i++) {

			// declare new boolean to determine if we need to find another index
			// because index may already be taken
			boolean keepSearching = true;

			// int to store the random index of the pilot in the pilot array
			int randomIndex;
			do {

				// get random number between 0 and 4
				randomIndex = (int) (Math.random() * 5);

				// check arr to see if that index (randomIndex) is NOT taken
				// set keepSearching to false so the loop breaks
				// set that index (randomIndex) to 1 to indicate that spot is now taken
				if (arr[randomIndex] == 0) {
					keepSearching = false;
					arr[randomIndex] = 1;
				}
			} while (keepSearching);

			// set pilot to jet using randomIndex
			jets[i].setPilot(pilots[randomIndex]);
		}

		hangar.setJets(jets);
		barracks.setPilots(pilots);

	}

	public void listFleet() {// prints info for all jets in hangar
		Jet[] jets = hangar.getJets();
		for (int i = 0; i < jets.length; i++) {
			System.out.println(jets[i]);
		}
		System.out.println();
	}

	public void showFastestJet() {// displays fastest jet on fleet
		Jet[] jets = hangar.getJets();
		Jet fastJet = jets[0];
		for (int i = 0; i < jets.length; i++) {
			if (fastJet.convertToMach() < jets[i].convertToMach()) {
				fastJet = jets[i];
			}
		}
		System.out.println(fastJet);
		System.out.println();

	}

	public void showMaxRangeJet() {// displays max range jet in hangar
		Jet[] jets = hangar.getJets();
		Jet maxRangeJet = jets[0];
		for (int i = 0; i < jets.length; i++) {
			if (maxRangeJet.getRange() < jets[i].getRange()) {
				maxRangeJet = jets[i];
			}

		}
		System.out.println(maxRangeJet);
		System.out.println();

	}

	public void addJet(Scanner kb) {// add custom jet to fleet
		Jet newJet = new Jet();
		System.out.println("Please enter the MODEL of your new jet.");
		String newModel = kb.next();
		newJet.setModel(newModel);

		System.out.println("Please enter the SPEED of your new jet in mph.");
		double newSpeed = kb.nextDouble();
		newJet.setSpeed(newSpeed);

		System.out.println("Please enter the RANGE of your new jet in miles.");
		double newRange = kb.nextDouble();
		newJet.setRange(newRange);

		System.out.println("Please enter the fuel CAPACITY of your new jet in pounds.");
		double newCapacity = kb.nextDouble();
		newJet.setCapacity(newCapacity);

		hangar.addJet(newJet);// new jet added to fleet

	}

	public void addPilot(Scanner kb) {// add custom pilot to barracks
		Pilot newPilot = new Pilot();
		System.out.println("Please enter the NAME of your new pilot.");
		kb.nextLine();
		String newName = kb.nextLine();
		newPilot.setName(newName);

		System.out.println("Please enter the AGE of your new pilot.");
		int newAge = kb.nextInt();
		newPilot.setAge(newAge);

		System.out.println("Please enter the EXPERIENCE of your new pilot in years.");
		int newExp = kb.nextInt();
		newPilot.setExperience(newExp);

		barracks.addPilot(newPilot);
	}

	public void quit() {// quits application
		System.out.println("Your session has ended");
		System.exit(0);
	}

	public void displayBarracks() {//displays available pilots in barracks
		for (int i = 0; i < barracks.getPilots().length; i++) {
			System.out.println(barracks.getPilots()[i]);
		}
		System.out.println();
	}
}