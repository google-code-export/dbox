/*
 * ItemGUI2.java
 *
 * Created on July 29, 2007, 5:43 PM
 */

package dbox2;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import nl.ikarus.nxt.priv.imageio.icoreader.obj.ICOFile;
import nl.ikarus.nxt.priv.imageio.icoreader.obj.IconEntry;

/**
 *
 * @author  Truben
 */
public class ItemGUI extends javax.swing.JDialog {
    
    private boolean edit = false;
    private DosItem dos;
    private MainWindow g;
    
    public ItemGUI(MainWindow parent) {
        
        dos = new DosItem();
        g = parent;
        setModal(true);
        initComponents();
        centerScreen();
    }
    
    public ItemGUI(DosItem di, MainWindow parent) {
        dos = di;
        initComponents();
        centerScreen();
        setModal(true);
        g = parent;
        edit = true;
        appName.setText(dos.getName());
        appExec.setText(dos.getGame());
        appPath.setText(dos.getPath());
        appSetup.setText(dos.getInstaller());
        appIcon.setText(dos.getIcon());
        appCD.setText(dos.getCdrom());
        sldCycles.setValue(dos.getCycles());
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdWizard = new javax.swing.JButton();
        cmdConfirm = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel(){
            ImageIcon backImage = new javax.swing.ImageIcon(getClass().getResource("/dbox2/img/bg.jpg"));
            Image image = backImage.getImage();
            int w = backImage.getIconWidth();

            public void paintComponent (Graphics g) {
                for(int i=0;i<50;i++)
                g.drawImage(image, w*i, 0, this);
                super.paintComponent(g);
            }
        }
        ;
        jLabel5 = new javax.swing.JLabel();
        Icon = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        appName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        appExec = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        appIcon = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        sldCycles = new javax.swing.JSlider();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        appSetup = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        appPath = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        appCD = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        cmdWizard.setText("Wizard");
        cmdWizard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdWizardActionPerformed(evt);
            }
        });

        cmdConfirm.setText("OK");
        cmdConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdConfirmActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 2, 18));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Edit Game");

        Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbox2/gameIcons/application-x-executable-32.png"))); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel5)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 334, Short.MAX_VALUE)
                .add(Icon)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Icon)
                    .add(jLabel5))
                .addContainerGap())
        );

        jPanel2.setOpaque(false);

        jLabel1.setText("Name");

        appName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Executable");

        jButton1.setText("Browse");
        jButton1.setToolTipText("Browse...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Icon");

        appIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appIconActionPerformed(evt);
            }
        });
        appIcon.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                appIconPropertyChange(evt);
            }
        });
        appIcon.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                appIconCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        appIcon.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                appIconCaretUpdate(evt);
            }
        });

        jButton4.setText("Browse");
        jButton4.setToolTipText("Browse...");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setText("How fast would you like the computer?");
        jLabel6.setToolTipText("How fast should the emulated\ncomputer be? If you draw the slider\nto the left, it will be slower, and to\nthe right it will be faster");

        sldCycles.setMaximum(15000);
        sldCycles.setMinimum(1);
        sldCycles.setToolTipText("3000 CPU Cycles");
        sldCycles.setValue(3000);
        sldCycles.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldCyclesStateChanged(evt);
            }
        });
        sldCycles.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                sldCyclesPropertyChange(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(appName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(appExec, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                            .add(appIcon, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jButton4)))
                    .add(jLabel3)
                    .add(jLabel8)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, sldCycles, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                    .add(jLabel6))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(appName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(appExec, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel8)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton4)
                    .add(appIcon, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel6)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(sldCycles, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(207, 207, 207))
        );

        jTabbedPane1.addTab("General", jPanel2);

        jPanel3.setOpaque(false);

        jLabel4.setText("Setup");

        jButton2.setText("Browse");
        jButton2.setToolTipText("Browse...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Path");

        jLabel7.setText("CD ROM Directory");

        jButton3.setText("Browse");
        jButton3.setToolTipText("Browse...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(appPath, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                    .add(jLabel2)
                    .add(jLabel7)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel4)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, appSetup, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, appCD, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jButton2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jButton3))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(appPath, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(appSetup, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton2))
                .add(8, 8, 8)
                .add(jLabel7)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(appCD, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton3))
                .addContainerGap(163, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Advanced", jPanel3);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(340, Short.MAX_VALUE)
                .add(cmdWizard)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cmdConfirm)
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 339, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(cmdWizard)
                    .add(cmdConfirm))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void sldCyclesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldCyclesStateChanged
    
    sldCycles.setToolTipText(sldCycles.getValue()+" CPU Cycles");
}//GEN-LAST:event_sldCyclesStateChanged

private void sldCyclesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_sldCyclesPropertyChange
    
}//GEN-LAST:event_sldCyclesPropertyChange

