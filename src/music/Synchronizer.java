/*
 * Created on May 10, 2018
 *
 */
package music;

import gui.control.Controller;

public class Synchronizer {

	private boolean firstVoiceFlag;
	private boolean secondVoiceFlag;
	private boolean thirdVoiceFlag;

	public Synchronizer(boolean firstVoiceFlag, boolean secondVoiceFlag, boolean thirdVoiceFlag) {
		super();
		this.firstVoiceFlag = firstVoiceFlag;
		this.secondVoiceFlag = secondVoiceFlag;
		this.thirdVoiceFlag = thirdVoiceFlag;
	}

	public synchronized void singFirstVoice(String lyrics, int delay) {
		while (!firstVoiceFlag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sing(lyrics, delay);
	}

	public synchronized void singSecondVoice(String lyrics, int delay) {
		while (!secondVoiceFlag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sing(lyrics, delay);
	}

	public synchronized void singThirdVoice(String lyrics, int delay) {
		while (!thirdVoiceFlag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sing(lyrics, delay);
	}

	private void sing(String lyrics, int delay) {
		Controller.singInGui(lyrics);

		try {
			wait(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (firstVoiceFlag) {
			firstVoiceFlag = !firstVoiceFlag;
			secondVoiceFlag = !secondVoiceFlag;
		} else if (secondVoiceFlag) {
			secondVoiceFlag = !secondVoiceFlag;
			thirdVoiceFlag = !thirdVoiceFlag;
		} else {
			thirdVoiceFlag = !thirdVoiceFlag;
			firstVoiceFlag = !firstVoiceFlag;
		}
		// promena flegova

		notifyAll();
	}

	public boolean isFirstVoiceFlag() {
		return firstVoiceFlag;
	}

	public void setFirstVoiceFlag(boolean firstVoiceFlag) {
		this.firstVoiceFlag = firstVoiceFlag;
	}

	public boolean isSecondVoiceFlag() {
		return secondVoiceFlag;
	}

	public void setSecondVoiceFlag(boolean secondVoiceFlag) {
		this.secondVoiceFlag = secondVoiceFlag;
	}

	public boolean isThirdVoiceFlag() {
		return thirdVoiceFlag;
	}

	public void setThirdVoiceFlag(boolean thirdVoiceFlag) {
		this.thirdVoiceFlag = thirdVoiceFlag;
	}

}
