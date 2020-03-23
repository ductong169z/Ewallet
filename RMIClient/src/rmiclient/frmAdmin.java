/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import rmiserver.User;

/**
 *
 * @author dorew
 */
public class frmAdmin extends javax.swing.JFrame {

    /**
     * Creates new form frmAdmin
     */
    public frmAdmin() {
        try {
            initComponents();
            BufferedImage add = ImageIO.read(new File("adduser.png"));
            Image resizeadd = add.getScaledInstance(btnCreatenewuser.getHeight(), btnCreatenewuser.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon addicon = new ImageIcon(resizeadd);
            btnCreatenewuser.setIcon(addicon);
            BufferedImage block = ImageIO.read(new File("blocked.png"));
            Image resizeblock = block.getScaledInstance(btnSuspendUser.getHeight(), btnSuspendUser.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon blockicon = new ImageIcon(resizeblock);
            btnSuspendUser.setIcon(blockicon);
            BufferedImage password = ImageIO.read(new File("password.png"));
            Image resizepassword = password.getScaledInstance(btnResetpassword.getHeight(), btnResetpassword.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon passwordicon = new ImageIcon(resizepassword);
            btnResetpassword.setIcon(passwordicon);
            BufferedImage rdeposit = ImageIO.read(new File("rdeposit.png"));
            Image resizerdeposit = rdeposit.getScaledInstance(btnDepositreport.getHeight(), btnDepositreport.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon rdepositicon = new ImageIcon(resizerdeposit);
            btnDepositreport.setIcon(rdepositicon);
            BufferedImage rwithdraw = ImageIO.read(new File("rwithdraw.png"));
            Image resizerwithdraw = rwithdraw.getScaledInstance(btnWithdrawrport.getHeight(), btnWithdrawrport.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon withdrawicon = new ImageIcon(resizerwithdraw);
            btnWithdrawrport.setIcon(withdrawicon);
            BufferedImage transfer = ImageIO.read(new File("rtransfer.png"));
            Image resizetransfer = transfer.getScaledInstance(btnTransferreport.getHeight(), btnTransferreport.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon transfericon = new ImageIcon(resizetransfer);
            btnTransferreport.setIcon(transfericon);
            this.setLocationRelativeTo(null);
        } catch (IOException ex) {
            Logger.getLogger(frmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public frmAdmin(User info) {
        try {
            initComponents();
            BufferedImage add = ImageIO.read(new File("adduser.png"));
            Image resizeadd = add.getScaledInstance(btnCreatenewuser.getHeight(), btnCreatenewuser.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon addicon = new ImageIcon(resizeadd);
            btnCreatenewuser.setIcon(addicon);
            BufferedImage block = ImageIO.read(new File("blocked.png"));
            Image resizeblock = block.getScaledInstance(btnSuspendUser.getHeight(), btnSuspendUser.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon blockicon = new ImageIcon(resizeblock);
            btnSuspendUser.setIcon(blockicon);
            BufferedImage password = ImageIO.read(new File("password.png"));
            Image resizepassword = password.getScaledInstance(btnResetpassword.getHeight(), btnResetpassword.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon passwordicon = new ImageIcon(resizepassword);
            btnResetpassword.setIcon(passwordicon);
            BufferedImage rdeposit = ImageIO.read(new File("rdeposit.png"));
            Image resizerdeposit = rdeposit.getScaledInstance(btnDepositreport.getHeight(), btnDepositreport.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon rdepositicon = new ImageIcon(resizerdeposit);
            btnDepositreport.setIcon(rdepositicon);
            BufferedImage rwithdraw = ImageIO.read(new File("rwithdraw.png"));
            Image resizerwithdraw = rwithdraw.getScaledInstance(btnWithdrawrport.getHeight(), btnWithdrawrport.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon withdrawicon = new ImageIcon(resizerwithdraw);
            btnWithdrawrport.setIcon(withdrawicon);
            BufferedImage transfer = ImageIO.read(new File("rtransfer.png"));
            Image resizetransfer = transfer.getScaledInstance(btnTransferreport.getHeight(), btnTransferreport.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon transfericon = new ImageIcon(resizetransfer);
            btnTransferreport.setIcon(transfericon);
            this.setLocationRelativeTo(null);
        } catch (IOException ex) {
            Logger.getLogger(frmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAdmin = new javax.swing.JPanel();
        lblMenu1 = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        pnReport = new javax.swing.JPanel();
        btnDepositreport = new javax.swing.JButton();
        btnWithdrawrport = new javax.swing.JButton();
        btnTransferreport = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnUsermanagement = new javax.swing.JPanel();
        btnCreatenewuser = new javax.swing.JButton();
        btnResetpassword = new javax.swing.JButton();
        btnSuspendUser = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMenu1.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        lblMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenu1.setText("Admin Menu");

        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblWelcome.setText("WELCOME ADMIN !!!");

        pnReport.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Report", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 16))); // NOI18N

        btnDepositreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositreportActionPerformed(evt);
            }
        });

        btnWithdrawrport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWithdrawrportActionPerformed(evt);
            }
        });

        btnTransferreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferreportActionPerformed(evt);
            }
        });

        jLabel1.setText("Deposit Report");

        jLabel2.setText("Withdraw Report");

        jLabel3.setText("Transfer Report");

        javax.swing.GroupLayout pnReportLayout = new javax.swing.GroupLayout(pnReport);
        pnReport.setLayout(pnReportLayout);
        pnReportLayout.setHorizontalGroup(
            pnReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnReportLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(pnReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(btnWithdrawrport, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTransferreport, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDepositreport, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        pnReportLayout.setVerticalGroup(
            pnReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnReportLayout.createSequentialGroup()
                .addComponent(btnDepositreport, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(btnWithdrawrport, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTransferreport, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        pnUsermanagement.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 16))); // NOI18N

        btnSuspendUser.setBorder(null);

        jLabel4.setText("Create New User");

        jLabel5.setText("Reset Password");

        jLabel6.setText("Suspend User");

        javax.swing.GroupLayout pnUsermanagementLayout = new javax.swing.GroupLayout(pnUsermanagement);
        pnUsermanagement.setLayout(pnUsermanagementLayout);
        pnUsermanagementLayout.setHorizontalGroup(
            pnUsermanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnUsermanagementLayout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addGroup(pnUsermanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addGroup(pnUsermanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnResetpassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCreatenewuser, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSuspendUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(87, 87, 87))
        );
        pnUsermanagementLayout.setVerticalGroup(
            pnUsermanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUsermanagementLayout.createSequentialGroup()
                .addComponent(btnCreatenewuser, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnResetpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuspendUser, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelAdminLayout = new javax.swing.GroupLayout(panelAdmin);
        panelAdmin.setLayout(panelAdminLayout);
        panelAdminLayout.setHorizontalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnUsermanagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdminLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(lblWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                .addGap(254, 254, 254))
        );
        panelAdminLayout.setVerticalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addComponent(lblMenu1)
                .addGap(29, 29, 29)
                .addComponent(lblWelcome)
                .addGap(18, 18, 18)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnUsermanagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDepositreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositreportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDepositreportActionPerformed

    private void btnWithdrawrportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWithdrawrportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnWithdrawrportActionPerformed

    private void btnTransferreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferreportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTransferreportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreatenewuser;
    private javax.swing.JButton btnDepositreport;
    private javax.swing.JButton btnResetpassword;
    private javax.swing.JButton btnSuspendUser;
    private javax.swing.JButton btnTransferreport;
    private javax.swing.JButton btnWithdrawrport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblMenu1;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel panelAdmin;
    private javax.swing.JPanel pnReport;
    private javax.swing.JPanel pnUsermanagement;
    // End of variables declaration//GEN-END:variables
}
