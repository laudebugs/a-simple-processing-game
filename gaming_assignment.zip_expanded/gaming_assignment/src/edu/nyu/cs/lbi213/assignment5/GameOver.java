package edu.nyu.cs.lbi213.assignment5;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * This is the class that is invoked each time the game ends
 * 
 * This class also shows the use of overloading a constructor
 * 
 * @author Laurence Bugasu Ininda
 *
 */
public class GameOver {

	//will hold a reference to the controlling  PApplet class, which handles all the  Processing-specific stuff
	LegoWars parent;
	private PImage img;
	/*
	 * Where the string will be drawn
	 */
	private int[]position = {155, 0};
	/*
	 * Variable to hold the string path
	 */
	private String im_path;
	
	/**
	 * This is the main constructor of the Gameover class that maintains a link to the parent class
	 * 
	 * @param parent
	 */
	GameOver(PApplet parent){
		super();
		this.parent = (LegoWars) parent;
		this.img = parent.loadImage("src/game_over.png");
		this.im_path="src/game_over.png";
	}
	public GameOver(PApplet parent, String string, int width, int height) {
		super();
		this.parent = (LegoWars) parent;
		this.position[0]= width;
		this.position[1]= height;

		this.img = parent.loadImage(string);
		this.im_path=string;
	}
	/**
	 * This second constructor includes a string path to draw something else at the end of the game other than gameover
	 * @param parent
	 * @param string
	 */
	GameOver(PApplet parent, String string){
		
		super();
		this.im_path= string;
		this.parent = (LegoWars) parent;
		
	}
	

	//To draw the image on the screen
	public void draw() {
		this.img = parent.loadImage(this.im_path);

		//this.im_path="src/game_over.png";
		this.img = parent.loadImage(im_path);
		parent.image(this.img, this.position[0], this.position[1]);
	}
	/*
	 * Getthe position
	 */
	public int[] getPosition() {
		return position;
	}


	
}
