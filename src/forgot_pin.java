
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
public class forgot_pin extends javax.swing.JFrame {
 User_db b=new User_db();
    /**
     * Creates new form forgot_pin
     */
    public forgot_pin() {
        initComponents();
    }
    
    public forgot_pin(User_db b1) {
        b=b1;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nick = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        new_p = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        uid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText(" Enter Nick Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 149, -1, -1));

        nick.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nickActionPerformed(evt);
            }
        });
        getContentPane().add(nick, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 97, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Enter New Pin");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 192, 97, -1));

        new_p.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        new_p.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                new_pKeyPressed(evt);
            }
        });
        getContentPane().add(new_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 97, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Submit");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 244, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Enter User Id");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        uid.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        uid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                uidKeyPressed(evt);
            }
        });
        getContentPane().add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 97, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Forgot Pin");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 130, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nickActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       String id=uid.getText();
        b.u_id=id;
        int e=b.check_creds(1);
        if(e==1){
        if(uid.getText().equals("") || nick.getText().equals("") || new_p.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Fields are empty !!!");
             return;
        }
        
        if(new_p.getText().length()!=4){
            JOptionPane.showMessageDialog(null,"Pin must be of 4-Digit !!!");
             return;
        }
        if(nick.getText().toUpperCase().equals(b.nick_name)&& new_p.getText().equals(b.u_p)){
             JOptionPane.showMessageDialog(null,"New Pin should be different from old one !");
             return; }
        if(nick.getText().toUpperCase().equals(b.nick_name)&& !new_p.getText().equals(b.u_p)){
             String p=new_p.getText();
             b.change_pin(p);
              JOptionPane.showMessageDialog(null,"Pin successfully changed !");
              setVisible(false);
             return; }
        if(!(nick.getText().toUpperCase().equals(b.nick_name))){
             JOptionPane.showMessageDialog(null,"Nick Name didn't match !");
             System.out.println(b.nick_name);
             return; }
        }
        JOptionPane.showMessageDialog(null,"UID doesn't exits !!!");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void new_pKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_new_pKeyPressed
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isDigit(c) || Character.isISOControl(c) || c=='.')
            new_p.setEditable(true); 
        else
        new_p.setEditable(false);
    }//GEN-LAST:event_new_pKeyPressed

    private void uidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uidKeyPressed
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isDigit(c) || Character.isISOControl(c) || c=='.')
            uid.setEditable(true); 
        else
        uid.setEditable(false);
    }//GEN-LAST:event_uidKeyPressed

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
            java.util.logging.Logger.getLogger(forgot_pin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(forgot_pin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(forgot_pin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(forgot_pin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new forgot_pin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField new_p;
    private javax.swing.JTextField nick;
    private javax.swing.JTextField uid;
    // End of variables declaration//GEN-END:variables
}
