
import java.util.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author honli
 */
public class myProcessBarWithTimer extends javax.swing.JProgressBar{
    public Timer myTimer;
    public myTimerTask myTask;

    public myProcessBarWithTimer(int orient, int min, int max) {
        super(orient, min, max);
        myTimer = new Timer();
        myTask = new myTimerTask(this);
        myTimer.schedule(myTask, 1000, 2000); //start after 1s and trigger every 2s
        this.setName("myProcessBarWithTimer");
    }
    
    public void stopTask(){
        System.out.println("Stop TimerTask");
        myTask.cancel();
    }
    
}
