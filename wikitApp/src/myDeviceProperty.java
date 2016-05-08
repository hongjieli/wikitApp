
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author honli
 */
public class myDeviceProperty {
    String deviceName;
    public myUtils.BasicType frameType;
    String iconPath;
    javax.swing.JLabel labelEntity;
    int validNum;

    public myDeviceProperty(String deviceName, myUtils.BasicType frameType, String iconPath, JLabel labelEntity, int validNum) {
        this.deviceName = deviceName;
        this.frameType = frameType;
        this.iconPath = iconPath;
        this.labelEntity = labelEntity;
        this.validNum = validNum;
    }
    
    
}
