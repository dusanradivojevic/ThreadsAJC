/*
 * Created on May 9, 2018
 *
 */
package test;

import music.Performance;
import music.Singer;
import music.Synchronizer;
import music.Voice;

public class Test {

	private Singer pattiSmith;
	private Singer bruceSpringsteen;
	private Singer chorus;
	
	private Synchronizer synch;

	public void initializeSingingInThreads() {
		String lyrics1 = "Because the night\n";
		String lyrics2 = "Belongs to lovers\n";
		String lyrics3 = "Take my hand as the sun descends\n";

		boolean stopAll = false;
		synch = new Synchronizer(true, false, false);

		Performance firstVoicePerformance = new Performance(lyrics1, 1500);
		Performance secondVoicePerformance = new Performance(lyrics2, 1500);
		Performance thirdVoicePerformance = new Performance(lyrics3, 1500);

		pattiSmith = new Singer("Patti Smith", Voice.FIRST, firstVoicePerformance, stopAll, synch);
		bruceSpringsteen = new Singer("Bruce Springsteen", Voice.SECOND, secondVoicePerformance, stopAll, synch);
		chorus = new Singer("Chorus", Voice.BACKGROUND, thirdVoicePerformance, stopAll, synch);
	}

	private void startAllSingers() {

		pattiSmith.start();
		bruceSpringsteen.start();
		chorus.start();
	}

	public void startSinger(int singer) throws Exception {

		switch (singer) {
		case 0:
			startAllSingers();
			break;
		case 1:
			pattiSmith.start();
			break;
		case 2:
			bruceSpringsteen.start();
			break;
		case 3:
			chorus.start();
			break;
		default:
			throw new Exception("Error at starting singers!");
		}

	}

	public void stopSingers() {

		pattiSmith.setStopAll(true);
		bruceSpringsteen.setStopAll(true);
		chorus.setStopAll(true);
	}

	public Singer getSinger(int i) {

		switch (i) {
		case 1:
			return pattiSmith;
		case 2:
			return bruceSpringsteen;
		default:
			return chorus;
		}
	}

	public Synchronizer getSynch() {
		return synch;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void simpleDelay() {
		long l1 = System.currentTimeMillis();
		System.out.println("Wait 2sec...");
		while (System.currentTimeMillis() < (l1 + 2000)) {
		}
		System.out.println("Done.");
	}

	public synchronized void waitDelay() {
		System.out.println("Wait 2sec...");
		try {
			wait(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done.");
	}

	public synchronized void loopDelay() {
		System.out.println("Wait 5 times 2sec...");
		for (int i = 0; i < 4; i++) {
			try {
				wait(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i + 1);
		}
		System.out.println("Done.");
	}

	public synchronized void threadWaitDelay() {
		WaitThread w1 = new WaitThread("t1");
		WaitThread w2 = new WaitThread("t2");
		System.out.println("Two threads...");
		w1.start();
		try {
			wait(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w2.start();
	}

}
