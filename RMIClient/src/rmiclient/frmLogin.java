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

        this.setLocationRelativeTo(null); // center the form
        try {
            // look up the registry created in RMI Server
            iAuth = (IAuthentication) Naming.lookup("rmi://localhost:69/Authentication");
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
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

        panelLogin = new javax.swing.JPanel();
        lblUsernameLog = new javax.swing.JLabel();
        lblPasswordLog = new javax.swing.JLabel();
        txtUsernameLog = new javax.swing.JTextField();
        txtPasswordLog = new javax.swing.JPasswordField();
        btnOKLog = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        lblSignUp = new javax.swing.JLabel();
        btnForgotPass = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Form");

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

        btnRegister.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(0, 80, 215));
        btnRegister.setText("Sign Up Now!");
        btnRegister.setBorder(null);
        btnRegister.setBorderPainted(false);
        btnRegister.setContentAreaFilled(false);
        btnRegister.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnRegister.setPreferredSize(new java.awt.Dimension(240, 31));
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        lblSignUp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSignUp.setText("No Account Yet?");
        lblSignUp.setPreferredSize(new java.awt.Dimension(132, 22));

        btnForgotPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnForgotPass.setForeground(new java.awt.Color(0, 80, 215));
        btnForgotPass.setText("Forgot Your Password?");
        btnForgotPass.setBorder(null);
        btnForgotPass.setBorderPainted(false);
        btnForgotPass.setContentAreaFilled(false);
        btnForgotPass.setPreferredSize(new java.awt.Dimension(240, 31));
        btnForgotPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForgotPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(btnOKLog, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblPasswordLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblUsernameLog, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPasswordLog)
                            .addComponent(txtUsernameLog, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnForgotPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addComponent(lblSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(45, 45, 45))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsernameLog)
                    .addComponent(txtUsernameLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPasswordLog)
                    .addComponent(txtPasswordLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(btnOKLog)
                .addGap(18, 18, 18)
                .addComponent(btnForgotPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* OK Button in LOGIN FORM */
    private void btnOKLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKLogActionPerformed
        /* Check if user credentials are inputted correctly */
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
            }
        }
    }//GEN-LAST:event_btnOKLogActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        new frmRegister(2).setVisible(true);
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnForgotPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForgotPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnForgotPassActionPerformed

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
    private javax.swing.JButton btnForgotPass;
    private javax.swing.JButton btnOKLog;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel lblPasswordLog;
    private javax.swing.JLabel lblSignUp;
    private javax.swing.JLabel lblUsernameLog;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPasswordField txtPasswordLog;
    private javax.swing.JTextField txtUsernameLog;
    // End of variables declaration//GEN-END:variables
}
