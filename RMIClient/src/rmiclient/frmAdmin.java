/**
 *
 * @author Wibuu Group, consists of 3 members:
 * @author Nguyen Duc Tong
 * @author Quan Duc Loc
 * @author Tran Minh Thang
 *
 */
package rmiclient;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import rmiserver.IAdminFunc;
import rmiserver.User;

public class frmAdmin extends javax.swing.JFrame {

    IAdminFunc iAdmin;
    User adminInfo; // store logged in admin info

    /**
     * Creates new form frmAdmin
     */
    public frmAdmin() {
        initComponents();

        try {
            /* Add the icons to the buttons */

            // Add icon for the Create New User Button
            BufferedImage add = ImageIO.read(new File("adduser.png"));
            Image resizeAdd = add.getScaledInstance(btnCreateNewUser.getHeight(), btnCreateNewUser.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon addIcon = new ImageIcon(resizeAdd);
            btnCreateNewUser.setIcon(addIcon);

            // Add icon for the Reset Password Button
            BufferedImage reset = ImageIO.read(new File("reset.png"));
            Image resizeReset = reset.getScaledInstance(btnResetPassword.getHeight(), btnResetPassword.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon resetIcon = new ImageIcon(resizeReset);
            btnResetPassword.setIcon(resetIcon);

            // Add icon for the Suspend User Button
            BufferedImage block = ImageIO.read(new File("blocked.png"));
            Image resizeBlock = block.getScaledInstance(btnSuspendUser.getHeight(), btnSuspendUser.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon blockIcon = new ImageIcon(resizeBlock);
            btnSuspendUser.setIcon(blockIcon);

            // Add icon for the Deposit Report Button
            BufferedImage rDeposit = ImageIO.read(new File("rdeposit.png"));
            Image resizeRDeposit = rDeposit.getScaledInstance(btnDepositReport.getHeight(), btnDepositReport.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon rDepositIcon = new ImageIcon(resizeRDeposit);
            btnDepositReport.setIcon(rDepositIcon);

            // Add icon for the Withdraw Report Button
            BufferedImage rWithdraw = ImageIO.read(new File("rwithdraw.png"));
            Image resizeRWithdraw = rWithdraw.getScaledInstance(btnWithdrawReport.getHeight(), btnWithdrawReport.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon rWithdrawIcon = new ImageIcon(resizeRWithdraw);
            btnWithdrawReport.setIcon(rWithdrawIcon);

            // Add icon for the Transfer Report Button
            BufferedImage rTransfer = ImageIO.read(new File("rtransfer.png"));
            Image resizeRTransfer = rTransfer.getScaledInstance(btnTransferReport.getHeight(), btnTransferReport.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon rTransferIcon = new ImageIcon(resizeRTransfer);
            btnTransferReport.setIcon(rTransferIcon);
            this.setLocationRelativeTo(null); // center the form
        } catch (IOException ex) {
            Logger.getLogger(frmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // constructor
    public frmAdmin(User adminInfo) {
        initComponents();
        this.adminInfo = adminInfo;
        this.setLocationRelativeTo(null); // center the form

        try {
            /* Add the icons to the buttons */

            // Add icon for the Create New User Button
            BufferedImage add = ImageIO.read(new File("adduser.png"));
            Image resizeAdd = add.getScaledInstance(btnCreateNewUser.getHeight(), btnCreateNewUser.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon addIcon = new ImageIcon(resizeAdd);
            btnCreateNewUser.setIcon(addIcon);

            // Add icon for the Reset Password Button
            BufferedImage reset = ImageIO.read(new File("reset.png"));
            Image resizeReset = reset.getScaledInstance(btnResetPassword.getHeight(), btnResetPassword.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon resetIcon = new ImageIcon(resizeReset);
            btnResetPassword.setIcon(resetIcon);

            // Add icon for the Suspend User Button
            BufferedImage block = ImageIO.read(new File("blocked.png"));
            Image resizeBlock = block.getScaledInstance(btnSuspendUser.getHeight(), btnSuspendUser.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon blockIcon = new ImageIcon(resizeBlock);
            btnSuspendUser.setIcon(blockIcon);

            // Add icon for the Deposit Report Button
            BufferedImage rDeposit = ImageIO.read(new File("rdeposit.png"));
            Image resizeRDeposit = rDeposit.getScaledInstance(btnDepositReport.getHeight(), btnDepositReport.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon rDepositIcon = new ImageIcon(resizeRDeposit);
            btnDepositReport.setIcon(rDepositIcon);

            // Add icon for the Withdraw Report Button
            BufferedImage rWithdraw = ImageIO.read(new File("rwithdraw.png"));
            Image resizeRWithdraw = rWithdraw.getScaledInstance(btnWithdrawReport.getHeight(), btnWithdrawReport.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon rWithdrawIcon = new ImageIcon(resizeRWithdraw);
            btnWithdrawReport.setIcon(rWithdrawIcon);

            // Add icon for the Transfer Report Button
            BufferedImage rTransfer = ImageIO.read(new File("rtransfer.png"));
            Image resizeRTransfer = rTransfer.getScaledInstance(btnTransferReport.getHeight(), btnTransferReport.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon rTransferIcon = new ImageIcon(resizeRTransfer);
            btnTransferReport.setIcon(rTransferIcon);

            /* Connects to server */
            iAdmin = (IAdminFunc) Naming.lookup("rmi://localhost:71/AdminFunctions");

            /* Set Admin name in Welcome text */
            lblWelcome.setText("Welcome " + adminInfo.getFullname() + " !!!");

        } catch (NotBoundException ex) {
            Logger.getLogger(frmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(frmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(frmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbReport = new javax.swing.JTable();
        lblReportTitle = new javax.swing.JLabel();
        btnExport = new javax.swing.JButton();
        panelAdmin = new javax.swing.JPanel();
        lblMenu = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        pnReport = new javax.swing.JPanel();
        btnDepositReport = new javax.swing.JButton();
        btnWithdrawReport = new javax.swing.JButton();
        btnTransferReport = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnUsermanagement = new javax.swing.JPanel();
        btnCreateNewUser = new javax.swing.JButton();
        btnResetPassword = new javax.swing.JButton();
        btnSuspendUser = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        tbReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Amount", "Time", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbReport);

        lblReportTitle.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblReportTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReportTitle.setText("<Title>");

        btnExport.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnExport.setText("Export");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExport)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(lblReportTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(lblReportTitle)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExport)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EWallet (Admin UI)");

        lblMenu.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        lblMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenu.setText("Admin Menu");

        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("WELCOME ADMIN !!!");

        pnReport.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Report", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 16))); // NOI18N
        pnReport.setPreferredSize(new java.awt.Dimension(292, 412));

        btnDepositReport.setBorder(null);
        btnDepositReport.setContentAreaFilled(false);
        btnDepositReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositReportActionPerformed(evt);
            }
        });

        btnWithdrawReport.setContentAreaFilled(false);
        btnWithdrawReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWithdrawReportActionPerformed(evt);
            }
        });

        btnTransferReport.setContentAreaFilled(false);
        btnTransferReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferReportActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Deposit Report");
        jLabel1.setPreferredSize(new java.awt.Dimension(120, 20));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Withdraw Report");
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 20));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Transfer Report");
        jLabel3.setPreferredSize(new java.awt.Dimension(120, 20));

        javax.swing.GroupLayout pnReportLayout = new javax.swing.GroupLayout(pnReport);
        pnReport.setLayout(pnReportLayout);
        pnReportLayout.setHorizontalGroup(
            pnReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnReportLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(pnReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnReportLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(pnReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnWithdrawReport, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTransferReport, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDepositReport, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        pnReportLayout.setVerticalGroup(
            pnReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnReportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDepositReport, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnWithdrawReport, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTransferReport, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pnUsermanagement.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 16))); // NOI18N

        btnCreateNewUser.setContentAreaFilled(false);

        btnResetPassword.setContentAreaFilled(false);

        btnSuspendUser.setBorder(null);
        btnSuspendUser.setContentAreaFilled(false);
        btnSuspendUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuspendUserActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Create New User");
        jLabel4.setPreferredSize(new java.awt.Dimension(120, 20));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Reset Password");
        jLabel5.setPreferredSize(new java.awt.Dimension(120, 20));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Suspend User");
        jLabel6.setPreferredSize(new java.awt.Dimension(120, 20));

        javax.swing.GroupLayout pnUsermanagementLayout = new javax.swing.GroupLayout(pnUsermanagement);
        pnUsermanagement.setLayout(pnUsermanagementLayout);
        pnUsermanagementLayout.setHorizontalGroup(
            pnUsermanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUsermanagementLayout.createSequentialGroup()
                .addGroup(pnUsermanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnUsermanagementLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(pnUsermanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnUsermanagementLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(pnUsermanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnResetPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCreateNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(pnUsermanagementLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btnSuspendUser, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        pnUsermanagementLayout.setVerticalGroup(
            pnUsermanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUsermanagementLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCreateNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnResetPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSuspendUser, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelAdminLayout = new javax.swing.GroupLayout(panelAdmin);
        panelAdmin.setLayout(panelAdminLayout);
        panelAdminLayout.setHorizontalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAdminLayout.createSequentialGroup()
                        .addComponent(pnReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnUsermanagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(lblWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(lblMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAdminLayout.setVerticalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addComponent(lblMenu)
                .addGap(30, 30, 30)
                .addComponent(lblWelcome)
                .addGap(30, 30, 30)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnReport, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                    .addComponent(pnUsermanagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDepositReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositReportActionPerformed
        try {
            new frmReport(1).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDepositReportActionPerformed

    private void btnWithdrawReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWithdrawReportActionPerformed
        try {
            new frmReport(2).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnWithdrawReportActionPerformed

    private void btnTransferReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferReportActionPerformed
        try {
            new frmReport(3).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTransferReportActionPerformed

    private void btnCreatenewuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatenewuserActionPerformed
        // TODO add your handling code here:
        frmRegister newReg = new frmRegister();
        newReg.setVisible(true);
    }//GEN-LAST:event_btnCreatenewuserActionPerformed

    private void btnResetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetPasswordActionPerformed
        // TODO add your handling code here:
        String phone = JOptionPane.showInputDialog(this, "Input phone number here !", "Reset password", JOptionPane.INFORMATION_MESSAGE);
        if (!phone.isEmpty()) {
            try {

                User user = iAdmin.getUser(phone);
                if (user != null) {
                    JPasswordField pass = new JPasswordField(20);
                    JPanel panel = new JPanel();
                    JLabel label = new JLabel("Enter a password:");
                    panel.add(label);
                    panel.add(pass);
                    String password = null;
                    String[] options = new String[]{"OK", "Cancel"};
                    int option = JOptionPane.showOptionDialog(null, panel, "Reset password for " + user.getFullname(),
                            JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                            null, options, options[1]);
                    if (option == 0) // pressing OK button
                    {
                        char[] passwordchar = pass.getPassword();
                        password = new String(passwordchar);

                    }
                    if (!password.isEmpty()) {
                        boolean status = iAdmin.changePassword(String.valueOf(user.getId()), password);
                        if (status) {

                            JOptionPane.showMessageDialog(this, "Reset password successfully ! !", "Reset password", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "Has undefined error !", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "User not fund !", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } catch (RemoteException ex) {
                Logger.getLogger(frmAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnResetPasswordActionPerformed

    private void btnSuspendUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuspendUserActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:

            String phone = JOptionPane.showInputDialog(this, "Input phone number here !", "Suspened user", JOptionPane.INFORMATION_MESSAGE);

            User user = iAdmin.getUser(phone);
            if (user != null) {
                if (user.getRole_id() != 1) {
                    int cfirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to suspend " + user.getFullname(), "", JOptionPane.OK_CANCEL_OPTION);
                    if (cfirm == 0) {
                        boolean status = iAdmin.suspendUser(user.getId());
                        if (status) {
                            JOptionPane.showMessageDialog(this, user.getFullname() + " has been suspended  ! !", "Suspened user", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "Has undefined error !", "Error", JOptionPane.ERROR_MESSAGE);

                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Cannot suspend admin !", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
        } catch (RemoteException ex) {
            Logger.getLogger(frmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuspendUserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateNewUser;
    private javax.swing.JButton btnDepositReport;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnResetPassword;
    private javax.swing.JButton btnSuspendUser;
    private javax.swing.JButton btnTransferReport;
    private javax.swing.JButton btnWithdrawReport;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblReportTitle;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel panelAdmin;
    private javax.swing.JPanel pnReport;
    private javax.swing.JPanel pnUsermanagement;
    private javax.swing.JTable tbReport;
    // End of variables declaration//GEN-END:variables
}
