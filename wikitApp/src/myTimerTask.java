
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author honli
 */
public class myTimerTask extends java.util.TimerTask {

    private myProcessBarWithTimer processBar;

    public myTimerTask(myProcessBarWithTimer processBar) {
        this.processBar = processBar;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int i;
        i = rand.nextInt(100);
        processBar.setValue(i);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
