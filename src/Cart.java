
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KIIT
 */
public class Cart extends javax.swing.JFrame {
 Order_db o=new Order_db();
 User_db b=new User_db();
    /**
     * Creates new form Cart
     */
    public Cart() {
        
        initComponents();
       total_price.setVisible(false);
        
    }
    
    public Cart(User_db b1) {
        o.u_id=b.u_id;
        b=b1;
        initComponents();
        total_price.setVisible(false);
        checkout.setVisible(false);
        jTextArea1.setText("\t  Your Cart is Emptyy !!!\n\n");
        
    }
    
    public Cart(User_db b1,Order_db o1) {
        o=o1;
        b=b1;
       // System.out.println("hiiiii");
        initComponents();
        total_price.setVisible(false);
        order_list();
        
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
        jTextArea1 = new javax.swing.JTextArea();
        checkout = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        total_price = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setText("Item\t\t\t"+"Quantity\t\t"+"Price\n\n");
        jTextArea1.setEditable(false);
        jTextArea1.setColumns(3);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextArea1.setRows(6);
        jTextArea1.setOpaque(false);
        jTextArea1.setBackground(new java.awt.Color(0,0,0,0));
        jScrollPane1.setViewportView(jTextArea1);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setOpaque(false);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 510, 190));

        checkout.setText("Checkout");
        checkout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkoutMouseClicked(evt);
            }
        });
        checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutActionPerformed(evt);
            }
        });
        getContentPane().add(checkout, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, -1));

        jButton2.setText("Close");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 90, -1));

        total_price.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(total_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 170, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkoutMouseClicked
        // TODO add your handling code here:   
//        o.items_count=0;
//        o.place_order();
//        o.insert_order();
//         
//         new Home(new Order_db(),o.u_id).setVisible(true);
//         dispose();

  new Order_summary(b,o).setVisible(true);
  dispose();
    }//GEN-LAST:event_checkoutMouseClicked

    private void checkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkoutActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        //System.out.println(o.u_id);
       // System.out.println(o.name[0]+" "+o.name[1]);
        new Home(b).setVisible(true);
         dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
    
     void order_list()
    {
        int i=0;
       double total=0.0;
        if(o.items_count==0){
            jTextArea1.setText("\t\tYour Cart is Empty !!!");
            checkout.setVisible(false);
            total_price.setVisible(false);
            return;}
        while(i<6){
         if(o.quantity[i]!=0){  
       if(o.name[i].length()>13) 
        jTextArea1.append(o.name[i].substring(0, Math.min(o.name[i].length(), 10)).concat("...")+"\t\t\t"+o.quantity[i]+"\t\t"+o.price[i]+"\n");
        
         
          else
              jTextArea1.append(o.name[i]+"\t\t\t"+o.quantity[i]+"\t\t"+o.price[i]+"\n");
            
          total+=o.price[i];
         }
            
        i++;
        }   
        total=Home.change(total);
        total_price.setVisible(true);
        
         total_price.setText("Total Price : "+total);   
    }
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
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cart().setVisible(true); 
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkout;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel total_price;
    // End of variables declaration//GEN-END:variables
}
