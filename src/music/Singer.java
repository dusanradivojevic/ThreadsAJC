/*
 * Created on May 9, 2018
 *
 */
package music;

public class Singer extends Thread {
    
    private String singerName;
    private Voice voice;
    private Performance performance;
    
    private boolean stopAll;
    private Synchronizer synch;
    
    public Singer(String singerName, Voice voice, Performance performance, boolean stopAll,
			Synchronizer synch) {
    	
		super();
		this.singerName = singerName;
		this.voice = voice;
		this.performance = performance;
		this.stopAll = stopAll;
		this.synch = synch;
	}
    
	public Singer() {
        super();
    }
  //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    
    @Override
    public void run() {
        sing();
    }
    
    //synchronized
    private synchronized void sing() {
        while (!stopAll) {
            if (this.voice == Voice.FIRST) {
                this.synch.singFirstVoice(performance.getLyrics(), performance.getDelay());
            } else if (this.voice == Voice.SECOND){
                this.synch.singSecondVoice(performance.getLyrics(), performance.getDelay());
            } else {
            	this.synch.singThirdVoice(performance.getLyrics(), performance.getDelay());
            }
        }
    }
    
 //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    public String getSingerName() {
        return singerName;
    }
    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }
    public Voice getVoice() {
        return voice;
    }
    public void setVoice(Voice voice) {
        this.voice = voice;
    }
    public Performance getPerformance() {
        return performance;
    }
    public void setPerformance(Performance performance) {
        this.performance = performance;
    }
    public boolean isStopAll() {
        return stopAll;
    }
    public void setStopAll(boolean stopIt) {
        this.stopAll = stopIt;
    }

    public Synchronizer getSynch() {
        return synch;
    }

    public void setSynch(Synchronizer synch) {
        this.synch = synch;
    }

}

