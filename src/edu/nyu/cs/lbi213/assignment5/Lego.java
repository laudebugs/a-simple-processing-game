package edu.nyu.cs.lbi213.assignment5;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * The Lego Class from which all Legos on the screen are generated
 * This class exhibits overloading of the constructor "Lego"
 * 
 * @author Laurence Bugasu Ininda
 *
 */
public class Lego {

	/*
	 * will hold a reference to the controlling  PApplet class, which handles all the  Processing-specific stuff
	 */
	LegoWars parent;
	/*
	 * This path to other lego objects will be determined by the subclass
	 */
	private String legoPath;
	/*
	 *  Will hold the image for the user
	 */
	protected PImage img;
	/*
	 * Variables for the jump
	 */
	private boolean alive = true;
	/*
	 * How many pixels to jump to avoid a hit
	 */
	final private int howHigh = 200;
	/*
	 * Variables to determine the jumping of the lego
	 */
	public boolean jump = false;
	public boolean reachedMax = false;
	private int jumpHeight= 0;
	
	/*
	 * The initial position of the lego object saved as an integer array of Width* height position
	 */
	private int[]position = {100,350};
	
	/**
	 * Constructor of the Lego class that build up all the objects
	 * @param parent
	 * @param path
	 */
	public Lego(PApplet parent, String path){
		
		this.legoPath=path;
		//set up initial properties for this Lego
		this.parent = (LegoWars) parent;
		//this.legoWars = legoWars;
		this.img = parent.loadImage(this.legoPath);
	}
	/**
	 * This is the constructor that is called whenever the Lego class is called
	 * @param parent
	 */
	public Lego(PApplet parent){
		this.legoPath="src/lego1.png";
		//set up initial properties for this Lego
		this.parent = (LegoWars) parent;
		//this.legoWars = legoWars;
		this.img = parent.loadImage(this.legoPath);
	}
	

	/**
	 * Makes the Lego jump on the screen
	 */
	protected void jump() {
		this.position[1]=250;
	}
	/**
	 * This moves the Lego on the screen
	 */
	public void move() {
		
		if (this.jump && this.reachedMax == false) {
			this.position[1]= this.position[1]-5;
			this.jumpHeight +=5;
			if (this.jumpHeight == this.howHigh){
				this.reachedMax =true;
			}
		}
		else if (jump && this.reachedMax == true ) {
			this.position[1]= this.position[1]+5;
			this.jumpHeight =-5; 
			if (this.position[1]==350) {
				this.jump = false;
				this.jumpHeight = 0;
				this.reachedMax = false;
				}
			}
		
		
	}
	
	/**
	 * Draws this alien to the PApplet screen.   Each alien draws itself to the main app  screen in this way.
	 */
	public void draw() {
		//Check if the Lego is alive or dead
		//if (this.alive) {
		parent.image(this.img, this.getPosition()[0], this.getPosition()[1]);
		
	}
	/*
	 * GETTERS AND SETTERS FOR THE ATTRIBUTES
	 */
	
	public PImage getImg() {
		return this.img;
	}
	public String getLegoPath() {
		return this.legoPath;
	}
	public void setLegoPath(String legoPath) {
		this.legoPath = legoPath;
	}

	public int getWidth() {
		return this.img.width;
	}
	public int getHeight() {
		return this.img.height;
	}

	public boolean isAlive() {
		return this.alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int[] getPosition() {
		return this.position;
	}
	public void setPosition(int[] position) {
		this.position = position;
	}
}
