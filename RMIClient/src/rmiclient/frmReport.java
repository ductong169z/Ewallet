/**
 *
 * @author Wibuu Group, consists of 3 members:
 * @author Nguyen Duc Tong
 * @author Quan Duc Loc
 * @author Tran Minh Thang
 *
 */
package rmiclient;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import rmiserver.IAdminFunc;
import rmiserver.IUserFunc;
import rmiserver.ReportList;
import rmiserver.User;

public class frmReport extends javax.swing.JFrame {

    IAdminFunc iAdmin;
    IUserFunc iUser;
    DefaultTableModel model;
    User userInfo;
    int option; // ReportList option
    // 1: Deposit report
    // 2: Withdrawal report
    // 3: Transfer report
    // 4: Transaction history

    /**
     * Creates new form ReportList
     */
    public frmReport(int option, User userInfo) throws SQLException {
        try {
            initComponents();
            this.userInfo = userInfo;
            iAdmin = (IAdminFunc) Naming.lookup("rmi://localhost:71/AdminFunctions");
            iUser = (IUserFunc) Naming.lookup("rmi://localhost:70/UserFunctions");
            ArrayList<ReportList> report;
            model = (DefaultTableModel) tbReport.getModel();
            tbReport = new JTable(model) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            this.option = option;
            this.setLocationRelativeTo(null);

            /* Set Icon for the form */
            ImageIcon icon = new ImageIcon("miniWibuu.png");
            this.setIconImage(icon.getImage());

            switch (option) {
                case 1:
                    this.setTitle("Deposit Report");
                    lblTitle.setText("Deposit Report");
                    report = iAdmin.getReportAll("user_deposit");
                    for (ReportList rp : report) {
                        Object objList[] = {rp.getId(), rp.getUser_id(), rp.getFullname(), rp.getMoney(), rp.getCreated_at(), rp.getDescription()};
                        model.addRow(objList);
                    }
                    break;
                case 2:
                    this.setTitle("Withdrawal Report");
                    lblTitle.setText("Withdrawal Report");
                    report = iAdmin.getReportAll("user_withdraw");
                    for (ReportList rp : report) {
                        Object objList[] = {rp.getId(), rp.getUser_id(), rp.getFullname(), rp.getMoney(), rp.getCreated_at(), rp.getDescription()};
                        model.addRow(objList);
                    }
                    break;
                case 3:
                    this.setTitle("Transfer Report");
                    lblTitle.setText("Transfer Report");
                    report = iAdmin.getReportAll("user_transfer");
                    model.setColumnCount(0);
                    model.setRowCount(0);
                    model.addColumn("ID");
                    model.addColumn("Send_ID");
                    model.addColumn("Receive_ID");
                    model.addColumn("Amount");
                    model.addColumn("Time");
                    
                    for (ReportList rp : report) {
                        Object objList[] = {rp.getId(), rp.getUser_id(), rp.getUser_id2(), rp.getMoney(), rp.getCreated_at()};
                        model.addRow(objList);
                    }
                    break;
                case 4:
                    this.setTitle("Transaction History");
                    lblTitle.setText("Transaction History");
                    report = iUser.viewTransactionHistory(String.valueOf(userInfo.getId()));
                    model.setColumnCount(0);
                    model.setRowCount(0);
                    model.addColumn("ID");
                    model.addColumn("User_Id");
                    model.addColumn("Date");
                    model.addColumn("Amount");
                    model.addColumn("Type");
                    model.addColumn("Description");
                    for (ReportList rp : report) {
                        Object objList[] = {rp.getId(), rp.getUser_id(), rp.getCreated_at(), rp.getMoney(), rp.getType().equals("1") ? "Withdrawal" : (rp.getType().equals("0") ? "Deposit" : "Transfer"), rp.getDescription()};
                        model.addRow(objList);
                    }
                    break;
                default:
                    break;
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(frmReport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(frmReport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(frmReport.class.getName()).log(Level.SEVERE, null, ex);
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

        excelFileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbReport = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        btnExport = new javax.swing.JButton();

        excelFileChooser.setDialogTitle("Save As");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "User ID", "Fullname", "Amount", "Time", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbReport);

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("<Title>");

        btnExport.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExport)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExport)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(filter);
        int choice = excelFileChooser.showSaveDialog(this);

        if (choice == JFileChooser.APPROVE_OPTION) {
            FileOutputStream fileOut = null;
            try {
                XSSFWorkbook excelExporter = new XSSFWorkbook();
                XSSFSheet excelSheet = excelExporter.createSheet(lblTitle.getText());
                XSSFRow excelRow = excelSheet.createRow(0);
                for (int i = 0; i < model.getColumnCount(); i++) {
                    XSSFCell excelCell = excelRow.createCell(i);
                    String cell = model.getColumnName(i);
                    excelCell.setCellValue(cell);
                }

                for (int i = 1; i < model.getRowCount() + 1; i++) {
                    excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);
                        String cell = model.getValueAt(i - 1, j).toString();
                        excelCell.setCellValue(cell);
                    }
                }
                fileOut = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                BufferedOutputStream fileBuffer = new BufferedOutputStream(fileOut);
                excelExporter.write(fileBuffer);
                JOptionPane.showMessageDialog(this, "Export Successfull");
                fileBuffer.close();
                fileOut.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(frmReport.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(frmReport.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnExportActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExport;
    private javax.swing.JFileChooser excelFileChooser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tbReport;
    // End of variables declaration//GEN-END:variables
}
