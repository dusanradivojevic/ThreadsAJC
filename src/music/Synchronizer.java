/*
 * Created on May 10, 2018
 *
 */
package music;

public class Synchronizer {
    
    private int voiceFlag;

    public Synchronizer(int voiceFlag) {
        super();
        this.voiceFlag = voiceFlag;
    }
    
    public synchronized void singFirstVoice(String lyrics, int delay) {
        while (voiceFlag != 1) {
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
        while (voiceFlag != 2) {
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
        while (voiceFlag != 3) {  
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
        System.out.println(lyrics);
        try {
            wait(delay);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        if (voiceFlag == 3)
        	voiceFlag = 1;
        else
        	voiceFlag++;
        
        notifyAll();
    }

}

