/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.userinterface.classroom;

import edu.neu.csye6200.NortheasternUniversity;
import edu.neu.csye6200.University;
import edu.neu.csye6200.classRoom.ClassRoom;
import edu.neu.csye6200.classRoomGroup.ClassRoomGroup;
import edu.neu.csye6200.userinterface.classroom.CreateNewClassRoomJPanel;
import edu.neu.csye6200.userinterface.classroom.UpdateClassRoomJPanel;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author manojreddy
 */
public class ClassRoomManagementHomeJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ClassRoomManagementHomeJPanel
     */
    private JPanel containerjPanel;
    private University university;
    
    public ClassRoomManagementHomeJPanel(JPanel containerjPanel, University university) {
        initComponents();
        this.containerjPanel = containerjPanel;
        this.university = university;
        
        populateClassRooms();
    }
    
    public void populateClassRooms() {
        
        DefaultTableModel classRoomListModel = (DefaultTableModel) classRoomsListjTable.getModel();
        classRoomListModel.setRowCount(0);
        
        System.out.println("class room count - "+university.getClassRoomController().getUnassignedClassRoom().size());
        
        university.getClassRoomController().getUnassignedClassRoom().stream()
                .map(x -> (ClassRoom)x)
                .map(x -> new Object[]{x, x.getName(),x.getIsFull(),x.getGroups().size()})
                .forEach(x -> {classRoomListModel.addRow(x);});
        
        System.out.println("model row count"+classRoomListModel.getRowCount());
        
        DefaultTableModel classRoomGroupListModel = (DefaultTableModel) classRoomGroupsListjTable.getModel();
        classRoomGroupListModel.setRowCount(0);
        
        university.getClassRoomGroupController().getUnassignedClassRoomGroup().stream()
                .map(x -> (ClassRoomGroup)x)
                .map(x -> new Object[]{x, x.getTeacher().getName(),x.getIsAssigned(),x.getStudents().size(),x.getAgeGroup().getDisplayValue()})
                .forEach(x -> {classRoomGroupListModel.addRow(x);});
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
        classRoomsListjTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        deletejButton = new javax.swing.JButton();
        createjButton = new javax.swing.JButton();
        updatejButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        classRoomGroupsListjTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        classRoomsListjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "IsFull", "No of Groups"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        classRoomsListjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classRoomsListjTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(classRoomsListjTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ClassRoom Records");

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

        classRoomGroupsListjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Teacher", "IsAssigned", "No of Students", "Age Group"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(classRoomGroupsListjTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ClassRoomGroup Records");

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
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(updatejButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deletejButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createjButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(74, Short.MAX_VALUE))
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
                    .addComponent(updatejButton)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deletejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletejButtonActionPerformed
        // TODO add your handling code here:

        DefaultTableModel classRoomListModel = (DefaultTableModel) classRoomsListjTable.getModel();
        ClassRoom classRoom = (ClassRoom) classRoomListModel.getValueAt(classRoomsListjTable.getSelectedRow(), 0);
        university.getClassRoomController().removeClassRoom(classRoom);

        JOptionPane.showMessageDialog(this, "Successfully deleted classRoom record");

        populateClassRooms();

    }//GEN-LAST:event_deletejButtonActionPerformed

    private void createjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createjButtonActionPerformed
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) containerjPanel.getLayout();
        containerjPanel.add("CreateNewStudentJpanel", new CreateNewClassRoomJPanel(containerjPanel, university));
        cardLayout.next(containerjPanel);
    }//GEN-LAST:event_createjButtonActionPerformed

    private void updatejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatejButtonActionPerformed
        // TODO add your handling code here:

        DefaultTableModel studentsModel = (DefaultTableModel) classRoomsListjTable.getModel();
        ClassRoom classRoom = (ClassRoom) studentsModel.getValueAt(classRoomsListjTable.getSelectedRow(), 0);

        CardLayout cardLayout = (CardLayout) containerjPanel.getLayout();
        containerjPanel.add("UpdateStudentJPanel", new UpdateClassRoomJPanel(containerjPanel, university, classRoom));
        cardLayout.next(containerjPanel);
    }//GEN-LAST:event_updatejButtonActionPerformed

    private void classRoomsListjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classRoomsListjTableMouseClicked
        // TODO add your handling code here:
        
        DefaultTableModel classRoomListModel = (DefaultTableModel) classRoomsListjTable.getModel();
        ClassRoom classRoom = (ClassRoom) classRoomListModel.getValueAt(classRoomsListjTable.getSelectedRow(), 0);
        
        DefaultTableModel classRoomGroupListModel = (DefaultTableModel) classRoomGroupsListjTable.getModel();
        classRoomGroupListModel.setRowCount(0);
        
        classRoom.getGroups().stream()
                .map(x -> (ClassRoomGroup)x)
                .map(x -> new Object[]{x, x.getTeacher().getName(),x.getIsAssigned(),x.getStudents().size()})
                .forEach(x -> {classRoomGroupListModel.addRow(x);});
    }//GEN-LAST:event_classRoomsListjTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable classRoomGroupsListjTable;
    private javax.swing.JTable classRoomsListjTable;
    private javax.swing.JButton createjButton;
    private javax.swing.JButton deletejButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton updatejButton;
    // End of variables declaration//GEN-END:variables
}
