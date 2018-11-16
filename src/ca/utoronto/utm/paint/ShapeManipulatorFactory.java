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

public class ShapeManipulatorFactory {

	public ShapeManipulatorFactory(){

	  }

	public ShapeManipulatorStrategy selectShape(String shape) {
	    switch (shape) {
	      case "Circle": return selectCircle();

	      case "Rectangle": return selectRectangle();

	      case "Squiggle": return selectSquiggle();

		  case "Square": return selectRectangle();

		  case "Polyline": return selectSquiggle();

	      default: return selectCircle();
	    }
	  }

	  public CircleManipulator selectCircle() {
	    return new CircleManipulator();
	  }

	  public RectangleManipulator selectRectangle() {
	    return new RectangleManipulator();
	  }

	  public SquiggleManipulator selectSquiggle() {
	    return new SquiggleManipulator();
	  }
}
