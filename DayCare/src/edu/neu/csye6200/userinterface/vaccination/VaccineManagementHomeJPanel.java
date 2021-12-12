/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.userinterface.vaccination;

import edu.neu.csye6200.University;
import edu.neu.csye6200.health.Vaccine;
import edu.neu.csye6200.health.VaccineRecord;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author manojreddy
 */
public class VaccineManagementHomeJPanel extends javax.swing.JPanel {

    /**
     * Creates new form VaccineManagementHomeJPanel
     */
    
    private JPanel containerjPanel;
    private University university;
    
    public VaccineManagementHomeJPanel(JPanel containerjPanel, University university) {
        initComponents();
        this.containerjPanel = containerjPanel;
        this.university = university;
        
        populateVaccineDirectoryRecords();
    }

    public void populateVaccineDirectoryRecords() {
        
        DefaultTableModel vaccineRecorsListModel = (DefaultTableModel) vaccinationDirectoryRecordsListjTable.getModel();
        vaccineRecorsListModel.setRowCount(0);
        
        for(Vaccine vaccine:university.getImmunizationController().getVaccineList()) {
            
            Object[] row = new Object[5];
            row[0] = vaccine;
            row[1] = vaccine.getName();
            row[2] = vaccine.getFrequency().name();
            row[3] = vaccine.isIsOptional();
            row[4] = vaccine.getDoseCount();
            
            vaccineRecorsListModel.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        vaccinationDirectoryRecordsListjTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        updatejButton = new javax.swing.JButton();
        deletejButton = new javax.swing.JButton();
        createjButton = new javax.swing.JButton();

        vaccinationDirectoryRecordsListjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "frequency", "Is Optional", "Dose Count"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(vaccinationDirectoryRecordsListjTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vaccination Directory");

        updatejButton.setText("Update");
        updatejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatejButtonActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(updatejButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deletejButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createjButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deletejButton)
                    .addComponent(createjButton)
                    .addComponent(updatejButton))
                .addContainerGap(171, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updatejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatejButtonActionPerformed
        // TODO add your handling code here:

        DefaultTableModel vaccineRecordListModel = (DefaultTableModel) vaccinationDirectoryRecordsListjTable.getModel();
        Vaccine vaccineRecord = (Vaccine) vaccineRecordListModel.getValueAt(vaccinationDirectoryRecordsListjTable.getSelectedRow(), 0);

        CardLayout cardLayout = (CardLayout) containerjPanel.getLayout();
        containerjPanel.add("UpdateStudentJPanel", new UpdateVaccinationRecordJPanel(containerjPanel, university, vaccineRecord));
        cardLayout.next(containerjPanel);
    }//GEN-LAST:event_updatejButtonActionPerformed

    private void deletejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletejButtonActionPerformed
        // TODO add your handling code here:

        DefaultTableModel vaccineRecordListModel = (DefaultTableModel) vaccinationDirectoryRecordsListjTable.getModel();
        Vaccine vaccineRecord = (Vaccine) vaccineRecordListModel.getValueAt(vaccinationDirectoryRecordsListjTable.getSelectedRow(), 0);
        university.getImmunizationController().removeVaccine(vaccineRecord);

        JOptionPane.showMessageDialog(this, "Successfully deleted Vaccine record");

        populateVaccineDirectoryRecords();
    }//GEN-LAST:event_deletejButtonActionPerformed

    private void createjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createjButtonActionPerformed
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) containerjPanel.getLayout();
        containerjPanel.add("CreateNewStudentJpanel", new CreateNewVaccinationRecordJPanel(containerjPanel, university));
        cardLayout.next(containerjPanel);
    }//GEN-LAST:event_createjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createjButton;
    private javax.swing.JButton deletejButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updatejButton;
    private javax.swing.JTable vaccinationDirectoryRecordsListjTable;
    // End of variables declaration//GEN-END:variables
}
