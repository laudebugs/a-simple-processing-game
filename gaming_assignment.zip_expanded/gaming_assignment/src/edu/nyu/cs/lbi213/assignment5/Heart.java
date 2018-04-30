package edu.nyu.cs.lbi213.assignment5;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * This is the Heart class that deals with all the lives that are in the game
 * 
 * @author Laurence Bugasu Ininda
 *
 */
public class Heart {

	/*
	 * will hold a reference to the controlling  PApplet class, which handles all the  Processing-specific stuff
	 */
	LegoWars parent;
	private final static String HEART_IM_PATH ="src/heart.png";
	/*
	 *  Will hold the image for the user
	 */
	private static  PImage img;
	/*
	 * The  initial position to draw the heart
	 */
	private int[] position = {650, 50};
	/*
	 * Variable to maintain how many hearts are drawn in order to draw them at distincet positions
	 */
	private static int heartCount = 1;

	/**
	 * The constructor of the Heart class that maintains a link to the parent class 
	 * @param parent
	 */
	public Heart(PApplet parent){
		this.parent = (LegoWars) parent;
		//System.out.println("mimi");
		img = parent.loadImage(Heart.HEART_IM_PATH);
		this.position[0]= this.position[0]+heartCount*this.getWidth();
		heartCount +=1;
		
	}
	/**
	 * Draw the heart on the screen
	 */
	public void draw() {
		parent.image(img, position[0], position[1]);
	}
	/*
	 * Getters and setters for the attributes
	 */
	
	public int[]getPosition(){
		return this.position;
	}
	public int getWidth() {
		return img.width;
	}
	public static int getHeartCount() {
		return heartCount;
	}
	public static void setHeartCount(int heartCount) {
		Heart.heartCount = heartCount;
	}
}
