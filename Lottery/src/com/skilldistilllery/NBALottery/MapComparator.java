package com.skilldistilllery.NBALottery;

import java.util.Comparator;
import java.util.Map;

public class MapComparator implements Comparator<String> {

		Map<String, Integer> teamWins;
	public MapComparator(Map<String, Integer> teamWins) {
			super();
			this.teamWins = teamWins;
		}
	@Override
	public int compare(String o1, String o2) {
		return teamWins.get(o2).compareTo(teamWins.get(o1));

	}
}
