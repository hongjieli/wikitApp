
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
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
public class mainFrame extends javax.swing.JFrame {

    /**
     * Creates new form mainFrame
     */
    public mainFrame() {
        initComponents();
        
        utils = new myUtils();
        
        //add all blank frame into vec
        this.vecFrameProperty = new Vector();
        this.vecFrameProperty.addElement(new myFrameProperty("frame1", utils.FRAMETYPE.ANALOG, false, "/resource/white.imageset/white.png", this.frame1, true));
        this.vecFrameProperty.addElement(new myFrameProperty("frame2", utils.FRAMETYPE.ANALOG, false, "/resource/white.imageset/white.png", this.frame2, true));
        this.vecFrameProperty.addElement(new myFrameProperty("frame3", utils.FRAMETYPE.ANALOG, false, "/resource/white.imageset/white.png", this.frame3, true));
        this.vecFrameProperty.addElement(new myFrameProperty("frame4", utils.FRAMETYPE.INVALID, false, "/resource/gray.imageset/grey.png", this.frame4, false));
        this.vecFrameProperty.addElement(new myFrameProperty("frame5", utils.FRAMETYPE.ANALOG, false, "/resource/white.imageset/white.png", this.frame5, true));
        this.vecFrameProperty.addElement(new myFrameProperty("frame6", utils.FRAMETYPE.DIGITAL, false, "/resource/white.imageset/white.png", this.frame6, true));
        this.vecFrameProperty.addElement(new myFrameProperty("frame7", utils.FRAMETYPE.DIGITAL, false, "/resource/white.imageset/white.png", this.frame7, true));
        this.vecFrameProperty.addElement(new myFrameProperty("frame8", utils.FRAMETYPE.DIGITAL, false, "/resource/white.imageset/white.png", this.frame8, true));
        this.vecFrameProperty.addElement(new myFrameProperty("frame9", utils.FRAMETYPE.PWM, false, "/resource/white.imageset/white.png", this.frame9, true));
        this.vecFrameProperty.addElement(new myFrameProperty("frame10", utils.FRAMETYPE.INVALID, false, "/resource/gray.imageset/grey.png", this.frame10, false));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabelBar = new javax.swing.JLabel();
        jLabelNoise = new javax.swing.JLabel();
        jLabelMainBoard = new javax.swing.JLabel();
        frame1 = new javax.swing.JLabel();
        frame2 = new javax.swing.JLabel();
        frame4 = new javax.swing.JLabel();
        frame3 = new javax.swing.JLabel();
        frame7 = new javax.swing.JLabel();
        frame8 = new javax.swing.JLabel();
        frame9 = new javax.swing.JLabel();
        frame10 = new javax.swing.JLabel();
        frame5 = new javax.swing.JLabel();
        frame6 = new javax.swing.JLabel();
        jLabelLight = new javax.swing.JLabel();
        jLabelBuzzer = new javax.swing.JLabel();
        jLabelRGB = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 768));
        setResizable(false);

        jPanel1.setBackground(java.awt.SystemColor.controlLtHighlight);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/BAR.imageset/BAR_small.jpg"))); // NOI18N
        jLabelBar.setText("BAR");
        jLabelBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabelBarMouseDragged(evt);
            }
        });
        jLabelBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelBarMouseReleased(evt);
            }
        });
        jLayeredPane1.add(jLabelBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 310, 92, -1));

        jLabelNoise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/LD.imageset/LD_small.png"))); // NOI18N
        jLabelNoise.setText("NOISE");
        jLabelNoise.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabelNoiseMouseDragged(evt);
            }
        });
        jLabelNoise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelNoiseMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelNoiseMouseReleased(evt);
            }
        });
        jLayeredPane1.add(jLabelNoise, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 174, 92, -1));

        jLabelMainBoard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/MB.imageset/MB_small.png"))); // NOI18N
        jLayeredPane1.add(jLabelMainBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 146, -1, -1));

        frame1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/white.imageset/white.png"))); // NOI18N
        jLayeredPane1.add(frame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(483, 17, -1, -1));

        frame2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/white.imageset/white.png"))); // NOI18N
        jLayeredPane1.add(frame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 17, -1, -1));

        frame4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/gray.imageset/grey.png"))); // NOI18N
        jLayeredPane1.add(frame4, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 17, -1, -1));

        frame3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/white.imageset/white.png"))); // NOI18N
        jLayeredPane1.add(frame3, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 17, -1, -1));

        frame7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/white.imageset/white.png"))); // NOI18N
        jLayeredPane1.add(frame7, new org.netbeans.lib.awtextra.AbsoluteConstraints(486, 368, -1, -1));

        frame8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/white.imageset/white.png"))); // NOI18N
        jLayeredPane1.add(frame8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 368, -1, -1));

        frame9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/white.imageset/white.png"))); // NOI18N
        jLayeredPane1.add(frame9, new org.netbeans.lib.awtextra.AbsoluteConstraints(674, 368, -1, -1));

        frame10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/gray.imageset/grey.png"))); // NOI18N
        jLayeredPane1.add(frame10, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 368, -1, -1));

        frame5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/white.imageset/white.png"))); // NOI18N
        jLayeredPane1.add(frame5, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 132, -1, -1));

        frame6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/white.imageset/white.png"))); // NOI18N
        jLayeredPane1.add(frame6, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 266, -1, -1));

        jLabelLight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/LS.imageset/LS_small.jpg"))); // NOI18N
        jLabelLight.setText("LIGHT");
        jLabelLight.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabelLightMouseDragged(evt);
            }
        });
        jLabelLight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelLightMouseReleased(evt);
            }
        });
        jLayeredPane1.add(jLabelLight, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 38, 92, -1));

        jLabelBuzzer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/buzzer.imageset/buzzer_small.jpg"))); // NOI18N
        jLabelBuzzer.setText("BUZZER");
        jLabelBuzzer.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabelBuzzerMouseDragged(evt);
            }
        });
        jLabelBuzzer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelBuzzerMouseReleased(evt);
            }
        });
        jLayeredPane1.add(jLabelBuzzer, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 106, -1, -1));

        jLabelRGB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/RGB.imageset/RGB_small.jpg"))); // NOI18N
        jLabelRGB.setText("RGB");
        jLabelRGB.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabelRGBMouseDragged(evt);
            }
        });
        jLabelRGB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelRGBMouseReleased(evt);
            }
        });
        jLayeredPane1.add(jLabelRGB, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 242, 92, -1));

        jPanel1.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.addTab("Design", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jTabbedPane1.addTab("tab2", jPanel2);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelNoiseMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNoiseMouseDragged
        // TODO add your handling code here:
        Cursor cur = new Cursor(MOVE_CURSOR);
        this.setCursor(cur);
    }//GEN-LAST:event_jLabelNoiseMouseDragged

    private void jLabelNoiseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNoiseMouseReleased
        // TODO add your handling code here:
        Cursor cur = new Cursor(DEFAULT_CURSOR);
        this.setCursor(cur);
        
        int indexOfFrameVec = this.utils.findFrameLocation(evt.getLocationOnScreen(), vecFrameProperty);
        if (indexOfFrameVec < 0){
            System.out.println("No frame hit");
        }
        else{
            javax.swing.JLabel tmp = (javax.swing.JLabel) ((myFrameProperty) vecFrameProperty.get(indexOfFrameVec)).labelEntity;
            tmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/white.imageset/white_LD.png")));
        }
    }//GEN-LAST:event_jLabelNoiseMouseReleased

    private void jLabelLightMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLightMouseDragged
        // TODO add your handling code here:
        Cursor cur = new Cursor(MOVE_CURSOR);
        this.setCursor(cur);
    }//GEN-LAST:event_jLabelLightMouseDragged

    private void jLabelLightMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLightMouseReleased
        // TODO add your handling code here:
        Cursor cur = new Cursor(DEFAULT_CURSOR);
        this.setCursor(cur);
        
        int indexOfFrameVec = this.utils.findFrameLocation(evt.getLocationOnScreen(), vecFrameProperty);
        if (indexOfFrameVec < 0){
            System.out.println("No frame hit");
        }
        else{
            javax.swing.JLabel tmp = (javax.swing.JLabel) ((myFrameProperty) vecFrameProperty.get(indexOfFrameVec)).labelEntity;
            tmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/white.imageset/white_LS.png")));
        }
    }//GEN-LAST:event_jLabelLightMouseReleased

    private void jLabelBuzzerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBuzzerMouseDragged
        // TODO add your handling code here:
        Cursor cur = new Cursor(MOVE_CURSOR);
        this.setCursor(cur);
    }//GEN-LAST:event_jLabelBuzzerMouseDragged

    private void jLabelRGBMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRGBMouseDragged
        // TODO add your handling code here:
        Cursor cur = new Cursor(MOVE_CURSOR);
        this.setCursor(cur);
    }//GEN-LAST:event_jLabelRGBMouseDragged

    private void jLabelBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBarMouseDragged
        // TODO add your handling code here:
        Cursor cur = new Cursor(MOVE_CURSOR);
        this.setCursor(cur);
    }//GEN-LAST:event_jLabelBarMouseDragged

    private void jLabelBuzzerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBuzzerMouseReleased
        // TODO add your handling code here:
        Cursor cur = new Cursor(DEFAULT_CURSOR);
        this.setCursor(cur);
        
        int indexOfFrameVec = this.utils.findFrameLocation(evt.getLocationOnScreen(), vecFrameProperty);
        if (indexOfFrameVec < 0){
            System.out.println("No frame hit");
        }
        else{
            javax.swing.JLabel tmp = (javax.swing.JLabel) ((myFrameProperty) vecFrameProperty.get(indexOfFrameVec)).labelEntity;
            tmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/white.imageset/white_buzzer.png")));
        }
    }//GEN-LAST:event_jLabelBuzzerMouseReleased

    private void jLabelRGBMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRGBMouseReleased
        // TODO add your handling code here:
        Cursor cur = new Cursor(DEFAULT_CURSOR);
        this.setCursor(cur);
        
        int indexOfFrameVec = this.utils.findFrameLocation(evt.getLocationOnScreen(), vecFrameProperty);
        if (indexOfFrameVec < 0){
            System.out.println("No frame hit");
        }
        else{
            javax.swing.JLabel tmp = (javax.swing.JLabel) ((myFrameProperty) vecFrameProperty.get(indexOfFrameVec)).labelEntity;
            tmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/white.imageset/white_RGB.png")));
        }
    }//GEN-LAST:event_jLabelRGBMouseReleased

    private void jLabelBarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBarMouseReleased
        // TODO add your handling code here:
        Cursor cur = new Cursor(DEFAULT_CURSOR);
        this.setCursor(cur);
        
        int indexOfFrameVec = this.utils.findFrameLocation(evt.getLocationOnScreen(), vecFrameProperty);
        if (indexOfFrameVec < 0){
            System.out.println("No frame hit");
        }
        else{
            javax.swing.JLabel tmp = (javax.swing.JLabel) ((myFrameProperty) vecFrameProperty.get(indexOfFrameVec)).labelEntity;
            tmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/white.imageset/white_BAR.png")));
        }        
    }//GEN-LAST:event_jLabelBarMouseReleased

    private void jLabelNoiseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNoiseMousePressed
        // TODO add your handling code here:
        //this.utils.AnalogDevicePressed(this.vecFrameProperty, this.frameType);
    }//GEN-LAST:event_jLabelNoiseMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel frame1;
    private javax.swing.JLabel frame10;
    private javax.swing.JLabel frame2;
    private javax.swing.JLabel frame3;
    private javax.swing.JLabel frame4;
    private javax.swing.JLabel frame5;
    private javax.swing.JLabel frame6;
    private javax.swing.JLabel frame7;
    private javax.swing.JLabel frame8;
    private javax.swing.JLabel frame9;
    private javax.swing.JLabel jLabelBar;
    private javax.swing.JLabel jLabelBuzzer;
    private javax.swing.JLabel jLabelLight;
    private javax.swing.JLabel jLabelMainBoard;
    private javax.swing.JLabel jLabelNoise;
    private javax.swing.JLabel jLabelRGB;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
    
    //Hongjie: additional var.
    public Vector vecFrameProperty;
    //public Vector frameType;
    public myUtils utils;
    
    //const
    public final int iFrameNum = 10;
}
