/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Proses_Aplikasi.EnkripsiFile;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
public class embed extends javax.swing.JFrame {
        public String lokasi;
        Algo_EOF eof = new Algo_EOF();
        private File CoverF, SecretF, Output,StegoFix;
        private String fileName;
    
    public embed() {
        initComponents();
        Clear();
        txtpilihgambar.setEnabled(false);
        txtpilihvideo.setEnabled(false);
        txtpilihpublickey.setEnabled(false);
        txtpenyimpanan.setEnabled(false);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Loading = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtpilihgambar = new javax.swing.JTextField();
        txtpilihvideo = new javax.swing.JTextField();
        txtpilihpublickey = new javax.swing.JTextField();
        txtpenyimpanan = new javax.swing.JTextField();
        btnpilihgambar = new javax.swing.JButton();
        btnpilihvideo = new javax.swing.JButton();
        btnpilihkey = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        btnembed = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        btnkeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 0));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText(":");

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("CV. MULTI KARYA INDONESIA");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Pilih Gambar");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Pilih Video");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Pilih Public Key");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Penyimpanan");

        btnpilihgambar.setText("Pilih");
        btnpilihgambar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpilihgambarActionPerformed(evt);
            }
        });

        btnpilihvideo.setText("Pilih");
        btnpilihvideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpilihvideoActionPerformed(evt);
            }
        });

        btnpilihkey.setText("Pilih Key");
        btnpilihkey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpilihkeyActionPerformed(evt);
            }
        });

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnembed.setText("Embed");
        btnembed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnembedActionPerformed(evt);
            }
        });

        btnbatal.setText("Batal");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        btnkeluar.setText("Keluar");
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(btnembed)
                .addGap(33, 33, 33)
                .addComponent(btnbatal)
                .addGap(38, 38, 38)
                .addComponent(btnkeluar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(96, 96, 96))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(Loading, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtpilihgambar)
                    .addComponent(txtpilihvideo)
                    .addComponent(txtpilihpublickey)
                    .addComponent(txtpenyimpanan, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnpilihvideo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnpilihkey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnpilihgambar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtpilihgambar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpilihgambar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtpilihvideo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpilihvideo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtpilihpublickey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpilihkey))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtpenyimpanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsimpan))
                .addGap(16, 16, 16)
                .addComponent(Loading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnembed)
                        .addComponent(btnbatal)
                        .addComponent(btnkeluar)))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed
        // TODO add your handling code here:
        frmmenuutama utama = new frmmenuutama();
        utama.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnkeluarActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        // TODO add your handling code here:
        Clear();
    }//GEN-LAST:event_btnbatalActionPerformed

    private void btnpilihgambarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpilihgambarActionPerformed
        // TODO add your handling code here:
         JFileChooser data = new JFileChooser ("D:\\");
        FileNameExtensionFilter filter = new FileNameExtensionFilter ("File Image","JPEG","JPG","PNG");
        data.setFileFilter(filter);
        data.setFileFilter(filter);
        
        int returnVal = data.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION){
            data.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            File file = data.getSelectedFile();
            lokasi = file.getParent();
            System.out.println("Ini File nya :" + file.getParent());
            String dir = file.getAbsolutePath();
            String a = data.getSelectedFile().toString();
            File myf = new File (a);
            long uk=myf.length();
            if (uk>2000000){
                JOptionPane.showMessageDialog(null,"Ukuran File Tidak Boleh Lebih Dari 2 MB","Warning", JOptionPane.INFORMATION_MESSAGE);
                txtpilihgambar.requestFocus();
            } else {
                txtpilihgambar.setText(dir);
            }
        }
    }//GEN-LAST:event_btnpilihgambarActionPerformed

    private void btnpilihvideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpilihvideoActionPerformed
        // TODO add your handling code here:
        JFileChooser FileIsi = new JFileChooser ("D://");
        FileNameExtensionFilter image = new FileNameExtensionFilter ("Audio","mp3","wav","mp4","wmv");
        FileIsi.setFileFilter(image);
        
        JFileChooser masuk = new JFileChooser ("./");
        masuk.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnVal = FileIsi.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION){
            File file = FileIsi.getSelectedFile();
            String dir = file.getAbsolutePath();
            try {
                txtpilihvideo.setText(file.getAbsolutePath());
//                    
             txtpilihvideo.setText(file.getAbsolutePath());
//                ImageIcon imageIcon = new ImageIcon((ImageIO.read(new File(txt_Image.getText()))));
//                
//                Image image2 = imageIcon.getImage();
//           int height = lbl_Cover.getWidth() * imageIcon.getIconHeight()/imageIcon.getIconWidth();
//           Image newimg = image2.getScaledInstance(lbl_Cover.getWidth(), height, java.awt.Image.SCALE_SMOOTH);
//           imageIcon = new ImageIcon(newimg);
//           lbl_Cover.setIcon(imageIcon);
        } catch (Exception ex){
               JOptionPane.showMessageDialog(null, "Video Tidak Bisa Terbuka", "Warning", JOptionPane.ERROR_MESSAGE);
               txtpilihvideo.setText("");
               //lbl_Cover.setIcon(null);
           }
            }
    }//GEN-LAST:event_btnpilihvideoActionPerformed

    private void btnpilihkeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpilihkeyActionPerformed
        // TODO add your handling code here:
        if (!(txtpilihgambar.getText().equals(""))){
            JFileChooser data = new JFileChooser ("D://");
            FileNameExtensionFilter filter = new FileNameExtensionFilter ("Public Key","PublicKey");
            data.setFileFilter(filter);
            data.setAcceptAllFileFilterUsed(false);
            int returnVal = data.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION){
                File file = data.getSelectedFile();
                String dir = file.getAbsolutePath();
                txtpilihpublickey.setText(dir);
            }
        } else {
            JOptionPane.showMessageDialog(null,"Silahkan Pilih Kunci Public Terlebih Dahulu!");
            txtpilihvideo.requestFocus();
        }
    }//GEN-LAST:event_btnpilihkeyActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
         String data = "D://";
       javax.swing.JFileChooser jfc = new JFileChooser(data);
       JFileChooser chooser = new JFileChooser("./") {
       public void approveSelection() {
            if (getSelectedFile().isFile()) {
              return;
          } else {
              super.approveSelection();
              }
         }
  };
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = jfc.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
           try {
        File directory = jfc.getSelectedFile();
        txtpenyimpanan.setText(directory.getAbsolutePath() );
        SecretF = jfc.getSelectedFile();

            } catch (Exception except) {
                //msg if opening fails
                JOptionPane.showMessageDialog(this, "File tidak valid!",
                "Error!", JOptionPane.INFORMATION_MESSAGE);
                txtpenyimpanan.setText("");
           }
        }
        else{
     }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnembedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnembedActionPerformed
        // TODO add your handling code here:
        Thread t = new Thread (new Runnable(){
        @Override
        public void run() {
        Loading.setIndeterminate(true);
           
    long start;
    long end;
    String Kunci = (txtpilihpublickey.getText());
    String fileName = (txtpilihgambar.getText());
    File file = new File (txtpilihgambar.getText());
    String fileOutput = lokasi;
    String Output = (txtpenyimpanan.getText());
    //String Master = (txt_Image.getText());
    File master = new File (txtpilihvideo.getText());
    int dot = fileName.lastIndexOf(".");
    int sep =fileName.replace("\\", "/").lastIndexOf("/");
    
    EnkripsiFile en = new EnkripsiFile();
    if (!(Kunci.equals("") || fileName.equals(""))){
        try{
            start = System.currentTimeMillis();
            en.setPublicKey(Kunci);
            eof.setPublicKey(Kunci);
            en.setFile(fileOutput.replace("\\", "/"), fileName.substring(sep + 1
            , dot), fileName.substring(dot + 1));
          
            //============== Menghitung Proses Dalam Detik ==================//
            en.encrypt(fileName.replace("\\", "/"));
            eof.EncodeFile(master, Output, file);
            File iniFile = new File(fileName);
            iniFile.delete();
            end = System.currentTimeMillis();
            JOptionPane.showMessageDialog(null, "Encode Berhasil Dengan Waktu :" 
            +((end - start)/1000.0) + "Detik","Pesan",JOptionPane.INFORMATION_MESSAGE);
            File isifile = new File(eof.getFileNameEncrypt());
            Runtime.getRuntime().exec("C:\\Windows\\explorer.exe " + isifile.getParent());
            Clear();
        } catch (IOException ex){
            Logger.getLogger(embed.class.getName()).log(Level.SEVERE, null, ex); 
            JOptionPane.showMessageDialog (null,"Gagal Melakukan Enkripsi", "Warning", JOptionPane.ERROR_MESSAGE);
            Clear();
        }
    } else {
        JOptionPane.showMessageDialog(null, "Silangkan Lengkapi Form Telebih Dahulu !","Warning", JOptionPane.INFORMATION_MESSAGE);
        Clear();
    }
     }
    });
     t.start();
    
    }//GEN-LAST:event_btnembedActionPerformed

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
            java.util.logging.Logger.getLogger(embed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(embed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(embed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(embed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new embed().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar Loading;
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnembed;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JButton btnpilihgambar;
    private javax.swing.JButton btnpilihkey;
    private javax.swing.JButton btnpilihvideo;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtpenyimpanan;
    private javax.swing.JTextField txtpilihgambar;
    private javax.swing.JTextField txtpilihpublickey;
    private javax.swing.JTextField txtpilihvideo;
    // End of variables declaration//GEN-END:variables

    private void Clear() {
        txtpilihgambar.setText("");
        txtpilihvideo.setText("");
        txtpilihpublickey.setText("");
        txtpenyimpanan.setText("");
    }
}