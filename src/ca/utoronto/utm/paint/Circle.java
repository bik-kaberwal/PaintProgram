/*
**This code is provided solely for the personal and private use of
** students taking the CSC207H5 course at the University of Toronto.
**Copying for purposes other than this use is expressly prohibited. 
**All forms of distribution of this code, whether as given or with
** any changes, are expressly prohitbited.
**
** Authors: Arnold Rosenbloom, Bikram Kaberwal, Ikjot Dhillon, Thivagar Nadarajan
**
**All of the files in this directory and all subdirectories are:
**Copyright (c) 2018 Arnold Rosenbloom. 
*/
package ca.utoronto.utm.paint;

import javafx.scene.paint.Color;

public class Circle {
	
	private Point centre;
	private int radius;
	private double thickness;
	private Color colour;

	public Circle(Point centre, int radius) {
		this.centre = centre;
		this.radius = radius;
	}
	
	public Circle(Point centre, int radius, Color colour) {
		this.centre = centre;
		this.radius = radius;
		this.colour = colour;
	}
	
	public Circle(Point centre, int radius, Color colour, double thickness) {
		this.centre = centre;
		this.radius = radius;
		this.colour = colour;
		this.thickness = thickness;
	}

	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point centre) {
		this.centre = centre;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public void setThickness(double thickness) {
		this.thickness = thickness;
	}
	public double getThickness() {
		return this.thickness;
	}
	public void setColour(Color Colour) {
		this.colour = colour;
	}
	
	public Color getColour() {
		return colour;
	}

}
