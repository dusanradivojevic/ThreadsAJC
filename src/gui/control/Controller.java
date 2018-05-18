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

	public static synchronized void playFirst() {
		
			try {
				t.startSinger(1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public static synchronized void stopFirst() {
		
	//	t.getSinger(1).setSings(false);
		t.getSinger(1).setStopAll(true);
	}
//////////////////////////////////////////
	public static void playSecond() {
		
	//	t.getSinger(2).setSings(true);
		
		try {
			t.startSinger(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void stopSecond() {

	//	t.getSinger(2).setSings(false);
		t.getSinger(2).setStopAll(true);
	}
//////////////////////////////////////////

	public static void playThird() {

	//	t.getSinger(3).setSings(true);
		
		try {
			t.startSinger(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void stopThird() {

	//	t.getSinger(3).setSings(false);
		t.getSinger(3).setStopAll(true);
	}
//////////////////////////////////////////

	public static void singInGui(String lyrics) {
		
		cg.tx.setText(cg.tx.getText() + lyrics);
	}
}
