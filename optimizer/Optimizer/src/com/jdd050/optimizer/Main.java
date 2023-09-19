package com.jdd050.optimizer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class Main implements ActionListener {

	private static JFrame frame;
	private static JPanel pane;
	private String versionDisclaimer = "This application is updated to support Genshin Impact V4.0\nPlease note that certain aspects of this application will not work if you are trying to use it for future versions.";
	private JLabel selectedDirectory = new JLabel("(no directory selected)");
	
	public Main() {
		// create application window
		frame = new JFrame();
		
		// main panel
		pane = new JPanel(null);
		
		// Version disclaimer information
		JOptionPane.showMessageDialog(null, versionDisclaimer, "Game Version Disclaimer", JOptionPane.INFORMATION_MESSAGE);
		
		// run options (artifacts, weapons, resources, etc.)
		JLabel runOptions = new JLabel("run options");
		runOptions.setBounds(0, 0, 150, 200);
		runOptions.setBorder(BorderFactory.createLineBorder(Color.red));
		
		pane.add(runOptions);
		
		// file output options (JSON)
		JLabel chooseDirLabel = new JLabel("Save Directory:");
		chooseDirLabel.setSize(90, 40);
		chooseDirLabel.setLocation(160, 30); // 10px pad from runOptions
		chooseDirLabel.setBorder(BorderFactory.createLineBorder(Color.red));
		
		JButton selectFile = new JButton("Open");
		selectFile.setSize(75, chooseDirLabel.getHeight());
		selectFile.setLocation(160 + chooseDirLabel.getWidth(), 30);
		selectFile.addActionListener(this);
		
		selectedDirectory.setSize(135, 16);
		selectedDirectory.setLocation(0,545);
		selectedDirectory.setBorder(BorderFactory.createLineBorder(Color.red));
		
		pane.add(chooseDirLabel);
		pane.add(selectFile);
		pane.add(selectedDirectory);
		
		
		// run button
		JButton runButton = new JButton("Run");
		runButton.addActionListener(this);
		pane.add(runButton);
		
		
	}
	
	public static void startApplication() {
		// add our panels to the frame (window) and define important properties
		frame.add(pane);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Genshin Impact Character Optimizer V0.1");
		frame.pack();
		frame.setSize(new Dimension(800, 600));
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		// create frame, panels, and add GUI elements
		Main main = new Main();
		
		// pack and launch frame
		startApplication();
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		
		if (command == "Run") {
			// run openCV function when run is pressed
			System.out.println("Hello World!"); // placeholder, why not
		}
		
		if (command == "Open") {
			// create object of JFileChooser Class
			JFileChooser file = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			// show the open dialog
			int open = file.showOpenDialog(null);
			// if the user selected a file
			if (open == JFileChooser.APPROVE_OPTION) 
			{
				selectedDirectory.setText(file.getSelectedFile().getAbsolutePath());
				selectedDirectory.setSize(selectedDirectory.getPreferredSize());
			}
		}
		
	}

}
