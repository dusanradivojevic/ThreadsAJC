package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.control.Controller;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import java.awt.ComponentOrientation;
import java.awt.Component;

public class ConcertGUI extends JFrame {

	private JPanel contentPane;
	public JTextArea tx;
	private final JScrollPane scrollPane = new JScrollPane();
	
	private JButton btnNewButton = new JButton("Play all");
	private JButton btnPlayFirstVoice = new JButton("First voice");
	private JButton btnPlaySecondVoice = new JButton("Second voice");
	private JButton btnThirdVoice = new JButton("Third voice");

	/**
	 * Create the frame.
	 */
	public ConcertGUI() {
		setResizable(false);
		setForeground(Color.BLACK);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConcertGUI.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaMute.png")));
		setTitle("Concert");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		JButton btnNewButton = new JButton("Play all");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		//		playAllBtn = btnNewButton;
				
				tx.setText(null);
				btnNewButton.setEnabled(false);
				
				if (btnPlayFirstVoice != null)
					btnPlayFirstVoice.setEnabled(false);
				
				if (btnPlaySecondVoice != null)
					btnPlaySecondVoice.setEnabled(false);
				
				if (btnThirdVoice != null)
					btnThirdVoice.setEnabled(false);
				
				Controller.initializeThreads();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(312, 178, 89, 35);
		contentPane.add(btnNewButton);
		
		JButton btnStop = new JButton("Stop all");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Controller.abortAll();
				Controller.t.getSinger(1).setStopAll(true);
				Controller.t.getSinger(2).setStopAll(true);
				Controller.t.getSinger(3).setStopAll(true);
				
				Controller.t.initializeSingingInThreads();
				
				btnNewButton.setEnabled(true);
				btnPlayFirstVoice.setEnabled(true);
				btnPlaySecondVoice.setEnabled(true);
				btnThirdVoice.setEnabled(true);
			}
		});
		btnStop.setFont(new Font("Arial", Font.PLAIN, 12));
		btnStop.setBounds(312, 224, 89, 36);
		contentPane.add(btnStop);
		
		
		btnPlayFirstVoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnPlayFirstVoice.setEnabled(false);
				btnNewButton.setEnabled(false);
				
				Controller.playFirst();
			}
		});
		btnPlayFirstVoice.setFont(new Font("Arial", Font.PLAIN, 12));
		btnPlayFirstVoice.setBounds(235, 40, 112, 35);
		contentPane.add(btnPlayFirstVoice);
		
		JButton btnStopFirstVoice = new JButton("First voice");
		btnStopFirstVoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.stopFirst();
			}
		});
		btnStopFirstVoice.setFont(new Font("Arial", Font.PLAIN, 12));
		btnStopFirstVoice.setBounds(369, 40, 112, 35);
		contentPane.add(btnStopFirstVoice);
		
		
		btnPlaySecondVoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnPlaySecondVoice.setEnabled(false);
				btnNewButton.setEnabled(false);
				
				Controller.playSecond();
			}
		});
		btnPlaySecondVoice.setFont(new Font("Arial", Font.PLAIN, 12));
		btnPlaySecondVoice.setBounds(235, 86, 112, 35);
		contentPane.add(btnPlaySecondVoice);
		
		JButton btnSecondVoice = new JButton("Second voice");
		btnSecondVoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.stopSecond();
			}
		});
		btnSecondVoice.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSecondVoice.setBounds(369, 86, 112, 35);
		contentPane.add(btnSecondVoice);
		
		
		btnThirdVoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnThirdVoice.setEnabled(false);
				btnNewButton.setEnabled(false);
				
				Controller.playThird();
			}
		});
		btnThirdVoice.setFont(new Font("Arial", Font.PLAIN, 12));
		btnThirdVoice.setBounds(235, 132, 112, 35);
		contentPane.add(btnThirdVoice);
		
		JButton btnThirdVoice_1 = new JButton("Third voice");
		btnThirdVoice_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.stopThird();
			}
		});
		btnThirdVoice_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnThirdVoice_1.setBounds(369, 132, 112, 35);
		contentPane.add(btnThirdVoice_1);
		
		JLabel lblPlay = new JLabel("PLAY");
		lblPlay.setFont(new Font("Arial", Font.BOLD, 15));
		lblPlay.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlay.setBounds(261, 19, 46, 14);
		contentPane.add(lblPlay);
		
		JLabel lblStop = new JLabel("STOP");
		lblStop.setFont(new Font("Arial", Font.BOLD, 15));
		lblStop.setHorizontalAlignment(SwingConstants.CENTER);
		lblStop.setBounds(396, 19, 46, 14);
		contentPane.add(lblStop);
		scrollPane.setBounds(10, 19, 215, 241);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		this.tx = textArea;
	}
}
