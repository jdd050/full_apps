package com.jdd050.tabletApp;

/*
 * NOTE: org.json.simple and org.json.simple.parser are throwing errors
 * consider switching to gson
 * https://stackoverflow.com/questions/55375664/trying-to-convert-jsonarray-to-jsonobject
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

import javax.swing.*;
import javax.swing.filechooser.*;

import com.google.gson.Gson;
import com.google.gson.JsonParser;



public class Main implements ActionListener
{
	
	private JFrame frame;
	private JPanel panel;
	private JLabel selectedFile = new JLabel("No file selected.");

	// Main class constructor
	public Main() 
	{
		// create window
		frame = new JFrame();
		
		// create panel and define boundaries, layout in grid
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder());
		panel.setLayout(new GridLayout(2,3));
		
		// GUI Elements
		JButton chooseFileBtn = new JButton("Open");
		JButton clearFileBtn = new JButton("Clear");
		JButton readFileBtn = new JButton("Read File");
		// create action listeners for relevant elements
		chooseFileBtn.addActionListener(this);
		clearFileBtn.addActionListener(this);
		readFileBtn.addActionListener(this);
		
		// add GUI elements to the panel
		panel.add(chooseFileBtn);
		panel.add(clearFileBtn);
		panel.add(readFileBtn);
		panel.add(selectedFile);
		
		// add our panel to the frame (window) and define important properties
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("OpenTabletDriver Config App");
		frame.pack();
		frame.setMinimumSize(new Dimension(800, 600));
		frame.setVisible(true);
	}

	
	// main method
	public static void main(String[] args) 
	{
		@SuppressWarnings("unused")
		Main mainConstructor = new Main();
	}

	// actions to be performed when ActionListener is triggered (with respect to element(s))
	@Override
	public void actionPerformed(ActionEvent evt)
	{
		String command = evt.getActionCommand();
		// if user presses the open button, show the open dialog.
		if (command.equals("Open"))
		{
			// create object of JFileChooser Class
			JFileChooser file = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			// show the open dialog
			int open = file.showOpenDialog(null);
			// if the user selected a file
			if (open == JFileChooser.APPROVE_OPTION) 
			{
				selectedFile.setText(file.getSelectedFile().getAbsolutePath());;
				
			}
			else 
			{
				selectedFile.setText("File open operation cancelled");
			}
		}
		
		// If the user presses the clear button, clear the selected file
		if (command.equals("Clear"))
		{
			selectedFile.setText("No file selected.");
		}
		
		// If the user presses the Read File button, read the data from the selected JSON file
		if (command.equals("Read File"))
		{
			Path filePath = Paths.get(selectedFile.getText());
			JsonParser parser = new JsonParser();
		}
	}
}