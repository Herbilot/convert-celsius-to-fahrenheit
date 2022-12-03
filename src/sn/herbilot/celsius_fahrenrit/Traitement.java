package sn.herbilot.celsius_fahrenrit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Traitement implements ActionListener {
	
	/******Constants and Variables******/
	final int LENGTHTABLEAUMESURE = 2;
	double celsius = 0;
	double fahrenheit = 0;
	
	/******FrontEnd*******/
	
	JFrame frame;
	JPanel panel;
	JTextField textfield;
	JTextField celsiusTextfield;
	JTextField fahrenheitTextfield;
	JButton[] mesure = new JButton[LENGTHTABLEAUMESURE];
	JTextField [] units = new JTextField[LENGTHTABLEAUMESURE];
	JButton wayOfConversion;
	JButton convertButton;
	
	//constructor
	Traitement() {
		//Frame
		frame = new JFrame("HerbiDev Temperature Converter");
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		
		
		
		//TextField
		textfield = new JTextField();
		textfield.setBounds(50, 25, 280, 50);
		textfield.setEditable(true);
		
		//JPanel
		panel = new JPanel();
		panel.setBounds(50, 100, 280, 20);
		panel.setLayout(new GridLayout(1, 1, 0, 10));
		
		/*Text Field celsius Fahrenheit*/
		//celsius
		celsiusTextfield = new JTextField();
		celsiusTextfield.setText("Celsius");
		celsiusTextfield.setBounds(50, 120, 50, 30);
		celsiusTextfield.setEditable(false);
		
		//fahrenheit
		fahrenheitTextfield = new JTextField();
		fahrenheitTextfield.setText("Fahrenheit");
		fahrenheitTextfield.setBounds(70, 120, 50, 30);
		fahrenheitTextfield.setEditable(false);
		
		units[0] = celsiusTextfield;
		units[1] = fahrenheitTextfield;
		
		wayOfConversion = new JButton("->\n<-");
		wayOfConversion.setPreferredSize(new Dimension (50,10));
		wayOfConversion.setBackground(Color.blue);
		convertButton =new JButton("Convert");
		convertButton.setBounds(145, 220, 90, 30);
		
		
		wayOfConversion.addActionListener(this);
		convertButton.addActionListener(this);
		//add button in the array
		
		mesure[0] = wayOfConversion;
		
		panel.add(units[0]);
		panel.add(mesure[0]);
		panel.add(units[1]);
		
		frame.add(convertButton);
		frame.add(panel);
		frame.add(textfield);
		frame.setVisible(true);
		
		
	}
	
	
	
	
	
	
	/*BackEnd*/
	public void actionPerformed (ActionEvent e) {
		
		if (e.getSource () == mesure[0]) {
			String tmp = "";
			tmp = units[0].getText();
			units[0].setText(units[1].getText());
			units[1].setText(tmp);
			
		}
		
		if (e.getSource() == convertButton) {
			String unit = units[0].getText();
			switch(unit) {
				case "Celsius":
					celsius= Double.parseDouble(textfield.getText());
					fahrenheit = (celsius * 9/5) + 32;
					textfield.setText(String.valueOf(fahrenheit) + " °F");
				break;
				
				case "Fahrenheit":
					fahrenheit = Double.parseDouble(textfield.getText());
					celsius = (fahrenheit - 32) * 5/9;
					textfield.setText(String.valueOf(celsius) + "°C");
				break;
			
			}
		}
		
	}

}
