/*
 * MainWindow.java
 *
 * Created on July 26, 2007, 8:54 PM
 */

package dbox2;

import java.awt.Dimension;
import java.awt.Rectangle;
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
        bl = deSerialize("database.dat");
        pref = deSerializePref("preferences.dat");
        initComponents();
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
            JOptionPane.showMessageDialog(this, "Hi!\n\nSeems like this is the first time you launch D-Box. I will now open the preferences window so you can fill in the blanks in my memory.", "Welcome!", JOptionPane.INFORMATION_MESSAGE);
            mnuPrefsActionPerformed(null);
            JOptionPane.showMessageDialog(this, "Thank you for assisting me! Now, go and have fun!", "Thank You!", JOptionPane.INFORMATION_MESSAGE);
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
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        gameList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        mnuNew1 = new javax.swing.JMenuItem();
        mnuEdit1 = new javax.swing.JMenuItem();
        mnuDelete1 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JSeparator();
        mnuPrefs1 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JSeparator();
        mnuExit1 = new javax.swing.JMenuItem();
        mnuGame1 = new javax.swing.JMenu();
        mnuRun1 = new javax.swing.JMenuItem();
        mnuSetup1 = new javax.swing.JMenuItem();
        mnuHelp1 = new javax.swing.JMenu();
        mnuRunDosBox1 = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuNew = new javax.swing.JMenuItem();
        mnuEdit = new javax.swing.JMenuItem();
        mnuDelete = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        mnuPrefs = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        mnuExit = new javax.swing.JMenuItem();
        mnuGame = new javax.swing.JMenu();
        mnuRun = new javax.swing.JMenuItem();
        mnuSetup = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        mnuRunDosBox = new javax.swing.JMenuItem();
        mnuAbout = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuNew = new javax.swing.JMenuItem();
        mnuEdit = new javax.swing.JMenuItem();
        mnuDelete = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        mnuPrefs = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        mnuExit = new javax.swing.JMenuItem();
        mnuGame = new javax.swing.JMenu();
        mnuRun = new javax.swing.JMenuItem();
        mnuSetup = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        mnuRunDosBox = new javax.swing.JMenuItem();
        mnuAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("D-Box");

        gameList.setFocusCycleRoot(true);
        gameList.setNextFocusableComponent(txtSearch);
        gameList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Double(evt);
            }
        });
        jScrollPane1.setViewportView(gameList);

        jLabel1.setText("Search:");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        txtSearch.setToolTipText("Search the gamelist");
        txtSearch.setNextFocusableComponent(gameList);
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jMenu2.setText("File");

        mnuNew1.setText("New Game");
        mnuNew1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNewActionPerformed(evt);
            }
        });
        jMenu2.add(mnuNew1);

        mnuEdit1.setText("Edit Game");
        mnuEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEditActionPerformed(evt);
            }
        });
        jMenu2.add(mnuEdit1);

        mnuDelete1.setText("Delete Game");
        mnuDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDeleteActionPerformed(evt);
            }
        });
        jMenu2.add(mnuDelete1);
        jMenu2.add(jSeparator3);

        mnuPrefs1.setText("Preferences");
        mnuPrefs1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPrefsActionPerformed(evt);
            }
        });
        jMenu2.add(mnuPrefs1);
        jMenu2.add(jSeparator4);

        mnuExit1.setText("Exit");
        mnuExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        jMenu2.add(mnuExit1);

        jMenuBar2.add(jMenu2);

        mnuGame1.setText("Game");

        mnuRun1.setText("Run");
        mnuRun1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRunActionPerformed(evt);
            }
        });
        mnuGame1.add(mnuRun1);

        mnuSetup1.setText("Setup");
        mnuSetup1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSetupActionPerformed(evt);
            }
        });
        mnuGame1.add(mnuSetup1);

        jMenuBar2.add(mnuGame1);

        mnuHelp1.setText("Help");

        mnuRunDosBox1.setText("Run DosBox");
        mnuRunDosBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRunDosBoxActionPerformed(evt);
            }
        });
        mnuHelp1.add(mnuRunDosBox1);

        jMenuBar2.add(mnuHelp1);

        jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getStyle() | java.awt.Font.BOLD, jLabel2.getFont().getSize()+5));
        jLabel2.setText("D-BOX");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jMenu1.setText("File");

        mnuNew.setText("New Game");
        mnuNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNewActionPerformed(evt);
            }
        });
        jMenu1.add(mnuNew);

        mnuEdit.setText("Edit Game");
        mnuEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEditActionPerformed(evt);
            }
        });
        jMenu1.add(mnuEdit);

        mnuDelete.setText("Delete Game");
        mnuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDeleteActionPerformed(evt);
            }
        });
        jMenu1.add(mnuDelete);
        jMenu1.add(jSeparator2);

        mnuPrefs.setText("Preferences");
        mnuPrefs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPrefsActionPerformed(evt);
            }
        });
        jMenu1.add(mnuPrefs);
        jMenu1.add(jSeparator1);

        mnuExit.setText("Exit");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        jMenu1.add(mnuExit);

        jMenuBar1.add(jMenu1);

        mnuGame.setText("Game");

        mnuRun.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        mnuRun.setText("Run");
        mnuRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRunActionPerformed(evt);
            }
        });
        mnuGame.add(mnuRun);

        mnuSetup.setText("Setup");
        mnuSetup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSetupActionPerformed(evt);
            }
        });
        mnuGame.add(mnuSetup);

        jMenuBar1.add(mnuGame);

        mnuHelp.setText("Help");

        mnuRunDosBox.setText("Run DosBox");
        mnuRunDosBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRunDosBoxActionPerformed(evt);
            }
        });
        mnuHelp.add(mnuRunDosBox);

        mnuAbout.setText("About");
        mnuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAboutActionPerformed(evt);
            }
        });
        mnuHelp.add(mnuAbout);

        jMenuBar1.add(mnuHelp);

        setJMenuBar(jMenuBar1);

        jMenu1.setText("File");

        mnuNew.setText("New Game");
        mnuNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNewActionPerformed(evt);
            }
        });
        jMenu1.add(mnuNew);

        mnuEdit.setText("Edit Game");
        mnuEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEditActionPerformed(evt);
            }
        });
        jMenu1.add(mnuEdit);

        mnuDelete.setText("Delete Game");
        mnuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDeleteActionPerformed(evt);
            }
        });
        jMenu1.add(mnuDelete);
        jMenu1.add(jSeparator2);

        mnuPrefs.setText("Preferences");
        mnuPrefs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPrefsActionPerformed(evt);
            }
        });
        jMenu1.add(mnuPrefs);
        jMenu1.add(jSeparator1);

        mnuExit.setText("Exit");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        jMenu1.add(mnuExit);

        jMenuBar1.add(jMenu1);

        mnuGame.setText("Game");

        mnuRun.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        mnuRun.setText("Run");
        mnuRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRunActionPerformed(evt);
            }
        });
        mnuGame.add(mnuRun);

        mnuSetup.setText("Setup");
        mnuSetup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSetupActionPerformed(evt);
            }
        });
        mnuGame.add(mnuSetup);

        jMenuBar1.add(mnuGame);

        mnuHelp.setText("Help");

        mnuRunDosBox.setText("Run DosBox");
        mnuRunDosBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRunDosBoxActionPerformed(evt);
            }
        });
        mnuHelp.add(mnuRunDosBox);

        mnuAbout.setText("About");
        mnuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAboutActionPerformed(evt);
            }
        });
        mnuHelp.add(mnuAbout);

        jMenuBar1.add(mnuHelp);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 287, Short.MAX_VALUE)
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtSearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 109, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtSearch)
                    .add(jLabel1)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    txtSearch.setFocusable(true);
}//GEN-LAST:event_jLabel1MouseClicked

