package com.skilldistilllery.NBALottery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PowerballApp {
	
	BallFactory bf = new BallFactory();
	Hopper hopper = new Hopper();
	Hopper hopper2 = new Hopper();

	public static void main(String[] args) {
		PowerballApp app = new PowerballApp();
		app.drawLottery();
	}

	public void drawLottery() {
		Map<String, Integer> lotteryBallsMap = new HashMap<>();

		for (int i = 1; i < 69; i++) {
			lotteryBallsMap.put(Integer.toString(i), 1);//first 5 balls have values between 1-69
		}
		List<Ball> balls = bf.generateBalls(lotteryBallsMap);//list of regular balls to choose from
		hopper.addBalls(balls);
		System.out.println("\t----------------------------");
		System.out.println("\tPowerball Simulator Results: ");
		System.out.println("\t----------------------------\n");
		
		for (int i = 0; i < 5; i++) {//displays first 5 balls
			System.out.println("\t      Ball #" + (i+1) + " ----- " + hopper.drawBall().getLabel());//displays first 5 picks
			hopper.shuffle();
			
		}
		Map<String, Integer> lotteryBallsMap2 = new HashMap<>();
		for (int i = 1; i < 26; i++) {//Powerball is only one ball that has a value between 1-26
			lotteryBallsMap2.put(Integer.toString(i), 1);
		}
		
		List<Ball> balls2 = bf.generateBalls(lotteryBallsMap2);//list of Powerball balls to choose from
		hopper2.addBalls(balls2);
		
		hopper2.shuffle();
		System.out.println("\n\t      POWERBALL --- " + hopper2.drawBall().getLabel());//displays Powerball pick

	}

}
