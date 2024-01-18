package com.application.formula1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App implements ActionListener {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Formula 1");
		frame.setSize(1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JPanel panel = new JPanel();
		frame.add(panel);
		DataSaver.readFile();
		Formula1MenaxhimKampionati f1 = new Formula1MenaxhimKampionati();
		f1.menaxhoKampionat(panel);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
