package edu.nyu.cs.lbi213.assignment5;

import processing.core.PApplet;

/**
 * This is The adult subclass of the Lego Superclass that inherits all the attributes and methods of the Lego Class but adds to itself
 * the ability to shoot to an enemy
 * 
 * @author Laurence Bugasu Ininda
 *
 */
public class Adult extends Lego{

	LegoWars parent;
	//a variable to hold whether the adult class wants to shoot or not
	private boolean shoot = false;
	
	/**
	 * The Adult class constructor that holds a link to the parent class LegoWars
	 * @param parent
	 */
	public Adult(PApplet parent) {
		super(parent, "src/lego3.png");
		this.parent = (LegoWars) parent;
		this.setLegoPath("src/lego3.png");

	}
	/**
	 * Invokes shooting to be true
	 */
	public void shoot(){
		this.shoot = true;
	}
	
	public boolean isShoot() {
		return shoot;
	}
	public void setShoot(boolean shoot) {
		this.shoot = shoot;
	}
}
