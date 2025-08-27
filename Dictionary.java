package binarytreeproject;

/**
 *
 * @author Sai Thupakula
 * 235420
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dictionary extends javax.swing.JFrame 
{

    private BSTree<String> dictionaryTree;
    
    /**
     * Creates new form Dictionary
     */
    public Dictionary()
    {
        initComponents();
        loadDictionary();
    }
    
    private void loadDictionary() 
    {
        ArrayList<String> wordList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/binarytreeproject/BSTDictionary.txt"))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                wordList.add(line.trim());
            }
        } 
        catch (IOException ex) 
        {
        }
        dictionaryTree = new BSTree<>(wordList.get(0));
        dictionaryTree.buildBalancedTree(wordList);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        stemField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        wordArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listButton.setText("List All Words");
        listButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listButtonActionPerformed(evt);
            }
        });
        getContentPane().add(listButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel1.setText("Word Stem:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 160, -1, -1));

        stemField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stemFieldKeyReleased(evt);
            }
        });
        getContentPane().add(stemField, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 190, 70, -1));

        wordArea.setColumns(20);
        wordArea.setRows(5);
        jScrollPane1.setViewportView(wordArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 55, 190, 220));

        jLabel2.setText("Word Search");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listButtonActionPerformed
        ArrayList<String> allWords = dictionaryTree.inOrder();
        wordArea.setText("");
        for (String word : allWords) 
        {
            wordArea.append(word + "\n");
        }
    }//GEN-LAST:event_listButtonActionPerformed

    private void stemFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stemFieldKeyReleased
        String text = stemField.getText();
        String upperText = text.toUpperCase();
        if (!text.equals(upperText)) 
        {
            stemField.setText(upperText);
        }
        
        String stem = upperText.trim();
        ArrayList<String> results;
        if (stem.isEmpty())
        {
            results = dictionaryTree.inOrder();
        } 
        else 
        {
            results = dictionaryTree.getGroup(stem, new FindWords());
        }
        
        wordArea.setText("");
        for (String word : results) 
        {
            wordArea.append(word + "\n");
        }
    }//GEN-LAST:event_stemFieldKeyReleased

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        TitleFrame f1 = new TitleFrame();
        f1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listButton;
    private javax.swing.JTextField stemField;
    private javax.swing.JTextArea wordArea;
    // End of variables declaration//GEN-END:variables
}
