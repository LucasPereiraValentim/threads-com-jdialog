package com.lucas.threads.tela;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTime extends JDialog {

	private JPanel jPanel = new JPanel(new GridBagLayout());

	private JLabel timeThread1 = new JLabel("Time Thread 01");

	private JTextField mostraTempo = new JTextField();

	private JLabel timeThread2 = new JLabel("Time Thread 02");

	private JTextField mostraTempoThread2 = new JTextField();

	private JButton jButton = new JButton("Start");

	private JButton jButton2 = new JButton("Stop");

	private Runnable thread1 = new Runnable() {
		public void run() {
			while (true) {
				mostraTempo
						.setText(new SimpleDateFormat("dd/mm/yyyy hh:mm.ss").format(Calendar.getInstance().getTime()));

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		}
	};

	private Runnable thread2 = new Runnable() {

		@Override
		public void run() {
			while (true) {
				mostraTempoThread2
						.setText(new SimpleDateFormat("dd/mm/yyy hh:mm.ss").format(Calendar.getInstance().getTime()));
				try {
					Thread.sleep(1000);

				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		}
	};

	private Thread thread1Time;

	private Thread thread2Time;

	public TelaTime() {

		setTitle("Time com Threads");
		setSize(new Dimension(300, 300));
		setLocationRelativeTo(null);
		setResizable(true);

		GridBagConstraints gridBagConstraints = new GridBagConstraints();

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);

		timeThread1.setPreferredSize(new Dimension(200, 25));
		jPanel.add(timeThread1, gridBagConstraints);

		mostraTempo.setPreferredSize(new Dimension(200, 25));

		gridBagConstraints.gridy++;
		mostraTempo.setEditable(false);
		jPanel.add(mostraTempo, gridBagConstraints);

		// ***********************************************************

		timeThread2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(timeThread2, gridBagConstraints);

		mostraTempoThread2.setPreferredSize(new Dimension(200, 25));

		gridBagConstraints.gridy++;
		mostraTempoThread2.setEditable(false);
		jPanel.add(mostraTempoThread2, gridBagConstraints);

		gridBagConstraints.gridwidth = 1;

		jButton.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy++;
		jPanel.add(jButton, gridBagConstraints);

		jButton2.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx++;
		jPanel.add(jButton2, gridBagConstraints);

		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thread1Time = new Thread(thread1);
				thread1Time.start();

				thread2Time = new Thread(thread2);

				thread2Time.start();

			}
		});

		jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thread1Time.stop();

			}
		});

		add(jPanel, BorderLayout.WEST);

		setVisible(true); // Tornar a tela vísivel ao usuário.
	}

}
