/*
 * iReport - Visual Designer for JasperReports.
 * Copyright (C) 2002 - 2009 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 * 
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 * 
 * This program is part of iReport.
 * 
 * iReport is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * iReport is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with iReport. If not, see <http://www.gnu.org/licenses/>.
 */
package com.jaspersoft.ireport.designer.wizards;

import com.jaspersoft.ireport.locale.I18n;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import net.sf.jasperreports.engine.design.JasperDesign;
import org.openide.WizardDescriptor;

public final class DatasetVisualPanelNewDataset extends JPanel {

    private DatasetWizardNewDataset wizardPanel = null;

    /** Creates new form DatasetVisualPanel1 */
    public DatasetVisualPanelNewDataset(DatasetWizardNewDataset wizardPanel) {
        initComponents();
        this.wizardPanel = wizardPanel;

        jTextFieldDatasetName.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                getWizardPanel().fireChangeEvent();
            }

            public void removeUpdate(DocumentEvent e) {
                getWizardPanel().fireChangeEvent();
            }

            public void changedUpdate(DocumentEvent e) {
                getWizardPanel().fireChangeEvent();
            }
        });
    }

    @Override
    public String getName() {
        return "New dataset";
    }


    public void validateForm()
    {
        String name = jTextFieldDatasetName.getText().trim();
        if (name.length() == 0)
        {
            throw new IllegalArgumentException(I18n.getString("DatasetVisualPanelNewDataset.Exception.EmptyName"));
        }
        if (  ((JasperDesign)getWizardPanel().getWizard().getProperty("jasperdesign")).getDatasetMap().containsKey(name))
        {
            throw new IllegalArgumentException(I18n.getString("DatasetVisualPanelNewDataset.Exception.DuplicatedName"));
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldDatasetName = new javax.swing.JTextField();

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton1, org.openide.util.NbBundle.getMessage(DatasetVisualPanelNewDataset.class, "DatasetVisualPanelNewDataset.jRadioButton1.text_1")); // NOI18N
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton2, org.openide.util.NbBundle.getMessage(DatasetVisualPanelNewDataset.class, "DatasetVisualPanelNewDataset.jRadioButton2.text_1")); // NOI18N
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(DatasetVisualPanelNewDataset.class, "DatasetVisualPanelNewDataset.jLabel1.text")); // NOI18N

        jTextFieldDatasetName.setText(org.openide.util.NbBundle.getMessage(DatasetVisualPanelNewDataset.class, "DatasetVisualPanelNewDataset.jTextFieldDatasetName.text")); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jRadioButton1)
                    .add(jRadioButton2)
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jTextFieldDatasetName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(13, 13, 13)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel1)
                    .add(jTextFieldDatasetName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(54, 54, 54)
                .add(jRadioButton1)
                .add(18, 18, 18)
                .add(jRadioButton2)
                .addContainerGap(149, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        getWizardPanel().updateWizardPanels();
        getWizardPanel().fireChangeEvent();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        getWizardPanel().updateWizardPanels();
        getWizardPanel().fireChangeEvent();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextFieldDatasetName;
    // End of variables declaration//GEN-END:variables


    public boolean isFinishPanel()
    {
        try {
            validateForm();
        } catch (IllegalArgumentException ex)
        {
            return false;
        }
        return jRadioButton2.isSelected();
    }

    public void readSettings(Object settings) {
        JasperDesign jd = (JasperDesign) getWizardPanel().getWizard().getProperty("jasperdesign");
        String name = "New Dataset ";
        for (int i = 1;; i++) {
            if (!jd.getDatasetMap().containsKey(name + i)) {
                jTextFieldDatasetName.setText(name + i);
                break;
            }
        }
    }

    public void storeSettings(Object settings) {
        getWizardPanel().getWizard().putProperty("dataset_type", jRadioButton1.isSelected() ? 0 : 1);
        getWizardPanel().getWizard().putProperty("dataset_name", jTextFieldDatasetName.getText().trim());
    }

    /**
     * @return the wizardPanel
     */
    public DatasetWizardNewDataset getWizardPanel() {
        return wizardPanel;
    }

}

