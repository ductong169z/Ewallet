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
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
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

    /* Class variables */
    IUserFunc iUser; // object from IUserFunc to call methods in server
    User userInfo; // store logged in user info
    User newInfo; // store new user info (for changing info)
    String action; // store action of user
    String recPhone; // store recipient phone number
    Map<String, String> schools = new HashMap<>();
    String id_student;
    String id_uni;
    String phoneNum;
    int payOption; // pay option 1 is tuition fee, 2 is mobile card
    int fee;
    /* 3 Transaction Limits */
    int maxDepositLim;
    int maxWithdrawLim;
    int maxTransLim;
    boolean atMaxWithdraw; // flag: user reached max withdraw limit
    boolean atMaxDeposit; // flag: user reached max deposit limit
    boolean atMaxTrans; // flag: user reached max transfer limit
    String[][] icons;

    /* CONSTRUCTOR FOR FORM USER */
    public frmUser(User userInfo) {
        initComponents();

        /* initialize variables */
        this.userInfo = userInfo; // set userInfo
        this.newInfo = new User(); // initialize new user info
        this.maxDepositLim = userInfo.getDeposit_lim(); // set max deposit limit
        this.maxWithdrawLim = userInfo.getWithdraw_lim(); // set max withdraw limit
        this.maxTransLim = userInfo.getTrans_lim(); // set max transfer limit
        this.atMaxWithdraw = false; // max limit not reached yet
        this.atMaxDeposit = false; // max limit not reached yet
        this.atMaxTrans = false; // max limit not reached yet

        this.setLocationRelativeTo(null); // center the form

        try {
            /* Add the icons to the buttons */
            int height = btnDeposit.getHeight(); // button's height
            int width = btnDeposit.getWidth(); // button's width

            /* Add Wibuu Pay Icon */
            BufferedImage wibuuImage = ImageIO.read(new File("Wibuu.png"));
            Image rWibuuImg = wibuuImage.getScaledInstance(iconWibuuPay.getWidth(), iconWibuuPay.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon wibuuIcon = new ImageIcon(rWibuuImg);
            iconWibuuPay.setIcon(wibuuIcon);

            // Add icon for the Deposit Button
            BufferedImage deposit = ImageIO.read(new File("deposit.png"));
            Image resizeDeposit = deposit.getScaledInstance(height, width, Image.SCALE_SMOOTH);
            ImageIcon depositIcon = new ImageIcon(resizeDeposit);
            btnDeposit.setIcon(depositIcon);
            
            // Add icon for the Withdraw Button
            BufferedImage withdraw = ImageIO.read(new File("withdraw.png"));
            Image resizeWithdraw = withdraw.getScaledInstance(height, width, Image.SCALE_SMOOTH);
            ImageIcon withdrawIcon = new ImageIcon(resizeWithdraw);
            btnWithdraw.setIcon(withdrawIcon);

            // Add icon for the Transfer Button
            BufferedImage transfer = ImageIO.read(new File("transfer.png"));
            Image resizeTransfer = transfer.getScaledInstance(height, width, Image.SCALE_SMOOTH);
            ImageIcon transferIcon = new ImageIcon(resizeTransfer);
            btnTransfer.setIcon(transferIcon);

            // Add icon for the Pay Tuition Button
            BufferedImage tuition = ImageIO.read(new File("tuition.png"));
            Image resizeTuition = tuition.getScaledInstance(height, width, Image.SCALE_SMOOTH);
            ImageIcon tuitionIcon = new ImageIcon(resizeTuition);
            btnPaytuition.setIcon(tuitionIcon);

            // Add icon for the Top Up Mobile Button
            BufferedImage card = ImageIO.read(new File("card.png"));
            Image resizeCard = card.getScaledInstance(height, width, Image.SCALE_SMOOTH);
            ImageIcon cardIcon = new ImageIcon(resizeCard);
            btnBuyMobile.setIcon(cardIcon);

            // Add icon for the Change Info Button
            BufferedImage changeInfo = ImageIO.read(new File("changeinfo.png"));
            Image resizeChangeInfo = changeInfo.getScaledInstance(height, width, Image.SCALE_SMOOTH);
            ImageIcon changeInfoIcon = new ImageIcon(resizeChangeInfo);
            btnChangeInfo.setIcon(changeInfoIcon);

            // Add icon for the Change Password Button
            BufferedImage changePass = ImageIO.read(new File("password.png"));
            Image resizechangePass = changePass.getScaledInstance(height, width, Image.SCALE_SMOOTH);
            ImageIcon changePassIcon = new ImageIcon(resizechangePass);
            btnChangePass.setIcon(changePassIcon);

            // Add icon for the Transaction History Button
            BufferedImage history = ImageIO.read(new File("history.png"));
            Image resizeHistory = history.getScaledInstance(height, width, Image.SCALE_SMOOTH);
            ImageIcon historyIcon = new ImageIcon(resizeHistory);
            btnTransactionHistory.setIcon(historyIcon);

            // Add icon for the Delete Account Button
            BufferedImage delete = ImageIO.read(new File("delete.png"));
            Image resizeDelete = delete.getScaledInstance(height, width, Image.SCALE_SMOOTH);
            ImageIcon deleteIcon = new ImageIcon(resizeDelete);
            btnDeleteAccount.setIcon(deleteIcon);

            /* Connects to server */
            iUser = (IUserFunc) Naming.lookup("rmi://localhost:70/UserFunctions");

            /* Display user's full name and balance */
            txtName.setText(userInfo.getFullname());
            txtBalance.setText(String.valueOf(userInfo.getMoney()) + " VND");

            /* Setup the texts on Deposit and Withdraw Dialog */
            txtPhoneNumber.setText(userInfo.getPhone());
            txtCurrentBalance.setText(String.valueOf(userInfo.getMoney()));

            /* Set Icon for the form */
            ImageIcon icon = new ImageIcon("miniWibuu.png");
            this.setIconImage(icon.getImage());
        } catch (NotBoundException | IOException ex) {
            Logger.getLogger(frmUser.class.getName()).log(Level.SEVERE, null, ex);
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
        txtCurrentBalance = new javax.swing.JTextField();
        txtAmount = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        lblVND1 = new javax.swing.JLabel();
        lblVND3 = new javax.swing.JLabel();
        dialogTransfer = new javax.swing.JDialog();
        lblSendPhone = new javax.swing.JLabel();
        lblSendBalance = new javax.swing.JLabel();
        lblTransAmount = new javax.swing.JLabel();
        txtSendPhone = new javax.swing.JTextField();
        txtSendBalance = new javax.swing.JTextField();
        txtTransAmount = new javax.swing.JTextField();
        btnConfirmTransfer = new javax.swing.JButton();
        lblRecPhone = new javax.swing.JLabel();
        txtRecPhone = new javax.swing.JTextField();
        lblSendName = new javax.swing.JLabel();
        txtSendName = new javax.swing.JTextField();
        lblRecName = new javax.swing.JLabel();
        txtRecName = new javax.swing.JTextField();
        lblVND = new javax.swing.JLabel();
        lblVND2 = new javax.swing.JLabel();
        dialogTransPhone = new javax.swing.JDialog();
        lblRecPhoneNum = new javax.swing.JLabel();
        txtRecPhoneNum = new javax.swing.JTextField();
        btnConfirmRecPhone = new javax.swing.JButton();
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
        dialogChangeInfo = new javax.swing.JDialog();
        txtUsername = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        lblFullname = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        rdoFemale = new javax.swing.JRadioButton();
        rdoMale = new javax.swing.JRadioButton();
        txtFullname = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        txtHint = new javax.swing.JTextField();
        dialogConfirm = new javax.swing.JDialog();
        txtPasswordConfirm = new javax.swing.JPasswordField();
        lblPasswordConfirm = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtHintConfirm = new javax.swing.JTextField();
        btnProceed = new javax.swing.JButton();
        dialogChangePass = new javax.swing.JDialog();
        txtHintPass = new javax.swing.JTextField();
        lblNewPassword = new javax.swing.JLabel();
        lblNewPassConfirm = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JPasswordField();
        txtNewPassConfirm = new javax.swing.JPasswordField();
        btnDialogChangePass = new javax.swing.JButton();
        lblOldPassword = new javax.swing.JLabel();
        txtOldPassword = new javax.swing.JPasswordField();
        genderGroup = new javax.swing.ButtonGroup();
        panelUser = new javax.swing.JPanel();
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
        lblDeposit = new javax.swing.JLabel();
        lblWithdraw = new javax.swing.JLabel();
        lblTransfer = new javax.swing.JLabel();
        lblPayTuition = new javax.swing.JLabel();
        lblTopUpMobile = new javax.swing.JLabel();
        pnAccountmanagement = new javax.swing.JPanel();
        btnChangeInfo = new javax.swing.JButton();
        btnDeleteAccount = new javax.swing.JButton();
        btnTransactionHistory = new javax.swing.JButton();
        lblChangeInfo = new javax.swing.JLabel();
        lblDeleteAccount = new javax.swing.JLabel();
        lblTransactionHistory = new javax.swing.JLabel();
        btnChangePass = new javax.swing.JButton();
        lblChangePassword = new javax.swing.JLabel();
        iconWibuuPay = new javax.swing.JLabel();

        lblPhoneNumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPhoneNumber.setText("Your Phone Number");

        lblCurrentBalance.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCurrentBalance.setText("Current Balance");

        txtPhoneNumber.setEditable(false);
        txtPhoneNumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAmount.setText("Deposit Amount");

        txtCurrentBalance.setEditable(false);
        txtCurrentBalance.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnConfirm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnConfirm.setText("Confirm Deposit");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        lblVND1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblVND1.setText("VND");

        lblVND3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblVND3.setText("VND");

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
                            .addComponent(txtPhoneNumber)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogDepositWithdrawLayout.createSequentialGroup()
                                .addGroup(dialogDepositWithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCurrentBalance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                    .addComponent(txtAmount, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dialogDepositWithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblVND1)
                                    .addComponent(lblVND3))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialogDepositWithdrawLayout.setVerticalGroup(
            dialogDepositWithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogDepositWithdrawLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(dialogDepositWithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhoneNumber))
                .addGap(18, 18, 18)
                .addGroup(dialogDepositWithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurrentBalance)
                    .addComponent(txtCurrentBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVND3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(dialogDepositWithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAmount)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVND1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addComponent(btnConfirm)
                .addGap(42, 42, 42))
        );

        dialogTransfer.setTitle("Transfer Transaction");

        lblSendPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSendPhone.setText("Sender Phone Number");

        lblSendBalance.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSendBalance.setText("Current Balance");

        lblTransAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTransAmount.setText("Transfer Amount");

        txtSendPhone.setEditable(false);
        txtSendPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtSendBalance.setEditable(false);
        txtSendBalance.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtTransAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnConfirmTransfer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnConfirmTransfer.setText("Confirm Transfer");
        btnConfirmTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmTransferActionPerformed(evt);
            }
        });

        lblRecPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblRecPhone.setText("Recipient Phone Number");

        txtRecPhone.setEditable(false);
        txtRecPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblSendName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSendName.setText("Sender Full Name");

        txtSendName.setEditable(false);
        txtSendName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblRecName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblRecName.setText("Recipient Full Name");

        txtRecName.setEditable(false);
        txtRecName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblVND.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblVND.setText("VND");

        lblVND2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblVND2.setText("VND");

        javax.swing.GroupLayout dialogTransferLayout = new javax.swing.GroupLayout(dialogTransfer.getContentPane());
        dialogTransfer.getContentPane().setLayout(dialogTransferLayout);
        dialogTransferLayout.setHorizontalGroup(
            dialogTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogTransferLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(dialogTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dialogTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogTransferLayout.createSequentialGroup()
                            .addComponent(lblRecName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtRecName, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(dialogTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(dialogTransferLayout.createSequentialGroup()
                                .addComponent(lblSendName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSendName))
                            .addGroup(dialogTransferLayout.createSequentialGroup()
                                .addGroup(dialogTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRecPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSendPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(dialogTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtSendPhone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRecPhone, javax.swing.GroupLayout.Alignment.LEADING)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogTransferLayout.createSequentialGroup()
                        .addGroup(dialogTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSendBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTransAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(dialogTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTransAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(txtSendBalance))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dialogTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVND)
                            .addComponent(lblVND2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogTransferLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirmTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        dialogTransferLayout.setVerticalGroup(
            dialogTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogTransferLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(dialogTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSendPhone)
                    .addComponent(txtSendPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSendName)
                    .addComponent(txtSendName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRecPhone)
                    .addComponent(txtRecPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRecName)
                    .addComponent(txtRecName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSendBalance)
                    .addComponent(txtSendBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVND2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTransAmount)
                    .addComponent(txtTransAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVND, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57)
                .addComponent(btnConfirmTransfer)
                .addGap(25, 25, 25))
        );

        dialogTransPhone.setTitle("Enter recipient phone number");

        lblRecPhoneNum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblRecPhoneNum.setText("Recipient Phone Number");

        txtRecPhoneNum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtRecPhoneNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecPhoneNumActionPerformed(evt);
            }
        });

        btnConfirmRecPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnConfirmRecPhone.setText("Confirm");
        btnConfirmRecPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmRecPhoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogTransPhoneLayout = new javax.swing.GroupLayout(dialogTransPhone.getContentPane());
        dialogTransPhone.getContentPane().setLayout(dialogTransPhoneLayout);
        dialogTransPhoneLayout.setHorizontalGroup(
            dialogTransPhoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogTransPhoneLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(dialogTransPhoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConfirmRecPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dialogTransPhoneLayout.createSequentialGroup()
                        .addComponent(lblRecPhoneNum, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRecPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        dialogTransPhoneLayout.setVerticalGroup(
            dialogTransPhoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogTransPhoneLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(dialogTransPhoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRecPhoneNum)
                    .addComponent(txtRecPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnConfirmRecPhone)
                .addGap(30, 30, 30))
        );

        dPay.setResizable(false);

        lblNotification.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNotification.setText("<notification>");

        btnPay.setText("Confirm");
        btnPay.setEnabled(false);
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

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

        cbSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        lblInput.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblInput.setText("<Input>:");

        txtInput.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtInputInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

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

        dialogChangeInfo.setTitle("Change Info");

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUsername.setText("Username:");

        lblFullname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblFullname.setText("Fullname:");

        lblGender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblGender.setText("Gender:");

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEmail.setText("Email:");

        lblPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPhone.setText("Phone:");

        lblAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAddress.setText("Address:");

        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        genderGroup.add(rdoFemale);
        rdoFemale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdoFemale.setText("Female");

        genderGroup.add(rdoMale);
        rdoMale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdoMale.setText("Male");

        txtFullname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnOK.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        txtHint.setEditable(false);
        txtHint.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtHint.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHint.setText("Note: Leave a field as is if you don't want to change it!");

        javax.swing.GroupLayout dialogChangeInfoLayout = new javax.swing.GroupLayout(dialogChangeInfo.getContentPane());
        dialogChangeInfo.getContentPane().setLayout(dialogChangeInfoLayout);
        dialogChangeInfoLayout.setHorizontalGroup(
            dialogChangeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogChangeInfoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(dialogChangeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogChangeInfoLayout.createSequentialGroup()
                        .addComponent(lblFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(dialogChangeInfoLayout.createSequentialGroup()
                        .addGroup(dialogChangeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(dialogChangeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dialogChangeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFullname, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtUsername)
                            .addGroup(dialogChangeInfoLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(rdoMale, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdoFemale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(txtHint, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogChangeInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        dialogChangeInfoLayout.setVerticalGroup(
            dialogChangeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogChangeInfoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(txtHint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(dialogChangeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogChangeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFullname)
                    .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogChangeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoMale)
                    .addComponent(rdoFemale)
                    .addComponent(lblGender))
                .addGap(18, 18, 18)
                .addGroup(dialogChangeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addGap(18, 18, 18)
                .addGroup(dialogChangeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhone))
                .addGap(18, 18, 18)
                .addGroup(dialogChangeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btnOK)
                .addGap(45, 45, 45))
        );

        txtPasswordConfirm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblPasswordConfirm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPasswordConfirm.setText("Confirm Password:");

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPassword.setText("Enter Password:");

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtHintConfirm.setEditable(false);
        txtHintConfirm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtHintConfirm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHintConfirm.setText("Please enter your password to confirm changing info");

        btnProceed.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnProceed.setText("Proceed");
        btnProceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogConfirmLayout = new javax.swing.GroupLayout(dialogConfirm.getContentPane());
        dialogConfirm.getContentPane().setLayout(dialogConfirmLayout);
        dialogConfirmLayout.setHorizontalGroup(
            dialogConfirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogConfirmLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(dialogConfirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtHintConfirm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dialogConfirmLayout.createSequentialGroup()
                        .addGroup(dialogConfirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPasswordConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(dialogConfirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPasswordConfirm)
                            .addComponent(txtPassword)))
                    .addComponent(btnProceed))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        dialogConfirmLayout.setVerticalGroup(
            dialogConfirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogConfirmLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(txtHintConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(dialogConfirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogConfirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPasswordConfirm)
                    .addComponent(txtPasswordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnProceed)
                .addGap(40, 40, 40))
        );

        dialogChangePass.setTitle("Change Password");

        txtHintPass.setEditable(false);
        txtHintPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtHintPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHintPass.setText("Please re-enter new password to Confirm field");

        lblNewPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNewPassword.setText("New Password:");

        lblNewPassConfirm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNewPassConfirm.setText("Confirm Password:");

        txtNewPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtNewPassConfirm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnDialogChangePass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDialogChangePass.setText("Change Password");
        btnDialogChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDialogChangePassActionPerformed(evt);
            }
        });

        lblOldPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblOldPassword.setText("Old Password:");

        txtOldPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout dialogChangePassLayout = new javax.swing.GroupLayout(dialogChangePass.getContentPane());
        dialogChangePass.getContentPane().setLayout(dialogChangePassLayout);
        dialogChangePassLayout.setHorizontalGroup(
            dialogChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogChangePassLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(dialogChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtHintPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dialogChangePassLayout.createSequentialGroup()
                        .addGroup(dialogChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblOldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNewPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNewPassConfirm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(dialogChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNewPassConfirm)
                            .addComponent(txtNewPassword)
                            .addComponent(txtOldPassword)))
                    .addComponent(btnDialogChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        dialogChangePassLayout.setVerticalGroup(
            dialogChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogChangePassLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(txtHintPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(dialogChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOldPassword)
                    .addComponent(txtOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNewPassword)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNewPassConfirm)
                    .addComponent(txtNewPassConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnDialogChangePass)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EWallet");

        panelUser.setPreferredSize(new java.awt.Dimension(580, 600));

        lblName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblName.setText("Name:");

        lblBalance.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBalance.setText("Balance:");

        txtName.setEditable(false);
        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtName.setText("<Display Balance>");
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
        btnTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferActionPerformed(evt);
            }
        });

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

        lblDeposit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDeposit.setText("Deposit");

        lblWithdraw.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWithdraw.setText("Withdraw");

        lblTransfer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTransfer.setText("Transfer");

        lblPayTuition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPayTuition.setText("Pay Tuition");

        lblTopUpMobile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTopUpMobile.setText("Top Up Mobile Account");

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
                    .addComponent(lblPayTuition, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTopUpMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnTransactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblTransfer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblWithdraw, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addComponent(lblDeposit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        pnTransactionLayout.setVerticalGroup(
            pnTransactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTransactionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDeposit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnWithdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblWithdraw)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTransfer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPaytuition, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPayTuition)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuyMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTopUpMobile)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pnAccountmanagement.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Account Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 16))); // NOI18N

        btnChangeInfo.setContentAreaFilled(false);
        btnChangeInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeInfoActionPerformed(evt);
            }
        });

        btnDeleteAccount.setContentAreaFilled(false);
        btnDeleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAccountActionPerformed(evt);
            }
        });

        btnTransactionHistory.setContentAreaFilled(false);
        btnTransactionHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransactionHistoryActionPerformed(evt);
            }
        });

        lblChangeInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChangeInfo.setText("Change Info");

        lblDeleteAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDeleteAccount.setText("Delete Account");

        lblTransactionHistory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTransactionHistory.setText("Transaction History");

        btnChangePass.setContentAreaFilled(false);
        btnChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePassActionPerformed(evt);
            }
        });

        lblChangePassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChangePassword.setText("Change Password");

        javax.swing.GroupLayout pnAccountmanagementLayout = new javax.swing.GroupLayout(pnAccountmanagement);
        pnAccountmanagement.setLayout(pnAccountmanagementLayout);
        pnAccountmanagementLayout.setHorizontalGroup(
            pnAccountmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAccountmanagementLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnChangeInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
            .addGroup(pnAccountmanagementLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(pnAccountmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnAccountmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAccountmanagementLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45))
                        .addComponent(lblChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnAccountmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAccountmanagementLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnAccountmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnTransactionHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDeleteAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(45, 45, 45))
                        .addGroup(pnAccountmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTransactionHistory, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(lblDeleteAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblChangeInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        pnAccountmanagementLayout.setVerticalGroup(
            pnAccountmanagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAccountmanagementLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnChangeInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblChangeInfo)
                .addGap(18, 18, 18)
                .addComponent(btnChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblChangePassword)
                .addGap(18, 18, 18)
                .addComponent(btnTransactionHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTransactionHistory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDeleteAccount)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelUserLayout = new javax.swing.GroupLayout(panelUser);
        panelUser.setLayout(panelUserLayout);
        panelUserLayout.setHorizontalGroup(
            panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUserLayout.createSequentialGroup()
                        .addComponent(iconWibuuPay, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBalance, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBalance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelUserLayout.createSequentialGroup()
                        .addComponent(pnTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnAccountmanagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panelUserLayout.setVerticalGroup(
            panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUserLayout.createSequentialGroup()
                .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUserLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBalance)
                            .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUserLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(iconWibuuPay, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnAccountmanagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    /* Code for Button to open WITHDRAW transaction Dialog */
    private void btnWithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWithdrawActionPerformed
        /* Check if user is at max withdraw limit, or user money is less than 1000 */
        if (atMaxWithdraw) {
            JOptionPane.showMessageDialog(dialogDepositWithdraw, "You have reached maximum withdraw limit!", "Withdraw Failed!", JOptionPane.INFORMATION_MESSAGE);
        } else if (userInfo.getMoney() < 1000) {
            JOptionPane.showMessageDialog(dialogDepositWithdraw, "You must have at least 1000 VND to withdraw!", "Withdraw Failed!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            /* Set values on Dialog */
            txtName.setText(userInfo.getFullname());
            txtBalance.setText(String.valueOf(userInfo.getMoney()) + " VND");

            txtPhoneNumber.setText(userInfo.getPhone());
            txtCurrentBalance.setText(String.valueOf(userInfo.getMoney()));

            /* Set Dialog properties */
            dialogDepositWithdraw.setTitle("Withdraw Transaction");
            lblAmount.setText("Withdraw Amount");
            btnConfirm.setText("Confirm Withdraw");

            /* Show the Dialog visible to user, and center it */
            dialogDepositWithdraw.pack(); // display dialog and its subcomponents in preferred size
            dialogDepositWithdraw.setVisible(true); // show up the dialog
            dialogDepositWithdraw.setLocationRelativeTo(null); // center the dialog

            this.action = "withdraw"; // update user action to Withdraw
        }
    }//GEN-LAST:event_btnWithdrawActionPerformed

    /* Code for Button to open DEPOSIT transaction Dialog */
    private void btnDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositActionPerformed
        /* Check if user already at max deposit limit */
        if (atMaxDeposit) {
            JOptionPane.showMessageDialog(this, "You have reached maximum deposit limit!", "Notification", JOptionPane.INFORMATION_MESSAGE);
        } else {
            /* Set values on Dialog */
            txtName.setText(userInfo.getFullname());
            txtBalance.setText(String.valueOf(userInfo.getMoney()) + " VND");

            txtPhoneNumber.setText(userInfo.getPhone());
            txtCurrentBalance.setText(String.valueOf(userInfo.getMoney()));

            /* Set Dialog properties */
            dialogDepositWithdraw.setTitle("Deposit Transaction");
            lblAmount.setText("Deposit Amount");
            btnConfirm.setText("Confirm Deposit");

            /* Show the Dialog visible to user, and center it */
            dialogDepositWithdraw.pack();// display dialog and its subcomponents in preferred size
            dialogDepositWithdraw.setVisible(true); // show up the dialog
            dialogDepositWithdraw.setLocationRelativeTo(null); // center the dialog

            this.action = "deposit";  // update user action to Deposit
        }
    }//GEN-LAST:event_btnDepositActionPerformed

    private void btnTransactionHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransactionHistoryActionPerformed
        try {
            new frmReport(4, userInfo).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frmUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnTransactionHistoryActionPerformed

    private void btnPaytuitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaytuitionActionPerformed
        // TODO add your handling code here:
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
            dPay.setLocationRelativeTo(null);
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
        dPay.setLocationRelativeTo(null);
        payOption = 2;
        dPay.setVisible(true);
    }//GEN-LAST:event_btnBuyMobileActionPerformed

    /* Code for Button to confirm DEPOSIT/WITHDRAW transaction */
    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        String txtAmountString; // deposit/withdraw amount in String
        int txtAmountInt; // deposit/withdraw amount in integer
        boolean error; // check if user input is wrong
        User result; // store the result (new User info from Server)

        /* Update Deposit Limit and Withdraw Limit */
        this.maxDepositLim = userInfo.getDeposit_lim();
        this.maxWithdrawLim = userInfo.getWithdraw_lim();

        /* Switch action dependent on deposit or withdraw transaction */
        switch (action) {
            case "deposit":

                /* initialize variables */
                txtAmountString = txtAmount.getText(); // string from amount field
                txtAmountInt = -1; // store amount of deposit/withdraw in integer
                error = false; // check if there is any error (by default there's no error)
                result = null; // store User object returned by server (by default the result is null)

                /* Check if user not enter anything or just spaces */
                if (txtAmountString == null || txtAmountString.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(dialogDepositWithdraw, "Please enter a number in \"Deposit Amount\" field. \n(Not bigger than 2147483647)", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // try number conversion from text (String) to integer
                    try {
                        txtAmountInt = Integer.parseInt(txtAmountString);
                    } catch (NumberFormatException ex) {
                        error = true; // indicate that there's an error in conversion
                    }

                    // if there's an error occured
                    if (error) {
                        JOptionPane.showMessageDialog(dialogDepositWithdraw, "Please enter a number in \"Deposit Amount\" field. \n(Not bigger than 2147483647)", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                        // check if user enter wrong deposit amount (less than 1000 VND, or more than maximum transfer limit)
                    } else if (txtAmountInt < 1000 || txtAmountInt > maxDepositLim) {
                        JOptionPane.showMessageDialog(dialogDepositWithdraw, "Please enter a value between 1000 and " + maxDepositLim + " (inclusive).", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                        // if user input is correct
                    } else {
                        // call method in server to execute
                        try {
                            result = iUser.deposit(userInfo, txtAmountInt);
                        } catch (RemoteException ex) {
                            Logger.getLogger(frmUser.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        // if user already reached maximum deposit limit
                        if (result == null) {
                            JOptionPane.showMessageDialog(dialogDepositWithdraw, "You have already reached maximum deposit limit!", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                            dialogDepositWithdraw.dispose(); // dispose the dialog
                            atMaxDeposit = true;
                            // if deposit is successful
                        } else if (result.getMoney() != userInfo.getMoney()) {
                            JOptionPane.showMessageDialog(dialogDepositWithdraw, "Deposit successfully! \nNew Account Balance: " + result.getMoney() + " VND", "Transaction Completed!", JOptionPane.INFORMATION_MESSAGE);

                            userInfo = result; // update User info

                            /* set new balance */
                            txtBalance.setText(String.valueOf(userInfo.getMoney()) + " VND");
                            txtCurrentBalance.setText(String.valueOf(userInfo.getMoney()));

                            txtAmount.setText(""); // empty the deposit amount inputted
                            // if deposit failed
                        } else if (result.getDeposit_lim() == userInfo.getDeposit_lim()) {
                            JOptionPane.showMessageDialog(dialogDepositWithdraw, "Deposit failed! \nSQL Exception Occured In Server!", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                            // if the total deposit amount in current day exceeds deposit limit (with current deposit amount)
                        } else {
                            JOptionPane.showMessageDialog(dialogDepositWithdraw, "Total deposit amount today exceeds limit of " + userInfo.getDeposit_lim() + " VND! \nYou can only deposit at maximum " + result.getDeposit_lim() + " VND more.", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                            this.maxDepositLim = result.getDeposit_lim(); // update the maximum deposit limit
                        }
                    }
                }
                break;

            case "withdraw":

                /* initialize variables */
                txtAmountString = txtAmount.getText(); // string from amount field
                txtAmountInt = -1; // store amount of deposit/withdraw in integer
                error = false; // check if there is any error (by default there's no error)
                result = null; // store User object returned by server (by default the result is null)

                /* Check if user not enter anything or just spaces */
                if (txtAmountString == null || txtAmountString.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(dialogDepositWithdraw, "Please enter a number in \"Withdraw Amount\" field. \n(Not bigger than 2147483647)", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // try number conversion from text (String) to integer
                    try {
                        txtAmountInt = Integer.parseInt(txtAmountString);
                    } catch (NumberFormatException ex) {
                        error = true; // indicate that there's an error in conversion
                    }

                    // if there's an error occured
                    if (error) {
                        JOptionPane.showMessageDialog(dialogDepositWithdraw, "Please enter a number in \"Withdraw Amount\" field. \n(Not bigger than 2147483647)", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                        // check if user enter wrong withdraw amount (less than 1000 VND, or more than maximium withdraw limit) - in case user money less than max withdraw limit
                    } else if (maxWithdrawLim > userInfo.getMoney() && (txtAmountInt < 1000 || txtAmountInt > maxWithdrawLim)) {
                        JOptionPane.showMessageDialog(dialogDepositWithdraw, "Please enter a value between 1000 and " + userInfo.getMoney() + " (inclusive).", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                        // check if user enter wrong withdraw amount (less than 1000 VND, or more than maximium withdraw limit) - in case user money is equal or more than max withdraw limit
                    } else if (maxWithdrawLim <= userInfo.getMoney() && txtAmountInt < 1000 || txtAmountInt > maxWithdrawLim) {
                        JOptionPane.showMessageDialog(dialogDepositWithdraw, "Please enter a value between 1000 and " + maxWithdrawLim + " (inclusive).", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                        // if user input is correct
                    } else {
                        // call method in server to execute
                        try {
                            result = iUser.withdraw(userInfo, txtAmountInt, "");
                        } catch (RemoteException ex) {
                            Logger.getLogger(frmUser.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        // if user already reached maximum withdraw limit
                        if (result == null) {
                            JOptionPane.showMessageDialog(dialogDepositWithdraw, "You have already reached maximum withdraw limit!", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                            dialogDepositWithdraw.dispose(); // dispose the dialog
                            atMaxWithdraw = true;
                            // if withdrawal is successful
                        } else if (result.getMoney() != userInfo.getMoney()) {
                            JOptionPane.showMessageDialog(dialogDepositWithdraw, "Withdraw successfully! \nNew Account Balance: " + result.getMoney() + " VND", "Transaction Completed!", JOptionPane.INFORMATION_MESSAGE);

                            userInfo = result; // update User info

                            /* set new balance */
                            txtBalance.setText(String.valueOf(userInfo.getMoney()) + " VND");
                            txtCurrentBalance.setText(String.valueOf(userInfo.getMoney()));

                            txtAmount.setText(""); // empty the withdraw amount inputted
                            // if withdrawal failed
                        } else if (result.getWithdraw_lim() == userInfo.getWithdraw_lim()) {
                            JOptionPane.showMessageDialog(dialogDepositWithdraw, "Withdraw failed! \nSQL Exception Occured In Server!", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                            // if the withdraw amount exceeds current balance
                        } else if (result.getDeposit_lim() == -1) {
                            JOptionPane.showMessageDialog(dialogDepositWithdraw, "Withdraw amount exceeds " + userInfo.getMoney() + " VND (your current Balance)! \nYou can only withdraw at maximum " + userInfo.getMoney() + " VND.", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                            this.maxWithdrawLim = result.getWithdraw_lim(); // update the maximum withdraw limit
                            // if the total withdraw amount in current day exceeds withdraw limit (with current withdraw amount)
                        } else {
                            JOptionPane.showMessageDialog(dialogDepositWithdraw, "Total withdraw amount today exceeds limit of " + userInfo.getWithdraw_lim() + " VND! \nYou can only withdraw at maximum " + result.getWithdraw_lim() + " VND more.", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                            this.maxWithdrawLim = result.getWithdraw_lim(); // update the maximum withdraw limit
                        }
                    }
                }
                break;
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    /* Code for Button to confirm TRANSFER transaction */
    private void btnConfirmTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmTransferActionPerformed
        /* initialize variables */
        String txtAmountString = txtTransAmount.getText(); // string from amount field
        int txtAmountInt = -1; // store amount of transfer in integer
        boolean error = false; // check if there is any error (by default there's no error)
        User result = null; // store User object returned by server (by default the result is null)

        /* Update Transfer Limit */
        this.maxTransLim = userInfo.getTrans_lim();

        /* Check if user not enter anything or just spaces */
        if (txtAmountString == null || txtAmountString.trim().isEmpty()) {
            JOptionPane.showMessageDialog(dialogTransfer, "Please enter a number in \"Transfer Amount\" field. \n(Not bigger than 2147483647)", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // try number conversion from text (String) to integer
            try {
                txtAmountInt = Integer.parseInt(txtAmountString);
            } catch (NumberFormatException ex) {
                error = true; // indicate that there's an error in conversion
            }

            // if there's an error occured
            if (error) {
                JOptionPane.showMessageDialog(dialogTransfer, "Please enter a number in \"Withdraw Amount\" field. \n(Not bigger than 2147483647)", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                // check if user enter wrong transfer amount (less than 1000 VND, or more than maximimum transfer limit) - in case user money less than max transfer limit
            } else if (maxTransLim > userInfo.getMoney() && (txtAmountInt < 1000 || txtAmountInt > maxTransLim)) {
                JOptionPane.showMessageDialog(dialogTransfer, "Please enter a value between 1000 and " + userInfo.getMoney() + " (inclusive).", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                // check if user enter wrong transfer amount (less than 1000 VND, or more than maximimum transfer limit) - in case user money is equal or more than max transfer limit
            } else if (maxTransLim <= userInfo.getMoney() && txtAmountInt < 1000 || txtAmountInt > maxTransLim) {
                JOptionPane.showMessageDialog(dialogTransfer, "Please enter a value between 1000 and " + maxTransLim + " (inclusive).", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                // if user input is correct
            } else {
                // call method in server to execute
                try {
                    result = iUser.transfer(userInfo, recPhone, txtAmountInt);
                } catch (RemoteException ex) {
                    Logger.getLogger(frmUser.class.getName()).log(Level.SEVERE, null, ex);
                }

                // if user already reached maximum transfer limit
                if (result == null) {
                    JOptionPane.showMessageDialog(dialogTransfer, "You have already reached maximum transfer limit!", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                    dialogTransfer.dispose(); // hides the dialog
                    atMaxTrans = true;
                    // if transfer is successful
                } else if (result.getMoney() != userInfo.getMoney()) {
                    JOptionPane.showMessageDialog(dialogTransfer, "Transfer successfully! \nNew Account Balance: " + result.getMoney() + " VND", "Transaction Completed!", JOptionPane.INFORMATION_MESSAGE);
                    userInfo = result; // update User info

                    /* set new balance */
                    txtBalance.setText(String.valueOf(userInfo.getMoney()) + " VND");
                    txtSendBalance.setText(String.valueOf(userInfo.getMoney()));

                    txtTransAmount.setText(""); // empty the transfer amount inputted
                    // if transfer failed
                } else if (result.getTrans_lim() == userInfo.getTrans_lim()) {
                    JOptionPane.showMessageDialog(dialogTransfer, "Transfer failed! \nSQL Exception Occured In Server!", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                    // if the transfer amount exceeds current balance
                } else if (result.getDeposit_lim() == -1) {
                    JOptionPane.showMessageDialog(dialogTransfer, "Transfer amount exceeds " + userInfo.getMoney() + " VND (your current Balance)! \nYou can only transfer at maximum " + userInfo.getMoney() + " VND.", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                    this.maxTransLim = result.getTrans_lim(); // update the maximum transfer limit
                    // if the total transfer amount in current day exceeds transfer limit (with current transfer amount)
                } else {
                    JOptionPane.showMessageDialog(dialogTransfer, "Total transfer amount today exceeds limit of " + userInfo.getTrans_lim() + " VND! \nYou can only transfer at maximum " + result.getTrans_lim() + " VND more.", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                    this.maxTransLim = result.getTrans_lim(); // update the maximum transfer limit
                }
            }
        }
    }//GEN-LAST:event_btnConfirmTransferActionPerformed

    private void btnConfirmRecPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmRecPhoneActionPerformed
        /* Check if recipient phone is entered correctly */
        if (txtRecPhoneNum.getText() == null || txtRecPhoneNum.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(dialogTransPhone, "Please enter a valid phone number of 10 digits", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
        } else if (!txtRecPhoneNum.getText().matches("(\\+84)[1-9][0-9]{8}") && !txtRecPhoneNum.getText().matches("(0)[1-9][0-9]{8}")) {
            JOptionPane.showMessageDialog(dialogTransPhone, "Please enter a valid phone number of 10 digits", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
        } else if (txtRecPhoneNum.getText().equals(userInfo.getPhone())) {
            JOptionPane.showMessageDialog(dialogTransPhone, "You cannot transfer money to yourself", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
        } else {
            User recUser = null; // store user returned from database
            recPhone = txtRecPhoneNum.getText(); // set recipient phone

            try {
                recUser = iUser.getUser(recPhone);
            } catch (RemoteException ex) {
                Logger.getLogger(frmUser.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (recUser == null) {
                JOptionPane.showMessageDialog(dialogTransPhone, "The inputted phone number doesn't exist in database!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
            } else if (recUser.getFullname() == null) {
                JOptionPane.showMessageDialog(dialogTransPhone, "SQL Exception Occured on server side!", "Server-side Error!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                /* set the information on dialog */
                txtSendName.setText(userInfo.getFullname());
                txtSendPhone.setText(userInfo.getPhone());
                txtRecName.setText(recUser.getFullname());
                txtRecPhone.setText(recPhone);
                txtSendBalance.setText(String.valueOf(userInfo.getMoney()));

                dialogTransfer.pack(); // display dialog and its subcomponents in preferred size
                dialogTransfer.setVisible(true); // show up the dialog
                dialogTransfer.setLocationRelativeTo(null); // center the dialog
                dialogTransPhone.dispose(); // dispose the dialog
            }
        }
    }//GEN-LAST:event_btnConfirmRecPhoneActionPerformed

    private void txtRecPhoneNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecPhoneNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRecPhoneNumActionPerformed

    private void btnTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferActionPerformed
        /* Check if user is at max transfer limit, or user money is less than 1000 */
        if (atMaxTrans) {
            JOptionPane.showMessageDialog(this, "You have reached maximum transfer limit!", "Transfer Failed!", JOptionPane.INFORMATION_MESSAGE);
        } else if (userInfo.getMoney() < 1000) {
            JOptionPane.showMessageDialog(this, "You must have at least 1000 VND to transfer money!", "Transfer Failed!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            dialogTransPhone.pack();// display dialog and its subcomponents in preferred size

            dialogTransPhone.setVisible(true); // show up the dialog
            dialogTransPhone.setLocationRelativeTo(null); // center the dialog
        }
    }//GEN-LAST:event_btnTransferActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        // TODO add your handling code here:
        User result = null;
        this.maxWithdrawLim = userInfo.getWithdraw_lim();

        if (payOption == 1) {

            if (userInfo.getMoney() < fee) {
                JOptionPane.showMessageDialog(dPay, "You Dont Have Enough Money");
                dPay.dispose();
            } else {
                try {
                    result = iUser.withdraw(userInfo, fee, lblNotification.getText() + " " + lblNotification1.getText());
                    // if user already reached maximum withdraw limit
                    if (result == null) {
                        JOptionPane.showMessageDialog(dPay, "You have already reached maximum withdraw limit!", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                        dPay.dispose(); // hides the dialog
                        atMaxWithdraw = true;
                        // if withdrawal is successful
                    } else if (result.getMoney() != userInfo.getMoney()) {
                        boolean check = iUser.payTuition(id_uni, id_student);
                        if (check == true) {
                            JOptionPane.showMessageDialog(dPay, "Paid Successfully");
                            userInfo = result; // update User info

                            /* set new balance */
                            txtBalance.setText(String.valueOf(userInfo.getMoney()) + " VND");
                            txtCurrentBalance.setText(String.valueOf(userInfo.getMoney()));
                        } else {
                            JOptionPane.showMessageDialog(dPay, "Some Error Occur!!! \nPlease Try Again!!!");
                        }
                        // if withdrawal failed
                    } else if (result.getWithdraw_lim() == userInfo.getWithdraw_lim()) {
                        JOptionPane.showMessageDialog(dPay, "Withdraw failed! \nSQL Exception Occured In Server!", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                        // if the withdraw amount exceeds current balance
                    } else if (result.getDeposit_lim() == -1) {
                        JOptionPane.showMessageDialog(dPay, "Withdraw amount exceeds " + userInfo.getMoney() + " VND (your current Balance)! \nYou can only withdraw at maximum " + userInfo.getMoney() + " VND.", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                        this.maxWithdrawLim = result.getWithdraw_lim(); // update the maximum withdraw limit
                        // if the total withdraw amount in current day exceeds withdraw limit (with current withdraw amount)
                    } else {
                        JOptionPane.showMessageDialog(dPay, "Total withdraw amount today exceeds limit of " + userInfo.getWithdraw_lim() + " VND! \nYou can only withdraw at maximum " + result.getWithdraw_lim() + " VND more.", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                        this.maxWithdrawLim = result.getWithdraw_lim(); // update the maximum withdraw limit
                    }
                    dPay.dispose();
                } catch (RemoteException ex) {
                    Logger.getLogger(frmUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (payOption == 2) {
            if (userInfo.getMoney() < fee) {
                JOptionPane.showMessageDialog(dPay, "You Dont Have Enough Money");
                dPay.dispose();
            } else {
                try {
                    result = iUser.withdraw(userInfo, fee, lblNotification.getText() + " " + lblNotification1.getText());
                    // if user already reached maximum withdraw limit
                    if (result == null) {
                        JOptionPane.showMessageDialog(dPay, "You have already reached maximum withdraw limit!", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                        dPay.dispose(); // hides the dialog
                        atMaxWithdraw = true;
                        // if withdrawal is successful
                    } else if (result.getMoney() != userInfo.getMoney()) {
                        JOptionPane.showMessageDialog(dPay, "Paid Successfully");
                        userInfo = result; // update User info

                        /* set new balance */
                        txtBalance.setText(String.valueOf(userInfo.getMoney()) + " VND");
                        txtCurrentBalance.setText(String.valueOf(userInfo.getMoney()));

                        // if withdrawal failed
                    } else if (result.getWithdraw_lim() == userInfo.getWithdraw_lim()) {
                        JOptionPane.showMessageDialog(dPay, "Withdraw failed! \nSQL Exception Occured In Server!", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                        // if the withdraw amount exceeds current balance
                    } else if (result.getDeposit_lim() == -1) {
                        JOptionPane.showMessageDialog(dPay, "Withdraw amount exceeds " + userInfo.getMoney() + " VND (your current Balance)! \nYou can only withdraw at maximum " + userInfo.getMoney() + " VND.", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                        this.maxWithdrawLim = result.getWithdraw_lim(); // update the maximum withdraw limit
                        // if the total withdraw amount in current day exceeds withdraw limit (with current withdraw amount)
                    } else {
                        JOptionPane.showMessageDialog(dPay, "Total withdraw amount today exceeds limit of " + userInfo.getWithdraw_lim() + " VND! \nYou can only withdraw at maximum " + result.getWithdraw_lim() + " VND more.", "Transaction Failed!", JOptionPane.INFORMATION_MESSAGE);
                        this.maxWithdrawLim = result.getWithdraw_lim(); // update the maximum withdraw limit
                    }
                    dPay.dispose();
                } catch (RemoteException ex) {
                    Logger.getLogger(frmUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        // TODO add your handling code here:
        if (atMaxWithdraw) {
            JOptionPane.showMessageDialog(dPay, "You have reached maximum withdraw limit!", "Notification", JOptionPane.INFORMATION_MESSAGE);
        } else {
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
                    } else {
                        JOptionPane.showMessageDialog(dPay, "You dont have enough money");
                    }
                } else {
                    JOptionPane.showMessageDialog(dPay, "Please Input Right Format of Phone Number!!!!");
                }
            }
        }
    }//GEN-LAST:event_btnCheckActionPerformed

    private void txtInputInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtInputInputMethodTextChanged

    }//GEN-LAST:event_txtInputInputMethodTextChanged

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        /* Check if all fields are entered correctly */
        if (txtUsername.getText() == null || txtUsername.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(dialogChangeInfo, "The username must not be null or empty!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
        } else if (txtFullname.getText() == null || txtFullname.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(dialogChangeInfo, "The full name field must not be null or empty!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
        } else if (txtEmail.getText() == null || txtEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(dialogChangeInfo, "The email field must not be null or empty!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
        } else if (txtPhone.getText() == null || txtPhone.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(dialogChangeInfo, "The phone field must not be null or empty!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
        } else if (!txtPhone.getText().matches("(\\+84)[1-9][0-9]{8}") && !txtPhone.getText().matches("[0][1-9][0-9]{8}")) {
            JOptionPane.showMessageDialog(dialogChangeInfo, "Please enter a valid phone number of 10 digits", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
            /* In case user input is correct */
        } else {
            /* Temp variables to store values from the fields user inputted */
            newInfo.setUsername(txtUsername.getText().trim());
            newInfo.setFullname(txtFullname.getText().trim());
            newInfo.setMail(txtEmail.getText().trim());
            newInfo.setPhone(txtPhone.getText().trim());
            newInfo.setGender(rdoMale.isSelected() ? "Male" : "Female");
            newInfo.setAddress(txtAddress.getText().trim());

            dialogConfirm.pack(); // display dialog and its subcomponents in preferred size

            dialogConfirm.setVisible(true); // show up the dialog
            dialogConfirm.setLocationRelativeTo(null); // center the dialog
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedActionPerformed
        /* Switch action dependent on "change info" or "delete account" function*/
        switch (action) {
            case "changeinfo":
                /* Check if password and password confirmation are all entered correctly*/
                if (String.valueOf(txtPassword.getPassword()) == null || String.valueOf(txtPassword.getPassword()).trim().isEmpty()) {
                    JOptionPane.showMessageDialog(dialogConfirm, "The password must not be null or empty!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                } else if (String.valueOf(txtPasswordConfirm.getPassword()) == null || String.valueOf(txtPasswordConfirm.getPassword()).trim().isEmpty()) {
                    JOptionPane.showMessageDialog(dialogConfirm, "The password confirmation must not be null or empty!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                } else if (!String.valueOf(txtPasswordConfirm.getPassword()).equals(String.valueOf(txtPassword.getPassword()))) {
                    JOptionPane.showMessageDialog(dialogConfirm, "The password confirmation must match the password!", "Input Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    User result = null; // store return user from server

                    // call method on server to execute
                    try {
                        result = iUser.changeInfo(userInfo, newInfo.getUsername(), String.valueOf(txtPassword.getPassword()), newInfo.getFullname(), newInfo.getPhone(), newInfo.getMail(), newInfo.getAddress(), newInfo.getGender());
                    } catch (RemoteException ex) {
                        Logger.getLogger(frmUser.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    /* Dependent on result, print out messages and perform actions appropriately */
                    // if password is incorrect
                    if (result == null) {
                        JOptionPane.showMessageDialog(dialogConfirm, "Password is incorrect! \nPlease enter your password again!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                    } else if (result.getPhone() == null) {
                        JOptionPane.showMessageDialog(dialogConfirm, "SQL Exception Occured on Server Side!", "Changing Info Failed!", JOptionPane.ERROR_MESSAGE);
                    } else if (result.getPhone().equals("-1")) {
                        JOptionPane.showMessageDialog(dialogConfirm, "The inputted phone number \"" + txtPhone.getText() + "\" already exists in database! \nPlease input another number!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                        dialogConfirm.dispose();
                    } else if (result.getUsername().equals("-1")) {
                        JOptionPane.showMessageDialog(dialogConfirm, "The inputted username \"" + txtUsername.getText() + "\" already exists in database! \nPlease input another username!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                        dialogConfirm.dispose();
                    } else if (result.getUsername().equalsIgnoreCase("Error")) {
                        JOptionPane.showMessageDialog(dialogConfirm, "Encrypting Password Error on Server Side!", "Changing Info Failed!", JOptionPane.ERROR_MESSAGE);
                    } else {
                        /* In case operation successful */
                        JOptionPane.showMessageDialog(dialogConfirm, "Your info has been updated!", "Changing Info Successfully!", JOptionPane.INFORMATION_MESSAGE);

                        userInfo = result; // update user info on client side
                        txtName.setText(userInfo.getFullname()); // update user name on form
                        /* Dispose the two dialog used for changing info */
                        dialogConfirm.dispose();
                        dialogChangeInfo.dispose();
                    }
                }

                break;

            case "delete":
                /* Check if password and password confirmation are all entered correctly*/
                if (String.valueOf(txtPassword.getPassword()) == null || String.valueOf(txtPassword.getPassword()).trim().isEmpty()) {
                    JOptionPane.showMessageDialog(dialogConfirm, "The password must not be null or empty!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                } else if (String.valueOf(txtPasswordConfirm.getPassword()) == null || String.valueOf(txtPasswordConfirm.getPassword()).trim().isEmpty()) {
                    JOptionPane.showMessageDialog(dialogConfirm, "The password confirmation must not be null or empty!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
                } else if (!String.valueOf(txtPasswordConfirm.getPassword()).equals(String.valueOf(txtPassword.getPassword()))) {
                    JOptionPane.showMessageDialog(dialogConfirm, "The password confirmation must match the password!", "Input Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int choice = JOptionPane.showConfirmDialog(dialogConfirm, "Do you really want to delete your account?", "Confirmation", JOptionPane.YES_NO_OPTION);

                    if (choice == JOptionPane.YES_OPTION) {
                        int result = -1; // store result of operation

                        // call deleteAccount method from server to execute
                        try {
                            result = iUser.deleteAccount(userInfo, String.valueOf(txtPassword.getPassword()));
                        } catch (RemoteException ex) {
                            Logger.getLogger(frmUser.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        /* Dependent on result, print out messages and perform actions */
                        switch (result) {
                            /* In case operation successful */
                            case 0:
                                JOptionPane.showMessageDialog(dialogConfirm, "Thank you for using our service!", "Delete User Successfully!", JOptionPane.INFORMATION_MESSAGE);
                                System.exit(0);

                            /* Other cases (unsuccessful or error occured) */
                            case 1:
                                JOptionPane.showMessageDialog(dialogConfirm, "SQL Exception Occured on Server Side!", "Delete User Failed!", JOptionPane.ERROR_MESSAGE);
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(dialogConfirm, "Encrypting Password Error on Server Side!", "Delete User Failed!", JOptionPane.ERROR_MESSAGE);
                                break;
                            default:
                                JOptionPane.showMessageDialog(dialogConfirm, "The inputted password is incorrect! \nDelete Account Aborted!", "Delete User Failed!", JOptionPane.ERROR_MESSAGE);
                                break;
                        }
                    } else {
                        /* In case user don't want to delete account */
                        dialogConfirm.dispose(); // closes the dialog
                    }

                    break;
                }
        }

        /* clear the password fields */
        txtPassword.setText("");
        txtPasswordConfirm.setText("");
    }//GEN-LAST:event_btnProceedActionPerformed

    private void btnChangeInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeInfoActionPerformed
        /* Set old info to the dialog */
        txtUsername.setText(userInfo.getUsername());
        txtFullname.setText(userInfo.getFullname());
        txtEmail.setText(userInfo.getMail());
        txtPhone.setText(userInfo.getPhone());
        txtAddress.setText(userInfo.getAddress());
        if (userInfo.getGender().equals("Male")) {
            rdoMale.setSelected(true);
        } else {
            rdoFemale.setSelected(true);
        }

        /* Clear the password fields in dialog */
        txtPassword.setText("");
        txtPasswordConfirm.setText("");

        /* Update dialog properties */
        dialogConfirm.setTitle("Confirm Info Change");
        txtHintConfirm.setText("Please enter your password to confirm changing info");
        this.action = "changeinfo"; // update action

        dialogChangeInfo.pack();// display dialog and its subcomponents in preferred size
        dialogChangeInfo.setVisible(true); // show up the dialog
        dialogChangeInfo.setLocationRelativeTo(null); // center the dialog
    }//GEN-LAST:event_btnChangeInfoActionPerformed

    private void btnDeleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAccountActionPerformed
        /* Update dialog properties */
        dialogConfirm.setTitle("Delete Account Confirmation");
        txtHintConfirm.setText("Please enter your password to confirm deleting account");
        this.action = "delete"; // update user action

        /* Clear the password fields in dialog */
        txtPassword.setText("");
        txtPasswordConfirm.setText("");

        dialogConfirm.pack(); // display dialog and its subcomponents in preferred size
        dialogConfirm.setVisible(true); // show up the dialog
        dialogConfirm.setLocationRelativeTo(null); // center the dialog
    }//GEN-LAST:event_btnDeleteAccountActionPerformed
    private void btnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassActionPerformed
        /* Empty the password fields */
        txtOldPassword.setText("");
        txtNewPassword.setText("");
        txtNewPassConfirm.setText("");

        dialogChangePass.pack(); // display dialog and its subcomponents in preferred size
        dialogChangePass.setVisible(true); // show up the dialog
        dialogChangePass.setLocationRelativeTo(null); // center the dialog
    }//GEN-LAST:event_btnChangePassActionPerformed

    private void btnDialogChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDialogChangePassActionPerformed
        /* Check if old password, new password and confirmation are all entered correctly*/
        if (String.valueOf(txtOldPassword.getPassword()) == null || String.valueOf(txtOldPassword.getPassword()).trim().isEmpty()) {
            JOptionPane.showMessageDialog(dialogChangePass, "Please enter your old password!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
        } else if (String.valueOf(txtNewPassword.getPassword()) == null || String.valueOf(txtNewPassword.getPassword()).trim().isEmpty()) {
            JOptionPane.showMessageDialog(dialogChangePass, "Please enter your new password!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
        } else if (String.valueOf(txtNewPassConfirm.getPassword()) == null || String.valueOf(txtNewPassConfirm.getPassword()).trim().isEmpty()) {
            JOptionPane.showMessageDialog(dialogChangePass, "Please confirm your new password!", "Input Notification", JOptionPane.INFORMATION_MESSAGE);
        } else if (!String.valueOf(txtNewPassword.getPassword()).equals(String.valueOf(txtNewPassConfirm.getPassword()))) {
            JOptionPane.showMessageDialog(dialogChangePass, "The new password confirmation must match the new password!", "Input Error", JOptionPane.ERROR_MESSAGE);
        } else if (String.valueOf(txtOldPassword.getPassword()).equals(String.valueOf(txtNewPassword.getPassword()))) {
            JOptionPane.showMessageDialog(dialogChangePass, "The new password cannot be the same as old password!", "Input Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int result = -1; // store result of operation

            // call changePassword method from server to execute
            try {
                result = iUser.changePassword(userInfo, String.valueOf(txtOldPassword.getPassword()), String.valueOf(txtNewPassword.getPassword()));
            } catch (RemoteException ex) {
                Logger.getLogger(frmUser.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(dialogChangePass, "Remote Exception Occured!", "Change Password Failed", JOptionPane.ERROR_MESSAGE);
            }

            /* Dependent on result, print out messages and perform actions */
            switch (result) {
                /* In case operation successful */
                case 0:
                    JOptionPane.showMessageDialog(dialogChangePass, "Your password has been updated!", "Change Password Successfully", JOptionPane.INFORMATION_MESSAGE);
                    dialogChangePass.dispose();
                    break;

                /* Other cases (unsuccessful or error) */
                case 1:
                    JOptionPane.showMessageDialog(dialogChangePass, "SQL Exception Occured on Server Side!", "Change Password Failed!", JOptionPane.ERROR_MESSAGE);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(dialogChangePass, "Encrypting Password Error on Server Side!", "Change Password Failed!", JOptionPane.ERROR_MESSAGE);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(dialogChangePass, "Your old password is incorrect!", "Change Password Failed!", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }

    }//GEN-LAST:event_btnDialogChangePassActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuyMobile;
    private javax.swing.JButton btnChangeInfo;
    private javax.swing.JButton btnChangePass;
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnConfirmRecPhone;
    private javax.swing.JButton btnConfirmTransfer;
    private javax.swing.JButton btnDeleteAccount;
    private javax.swing.JButton btnDeposit;
    private javax.swing.JButton btnDialogChangePass;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnPaytuition;
    private javax.swing.JButton btnProceed;
    private javax.swing.JButton btnTransactionHistory;
    private javax.swing.JButton btnTransfer;
    private javax.swing.JButton btnWithdraw;
    private javax.swing.JComboBox<String> cbSelection;
    private javax.swing.JDialog dPay;
    private javax.swing.JDialog dialogChangeInfo;
    private javax.swing.JDialog dialogChangePass;
    private javax.swing.JDialog dialogConfirm;
    private javax.swing.JDialog dialogDepositWithdraw;
    private javax.swing.JDialog dialogTransPhone;
    private javax.swing.JDialog dialogTransfer;
    private javax.swing.ButtonGroup genderGroup;
    private javax.swing.JLabel iconWibuuPay;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblChangeInfo;
    private javax.swing.JLabel lblChangePassword;
    private javax.swing.JLabel lblCurrentBalance;
    private javax.swing.JLabel lblDeleteAccount;
    private javax.swing.JLabel lblDeposit;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFullname;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblInput;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNewPassConfirm;
    private javax.swing.JLabel lblNewPassword;
    private javax.swing.JLabel lblNotification;
    private javax.swing.JLabel lblNotification1;
    private javax.swing.JLabel lblOldPassword;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPasswordConfirm;
    private javax.swing.JLabel lblPayTuition;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblRecName;
    private javax.swing.JLabel lblRecPhone;
    private javax.swing.JLabel lblRecPhoneNum;
    private javax.swing.JLabel lblSelection;
    private javax.swing.JLabel lblSendBalance;
    private javax.swing.JLabel lblSendName;
    private javax.swing.JLabel lblSendPhone;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTopUpMobile;
    private javax.swing.JLabel lblTransAmount;
    private javax.swing.JLabel lblTransactionHistory;
    private javax.swing.JLabel lblTransfer;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblVND;
    private javax.swing.JLabel lblVND1;
    private javax.swing.JLabel lblVND2;
    private javax.swing.JLabel lblVND3;
    private javax.swing.JLabel lblWithdraw;
    private javax.swing.JPanel panelUser;
    private javax.swing.JPanel pnAccountmanagement;
    private javax.swing.JPanel pnTransaction;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtCurrentBalance;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtHint;
    private javax.swing.JTextField txtHintConfirm;
    private javax.swing.JTextField txtHintPass;
    private javax.swing.JTextField txtInput;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtNewPassConfirm;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtOldPassword;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordConfirm;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtRecName;
    private javax.swing.JTextField txtRecPhone;
    private javax.swing.JTextField txtRecPhoneNum;
    private javax.swing.JTextField txtSendBalance;
    private javax.swing.JTextField txtSendName;
    private javax.swing.JTextField txtSendPhone;
    private javax.swing.JTextField txtTransAmount;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
