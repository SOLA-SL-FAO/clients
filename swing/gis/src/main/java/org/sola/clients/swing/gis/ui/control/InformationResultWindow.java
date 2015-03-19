/**
 * ******************************************************************************************
 * Copyright (C) 2015 - Food and Agriculture Organization of the United Nations (FAO).
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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InformationResultWindow.java
 *
 * Created on Jul 1, 2011, 1:55:14 PM
 */
package org.sola.clients.swing.gis.ui.control;

import java.util.List;
import org.sola.common.WindowUtility;
import org.sola.webservices.search.ResultForSelectionInfo;

/**
 * This dialog serves as a host for information result panels that are produced during the
 * information tool action.
 * For each information result, a tab is added.
 * 
 * @author Elton Manoku
 */
public class InformationResultWindow extends javax.swing.JDialog {

    /** Creates new form InformationResultWindow */
    public InformationResultWindow() {
        initComponents();
        this.setAlwaysOnTop(true);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setIconImage(WindowUtility.getTitleBarImage());
        WindowUtility.addEscapeListener(this, true);
    }

    /**
     * Adds the information result panels and makes the dialog visible
     * 
     * @param results 
     */
    public void Show(List<ResultForSelectionInfo> results) {
        this.tabsResult.removeAll();
        for (ResultForSelectionInfo resultInfo : results) {
            if (resultInfo.getResult().getValues().isEmpty()){
                continue;
            }

            InformationResultPanel resultPanel = new InformationResultPanel(resultInfo.getResult());
            String title = String.format("%s (%s)",
                    resultInfo.getId(), resultInfo.getResult().getValues().size());
            this.tabsResult.insertTab(title, null, resultPanel, null, 0);
        }
        this.pack();
        this.setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabsResult = new javax.swing.JTabbedPane();

        setTitle("Results");
        setAlwaysOnTop(true);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabsResult, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabsResult, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tabsResult;
    // End of variables declaration//GEN-END:variables
}
