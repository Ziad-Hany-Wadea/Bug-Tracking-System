/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bugtrackingsystem.tables;

import bugtrackingsystem.modules.Admin;
import bugtrackingsystem.modules.Developer;
import bugtrackingsystem.modules.ProjectManager;
import bugtrackingsystem.modules.Tester;
import database.DataBaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zeyad
 */
public class Users extends javax.swing.JFrame {

    protected final Statement statement;
    protected final int id;
    public Users(int id) {
        this.id=id;
        this.statement = new DataBaseConnection().setStatement();
        initComponents();
        Show();
    }

    private void Show() {
        String sql = "SELECT * FROM Users";
        try {
            ResultSet rs = this.statement.executeQuery(sql);
            DefaultTableModel df = (DefaultTableModel) this.table_.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                df.addRow(new Object
                []{rs.getString("ID"), rs.getString("username"), rs.getString("password"), rs.getString("role"), rs.getString("name")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bugs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_ = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        table_.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Username", "Password", "Role", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_);
        if (table_.getColumnModel().getColumnCount() > 0) {
            table_.getColumnModel().getColumn(0).setResizable(false);
            table_.getColumnModel().getColumn(1).setResizable(false);
            table_.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        backBtn.setBackground(new java.awt.Color(255, 102, 0));
        backBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Back");
        backBtn.setPreferredSize(new java.awt.Dimension(90, 23));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        try {
            // TODO add your handling code here:
            String sql = "SELECT * FROM Users WHERE ID = " + id;

            ResultSet rs = this.statement.executeQuery(sql);
            while (rs.next()) {
                switch (rs.getString(4)) {
                    case "admin" -> {
                        String name = rs.getString("name");
                        java.awt.EventQueue.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                new Admin(id).setVisible(true);
                            }
                        });
                        this.dispose();
                    }

                    case "pm" -> {
                        String name = rs.getString("name");
                        java.awt.EventQueue.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                new ProjectManager(id).setVisible(true);
                            }
                        });
                        this.dispose();
                    }

                    case "developer" -> {
                        String name = rs.getString("name");
                        java.awt.EventQueue.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                new Developer(id).setVisible(true);
                            }
                        });
                        this.dispose();
                    }

                    case "tester" -> {
                        String name = rs.getString("name");
                        java.awt.EventQueue.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                new Tester(id).setVisible(true);
                            }
                        });
                        this.dispose();
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bugs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_backBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_;
    // End of variables declaration//GEN-END:variables
}
