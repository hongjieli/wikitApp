
import java.awt.Point;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author honli
 */
public class myUtils{
    public int findFrameLocation(Point src, Vector vecFrame) {
        int returnIndex = -1;
        
        for(int i = 0; i < vecFrame.size(); i++)
        {
            javax.swing.JLabel tmp  = (javax.swing.JLabel) vecFrame.get(i);
            int deltaX = src.x - tmp.getLocationOnScreen().x;
            int deltaY = src.y - tmp.getLocationOnScreen().y;
            if( deltaX > 0 && deltaX < 75 && deltaY > 0 && deltaY < 75){
                System.out.println("frame" + i + " hits");
                //this.jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/white.imageset/write_LD.png")));
            }
        }
        
        return returnIndex;
    }
    
    private final int DELTA = 75;
}
