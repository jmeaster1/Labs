package com.skilldistilllery.NBALottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NBADraftApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		hundredPlayStats();

	}

	public static void hundredPlayStats() {

		Map<String, Integer> teamWins = new HashMap<>();

		for (int i = 0; i < 100; i++) {                   // for 100 trials...

//			Hopper hopper = new Hopper();
//			List<Ball> listOfBalls = BallFactory.generateBalls();
//			hopper.setBallList(listOfBalls);
//			hopper.shuffle();
			DraftLottery lottery = new DraftLottery();
														//   sets/shuffles balls
			Ball winningBall = lottery.drawWinner();

			if (teamWins.containsKey(winningBall.getLabel())) {
				Integer x = teamWins.get(winningBall.getLabel());
				x++;

				teamWins.put(winningBall.getLabel(), x);
			} else {
				Integer x = 1;
				teamWins.put(winningBall.getLabel(), x);
			}

		}
		MapComparator mc1 = new MapComparator(teamWins);
		Set<String> teams = teamWins.keySet();
		List<String> teamList = new ArrayList<>(teams);
		Collections.sort(teamList, mc1);
		System.out.println("\n\tNBA Draft Lottery wins by team \n\t(100 trials)");
		System.out.println("\t______________________________\n");
		for (String string : teamList) {
			System.out.println("\t" + string + " .................  " + teamWins.get(string) + "\n");
		}
		//System.out.println(teamWins);     // output before sorting with comparator
	}

}
