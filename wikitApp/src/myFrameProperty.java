
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
public class myFrameProperty {

    String frameName;
    public myUtils.BasicType frameType;
    Boolean bOcupied;
    String sOcupiedDeviceName;
    String iconPath;
    javax.swing.JLabel labelEntity;
    Boolean bValid;
    javax.swing.JComponent UperComp;

    public myFrameProperty() {
    }
    
    public myFrameProperty(String frameName, myUtils.BasicType frameType, Boolean bOcupied, String sOcupiedDeviceName, String iconPath, JLabel labelEntity, Boolean bValid) {
        this.frameName = frameName;
        this.frameType = frameType;
        this.bOcupied = bOcupied;
        this.sOcupiedDeviceName = sOcupiedDeviceName;
        this.iconPath = iconPath;
        this.labelEntity = labelEntity;
        this.bValid = bValid;
        this.UperComp = null;
    }

}
