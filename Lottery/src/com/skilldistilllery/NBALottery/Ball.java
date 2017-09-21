package com.skilldistilllery.NBALottery;

public class Ball {
 private String label;

public Ball(String label) {
	super();
	this.label = label;
}

public String getLabel() {
	return label;
}

public void setLabel(String label) {
	this.label = label;
}

@Override
public String toString() {
	return "Ball [label=" + label + "]";
}
 
}
