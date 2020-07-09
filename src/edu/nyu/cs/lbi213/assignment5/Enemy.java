package edu.nyu.cs.lbi213.assignment5;

import processing.core.PApplet;

/**
 * This is the Enemy class of the Lego class that is invoked as your adversary in the quest to to defeat him by shooting him
 * It adds its own variables and methods
 * 
 * @author Laurence Bugasu Ininda
 *
 */
public class Enemy extends Lego{

	LegoWars parent;
	private static int[] enemyPosition = {800,350};
	
	
	/**
	 * This is the constructor to the Enemy class that holds a reference to the parent class
	 * @param parent
	 */
	public Enemy(PApplet parent) {
		super(parent, "src/enemy.png");
		//this.setLives(3);
		this.setLegoPath("src/enemy.png");
		this.setPosition(enemyPosition);
	}
	
	/*
	 * Getters and setters for this class
	 */
	public static  int[] getEnemyPosition() {
		return enemyPosition;
	}
	public static void setEnemyPosition(int[] enemyPosition) {
		Enemy.enemyPosition = enemyPosition;
	}

	
}
