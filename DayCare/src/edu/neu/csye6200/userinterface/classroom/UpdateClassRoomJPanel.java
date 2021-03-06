/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.userinterface.classroom;

import edu.neu.csye6200.Person;
import edu.neu.csye6200.University;
import edu.neu.csye6200.classRoom.ClassRoom;
import edu.neu.csye6200.classRoomGroup.ClassRoomGroup;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author manojreddy
 */
public class UpdateClassRoomJPanel extends javax.swing.JPanel {

    /**
     * Creates new form UpdateClassRoomJPanel
     */
    private JPanel containerjPanel;
    private University university;
    private ClassRoom classRoom;
    
    public UpdateClassRoomJPanel(JPanel containerjPanel, University university, ClassRoom classRoom) {
        initComponents();
        this.containerjPanel = containerjPanel;
        this.university = university;
        this.classRoom = classRoom;
        populateData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idJField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nameJField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        groupsJList = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        updateJButton = new javax.swing.JButton();

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setText("Update ClassRoom");

        jLabel2.setText("Id");

        idJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idJFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Name");

        jScrollPane1.setViewportView(groupsJList);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Class Room Groups");

        updateJButton.setText("update");
        updateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(backJButton)
                        .addGap(129, 129, 129)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameJField, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idJField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateJButton))))
                .addContainerGap(305, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idJField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nameJField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateJButton)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        /*
        containerjPanel.remove(this);

        Component[] components = containerjPanel.getComponents();
        ClassRoomGroupManagementHomeJPanel classRoomGroupManagementHomeJPanel = (ClassRoomGroupManagementHomeJPanel) components[components.length-1];
        classRoomGroupManagementHomeJPanel.populateClassRoomgroups();

        CardLayout cardLayout = (CardLayout) containerjPanel.getLayout();
        cardLayout.previous(containerjPanel);
        */

        containerjPanel.remove(this);
        Component[] components = containerjPanel.getComponents();
        ClassRoomManagementHomeJPanel classRoomHomePanel = (ClassRoomManagementHomeJPanel) components[components.length-1];
        classRoomHomePanel.populateClassRooms();

        CardLayout cardLayout = (CardLayout) containerjPanel.getLayout();
        cardLayout.previous(containerjPanel);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void idJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idJFieldActionPerformed

    private void updateJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateJButtonActionPerformed
        // TODO add your handling code here:
        if(idJField.getText()=="")
        {
            JOptionPane.showMessageDialog(this, "Please input valid id");
            return;
        }
        int id = Integer.parseInt(idJField.getText());
        String name = nameJField.getText();
        if(name=="")
        {
            JOptionPane.showMessageDialog(this, "Please input valid name");
            return;
        }
        List<ClassRoomGroup> groups = new ArrayList();
        int[] indices = groupsJList.getSelectedIndices();
        List<ClassRoomGroup> unassignedGroups = new ArrayList();
        unassignedGroups.addAll(classRoom.getGroups());
        unassignedGroups.addAll( university.getClassRoomGroupController().getUnassignedClassRoomGroup());
        for(int i=0;i<indices.length;i++)
        {
            groups.add(unassignedGroups.get(i));
        }
        if(indices.length<0)
        {
            JOptionPane.showMessageDialog(this, "Please input valid name");
            return;
        }
        university.getClassRoomController().updateClassRoom(classRoom, id, name, groups);
        JOptionPane.showMessageDialog(this, "Successfully add classRoom record");
        populateData();
    }//GEN-LAST:event_updateJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JList<String> groupsJList;
    private javax.swing.JTextField idJField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJField;
    private javax.swing.JButton updateJButton;
    // End of variables declaration//GEN-END:variables

    private void populateData() {
        idJField.setText(((Integer)this.classRoom.getId()).toString());
        nameJField.setText(this.classRoom.getName());
        List<ClassRoomGroup> groups = new ArrayList();
        groups.addAll(this.classRoom.getGroups());
        groups.addAll(university.getClassRoomGroupController().getUnassignedClassRoomGroup());
        groupsJList.removeAll();
        String[] listData = new String[groups.size()]; 
        int[] selectedIndices = new int[this.classRoom.getGroups().size()];
        for(int i=0;i<groups.size();i++)
        {
            ClassRoomGroup group = groups.get(i);
            listData[i]= group.getId()+"_"+group.getTeacher().getName();
            if(i<selectedIndices.length){
            selectedIndices[i]=i;
            }
        }
        groupsJList.setListData(listData);
        groupsJList.setSelectedIndices(selectedIndices);
    }
    
    
}
