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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import rmiserver.IUserFunc;
import rmiserver.User;

public class frmUser extends javax.swing.JFrame {

    IUserFunc iUser;
    User userInfo; // store logged in user info
    String action;
    int maxDepositLim;
    int maxWithdrawLim;

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
        this.maxDepositLim = userInfo.getDeposit_lim();
        this.maxWithdrawLim = userInfo.getWithdraw_lim();

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

            txtPhoneNumber.setText(userInfo.getPhone());
            txtBalance1.setText(String.valueOf(userInfo.getMoney()) + " VND");

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
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogDepositWithdraw = new javax.swing.JDialog();
        lblPhoneNumber = new javax.swing.JLabel();
        lblCurrentBalance = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        lblAmount = new javax.swing.JLabel();
        txtBalance1 = new javax.swing.JTextField();
        txtAmount = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
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

        lblPhoneNumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPhoneNumber.setText("Your Phone Number");

        lblCurrentBalance.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCurrentBalance.setText("Current Balance");

        txtPhoneNumber.setEditable(false);
        txtPhoneNumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAmount.setText("Deposit Amount");

        txtBalance1.setEditable(false);
        txtBalance1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnConfirm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnConfirm.setText("Confirm Deposit");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogDepositWithdrawLayout = new javax.swing.GroupLayout(dialogDepositWithdraw.getContentPane());
        dialogDepositWithdraw.getContentPane().setLayout(dialogDepositWithdrawLayout);
        dialogDepositWithdrawLayout.setHorizontalGroup(
            dialogDepositWithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogDepositWithdrawLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(dialogDepositWithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dialogDepositWithdrawLayout.createSequentialGroup()
                        .addGroup(dialogDepositWithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCurrentBalance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPhoneNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(dialogDepositWithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBalance1)
                            .addComponent(txtAmount)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialogDepositWithdrawLayout.setVerticalGroup(
            dialogDepositWithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogDepositWithdrawLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(dialogDepositWithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhoneNumber))
                .addGap(18, 18, 18)
                .addGroup(dialogDepositWithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurrentBalance)
                    .addComponent(txtBalance1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogDepositWithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAmount)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(btnConfirm)
                .addGap(42, 42, 42))
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
        if (userInfo.getMoney() < 1000) {
            JOptionPane.showMessageDialog(this, "You must have at least 1000 VND to withdraw", "Withdraw Failed!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            txtName.setText(userInfo.getFullname());
            txtBalance.setText(userInfo.getMoney() + " VND");

            txtPhoneNumber.setText(userInfo.getPhone());
            txtBalance1.setText(String.valueOf(userInfo.getMoney()) + " VND");

            dialogDepositWithdraw.setTitle("Withdraw Transaction");
            lblAmount.setText("Withdraw Amount");
            btnConfirm.setText("Confirm Withdraw");

            dialogDepositWithdraw.pack();

            dialogDepositWithdraw.setVisible(true);
            dialogDepositWithdraw.setLocationRelativeTo(null);
            this.action = "withdraw";
        }
    }//GEN-LAST:event_btnWithdrawActionPerformed

    private void btnDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositActionPerformed
        txtName.setText(userInfo.getFullname());
        txtBalance.setText(userInfo.getMoney() + " VND");

        txtPhoneNumber.setText(userInfo.getPhone());
        txtBalance1.setText(String.valueOf(userInfo.getMoney()) + " VND");

        dialogDepositWithdraw.setTitle("Deposit Transaction");
        lblAmount.setText("Deposit Amount");
        btnConfirm.setText("Confirm Deposit");

        dialogDepositWithdraw.pack();

        dialogDepositWithdraw.setVisible(true);
        dialogDepositWithdraw.setLocationRelativeTo(null);
        this.action = "deposit";
    }//GEN-LAST:event_btnDepositActionPerformed

    private void btnTransactionHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransactionHistoryActionPerformed
        // TODO add your handling code here:
        new frmReport(4).setVisible(true);
    }//GEN-LAST:event_btnTransactionHistoryActionPerformed

