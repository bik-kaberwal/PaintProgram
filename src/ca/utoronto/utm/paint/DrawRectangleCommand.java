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

public class DrawRectangleCommand implements DrawingCommand{
	
	private Canvas canvas;
	private Rectangle rect;
	private int width, height;

	public DrawRectangleCommand(Rectangle rect, Canvas canvas) {
		this.rect = rect;
		this.canvas = canvas;
		this.width = rect.getWidth();
		this.height = rect.getHeight();
	}
	
	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public void execute() {
		GraphicsContext g = canvas.getGraphicsContext2D();
		int x = rect.getCorner().getX();
	    int y = rect.getCorner().getY();
	    g.setLineWidth(rect.getThickness());
	    g.setStroke(rect.getColour());
	    g.strokeRect(x, y, width, height);
	    
	}

}
