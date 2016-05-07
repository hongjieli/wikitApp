
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
    public int findFrameLocation(Point src, Vector vecFrameProperty) {
        int returnIndex = -1;
        
        for(int i = 0; i < vecFrameProperty.size(); i++)
        {
            //myFrameProperty framePropertyEntity = (myFrameProperty) vecFrameProperty.get(i);
            //System.out.println("frame is " + framePropertyEntity.frameName);
            javax.swing.JLabel jLabelEntity = ((myFrameProperty) vecFrameProperty.get(i)).labelEntity;
            int deltaX = src.x - jLabelEntity.getLocationOnScreen().x;
            int deltaY = src.y - jLabelEntity.getLocationOnScreen().y;
            if( deltaX > 0 && deltaX < 75 && deltaY > 0 && deltaY < 75){
                //System.out.println("frame" + i + " hits");
                returnIndex = i;
                break;
            }
        }
        
        return returnIndex;
    }
    public void AnalogDevicePressed(Vector frameVec, Vector frameType){
        for (int i = 0; i< frameType.size(); i++){
            if(frameType.get(i) != FRAMETYPE.ANALOG){
                javax.swing.JLabel tmp = (javax.swing.JLabel) frameVec.get(i);
                tmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/gray.imageset/grey.png")));
            }
        }
    }
    
    public void DigitalDevicePressed(Vector frameVec, Vector frameType){
        for (int i = 0; i< frameType.size(); i++){
            if(frameType.get(i) != FRAMETYPE.DIGITAL){
                javax.swing.JLabel tmp = (javax.swing.JLabel) frameVec.get(i);
                tmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/gray.imageset/grey.png")));
            }
        }
    }
    
    public void PMWDevicePressed(Vector frameVec, Vector frameType){
        for (int i = 0; i< frameType.size(); i++){
            if(frameType.get(i) != FRAMETYPE.PWM){
                javax.swing.JLabel tmp = (javax.swing.JLabel) frameVec.get(i);
                tmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/gray.imageset/grey.png")));
            }
        }
    }
    private final int DELTA = 75;
    
    public enum BasicType {
        ANALOG,
        DIGITAL,
        ANALOG_DIGITAL,
        PWM,
        INVALID;
    }
    public BasicType FRAMETYPE;
}