private void cmdConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdConfirmActionPerformed
    DosItem d = new DosItem(appName.getText(),appPath.getText(), appExec.getText(),appSetup.getText(), sldCycles.getValue(), appCD.getText());
    int s = sldCycles.getValue();
    int a = 0;
    if(s > 12000)
        a = 1;
    if(s > 13000)
        a = 2;
    if(s > 14000)
        a = 3;
    if(s >= 15000)
        a = 4;
    
    d.setFrameskip(a);
    d.setIcon(appIcon.getText());
    MainWindow.bl.addGame(d);
    this.setVisible(false);
}//GEN-LAST:event_cmdConfirmActionPerformed

private void cmdWizardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdWizardActionPerformed
    String name = JOptionPane.showInputDialog(this, "Please enter the name of the application", appName.getText());
    if(name == null)
        return;
    appName.setText(name);
    String s = helperClass.getFileAWT(this);
    if (s != null) {
        int last = 0;
        for(int i = s.length()-1; i >= 0; i--)
            if(s.charAt(i) == File.separatorChar) {
                last = i;
                break;
            }
        
        appPath.setText(s.substring(0,last));
        appExec.setText(s.substring(last+1));

        // Check if setup exists
        File f = new File(appPath.getText() + File.separatorChar +  "setup.exe");
        if(f.exists())
            appSetup.setText("setup.exe");
        f = new File(appPath.getText() + File.separatorChar + "install.exe");
        if(f.exists())
            appSetup.setText("install.exe");
        f = new File(appPath.getText() + File.separatorChar + "setup.com");
        if(f.exists())
            appSetup.setText("setup.com");

        // icons
        f = new File(appPath.getText() + File.separatorChar + appExec.getText() + ".ico");
        if(f.exists())
            appIcon.setText(appExec.getText() + ".ico");
        f = new File(appPath.getText() + File.separatorChar + appName.getText() + ".ico");
        if(f.exists())
            appIcon.setText(appName.getText() + ".ico");


    }
}//GEN-LAST:event_cmdWizardActionPerformed

private void appNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appNameActionPerformed
    
}//GEN-LAST:event_appNameActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String s = helperClass.getFileAWT(this);
    if (s != null) {
        int last = 0;
        for(int i = s.length()-1; i >= 0; i--)
            if(s.charAt(i) == File.separatorChar) {
                last = i;
                break;
            }

        System.out.println(s);
        appPath.setText(s.substring(0,last));
        appExec.setText(s.substring(last+1));
    }
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    String s = helperClass.getFileAWT(this);
    if (s != null) {
        int last = 0;
        for(int i = s.length()-1; i >= 0; i--)
            if(s.charAt(i) == File.separatorChar) {
                last = i;
                break;
            }

        System.out.println(s);
        appSetup.setText(s.substring(last+1));
    }
}//GEN-LAST:event_jButton2ActionPerformed



private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    String s = helperClass.getFileAWT(this);
    if (s != null) {
        int last = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == File.separatorChar) {
                last = i;
                break;
            }
        }

        appCD.setText(s.substring(0, last));
    }

}//GEN-LAST:event_jButton3ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    String s = helperClass.getFileAWTIcon(this);
    if (s != null) {
        appIcon.setText(s);
    }
}//GEN-LAST:event_jButton4ActionPerformed

private void appIconPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_appIconPropertyChange
    String ikon = appIcon.getText();
    File fil = new File(ikon);
    ImageIcon ii = new ImageIcon(getClass().getResource("/dbox2/gameIcons/application-x-executable-32.png"));
    if(fil.exists()) {
        if(ikon.toLowerCase().endsWith("ico")) { // If the file is a ICO file
            try {
                ImageInputStream in = ImageIO.createImageInputStream(new FileInputStream(new File(ikon)));
                ICOFile f;
                f = new ICOFile(in);
                IconEntry ie = f.getEntry(0);
                ii = new ImageIcon(ie.getBitmap().getImage());
            } catch (IOException ex) {
                System.out.println("Error reading icon " + ikon);
            }
        }
        else
            ii = new ImageIcon(ikon);
        
        Icon.setIcon(resizeIcon(ii));

    }


}//GEN-LAST:event_appIconPropertyChange

private void appIconCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_appIconCaretPositionChanged

}//GEN-LAST:event_appIconCaretPositionChanged

private void appIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appIconActionPerformed

}//GEN-LAST:event_appIconActionPerformed

private void appIconCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_appIconCaretUpdate
    appIconPropertyChange(null);
}//GEN-LAST:event_appIconCaretUpdate

     private ImageIcon resizeIcon(ImageIcon icon) {
         if(MainWindow.pref.isIconResize()) {
             int width = 32;
             int height = 32;

             BufferedImage bi = new BufferedImage(width, height,
             BufferedImage.TYPE_INT_ARGB);
             bi.getGraphics().drawImage(icon.getImage(), 0, 0, width, height, null);

             return new ImageIcon(bi);
         }
         else
             return icon;
     }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Icon;
    private javax.swing.JTextField appCD;
    private javax.swing.JTextField appExec;
    private javax.swing.JTextField appIcon;
    private javax.swing.JTextField appName;
    private javax.swing.JTextField appPath;
    private javax.swing.JTextField appSetup;
    private javax.swing.JButton cmdConfirm;
    private javax.swing.JButton cmdWizard;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JSlider sldCycles;
    // End of variables declaration//GEN-END:variables
    
}
