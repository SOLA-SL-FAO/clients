/**
 * ******************************************************************************************
 * Copyright (C) 2014 - Food and Agriculture Organization of the United Nations (FAO).
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice,this list
 *       of conditions and the following disclaimer.
 *    2. Redistributions in binary form must reproduce the above copyright notice,this list
 *       of conditions and the following disclaimer in the documentation and/or other
 *       materials provided with the distribution.
 *    3. Neither the name of FAO nor the names of its contributors may be used to endorse or
 *       promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT
 * SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,PROCUREMENT
 * OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,STRICT LIABILITY,OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * *********************************************************************************************
 */
package org.sola.clients.swing.desktop.administrative;

import org.sola.clients.beans.application.ApplicationBean;
import org.sola.clients.beans.application.ApplicationServiceBean;
import org.sola.clients.beans.security.SecurityBean;
import org.sola.clients.swing.ui.ContentPanel;
import org.sola.common.RolesConstants;

/**
 *
 * @author Troy
 */
public class ValuationListPanel extends ContentPanel {

    /**
     * Creates new form ValuationListPanel
     * @param applicationBean
     * @param applicationService
     * @param readOnly 
     */
    public ValuationListPanel(ApplicationBean applicationBean,
            ApplicationServiceBean applicationService,
            Boolean readOnly) {
        this.readOnly = readOnly || !SecurityBean.isInRole(RolesConstants.APPLICATION_EDIT_APPS);
        this.applicationBean = applicationBean;
        this.applicationService = applicationService;
        resourceBundle = java.util.ResourceBundle.getBundle("org/sola/clients/swing/desktop/administrative/Bundle");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        valuationList = new org.sola.clients.beans.administrative.ValuationListBean();
        headerPanel1 = new org.sola.clients.swing.ui.HeaderPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnSave = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableWithDefaultStyles1 = new org.sola.clients.swing.common.controls.JTableWithDefaultStyles();

        setCloseOnHide(true);
        setHeaderPanel(headerPanel1);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/sola/clients/swing/desktop/administrative/Bundle"); // NOI18N
        headerPanel1.setTitleText(bundle.getString("ValuationListPanel.headerPanel1.titleText")); // NOI18N

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setName(""); // NOI18N

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/common/save.png"))); // NOI18N
        btnSave.setText(bundle.getString("ValuationListPanel.btnSave.text")); // NOI18N
        btnSave.setFocusable(false);
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSave);

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/common/print.png"))); // NOI18N
        btnPrint.setText(bundle.getString("ValuationListPanel.btnPrint.text")); // NOI18N
        btnPrint.setFocusable(false);
        btnPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnPrint);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/common/add.png"))); // NOI18N
        btnAdd.setText(bundle.getString("ValuationListPanel.btnAdd.text")); // NOI18N
        btnAdd.setFocusable(false);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jToolBar2.add(btnAdd);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/common/folder-open-document-text.png"))); // NOI18N
        btnEdit.setText(bundle.getString("ValuationListPanel.btnEdit.text")); // NOI18N
        btnEdit.setFocusable(false);
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnEdit);

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/common/remove.png"))); // NOI18N
        btnRemove.setText(bundle.getString("ValuationListPanel.btnRemove.text")); // NOI18N
        btnRemove.setFocusable(false);
        btnRemove.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnRemove);

        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/common/view.png"))); // NOI18N
        btnView.setText(bundle.getString("ValuationListPanel.btnView.text")); // NOI18N
        btnView.setFocusable(false);
        btnView.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnView);

        btnOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/common/folder-open-document.png"))); // NOI18N
        btnOpen.setText(bundle.getString("ValuationListPanel.btnOpen.text")); // NOI18N
        btnOpen.setFocusable(false);
        btnOpen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnOpen);

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${valuationList}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, valuationList, eLProperty, jTableWithDefaultStyles1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nr}"));
        columnBinding.setColumnName("Nr");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${baUnitId}"));
        columnBinding.setColumnName("Ba Unit Id");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${classificationCode}"));
        columnBinding.setColumnName("Classification Code");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${amount}"));
        columnBinding.setColumnName("Amount");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${typeCode}"));
        columnBinding.setColumnName("Type Code");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${description}"));
        columnBinding.setColumnName("Description");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTableWithDefaultStyles1);
        if (jTableWithDefaultStyles1.getColumnModel().getColumnCount() > 0) {
            jTableWithDefaultStyles1.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("ValuationListPanel.jTableWithDefaultStyles1.columnModel.title0_1")); // NOI18N
            jTableWithDefaultStyles1.getColumnModel().getColumn(1).setHeaderValue(bundle.getString("ValuationListPanel.jTableWithDefaultStyles1.columnModel.title1_1")); // NOI18N
            jTableWithDefaultStyles1.getColumnModel().getColumn(2).setHeaderValue(bundle.getString("ValuationListPanel.jTableWithDefaultStyles1.columnModel.title2_1")); // NOI18N
            jTableWithDefaultStyles1.getColumnModel().getColumn(3).setHeaderValue(bundle.getString("ValuationListPanel.jTableWithDefaultStyles1.columnModel.title3_1")); // NOI18N
            jTableWithDefaultStyles1.getColumnModel().getColumn(4).setHeaderValue(bundle.getString("ValuationListPanel.jTableWithDefaultStyles1.columnModel.title4_1")); // NOI18N
            jTableWithDefaultStyles1.getColumnModel().getColumn(5).setHeaderValue(bundle.getString("ValuationListPanel.jTableWithDefaultStyles1.columnModel.title5")); // NOI18N
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 125, Short.MAX_VALUE))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addValuation();
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnView;
    private org.sola.clients.swing.ui.HeaderPanel headerPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.sola.clients.swing.common.controls.JTableWithDefaultStyles jTableWithDefaultStyles1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private org.sola.clients.beans.administrative.ValuationListBean valuationList;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void addValuation() {
     //   ValuationForm serviceListForm = new ValuationForm(applicationBean);
       // serviceListForm.setLocationRelativeTo(this);
       // serviceListForm.setVisible(true);
    }
        
    
    private boolean readOnly = false;
    private ApplicationBean applicationBean;
    private ApplicationServiceBean applicationService;
    boolean saveInProgress = false;
    java.util.ResourceBundle resourceBundle;

}