    private void btnPaytuitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaytuitionActionPerformed
        // TODO add your handling code here:
        new frmPay(1).setVisible(true);
    }//GEN-LAST:event_btnPaytuitionActionPerformed

    private void btnBuyMobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyMobileActionPerformed
        // TODO add your handling code here:
        new frmPay(2).setVisible(true);
    }//GEN-LAST:event_btnBuyMobileActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        String txtAmountString; // deposit amount in String
        int txtAmountInt; // deposit amount in integer
        boolean error; // check if user input is wrong
        User result; // store the result (new User info from Server)

        /* Update Deposit Limit and Withdraw Limit */
        this.maxDepositLim = userInfo.getDeposit_lim();
        this.maxWithdrawLim = userInfo.getWithdraw_lim();

        /* Switch action dependent on deposit or withdraw transaction*/
        switch (action) {
            case "deposit":

                /* initialize variables */
                txtAmountString = txtAmount.getText(); // get string from input field
                txtAmountInt = -1; // indicate that number conversion is not done
                error = false; // by default there's no error
                result = null; // by default the result is null

                /* Check if user not enter anything or just spaces */
                if (txtAmountString == null || txtAmountString.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter a number in \"Deposit Amount\" field", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // try number conversion from text (String) to integer
                    try {
                        txtAmountInt = Integer.parseInt(txtAmountString);
                    } catch (NumberFormatException ex) {
                        error = true; // indicate that there's an error in conversion
                    }

                    // if there's an error occured
                    if (error) {
                        JOptionPane.showMessageDialog(this, "Please enter a number in \"Deposit Amount\" field.", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                        // check if user enter wrong deposit amount (must be at least 1000 VND, and at most deposit limit)
                    } else if (txtAmountInt < 1000 || txtAmountInt > maxDepositLim) {
                        JOptionPane.showMessageDialog(this, "Please enter a value between 1000 and " + maxDepositLim + " (inclusive).", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // call method in server to execute
                        try {
                            result = iUser.deposit(userInfo, txtAmountInt);
                        } catch (RemoteException ex) {
                            Logger.getLogger(frmDepositWithdraw.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        // if user already reached maximum deposit limit
                        if (result == null) {
                            JOptionPane.showMessageDialog(this, "You have already reached maximum deposit limit!", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                            this.dispose();
                            // if deposit is successful
                        } else if (result.getMoney() != userInfo.getMoney()) {
                            JOptionPane.showMessageDialog(this, "Deposit successfully! \nNew Account Balance: " + result.getMoney() + " VND", "Transaction Completed!", JOptionPane.INFORMATION_MESSAGE);
                            userInfo = result; // update User info
                            /* set new balance */
                            txtBalance.setText(result.getMoney() + " VND");
                            txtBalance1.setText(result.getMoney() + " VND");
                            txtAmount.setText(""); // empty the deposit amount inputted
                            // if deposit failed
                        } else if (result.getDeposit_lim() == userInfo.getDeposit_lim()) {
                            JOptionPane.showMessageDialog(this, "Deposit failed! \nSQL Exception Occured In Server!", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                            // if the total deposit amount in current day exceeds deposit limit (with current deposit amount)
                        } else {
                            JOptionPane.showMessageDialog(this, "Total deposit amount today exceeds limit of " + userInfo.getDeposit_lim() + " VND! \nYou can only deposit at maximum " + result.getDeposit_lim() + " VND more.", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                            this.maxDepositLim = result.getDeposit_lim(); // update the maximum deposit limit
                        }
                    }
                }
                break;

            case "withdraw":

                /* initialize variables */
                txtAmountString = txtAmount.getText(); // get string from input field
                txtAmountInt = -1; // indicate that number conversion is not done
                error = false; // by default there's no error
                result = null; // by default the result is null

                /* Check if user not enter anything or just spaces */
                if (txtAmountString == null || txtAmountString.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter a number in \"Withdraw Amount\" field", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // try number conversion from text (String) to integer
                    try {
                        txtAmountInt = Integer.parseInt(txtAmountString);
                    } catch (NumberFormatException ex) {
                        error = true; // indicate that there's an error in conversion
                    }

                    // if there's an error occured
                    if (error) {
                        JOptionPane.showMessageDialog(this, "Please enter a number in \"Withdraw Amount\" field.", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                        // check if user enter wrong withdraw amount (must be at least 1000 VND, and at most withdraw limit)
                    } else if (maxWithdrawLim > userInfo.getMoney() && (txtAmountInt < 1000 || txtAmountInt > maxWithdrawLim)) {
                        JOptionPane.showMessageDialog(this, "Please enter a value between 1000 and " + userInfo.getMoney() + " (inclusive).", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                    } else if (maxWithdrawLim <= userInfo.getMoney() && txtAmountInt < 1000 || txtAmountInt > maxWithdrawLim) {
                        JOptionPane.showMessageDialog(this, "Please enter a value between 1000 and " + maxWithdrawLim + " (inclusive).", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // call method in server to execute
                        try {
                            result = iUser.withdraw(userInfo, txtAmountInt);
                        } catch (RemoteException ex) {
                            Logger.getLogger(frmDepositWithdraw.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        // if user already reached maximum withdraw limit
                        if (result == null) {
                            JOptionPane.showMessageDialog(this, "You have already reached maximum withdraw limit!", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                            this.dispose();
                            // if withdrawal is successful
                        } else if (result.getMoney() != userInfo.getMoney()) {
                            JOptionPane.showMessageDialog(this, "Withdraw successfully! \nNew Account Balance: " + result.getMoney() + " VND", "Transaction Completed!", JOptionPane.INFORMATION_MESSAGE);
                            userInfo = result; // update User info
                            /* set new balance */
                            txtBalance.setText(result.getMoney() + " VND");
                            txtBalance1.setText(result.getMoney() + " VND");
                            txtAmount.setText(""); // empty the withdraw amount inputted
                            // if withdrawal failed
                        } else if (result.getWithdraw_lim() == userInfo.getWithdraw_lim()) {
                            JOptionPane.showMessageDialog(this, "Withdraw failed! \nSQL Exception Occured In Server!", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                            // if the withdraw amount exceeds current balance
                        } else if (result.getDeposit_lim() == -1) {
                            JOptionPane.showMessageDialog(this, "Withdraw amount exceeds " + userInfo.getMoney() + " VND (your current Balance)! \nYou can only withdraw at maximum " + userInfo.getMoney() + " VND.", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                            this.maxWithdrawLim = result.getWithdraw_lim(); // update the maximum withdraw limit
                            // if the total withdraw amount in current day exceeds withdraw limit (with current withdraw amount)
                        } else {
                            JOptionPane.showMessageDialog(this, "Total withdraw amount today exceeds limit of " + userInfo.getWithdraw_lim() + " VND! \nYou can only withdraw at maximum " + result.getWithdraw_lim() + " VND more.", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                            this.maxWithdrawLim = result.getWithdraw_lim(); // update the maximum withdraw limit
                        }
                    }
                }
                break;
        }


    }//GEN-LAST:event_btnConfirmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuyMobile;
    private javax.swing.JButton btnChangeInfo;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnDeleteAccount;
    private javax.swing.JButton btnDeposit;
    private javax.swing.JButton btnPaytuition;
    private javax.swing.JButton btnTransactionHistory;
    private javax.swing.JButton btnTransfer;
    private javax.swing.JButton btnWithdraw;
    private javax.swing.JDialog dialogDepositWithdraw;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblCurrentBalance;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JPanel panelUser;
    private javax.swing.JPanel pnAccountmanagement;
    private javax.swing.JPanel pnTransaction;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtBalance1;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
