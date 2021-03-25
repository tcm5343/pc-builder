/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.*;

/**
 *
 * @author mbp5503
 */
public class AddComp extends javax.swing.JPanel {

    private Mockup myGUI;
    private DB_Manager db = new DB_Manager();

    /**
     * Creates new form AddComp1
     */
    public AddComp() {
        initComponents();
    }

    public AddComp(Mockup m) {
        myGUI = m;
        initComponents();
        ComponentCmb.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComponentCmb = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Pricetxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CancelBtn = new javax.swing.JButton();
        Stocktxt = new javax.swing.JTextField();
        UpdateListBtn = new javax.swing.JButton();
        AddTxt1 = new javax.swing.JTextField();
        AddTxt2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Nametxt = new javax.swing.JTextField();
        AddTxt3 = new javax.swing.JTextField();
        AddLabel1 = new javax.swing.JLabel();
        AddLabel2 = new javax.swing.JLabel();
        AddLabel3 = new javax.swing.JLabel();

        ComponentCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPU", "GPU", "MOBO", "RAM", "PSU", "Case" }));
        ComponentCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComponentCmbActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Price (double)");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Component type");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Add Items");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("Stock (int)");

        CancelBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        UpdateListBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        UpdateListBtn.setText("Update List");
        UpdateListBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateListBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("Name (String)");

        AddTxt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTxt3ActionPerformed(evt);
            }
        });

        AddLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        AddLabel1.setText("Label1");

        AddLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        AddLabel2.setText("Label2");

        AddLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        AddLabel3.setText("Label3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CancelBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Nametxt)
                                .addComponent(Stocktxt)
                                .addComponent(Pricetxt)
                                .addComponent(jLabel4)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ComponentCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addComponent(UpdateListBtn)
                        .addGap(94, 94, 94))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AddTxt3)
                            .addComponent(AddTxt2)
                            .addComponent(AddTxt1)
                            .addComponent(AddLabel3)
                            .addComponent(AddLabel2)
                            .addComponent(AddLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComponentCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(AddLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(AddLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Pricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(AddLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Stocktxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(112, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CancelBtn)
                            .addComponent(UpdateListBtn))
                        .addGap(49, 49, 49))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        myGUI.changePanel("additem", "manager");
        // TODO add your handling code here:
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void UpdateListBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateListBtnActionPerformed
        String name = Nametxt.getText();
        double price = Double.parseDouble(Pricetxt.getText());
        int stock = Integer.parseInt(Stocktxt.getText());
        String text1 = AddTxt1.getText();
        String text2 = AddTxt2.getText();
        String text3 = AddTxt3.getText();
        switch (ComponentCmb.getSelectedIndex()) {
            case 0: // displays CPU
                String cpuSocket = text1;
                int power = Integer.parseInt(text2);
                // CPU(String name, String type, double price, int sku, int stock, String socket, int power){
                CPU cpu = new CPU(name, "CPU", price, DB_Manager.getSku(), stock, cpuSocket, power);
                db.insertItem(cpu);
                break;

            case 1: // displays GPU
                int gpuPower = Integer.parseInt(text1);
                // GPU(String name, String type, double price, int sku, int stock, int power)
                GPU gpu = new GPU(name, "GPU", price, DB_Manager.getSku(), stock, gpuPower);
                System.out.println("name "+gpu.getName());
                System.out.println("sku "+gpu.getSku());
                System.out.println("power "+gpu.getPower());
                System.out.println("price "+gpu.getPrice());
                System.out.println("stock "+gpu.getStock());
                System.out.println("type "+gpu.getType());
                db.insertItem(gpu);
                break;

            case 2: // displays MOBO
                int size = Integer.parseInt(text1);
                int ramType = Integer.parseInt(text2);
                String moboSocket = text3;
//                String name, String type, double price, int sku, int stock, int size,int ramType, String socket
                MOBO mobo = new MOBO(name, "MOBO", price, DB_Manager.getSku(), stock, size, ramType, moboSocket);
                db.insertItem(mobo);
                break;

            case 3: // displays RAM
                int ramType1 = Integer.parseInt(text1);
//              String name, String type, double price, int sku, int stock, int ramType
                RAM ram = new RAM(name, "RAM", price, DB_Manager.getSku(), stock, ramType1);
                db.insertItem(ram);
                break;

            case 4: // displays PSU
                int modular = Integer.parseInt(text1);
                int psuPower = Integer.parseInt(text2);
//                String name, String type, double price, int sku, int stock, int modular, int power
                PSU psu = new PSU(name, "PSU", price, DB_Manager.getSku(), stock, modular, psuPower);
                db.insertItem(psu);
                break;

            case 5: // displays Case
                int caseSize = Integer.parseInt(text1);
//                String name, String type, double price, int sku, int stock, int size
                Case case1 = new Case(name, "Case", price, DB_Manager.getSku(), stock, caseSize);
                db.insertItem(case1);
                break;
        } // end of switch

    }//GEN-LAST:event_UpdateListBtnActionPerformed

    private void AddTxt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTxt3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddTxt3ActionPerformed

    private void ComponentCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComponentCmbActionPerformed
        switch (ComponentCmb.getSelectedIndex()) {
            case 0:
                AddLabel1.setText("Socket (String)");
                AddLabel2.setText("Power (Int)");
                AddLabel3.setVisible(false);
                AddTxt3.setVisible(false);
                break;
            case 1:
                AddLabel1.setText("Power (Int)");
                AddLabel2.setVisible(false);
                AddTxt2.setVisible(false);
                AddLabel3.setVisible(false);
                AddTxt3.setVisible(false);
                break;
            case 2:
                AddLabel1.setText("Size (Int)");
                AddLabel2.setVisible(true);
                AddLabel2.setText("RAM Type (Int)");
                AddTxt2.setVisible(true);
                AddLabel3.setVisible(true);
                AddLabel3.setText("Socket (String)");
                AddTxt3.setVisible(true);

                break;
            case 3:
                AddLabel1.setText("RAM Type (Int)");
                AddLabel2.setVisible(false);
                AddTxt2.setVisible(false);
                AddLabel3.setVisible(false);
                AddTxt3.setVisible(false);
                break;
            case 4:
                AddLabel1.setText("Modular (Int)");
                AddLabel2.setVisible(true);
                AddLabel2.setText("Power (Int)");
                AddTxt2.setVisible(true);
                AddLabel3.setVisible(false);
                AddTxt3.setVisible(false);

                break;
            case 5:
                AddLabel1.setText("Size (Int)");
                AddLabel2.setVisible(false);
                AddTxt2.setVisible(false);
                AddLabel3.setVisible(false);
                AddTxt3.setVisible(false);
                break;
        }
    }//GEN-LAST:event_ComponentCmbActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddLabel1;
    private javax.swing.JLabel AddLabel2;
    private javax.swing.JLabel AddLabel3;
    private javax.swing.JTextField AddTxt1;
    private javax.swing.JTextField AddTxt2;
    private javax.swing.JTextField AddTxt3;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JComboBox<String> ComponentCmb;
    private javax.swing.JTextField Nametxt;
    private javax.swing.JTextField Pricetxt;
    private javax.swing.JTextField Stocktxt;
    private javax.swing.JButton UpdateListBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
