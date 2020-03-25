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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import rmiserver.IUserFunc;
import rmiserver.User;

public class frmUser extends javax.swing.JFrame {

    IUserFunc iUser;
    User userInfo; // store logged in user info
    int payOption; // pay option 1 is tuition fee, 2 is mobile card
    Map<String, String> schools = new HashMap<>();
    String id_student;
    String id_uni;
    int fee;
    String phoneNum;

    /**
     * Creates new form frmUser
     */
    public frmUser() {
        initComponents();
        this.setLocationRelativeTo(null); // center the frame
        try {
            /* Add the icons to the buttons */

            // Add icon for the Create New User Button
            BufferedImage deposit = ImageIO.read(new File("deposit.png"));
            Image resizeDeposit = deposit.getScaledInstance(btnDeposit.getHeight(), btnDeposit.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon depositIcon = new ImageIcon(resizeDeposit);
            btnDeposit.setIcon(depositIcon);

            // Add icon for the Create New User Button
            BufferedImage withdraw = ImageIO.read(new File("withdraw.png"));
            Image resizeWithdraw = withdraw.getScaledInstance(btnWithdraw.getHeight(), btnWithdraw.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon withdrawIcon = new ImageIcon(resizeWithdraw);
            btnWithdraw.setIcon(withdrawIcon);

            // Add icon for the Create New User Button
            BufferedImage transfer = ImageIO.read(new File("transfer.png"));
            Image resizeTransfer = transfer.getScaledInstance(btnTransfer.getHeight(), btnTransfer.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon transferIcon = new ImageIcon(resizeTransfer);
            btnTransfer.setIcon(transferIcon);

            // Add icon for the Create New User Button
            BufferedImage tuition = ImageIO.read(new File("tuition.png"));
            Image resizeTuition = tuition.getScaledInstance(btnPaytuition.getHeight(), btnPaytuition.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon tuitionIcon = new ImageIcon(resizeTuition);
            btnPaytuition.setIcon(tuitionIcon);

            // Add icon for the Create New User Button
            BufferedImage card = ImageIO.read(new File("card.png"));
            Image resizeCard = card.getScaledInstance(btnBuyMobile.getHeight(), btnBuyMobile.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon cardIcon = new ImageIcon(resizeCard);
            btnBuyMobile.setIcon(cardIcon);

            // Add icon for the Create New User Button
            BufferedImage changeInfo = ImageIO.read(new File("changeinfo.png"));
            Image resizeChangeInfo = changeInfo.getScaledInstance(btnChangeInfo.getHeight(), btnChangeInfo.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon changeInfoIcon = new ImageIcon(resizeChangeInfo);
            btnChangeInfo.setIcon(changeInfoIcon);

            // Add icon for the Create New User Button
            BufferedImage history = ImageIO.read(new File("history.png"));
            Image resizeHistory = history.getScaledInstance(btnTransactionHistory.getHeight(), btnTransactionHistory.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon historyIcon = new ImageIcon(resizeHistory);
            btnTransactionHistory.setIcon(historyIcon);

            // Add icon for the Create New User Button
            BufferedImage delete = ImageIO.read(new File("delete.png"));
            Image resizeDelete = delete.getScaledInstance(btnDeleteAccount.getHeight(), btnDeleteAccount.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon deleteIcon = new ImageIcon(resizeDelete);
            btnDeleteAccount.setIcon(deleteIcon);

            /* Connects to server */
            iUser = (IUserFunc) Naming.lookup("rmi://localhost:70/UserFunctions");

            /* Display user's full name and balance */
            txtName.setText(userInfo.getFullname());
            txtBalance.setText(userInfo.getMoney() + " VND");

//            set icon for the frame
//              Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/person.png"));
//            this.setIconImage(icon);
        } catch (NotBoundException ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public frmUser(User userInfo) {
        initComponents();

        this.userInfo = userInfo;

        this.setLocationRelativeTo(null); // center the frame
        try {
            /* Add the icons to the buttons */

            // Add icon for the Create New User Button
            BufferedImage deposit = ImageIO.read(new File("deposit.png"));
            Image resizeDeposit = deposit.getScaledInstance(btnDeposit.getHeight(), btnDeposit.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon depositIcon = new ImageIcon(resizeDeposit);
            btnDeposit.setIcon(depositIcon);

            // Add icon for the Create New User Button
            BufferedImage withdraw = ImageIO.read(new File("withdraw.png"));
            Image resizeWithdraw = withdraw.getScaledInstance(btnWithdraw.getHeight(), btnWithdraw.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon withdrawIcon = new ImageIcon(resizeWithdraw);
            btnWithdraw.setIcon(withdrawIcon);

            // Add icon for the Create New User Button
            BufferedImage transfer = ImageIO.read(new File("transfer.png"));
            Image resizeTransfer = transfer.getScaledInstance(btnTransfer.getHeight(), btnTransfer.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon transferIcon = new ImageIcon(resizeTransfer);
            btnTransfer.setIcon(transferIcon);

            // Add icon for the Create New User Button
            BufferedImage tuition = ImageIO.read(new File("tuition.png"));
            Image resizeTuition = tuition.getScaledInstance(btnPaytuition.getHeight(), btnPaytuition.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon tuitionIcon = new ImageIcon(resizeTuition);
            btnPaytuition.setIcon(tuitionIcon);

            // Add icon for the Create New User Button
            BufferedImage card = ImageIO.read(new File("card.png"));
            Image resizeCard = card.getScaledInstance(btnBuyMobile.getHeight(), btnBuyMobile.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon cardIcon = new ImageIcon(resizeCard);
            btnBuyMobile.setIcon(cardIcon);

            // Add icon for the Create New User Button
            BufferedImage changeInfo = ImageIO.read(new File("changeinfo.png"));
            Image resizeChangeInfo = changeInfo.getScaledInstance(btnChangeInfo.getHeight(), btnChangeInfo.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon changeInfoIcon = new ImageIcon(resizeChangeInfo);
            btnChangeInfo.setIcon(changeInfoIcon);

            // Add icon for the Create New User Button
            BufferedImage history = ImageIO.read(new File("history.png"));
            Image resizeHistory = history.getScaledInstance(btnTransactionHistory.getHeight(), btnTransactionHistory.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon historyIcon = new ImageIcon(resizeHistory);
            btnTransactionHistory.setIcon(historyIcon);

            // Add icon for the Create New User Button
            BufferedImage delete = ImageIO.read(new File("delete.png"));
            Image resizeDelete = delete.getScaledInstance(btnDeleteAccount.getHeight(), btnDeleteAccount.getWidth(), Image.SCALE_SMOOTH);
            ImageIcon deleteIcon = new ImageIcon(resizeDelete);
            btnDeleteAccount.setIcon(deleteIcon);

            /* Connects to server */
            iUser = (IUserFunc) Naming.lookup("rmi://localhost:70/UserFunctions");

            /* Display user's full name and balance */
            txtName.setText(userInfo.getFullname());
            txtBalance.setText(userInfo.getMoney() + " VND");

//            set icon for the frame
//              Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/person.png"));
//            this.setIconImage(icon);
        } catch (NotBoundException ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
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

        dPay = new javax.swing.JDialog();
        lblNotification = new javax.swing.JLabel();
        btnPay = new javax.swing.JButton();
        btnCheck = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblSelection = new javax.swing.JLabel();
        cbSelection = new javax.swing.JComboBox<>();
        lblInput = new javax.swing.JLabel();
        txtInput = new javax.swing.JTextField();
        lblNotification1 = new javax.swing.JLabel();
        panelUser = new javax.swing.JPanel();
        lblMenu = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtBalance = new javax.swing.JTextField();
        pnTransaction = new javax.swing.JPanel();
        btnWithdraw = new javax.swing.JButton();
        btnTransfer = new javax.swing.JButton();
        btnDeposit = new javax.swing.JButton();
        btnPaytuition = new javax.swing.JButton();
        btnBuyMobile = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnAccountmanagement = new javax.swing.JPanel();
        btnChangeInfo = new javax.swing.JButton();
        btnDeleteAccount = new javax.swing.JButton();
        btnTransactionHistory = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        dPay.setResizable(false);

        lblNotification.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblNotification.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNotification.setText("<notification>");

        btnPay.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnPay.setText("Confirm");
        btnPay.setEnabled(false);
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        btnCheck.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnCheck.setText("Check");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

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
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtInputInputMethodTextChanged(evt);
            }
        });

        lblNotification1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblNotification1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNotification1.setText("<notification>");

        javax.swing.GroupLayout dPayLayout = new javax.swing.GroupLayout(dPay.getContentPane());
        dPay.getContentPane().setLayout(dPayLayout);
        dPayLayout.setHorizontalGroup(
            dPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dPayLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dPayLayout.createSequentialGroup()
                .addGroup(dPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dPayLayout.createSequentialGroup()
                        .addContainerGap(92, Short.MAX_VALUE)
                        .addGroup(dPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dPayLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblNotification, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNotification1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(dPayLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(dPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSelection)
                            .addComponent(lblInput))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(dPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtInput)
                            .addComponent(cbSelection, 0, 259, Short.MAX_VALUE))))
                .addGap(40, 40, 40))
        );
        dPayLayout.setVerticalGroup(
            dPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dPayLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitle)
                .addGap(28, 28, 28)
                .addGroup(dPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSelection)
                    .addComponent(cbSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInput)
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(lblNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNotification1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPay)
                    .addComponent(btnCheck))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EWallet");

        panelUser.setPreferredSize(new java.awt.Dimension(580, 600));

        lblMenu.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        lblMenu.setText("MENU");

        lblName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblName.setText("Name:");

        lblBalance.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBalance.setText("Balance:");

        txtName.setEditable(false);
        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtName.setText("<Display Name>");
        txtName.setBorder(null);
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtBalance.setEditable(false);
        txtBalance.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtBalance.setText("<Display Balance>");
        txtBalance.setBorder(null);

        pnTransaction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transaction", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 16))); // NOI18N

        btnWithdraw.setContentAreaFilled(false);
        btnWithdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWithdrawActionPerformed(evt);
            }
        });

        btnTransfer.setContentAreaFilled(false);

        btnDeposit.setBorder(null);
        btnDeposit.setContentAreaFilled(false);
        btnDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositActionPerformed(evt);
            }
        });

        btnPaytuition.setContentAreaFilled(false);
        btnPaytuition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaytuitionActionPerformed(evt);
            }
        });

        btnBuyMobile.setContentAreaFilled(false);
        btnBuyMobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyMobileActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Deposit");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Withdraw");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Transfer");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Pay Tuition");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Top Up Mobile Account");

        javax.swing.GroupLayout pnTransactionLayout = new javax.swing.GroupLayout(pnTransaction);
        pnTransaction.setLayout(pnTransactionLayout);
        pnTransactionLayout.setHorizontalGroup(
            pnTransactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTransactionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnTransactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPaytuition, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnWithdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuyMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(110, 110, 110))
            .addGroup(pnTransactionLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(pnTransactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnTransactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        pnTransactionLayout.setVerticalGroup(
            pnTransactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTransactionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnWithdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPaytuition, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuyMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        pnAccountmanagement.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Account Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 16))); // NOI18N

        btnChangeInfo.setContentAreaFilled(false);

        btnDeleteAccount.setContentAreaFilled(false);

        btnTransactionHistory.setContentAreaFilled(false);
        btnTransactionHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransactionHistoryActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Change Info");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Delete Account");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Transaction History");

        javax.swing.GroupLayout pnAccountmanagementLayout = new javax.swing.GroupLayout(pnAccountmanagement);
        pnAccountmanagement.setLayout(pnAccountmanagementLayout);
        pnAccountmanagementLayout.setHorizontalGroup(
            pnAccountmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAccountmanagementLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnAccountmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChangeInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTransactionHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(110, 110, 110))
            .addGroup(pnAccountmanagementLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(pnAccountmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        pnAccountmanagementLayout.setVerticalGroup(
            pnAccountmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAccountmanagementLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnChangeInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTransactionHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelUserLayout = new javax.swing.GroupLayout(panelUser);
        panelUser.setLayout(panelUserLayout);
        panelUserLayout.setHorizontalGroup(
            panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUserLayout.createSequentialGroup()
                .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUserLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnAccountmanagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelUserLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBalance)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelUserLayout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(lblMenu)))
                .addContainerGap())
        );
        panelUserLayout.setVerticalGroup(
            panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMenu)
                .addGap(18, 18, 18)
                .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBalance)
                    .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnAccountmanagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelUser, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnWithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWithdrawActionPerformed
        new frmDepositWithdraw("withdraw", userInfo).setVisible(true);
    }//GEN-LAST:event_btnWithdrawActionPerformed

    private void btnDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositActionPerformed
        new frmDepositWithdraw("deposit", userInfo).setVisible(true);
    }//GEN-LAST:event_btnDepositActionPerformed

    private void btnTransactionHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransactionHistoryActionPerformed
        // TODO add your handling code here:
        new frmReport(4).setVisible(true);
    }//GEN-LAST:event_btnTransactionHistoryActionPerformed

    private void btnPaytuitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaytuitionActionPerformed
        try {
            cbSelection.removeAllItems();
            lblTitle.setText("Pay Tuition");
            lblSelection.setText("School:");
            lblInput.setText("Student ID:");
            lblNotification.setText("Name: ");
            lblNotification1.setText("Tuition fee:");
            txtInput.setText("");
            btnPay.setEnabled(false);
            schools = iUser.getSchool();
            for (String value : schools.values()) {
                cbSelection.addItem(value);
            }
            dPay.pack();
            payOption = 1;
            dPay.setVisible(true);

        } catch (RemoteException ex) {
            Logger.getLogger(frmUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPaytuitionActionPerformed

    private void btnBuyMobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyMobileActionPerformed
        // TODO add your handling code here:
        cbSelection.removeAllItems();
        lblTitle.setText("Top Up");
        lblSelection.setText("Amount:");
        lblInput.setText("Phone number:");
        lblNotification.setText("Phone number: ");
        lblNotification1.setText("Amount: ");
        txtInput.setText("");
        btnPay.setEnabled(false);
        cbSelection.addItem("10000 VND");
        cbSelection.addItem("20000 VND");
        cbSelection.addItem("50000 VND");
        cbSelection.addItem("100000 VND");
        cbSelection.addItem("200000 VND");
        cbSelection.addItem("500000 VND");
        dPay.pack();
        payOption = 2;
        dPay.setVisible(true);
    }//GEN-LAST:event_btnBuyMobileActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        // TODO add your handling code here:
        if (payOption == 1) {

            if (userInfo.getMoney() < fee) {
                JOptionPane.showMessageDialog(dPay, "You Dont Have Enough Money");
                dPay.setVisible(false);
            } else {
                try {
                    boolean check = iUser.payTuition(id_uni, id_student);
                    if (check == true) {
                        JOptionPane.showMessageDialog(dPay, "Paid Successfully");
                        dPay.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(dPay, "Some Error Occur !!! Please Try Again !!!");
                        dPay.setVisible(false);
                    }
                } catch (RemoteException ex) {
                    Logger.getLogger(frmUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (payOption == 2) {

        }
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        // TODO add your handling code here:
        if (payOption == 1) {
            try {
                int schoolId = (int) cbSelection.getSelectedIndex() + 1;
                String tuitionInfo = iUser.getTuition(String.valueOf(schoolId), txtInput.getText().toUpperCase());
                if (!tuitionInfo.equals("")) {
                    id_uni = String.valueOf(schoolId);
                    id_student = txtInput.getText().toUpperCase();
                    String[] info = tuitionInfo.split(": ");
                    lblNotification.setText("Name: " + info[0]);
                    lblNotification1.setText("Tuition fee: " + info[1] + " VND");
                    fee = Integer.parseInt(info[1]);
                    if (fee != 0) {
                        btnPay.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(dPay, "This student has paid tuition fee");
                        dPay.setVisible(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(dPay, "Student Not Found");
                }
            } catch (RemoteException ex) {
                Logger.getLogger(frmUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (payOption == 2) {
            phoneNum = txtInput.getText();
            if (phoneNum.matches("(\\+84)[1-9][0-9]{8}") || phoneNum.matches("[0][1-9][0-9]{8}")) {
                String ts = (String) cbSelection.getSelectedItem();
                String[] temp = ts.split(" ");
                fee = Integer.parseInt(temp[0]);
                if (userInfo.getMoney() >= fee) {
                    lblNotification.setText("Phone number: " + phoneNum);
                    lblNotification1.setText("Amount: " + fee + " VND");
                    btnPay.setEnabled(true);
                } else{
                    JOptionPane.showMessageDialog(dPay, "You dont have enough money");
                }
            }else{
                JOptionPane.showMessageDialog(dPay, "Please Input Right Format of Phone Number!!!!");
            }
        }
    }//GEN-LAST:event_btnCheckActionPerformed

    private void txtInputInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtInputInputMethodTextChanged

    }//GEN-LAST:event_txtInputInputMethodTextChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuyMobile;
    private javax.swing.JButton btnChangeInfo;
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnDeleteAccount;
    private javax.swing.JButton btnDeposit;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnPaytuition;
    private javax.swing.JButton btnTransactionHistory;
    private javax.swing.JButton btnTransfer;
    private javax.swing.JButton btnWithdraw;
    private javax.swing.JComboBox<String> cbSelection;
    private javax.swing.JDialog dPay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblInput;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNotification;
    private javax.swing.JLabel lblNotification1;
    private javax.swing.JLabel lblSelection;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelUser;
    private javax.swing.JPanel pnAccountmanagement;
    private javax.swing.JPanel pnTransaction;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtInput;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
