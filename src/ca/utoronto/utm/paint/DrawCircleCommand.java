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
import javafx.scene.canvas.GraphicsContext;

public class DrawCircleCommand implements DrawingCommand{
	
	private Canvas canvas;
	private Circle circle;
	private int radius;

	public DrawCircleCommand(Circle circle, Canvas canvas) {
		this.circle = circle;
		this.canvas = canvas;
		this.radius = circle.getRadius();
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public void execute() {
		GraphicsContext g = canvas.getGraphicsContext2D();
		int x = circle.getCentre().getX();
	    int y = circle.getCentre().getY();
	    g.setLineWidth(circle.getThickness());
	    g.setStroke(circle.getColour());
	    g.strokeOval(x-radius, y-radius, radius*2, radius*2);
		
	}

}
