/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.GroupLayout;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmiserver.IUserFunc;

/**
 *
 * @author dorew
 */
public class frmPay extends javax.swing.JFrame {

    IUserFunc iuser;
    int payOption; // pay option 1 is tuition fee, 2 is mobile card
    Map<String, String> school = new HashMap<>();
    /**
     * Creates new form frmPaytuition
     */
    public frmPay(int payOption) {
        try {
            this.payOption = payOption;
            initComponents();
            iuser = (IUserFunc) Naming.lookup("rmi://localhost:70/UserFunctions");
            if (payOption == 1) {
                lblTitle.setText("Pay Tuition");
                this.setTitle("Pay Tuition");
                lblSelection.setText("School:");
                lblInput.setText("Student ID:");
                lblNotification.setText("");
                school = iuser.getSchool();
                cbSelection.removeItemAt(0);
                for(String value: school.values()){
                        cbSelection.addItem(value);
                }
            } else if (payOption == 2) {
                lblTitle.setText("Top Up");
                this.setTitle("Top Up Mobile Account");
                lblSelection.setText("Amount:");
                lblInput.setText("Phone number:");
                lblNotification.setText("");
                cbSelection.removeItemAt(0);
                cbSelection.addItem("10,000 VND");
                cbSelection.addItem("20,000 VND");
                cbSelection.addItem("50,000 VND");
                cbSelection.addItem("100,000 VND");
                cbSelection.addItem("200,000 VND");
                cbSelection.addItem("500,000 VND");
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(frmPay.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(frmPay.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(frmPay.class.getName()).log(Level.SEVERE, null, ex);
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

        lblTitle = new javax.swing.JLabel();
        lblSelection = new javax.swing.JLabel();
        cbSelection = new javax.swing.JComboBox<>();
        lblInput = new javax.swing.JLabel();
        txtInput = new javax.swing.JTextField();
        lblNotification = new javax.swing.JLabel();
        btnPay = new javax.swing.JButton();
        btnPay1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pay Tuition");
        setResizable(false);

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("<Title>");

        lblSelection.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblSelection.setText("<Selection>:");

        cbSelection.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        lblInput.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblInput.setText("<Input>:");

        txtInput.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtInput.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtInputInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        lblNotification.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblNotification.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNotification.setText("<notification>");

        btnPay.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnPay.setText("Confirm");
        btnPay.setEnabled(false);

        btnPay1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnPay1.setText("Check");
        btnPay1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPay1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSelection)
                    .addComponent(lblInput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtInput)
                    .addComponent(cbSelection, 0, 259, Short.MAX_VALUE))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPay1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPay))
                    .addComponent(lblNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitle)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSelection)
                    .addComponent(cbSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInput)
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(lblNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPay)
                    .addComponent(btnPay1))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtInputInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtInputInputMethodTextChanged
        // TODO add your handling code here:
        lblNotification.setText("abcasd");
    }//GEN-LAST:event_txtInputInputMethodTextChanged

    private void btnPay1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPay1ActionPerformed
        // TODO add your handling code here:
        if(payOption == 1){
            
        }else if(payOption ==  2){
            
        }
    }//GEN-LAST:event_btnPay1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnPay1;
    private javax.swing.JComboBox<String> cbSelection;
    private javax.swing.JLabel lblInput;
    private javax.swing.JLabel lblNotification;
    private javax.swing.JLabel lblSelection;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtInput;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JComboBox<String> cbInput;
}
