package edu.nyu.cs.lbi213.assignment5;

import processing.core.PApplet;
import java.util.ArrayList;
/**
 * This is the Class that will run the program Lego WARS, a game where you have to avoid being shot dead by the evil Batman Lego
 * the LegoWars class extends the PApplet  class file
 * 
 * Click up to jump and right to shoot when you have passed 1500 points
 * Note: You are always a little vulnerable whenever you upgrade to a stronger Lego character
 * 
 * For extra credit, I have includes classes that usefully inherit from other classes: i.e, 
 * the Spark class inherits from the bullet class
 * The EnemyHeart inherits from the Heart class
 * The Adult class inherits from the Lego Class
 * '
 * @author Laurence Bugasu Ininda
 * @version 3.3
 *
 */
public class LegoWars extends PApplet{

	/*
	 * Constants for the game
	 * w= width of the window
	 */
	public final int w = 1000;
	/* h= height of the window */
	public final int h = 500;

	/*COLORS as final variables*/
	public final int BG_GAME = color(149,212,209);
	public final int BG_END_GAME = color(241,113,145);
	public final int BLACK = color(0,0,0);
	public final int WHITE = color(255,255,255);
	
	/*
	 * A variable to hold the skillpoints
	 */
	public static int skillPoints = 0;
			
	/*an array list that will hold any bullets  that are currently on screen.
	 * 
	 */
	public static ArrayList<Bullet> bullets = new  ArrayList<Bullet>();
	
	/*
	 * An arrayList that will hold the number of balls of fire that you throw. This power is only available in Level 3, with the fully upgraded Lego
	 */
	public static ArrayList<Spark> sparks = new  ArrayList<Spark>();
	
	/*
	 * An array list that will hold the "lifes" that you have
	 */ 
	public static ArrayList<Heart> hearts = new  ArrayList<Heart>();
	
	/*
	 * An array List that will hold the number of lives that the BatLego has
	 */
	public ArrayList<EnemyHeart> enearts = new  ArrayList<EnemyHeart>();
	
	/*
	 * Declare the Lego objects that will be used in the game
	 */
	private static Enemy enemy;
	private GameOver gameover;
	private GameOver youWon;
	private GameOver aPicOfMe;//Picture of me
	public static Lego currentLego;
	/*
	 * This will determine how many lives you have
	 */
	private static int lives = 3;
	/*
	 * This will determine how many lives your enemy has
	 */
	private static int enlives = 3;

	/**
	 * This is the main method that invokes the main method in the PApplet class
	 * @param args
	 */
	public static void main (String[]args) {
		
		PApplet.main("edu.nyu.cs.lbi213.assignment5.LegoWars");
		}
	
	/**
	 * Called once to set up window
	 */
	public void settings() {
		this.size(this.w, this.h);
	}
	
