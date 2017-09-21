package com.skilldistillery.history;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class President implements Comparable<President> {
	private int termNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private int electionsWon;
	private String whyLeftOffice;
	private String party;
	private LocalDate termStartYear, termEndYear;

	// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM/dd/yyyy");
	// LocalDate dt = LocalDate.parse(termStartYear, formatter);
	// LocalDate dt2 = LocalDate.parse(termEndYear, formatter);
	public Period getTermLength() {
		Period p1;
		if (termEndYear == null) {

			p1 = Period.between(termStartYear, LocalDate.now());
		} else {

			p1 = Period.between(termStartYear, termEndYear);
		}

		return p1;
	}

	public LocalDate getTermStartYear() {
		return termStartYear;
	}

	public void setTermStartYear(LocalDate termStartYear) {
		this.termStartYear = termStartYear;
	}

	public LocalDate getTermEndYear() {
		return termEndYear;
	}

	public void setTermEndYear(LocalDate termEndYear) {
		this.termEndYear = termEndYear;
	}

	public President(int termNumber, String firstName, String middleName, String lastName, int electionsWon,
			String whyLeftOffice, String party, LocalDate termStartYear, LocalDate termEndYear) {
		super();
		this.termNumber = termNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.electionsWon = electionsWon;
		this.whyLeftOffice = whyLeftOffice;
		this.party = party;
		this.termStartYear = termStartYear;
		this.termEndYear = termEndYear;
	}

	public President(int termNumber, String firstName, String middleName, String lastName, int electionsWon,
			String reasonLeftOffice, String party) {
		super();
		this.termNumber = termNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.electionsWon = electionsWon;
		this.whyLeftOffice = reasonLeftOffice;
		this.party = party;
	}

	public int getTermNumber() {
		return termNumber;
	}

	public void setTermNumber(int termNumber) {
		this.termNumber = termNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getElectionsWon() {
		return electionsWon;
	}

	public void setElectionsWon(int electionsWon) {
		this.electionsWon = electionsWon;
	}

	public String getWhyLeftOffice() {
		return whyLeftOffice;
	}

	public void setWhyLeftOffice(String reasonLeftOffice) {
		this.whyLeftOffice = reasonLeftOffice;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	@Override
	public String toString() {
		return termNumber + ": " + firstName + " " + middleName + " " + lastName + ", " + termStartYear + "-"
				+ termEndYear + "; " + party + " " + electionsWon + " " + whyLeftOffice;

	}

	@Override
	public int compareTo(President other) {
		if (this.termNumber > other.termNumber) {
			return 1;
		} else if (this.termNumber < other.termNumber) {
			return -1;
		}
		return 0;
	}

}