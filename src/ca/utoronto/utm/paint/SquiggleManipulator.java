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

import java.util.ArrayList;

public class SquiggleManipulator extends ShapeManipulatorStrategy {
  
  private ArrayList<Point> squiggle = new ArrayList<Point>();
  private Canvas canvas;
  private DrawSquiggleCommand squiggleCommand;
  
  public SquiggleManipulator(){
    this.name = "Squiggle";
  }
  
  public void mousePressed(MouseEvent e, PaintModel model, double thickness, Color colour, Canvas canvas){
	  this.canvas = canvas;
	  this.squiggle.add(new Point((int) e.getX(), (int) e.getY(), thickness, colour));
	  this.squiggleCommand = new DrawSquiggleCommand(squiggle, this.canvas);
  }
  
  public void mouseReleased(MouseEvent e, PaintModel model, double thickness, Color colour, Canvas canvas){
    if (this.squiggle != null) {
      this.squiggle = new ArrayList<Point>();
      model.acceptCommand(squiggleCommand);
    }
  }
  
  public void mouseDragged(MouseEvent e, PaintModel model, double thickness, Color colour, Canvas canvas){
    this.squiggle.add(new Point((int) e.getX(), (int) e.getY(), thickness, colour));
    model.acceptCommand(squiggleCommand);
    
    
  }
  
}