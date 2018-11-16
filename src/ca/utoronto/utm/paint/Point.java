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

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class Point {
	int x, y;
	private double thickness;
	private Color colour;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	Point(int x, int y, Color colour){
		this.x = x;
		this.y = y;
		this.colour = colour;
	}
	
	Point(int x, int y, double thickness){
		this.x = x;
		this.y = y;
		this.thickness = thickness;
	}
	
	Point(int x, int y, double thickness, Color colour){
		this.x = x;
		this.y = y;
		this.thickness = thickness;
		this.colour = colour;
	}
	
	Point(int x, int y, double thickness, Color colour, Canvas canvas){
		this.x = x;
		this.y = y;
		this.thickness = thickness;
		this.colour = colour;
	}
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setColour(Color Colour) {
		this.colour = colour;
	}
	
	public Color getColour() {
		return colour;
	}
	public void setThickness(double thickness) {
		this.thickness = thickness;
	}
	
	public double getThickness() {
		return thickness;
	

	}
}

