/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.userinterface.student;

import edu.neu.csye6200.University;
import edu.neu.csye6200.student.Student;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author manojreddy
 */
public class StudentMangementHomeJPanel extends javax.swing.JPanel {

    /**
     * Creates new form StudentMangementHomeJPanel
     */
    private JPanel containerjPanel;
    private University university;
    
    public StudentMangementHomeJPanel(JPanel containerjPanel, University university) {
        initComponents();
        this.containerjPanel = containerjPanel;
        this.university = university;
        
        populateTable();
    }

    public void populateTable() {
        
        DefaultTableModel studentListModel = (DefaultTableModel) studentsListjTable.getModel();
        studentListModel.setRowCount(0);
        
        System.out.println(university.getStudentController().getUnassignedStudent().size());
        
        university.getStudentController().getUnassignedStudent().stream()
                .map(x -> (Student)x)
                .map(x -> new Object[]{x, x.getName(),x.getAge(),x.getGpa(),x.getPhoneNumber(),x.getParentName(),x.getAddress()})
                .forEach(x -> {studentListModel.addRow(x);});
        
        System.out.println(studentListModel.getRowCount());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        studentsListjTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        deletejButton = new javax.swing.JButton();
        createjButton = new javax.swing.JButton();
        updatejButton = new javax.swing.JButton();

        studentsListjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Student-Id", "Name", "Age", "Gpa", "Phone No", "Parent Name", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(studentsListjTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Students Records");

        deletejButton.setText("Delete");
        deletejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletejButtonActionPerformed(evt);
            }
        });

        createjButton.setText("Create >");
        createjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createjButtonActionPerformed(evt);
            }
        });

        updatejButton.setText("Update");
        updatejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatejButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updatejButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deletejButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createjButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(151, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {createjButton, deletejButton, updatejButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deletejButton)
                    .addComponent(createjButton)
                    .addComponent(updatejButton))
                .addGap(80, 80, 80))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deletejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletejButtonActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel studentListModel = (DefaultTableModel) studentsListjTable.getModel();
        Student student = (Student) studentListModel.getValueAt(studentsListjTable.getSelectedRow(), 0);
        university.getStudentController().removeStudent(student);
        populateTable();
        
    }//GEN-LAST:event_deletejButtonActionPerformed

    private void createjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createjButtonActionPerformed
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) containerjPanel.getLayout();
        containerjPanel.add("CreateNewStudentJpanel", new CreateNewStudentJPanel(containerjPanel, university));
        cardLayout.next(containerjPanel);
    }//GEN-LAST:event_createjButtonActionPerformed

    private void updatejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatejButtonActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel studentsModel = (DefaultTableModel) studentsListjTable.getModel();
        Student student = (Student) studentsModel.getValueAt(studentsListjTable.getSelectedRow(), 0);        
        
        CardLayout cardLayout = (CardLayout) containerjPanel.getLayout();
        containerjPanel.add("UpdateStudentJPanel", new UpdateStudentJPanel(containerjPanel, university, student));
        cardLayout.next(containerjPanel);
    }//GEN-LAST:event_updatejButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createjButton;
    private javax.swing.JButton deletejButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable studentsListjTable;
    private javax.swing.JButton updatejButton;
    // End of variables declaration//GEN-END:variables
}
