package csdlth;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Giaodienchinh extends javax.swing.JFrame {

    public Giaodienchinh() {
        initComponents();
    }

    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();  // Manh3 button
        jButton5 = new javax.swing.JButton();  // Sanpham_2 button
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtError = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Co So Du Lieu Phan Tang");

        // Set the background color of the frame
        getContentPane().setBackground(new Color(230, 230, 255)); // Light blue background

        // Button 1 (Manh1)
        jButton1.setText("Manh1");
        jButton1.setBackground(new Color(0, 123, 255)); // Blue button
        jButton1.setForeground(Color.WHITE);
        jButton1.setFont(new Font("Arial", Font.BOLD, 14));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        // Button 2 (Manh2)
        jButton3.setText("Manh2");
        jButton3.setBackground(new Color(0, 123, 255)); // Blue button
        jButton3.setForeground(Color.WHITE);
        jButton3.setFont(new Font("Arial", Font.BOLD, 14));
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        // Panel to group Sanpham_1 and Sanpham_2
        JPanel pnlSanpham = new JPanel();
        pnlSanpham.setLayout(new BoxLayout(pnlSanpham, BoxLayout.X_AXIS));  // Arrange buttons horizontally

        // Button 3 (Sanpham_1)
        jButton2.setText("Sanpham_1");
        jButton2.setBackground(new Color(255, 87, 34)); // Orange button
        jButton2.setForeground(Color.WHITE);
        jButton2.setFont(new Font("Arial", Font.BOLD, 14));
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        // Button 5 (Sanpham_2)
        jButton5.setText("Sanpham_2");
        jButton5.setBackground(new Color(255, 87, 34)); // Orange button
        jButton5.setForeground(Color.WHITE);
        jButton5.setFont(new Font("Arial", Font.BOLD, 14));
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt); // Action handler for Sanpham_2
            }
        });

        // Add both buttons to the panel
        pnlSanpham.add(jButton2);
        pnlSanpham.add(Box.createHorizontalStrut(10)); // Add some spacing between buttons
        pnlSanpham.add(jButton5);

        // Button 4 (Manh3)
        jButton4.setText("Manh3");
        jButton4.setBackground(new Color(0, 123, 255)); // Blue button
        jButton4.setForeground(Color.WHITE);
        jButton4.setFont(new Font("Arial", Font.BOLD, 14));
        jButton4.setFocusPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt); // Action handler for Manh3
            }
        });

        // Table
        tblResult.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        tblResult.setFont(new Font("Arial", Font.PLAIN, 12));
        tblResult.setRowHeight(30); // Set row height for better readability
        tblResult.setBackground(new Color(240, 240, 240)); // Light gray table background
        tblResult.setGridColor(new Color(200, 200, 255)); // Light blue grid color

        jScrollPane1.setViewportView(tblResult);

        // Error text area
        txtError.setColumns(20);
        txtError.setRows(5);
        txtError.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtError.setBackground(new Color(255, 255, 204)); // Light yellow background for error messages
        jScrollPane2.setViewportView(txtError);

        // Layout settings
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
                                                Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pnlSanpham) // Add grouped panel here
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        40, Short.MAX_VALUE))
                                        .addComponent(jScrollPane2))
                                .addContainerGap(17, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton3)
                                        .addComponent(jButton4)
                                        .addComponent(pnlSanpham)) // Add the panel containing buttons here
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }

    // Action for Manh1 button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel tblmodel = new DefaultTableModel();
        String[] tenCot = { "Ma San Pham", "Ten San Pham" };
        tblmodel.setColumnIdentifiers(tenCot);

        File f = new File("D:/sanpham_1.txt");
        SanPhamModel db = new SanPhamModel();
        db.getDataSanPhamvaLoadTable(f, tblmodel, tblResult, txtError, tenCot, "1");
        tblResult.setModel(tblmodel);
    }

    // Action for Manh2 button
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel tblmodel = new DefaultTableModel();
        String[] tenCot = { "Ma San Pham", "Gia Ban", "Ma Kho" };
        tblmodel.setColumnIdentifiers(tenCot);

        File f = new File("D:/sanpham_2.txt");
        SanPhamModel db = new SanPhamModel();
        db.getDataSanPhamvaLoadTable(f, tblmodel, tblResult, txtError, tenCot, "2");
        tblResult.setModel(tblmodel);
    }

    // Action for Sanpham_1 button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        SanPhamModel db = new SanPhamModel(); 
        File f = new File("D:/sanpham_1.txt");
        ArrayList<ArrayList<String>> a = db.getDataFromManh(f, txtError, "1");
        f = new File("D:/sanpham_2.txt");
        ArrayList<ArrayList<String>> b = db.getDataFromManh(f, txtError, "2");
        f = new File("D:/sanpham_3.txt");
        ArrayList<ArrayList<String>> c = db.getDataFromManh(f, txtError, "3");
        
        ArrayList<ArrayList<String>> result = null;
        result=db.Combie2Table(a, b);
        result=db.GhepPhanManhNgang(result, c);
        
        String tenCot[] = {"Ma San Pham", "Ten San Pham", "Gia Ban", "Ma Kho"};
        DefaultTableModel tblmodel = db.getTableModel(tenCot, result);
        tblResult.setModel(tblmodel);
    }

    // Action for Sanpham_2 button
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        SanPhamModel db = new SanPhamModel(); 
        File f = new File("D:/sanpham_1.txt");
        ArrayList<ArrayList<String>> a = db.getDataFromManh(f, txtError, "1");
        f = new File("D:/sanpham_2.txt");
        ArrayList<ArrayList<String>> b = db.getDataFromManh(f, txtError, "2");
        f = new File("D:/sanpham_3.txt");
        ArrayList<ArrayList<String>> c = db.getDataFromManh(f, txtError, "3");
        
        ArrayList<ArrayList<String>> sp = null;
        sp=db.Combie2Table(a, b);
        sp=db.GhepPhanManhNgang(sp, c);
        
        KhoHangModel khodb = new KhoHangModel();
        f = new File("D:/sanpham_1.txt");
        ArrayList<ArrayList<String>> kh = khodb.getDataFromManh(f, txtError);
        
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (int i = 0; i < sp.size(); i++) {
                ArrayList<String> row_sp = sp.get(i);
                for (int j = 0; j < kh.size(); j++) {
                        ArrayList<String> row_kh = kh.get(j);
                        if (row_sp.get(3).equals(row_kh.get(0))) {
                        ArrayList<String> row_result = new ArrayList<>();
                        row_result.add(row_sp.get(0));
                        row_result.add(row_sp.get(1));
                        row_result.add(row_sp.get(2));
                        row_result.add(row_kh.get(1));
                        row_result.add(row_kh.get(2));
                        result.add(row_result);
                        }
                }
        } 
 
        String tenCot[] = {"Ma San Pham", "Ten San Pham", "Gia Ban", "Ten Kho","Dia Chi Kho"};
        DefaultTableModel tblmodel = db.getTableModel(tenCot, result);
        tblResult.setModel(tblmodel);

    }

    // Action for Manh3 button
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel tblmodel = new DefaultTableModel();
        String[] tenCot = { "Ma San Pham", "Ten San Pham", "Gia Ban", "Ma Kho" };

        tblmodel.setColumnIdentifiers(tenCot);

        File f = new File("D:/sanpham_3.txt"); // Assuming this is the correct path for Manh3
        SanPhamModel db = new SanPhamModel();
        db.getDataSanPhamvaLoadTable(f, tblmodel, tblResult, txtError, tenCot, "3");
        tblResult.setModel(tblmodel);
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4; // New button variable for Manh3
    private javax.swing.JButton jButton5; // New button variable for Sanpham_2
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblResult;
    private javax.swing.JTextArea txtError;
}