	/**
	 * Called once on load. Used to create the  window and "global" settings.
	 */
	public void setup() {
		this.background(BLACK);
		
		//Create the Objects	
		currentLego = new Lego(this);//uses the "currentLego" variable name to point to a new Lego object
		enemy = new Enemy(this);//Create the new enemy object
		gameover = new GameOver(this);//Create a new Gameover object screen that will show once the game is over
		youWon = new GameOver(this, "src/you_won.gif");//Create a new YouWon object that shows whenever you defeat the enemy
		aPicOfMe = new GameOver(this, "src/aPhotoOfMe.jpg", 800, 300);
		//Generate the number of hearts for the current Lego on the screen, starting with 1 life, and each updrade adds one more life to your gameplay
		for (int i = 0; i<lives;i++) {
			Heart heart = new Heart(this);
			hearts.add(heart);//Add the life object to the hearts arraylist
		}
		//Generate the number of hearts for the Batlego, this will  be three lives
		for (int i = 0; i<enlives;i++) {
			EnemyHeart eneart = new EnemyHeart(this);
			this.enearts.add(eneart);
		}
	}
	/**
	 * The draw function is called 30 times per second to animate all the action on the screen
	 * In this case, the draw() function draws your character, your enemy, your lives, your enemies lives and any bullets/ sparklets that you throw to each other
	 *
	 */
	public void draw(){
		
		//Deermine if user has won/ lost, or is still playing
		if (lives<=0) {
			this.background(BG_END_GAME);
			//Print SkillPoints at the end of the game
			this.text(Double.toString(skillPoints), 50, 50);
			gameover.draw();
			aPicOfMe.draw();
			this.textSize(25);
			this.text("By:Laurence Ininda", 750, 475);		
		}
		else if(enlives<=0) {
			this.background(BG_END_GAME);
			youWon.draw();
			aPicOfMe.draw();
			this.textSize(25);
			this.text("By Laurence Ininda", 400, 450);
		}
		
		else if (lives>0 && enlives>0) {
			this.background(BG_GAME);//Color the screen
			frameRate(60);//Make the framerate of the screen draw function to be 24 fps
			
			//Check if the user hits 500 points and is viable for a new upgrade
			if (skillPoints==500) {
				currentLego = new Lego(this, "src/lego2.png");//Create a new boy object and use "currentLego" variable name to point to it
			}
			
			//Check if the user hits 1500 skillpoints and is viable for another upgrade
			if(skillPoints==1500){
				//Upgrade to a lego that has the ability to shoot
				currentLego = (Lego)new Adult(this);//Create a new Adult object and use "currentLego" variable name to point to it
			}
			
			//Loop through the number of lives you have and draw on screen
			for (int i =0;i<lives;i++) {
				Heart heart = hearts.get(i);
				heart.draw();//draw a heart
			}
			//Loop through the number of lives that the enemy has and draw on screen
			for (int i =0;i<enlives;i++) {
				EnemyHeart eneart = enearts.get(i);
				eneart.draw();//draw a heart
			}
			
			
			currentLego.move();//Moves your Lego objects
			currentLego.draw();//Draws on screen
			enemy.draw();//Draws your enemey
			
			//Generate new bullets after every 100 frames
			if (frameCount%100 ==0) {
				Bullet newBullet = new Bullet(this);
				bullets.add(newBullet);//Add bullets to the bullets array List
			}
			//Draw the bullets on the screen
			for (int i=0; i<bullets.size(); i++) {
				Bullet bullet = bullets.get(i);
				bullet.move(); //have the bullet  move itself to a new location
				bullet.draw(); //have the bullet  draw itself to the screen

			}
			
			//Invokes the shooting ability of the fully upgraded adult Lego from the KeyPressed function
			if (currentLego instanceof Adult) {
				if (((Adult)currentLego).isShoot()){
					Spark pew = new Spark(this);
					sparks.add(pew);//Add the new shot to the sparks arrayList
				}
				//Draw any firery sparks (sparklet) that you have shoot towards the enemy
				for (int i=0; i<sparks.size(); i++) {
					Spark spark = sparks.get(i);
					spark.move(); //have the sparklet  move itself to a new location
					spark.draw(); //have the sparklet  draw itself to the screen
					((Adult)currentLego).setShoot(false);
				}
			}

			//Create an array list to store the bullets that you want to take out
			ArrayList<Bullet> bulletsToRemove = new  ArrayList<Bullet>(); //will hold the bullets to remove
			
			//Loop through the bullets and see which one to remove
			for (Bullet bullet:bullets) {			
					//our Bullet class has a method that checks whether there  is a collision
					if (bullet.isCollision(bullet,  currentLego)) {
						bulletsToRemove.add(bullet);  //add this bullet to the  list that we will remove
						lives--;//You lose a life
					}
					
					//Our bullet has a method that checks whether each bullet has gone out of bounds
					if (bullet.isOutsideArea()) {
						bulletsToRemove.add(bullet);  //add this bullet to the  list that we will remove
					}
			}
			
			//Loop through the sparklets and see which one to remove
			ArrayList<Spark> sparksToRemove = new  ArrayList<Spark>(); //will hold the bullets to remove
			for (Spark spark:sparks) {			
					//our Spark class has a method that checks whether there  is a collision with the enemy
					if (spark.isCollision(spark,  enemy)) {
						sparksToRemove.add(spark);  //add this sparklet to the  list that we will remove
						enlives-=1;//Take away a life of the enemy
						
					}
					//Our bullet(sparklet) has a method that checks whether each bullet has gone out of bounds
					if (spark.isOutsideArea()) {
						sparksToRemove.add(spark);  //add this sparklet to the  list that we will remove
					}
			}

			//remove all bullets we earmarked as  removable
			for (Bullet bullet:bulletsToRemove) {
				bullet.kill(); //tell the bullet to  kill itself
			}	

			//Remove the sparklets marked for removal
			for (Spark spark:sparksToRemove) {
				spark.kill();
			}

			this.fill(29,79,209);
			this.textSize(50);
			this.text(Double.toString(skillPoints), 50, 50);
			this.textSize(25);
			this.text("your lives:", 550, 75);
			this.text("Enemy lives:", 550, 140);
		}
	}


	/**
	 * This KeyPressed method is called each time the UP or RIGHT key is pressed by the user
	 * 
	 */
	public void keyPressed() {
		if (key == CODED) {
			//Make the Lego jump
			if (keyCode == UP) {
				currentLego.jump= true;
				//Add 50 points to the user whenever the user jumps
				skillPoints +=50;
			}
			//Shoot an sparklet to the enemy
			if (keyCode == RIGHT && currentLego instanceof Adult) {
				((Adult)currentLego).shoot();
				
			}
		}
	}
	
}

