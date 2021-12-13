/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.userinterface.vaccination;

import edu.neu.csye6200.Person;
import edu.neu.csye6200.University;
import edu.neu.csye6200.health.Vaccine;
import edu.neu.csye6200.health.VaccineRecord;
import edu.neu.csye6200.student.Student;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        
        populateStudents();
        populateVaccinationTypes();
        searchVaccinationHistory();
        
    }
    
    private void populateStudents() {
        
        studentjComboBox.removeAllItems();
        
        for(Person person:university.getStudentController().getStudentList()) {
            Student student = (Student) person;
            studentjComboBox.addItem(student.getSId()+ "-" + student.getName());
        }
    }
    
    private void populateVaccinationTypes() {
        
        vaccinneTypejComboBox.removeAllItems();
        
        for(Vaccine vaccine:university.getImmunizationController().getVaccineList()) {
            vaccinneTypejComboBox.addItem(vaccine.getName());
        }
    }
    
    private void searchVaccinationHistory() {
        
        int studentIndex = studentjComboBox.getSelectedIndex();
        int vaccineTypeIndex = vaccinneTypejComboBox.getSelectedIndex();
        
        if(studentIndex < 0 || vaccineTypeIndex < 0) {
            JOptionPane.showMessageDialog(this, "Students or vaccineTypes is empty. Cannot proceed ahead");
            return;
        }
        
        Vaccine vaccine = university.getImmunizationController().getVaccineList().get(vaccinneTypejComboBox.getSelectedIndex());
        Student student = (Student) university.getStudentController().getStudentList().get(studentIndex);
        
        DefaultTableModel vaccinationStudentModel = (DefaultTableModel) vaccinationStudentRecordsListjTable.getModel();
        vaccinationStudentModel.setRowCount(0);
        
        VaccineRecord vaccineRecord = university.getImmunizationController().getVaccineRecordByStudentIdAndVaccine(student, vaccine);
        if(vaccineRecord!=null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
            Date lastUpdatedDate = null;
            for(Date date: vaccineRecord.getRecievedDate()) {
                Object[] row = new Object[2];
                row[0] = vaccineRecord;
                row[1] = simpleDateFormat.format(date);

                vaccinationStudentModel.addRow(row);
                if(lastUpdatedDate==null){
                    lastUpdatedDate=date;
                }else{
                    if(lastUpdatedDate.before(date)){
                        lastUpdatedDate = date;
                    }
                }
            }
            if(lastUpdatedDate==null){
                vaccineStatusjLabel.setText("PENDING");
            }else{
                boolean vaccinationStatus = isVaccinePending(lastUpdatedDate, vaccine);
                if(vaccinationStatus) {
                    vaccineStatusjLabel.setText("PENDING");
                }else{
                    vaccineStatusjLabel.setText("OK");
                }
            }
        }else{
            vaccineStatusjLabel.setText("PENDING");
        }
    }
    
    private boolean isVaccinePending(Date lastUpdatedDate, Vaccine vaccine) {
        
        return ((new Date().getTime()-lastUpdatedDate.getTime())/60000>(1440)*vaccine.getFrequency().getDays());
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
        updatejButton1 = new javax.swing.JButton();
        deletejButton1 = new javax.swing.JButton();
        createjButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        vaccinationStudentRecordsListjTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        studentjComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        vaccinneTypejComboBox = new javax.swing.JComboBox<>();
        searchjButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        vaccineStatusjLabel = new javax.swing.JLabel();

        vaccinationDirectoryRecordsListjTable.setAutoCreateRowSorter(true);
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
        if (vaccinationDirectoryRecordsListjTable.getColumnModel().getColumnCount() > 0) {
            vaccinationDirectoryRecordsListjTable.getColumnModel().getColumn(1).setHeaderValue("Vaccine Name");
            vaccinationDirectoryRecordsListjTable.getColumnModel().getColumn(3).setHeaderValue("Is Optional");
            vaccinationDirectoryRecordsListjTable.getColumnModel().getColumn(4).setHeaderValue("Dose Count");
        }

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

        updatejButton1.setText("Update");
        updatejButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatejButton1ActionPerformed(evt);
            }
        });

        deletejButton1.setText("Delete");
        deletejButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletejButton1ActionPerformed(evt);
            }
        });

        createjButton1.setText("Create >");
        createjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createjButton1ActionPerformed(evt);
            }
        });

        vaccinationStudentRecordsListjTable.setAutoCreateRowSorter(true);
        vaccinationStudentRecordsListjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Record-Id", "Received Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(vaccinationStudentRecordsListjTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Student Vaccination Records");

        jLabel3.setText("Student :");

        jLabel4.setText("VaccineType :");

        searchjButton.setText("Search");
        searchjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchjButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        jLabel6.setText("Vaccine Status :");

        vaccineStatusjLabel.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        vaccineStatusjLabel.setForeground(new java.awt.Color(51, 51, 255));
        vaccineStatusjLabel.setText("OK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(368, 368, 368)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(studentjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(37, 37, 37)
                                            .addComponent(jLabel4)
                                            .addGap(18, 18, 18)
                                            .addComponent(vaccinneTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(139, 139, 139))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(62, 62, 62)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(searchjButton)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(updatejButton)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(deletejButton)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(createjButton))))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(vaccineStatusjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(updatejButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deletejButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createjButton1)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deletejButton)
                            .addComponent(createjButton)
                            .addComponent(updatejButton))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(studentjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(vaccinneTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchjButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deletejButton1)
                    .addComponent(createjButton1)
                    .addComponent(updatejButton1)
                    .addComponent(jLabel6)
                    .addComponent(vaccineStatusjLabel))
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updatejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatejButtonActionPerformed
        // TODO add your handling code here:

        DefaultTableModel vaccineRecordListModel = (DefaultTableModel) vaccinationDirectoryRecordsListjTable.getModel();
        if(vaccinationDirectoryRecordsListjTable.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row ");
            return;
        }
        
        Vaccine vaccineRecord = (Vaccine) vaccineRecordListModel.getValueAt(vaccinationDirectoryRecordsListjTable.getSelectedRow(), 0);

        CardLayout cardLayout = (CardLayout) containerjPanel.getLayout();
        containerjPanel.add("UpdateStudentJPanel", new UpdateVaccinationRecordJPanel(containerjPanel, university, vaccineRecord));
        cardLayout.next(containerjPanel);
    }//GEN-LAST:event_updatejButtonActionPerformed

    private void deletejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletejButtonActionPerformed
        // TODO add your handling code here:

        DefaultTableModel vaccineRecordListModel = (DefaultTableModel) vaccinationDirectoryRecordsListjTable.getModel();
        if(vaccinationDirectoryRecordsListjTable.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete");
            return;
        }
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

    private void updatejButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatejButton1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel vaccinationStudentModel = (DefaultTableModel) vaccinationStudentRecordsListjTable.getModel();
        if(vaccinationStudentRecordsListjTable.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Please select a record to update");
            return;
        }
        
        int studentIndex = studentjComboBox.getSelectedIndex();
        int vaccineTypeIndex = vaccinneTypejComboBox.getSelectedIndex();
        
        if(studentIndex < 0 || vaccineTypeIndex < 0) {
            JOptionPane.showMessageDialog(this, "Students or vaccineTypes is empty. Cannot proceed ahead");
            return;
        }
        
        Vaccine vaccine = university.getImmunizationController().getVaccineList().get(vaccinneTypejComboBox.getSelectedIndex());
        Student student = (Student) university.getStudentController().getStudentList().get(studentIndex);
        
        VaccineRecord vaccineRecord = (VaccineRecord) vaccinationStudentModel.getValueAt(vaccinationStudentRecordsListjTable.getSelectedRow(), 0);
        CardLayout cardLayout = (CardLayout) containerjPanel.getLayout();
        containerjPanel.add("UpdateVaccinationStudentRecordJpanel", new UpdateVaccinationStudentRecordJPanel(containerjPanel, university, student, vaccine, vaccineRecord));
        cardLayout.next(containerjPanel);
                
    }//GEN-LAST:event_updatejButton1ActionPerformed

    private void deletejButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletejButton1ActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel vaccinationStudentModel = (DefaultTableModel) vaccinationStudentRecordsListjTable.getModel();
        if(vaccinationStudentRecordsListjTable.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Please select a record to delete");
            return;
        }
        VaccineRecord vaccineRecord = (VaccineRecord) vaccinationStudentModel.getValueAt(vaccinationStudentRecordsListjTable.getSelectedRow(), 0);
        
        university.getImmunizationController().removeVaccineRecord(vaccineRecord);
        populateVaccineDirectoryRecords();
    }//GEN-LAST:event_deletejButton1ActionPerformed

    private void createjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createjButton1ActionPerformed
        // TODO add your handling code here:
        
        int studentIndex = studentjComboBox.getSelectedIndex();
        int vaccineTypeIndex = vaccinneTypejComboBox.getSelectedIndex();
        
        if(studentIndex < 0 || vaccineTypeIndex < 0) {
            JOptionPane.showMessageDialog(this, "Students or vaccineTypes is empty. Cannot proceed ahead");
            return;
        }
        
        Vaccine vaccine = university.getImmunizationController().getVaccineList().get(vaccinneTypejComboBox.getSelectedIndex());
        Student student = (Student) university.getStudentController().getStudentList().get(studentIndex);
        
        CardLayout cardLayout = (CardLayout) containerjPanel.getLayout();
        containerjPanel.add("CreateVaccinationStudentRecordJpanel", new CreateNewVaccinationStudentRecordJPanel(containerjPanel, university, student, vaccine));
        cardLayout.next(containerjPanel);
        
    }//GEN-LAST:event_createjButton1ActionPerformed

    private void searchjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchjButtonActionPerformed
        // TODO add your handling code here:
        searchVaccinationHistory();
    }//GEN-LAST:event_searchjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createjButton;
    private javax.swing.JButton createjButton1;
    private javax.swing.JButton deletejButton;
    private javax.swing.JButton deletejButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton searchjButton;
    private javax.swing.JComboBox<String> studentjComboBox;
    private javax.swing.JButton updatejButton;
    private javax.swing.JButton updatejButton1;
    private javax.swing.JTable vaccinationDirectoryRecordsListjTable;
    private javax.swing.JTable vaccinationStudentRecordsListjTable;
    private javax.swing.JLabel vaccineStatusjLabel;
    private javax.swing.JComboBox<String> vaccinneTypejComboBox;
    // End of variables declaration//GEN-END:variables
}
