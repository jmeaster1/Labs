package com.skilldistillery.jets;

public class Pilot {
	
	String name;
	int age;
	int experience;

	public Pilot() {
	}
	
	public Pilot(String name, int age, int experience) {
		super();
		this.name = name;
		this.age = age;
		this.experience = experience;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Pilot name: " + name + ", age: " + age + ", experience: " + experience + "]";
	}
	
}
