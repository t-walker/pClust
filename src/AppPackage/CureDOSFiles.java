/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RootPaneContainer;

/**
 *
 * @author Svetlana
 */
public class CureDOSFiles extends javax.swing.JDialog {

    /**
     * Creates new form CureDOSFiles
     */
    public CureDOSFiles(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("spiral_logo.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSelectFiles = new javax.swing.JLabel();
        txtSelectFiles = new javax.swing.JTextField();
        btnSelectFiles = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaTest = new javax.swing.JTextArea();
        lblSelectOutputDir = new javax.swing.JLabel();
        txtSelectOutputDir = new javax.swing.JTextField();
        btnSelectOutputDir = new javax.swing.JButton();
        btnCureFiles = new javax.swing.JButton();
        prChBoxShowOutput = new javax.swing.JCheckBox();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSelectFiles.setText("Select fasta files to cure:");
        getContentPane().add(lblSelectFiles, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        getContentPane().add(txtSelectFiles, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 380, -1));

        btnSelectFiles.setText("Browse");
        btnSelectFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectFilesActionPerformed(evt);
            }
        });
        getContentPane().add(btnSelectFiles, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 80, -1));

        txtAreaTest.setColumns(20);
        txtAreaTest.setRows(5);
        jScrollPane1.setViewportView(txtAreaTest);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 490, 160));

        lblSelectOutputDir.setText("Select folder for storing the output files:");
        getContentPane().add(lblSelectOutputDir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));
        getContentPane().add(txtSelectOutputDir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 380, -1));

        btnSelectOutputDir.setText("Browse");
        btnSelectOutputDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectOutputDirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSelectOutputDir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 80, -1));

        btnCureFiles.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCureFiles.setText("Cure Files");
        btnCureFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCureFilesActionPerformed(evt);
            }
        });
        getContentPane().add(btnCureFiles, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 150, 30));

        prChBoxShowOutput.setSelected(true);
        prChBoxShowOutput.setText("Show diagnostic messages");
        getContentPane().add(prChBoxShowOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, 30));

        btnClear.setText("Clear output window");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 150, 30));

        setSize(new java.awt.Dimension(508, 379));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * This method turns a normal cursor into the waiting cursor shape.
     * Use this method only in conjuction with stopWaitCursor() method.
     */
    public void startWaitCursor() {
        RootPaneContainer root = (RootPaneContainer) this.getRootPane().getTopLevelAncestor();
        root.getGlassPane().setCursor(
                Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        root.getGlassPane().setVisible(true);
    }

    /**
     * This method turns a waiting cursor into the normal cursor shape.
     * Use this method only in conjuction with startWaitCursor() method.
     */
    public void stopWaitCursor() {
        RootPaneContainer root = (RootPaneContainer) this.getRootPane().getTopLevelAncestor();
        root.getGlassPane().setCursor(
                Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        root.getGlassPane().setVisible(false);
    }

    private void btnSelectFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectFilesActionPerformed
        //Create a file chooser
        JFileChooser fc = new JFileChooser();
        // Set default directory
        //        fc.setCurrentDirectory(new File(System.getProperty("user.home")));
        fc.setCurrentDirectory(new File("."+ File.separator + "Resources"));
        // Allow to open only files
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        // Allow to select multiple files.
        fc.setMultiSelectionEnabled(true);

        // User does selection --> get its value
        int returnVal = fc.showOpenDialog(this);
        int i;
        String fileNames = "";

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            // Store selected files in the private variable files
            this.files = fc.getSelectedFiles();
            // Display the selected files
            for(i = 0; i < this.files.length; i++){
                fileNames += "\"" + this.files[i].getName() + "\" ";
            }
            this.txtSelectFiles.setText(fileNames);

            // Debuging display
            if(this.prChBoxShowOutput.isSelected()){
                this.txtAreaTest.append("Selected input files:" + this.newline);
                for(i = 0; i < this.files.length; i++){
                    this.txtAreaTest.append(this.files[i].getAbsolutePath() + this.newline);
                }
            }
        }
        else{
            if(this.prChBoxShowOutput.isSelected())
                this.txtAreaTest.append("User canceled action" + this.newline + this.newline);
            this.txtSelectFiles.setText("");
        }
        this.lblSelectFiles.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnSelectFilesActionPerformed

    private void btnSelectOutputDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectOutputDirActionPerformed
        //Create a file chooser
        JFileChooser fc = new JFileChooser();
        // Set default directory
        fc.setCurrentDirectory(null);
        // Allow to open both files and directories
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        // User does selection --> get its value
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            this.outputDir = fc.getSelectedFile();
            this.txtSelectOutputDir.setText(this.outputDir.getAbsolutePath());
            
            if(this.prChBoxShowOutput.isSelected()){
                this.txtAreaTest.append("Selected output directory:"  + this.newline
                    + this.outputDir.getAbsolutePath() + this.newline + this.newline);
            }
        }
        else{
            if(this.prChBoxShowOutput.isSelected())
                this.txtAreaTest.append("User canceled action" + this.newline + this.newline);
            this.txtSelectOutputDir.setText("");
        }
        this.lblSelectOutputDir.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnSelectOutputDirActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        this.txtAreaTest.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCureFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCureFilesActionPerformed
        // Re-intiate label colors
        this.lblSelectFiles.setForeground(Color.BLACK);
        this.lblSelectOutputDir.setForeground(Color.BLACK);
        int i;
        boolean flag = true;
        for(i = 0; i < this.files.length; i++){
                flag = replaceDOSchars(this.files[i]);
        }
        if(flag){
        JOptionPane.showMessageDialog(this, "Cured files successfully and stored in " 
                + this.txtSelectOutputDir.getText(),
                    "File Cured Successfully", JOptionPane.INFORMATION_MESSAGE);
        }else{
        JOptionPane.showMessageDialog(this, "An error occurred while curing one of the files" 
                + this.txtSelectOutputDir.getText(),
                    "Error While Curing", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnCureFilesActionPerformed

    private void wrapperReplaceDOSFiles(File infile, File outfile){
        try {
            // Prepare different local variables
            OutputStream out = null;
            byte[] buf = new byte[1024];
            int b;
            startWaitCursor();
            if(this.prChBoxShowOutput.isSelected()){
                this.txtAreaTest.append("Processing file: " + infile.getName() + this.newline);
            }
            out = new FileOutputStream(outfile);
            InputStream in = new FileInputStream(infile);
            try {
                while ( (b = in.read(buf)) >= 0) {
                    String s = new String(Arrays.copyOfRange(buf, 0, b));
                    s = s.replaceAll("[\\r]+", "");
                    out.write(s.getBytes());
                    out.flush();
                }
            } catch (IOException e) {// b = in.read(buf)
                JOptionPane.showMessageDialog(this,
                    "Could not read line from " + infile.getName() + this.newline 
                            + "Showing Exception 1:" + this.newline + e,
                    "Could Not Read Line", JOptionPane.ERROR_MESSAGE);
                stopWaitCursor();
            }
            try {
                in.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this,
                    "Could not close input reader for " + infile.getName() + this.newline 
                            + "Showing Exception 2:" + this.newline + e,
                    "Could Not Close Input Reader", JOptionPane.ERROR_MESSAGE);
                stopWaitCursor();
            }
            try {
                out.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this,
                    "Could not close output writer for " + outfile.getName() + this.newline 
                            + "Showing Exception 3:" + this.newline + e,
                    "Could Not Close Output Writer", JOptionPane.ERROR_MESSAGE);
                stopWaitCursor();
            }
            stopWaitCursor();
            if(this.prChBoxShowOutput.isSelected()){
                this.txtAreaTest.append("Done processing file: " + infile.getName() + this.newline);
            }
        } catch (FileNotFoundException e) {// out = new FileOutputStream(outfile);
                JOptionPane.showMessageDialog(this,
                    "Could not open output writer for " + outfile.getName() + this.newline 
                            + "Showing Exception 4:" + this.newline + e,
                    "Could Not Open Output Writer", JOptionPane.ERROR_MESSAGE);
            stopWaitCursor();
        }
    }
    // This function removes all \r in text file
    private boolean replaceDOSchars(File infile){
        boolean flag = true;
        // Try to create a new file
        File outFile = new File(this.outputDir + File.separator + infile.getName());
        try {
            flag = outFile.createNewFile();
            if(flag == true){ // can create a new file
            // 1. If-clause: were able to create the specified output file
                wrapperReplaceDOSFiles(infile, outFile);
            }else{
            // 2. Else-clause: were not able to create the specified file.
            // The only assumed reason for that is that the file with such name already exists.
                int userResponse = JOptionPane.showConfirmDialog(this, "File "
                    + infile.getAbsolutePath() + " already exists. Do you want to overwrite it?",
                    "File Already Exists", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                // Option 1: User wants to overwrite the existing file
                if(userResponse == JOptionPane.YES_OPTION){
                    try{
                        outFile.delete();
                        flag = outFile.createNewFile();
                        if(flag == true){
                            wrapperReplaceDOSFiles(infile, outFile);
                        }
                        else{ // Could not create the new file!!
                            JOptionPane.showMessageDialog(this,
                                "Could not create the file. Close and restart this program.",
                                "Could Not Create File", JOptionPane.ERROR_MESSAGE);
                            return false;
                        }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this,
                            "Could not delete the file. Make sure the file exists and is closed."
                            + this.newline +  "Showing Exception 6 message: " + e,
                            "Could Not Delete File", JOptionPane.ERROR_MESSAGE);
                    }
                }
                // Option 2: User does not want to overwrite the existing file
                if(userResponse == JOptionPane.NO_OPTION){
                    this.lblSelectOutputDir.setForeground(Color.red);
                    this.txtSelectOutputDir.setText("");
                    this.txtSelectOutputDir.setCaretPosition(0);
                    this.txtSelectOutputDir.requestFocusInWindow();
                }
            }
        } catch (IOException e) {
            flag = false;
            JOptionPane.showMessageDialog(this,
                "File with such name already exists in this folder." + this.newline 
                        + "Please select another folder" + this.newline 
                        + "Showing Exception 5:" + this.newline + e,
                "Could Not Create File", JOptionPane.ERROR_MESSAGE);
            this.lblSelectOutputDir.setForeground(Color.red);
            this.txtSelectOutputDir.setText("");
            this.txtSelectOutputDir.setCaretPosition(0);
            this.txtSelectOutputDir.requestFocusInWindow();
        }
        return flag;
    }
    

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CureDOSFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CureDOSFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CureDOSFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CureDOSFiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CureDOSFiles dialog = new CureDOSFiles(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCureFiles;
    private javax.swing.JButton btnSelectFiles;
    private javax.swing.JButton btnSelectOutputDir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSelectFiles;
    private javax.swing.JLabel lblSelectOutputDir;
    private javax.swing.JCheckBox prChBoxShowOutput;
    private javax.swing.JTextArea txtAreaTest;
    private javax.swing.JTextField txtSelectFiles;
    private javax.swing.JTextField txtSelectOutputDir;
    // End of variables declaration//GEN-END:variables

    private File[] files; // stores array of FASTA files
//    private final  String newline = System.getProperty("line.separator");
    private final  String newline = "\n";
    private File outputDir; // stores user specified directory
    
}
