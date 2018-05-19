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
	
	private String voices;
	
	public Synchronizer(boolean firstVoiceFlag, boolean secondVoiceFlag, boolean thirdVoiceFlag) {
		super();
		this.firstVoiceFlag = firstVoiceFlag;
		this.secondVoiceFlag = secondVoiceFlag;
		this.thirdVoiceFlag = thirdVoiceFlag;
		
		this.voices = "";
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

		if (voices.length() == 3) {
			
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
			
			notifyAll();
			
		} else if (voices.length() == 2) {
			
			if (voices.contains("1") && voices.contains("2")) {
				firstVoiceFlag = !firstVoiceFlag;
				secondVoiceFlag = !secondVoiceFlag;
				
				notifyAll();
				return;
			}
			
			if (voices.contains("1") && voices.contains("3")) {
				firstVoiceFlag = !firstVoiceFlag;
				thirdVoiceFlag = !thirdVoiceFlag;
				
				notifyAll();
				return;
			}
			
			if (voices.contains("2") && voices.contains("3")) {
				secondVoiceFlag = !secondVoiceFlag;
				thirdVoiceFlag = !thirdVoiceFlag;
				
				notifyAll();
				return;
			}
			
		} else if (voices.length() == 1) {
			// no need for changes
			
			notifyAll();
		}
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

	public String getVoices() {
		return voices;
	}

	public void setVoices(String voices) {
		this.voices = voices;
	}

}
