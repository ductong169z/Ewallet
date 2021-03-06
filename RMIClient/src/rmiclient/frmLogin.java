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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import rmiserver.IAdminFunc;
import rmiserver.IAuthentication;
import rmiserver.IUserFunc;
import rmiserver.User;

public class frmLogin extends javax.swing.JFrame {

    IAuthentication iAuth;
    ImageIcon icon;
    IAdminFunc iAdmin;

    /**
     * Creates new form frmUserInterface
     */
    public frmLogin() {
        initComponents();

        this.setLocationRelativeTo(null); // center the form
        this.getRootPane().setDefaultButton(btnOKLog); // set "OK" button to perform when user input "Enter" key
        try {
            // look up the registry created in RMI Server
            iAuth = (IAuthentication) Naming.lookup("rmi://localhost:69/Authentication");
            iAdmin = (IAdminFunc) Naming.lookup("rmi://localhost:71/AdminFunctions");

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Add WibuuPay icon
        try {
            BufferedImage wibuuImage = ImageIO.read(new File("Wibuu.png"));
            Image rWibuuImg = wibuuImage.getScaledInstance(iconWibuuPay.getWidth(), iconWibuuPay.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon wibuuIcon = new ImageIcon(rWibuuImg);
            iconWibuuPay.setIcon(wibuuIcon);
        } catch (IOException ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }


        /* Set Icon for the form */
        icon = new ImageIcon("miniWibuu.png");
        this.setIconImage(icon.getImage());

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
        iconWibuuPay = new javax.swing.JLabel();

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
                        .addGap(105, 105, 105)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnForgotPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                                .addComponent(lblSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(btnOKLog, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblPasswordLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblUsernameLog, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPasswordLog)
                                    .addComponent(txtUsernameLog, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(iconWibuuPay, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconWibuuPay, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
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
                .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
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
                    if (iAuth.checkStatus(result.getId() + "")) {

                        if (result.getFullname() == null) {
                            JOptionPane.showMessageDialog(this, "Cannot connect to Database\nSQL Exception Occured!", "Login failed", JOptionPane.ERROR_MESSAGE);
                        } else if (result.getRole_id() == 2) {
                            JOptionPane.showMessageDialog(this, "You are now logged in as a User!", "Login Successfully", JOptionPane.INFORMATION_MESSAGE);
                            JFrame frmUser = new frmUser(result);
                            frmUser.setIconImage(icon.getImage());
                            frmUser.setVisible(true);
                            this.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(this, "You are now logged in as an Admin!", "Login Successfully", JOptionPane.INFORMATION_MESSAGE);
                            JFrame frmAdmin = new frmAdmin(result);
                            frmAdmin.setIconImage(icon.getImage());
                            frmAdmin.setVisible(true);
                            this.setVisible(false);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Your account has been suspended !", "Login failed", JOptionPane.ERROR_MESSAGE);
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
        JTextField txtPhone = new JTextField();
        JTextField txtFullname = new JTextField();
        JPanel pnlReset = new JPanel();
        pnlReset.setLayout(new BoxLayout(pnlReset, BoxLayout.Y_AXIS));
        JLabel lblFullname = new JLabel("Enter your full name:");
        JLabel lblphone = new JLabel("Enter your phone number:");
        pnlReset.add(lblFullname);
        pnlReset.add(txtFullname);
        pnlReset.add(lblphone);
        pnlReset.add(txtPhone);
        String[] options = new String[]{"OK", "Cancel"};
        User user = null;
        int option = JOptionPane.showOptionDialog(this, pnlReset, "Forget password", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[1]);
        if (option == 0) {

            try {
                if (txtPhone.getText().matches("[0][1-9][0-9]{8}")) {
                    user = iAdmin.getUser(txtPhone.getText());
                    if (user == null) {
                        JOptionPane.showMessageDialog(this, "User with phone " + txtPhone.getText() + " doesn't exist");

                    } else {
                        if (user.getFullname().equals(txtFullname.getText())) {
                            boolean loop = true;
                            do {
                                JPasswordField txtPassword = new JPasswordField();
                                JPasswordField txtCPassword = new JPasswordField();
                                JPanel pnlPassword = new JPanel();
                                pnlPassword.setLayout(new BoxLayout(pnlPassword, BoxLayout.Y_AXIS));
                                JLabel lblPassword = new JLabel("Enter your new password:");
                                JLabel lblCpassword = new JLabel("Enter your new password again :");
                                pnlPassword.add(lblPassword);
                                pnlPassword.add(txtPassword);
                                pnlPassword.add(lblCpassword);
                                pnlPassword.add(txtCPassword);
                                int option2 = JOptionPane.showOptionDialog(this, pnlPassword, "Enter new password", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                                        null, options, options[1]);
                                if (option2 == 0) {
                                    if (String.valueOf(txtPassword.getPassword()).equals(String.valueOf(txtCPassword.getPassword()))) {
                                        if (String.valueOf(txtPassword.getPassword()) == null || String.valueOf(txtPassword.getPassword()).isEmpty()) {
                                            JOptionPane.showMessageDialog(this, "The password must not be null or empty!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);

                                        } else {
                                            iAdmin.changePassword(user.getId() + "", String.valueOf(txtCPassword.getPassword()));
                                            JOptionPane.showMessageDialog(this, "Your password has been reset successfully");
                                            loop = false;
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Password do not match");
                                    }
                                } else {
                                    loop = false;

                                }
                            } while (loop);
                        } else {
                            JOptionPane.showMessageDialog(this, "Username and Phone don't match");
                        }
                    }
                } else {

                    JOptionPane.showMessageDialog(this, "Please enter a valid phone number of 10 digits", "Input Notification", JOptionPane.INFORMATION_MESSAGE);

                }

            } catch (RemoteException ex) {
                Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception e) {
                Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, e);

            }
        }
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
    private javax.swing.JLabel iconWibuuPay;
    private javax.swing.JLabel lblPasswordLog;
    private javax.swing.JLabel lblSignUp;
    private javax.swing.JLabel lblUsernameLog;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPasswordField txtPasswordLog;
    private javax.swing.JTextField txtUsernameLog;
    // End of variables declaration//GEN-END:variables
}
