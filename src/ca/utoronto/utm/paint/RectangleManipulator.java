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
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class RectangleManipulator extends ShapeManipulatorStrategy {
  
  private Rectangle rect;
  private int cornerX, cornerY;
  private Canvas canvas;
  private DrawRectangleCommand rectCommand;
  
  public RectangleManipulator(){
    this.name = "Rectangle";
  }
  
  public void mousePressed(MouseEvent e, PaintModel model, double thickness, Color colour, Canvas canvas){
    cornerX = (int)e.getX();
    cornerY = (int)e.getY();
    this.canvas = canvas;
    Point corner = new Point(cornerX, cornerY);
    this.rect = new Rectangle(corner, 0, 0, colour, thickness);
    this.rectCommand = new DrawRectangleCommand(rect, this.canvas);
  }
  
  
  public void mouseReleased(MouseEvent e, PaintModel model, double thickness, Color colour, Canvas canvas){
    if (this.rect != null) {
      int width = (int)(e.getX() - this.rect.getCorner().getX());
      int height = (int)(e.getY() - this.rect.getCorner().getY());
      
      if (e.getX() < cornerX) {
        width = (int)(cornerX - e.getX());
        this.rect.getCorner().setX((int)e.getX());
      }
      
      if (e.getY() < cornerY) {
        height = (int)(cornerY - e.getY());
        this.rect.getCorner().setY((int)e.getY());
      }
      this.rectCommand.setWidth(width);
      this.rectCommand.setHeight(height);
      model.acceptCommand(rectCommand);
      
    }
    this.rect = null;
    
  }
  
  public void mouseDragged(MouseEvent e, PaintModel model, double thickness, Color Colour, Canvas canvas){
	  if (this.rect != null) {
		  int width = (int)(e.getX() - this.rect.getCorner().getX());
		  int height = (int)(e.getY() - this.rect.getCorner().getY());
		  
		  if (e.getX() < cornerX) {
			  width = (int)(cornerX - e.getX());
	          this.rect.getCorner().setX((int)e.getX());
	        }

	       if (e.getY() < cornerY) {
	          height = (int)(cornerY - e.getY());
	          this.rect.getCorner().setY((int)e.getY());
	        }

			rectCommand.setWidth(width);
			rectCommand.setHeight(height);
			model.acceptCommand(rectCommand);
    }
  }
  
  
}