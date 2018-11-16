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

import java.util.ArrayList;
import java.util.Observable;

public class PaintModel extends Observable {
	
	private ArrayList<DrawingCommand> commandQueue = new ArrayList<DrawingCommand>();
	
	public void acceptCommand(DrawingCommand command) {
		this.commandQueue.add(command);
		this.setChanged();
		this.notifyObservers();
	}
	
	void DrawAll() {
		for (DrawingCommand command: this.commandQueue) {
			command.execute();
		}
	}
	
}
