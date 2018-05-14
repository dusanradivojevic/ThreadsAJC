/*
 * Created on May 9, 2018
 *
 */
package test;

import java.util.Scanner;

import music.Performance;
import music.Singer;
import music.Synchronizer;
import music.Voice;

public class Test {

    public static final Scanner IN = new Scanner(System.in);
    
    private Singer pattiSmith;
    private Singer bruceSpringsteen;
    private Singer chorus;
    
    private void initializeSingingInThreads() {
        String lyrics1 = "Because the night";
        String lyrics2 = "Belongs to lovers";
        String lyrics3 = "Take my hand as the sun descends";
        
        boolean sings = true; //add as param?
        boolean stopIt = false;
        Synchronizer synch = new Synchronizer(1);
        
        Performance firstVoicePerformance = new Performance(lyrics1, 2000);
        Performance secondVoicePerformance = new Performance(lyrics2, 2000);
        Performance thirdVoicePerformance = new Performance(lyrics3, 2000);
        
        pattiSmith = new Singer("Patti Smith", Voice.FIRST, firstVoicePerformance, sings, stopIt, synch);
        bruceSpringsteen = new Singer("Bruce Springsteen", Voice.SECOND, secondVoicePerformance, sings, stopIt, synch);
        chorus = new Singer("Chorus", Voice.BACKGROUND, thirdVoicePerformance, sings, stopIt, synch);
    }
    
    public void testSingInThreads() {
        
        initializeSingingInThreads();
        
        pattiSmith.start();
        bruceSpringsteen.start();
        chorus.start();
        
        IN.nextLine();
        pattiSmith.setStopAll(true);
        bruceSpringsteen.setStopAll(true);
        chorus.setStopAll(true);
        
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

