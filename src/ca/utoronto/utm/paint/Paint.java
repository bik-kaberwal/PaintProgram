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

import javafx.application.Application;
import javafx.stage.Stage;

public class Paint extends Application {

	PaintModel model; // Model
	View view; // View + Controller

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		this.model = new PaintModel();
	
		// View + Controller
		this.view = new View(model, stage);
	}
}
