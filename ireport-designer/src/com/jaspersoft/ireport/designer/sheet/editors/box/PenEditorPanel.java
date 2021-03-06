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
package com.jaspersoft.ireport.designer.sheet.editors.box;

import com.jaspersoft.ireport.locale.I18n;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.sf.jasperreports.engine.JRPen;
import net.sf.jasperreports.engine.type.LineStyleEnum;

/**
 *
 * @author  gtoffoli
 */
public class PenEditorPanel extends javax.swing.JPanel  {
    
    private JRPen pen = null;
    private SpinnerNumberModel spinnedModel = null;
    private DefaultListModel styleListModel = null;
    
    private boolean init = false;
    
    /** Creates new form PenEditorPanel */
    public PenEditorPanel() {
        initComponents();
        
        
        colorSelector.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
                if (!isInit() && pen != null)
                {
                    pen.setLineColor( colorSelector.getColor() );
                }
       
            }
        });
        
        spinnedModel = new SpinnerNumberModel(0, 0, 100, 0.25); 
        jSpinnerLineWidth.setModel(spinnedModel);
        spinnedModel.addChangeListener(new ChangeListener() {

        public void stateChanged(ChangeEvent e) {
                if (!isInit() && pen != null)
                {
                    pen.setLineWidth( spinnedModel.getNumber().floatValue() );
                }
            }

        });
        
        jSpinnerLineWidth.setFont( UIManager.getFont("TextField.font"));
        
        jList1.setCellRenderer(new LineStyleListCellRenderer());
        styleListModel = new DefaultListModel();
        jList1.setModel(styleListModel);

        //styleListModel.addElement("");
        styleListModel.addElement( LineStyleEnum.SOLID );
        styleListModel.addElement( LineStyleEnum.DASHED );
        styleListModel.addElement( LineStyleEnum.DOTTED );
        styleListModel.addElement( LineStyleEnum.DOUBLE );
        
        jList1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (!isInit() && pen != null)
                {
                    pen.setLineStyle( (LineStyleEnum)jList1.getSelectedValue() );
                }
                
            }
        });
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSpinnerLineWidth = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jPanelColorSelector = new javax.swing.JPanel();
        colorSelector = new com.jaspersoft.ireport.designer.sheet.editors.box.ColorSelectorPanel();

        jPanel4.setMinimumSize(new java.awt.Dimension(200, 150));
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 150));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText(I18n.getString("PenEditorPanel.jLabel1.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(8, 4, 4, 4);
        jPanel4.add(jLabel1, gridBagConstraints);

        jSpinnerLineWidth.setMinimumSize(new java.awt.Dimension(120, 20));
        jSpinnerLineWidth.setPreferredSize(new java.awt.Dimension(120, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 8);
        jPanel4.add(jSpinnerLineWidth, gridBagConstraints);

        jLabel7.setText(I18n.getString("PenEditorPanel.jLabel7.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 4, 4, 4);
        jPanel4.add(jLabel7, gridBagConstraints);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(120, 80));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(120, 80));

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 8);
        jPanel4.add(jScrollPane1, gridBagConstraints);

        jLabel2.setText(I18n.getString("PenEditorPanel.jLabel2.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(8, 4, 4, 4);
        jPanel4.add(jLabel2, gridBagConstraints);

        jPanelColorSelector.setBackground(new java.awt.Color(255, 255, 255));
        jPanelColorSelector.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.SystemColor.controlShadow));
        jPanelColorSelector.setMinimumSize(new java.awt.Dimension(50, 20));
        jPanelColorSelector.setPreferredSize(new java.awt.Dimension(120, 20));
        jPanelColorSelector.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        jPanelColorSelector.add(colorSelector, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 8);
        jPanel4.add(jPanelColorSelector, gridBagConstraints);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jaspersoft.ireport.designer.sheet.editors.box.ColorSelectorPanel colorSelector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelColorSelector;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerLineWidth;
    // End of variables declaration//GEN-END:variables

    public JRPen getPen() {
        return pen;
    }

    public void setPen(JRPen pen) {
        this.pen = pen;
        boolean oldInit = setInit(true);
        
        jSpinnerLineWidth.setValue(new Double(0));
        jList1.clearSelection();
        colorSelector.setColor(null);

        if (pen != null)
        {
            if (pen.getLineWidth() != null)
            {
                jSpinnerLineWidth.setValue(pen.getLineWidth().doubleValue());
            }
            
            if (pen.getLineStyleValue() != null)
            {
                jList1.setSelectedValue(pen.getLineStyleValue(), true);
            }
            
            if (pen.getLineColor() != null)
            {
                colorSelector.setColor(pen.getLineColor());
            }
        }
        
        setInit(oldInit);
        
    }

    public boolean isInit() {
        return init;
    }

    /**
     * Returns the previous state of init.
     * 
     * @param init
     * @return
     */
    public boolean setInit(boolean newinit) {
        boolean oldInit = this.init;
        this.init = newinit;
        return oldInit;
    }

    
}
