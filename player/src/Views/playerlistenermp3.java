/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.Playlist;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import javax.swing.UIManager;
/**
 *
 * @author helder
 */
public class playerlistenermp3 extends javax.swing.JFrame {
    Playlist pl = new Playlist();
    
    ArrayList updateList = new ArrayList();
    
    javazoom.jl.player.Player player;
    File simpan;
    
    /**
     * Creates new form playerlistenermp3
     */
    public playerlistenermp3() {
        initComponents();
    }

    
    void updateList(){
        updateList = pl.getListSong();
        DefaultListModel model = new DefaultListModel();
        for(int i = 0; i < updateList.size(); i++){
            int j = 1 + 1;
            model.add(i, j + " | " + ((File) updateList.get(i)).getName());
        }
        
        jPlaylist.setModel(model);
        
    } 
    
    //painel de controle
    void add(){
        pl.add(this);
        updateList();
    }
    
    void remover(){
        try {
            int willBeDeleted = jPlaylist.getLeadSelectionIndex(); //Será deletado
            pl.ls.remove(willBeDeleted);
            updateList();
        } catch (Exception e) {
        }
    }
    
    void up(){
        try {
            int s1 = jPlaylist.getLeadSelectionIndex();
            simpan = (File) pl.ls.get(s1);
            pl.ls.remove(s1);
            pl.ls.add(s1 - 1, simpan);
            updateList();
            jPlaylist.setSelectedIndex(s1-1);
        } catch (Exception e) {
        }
    }
    
    void down(){
        try {
            int s1 = jPlaylist.getLeadSelectionIndex();
            simpan = (File) pl.ls.get(s1);
            pl.ls.remove(s1);
            pl.ls.add(s1 + 1, simpan);
            updateList();
            jPlaylist.setSelectedIndex(s1 + 1);
        } catch (Exception e) {
        }
    }
    
    void abrir(){
        pl.abrirPls(this);
        updateList();
    }
    
    void salvar(){
        pl.salvarPlaylist(this);
        updateList();
    }
    
    File play1;
    static int a = 0;
    
    void rodar(){
        if(a == 0){
            try {
                int p1 = jPlaylist.getSelectedIndex();
                play1 = (File) this.updateList.get(p1);
                FileInputStream fis = new FileInputStream(play1);
                BufferedInputStream bis = new BufferedInputStream(fis);
                player = new javazoom.jl.player.Player(bis);
                a = 1;
            } catch (Exception e) {
                System.out.println("Problema no arquivo");
                System.out.println(e);
            }
            
            new Thread(){
                @Override                
                public void run(){
                    try {
                        player.play();
                    } catch (Exception e) {
                    
                    }
                }
            }.start();
        }else{
            player.close();
            a = 0;
            rodar();
        }
    }
    
    File sa;
    void proximo(){
        if(a == 0){
            try {
                int s1 = jPlaylist.getSelectedIndex() + 1;
                sa = (File) this.updateList.get(s1);
                FileInputStream fis = new FileInputStream(sa);
                BufferedInputStream bis = new BufferedInputStream(fis);
                player = new javazoom.jl.player.Player(bis);
                a = 1;
                jPlaylist.setSelectedIndex(s1);
            } catch (Exception e) {
                System.out.println("Problema no arquivo");
                System.out.println(e);
            }
            
            new Thread(){
                @Override                
                public void run(){
                    try {
                        player.play();
                    } catch (Exception e) {
                    
                    }
                }
            }.start();
        }else{
            player.close();
            a = 0;
            proximo();
        }
    }
    
    void voltar(){
    if(a == 0){
            try {
                int s1 = jPlaylist.getSelectedIndex() - 1;
                sa = (File) this.updateList.get(s1);
                FileInputStream fis = new FileInputStream(sa);
                BufferedInputStream bis = new BufferedInputStream(fis);
                player = new javazoom.jl.player.Player(bis);
                a = 1;
                jPlaylist.setSelectedIndex(s1);
            } catch (Exception e) {
                System.out.println("Problema no arquivo");
                System.out.println(e);
            }
            
            new Thread(){
                @Override                
                public void run(){
                    try {
                        player.play();
                    } catch (Exception e) {
                    
                    }
                }
            }.start();
        }else{
            player.close();
            a = 0;
            voltar();
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

        btnAdd = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnUp = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPlaylist = new javax.swing.JList<>();
        btnPause = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnAvancar = new javax.swing.JButton();
        btnPare = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemover.setText("REMOVER");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnUp.setText("UP");
        btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });

        btnDown.setText("DOWN");
        btnDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownActionPerformed(evt);
            }
        });

        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnAbrir.setText("ABRIR");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jPlaylist);

        btnPause.setText("||");

        btnVoltar.setText("|<");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnPlay.setText("PLAY");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        btnAvancar.setText(">|");
        btnAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancarActionPerformed(evt);
            }
        });

        btnPare.setText("[]");
        btnPare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPareActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDown, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAbrir, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(btnPare, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(btnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAvancar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUp)
                            .addComponent(btnAbrir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDown)
                            .addComponent(btnSave)
                            .addComponent(btnRemover))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnPare)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVoltar)
                            .addComponent(btnAvancar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPause)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpActionPerformed
        // TODO add your handling code here:
        up();
    }//GEN-LAST:event_btnUpActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       add();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // TODO add your handling code here:
        remover();
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        // TODO add your handling code here:
        rodar();
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        voltar();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarActionPerformed

        // TODO add your handling code here:
        proximo();
    }//GEN-LAST:event_btnAvancarActionPerformed

    private void btnDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownActionPerformed
        // TODO add your handling code here:
        down();
    }//GEN-LAST:event_btnDownActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        // TODO add your handling code here:
        abrir();
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        salvar();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnPareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPareActionPerformed
        // TODO add your handling code here:
        player.close();
    }//GEN-LAST:event_btnPareActionPerformed

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
            java.util.logging.Logger.getLogger(playerlistenermp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(playerlistenermp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(playerlistenermp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(playerlistenermp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new playerlistenermp3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAvancar;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnPare;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUp;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JList<String> jPlaylist;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private DefaultListModel DefaultListModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
