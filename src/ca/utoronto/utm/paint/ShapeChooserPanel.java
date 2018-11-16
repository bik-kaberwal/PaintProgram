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

import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
public class ShapeChooserPanel extends GridPane implements EventHandler<ActionEvent> {

	private View view; // So we can talk to our parent or other components of the view
	private Slider slider;
	
	public ShapeChooserPanel(View view) {

		this.view = view;

	   String[] buttonLabels = { "Circle", "Rectangle", "Square", "Squiggle", "Polyline", "Eraser" };
	   File circlefile = new File ("./Icons/Circle.png");
	   File rectanglefile = new File("./Icons/Rectangle.png");
	   File squarefile = new File("./Icons/Square.png");
	   File squigglefile = new File("./Icons/Squiggle.png");
	   File polylinefile = new File("./Icons/Polyline.png");
	   File eraserfile = new File("./Icons/Eraser.png");
	   Image circle = new Image(circlefile.toURI().toString());	
	   Image rectangle = new Image(rectanglefile.toURI().toString());
	   Image square = new Image(squarefile.toURI().toString());
	   Image squiggle = new Image(squigglefile.toURI().toString());
	   Image polyline = new Image(polylinefile.toURI().toString());
	   Image eraser = new Image(eraserfile.toURI().toString());
	   Image[] icons = {circle,rectangle,square,squiggle,polyline,eraser};
		int i = 0;
		while(i < 6) {
			Button button = new Button(buttonLabels[i],new ImageView(icons[i]));
			button.setMinWidth(160);
			this.add(button, 0, i);
			i++;
			button.setOnAction(this);
		
		}
		//add label
		Label thickness = new Label("Thickness: ");
		this.add(thickness, 0, 7);
		
		//add slider
		slider = new Slider();
		slider.setMin(1);
		slider.setMax(10);
		slider.setValue(1);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setBlockIncrement(1);
		slider.setMajorTickUnit(1);
		
		this.add(slider, 0, 8);
		
		
	}
	
	public Slider getSlider() {
		return slider;
	}
	
	@Override
	public void handle(ActionEvent event) {
		String command = ((Button) event.getSource()).getText();
		this.view.getPaintPanel().setMode(command);
		System.out.println(command);
	}
}
