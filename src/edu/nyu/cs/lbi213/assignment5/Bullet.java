package edu.nyu.cs.lbi213.assignment5;

import processing.core.PApplet;
import processing.core.PImage;


/**
 * This is the bullet class, with all its attributes and methods
 * @author Laurence Bugasu Ininda
 *
 */
public class Bullet {

	//will hold a reference to the controlling  PApplet class, which handles all the  Processing-specific stuff
	LegoWars parent;
	LegoWars legoWars;
	
	final static String BULLET_IM_PATH = "src/bullet.png";
	//private PImage img= "src/bullet.png";
	private PImage img;
	private int[]position = {850, 400};
	public int x, y;//position
	private int speedX = -7;
	private int speedY = 0;
	


	/**
	 * This is 
	 * @param parent
	 */
	Bullet(PApplet parent){
		super();
		this.parent = (LegoWars) parent;
		this.img = parent.loadImage("src/bullet.png");
	}
	
	public void move() {
		this.position[0] = this.position[0] + this.speedX;
	
	}

	public void kill() {
		LegoWars.bullets.remove(this);
	}
	//To draw the bullet on the screen
	public void draw() {
		this.img = parent.loadImage(Bullet.BULLET_IM_PATH);
		parent.image(this.img, this.position[0], this.position[1]);
	}
	
	/**
	 * This method determines if a bullet has collided with you and returns true if so
	 * @param bullet
	 * @param lego
	 * @return
	 */
	public boolean isCollision(Bullet bullet, Lego lego) {
		boolean collision = false;
	//if (this.position[1] >= lego.getPosition()[1] && this.position[0]  + 30 <= lego.getPosition()[1] +  lego.getHeight()) {
		
		if (this.position[0] >= lego.getPosition()[0] && this.position[1] >= lego.getPosition()[1] ){
			if (this.position[0]+50 <= lego.getPosition()[0]+lego.getWidth() && this.position[1]<= lego.getPosition()[1]+lego.getHeight()) {
					collision = true;
			}
		}
		return collision;
	}
	/**
	 * This method determines if a bullet has gone out of bounds of the screen or not
	 * @return
	 */
	public boolean isOutsideArea() {
		boolean isItReally= false;
		if (this.position[0]<0 || this.position[0]>1000) {
			isItReally = true;
		}
		return isItReally;
	}
	//Getters and setters for the Bullet class
	public int getSpeedX() {
		return speedX;
	}
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	public int getSpeedY() {
		return speedY;
	}
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
}
