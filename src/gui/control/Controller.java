package gui.control;

import java.awt.EventQueue;

import gui.ConcertGUI;
import test.Test;

public class Controller {

	public static ConcertGUI cg;
	public static Test t = new Test();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller.cg = new ConcertGUI();
					cg.setVisible(true);

					t.initializeSingingInThreads();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void initializeThreads() {

		try {
			t.startSinger(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void abortAll() {

		t.stopSingers();
	}
//////////////////////////////////////////

	public static void playFirst() {
		
		t.getSinger(1).setSings(true);
//		t.getSinger(1).start();
	}

	public static void stopFirst() {
		
		t.getSinger(1).setSings(false);
	}
//////////////////////////////////////////
	public static void playSecond() {
		
		t.getSinger(2).setSings(true);
	}

	public static void stopSecond() {

		t.getSinger(2).setSings(false);
	}
//////////////////////////////////////////

	public static void playThird() {

		t.getSinger(3).setSings(true);
	}

	public static void stopThird() {

		t.getSinger(3).setSings(false);
	}
//////////////////////////////////////////

	public static void singInGui(String lyrics) {
		
		cg.tx.setText(cg.tx.getText() + lyrics);
	}
}
