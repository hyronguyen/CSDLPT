
package csdlth;

import java.io.File;
import javax.swing.table.DefaultTableModel;
public class Giaodienchinh extends javax.swing.JFrame {

    public Giaodienchinh() {
        initComponents();
    }

    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtError = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Manh1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Manh2");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));

        jScrollPane1.setViewportView(tblResult);

        txtError.setColumns(20);
        txtError.setRows(5);
        jScrollPane2.setViewportView(txtError);

        jButton2.setText("Sanpham");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane2))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Tạo DefaultTableModel mới cho "Mảnh 1"
        DefaultTableModel tblmodel = new DefaultTableModel();
        String[] tenCot = {"Ma San Pham", "Ten San Pham", "Gia Ban", "Ma Kho"};
        tblmodel.setColumnIdentifiers(tenCot);
    
        File f = new File("D:/sanpham_1.txt");
        DataModel db = new DataModel();
        db.getDataSanPham(f, tblmodel, tblResult, txtError, tenCot); // Cập nhật bảng
        tblResult.setModel(tblmodel); // Đặt lại bảng với dữ liệu mới
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Tạo DefaultTableModel mới cho "Mảnh 2"
        DefaultTableModel tblmodel = new DefaultTableModel();
        String[] tenCot = {"Ma San Pham", "Ten San Pham", "Gia Ban", "Ma Kho"};
        tblmodel.setColumnIdentifiers(tenCot);
    
        File f = new File("D:/sanpham_2.txt");
        DataModel db = new DataModel();
        db.getDataSanPham(f, tblmodel, tblResult, txtError, tenCot); // Cập nhật bảng
        tblResult.setModel(tblmodel); // Đặt lại bảng với dữ liệu mới
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Tạo DefaultTableModel mới cho "Sanpham"
        DefaultTableModel tblmodel = new DefaultTableModel();
        String[] tenCot = {"Ma San Pham", "Ten San Pham", "Gia Ban", "Ma Kho"};
        tblmodel.setColumnIdentifiers(tenCot);
    
        // Xử lý file sanpham_1.txt
        File f = new File("D:/sanpham_1.txt");
        DataModel db = new DataModel();
        db.getDataSanPham(f, tblmodel, tblResult, txtError, tenCot);
    
        // Xử lý file sanpham_2.txt
        f = new File("D:/sanpham_2.txt");
        db.getDataSanPham(f, tblmodel, tblResult, txtError, tenCot);
    
        tblResult.setModel(tblmodel); // Đặt lại bảng với dữ liệu mới
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Giaodienchinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Giaodienchinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Giaodienchinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Giaodienchinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Giaodienchinh().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblResult;
    
    private javax.swing.JTextArea txtError;

}
