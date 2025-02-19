package csdlth;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;

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

        // Button 3 (Sanpham)
        jButton2.setText("Sanpham");
        jButton2.setBackground(new Color(255, 87, 34)); // Orange button
        jButton2.setForeground(Color.WHITE);
        jButton2.setFont(new Font("Arial", Font.BOLD, 14));
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        139, Short.MAX_VALUE)
                                                .addComponent(jButton2))
                                        .addComponent(jScrollPane2))
                                .addContainerGap(17, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton3)
                                        .addComponent(jButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel tblmodel = new DefaultTableModel();
        String[] tenCot = { "Ma San Pham", "Ten San Pham" };
        tblmodel.setColumnIdentifiers(tenCot);

        File f = new File("D:/sanpham_1.txt");
        DataModel db = new DataModel();
        db.getDataSanPhamvaLoadTable(f, tblmodel, tblResult, txtError, tenCot, "1");
        tblResult.setModel(tblmodel);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel tblmodel = new DefaultTableModel();
        String[] tenCot = { "Ma San Pham", "Gia Ban", "Ma Kho" };
        tblmodel.setColumnIdentifiers(tenCot);

        File f = new File("D:/sanpham_2.txt");
        DataModel db = new DataModel();
        db.getDataSanPhamvaLoadTable(f, tblmodel, tblResult, txtError, tenCot, "2");
        tblResult.setModel(tblmodel);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel tblmodel = new DefaultTableModel();
        String[] tenCot = {"Ma San Pham", "Ten San Pham", "Gia Ban", "Ma Kho"};

        tblmodel.setColumnIdentifiers(tenCot);

        File f = new File("D:/sanpham_1.txt");
        DataModel db = new DataModel();
        
        ArrayList<ArrayList<String>> sanpham1 = db.getDataFromManh(f, txtError,"1");
        f = new File("D:/sanpham_2.txt");
        ArrayList<ArrayList<String>> sanpham2 = db.getDataFromManh(f, txtError,"2");
        ArrayList<ArrayList<String>> sanpham = db.Combie2Table(sanpham1, sanpham2);

        tblResult.setModel(db.addTableModel(tblmodel, sanpham, tenCot));
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblResult;
    private javax.swing.JTextArea txtError;
}
