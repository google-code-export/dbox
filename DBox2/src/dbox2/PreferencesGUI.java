/*
 * PreferencesGUI.java
 *
 * Created on July 29, 2007, 6:28 PM
 */

package dbox2;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author  Truben
 */
public class PreferencesGUI extends javax.swing.JDialog {
    
    /** Creates new form PreferencesGUI */
    public PreferencesGUI() {
        initComponents();
        txtDosBoxPath.setText(MainWindow.pref.getDosBoxPath());
        chkKeepOpen.setSelected(MainWindow.pref.isKeepOpen());
        chkFullscreen.setSelected(MainWindow.pref.isFullScreen());
        centerScreen();
    }
    
    /**
     * Putter boksen midt paa skjermen
     */
    public void centerScreen() {
    	  Dimension dim = getToolkit().getScreenSize();
    	  Rectangle abounds = getBounds();
    	  setLocation((dim.width - abounds.width) / 2,
    	      (dim.height - abounds.height) / 2);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDosBoxPath = new javax.swing.JTextField();
        cmdConfirm = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cmdBrowse = new javax.swing.JButton();
        chkKeepOpen = new javax.swing.JCheckBox();
        chkFullscreen = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Path to DosBox");

        txtDosBoxPath.setToolTipText("The full path to the DosBox executable. On MacOs X this path has to point to the executable inside the app package. If you chose browse, D-Box will do this by itself to please and serve you!");
        txtDosBoxPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDosBoxPathActionPerformed(evt);
            }
        });

        cmdConfirm.setText("OK");
        cmdConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdConfirmActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 2, 18));
        jLabel5.setText("Preferences");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel5)
                .addContainerGap(355, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .add(jLabel5)
                .addContainerGap())
        );

        cmdBrowse.setText("Browse");
        cmdBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBrowseActionPerformed(evt);
            }
        });

        chkKeepOpen.setText("Keep the DosBox window open (doesn't always work)");
        chkKeepOpen.setToolTipText("Determines if the DosBox window will be closed after the application you currently are running has halted. This option will only have effect on applications that you're opening after you have altered this preference.");
        chkKeepOpen.setMargin(new java.awt.Insets(0, 0, 0, 0));

        chkFullscreen.setText("Play games in full screen (Press Alt+Enter in game to toggle)");
        chkFullscreen.setToolTipText("If you check this, your programs will run in full screen.\nYou can toggle by using the key combination Alt + Enter");
        chkFullscreen.setMargin(new java.awt.Insets(0, 0, 0, 0));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(txtDosBoxPath, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdBrowse)
                        .addContainerGap())))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(383, Short.MAX_VALUE)
                .add(cmdConfirm)
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(chkFullscreen, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(chkKeepOpen, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .add(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtDosBoxPath, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmdBrowse))
                .add(18, 18, 18)
                .add(chkKeepOpen, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(7, 7, 7)
                .add(chkFullscreen, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(73, 73, 73)
                .add(cmdConfirm)
                .add(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cmdBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBrowseActionPerformed

    final JFileChooser fc = new JFileChooser();
    int returnVal = fc.showOpenDialog(this);
    
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fc.getSelectedFile();
        String s = file.getAbsolutePath();
        if(s.endsWith("app"))
                s+="/Contents/MacOS/DOSBox";
        txtDosBoxPath.setText(s);
    }

}//GEN-LAST:event_cmdBrowseActionPerformed

private void cmdConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdConfirmActionPerformed
    Preferences p = new Preferences();
    p.setDosBoxPath(txtDosBoxPath.getText());
    p.setKeepOpen(chkKeepOpen.isSelected());
    p.setFullScreen(chkFullscreen.isSelected());
    MainWindow.pref = p;
    this.setVisible(false);
}//GEN-LAST:event_cmdConfirmActionPerformed

private void txtDosBoxPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDosBoxPathActionPerformed
    
}//GEN-LAST:event_txtDosBoxPathActionPerformed
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkFullscreen;
    private javax.swing.JCheckBox chkKeepOpen;
    private javax.swing.JButton cmdBrowse;
    private javax.swing.JButton cmdConfirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDosBoxPath;
    // End of variables declaration//GEN-END:variables
    
}