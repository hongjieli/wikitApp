
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;

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

    public JLayeredPane getDesignPane() {
        return designPane;
    }

    public void setDesignPane(JLayeredPane designPane) {
        this.designPane = designPane;
    }

    public boolean ValidateType(myFrameProperty framePropertyEntity, myDeviceProperty deviceEntity) {
        //framePropertyEntity.frameType != deviceEntity.frameType;
        if (framePropertyEntity.frameType == deviceEntity.frameType) {
            return true;
        } else if (framePropertyEntity.frameType == myTYPE.ANALOG_DIGITAL) {
            if (deviceEntity.frameType == myTYPE.ANALOG || deviceEntity.frameType == myTYPE.DIGITAL) {
                return true;
            }
        }
        return false;
    }

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
                } else if (!ValidateType(framePropertyEntity, deviceEntity)) {
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

                    String deviceName = deviceLabel.getName();
                    if (deviceName.equals("BUZZER")) {
                        AddOnOffButton(framePropertyEntity);
                    } else if (deviceName.equals("NOISE")) {
                        AddProcessBar(framePropertyEntity);
                    }

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
            if (!ValidateType(framePropertyEntity, deviceEntity) && framePropertyEntity.bOcupied == false && framePropertyEntity.bValid == true) {
                framePropertyEntity.labelEntity.setIcon(new javax.swing.ImageIcon(getClass().getResource(iconPathGrey)));
            }
        }

        return returnValue;
    }

    public void FramePopupMenu(javax.swing.JLabel frameLabel, Vector vecFrameProperty, final Vector vecDeviceProperty, java.awt.event.MouseEvent evt) {
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
                                    if (deviceEntity.deviceName.equals(framePropertyEntity.sOcupiedDeviceName)) {
                                        deviceEntity.validNum = deviceEntity.validNum + 1;
                                        deviceEntity.labelEntity.setText(deviceEntity.labelEntity.getName() + " X " + deviceEntity.validNum);
                                    }
                                }

                                framePropertyEntity.bOcupied = false;
                                framePropertyEntity.sOcupiedDeviceName = "";
                                framePropertyEntity.labelEntity.setIcon(new javax.swing.ImageIcon(getClass().getResource(iconPathWhite)));

                                if (framePropertyEntity.UperComp != null) {
                                    getDesignPane().remove(framePropertyEntity.UperComp);
                                    getDesignPane().revalidate();
                                    getDesignPane().repaint();
                                    if(framePropertyEntity.UperComp.getName().equals("myProcessBarWithTimer")){
                                        myProcessBarWithTimer compEntity = (myProcessBarWithTimer) framePropertyEntity.UperComp;
                                        compEntity.stopTask();
                                    }
                                    framePropertyEntity.UperComp = null;
                                }

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

    public void AddProcessBar(myFrameProperty framePropertyEntity) {
        myProcessBarWithTimer newProcessBar = new myProcessBarWithTimer(0, 0, 100);
        newProcessBar.setStringPainted(false);
        
        Point location = new Point(framePropertyEntity.labelEntity.getLocation());
        System.out.println(framePropertyEntity.frameName);
        System.out.println(location);
        designPane.add(newProcessBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(location.x + 10, (location.y - 28), 60, 20));
        framePropertyEntity.UperComp = newProcessBar;
        //newProcessBar.setSize(20, 20);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void AddOnOffButton(myFrameProperty framePropertyEntity) {
        final JToggleButton newJToggleButton = new javax.swing.JToggleButton("OFF", false);
        newJToggleButton.setName("JToggleButton");
        Point location = new Point(framePropertyEntity.labelEntity.getLocation());
        System.out.println(framePropertyEntity.frameName);
        System.out.println(location);
        designPane.add(newJToggleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(location.x + 10, (location.y - 28), -1, -1));
        framePropertyEntity.UperComp = newJToggleButton;

        newJToggleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newJToggleButtonMouseClicked(evt);
            }

            private void newJToggleButtonMouseClicked(MouseEvent evt) {
                if (newJToggleButton.isSelected()) {
                    newJToggleButton.setText("ON");
                } else {
                    newJToggleButton.setText("OFF");
                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        designPane.revalidate();

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

    private javax.swing.JLayeredPane designPane;

}
