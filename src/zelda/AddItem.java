/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zelda;

import DAO.ItemDAO;
import DAO.ProductDAO;
import DTO.ComboItem;
import DTO.ItemDTO;
import DTO.ProductDTO;
import System.ImagePrinter;
import System.QRCodeGenerator;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import zeldacon.PERIOD;
import zeldacon.SerialConnection;

/**
 *
 * @author User
 */
public class AddItem extends javax.swing.JFrame {

    /**
     * Creates new form AddItem
     */
    BufferedImage image;
    private static AddItem form;
    
    private AddItem() {
        initComponents();
    }
    
    public static AddItem getForm(){
        if(form == null){
            form = new AddItem();
            form.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
        form.updateProductNameCombo();
        return form;
    }

    public boolean validateForm(){
        //Validate null input
        if(txtItemId.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Item ID cannot be null", "Validaion error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        //Validate whether the given input is a number
        try{
            Integer.parseInt(txtItemId.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Item ID should be a number", "Validaion error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
       
        //validation succeful
        return true;
    }
    
    public void clearForm(){
        txtItemId.setText("");
    }
    
    public void updateProductNameCombo(){
        //clear product selection combo
        cmbProductName.removeAllItems();
        
        //Load product names from the local data source
        ArrayList<ComboItem> comboItems = new ProductDAO().getAllProductsToCombo();
        
        //Bind data to the combobox
        for(ComboItem item: comboItems){
            cmbProductName.addItem(item);
        }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtItemId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtItemDescription = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbItemType = new javax.swing.JComboBox();
        txtItemPrice = new javax.swing.JTextField();
        btnScan = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        cmbProductName = new javax.swing.JComboBox();
        btnViewQR = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Item Id");

        jLabel2.setText("Name");

        jLabel3.setText("Description");

        txtItemId.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtItemIdCaretUpdate(evt);
            }
        });
        txtItemId.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtItemIdInputMethodTextChanged(evt);
            }
        });
        txtItemId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemIdActionPerformed(evt);
            }
        });

        txtItemDescription.setColumns(20);
        txtItemDescription.setRows(5);
        txtItemDescription.setEnabled(false);
        jScrollPane1.setViewportView(txtItemDescription);

        jLabel4.setText("Type");

        jLabel5.setText("Price");

        cmbItemType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Electronic", "Education", "Food", "Clothe", "Other" }));
        cmbItemType.setEnabled(false);

        txtItemPrice.setEnabled(false);

        btnScan.setText("Scan");
        btnScan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScanActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        cmbProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProductNameActionPerformed(evt);
            }
        });
        cmbProductName.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbProductNamePropertyChange(evt);
            }
        });

        btnViewQR.setText("Print QR");
        btnViewQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewQRActionPerformed(evt);
            }
        });

        lblImage.setBackground(new java.awt.Color(153, 153, 153));
        lblImage.setPreferredSize(new java.awt.Dimension(250, 250));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtItemId, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnScan))
                    .addComponent(txtItemPrice)
                    .addComponent(cmbItemType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(cmbProductName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(btnViewQR, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtItemId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnScan)
                    .addComponent(btnViewQR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbItemType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnScanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScanActionPerformed
        SerialConnection con = new SerialConnection(new SerialConnection.PortListner() {
            @Override
            public void onReceived(String data) {
                txtItemId.setText(data);
            }
        }, PERIOD.TEMPORARY);
        con.listen(); 
    }//GEN-LAST:event_btnScanActionPerformed

    private void cmbProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProductNameActionPerformed
        //Retrieve selected item
        ComboItem item = (ComboItem)cmbProductName.getSelectedItem();
        
        //Load the relavent product from the local source
        ProductDTO product = new ProductDAO().getProductById(item.getKey());
        
        //Update rest of the GUI components with product data
        txtItemDescription.setText(product.getDescription());
        cmbItemType.setSelectedItem(product.getType());
        txtItemPrice.setText(String.valueOf(product.getPrice()));
    }//GEN-LAST:event_cmbProductNameActionPerformed

    private void cmbProductNamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbProductNamePropertyChange
        
    }//GEN-LAST:event_cmbProductNamePropertyChange

    private void btnViewQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewQRActionPerformed
        if(image == null){
            JOptionPane.showMessageDialog(null, "No image to print", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        new Thread(new ImagePrinter(image)).start();
        /*
        if(!txtItemId.getText().equals("")){
            //Create QR code generating interface
            QRCodeGenerator qr = new QRCodeGenerator();
            
            //Get the generated bufferef image
            BufferedImage image = qr.createQR(txtItemId.getText());
            
            //Set dimension of the container
            lblImage.setSize(image.getWidth(), image.getHeight());
            
            //Bind the image
            lblImage.setIcon(new ImageIcon(image));
        }else{
            //For null input bind null image 
            lblImage.setIcon(null);
        }
        */
    }//GEN-LAST:event_btnViewQRActionPerformed

    private void txtItemIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemIdActionPerformed
        
    }//GEN-LAST:event_txtItemIdActionPerformed

    private void txtItemIdInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtItemIdInputMethodTextChanged
        
    }//GEN-LAST:event_txtItemIdInputMethodTextChanged

    private void txtItemIdCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtItemIdCaretUpdate
        if(!txtItemId.getText().equals("")){
            //Create QR code generating interface
            QRCodeGenerator qr = new QRCodeGenerator();
            
            //Get the generated bufferef image
            image = qr.createQR(txtItemId.getText());
            
            //Set dimension of the container
            lblImage.setSize(image.getWidth(), image.getHeight());
            
            //Bind the image
            lblImage.setIcon(new ImageIcon(image));
        }else{
            //For null input bind null image 
            lblImage.setIcon(null);
        }
    }//GEN-LAST:event_txtItemIdCaretUpdate

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(validateForm()){
            ComboItem item = (ComboItem)cmbProductName.getSelectedItem();
            ProductDTO product = new ProductDAO().getProductById(item.getKey());
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setId(Integer.parseInt(txtItemId.getText()));
            itemDTO.setProductId(product.getId());
            itemDTO.setStatus("U");
            ItemDAO itemDAO = new ItemDAO();
            itemDAO.insert(itemDTO);
            clearForm();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnScan;
    private javax.swing.JButton btnViewQR;
    private javax.swing.JComboBox cmbItemType;
    private javax.swing.JComboBox cmbProductName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTextArea txtItemDescription;
    private javax.swing.JTextField txtItemId;
    private javax.swing.JTextField txtItemPrice;
    // End of variables declaration//GEN-END:variables
}