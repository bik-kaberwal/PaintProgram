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

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class DrawSquiggleCommand implements DrawingCommand{
	private Canvas canvas;
	private ArrayList<Point> squiggle;

	public DrawSquiggleCommand(ArrayList<Point> squiggle, Canvas canvas) {
		this.squiggle = squiggle;
		this.canvas = canvas;
	}
	
	@Override
	public void execute() {
		GraphicsContext g = canvas.getGraphicsContext2D();
		for (int i = 0; i < squiggle.size() - 1; i++) {
		      Point p1 = squiggle.get(i);
		      Point p2 = squiggle.get(i + 1);
		      g.setLineWidth(p1.getThickness());
		      g.setStroke(p1.getColour());
		      g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		    }
	}
}
