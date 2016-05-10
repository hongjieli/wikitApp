
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

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
            if (deviceLabel.getName().equals(((myDeviceProperty) vecDeviceProperty.get(i)).deviceName)) {
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
                } else if (deviceEntity.validNum == 0) {
                    JOptionPane.showMessageDialog(null,
                            "器件数量已用完！",
                            "错误",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    framePropertyEntity.bOcupied = true;
                    framePropertyEntity.sOcupiedDeviceName = deviceLabel.getName();
                    framePropertyEntity.labelEntity.setIcon(new javax.swing.ImageIcon(getClass().getResource(deviceEntity.iconFramePath)));

                    deviceEntity.validNum = deviceEntity.validNum - 1;
                    deviceEntity.labelEntity.setText(deviceEntity.labelEntity.getName() + " X " + deviceEntity.validNum);
                    //FIXME need to update backgroud logic here
                }
                break;
            }
        }

        //Update frameIcon at the end.
        for (int i = 0; i < vecFrameProperty.size(); i++) {
            myFrameProperty framePropertyEntity = (myFrameProperty) vecFrameProperty.get(i);
            if (framePropertyEntity.bOcupied == false && framePropertyEntity.bValid == true) {
                framePropertyEntity.labelEntity.setIcon(new javax.swing.ImageIcon(getClass().getResource(iconPathWhite)));
            }
        }

        return returnIndex;
    }

    public int DeviceLabelPressed(Vector vecFrameProperty, javax.swing.JLabel deviceLabel, Vector vecDeviceProperty) {
        int returnValue = -1;

        myDeviceProperty deviceEntity = new myDeviceProperty();
        for (int i = 0; i < vecDeviceProperty.size(); i++) {
            if (deviceLabel.getName().equals(((myDeviceProperty) vecDeviceProperty.get(i)).deviceName)) {
                deviceEntity = (myDeviceProperty) vecDeviceProperty.get(i);
            }
        }
        for (int i = 0; i < vecFrameProperty.size(); i++) {
            myFrameProperty framePropertyEntity = (myFrameProperty) vecFrameProperty.get(i);
            if (framePropertyEntity.frameType != deviceEntity.frameType && framePropertyEntity.bOcupied == false && framePropertyEntity.bValid == true) {
                framePropertyEntity.labelEntity.setIcon(new javax.swing.ImageIcon(getClass().getResource(iconPathGrey)));
            }
        }

        return returnValue;
    }

    public void framePopupMenu(javax.swing.JLabel frameLabel, Vector vecFrameProperty, final Vector vecDeviceProperty, java.awt.event.MouseEvent evt) {
        if (evt.getButton() == MouseEvent.BUTTON3) {
            for (int i = 0; i < vecFrameProperty.size(); i++) {
                final myFrameProperty framePropertyEntity = (myFrameProperty) vecFrameProperty.get(i);
                if (framePropertyEntity.labelEntity.equals(frameLabel) && framePropertyEntity.bOcupied) {
                    JPopupMenu popup = null;
                    if (popup == null) {
                        popup = new JPopupMenu("Popup");

                        JMenuItem item1 = new JMenuItem("Delete");
                        item1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                //System.out.println("delete...");

                                for (int i = 0; i < vecDeviceProperty.size(); i++) {
                                    myDeviceProperty deviceEntity = (myDeviceProperty) vecDeviceProperty.get(i);
                                    if(deviceEntity.deviceName.equals(framePropertyEntity.sOcupiedDeviceName)){
                                        deviceEntity.validNum = deviceEntity.validNum +1;
                                        deviceEntity.labelEntity.setText(deviceEntity.labelEntity.getName() + " X " + deviceEntity.validNum);
                                    }
                                }

                                framePropertyEntity.bOcupied = false;
                                framePropertyEntity.sOcupiedDeviceName = "";
                                framePropertyEntity.labelEntity.setIcon(new javax.swing.ImageIcon(getClass().getResource(iconPathWhite)));
                                
                                //FIXME need to update backgroud logic here
                            }
                        });
                        popup.add(item1);

//            JMenuItem item2 = new JMenuItem("Red");
//            item2.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//
//                }
//            });
//            popup.add(item2);
                    }
                    popup.show(evt.getComponent(), evt.getX(), evt.getY());

                }
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

    public final String iconPathWhite = "/resource/white.imageset/white.png";
    public final String iconPathGrey = "/resource/gray.imageset/grey.png";
    public final String iconPathLight = "/resource/LS.imageset/LS_small.jpg";
    public final String iconPathBuzzer = "/resource/buzzer.imageset/buzzer_small.jpg";
    public final String iconPathNoise = "/resource/LD.imageset/LD_small.png";
    public final String iconPathRgb = "/resource/RGB.imageset/RGB_small.jpg";
    public final String iconPathBar = "/resource/BAR.imageset/BAR_small.jpg";
    public final String iconPathServo = "/resource/servo.imageset/micro servo_small.png";
    public final String iconPathLightFrame = "/resource/white.imageset/white_LS.png";
    public final String iconPathBuzzerFrame = "/resource/white.imageset/white_buzzer.png";
    public final String iconPathNoiseFrame = "/resource/white.imageset/white_LD.png";
    public final String iconPathRgbFrame = "/resource/white.imageset/white_RGB.png";
    public final String iconPathBarFrame = "/resource/white.imageset/white_BAR.png";
    public final String iconPathServoFrame = "/resource/white.imageset/white_servo.png";
    
}
