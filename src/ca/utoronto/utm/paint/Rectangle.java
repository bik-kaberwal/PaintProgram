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

public class Rectangle {

  private Point corner;
  private int width, height;
  private double thickness;
  private Color colour;

  public Rectangle(Point corner, int width, int height) {
    this.corner = corner;
    this.width = width;
    this.height = height;
  }
  
  public Rectangle(Point corner, int width, int height, Color colour) {
	  this.corner = corner;
	  this.width = width;
	  this.height = height;
	  this.colour = colour;
  }
  
  public Rectangle(Point corner, int width, int height, Color colour, double thickness) {
	  this.corner = corner;
	  this.width = width;
	  this.height = height;
	  this.colour = colour;
	  this.thickness = thickness;
  }

  public Point getCorner() {
    return corner;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

   public void setWidth(int width) {
    this.width = width;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public void setCorner(int x, int y) {
    this.corner.setX(x);
    this.corner.setY(x);
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
