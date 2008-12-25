/*
 * MainWindow.java
 *
 * Created on July 26, 2007, 8:54 PM
 */

package dbox2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author  Truben
 */
public class MainWindow extends javax.swing.JFrame {
    
    public static BoxListe bl = new BoxListe();
    public static Preferences pref = new Preferences();

    
    /** Creates new form MainWindow */
    public MainWindow() {
        
        try {
            initComponents();
        }
        catch(Exception e) {
            pack();
        }

        bl = deSerialize("database.dat");
        pref = deSerializePref("preferences.dat");
        centerScreen();
        updateList();
    }
    
    private BoxListe deSerialize(String name) {
        BoxListe s = new BoxListe();
        try {
            FileInputStream fis = new FileInputStream(name);
            ObjectInputStream ois;
            ois = new ObjectInputStream(fis);
            try {
                s = (BoxListe)ois.readObject();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            ois.close();
        } catch (IOException ex) {
            return s;
        }
        
        return s;
    }
    
    private Preferences deSerializePref(String name) {
        Preferences s = new Preferences();
        try {
            FileInputStream fis = new FileInputStream(name);
            ObjectInputStream ois;
            ois = new ObjectInputStream(fis);
            try {
                s = (Preferences)ois.readObject();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            ois.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Hey! Welcome to D-Box. Please check your preferences before you start! Just click on the cogwheel in the main window.", "Welcome!", JOptionPane.INFORMATION_MESSAGE);
            return s;
        }
        
        return s;
    }
    
    
    public void skrivObjekt(String navn, Object o) {
		try {
			ObjectOutputStream output =
				new ObjectOutputStream(new FileOutputStream( navn ) );
			
			output.writeObject(o);
			output.flush();
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
    
    private void writeConfig(String filename, int cpucycles, boolean fullscreen, String dir, String extra, int skip){
        String ut;
        System.out.println("Skriver cfg fil til " + filename);
        // CPU
        ut = "[CPU]\n" +
             "cycles="+cpucycles+"\n\n";
        
        ut += "[RENDER]\n" +
                "frameskip=" + skip + "\n\n";
        
        // Screen
        if(fullscreen)
            ut += "[SDL]\n" +
                  "fullscreen=true\n\n";
        
        // Mounting
        ut += "[autoexec]\n" +
                "mount c \"" + dir + "\"\n";
        if(extra != null || extra.equals(""))
            ut += "mount d \"" + extra + "\" -t cdrom\n";
        
        ut+="\n";
        
        try {
            java.io.FileWriter fw = new java.io.FileWriter(filename);
            java.io.BufferedWriter bw = new java.io.BufferedWriter(fw);
            bw.write(ut);
            bw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger("global").log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void updateList() {
        gameList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = bl.getGameList();
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        skrivObjekt("database.dat", bl);
    }
    
    private void updateList(String search) {
        final String s = search;
        gameList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = bl.getGameList(s);
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        runMenu = new javax.swing.JPopupMenu();
        mnuRun2 = new javax.swing.JMenuItem();
        mnuSetup2 = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JPopupMenu();
        mnuNew2 = new javax.swing.JMenuItem();
        mnuEdit2 = new javax.swing.JMenuItem();
        mnuDelete2 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        gameList = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        mnuRun2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        mnuRun2.setText("Run");
        mnuRun2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRunActionPerformed(evt);
            }
        });
        runMenu.add(mnuRun2);

        mnuSetup2.setText("Setup");
        mnuSetup2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSetupActionPerformed(evt);
            }
        });
        runMenu.add(mnuSetup2);

        mnuNew2.setText("New Game");
        mnuNew2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNewActionPerformed(evt);
            }
        });
        editMenu.add(mnuNew2);

        mnuEdit2.setText("Edit Game");
        mnuEdit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEditActionPerformed(evt);
            }
        });
        editMenu.add(mnuEdit2);

        mnuDelete2.setText("Delete Game");
        mnuDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDeleteActionPerformed(evt);
            }
        });
        editMenu.add(mnuDelete2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("D-Box");

        gameList.setFocusCycleRoot(true);
        gameList.setNextFocusableComponent(txtSearch);
        gameList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gameListKeyPressed(evt);
            }
        });
        gameList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                gameListMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Double(evt);
            }
        });
        jScrollPane1.setViewportView(gameList);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbox2/img/title.jpg"))); // NOI18N
        jLabel3.setToolTipText("Visit D-Box' homepage");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        txtSearch.setToolTipText("Search the gamelist");
        txtSearch.setNextFocusableComponent(gameList);
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel1.setText("Search:");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbox2/img/utilities-terminal.png"))); // NOI18N
        jLabel2.setToolTipText("Game information");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, editMenu, org.jdesktop.beansbinding.ObjectProperty.create(), jLabel2, org.jdesktop.beansbinding.BeanProperty.create("componentPopupMenu"));
        bindingGroup.addBinding(binding);

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel2MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbox2/img/media-playback-start.png"))); // NOI18N
        jLabel4.setToolTipText("Run Application");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel4MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbox2/img/emblem-system.png"))); // NOI18N
        jLabel5.setToolTipText("Preferences");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel5MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("D-Box 1.5");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(jLabel4)
                .add(18, 18, 18)
                .add(jLabel2)
                .add(18, 18, 18)
                .add(jLabel5)
                .add(18, 18, 18)
                .add(jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtSearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 109, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                .add(txtSearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(jLabel1)
                .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(jLabel2)
                .add(jLabel5)
                .add(jLabel6))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 596, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    txtSearch.setFocusable(true);
}//GEN-LAST:event_jLabel1MouseClicked

