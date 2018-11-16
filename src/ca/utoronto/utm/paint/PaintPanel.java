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

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import java.util.Observable;
import java.util.Observer;

class PaintPanel extends StackPane implements Observer, EventHandler<MouseEvent> {
	
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view

	private double thickness= 1;
	private Color colour = Color.BLACK;

	private Canvas canvas;
	
	private ShapeManipulatorStrategy mode;
	private ShapeManipulatorFactory shapeFact;

	public PaintPanel(PaintModel model, View view) {
		
		this.canvas = new Canvas(500, 450);
		this.getChildren().add(this.canvas);
		// The canvas is transparent, so the background color of the
		// containing pane serves as the background color of the canvas.
		this.setStyle("-fx-background-color: white");

		this.addEventHandler(MouseEvent.ANY, this);

		shapeFact = new ShapeManipulatorFactory();
	    this.mode = shapeFact.selectShape("Circle");

		this.model = model;
		this.model.addObserver(this);

		this.view = view;
	}

	public void repaint() {

		GraphicsContext g = this.canvas.getGraphicsContext2D();

		// Clear the canvas
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		g.setStroke(colour);

		model.DrawAll();
	   
	}
	
	@Override
	public void update(Observable o, Object arg) {

		// Not exactly how MVC works, but similar.
		this.repaint();
	}

	/**
	 * Controller aspect of this
	 */
	public void setMode(String mode) {
		ShapeManipulatorFactory shapeFact = new ShapeManipulatorFactory();
		this.mode = shapeFact.selectShape(mode);
	}
	
	public void setColour(Color colour) {
		this.colour = colour;
	}

	@Override
	public void handle(MouseEvent event) {
		thickness = this.view.getShapeChooserPanel().getSlider().getValue();
		if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
	      
			this.mode.mouseDragged(event, this.model, thickness, colour, canvas);
	      
	    } else if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
	      
	      this.mode.mousePressed(event, this.model, thickness, colour, canvas);
	      
	    } else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
	      
	      this.mode.mouseReleased(event, this.model, thickness, colour, canvas);

	    } 
	  }
}