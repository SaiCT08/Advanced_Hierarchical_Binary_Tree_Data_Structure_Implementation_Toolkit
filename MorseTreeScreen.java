/**
 *
 * @author Sai Thupakula
 * 235420
 */

package binarytreeproject;
public class MorseTreeScreen extends javax.swing.JFrame 
{

    /**
     * Creates new form MorseTreeFrame
     */
    public MorseTreeScreen() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        morseArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        dotButton = new javax.swing.JButton();
        dashButton = new javax.swing.JButton();
        spaceButton = new javax.swing.JButton();
        slashButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        translateButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        translationArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        morseArea.setEditable(false);
        morseArea.setColumns(20);
        morseArea.setRows(5);
        jScrollPane1.setViewportView(morseArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jLabel1.setText("Morse Code:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 20));

        dotButton.setText("•");
        dotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dotButtonActionPerformed(evt);
            }
        });
        getContentPane().add(dotButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 70, -1));

        dashButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dashButton.setText("-");
        dashButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashButtonActionPerformed(evt);
            }
        });
        getContentPane().add(dashButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 70, -1));

        spaceButton.setText("Space");
        spaceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spaceButtonActionPerformed(evt);
            }
        });
        getContentPane().add(spaceButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        slashButton.setText("/");
        slashButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slashButtonActionPerformed(evt);
            }
        });
        getContentPane().add(slashButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 70, -1));

        jLabel2.setText("Space between letters");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 140, 20));

        translateButton.setText("Translate");
        translateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(translateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        translationArea.setEditable(false);
        translationArea.setColumns(20);
        translationArea.setRows(5);
        jScrollPane2.setViewportView(translationArea);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        jLabel3.setText("Translation:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, -1, -1));

        jLabel4.setText("Use slash between words");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void spaceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spaceButtonActionPerformed
        morseArea.append(" ");
    }//GEN-LAST:event_spaceButtonActionPerformed

    private void dotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dotButtonActionPerformed
        morseArea.append("•");
    }//GEN-LAST:event_dotButtonActionPerformed

    private void dashButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashButtonActionPerformed
        morseArea.append("-");
    }//GEN-LAST:event_dashButtonActionPerformed

    private void slashButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slashButtonActionPerformed
        morseArea.append("/\n");
    }//GEN-LAST:event_slashButtonActionPerformed

    private void translateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_translateButtonActionPerformed
        MorseTree decoder = new MorseTree("src/binarytreeproject/MorseCodeInput.dat");
        String text = morseArea.getText();
        text = text.replace("\n", "").replace("•", ".");
        translationArea.append(decoder.translateLines(text) + "\n");
        morseArea.setText("");
    }//GEN-LAST:event_translateButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        TitleFrame f1 = new TitleFrame();
        f1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dashButton;
    private javax.swing.JButton dotButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea morseArea;
    private javax.swing.JButton slashButton;
    private javax.swing.JButton spaceButton;
    private javax.swing.JButton translateButton;
    private javax.swing.JTextArea translationArea;
    // End of variables declaration//GEN-END:variables
}
