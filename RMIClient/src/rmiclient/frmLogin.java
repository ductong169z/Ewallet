/**
 *
 * @author Wibuu Group, consists of 3 members:
 * @author Nguyen Duc Tong
 * @author Quan Duc Loc
 * @author Tran Minh Thang
 *
 */
package rmiclient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rmiserver.IAuthentication;
import rmiserver.User;

public class frmLogin extends javax.swing.JFrame {

    IAuthentication iAuth;

    /**
     * Creates new form frmUserInterface
     */
    public frmLogin() {
        initComponents();

        this.setLocationRelativeTo(null);
        try {
            // look up the registry created in RMI Server
            iAuth = (IAuthentication) Naming.lookup("rmi://localhost:69/Authentication");
        } catch (NotBoundException ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
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

        grpGender = new javax.swing.ButtonGroup();
        panelLogin = new javax.swing.JPanel();
        lblUsernameLog = new javax.swing.JLabel();
        lblPasswordLog = new javax.swing.JLabel();
        txtUsernameLog = new javax.swing.JTextField();
        txtPasswordLog = new javax.swing.JPasswordField();
        btnOKLog = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Authentication Form");

        panelLogin.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        panelLogin.setPreferredSize(new java.awt.Dimension(575, 540));

        lblUsernameLog.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblUsernameLog.setText("Username:");

        lblPasswordLog.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPasswordLog.setText("Password:");

        txtUsernameLog.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtPasswordLog.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnOKLog.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnOKLog.setText("OK");
        btnOKLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKLogActionPerformed(evt);
            }
        });

        jButton1.setText("User");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Admin");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Register");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblPasswordLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblUsernameLog, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPasswordLog)
                            .addComponent(txtUsernameLog, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 92, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnOKLog, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsernameLog)
                    .addComponent(txtUsernameLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPasswordLog)
                    .addComponent(txtPasswordLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(btnOKLog)
                .addGap(33, 33, 33)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new frmUser().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /* OK Button in LOGIN FORM */
    private void btnOKLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKLogActionPerformed
        boolean error = false; // check if there is any errors occured

        // check if there are any fields having null values or being empty, or the 2 password fields don't match
        if (txtUsernameLog.getText() == null || txtUsernameLog.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "The username must not be null or empty!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
        } else if (String.valueOf(txtPasswordLog.getPassword()) == null || String.valueOf(txtPasswordLog.getPassword()).trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "The password must not be null or empty!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
            // if there are no fields having null value or being empty and both password fields match
        } else {
            /* Temp variables to store values from the fields user inputted */
            String username = txtUsernameLog.getText();
            String password = String.valueOf(txtPasswordLog.getPassword());
            User result; // store the user return from operation

            // call method validateUser on server side to execute
            try {
                result = iAuth.validateUser(username, password);
                if (result != null) {
                    if (result.getFullname() == null) {
                        JOptionPane.showMessageDialog(this, "Cannot connect to Database\nSQL Exception Occured!", "Login failed", JOptionPane.ERROR_MESSAGE);
                    } else if (result.getRole_id() == 2) {
                        JOptionPane.showMessageDialog(this, "You are now logged in as a User!", "Login Successfully", JOptionPane.INFORMATION_MESSAGE);
                        new frmUser(result).setVisible(true);
                        this.setVisible(false);
                    } else {
                        if (iAuth.checkStatus(result.getId() + "")) {
                            JOptionPane.showMessageDialog(this, "You are now logged in as an Admin!", "Login Successfully", JOptionPane.INFORMATION_MESSAGE);
                            new frmAdmin(result).setVisible(true);
                            this.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(this, "Your account has been suspended !", "Login failed", JOptionPane.ERROR_MESSAGE);

                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Username or Password is incorrect", "Login failed", JOptionPane.ERROR_MESSAGE);
                }
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(this, "Remote Exception Occured!", "Login failed", JOptionPane.ERROR_MESSAGE);
                error = true; // mark that there's an error occured
            }

            // if there are no errors occured, and operation successful on server side
//            if (!error && result == 0) {
//                // clear all input fields
//                txtUsernameLog.setText("");
//                txtPasswordLog.setText("");
//                JOptionPane.showMessageDialog(this, "You are logged in!", "Login successfully", JOptionPane.INFORMATION_MESSAGE);
//                // if login failed (but no errors)
//            } else if (!error && result == 2) {
//                JOptionPane.showMessageDialog(this, "Username or Password is incorrect!\n(CASE-SENSITIVE)", "Login failed", JOptionPane.WARNING_MESSAGE);
//                // if operation unsuccessful on server side
//            } else if (result == 1) {
//                JOptionPane.showMessageDialog(this, "An error occured on server side!", "Login failed", JOptionPane.ERROR_MESSAGE);
//                // if there's an error occured on client side
//            } else {
//                JOptionPane.showMessageDialog(this, "An error occured!", "Login failed", JOptionPane.ERROR_MESSAGE);
//            }
        }
    }//GEN-LAST:event_btnOKLogActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new frmAdmin().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new frmRegister().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOKLog;
    private javax.swing.ButtonGroup grpGender;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel lblPasswordLog;
    private javax.swing.JLabel lblUsernameLog;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPasswordField txtPasswordLog;
    private javax.swing.JTextField txtUsernameLog;
    // End of variables declaration//GEN-END:variables
}
