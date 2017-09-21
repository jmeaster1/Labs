package com.skilldistilllery.NBALottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Hopper {
	
	List<Ball> ballList = new ArrayList<>();
	
	public Ball drawBall() {		// draws a ball from 1000 possible balls in hopper
		
//		int selection = (int)(Math.random() * ballList.size());
		
		return ballList.get(0);
		
	}
	public void shuffle() {		//you guessed it....shuffles
		Collections.shuffle(ballList);
		
	}
	public void addBall(Ball ball) {		//adds balls to our List of balls
		ballList.add(ball);
	}
	public void addBalls(List<Ball> balls) {		//adds balls to our List of balls
		ballList.addAll(balls);
	}
	public List<Ball> getBallList() {
		return ballList;
	}
	public void setBallList(List<Ball> ballList) {
		this.ballList = ballList;
	}
	

}
