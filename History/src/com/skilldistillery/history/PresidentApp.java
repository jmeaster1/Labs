package com.skilldistillery.history;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;

public class PresidentApp implements PresidentMatcher {
	private static final String fileName = "presidents.tsv";
	private List<President> presidents = new ArrayList<>();

	public static void main(String[] args) {
		PresidentApp app = new PresidentApp();
		app.start();

	}

	public void start() {
		// List<President> p1 = getPresidentsByPartyAndTerm(presidents);
		PresidentPartyMatcher matcher = new PresidentPartyMatcher();
		
		// getPresidentsByLastName(presidents);

		//getPresidentsByLengthOfTerm(presidents);
		System.out.println(filter("John", matcher));
		
//		matcher.matches(null, "John");
//		System.out.println(matcher);

	}

	public PresidentApp() {
		this.loadPresidents(fileName);
	}

	public List<President> getPresidents() {
		return this.presidents;
	}

	public List<President> getPresidentsByPartyAndTerm(List<President> input) {
		List<President> copy = new ArrayList<>(input);
		PresidentCompare p1 = new PresidentCompare();
		Collections.sort(copy, p1);
		return copy;
	}

	public List<President> getPresidentsByReasonAndTerm(List<President> input) {
		List<President> copy2 = new ArrayList<>(input);

		class PresidentCompare implements Comparator<President> {

			@Override
			public int compare(President o1, President o2) {
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

			}
		}
		Comparator<President> p2 = new PresidentCompare();

		Collections.sort(copy2, p2);
		return copy2;
	}

	public void getPresidentsByLastName(List<President> input) {
		List<President> p1 = new ArrayList<>(input);
		Comparator<President> comp = new Comparator<President>() {

			public int compare(President o1, President o2) {
				if (o1.getLastName().compareTo(o2.getLastName()) > 0)
					return 1;
				else if (o1.getLastName().compareTo(o2.getLastName()) < 0)
					return -1;
				else {
					return 0;
				}
			}
		};
		Collections.sort(p1, comp);
		printPresidents(p1);
	}

	
	
	public void getPresidentsByLengthOfTerm(List<President> input) {
		List<President> p1 = new ArrayList<>(input);
		Comparator<President> comp = new Comparator<President>() {
			public int compare(President o1, President o2) {

				if (o1.getTermLength().getYears() > o2.getTermLength().getYears())
					return 1;
				else if (o1.getTermLength().getYears() < o2.getTermLength().getYears())
					return -1;
				else {
					if (o1.getTermLength().getMonths() > o2.getTermLength().getMonths())
						return 1;
					else if (o1.getTermLength().getMonths() < o2.getTermLength().getMonths())
						return -1;
					else {
						if (o1.getTermLength().getDays() > o2.getTermLength().getDays())
							return 1;
						else if (o1.getTermLength().getDays() < o2.getTermLength().getDays())
							return -1;
						else {
							return 0;
						}
					}
				}
			}

		};
		Collections.sort(p1, comp);
		printPresidents(p1);
	}
	
	
	
	public void getPresidentsTermStart19thCentury(List<President> input) {
		List<President> p1 = new ArrayList<>(input);
		Comparator<President> comp = new Comparator<President>() {
			public int compare(President o1, President o2) {
				if (o1.getTermStartYear().compareTo(o2.getTermStartYear()) > 0)
					return 1;
				else if (o1.getTermStartYear().compareTo(o2.getTermStartYear()) < 0)
					return -1;
				else {
					return 0;
				}
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

	public List<President> filter(String string, PresidentMatcher matcher) {

		List<President> filtered = new ArrayList<>();
		for (President p : presidents) {
			if (matcher.matches(p, string)) {
				filtered.add(p);
			}
		}
		return filtered;
	}

	private void loadPresidents(String fileName) {
		// File format (tab-separated):
		// # First Middle Last Inaugurated Left office Elections won Reason left office
		// Party
		// 1 George Washington July 1, 1789 March 4, 1797 2 Did not seek re-election
		// Independent
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

				// President pres = new President(term, fName, mName, lName, won, whyLeft,
				// party);
				President pres = new President(term, fName, mName, lName, won, whyLeft, party, termStart, termEnd);
				presidents.add(pres);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(1);
		}
	}

	class PresidentCompare implements Comparator<President> {

		@Override
		public int compare(President o1, President o2) {
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

		}
	}

	@Override
	public boolean matches(President pres, String string) {
		// TODO Auto-generated method stub
		return false;
	}
	
	class PresidentPartyMatcher implements PresidentMatcher {
		@Override
		public boolean matches(President pres, String string) {
			return pres.getFirstName().equalsIgnoreCase(string);
		}
	}

}