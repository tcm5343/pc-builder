/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

/**
 *
 * @author mbp5503
 */
public class IndividualComp extends javax.swing.JPanel {

    private Mockup myGUI;
    private DB_Manager db = new DB_Manager();
    private ArrayList<? extends Item> itemList;

    private final String[] COMPONENTS = new String[]{"CPU", "MOBO", "RAM", "PSU", "GPU", "Case"};

    /**
     * Creates new form IndividualComp
     */
    public IndividualComp() {
        initComponents();
    }

    public IndividualComp(Mockup m) {
        myGUI = m;
        initComponents();
        reset();
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
        ComponentList = new javax.swing.JList<>();
        PriceLbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        StockLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ComponentCmb = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        FinalBtn = new javax.swing.JButton();
        Qty = new javax.swing.JSpinner();
        CancelBtn = new javax.swing.JButton();
        sortCmb = new javax.swing.JComboBox<>();

        ComponentList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "CPU1", "CPU2", "CPU3", "CPU4", "CPU6", "CPU7", "CPU8", "CPU9" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ComponentList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComponentListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ComponentList);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Stock:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setText("Price:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Component Type");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Components: ");

        ComponentCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPU", "MOBO", "RAM", "GPU", "PSU", "Case" }));
        ComponentCmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComponentCmbItemStateChanged(evt);
            }
        });
        ComponentCmb.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ComponentCmbPropertyChange(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Select Individual Component");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Qty");

        FinalBtn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        FinalBtn.setText("Finalize");
        FinalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalBtnActionPerformed(evt);
            }
        });

        Qty.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        CancelBtn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        sortCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sort by:", "Price", "Name" }));
        sortCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortCmbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(23, 23, 23))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(StockLbl)
                                    .addComponent(PriceLbl)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ComponentCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sortCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(113, 113, 113))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(85, 85, 85)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(75, 75, 75)
                                                .addComponent(Qty, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(FinalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComponentCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addComponent(sortCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(StockLbl))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(PriceLbl))
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FinalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        reset();
        myGUI.changePanel("individualpart", "customer");
    }//GEN-LAST:event_CancelBtnActionPerformed

    protected void reset() {
        // reset labels
        Qty.setValue(0);
        PriceLbl.setText("");
        StockLbl.setText("");
        sortCmb.setSelectedIndex(0);

        itemList = db.queryCPU();
        updateJList();
    }

    public JSpinner getQty() {
        return Qty;
    }

    private void decrementStock(Item item) {
        int quantity = (int) Qty.getValue();
        // changes stock
        item.setStock(item.getStock() - quantity);
        // updates item in the database
        db.updateItem(item);
    }

    private void updateJList() {
        // add names from itemList to array for the JList
        String[] itemArray = new String[itemList.size()];
        for (int i = 0; i < itemArray.length; i++) {
            // checks if it is in stock
            if (itemList.get(i).getStock() > 0) {
                itemArray[i] = itemList.get(i).getName();
            }
        }

        // wipes and updates JList
        ComponentList.clearSelection();
        ComponentList.setListData(itemArray);
    }

    private void FinalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalBtnActionPerformed

        for (Item item : (ArrayList<Item>) itemList) {
            // checks if user selected a component
            if (ComponentList.getSelectedValue() != null) {
                // compares quantity to current stock
                if (item.getStock() >= (int) Qty.getValue()) {
                    decrementStock(item);
                    myGUI.getConfirmPage().displayQuantity();
                    myGUI.getConfirmPage().display(item);
                    reset();

                    myGUI.changePanel("individualpart", "confirm");
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Quantity chosen exceeds stock, please lower your quantity", "Error", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select one component", "Error", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }

    }//GEN-LAST:event_FinalBtnActionPerformed

    private void sortCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortCmbActionPerformed
        if (sortCmb.getSelectedIndex() != 0) {
            switch (sortCmb.getSelectedIndex()) {
                case 1: // sort by price
                    Collections.sort(itemList, new PriceSorter());
                    break;

                case 2: // sort by name
                    Collections.sort(itemList, new NameSorter());
                    break;
            }
            updateJList();
        }
    }//GEN-LAST:event_sortCmbActionPerformed

    private void ComponentListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComponentListMouseClicked
        Qty.setValue(0);
        for (Item item : (ArrayList<Item>) itemList) {
            // iterates through array to return the item which was selected
            if (item.getName().equalsIgnoreCase(ComponentList.getSelectedValue())) {
                PriceLbl.setText(Double.toString(item.getPrice()));
                StockLbl.setText(Integer.toString(item.getStock()));
            }
        }
    }//GEN-LAST:event_ComponentListMouseClicked

    private void ComponentCmbPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ComponentCmbPropertyChange

    }//GEN-LAST:event_ComponentCmbPropertyChange

    private void ComponentCmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComponentCmbItemStateChanged
        // resets labels
        Qty.setValue(0);
        PriceLbl.setText("");
        StockLbl.setText("");
        sortCmb.setSelectedIndex(0);

        switch (ComponentCmb.getSelectedIndex()) {
            case 0: // displays CPU
                // add names from cpuList to cpuArray for the JList
                itemList = db.queryCPU();
                updateJList();
                break;

            case 1: // displays MOBO
                // query database
                itemList = db.queryMOBO();
                updateJList();
                break;

            case 2: // displays RAM
                // query database
                itemList = db.queryRAM();
                updateJList();
                break;

            case 3: // displays GPU
                // query database
                itemList = db.queryGPU();
                updateJList();
                break;

            case 4: // displays PSU
                // query the database
                itemList = db.queryPSU();
                updateJList();
                break;

            case 5: // displays Case
                // query the database
                itemList = db.queryCase();
                updateJList();
                break;
        } // end of switch
    }//GEN-LAST:event_ComponentCmbItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBtn;
    private javax.swing.JComboBox<String> ComponentCmb;
    private javax.swing.JList<String> ComponentList;
    private javax.swing.JButton FinalBtn;
    private javax.swing.JLabel PriceLbl;
    private javax.swing.JSpinner Qty;
    private javax.swing.JLabel StockLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> sortCmb;
    // End of variables declaration//GEN-END:variables
}
