package edu.nyu.cs.lbi213.assignment5;

import processing.core.*;
/**
 * This class is called as a subclass of the Heart parent class that modifies the position of being drawn and 
 * is the number of hearts that the enemy has
 * 
 * It includes its own methods and attributes and modifiesthe draw method of the Heart class
 * @author Laurence Bugasu Ininda
 *
 */
public class EnemyHeart extends Heart {

	LegoWars parent;
	private static int enemyHearts = 3;
	private final static String ENEART_PATH ="src/heart2.png";
	private static  PImage img;// Will hold the image for the user
	private static int[] enemyHpos = {700, 100};
	private int[] position = {700, 100};
	
	/**
	 * This is the constructor to the Enemy heart class that maintains a link to the parent class that handles all the processing
	 * @param parent
	 */
	public EnemyHeart(PApplet parent) {
		super (parent);
		this.parent = (LegoWars) parent;

		img = parent.loadImage(EnemyHeart.ENEART_PATH);
		this.position[0]= enemyHpos[0];
		enemyHpos[0] = enemyHpos[0]+this.getWidth();
		
	}

	public void draw() {
		parent.image(img, position[0], position[1]);
	}
	/**
	 * To get the number of enemy hearts
	 * @return
	 */
	public static int getEnemyHearts() {
		return enemyHearts;
	}
	/**
	 * To set the number of enemy hearts
	 * @param enemyHearts
	 */
	public static void setEnemyHearts(int enemyHearts) {
		EnemyHeart.enemyHearts = enemyHearts;
	}
}
