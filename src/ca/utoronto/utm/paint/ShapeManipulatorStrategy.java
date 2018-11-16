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

public abstract class ShapeManipulatorStrategy {
  
  protected String name;
  
  public ShapeManipulatorStrategy() {
    //this.model = model;
  }
  
  public String getName() {
    return this.name;
  }
  
  public abstract void mousePressed(MouseEvent e, PaintModel model, double thickness, Color colour, Canvas canvas);
  public abstract void mouseReleased(MouseEvent e, PaintModel model, double thickness, Color colour, Canvas canvas);
  public abstract void mouseDragged(MouseEvent e, PaintModel model, double thickness, Color colour, Canvas canvas);
   
}