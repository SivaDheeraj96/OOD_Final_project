/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.userinterface.student;

import edu.neu.csye6200.Person;
import edu.neu.csye6200.University;
import edu.neu.csye6200.student.Student;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
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
        
        populateTable(university.getStudentController().getStudentList());
    }

    public void populateTable(List<Person> personList) {
        
        DefaultTableModel studentListModel = (DefaultTableModel) studentsListjTable.getModel();
        studentListModel.setRowCount(0);
        
//        System.out.println(university.getStudentController().getUnassignedStudent().size());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        personList.stream()
                .map(x -> (Student)x)
                .map(x -> new Object[]{x, x.getName(),x.getAge(),x.getGpa(),x.getPhoneNumber(),x.getParentName(),x.getAddress(),simpleDateFormat.format(x.getLastRenewedDate())})
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
        searchStudentId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        searchStudentName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        searchParentName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        searchPhoneNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        statusjCheckBox = new javax.swing.JCheckBox();

        studentsListjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student-Id", "Name", "Age", "Gpa", "Phone No", "Parent Name", "Address", "Last Renewal Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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

        jLabel2.setText("Student Id");

        jButton1.setText("search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Name");

        searchStudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchStudentNameActionPerformed(evt);
            }
        });

        jLabel4.setText("Parent Name");

        jLabel5.setText("Phone Number");

        jLabel6.setText("Renewed");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(updatejButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deletejButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createjButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(368, 368, 368)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchParentName, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(statusjCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {createjButton, deletejButton, updatejButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1)
                    .addComponent(jLabel3)
                    .addComponent(searchStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(searchParentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(searchPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(statusjCheckBox))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deletejButton)
                    .addComponent(createjButton)
                    .addComponent(updatejButton))
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deletejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletejButtonActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel studentListModel = (DefaultTableModel) studentsListjTable.getModel();
        Student student = (Student) studentListModel.getValueAt(studentsListjTable.getSelectedRow(), 0);
        university.getStudentController().removeStudent(student);
        
        JOptionPane.showMessageDialog(this, "Successfully deleted Student record");

        populateTable(university.getStudentController().getStudentList());
        
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

    private void searchStudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchStudentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchStudentNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Map<String,String> criteria  = new HashMap();
        String sId = searchStudentId.getText();
        String name = searchStudentName.getText();
        String parentName = searchParentName.getText();
        String phoneNumber = searchPhoneNumber.getText();
        boolean status = statusjCheckBox.isSelected();
        
        if((sId != null && !sId.isEmpty()))
        {
            criteria.put("ID", sId);
        }
        if((name != null && !name.isEmpty()))
        {
            criteria.put("NAME", name);
        }
        if((parentName != null && !parentName.isEmpty()))
        {
            criteria.put("PARENT_NAME", parentName);
        }
        if((phoneNumber != null && !phoneNumber.isEmpty()))
        {
            criteria.put("PHONE_NUMBER", phoneNumber);
        }
        if(status)
        {
            criteria.put("STATUS", "TRUE");
        }
        List<Person> searchedList = university.getStudentController().searchStudent(criteria);
        populateTable(searchedList);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createjButton;
    private javax.swing.JButton deletejButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchParentName;
    private javax.swing.JTextField searchPhoneNumber;
    private javax.swing.JTextField searchStudentId;
    private javax.swing.JTextField searchStudentName;
    private javax.swing.JCheckBox statusjCheckBox;
    private javax.swing.JTable studentsListjTable;
    private javax.swing.JButton updatejButton;
    // End of variables declaration//GEN-END:variables
}
