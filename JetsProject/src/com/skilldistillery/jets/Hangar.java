package com.skilldistillery.jets;

public class Hangar {
	Jet[] jets;
	
	
	
	

	public Hangar() {
		jets = new Jet[5];
	}

	public Jet[] getJets() {
		return jets;
	}

	public void setJets(Jet[] jets) {
		this.jets = jets;
	}

	public Hangar(Jet[] jets) {
		super();
		this.jets = jets;
	}
	public void addJet(Jet newJet) {
		Jet[] newJets = new Jet[jets.length + 1];
		for (int i = 0; i < jets.length; i++) {
			newJets[i] = jets[i];
		}
		newJets[newJets.length - 1] = newJet;
		jets = newJets;
			
		
		
	
	}
	
}
