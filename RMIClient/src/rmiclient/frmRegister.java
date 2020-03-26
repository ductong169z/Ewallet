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
import rmiserver.IUserFunc;

public class frmRegister extends javax.swing.JFrame {

    IUserFunc iUser;

    /* Constructor for form Register */
    public frmRegister() {
        initComponents();

        try {
            // look up the registry created in RMI Server
            iUser = (IUserFunc) Naming.lookup("rmi://localhost:70/UserFunctions");
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderGroup = new javax.swing.ButtonGroup();
        panelRegister = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        lblPassword = new javax.swing.JLabel();
        lblPasswordConfirm = new javax.swing.JLabel();
        txtPasswordConfirm = new javax.swing.JPasswordField();
        lblFullname = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUsername.setText("Username:");

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPassword.setText("Password:");

        lblPasswordConfirm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPasswordConfirm.setText("Confirmation:");

        txtPasswordConfirm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblFullname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblFullname.setText("Fullname:");

        txtFullname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblGender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblGender.setText("Gender:");

        genderGroup.add(rdoMale);
        rdoMale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdoMale.setSelected(true);
        rdoMale.setText("Male");

        genderGroup.add(rdoFemale);
        rdoFemale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdoFemale.setText("Female");

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEmail.setText("Email:");

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPhone.setText("Phone:");

        txtPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnOK.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        lblAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAddress.setText("Address:");

        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout panelRegisterLayout = new javax.swing.GroupLayout(panelRegister);
        panelRegister.setLayout(panelRegisterLayout);
        panelRegisterLayout.setHorizontalGroup(
            panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFullname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblPasswordConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtFullname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelRegisterLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelRegisterLayout.createSequentialGroup()
                                    .addComponent(rdoMale, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rdoFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelRegisterLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtPasswordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegisterLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegisterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192))
        );
        panelRegisterLayout.setVerticalGroup(
            panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegisterLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPasswordConfirm)
                    .addComponent(txtPasswordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFullname)
                    .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender)
                    .addComponent(rdoMale)
                    .addComponent(rdoFemale))
                .addGap(18, 18, 18)
                .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btnOK)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        /* Check if there are any fields having null values or being empty, or the 2 password fields don't match, or phone number is not 10-digit */
        if (txtUsername.getText() == null || txtUsername.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "The username must not be null or empty!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
        } else if (String.valueOf(txtPassword.getPassword()) == null || String.valueOf(txtPassword.getPassword()).trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "The password must not be null or empty!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
        } else if (String.valueOf(txtPasswordConfirm.getPassword()) == null || String.valueOf(txtPasswordConfirm.getPassword()).trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "The password confirmation must not be null or empty!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
        } else if (!String.valueOf(txtPasswordConfirm.getPassword()).equals(String.valueOf(txtPassword.getPassword()))) {
            JOptionPane.showMessageDialog(this, "The password confirmation must match the password!", "Input Error", JOptionPane.ERROR_MESSAGE);
        } else if (txtFullname.getText() == null || txtFullname.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "The full name field must not be null or empty!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
        } else if (txtEmail.getText() == null || txtEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "The email field must not be null or empty!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
        } else if (txtPhone.getText() == null || txtPhone.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "The phone field must not be null or empty!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
        } else if (txtPhone.getText().length() != 10) {
            JOptionPane.showMessageDialog(this, "The phone number must consist of 10 digits", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
            /* If there are no fields having null value or being empty and both password fields match */
        } else {
            /* Temp variables to store values from the fields user inputted */
            String username = txtUsername.getText().trim();
            String password = String.valueOf(txtPasswordConfirm.getPassword());
            String fullname = txtFullname.getText().trim();
            String mail = txtEmail.getText().trim();
            String phone = txtPhone.getText().trim();
            String gender = rdoMale.isSelected() ? "Male" : "Female";
            String address = txtAddress.getText().trim();
            int result = -1; // store the result of operation (0 if successful, 1 if unsuccessful, 2 if phone number already bound to another account in database)

            // call method createUser on server side to execute
            try {
                result = iUser.createUser(username, password, fullname, phone, mail, address, gender);
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(this, "Remote Exception Occured!", "Registration failed", JOptionPane.ERROR_MESSAGE);
            }

            /* Perform action dependent on result */
            switch (result) {
                case 0:
                    // clear all input fields
                    txtUsername.setText("");
                    txtPassword.setText("");
                    txtPasswordConfirm.setText("");
                    txtFullname.setText("");
                    txtEmail.setText("");
                    txtPhone.setText("");
                    txtAddress.setText("");
                    JOptionPane.showMessageDialog(this, "Creating new account succesfully!", "Registration successfully", JOptionPane.INFORMATION_MESSAGE);
                    // if operation is unsuccessful on server side
                    break;
                case 1:
                    JOptionPane.showMessageDialog(this, "Creating new account failed!\nSQL Exception or Hashing Error Occured!", "Registration failed", JOptionPane.ERROR_MESSAGE);
                    // if phone number already bound to another account in database
                    break;
                case 2:
                    JOptionPane.showMessageDialog(this, "This phone number already bound to another account!", "Registration failed", JOptionPane.ERROR_MESSAGE);
                    // if username already bound to another account in database
                    break;
                case 3:
                    JOptionPane.showMessageDialog(this, "This username already bound to another account!", "Registration failed", JOptionPane.ERROR_MESSAGE);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(this, "Encrypting Password Error!", "Registration failed", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }//GEN-LAST:event_btnOKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.ButtonGroup genderGroup;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFullname;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPasswordConfirm;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel panelRegister;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordConfirm;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
