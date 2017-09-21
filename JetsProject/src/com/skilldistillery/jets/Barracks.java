package com.skilldistillery.jets;

public class Barracks {
	Pilot[] pilots;

	public Barracks() {
		pilots = new Pilot[5];
	}

	public Pilot[] getPilots() {
		return pilots;
	}

	public void setPilots(Pilot[] pilots) {
		this.pilots = pilots;
	}

	public Barracks(Pilot[] pilots) {
		super();
		this.pilots = pilots;
	}

	public void addPilot(Pilot newPilot) {
		Pilot[] newPilots = new Pilot[pilots.length + 1];
		for (int i = 0; i < pilots.length; i++) {
			newPilots[i] = pilots[i];
		}
		newPilots[newPilots.length - 1] = newPilot;
		pilots = newPilots;

	}
}
