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
import javafx.event.ActionEvent;

import java.io.File;
import java.util.Observable;
import java.util.Observer;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class ColourChooserPanel extends GridPane implements Observer, EventHandler<ActionEvent> {
	
	private View view;
    private PaintModel model;
    private String[] colorlist = {"black", "white", "blue", "red", "green", "orange", "grey", "yellow", "brown", "pink", "purple", "aqua"};
    private Color[] colourlist = {Color.BLACK,Color.WHITE,Color.BLUE,Color.RED,Color.GREEN,Color.ORANGE,Color.GREY,Color.YELLOW,Color.BROWN,Color.PINK,Color.PURPLE,Color.AQUA};
    
    public ColourChooserPanel(PaintModel model, View view) {
    	this.model = model;
		this.view = view;
		this.model.addObserver(this);
		// Setting up the Vgap and Hgap
		this.setVgap(5);
		this.setHgap(5);
		this.setPadding(new Insets(10));
		
		//adding all buttons 

		int i = 0;
		for(i=0;i<colorlist.length;i++) {
			Button button = new Button();
			button.setMaxWidth(10);
			button.setMaxHeight(10);
			if (i < 6) {
				this.add(button, i, 0);
				button.setOnAction(this);
				button.setStyle("-fx-background-color:"+colorlist[i]);
				button.setId(Integer.toString(i));
			}
			else {
				this.add(button, i%6, 1);
				button.setOnAction(this);
				button.setStyle("-fx-background-color:"+colorlist[i]);
				button.setId(Integer.toString(i));
			}
		}

		
	}

	@Override
	public void handle(ActionEvent event) {
    	Button btn = (Button) event.getSource();
		int id = Integer.parseInt(btn.getId());
		System.out.println(id);
		view.getPaintPanel().setColour(colourlist[id]);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}


		}


