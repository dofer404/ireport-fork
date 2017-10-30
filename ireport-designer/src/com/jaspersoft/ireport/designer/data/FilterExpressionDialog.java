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
package com.jaspersoft.ireport.designer.data;

import com.jaspersoft.ireport.locale.I18n;
import com.jaspersoft.ireport.designer.editor.ExpressionContext;
import net.sf.jasperreports.engine.design.JRDesignDataset;
import com.jaspersoft.ireport.designer.editor.ExpressionEditor;
import com.jaspersoft.ireport.designer.utils.Misc;
import java.awt.BorderLayout;

/**
 *
 * @author  Administrator
 */
public class FilterExpressionDialog extends javax.swing.JDialog {
	/** Creates new form JRParameterDialog */
	private String filterExpression = "";
        private ExpressionEditor editorPane = null;
	
	public FilterExpressionDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initAll();
	}
        
        public FilterExpressionDialog(java.awt.Dialog parent, boolean modal) {
		super(parent, modal);
		initAll();
	}
        
        
        public void initAll()
        {
            initComponents();
            //applyI18n();
            editorPane = new ExpressionEditor();
            jPanel2.add(editorPane, BorderLayout.CENTER);
            //this.pack();
                
            javax.swing.KeyStroke escape =  javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0, false);
            javax.swing.Action escapeAction = new javax.swing.AbstractAction() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    jButtonCancelActionPerformed(e);
                }
            };

            getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(escape, I18n.getString("Global.Pane.Escape"));
            getRootPane().getActionMap().put(I18n.getString("Global.Pane.Escape"), escapeAction);


            //to make the default button ...
            this.getRootPane().setDefaultButton(this.jButtonOK);    
            
        }
        
        
        
	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButtonOK = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        setTitle("Add/modify field");
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel1.setText("Filter expression");

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButtonOK.setText("OK");
        jButtonOK.setMnemonic('o');
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonOK);

        jButtonCancel.setText("Cancel");
        jButtonCancel.setMnemonic('c');
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancel);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents
	
    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
	    setVisible(false);
	    this.setDialogResult( javax.swing.JOptionPane.CANCEL_OPTION);
	    dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed
    
    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
	    
	    filterExpression = editorPane.getExpression();
	    setVisible(false);
	    this.setDialogResult( javax.swing.JOptionPane.OK_OPTION);
	    dispose();
    }//GEN-LAST:event_jButtonOKActionPerformed
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
	    setVisible(false);
	    this.setDialogResult( javax.swing.JOptionPane.CLOSED_OPTION);
	    dispose();
    }//GEN-LAST:event_closeDialog
    
    
   
    /** Getter for property dialogResult.
     * @return Value of property dialogResult.
     *
     */
    public int getDialogResult() {
	    return dialogResult;
    }
    
    /** Setter for property dialogResult.
     * @param dialogResult New value of property dialogResult.
     *
     */
    public void setDialogResult(int dialogResult) {
	    this.dialogResult = dialogResult;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
	
	private int dialogResult;

    public String getFilterExpression() {
        return filterExpression;
    }

    public void setFilterExpression(String filterExpression) {
        setFilterExpression(filterExpression, null);
    }
    
    public void setFilterExpression(String filterExpression, JRDesignDataset subDataset) {
        this.filterExpression = filterExpression;
        editorPane.setExpression(filterExpression);
        if (subDataset != null) 
            editorPane.setExpressionContext( new ExpressionContext( subDataset) );
    }
	
    /*
    public void applyI18n(){
                // Start autogenerated code ----------------------
                jButtonCancel.setText(I18n.getString("filterExpressionDialog.buttonCancel","Cancel"));
                jButtonOK.setText(I18n.getString("filterExpressionDialog.buttonOK","OK"));
                jLabel1.setText(I18n.getString("filterExpressionDialog.label1","Filter expression"));
                // End autogenerated code ----------------------
                
                //
                this.setTitle(I18n.getString("filterExpressionDialog.title","Add/modify field"));
                jButtonCancel.setMnemonic(I18n.getString("filterExpressionDialog.buttonCancelMnemonic","c").charAt(0));
                jButtonOK.setMnemonic(I18n.getString("filterExpressionDialog.buttonOKMnemonic","o").charAt(0));
                //
    }
     */
    
    
    public static final int COMPONENT_NONE=0;
    public static final int COMPONENT_EXPRESSION=1;

    /**
     * This method set the focus on a specific component.
     * Valid constants are something like:
     * FIELD_XXX
     */
    public void setFocusedExpression(int expID )
    {
        switch (expID)
        {
            case COMPONENT_EXPRESSION:
                Misc.selectTextAndFocusArea(editorPane);
                break;
        }
        
    }
}
