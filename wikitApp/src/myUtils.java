
import java.awt.Point;
import java.util.Vector;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author honli
 */
public class myUtils {

    public int DragDownOperation(Point src, Vector vecFrameProperty, javax.swing.JLabel deviceLabel, Vector vecDeviceProperty) {

        int returnIndex = -1;
        //System.out.println(deviceLabel.getText());
        myDeviceProperty deviceEntity = new myDeviceProperty();
        for (int i = 0; i < vecDeviceProperty.size(); i++) {
            if (deviceLabel.getText().equals(((myDeviceProperty) vecDeviceProperty.get(i)).deviceName)) {
                deviceEntity = (myDeviceProperty) vecDeviceProperty.get(i);
                //System.out.println("label:" + deviceLabel.getText() + " is hit");
            }
        }

        for (int i = 0; i < vecFrameProperty.size(); i++) {
            myFrameProperty framePropertyEntity = (myFrameProperty) vecFrameProperty.get(i);
            javax.swing.JLabel jLabelEntity = framePropertyEntity.labelEntity;
            int deltaX = src.x - jLabelEntity.getLocationOnScreen().x;
            int deltaY = src.y - jLabelEntity.getLocationOnScreen().y;
            if (deltaX > 0 && deltaX < 75 && deltaY > 0 && deltaY < 75) {
                //System.out.println("frame" + i + " hits");
                if (framePropertyEntity.bValid == false) { //不允许占用
                    JOptionPane.showMessageDialog(null,
                            "此处不允许放置器件！",
                            "错误",
                            JOptionPane.ERROR_MESSAGE);
                } else if (framePropertyEntity.bOcupied == true) { //已经被占用
                    JOptionPane.showMessageDialog(null,
                            "此处已被其他器件占用！",
                            "错误",
                            JOptionPane.ERROR_MESSAGE);
                } else if (framePropertyEntity.frameType != deviceEntity.frameType) {
                    JOptionPane.showMessageDialog(null,
                            "器件类型不匹配！",
                            "错误",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    framePropertyEntity.bOcupied = true;
                    framePropertyEntity.labelEntity.setIcon(new javax.swing.ImageIcon(getClass().getResource(deviceEntity.iconFramePath)));

                    //FIXME need to update device num by -1
                    //FIXME need to update backgroud logic here
                }
                break;
            }
        }

        return returnIndex;
    }

    public void AnalogDevicePressed(Vector frameVec, Vector frameType) {
        for (int i = 0; i < frameType.size(); i++) {
            if (frameType.get(i) != myTYPE.ANALOG) {
                javax.swing.JLabel tmp = (javax.swing.JLabel) frameVec.get(i);
                tmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/gray.imageset/grey.png")));
            }
        }
    }

    public void DigitalDevicePressed(Vector frameVec, Vector frameType) {
        for (int i = 0; i < frameType.size(); i++) {
            if (frameType.get(i) != myTYPE.DIGITAL) {
                javax.swing.JLabel tmp = (javax.swing.JLabel) frameVec.get(i);
                tmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/gray.imageset/grey.png")));
            }
        }
    }

    public void PMWDevicePressed(Vector frameVec, Vector frameType) {
        for (int i = 0; i < frameType.size(); i++) {
            if (frameType.get(i) != myTYPE.PWM) {
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
    public BasicType myTYPE;
}
