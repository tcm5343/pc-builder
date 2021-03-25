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

/**
 *
 * @author mbp5503
 */
public class BuildPC extends javax.swing.JPanel {

    private Mockup myGUI;
    private DB_Manager db = new DB_Manager();
    private ArrayList<? extends Item> itemList;
    protected ArrayList<Item> cart = new ArrayList<>();
    private int runningTotal;
    private int step;

    private final String[] COMPONENTS = new String[]{"CPU", "MOBO", "RAM", "GPU", "PSU", "Case"};

    /**
     * Creates new form BuildPC1
     */
    public BuildPC() {
        initComponents();

    }

    public BuildPC(Mockup m) {
        myGUI = m;
        initComponents();
        reset();
    }

    protected void reset() {
        // empties cart
        if (step > 0) {
            cart.clear();
            updateBuildList();
        }

        // updates labels and step
        step = 0;
        runningTotal = 0;
        PriceLbl.setText("");
        StockLbl.setText("");
        TotalPricetxt.setText("");
        sortCmb.setSelectedIndex(0);
        updateLabels();

        // add names from itemList to cpuArray for the JList
        itemList = db.queryCPU();
        updateJList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        NextBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ComponentList = new javax.swing.JList<>();
        PriceLbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        StockLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TotalPricetxt = new javax.swing.JTextField();
        ProgressBar = new javax.swing.JProgressBar();
        jScrollPane3 = new javax.swing.JScrollPane();
        CartJList = new javax.swing.JList<>();
        sortCmb = new javax.swing.JComboBox<>();

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Customize your PC");

        NextBtn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        NextBtn.setText("Next");
        NextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextBtnActionPerformed(evt);
            }
        });

        CancelBtn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

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
        ComponentList.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ComponentListPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(ComponentList);

        PriceLbl.setText(" ");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Stock:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setText("Price:");

        StockLbl.setText(" ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Component Type");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Components: ");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField1.setText("CPU");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Your Computer Build:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel4.setText("Total Price");

        TotalPricetxt.setEditable(false);

        ProgressBar.setMaximum(6);
        ProgressBar.setString("0 out of 6");
        ProgressBar.setStringPainted(true);

        jScrollPane3.setViewportView(CartJList);

        sortCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sort by:", "Price", "Name" }));
        sortCmb.setName(""); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
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
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(TotalPricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(118, 118, 118)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(sortCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(54, 54, 54))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(sortCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TotalPricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(StockLbl))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(PriceLbl))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );

        sortCmb.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        // empties cart
        if (step > 0) {
            cart.clear();
            updateBuildList();
        }

        reset();
        myGUI.changePanel("custompc", "customer");
    }//GEN-LAST:event_CancelBtnActionPerformed

    // insert check method here
    private void updateBuildList() {
        // updates build list
        String[] cartArray = new String[cart.size()];
        for (int i = 0; i < cartArray.length; i++) {
            cartArray[i] = cart.get(i).getName();
        }
        CartJList.clearSelection();
        CartJList.setListData(cartArray);
    }

    private void updateLabels() {
        // updates labels
        ProgressBar.setValue(step);
        ProgressBar.setString(Integer.toString(step) + " out of 6");
        jTextField1.setText(COMPONENTS[step]);
    }

    private void addToCart() {
        // adds selected component to cart and updates price
        for (Item item : itemList) {
            if ((item.getName().equalsIgnoreCase(ComponentList.getSelectedValue()))) {
                cart.add(item);
                runningTotal += item.getPrice();
                TotalPricetxt.setText("$" + Integer.toString(runningTotal));
            }
        }
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

    private void NextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextBtnActionPerformed

        // checks if user selected a component
        if (ComponentList.getSelectedValue() != null) {

            // resets labels
            PriceLbl.setText("");
            StockLbl.setText("");
            sortCmb.setSelectedIndex(0);
            step++;

            switch (step) {

                case 1: // displays MOBO
                    addToCart(); // adds previously selected component to cart
                    updateBuildList();
                    updateLabels();

                    // iterates through the cart and adds CPU socket type to query
                    for (Item item : cart) {
                        if ((item.getType().equalsIgnoreCase("CPU"))
                                && (item instanceof CPU)) {
                            itemList = db.queryMOBOSocket(((CPU) item).getSocket());
                            break;
                        }
                    }

                    updateJList();

                    break;

                case 2: // displays RAM
                    addToCart(); // adds previously selected component to cart
                    updateBuildList();
                    updateLabels();

                    // iterates through the cart and adds MOBO ramType to query
                    for (Item item : cart) {
                        if ((item.getName() != null)
                                && (item.getType().equalsIgnoreCase("MOBO"))
                                && (item instanceof MOBO)) {
                            itemList = db.queryRamType(((MOBO) item).getRamType());
                            break;
                        }
                    }

                    updateJList();

                    break;

                case 3: // displays GPU
                    addToCart(); // adds previously selected component to cart
                    updateBuildList();
                    updateLabels();

                    // queries the database
                    itemList = db.queryGPU();

                    updateJList();

                    break;

                case 4: // displays PSU
                    addToCart(); // adds previously selected component to cart
                    updateBuildList();
                    updateLabels();

                    // iterates through the cart and sums the total power consumption to query
                    int power = 0;
                    for (Item item : cart) {
                        if (item instanceof CPU) {
                            power += ((CPU) item).getPower();
                        } else if (item instanceof GPU) {
                            power += ((GPU) item).getPower();
                        }
                    }

                    // queries the database
                    itemList = db.queryPSUPower(power);

                    updateJList();

                    break;

                case 5: // displays Case
                    addToCart(); // adds previously selected component to cart
                    updateBuildList();
                    updateLabels();

                    NextBtn.setText("Finalize");

                    // iterates through the cart and adds MOBO size to query
                    for (Item item : cart) {
                        if ((item.getName() != null)
                                && (item.getType().equalsIgnoreCase("MOBO"))
                                && (item instanceof MOBO)) {
                            itemList = db.queryCaseSize(((MOBO) item).getSize());
                            break;
                        }
                    }

                    updateJList();

                    break;

                case 6: // directs to the confirmation page
                    addToCart(); // adds previously selected component to cart
                    db.updateCartStock(cart); // decrements all the items in the cart
                    
                    NextBtn.setText("Next");
                    myGUI.getConfirmPage().displayCart();
                    myGUI.changePanel("custompc", "confirm");

                    break;
            } // end of switch
        } else {
            JOptionPane.showMessageDialog(null, "Please select one component", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_NextBtnActionPerformed

    private void ComponentListPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ComponentListPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_ComponentListPropertyChange

    private void ComponentListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComponentListMouseClicked

        for (Item item : (ArrayList<Item>) itemList) {
            // iterates through array to return the item which was selected
            if (item.getName() != null && item.getName().equalsIgnoreCase(ComponentList.getSelectedValue())) {
                PriceLbl.setText(Double.toString(item.getPrice()));
                StockLbl.setText(Integer.toString(item.getStock()));
            }
        }
    }//GEN-LAST:event_ComponentListMouseClicked

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBtn;
    private javax.swing.JList<String> CartJList;
    private javax.swing.JList<String> ComponentList;
    private javax.swing.JButton NextBtn;
    private javax.swing.JLabel PriceLbl;
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JLabel StockLbl;
    private javax.swing.JTextField TotalPricetxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> sortCmb;
    // End of variables declaration//GEN-END:variables
}