private void mnuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAboutActionPerformed
    AboutWindow ass = new AboutWindow(this, true);
    ass.setVisible(true);
}//GEN-LAST:event_mnuAboutActionPerformed

private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
    int rn = (int) (Math.random() * 7);
    String[] s = new String[]{ "Heidsj", "Fyrings", "Lattis", "Hafich", "Könich", "Saftich", "Hydrodigg" };
    jLabel2.setText(s[rn] + "!");
}//GEN-LAST:event_jLabel2MouseClicked

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
            par[8] = "@echo Keep Working!";
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
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList gameList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JMenuItem mnuAbout;
    private javax.swing.JMenuItem mnuDelete;
    private javax.swing.JMenuItem mnuDelete1;
    private javax.swing.JMenuItem mnuEdit;
    private javax.swing.JMenuItem mnuEdit1;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenuItem mnuExit1;
    private javax.swing.JMenu mnuGame;
    private javax.swing.JMenu mnuGame1;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenu mnuHelp1;
    private javax.swing.JMenuItem mnuNew;
    private javax.swing.JMenuItem mnuNew1;
    private javax.swing.JMenuItem mnuPrefs;
    private javax.swing.JMenuItem mnuPrefs1;
    private javax.swing.JMenuItem mnuRun;
    private javax.swing.JMenuItem mnuRun1;
    private javax.swing.JMenuItem mnuRunDosBox;
    private javax.swing.JMenuItem mnuRunDosBox1;
    private javax.swing.JMenuItem mnuSetup;
    private javax.swing.JMenuItem mnuSetup1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
    
}
