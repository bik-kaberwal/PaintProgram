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

public class CircleManipulator extends ShapeManipulatorStrategy {
  
  private Circle circle;
  private DrawCircleCommand circleCommand;
  private Canvas canvas;
  
  public CircleManipulator(){
    this.name = "Circle";
  }
  
  public void mousePressed(MouseEvent e, PaintModel model, double thickness, Color colour, Canvas canvas) {
	this.canvas = canvas;
    Point centre = new Point((int) e.getX(), (int) e.getY());
    int radius = 0;
    this.circle = new Circle(centre, radius, colour, thickness);
    this.circleCommand = new DrawCircleCommand(circle, this.canvas);
  }
  
  public void mouseReleased(MouseEvent e, PaintModel model, double thickness, Color colour, Canvas canvas) {
    if (this.circle != null) {
    	int x = (int)Math.pow((this.circle.getCentre().getX() - e.getX()),2);
        int y = (int)Math.pow((this.circle.getCentre().getY() - e.getY()),2);
        int radius = (int)Math.sqrt(x+y);
        circleCommand.setRadius(radius);
        model.acceptCommand(circleCommand);
        this.circle = null;
    }
  }
  
  public void mouseDragged(MouseEvent e, PaintModel model, double thickness, Color colour, Canvas canvas) {
    int x = (int)Math.pow((this.circle.getCentre().getX() - e.getX()),2);
    int y = (int)Math.pow((this.circle.getCentre().getY() - e.getY()),2);
    int radius = (int)Math.sqrt(x+y);
    circleCommand.setRadius(radius);
    model.acceptCommand(circleCommand);
  }
  
}