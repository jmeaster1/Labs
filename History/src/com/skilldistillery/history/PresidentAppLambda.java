package com.skilldistillery.history;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

import com.skilldistillery.history.PresidentApp.PresidentCompare;

public class PresidentAppLambda implements PresidentMatcher {
	private static final String fileName = "presidents.tsv";
	private List<President> presidents = new ArrayList<>();

	public static void main(String[] args) {
		PresidentAppLambda app = new PresidentAppLambda();
		app.start();
	}

	public void start() {
		System.out.println(filter("John", (p, string)
				-> {
				return p.getFirstName().contains(string);
			}));
	}

	public void PresidentApp() {
		this.loadPresidents(fileName);
	}

	public List<President> getPresidents() {
		return this.presidents;
	}

	public List<President> getPresidentsByPartyAndTerm(List<President> input) {
		List<President> copy = new ArrayList<>(input);
			Comparator<President> comp = (o1, o2)
					-> {
			if (o1.getParty().compareTo(o2.getParty()) > 0) {
				return 1;
			} else if (o1.getParty().compareTo(o2.getParty()) < 0) {
				return -1;
			} else if (o1.getTermNumber() > o2.getTermNumber()) {
				return 1;
			} else if (o1.getTermNumber() < o2.getTermNumber()) {
				return -1;
			} else {
				return 0;
			}

		};
		Collections.sort(copy, comp);
		return copy;
	}

	public List<President> getPresidentsByReasonAndTerm(List<President> input) {
		List<President> copy2 = new ArrayList<>(input);

		Collections.sort(copy2, (o1, o2) 
				-> {
			if (o1.getParty().compareTo(o2.getParty()) > 0) {
				return 1;
			} else if (o1.getParty().compareTo(o2.getParty()) < 0) {
				return -1;
			} else if (o1.getTermNumber() > o2.getTermNumber()) {
				return 1;
			} else if (o1.getTermNumber() < o2.getTermNumber()) {
				return -1;
			} else {
				return 0;
			}

		});
		return copy2;
	}

	public void getPresidentsByLastName(List<President> input) {
		List<President> p1 = new ArrayList<>(input);
		Comparator<President> comp = (o1, o2) 
				->
		{
			if (o1.getParty().compareTo(o2.getParty()) > 0) {
				return 1;
			} else if (o1.getParty().compareTo(o2.getParty()) < 0) {
				return -1;
			} else if (o1.getTermNumber() > o2.getTermNumber()) {
				return 1;
			} else if (o1.getTermNumber() < o2.getTermNumber()) {
				return -1;
			} else {
				return 0;
			}

		};
	}

	public void getPresidentsByLengthOfTerm(List<President> input) {
		List<President> p1 = new ArrayList<>(input);
		Comparator<President> comp = (o1, o2) 
				-> {
			if (o1.getParty().compareTo(o2.getParty()) > 0) {
				return 1;
			} else if (o1.getParty().compareTo(o2.getParty()) < 0) {
				return -1;
			} else if (o1.getTermNumber() > o2.getTermNumber()) {
				return 1;
			} else if (o1.getTermNumber() < o2.getTermNumber()) {
				return -1;
			} else {
				return 0;
			}

		};
	}

	public void getPresidentsTermStart19thCentury(List<President> input) {
		List<President> p1 = new ArrayList<>(input);
		Comparator<President> comp = (President o1, President o2)
				-> {
			if (o1.getTermStartYear().compareTo(o2.getTermStartYear()) > 0)
				return 1;
			else if (o1.getTermStartYear().compareTo(o2.getTermStartYear()) < 0)
				return -1;
			else {
				return 0;
			}

		};
		Collections.sort(p1, comp);
		printPresidents(p1);
	}

	public void printPresidents(List<President> pres) {
		for (President p : pres) {
			System.out.println(p);
		}
	}

	public List<President> filter(String string, BiPredicate<President, String> bp) {

		List<President> filtered = new ArrayList<>();
		for (President p : presidents) {
			if (bp.test(p, string)) {
				filtered.add(p);
			}
		}
		return filtered;
	}

	private void loadPresidents(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String record = reader.readLine(); // Read and discard header line
			while ((record = reader.readLine()) != null) {
				String[] col = record.split("\\t");

				int term = Integer.parseInt(col[0]);
				String fName = col[1];
				String mName = col[2];
				String lName = col[3];
				String termStartYear = col[4]; // Date term began.
				String termEndYear = col[5]; // Date term ended.

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");

				LocalDate termStart = LocalDate.parse(termStartYear, formatter);
				LocalDate termEnd = null;
				if (termEndYear != null && termEndYear.length() > 0) {
					termEnd = LocalDate.parse(termEndYear, formatter);
				}

				int won = Integer.parseInt(col[6]);

				String whyLeft = col[7];
				String party = col[8];

				President pres = new President(term, fName, mName, lName, won, whyLeft, party, termStart, termEnd);
				presidents.add(pres);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(1);
		}
	}
		Comparator<President> comp = (President o1, President o2)
				-> {
			if (o1.getWhyLeftOffice().compareTo(o2.getWhyLeftOffice()) > 0) {
				return 1;
			} else if (o1.getWhyLeftOffice().compareTo(o2.getWhyLeftOffice()) < 0) {
				return -1;
			} else if (o1.getTermNumber() > o2.getTermNumber()) {
				return 1;
			} else if (o1.getTermNumber() < o2.getTermNumber()) {
				return -1;
			} else {
				return 0;
			}

		};
	

	@Override
	public boolean matches(President pres, String string) {
		return false;
	}
	
	PresidentMatcher pm2 = (pres, string)
			->
	 {
			return pres.getFirstName().equalsIgnoreCase(string);
		};
	}
	