private void mnuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAboutActionPerformed
    AboutWindow ass = new AboutWindow(this, true);
    ass.setVisible(true);
}//GEN-LAST:event_mnuAboutActionPerformed

private void Double(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Double
    if(evt.getClickCount() == 2 && !evt.isAltDown())
        mnuRunActionPerformed(null);
    else if(evt.getClickCount() == 15 && evt.isAltDown())
        JOptionPane.showMessageDialog(this, "Saying that Java is good because it works on all platforms\n is like saying anal sex is good because it works on all genders.");
}//GEN-LAST:event_Double

private void mnuRunDosBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRunDosBoxActionPerformed
    String[] par = new String[3];
        par[0] = pref.getDosBoxPath();
        par[1] = "-c";
        par[2] = "@echo Have fun! Best wishes from D-Box :)";
        
        try {
            Runtime.getRuntime().exec(par);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
}//GEN-LAST:event_mnuRunDosBoxActionPerformed

private void mnuPrefsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPrefsActionPerformed
    PreferencesGUI prf = new PreferencesGUI();
    prf.setModal(true);
    prf.setVisible(true);
    prf = null;
    skrivObjekt("preferences.dat", pref);
}//GEN-LAST:event_mnuPrefsActionPerformed

private void mnuSetupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSetupActionPerformed
    
    DosItem di = bl.getGame((String)gameList.getSelectedValue());
    
        String[] par = new String[9];
        par[0] = pref.getDosBoxPath();
        par[1] = "-c";
        par[2] = "mount c: \"" + di.getPath()+"\"";
        par[3] = "-c";
        par[4] = "c:";
        par[5] = "-c";
        par[6] = di.getInstaller();
        par[7] = "-c";
        par[8] = "exit";
        
        try {
            Runtime.getRuntime().exec(par);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
}//GEN-LAST:event_mnuSetupActionPerformed

private String getCurrentDir() {
    File dir1 = new File (".");
     try {
       return dir1.getCanonicalPath();
     }
     catch(Exception e) {
       e.printStackTrace();
       }
    return null;
}

private void mnuRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRunActionPerformed
    DosItem di = bl.getGame((String)gameList.getSelectedValue());
        writeConfig(
                    getCurrentDir() + File.separator + "dosbox.conf",
                    di.getCycles(),
                    pref.isFullScreen(),
                    di.getPath(),
                    di.getCdrom(),
                    di.getFrameskip()
                   );
        String[] par = new String[11];
        par[0] = pref.getDosBoxPath();
        par[1] = "-c";
        par[2] = "@echo Go go go!";
        System.out.println(par[2]);
        par[3] = "-c";
        par[4] = "c:";
        par[5] = "-c";
        par[6] = di.getGame();
      
        if(!pref.isKeepOpen()){
            System.out.println("hold!");
            par[7] = "-c";
            par[8] = "exit";
        }
        else {
            System.out.println("ikke hold!");
            par[7] = "-c";
            par[8] = "@echo Keep on rockin'!";
        }
        
        par[9] = "-conf";
        par[10] = getCurrentDir() + File.separator + "dosbox.conf";
        
        try {
            Runtime.getRuntime().exec(par);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
}//GEN-LAST:event_mnuRunActionPerformed

