package com.lucas.threads.tela;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTime extends JDialog{
	
	private JPanel jPanel = new JPanel(new GridBagLayout());
	
	private JLabel timeThread1 = new JLabel("Time Thread 01");
	
	private JTextField mostraTempo = new JTextField();
	
	private JLabel timeThread2 = new JLabel("Time Thread 02");
	
	private JTextField mostraTempoThread2 = new JTextField();
	
	public TelaTime() {
		
		setTitle("Time com Threads");
		setSize(new Dimension(300, 300));
		setLocationRelativeTo(null);
		setResizable(true);
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		
		timeThread1.setPreferredSize(new Dimension(200, 25));
		jPanel.add(timeThread1, gridBagConstraints);
		
		
		
		mostraTempo.setPreferredSize(new Dimension(200, 25));
		
		gridBagConstraints.gridy++;
		
		jPanel.add(mostraTempo, gridBagConstraints);
		
		//***********************************************************
		
		timeThread2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(timeThread2, gridBagConstraints);
		
		mostraTempoThread2.setPreferredSize(new Dimension(200, 25));
		
		gridBagConstraints.gridy++;
		jPanel.add(mostraTempoThread2, gridBagConstraints);
		
		add(jPanel, BorderLayout.WEST);
		
		setVisible(true); //Tornar a tela vísivel ao usuário.	
	}
	

}
