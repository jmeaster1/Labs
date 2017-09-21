package com.skilldistilllery.NBALottery;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BallFactory {


	public static List<Ball> generateBalls(Map<String, Integer> numBalls) {		//generates all balls and assigns corresponding teams
		List<Ball> hopperList = new ArrayList<>();
		for (String teamName : numBalls.keySet()) {
			int numOfBalls = numBalls.get(teamName); 
			for (int i = 0; i < numOfBalls; i++) {		//Kings (1 seed) --- 250 balls (iterations)
				hopperList.add(new Ball(teamName));
			}
			
		}
		return hopperList;
	}

}
