package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ConcertGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConcertGUI frame = new ConcertGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConcertGUI() {
		setResizable(false);
		setForeground(Color.BLACK);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConcertGUI.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaMute.png")));
		setTitle("Concert");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 197, 249);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Play all");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(283, 178, 89, 35);
		contentPane.add(btnNewButton);
		
		JButton btnStop = new JButton("Stop all");
		btnStop.setFont(new Font("Arial", Font.PLAIN, 12));
		btnStop.setBounds(283, 224, 89, 36);
		contentPane.add(btnStop);
		
		JButton btnPlayFirstVoice = new JButton("First voice");
		btnPlayFirstVoice.setFont(new Font("Arial", Font.PLAIN, 12));
		btnPlayFirstVoice.setBounds(217, 37, 103, 35);
		contentPane.add(btnPlayFirstVoice);
		
		JButton btnStopFirstVoice = new JButton("First voice");
		btnStopFirstVoice.setFont(new Font("Arial", Font.PLAIN, 12));
		btnStopFirstVoice.setBounds(330, 37, 104, 35);
		contentPane.add(btnStopFirstVoice);
		
		JButton btnPlaySecondVoice = new JButton("Second voice");
		btnPlaySecondVoice.setFont(new Font("Arial", Font.PLAIN, 12));
		btnPlaySecondVoice.setBounds(217, 83, 103, 35);
		contentPane.add(btnPlaySecondVoice);
		
		JButton btnSecondVoice = new JButton("Second voice");
		btnSecondVoice.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSecondVoice.setBounds(330, 83, 104, 35);
		contentPane.add(btnSecondVoice);
		
		JButton btnThirdVoice = new JButton("Third voice");
		btnThirdVoice.setFont(new Font("Arial", Font.PLAIN, 12));
		btnThirdVoice.setBounds(217, 129, 103, 35);
		contentPane.add(btnThirdVoice);
		
		JButton btnThirdVoice_1 = new JButton("Third voice");
		btnThirdVoice_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnThirdVoice_1.setBounds(330, 129, 104, 35);
		contentPane.add(btnThirdVoice_1);
		
		JLabel lblPlay = new JLabel("PLAY");
		lblPlay.setFont(new Font("Arial", Font.BOLD, 15));
		lblPlay.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlay.setBounds(243, 16, 46, 14);
		contentPane.add(lblPlay);
		
		JLabel lblStop = new JLabel("STOP");
		lblStop.setFont(new Font("Arial", Font.BOLD, 15));
		lblStop.setHorizontalAlignment(SwingConstants.CENTER);
		lblStop.setBounds(357, 16, 46, 14);
		contentPane.add(lblStop);
	}
}