private void mnuEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEditActionPerformed
    ItemGUI ui = new ItemGUI(bl.removeGame((String)gameList.getSelectedValue()), this);
    ui.setVisible(true);
    ui = null;
    updateList();
}//GEN-LAST:event_mnuEditActionPerformed

private void mnuNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNewActionPerformed
    ItemGUI ui = new ItemGUI(this);
    ui.setVisible(true);
    ui = null;
    updateList();
}//GEN-LAST:event_mnuNewActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
    updateList(txtSearch.getText());
}//GEN-LAST:event_txtSearchKeyReleased

private void mnuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDeleteActionPerformed

    bl.removeGame((String)gameList.getSelectedValue());
    updateList();
}//GEN-LAST:event_mnuDeleteActionPerformed

private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
    System.exit(0);
}//GEN-LAST:event_mnuExitActionPerformed

private void gameListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gameListKeyPressed
    if(evt.getKeyCode() == evt.VK_ENTER)
        mnuRunActionPerformed(null);
}//GEN-LAST:event_gameListKeyPressed

private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
editMenu.show(evt.getComponent(),
                       evt.getX(), evt.getY());

}//GEN-LAST:event_jLabel2MousePressed

private void jLabel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseReleased

}//GEN-LAST:event_jLabel2MouseReleased

private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

}//GEN-LAST:event_jLabel2MouseClicked

private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed

    if(evt.getButton() == MouseEvent.BUTTON3) {
    runMenu.show(evt.getComponent(),
                       evt.getX(), evt.getY());
    }
}//GEN-LAST:event_jLabel4MousePressed

private void jLabel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseReleased
    // TODO add your handling code here:
}//GEN-LAST:event_jLabel4MouseReleased

private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
if(evt.getButton() == evt.BUTTON1)
    mnuRunActionPerformed(null);
}//GEN-LAST:event_jLabel4MouseClicked

private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
    // TODO add your handling code here:
}//GEN-LAST:event_jLabel5MousePressed

private void jLabel5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseReleased
    // TODO add your handling code here:
}//GEN-LAST:event_jLabel5MouseReleased

private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
    mnuPrefsActionPerformed(null);
}//GEN-LAST:event_jLabel5MouseClicked

private void gameListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gameListMouseReleased
    if(evt.getButton() == MouseEvent.BUTTON3) {
    runMenu.show(evt.getComponent(),
                       evt.getX(), evt.getY());
    }
}//GEN-LAST:event_gameListMouseReleased

private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
    BrowserControl.openUrl("http://code.google.com/p/dbox/");
}//GEN-LAST:event_jLabel3MouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu editMenu;
    private javax.swing.JList gameList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JMenuItem mnuAbout;
    private javax.swing.JMenuItem mnuDelete;
    private javax.swing.JMenuItem mnuDelete1;
    private javax.swing.JMenuItem mnuDelete2;
    private javax.swing.JMenuItem mnuEdit;
    private javax.swing.JMenuItem mnuEdit1;
    private javax.swing.JMenuItem mnuEdit2;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenuItem mnuExit1;
    private javax.swing.JMenu mnuGame;
    private javax.swing.JMenu mnuGame1;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenu mnuHelp1;
    private javax.swing.JMenuItem mnuNew;
    private javax.swing.JMenuItem mnuNew1;
    private javax.swing.JMenuItem mnuNew2;
    private javax.swing.JMenuItem mnuPrefs;
    private javax.swing.JMenuItem mnuPrefs1;
    private javax.swing.JMenuItem mnuRun;
    private javax.swing.JMenuItem mnuRun1;
    private javax.swing.JMenuItem mnuRun2;
    private javax.swing.JMenuItem mnuRunDosBox;
    private javax.swing.JMenuItem mnuRunDosBox1;
    private javax.swing.JMenuItem mnuSetup;
    private javax.swing.JMenuItem mnuSetup1;
    private javax.swing.JMenuItem mnuSetup2;
    private javax.swing.JPopupMenu runMenu;
    private javax.swing.JTextField txtSearch;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    
}