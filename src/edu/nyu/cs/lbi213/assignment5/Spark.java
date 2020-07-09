package edu.nyu.cs.lbi213.assignment5;

import processing.core.*;

/**
 * This is the class tha holds the Sparklets that a user shoots to the enemy
 * as a subclass of the Bullet superclass, it declares its own parameters and methods as well as overriding some  parameters andmethods
 * 
 * This class overides some attributes(position) and methods(move(),  kill(), draw(), isCollision()) of the Bullet class
 * @author Laurence Bugasu Ininda
 *
 */
public class Spark extends Bullet{
	
	LegoWars parent;
	/*
	 * To hold the sparklet path
	 */
	private final static String SPARK_PATH = "src/spark.png";
	/*
	 * private PImage img= "src/bullet.png";
	 */
	private PImage img;
	/*
	 * Position to start drawing
	 */
	private int[]position = {150, 400};
	
	/**
	 * This is the constructor of the class spark that creates a spark object
	 * @param parent
	 */
	public Spark(PApplet parent) {
		super(parent);
		this.parent = (LegoWars) parent;		
		this.img = parent.loadImage("src/spark.png");
	}
	/**
	 * Method to kill a spark
	 */
	public void kill() {
		LegoWars.sparks.remove(this);
	}
	/**
	 * Method to move the object on the screen
	 */
	public void move() {
		this.position[0] = this.position[0] + 7;
	
	}
	/**
	 * Method to draw the spark on the screen
	 */
	public void draw() {
		this.img = parent.loadImage(Spark.SPARK_PATH);
		parent.image(this.img, this.position[0], this.position[1]);
	}
	
	/**
	 * Overrides the isCollision method of the Bullet and modifies it
	 */
	public boolean isCollision(Bullet bullet, Lego lego) {
		boolean collision = false;
	//if (this.position[1] >= lego.getPosition()[1] && this.position[0]  + 30 <= lego.getPosition()[1] +  lego.getHeight()) {
		
		if (this.position[0] >= lego.getPosition()[0] && this.position[1] >= lego.getPosition()[1] ){
			if (this.position[0]+50 <= Enemy.getEnemyPosition()[0]+lego.getWidth() && this.position[1]<=  Enemy.getEnemyPosition()[1]+lego.getHeight()) {
					collision = true;
			}
		}
		return collision;
	}

}
