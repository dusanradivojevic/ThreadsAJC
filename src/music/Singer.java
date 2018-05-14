/*
 * Created on May 9, 2018
 *
 */
package music;

public class Singer extends Thread {
    
    private String singerName;
    private Voice voice;
    private Performance performance;
    private boolean sings; //if true specific singer can sing
    
    private boolean stopAll;
    private Synchronizer synch;
    
    public Singer(String singerName, Voice voice, Performance performance, boolean singS, boolean stopAll,
			Synchronizer synch) {
    	
		super();
		this.singerName = singerName;
		this.voice = voice;
		this.performance = performance;
		this.sings = singS;
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
            if (this.voice == Voice.FIRST && sings) {
                this.synch.singFirstVoice(performance.getLyrics(), performance.getDelay());
            } else if (this.voice == Voice.SECOND && sings){
                this.synch.singSecondVoice(performance.getLyrics(), performance.getDelay());
            } else if (sings){
            	this.synch.singThirdVoice(performance.getLyrics(), performance.getDelay());
            }
        }
    }
    
 //XXXXXXXXXXXXXXXXXXXXXX
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

	public boolean isSings() {
		return sings;
	}

	public void setSings(boolean sings) {
		this.sings = sings;
	}

}

