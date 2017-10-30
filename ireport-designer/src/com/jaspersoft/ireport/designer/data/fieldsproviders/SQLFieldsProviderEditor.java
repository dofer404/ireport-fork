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

/*
 * SQLFieldsProviderEditor.java
 *
 * Created on 8-set-2010, 16.01.37
 */

package com.jaspersoft.ireport.designer.data.fieldsproviders;

import com.jaspersoft.ireport.designer.FieldsProviderEditor;
import com.jaspersoft.ireport.designer.IReportManager;
import com.jaspersoft.ireport.designer.data.ReportQueryDialog;
import com.jaspersoft.ireport.designer.editor.ExpressionContext;
import com.jaspersoft.ireport.designer.tools.JRParameterDialog;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignDataset;
import net.sf.jasperreports.engine.design.JRDesignParameter;

/**
 *
 * @author gtoffoli
 */
public class SQLFieldsProviderEditor extends javax.swing.JPanel implements FieldsProviderEditor, PropertyChangeListener {

    private boolean sort = true;
    private boolean filter = true;
    private ReportQueryDialog reportQueryDialog = null;

    private JRDesignDataset dataset = null;
    /** Creates new form SQLFieldsProviderEditor */
    public SQLFieldsProviderEditor() {
        initComponents();

        jList1.setModel(new DefaultListModel());
        jList1.setCellRenderer(new SQLParameterCellRenderer(jList1));

        jList1.setTransferHandler(new ParameterTextTransferHandler());

        boolean b = IReportManager.getPreferences().getBoolean("sqlFieldProvider.filter", true);
        jToggleButtonFilter.setSelected(b);
        setFilter(b);

        b = IReportManager.getPreferences().getBoolean("sqlFieldProvider.sort", true);
        jToggleButtonSort.setSelected(b);
        setSort(b);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jToggleButtonFilter = new javax.swing.JToggleButton();
        jToggleButtonSort = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelHelp = new javax.swing.JLabel();

        jLabel1.setText(org.openide.util.NbBundle.getMessage(SQLFieldsProviderEditor.class, "SQLFieldsProviderEditor.jLabel1.text")); // NOI18N

        jList1.setDragEnabled(true);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jButton1.setText(org.openide.util.NbBundle.getMessage(SQLFieldsProviderEditor.class, "SQLFieldsProviderEditor.jButton1.text")); // NOI18N
        jButton1.setToolTipText(org.openide.util.NbBundle.getMessage(SQLFieldsProviderEditor.class, "SQLFieldsProviderEditor.jButton1.toolTipText")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jToggleButtonFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/designer/resources/filter-parameters.png"))); // NOI18N
        jToggleButtonFilter.setSelected(true);
        jToggleButtonFilter.setToolTipText(org.openide.util.NbBundle.getMessage(SQLFieldsProviderEditor.class, "SQLFieldsProviderEditor.jToggleButtonFilter.toolTipText")); // NOI18N
        jToggleButtonFilter.setBorderPainted(false);
        jToggleButtonFilter.setFocusPainted(false);
        jToggleButtonFilter.setFocusable(false);
        jToggleButtonFilter.setMargin(new java.awt.Insets(2, 6, 2, 6));
        jToggleButtonFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonFilterActionPerformed(evt);
            }
        });
        jToolBar1.add(jToggleButtonFilter);

        jToggleButtonSort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/designer/resources/parameters-sort-16.png"))); // NOI18N
        jToggleButtonSort.setSelected(true);
        jToggleButtonSort.setToolTipText(org.openide.util.NbBundle.getMessage(SQLFieldsProviderEditor.class, "SQLFieldsProviderEditor.jToggleButtonSort.toolTipText")); // NOI18N
        jToggleButtonSort.setBorderPainted(false);
        jToggleButtonSort.setFocusPainted(false);
        jToggleButtonSort.setFocusable(false);
        jToggleButtonSort.setMargin(new java.awt.Insets(2, 6, 2, 6));
        jToggleButtonSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonSortActionPerformed(evt);
            }
        });
        jToolBar1.add(jToggleButtonSort);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabelHelp.setBackground(new java.awt.Color(255, 255, 204));
        jLabelHelp.setText(org.openide.util.NbBundle.getMessage(SQLFieldsProviderEditor.class, "SQLFieldsProviderEditor.jLabelHelp.text")); // NOI18N
        jLabelHelp.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(jLabelHelp, gridBagConstraints);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .add(jLabel1)
                    .add(layout.createSequentialGroup()
                        .add(jButton1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jToolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jButton1)
                    .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonFilterActionPerformed
        setFilter( jToggleButtonFilter.isSelected());
        IReportManager.getPreferences().putBoolean("sqlFieldProvider.filter", isFilter());
}//GEN-LAST:event_jToggleButtonFilterActionPerformed

    private void jToggleButtonSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonSortActionPerformed
        setSort( jToggleButtonSort.isSelected() );
        IReportManager.getPreferences().putBoolean("sqlFieldProvider.sort", isSort());
}//GEN-LAST:event_jToggleButtonSortActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        createNewParameter();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked

        if (SwingUtilities.isLeftMouseButton(evt) && evt.getClickCount() == 2 && jList1.getSelectedValue() != null)
        {
            JRDesignParameter p = (JRDesignParameter)jList1.getSelectedValue();
            JRParameterDialog pd = new JRParameterDialog(getReportQueryDialog(),getDataset().getParametersMap());
            pd.setExpressionContext(new ExpressionContext(getDataset()));
            pd.setParameter(p);
            pd.setVisible(true);

            if (pd.getDialogResult() == JOptionPane.OK_OPTION)
            {
                JRDesignParameter pNew = pd.getParameter();

                p.setName(pNew.getName());
                p.setValueClassName(pNew.getValueClassName());
                p.setDefaultValueExpression(pNew.getDefaultValueExpression());

                jList1.updateUI();
            }

        }

    }//GEN-LAST:event_jList1MouseClicked


    private void createNewParameter()
    {
         if (getDataset() == null) return;
        JRParameterDialog dialog = new JRParameterDialog(getReportQueryDialog(), getDataset().getParametersMap());
        dialog.setExpressionContext(new ExpressionContext(getDataset()));

        dialog.setVisible(true);

        if (dialog.getDialogResult() == JOptionPane.OK_OPTION)
        {
            JRDesignParameter p = dialog.getParameter();
            try {
                getDataset().addParameter(p);
            } catch (JRException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelHelp;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButtonFilter;
    private javax.swing.JToggleButton jToggleButtonSort;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    public void queryChanged(String newQuery) {
        
    }

    /**
     * @return the dataset
     */
    public JRDesignDataset getDataset() {
        return dataset;
    }

    /**
     * @param dataset the dataset to set
     */
    public void setDataset(JRDesignDataset dataset) {

        if (this.dataset != null)
        {
            this.dataset.getEventSupport().removePropertyChangeListener(this);
        }
        this.dataset = dataset;
        if (this.dataset != null)
        {
            this.dataset.getEventSupport().addPropertyChangeListener(this);
        }

        updateParameters();
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals( JRDesignDataset.PROPERTY_PARAMETERS))
        {
            updateParameters();
        }
    }

    private void updateParameters() {
        DefaultListModel dlm = (DefaultListModel)this.jList1.getModel();

        dlm.removeAllElements();

        if (getDataset() == null)
        {
            jList1.updateUI();
            return;
        }

        List parameters = new ArrayList( getDataset().getParametersList() );

        // Sort...
        if (isSort())
        {
                // Order elements by name...
                Object[] params = parameters.toArray();
                Arrays.sort(params, new Comparator() {

                    public int compare(Object o1, Object o2) {
                        return ((JRDesignParameter)o1).getName().compareToIgnoreCase(((JRDesignParameter)o2).getName());
                    }
                });
                parameters.clear();
                parameters.addAll(Arrays.asList(params));

        }

        for (int i=0; i<parameters.size(); ++i)
        {
            JRDesignParameter p = (JRDesignParameter)parameters.get(i);
            if (isFilter() && p.isSystemDefined()) continue;

            dlm.addElement(parameters.get(i));
        }
        jList1.updateUI();
    }

    /**
     * @return the sort
     */
    public boolean isSort() {
        return sort;
    }

    /**
     * @param sort the sort to set
     */
    public void setSort(boolean sort) {
        this.sort = sort;
        updateParameters();
    }

    /**
     * @return the filter
     */
    public boolean isFilter() {
        return filter;
    }

    /**
     * @param filter the filter to set
     */
    public void setFilter(boolean filter) {
        this.filter = filter;
        updateParameters();
    }

    /**
     * @return the reportQueryDialog
     */
    public ReportQueryDialog getReportQueryDialog() {
        return reportQueryDialog;
    }

    /**
     * @param reportQueryDialog the reportQueryDialog to set
     */
    public void setReportQueryDialog(ReportQueryDialog reportQueryDialog) {
        this.reportQueryDialog = reportQueryDialog;
        setDataset( reportQueryDialog.getDataset() );
    }


}
