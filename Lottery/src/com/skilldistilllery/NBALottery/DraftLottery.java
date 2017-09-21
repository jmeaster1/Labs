package com.skilldistilllery.NBALottery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DraftLottery {
	BallFactory factory = new BallFactory();
	Hopper hopper = new Hopper();
	
	public DraftLottery() {
		this.calculateBalls();
	}
	
	//create hopper
	//create BallFactory
	public Ball drawWinner() {
		hopper.shuffle();
		Ball b = hopper.drawBall();
		return b;

	}
	
	public Map<String, Integer> calculateBalls(){//calcs # of balls per team
		Map<String, Integer> numBalls = new HashMap<>();
		numBalls.put("Kings   ", 250);
		numBalls.put("Warriors", 199);
		numBalls.put("Bulls   ", 156);
		numBalls.put("Thunder ", 119);
		numBalls.put("Cavs    ", 88);
		numBalls.put("Heat    ", 63);
		numBalls.put("Magic   ", 43);
		numBalls.put("Mavs    ", 28);
		numBalls.put("Celtics ", 17);
		numBalls.put("Raptors ", 11);
		numBalls.put("Lakers  ", 8);
		numBalls.put("Clippers", 7);
		numBalls.put("Wizards ", 6);
		numBalls.put("Jazz    ", 5);
		List<Ball> balls = factory.generateBalls(numBalls);
		hopper.addBalls(balls);
		
//		Ball seed1 = new Ball("Kings   ");		//Kings assigned to (1) seed. New ball Object created.
//		Ball seed2 = new Ball("Warriors");		//Warriors assigned to (2) seed, etc.
//		Ball seed3 = new Ball("Bulls   ");
//		Ball seed4 = new Ball("Thunder ");
//		Ball seed5 = new Ball("Cavs    ");
//		Ball seed6 = new Ball("Heat    ");
//		Ball seed7 = new Ball("Magic   ");
//		Ball seed8 = new Ball("Mavs    ");
//		Ball seed9 = new Ball("Celtics ");
//		Ball seed10 = new Ball("Raptors ");
//		Ball seed11 = new Ball("Lakers  ");
//		Ball seed12 = new Ball("Clippers");
//		Ball seed13 = new Ball("Wizards ");
//		Ball seed14 = new Ball("Jazz    ");
//		

		return numBalls;
		
	

}
}
