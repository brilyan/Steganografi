/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Proses_Aplikasi.SecretStego;
import Proses_Aplikasi.Session;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
public class retrieve extends javax.swing.JFrame {

    private Integer d;
    private BigInteger n;
    BufferedReader fileReader_1;
    String strChiper ="", mypathout_1="" ;
    private File CoverF, SecretF, Output, StegoFix;
    private String fileNameDecrypt, data;
    public String lokasi;
    Algo_EOF eof= new Algo_EOF(); 
    private String Stego;
    public retrieve() {
        initComponents();
        txtpilihvideor.setEnabled(false);
        txtpilihprivatekeyr.setEnabled(false);
        txtpenyimpananr.setEnabled(false);
        Clear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Loading2 = new javax.swing.JProgressBar();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtpilihprivatekeyr = new javax.swing.JTextField();
        txtpilihvideor = new javax.swing.JTextField();
        txtpenyimpananr = new javax.swing.JTextField();
        btnpilihr = new javax.swing.JButton();
        btnpilihkeyr = new javax.swing.JButton();
        btnsimpanr = new javax.swing.JButton();
        btnretriever = new javax.swing.JButton();
        btnbatalr = new javax.swing.JButton();
        btnkeluarr = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(102, 204, 0));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText(":");

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("CV. MULTI KARYA INDONESIA");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("Pilih Video");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("Pilih Private Key");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("Penyimpanan");

        btnpilihr.setText("Pilih");
        btnpilihr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpilihrActionPerformed(evt);
            }
        });

        btnpilihkeyr.setText("Pilih Key");
        btnpilihkeyr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpilihkeyrActionPerformed(evt);
            }
        });

        btnsimpanr.setText("Simpan");
        btnsimpanr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanrActionPerformed(evt);
            }
        });

        btnretriever.setText("Retrieve");
        btnretriever.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnretrieverActionPerformed(evt);
            }
        });

        btnbatalr.setText("Batal");
        btnbatalr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalrActionPerformed(evt);
            }
        });

        btnkeluarr.setText("Keluar");
        btnkeluarr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(96, 96, 96))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(Loading2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtpilihvideor)
                            .addComponent(txtpilihprivatekeyr)
                            .addComponent(txtpenyimpananr, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnpilihkeyr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnsimpanr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnpilihr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(btnretriever)
                        .addGap(18, 18, 18)
                        .addComponent(btnbatalr)
                        .addGap(18, 18, 18)
                        .addComponent(btnkeluarr)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtpilihvideor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnpilihr))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtpilihprivatekeyr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnpilihkeyr)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtpenyimpananr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsimpanr))
                .addGap(23, 23, 23)
                .addComponent(Loading2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnretriever)
                    .addComponent(btnbatalr)
                    .addComponent(btnkeluarr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnpilihkeyrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpilihkeyrActionPerformed
        // TODO add your handling code here:
        if (!(txtpilihvideor.getText().equals(""))){
            JFileChooser data = new JFileChooser ("D://");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Kunci Private","PrivateKey","PrivateKey");
            data.setFileFilter(filter);
            data.setAcceptAllFileFilterUsed(false);
            int returnVal = data.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION){
                File file = data.getSelectedFile();
                String dir = file.getAbsolutePath();
                txtpilihprivatekeyr.setText(dir);
            }
        }
    }//GEN-LAST:event_btnpilihkeyrActionPerformed

    private void btnkeluarrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarrActionPerformed
        // TODO add your handling code here:
        frmmenuutama utama = new frmmenuutama();
        utama.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnkeluarrActionPerformed

    private void btnbatalrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalrActionPerformed
        // TODO add your handling code here:
        Clear();
    }//GEN-LAST:event_btnbatalrActionPerformed

    private void btnpilihrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpilihrActionPerformed
        // TODO add your handling code here:
        JFileChooser datafile = new JFileChooser ("D:/");
        FileNameExtensionFilter Image = new FileNameExtensionFilter ("Audio","mp3","wav","mp4");
        datafile.setFileFilter(Image);
        JFileChooser chooser = new JFileChooser ("./");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnVal = datafile.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION){
            File file = datafile.getSelectedFile();
            String dir = file.getAbsolutePath();
            try{
                txtpilihvideor.setText(file.getAbsolutePath());
                File master2 = new File (txtpilihvideor.getText());
                SecretStego.setCheck(master2);
                if (SecretStego.getCheck().equals("TIDAK TERSEDIA")){
                    btnretriever.setEnabled(false);
                }
                else
                 btnretriever.setEnabled(true);      
                txtpilihvideor.setText(file.getAbsolutePath());
//                ImageIcon imageIcon = new ImageIcon((ImageIO.read(new File(txt_Image.getText())))); // load the image to a imageIcon
//                String info = "<html>Resolusi Gambar = " + imageIcon.getIconWidth() + " x " + imageIcon.getIconHeight() + "pixel<br>"
//                + "Besar File = " + file.length() + "byte<br>"
//                + "Max-bit yang ditampung = " + (3 * imageIcon.getIconWidth() * imageIcon.getIconHeight()) + "bit</html>";
//                Image image = imageIcon.getImage(); // transform it
//                int height = lbl_Cover.getWidth() * imageIcon.getIconHeight() / imageIcon.getIconWidth();
//                Image newimg = image.getScaledInstance(lbl_Cover.getWidth(), height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
//                imageIcon = new ImageIcon(newimg);  // transform it back
//                lbl_Cover.setIcon(imageIcon);
//                lblInfo.setText(info);
            } catch (Exception except) {
                //msg if opening fails
                JOptionPane.showMessageDialog(this, "Video tidak dapat dibuka!",
                        "Error!", JOptionPane.INFORMATION_MESSAGE);
                txtpilihvideor.setText("");
              //  lbl_Cover.setIcon(null);
            } 
        }
    }//GEN-LAST:event_btnpilihrActionPerformed

    private void btnsimpanrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanrActionPerformed
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
                txtpenyimpananr.setText(directory.getAbsolutePath() );
                SecretF = jfc.getSelectedFile();

            } catch (Exception except) {
                //msg if opening fails
                JOptionPane.showMessageDialog(this, "File tidak valid!",
                        "Error!", JOptionPane.INFORMATION_MESSAGE);
                txtpenyimpananr.setText("");
            }
        }
        else{
        }
    }//GEN-LAST:event_btnsimpanrActionPerformed

    private void btnretrieverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnretrieverActionPerformed
        // TODO add your handling code here:
        Thread t;
            t = new Thread (new Runnable(){
                @Override
                public void run(){
                    Loading2.setIndeterminate(true); //Untuk Proses Loading                   
                    long start;
                    long end;                
                    try { 
                        aksi_decode();
                    } catch (IOException ex) {
                        Logger.getLogger(retrieve.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        t.start();
    }//GEN-LAST:event_btnretrieverActionPerformed

    public boolean aksi_decode () throws IOException{
        Loading2.setIndeterminate(true);
        String Stego = txtpilihvideor.getText();
        Output = new File (Stego);
        String dir = Output.getAbsolutePath();
        String Secret = txtpenyimpananr.getText();
        File getStego = new  File (Stego);
        File getSecret = new File (Secret);
        String Kunci = (txtpilihprivatekeyr.getText());
        long start;
        long end;
        
        if (eof.DecodeFile(Output, getSecret)){
        start = System.currentTimeMillis();
        setPrivateKey (Kunci);
        ProsesDekrip(eof.getPath());
        end = System.currentTimeMillis();
        JOptionPane.showMessageDialog (null,eof.getMessage(),"Pesan", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Retrieve Berhasil dengan waktu :" + ((end - start) / 1000.0) 
        + "Detik :", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        Clear();
        } else 
            JOptionPane.showMessageDialog(null, "Silahkan Lengkapi Form Terlebih Dahulu","Warning",JOptionPane.INFORMATION_MESSAGE);
    return true;
    }
    //=========================== Proses Dekripsi ==============================//
 public void ProsesDekrip(String file) throws IOException{
     if (txtpenyimpananr.getText().equals("")) {
     JOptionPane.showMessageDialog(null, "Pilih file dan masukkan password terlebih dahulu  !");
     }else{
     String fileoutput = txtpenyimpananr.getText();
              //int dot = fileoutput.lastIndexOf(".");
             // int sep = fileoutput.replace("\\", "/").lastIndexOf("/");
     System.out.println("Sedang Melakukan Proses Dekripsi");
     fileReader_1 = new BufferedReader(new FileReader(file));
     long len = file.length();
     String current;
     String data = "";
     for(int i=0; i<len; i++){
     while((current = fileReader_1.readLine()) != null){
     strChiper += current;
     }
        }
     String ubl = strChiper.substring(strChiper.lastIndexOf("09-09-94")+12);
     String[] data1 = ubl.split(" "); //menghilangkan spasi 8
     String kompress = data;
             //=========== Proses Decompresi =======================//
//      Algoritma_LZW xx = new Algoritma_LZW();
       // List<Short>kompressback = Algoritma_LZW.back(kompress);
      //String decompressed = decompress(kompressback);
       //String[] data1 = decompressed.split(" ");
          //============================ End =======================//
      BigInteger[] data2 = new BigInteger[data1.length];
      for (int i=0; i < data1.length; i++){
      data2[i] = (new BigInteger(String.valueOf(data1[i]))).pow(this.d);
      data2[i] = data2[i].mod(this.n);
             }
            byte[] data3 = new byte[data2.length];
            for (int i=0; i < data2.length; i++){
            data3[i] = (byte) (data2[i].byteValue());  
            } 
             String filename = file;
             String fileout = txtpenyimpananr.getText();
             int dot1 = filename.lastIndexOf(".");
             int sep1 = filename.replace("\\", "/").lastIndexOf("/");
             this.setFileDecrypt(fileout.replace("\\", "/"), filename.substring(sep1 + 1, dot1), filename.substring(dot1 + 1)  );
             this.saveDecryption(data3);
             
          }
    }
    //============== Set Private Key ==========================//
public void setPrivateKey (String filePrivate){
    BufferedReader br = null;
    try {
        int batas = 0;
        String current;
         br = new BufferedReader(new FileReader(filePrivate));
        while ((current = br.readLine()) != null){
        if (batas == 1) {
                    this.n = new BigInteger(current);
                    Session.setN(current);
                } else if (batas == 2) {
                    this.d = new Integer(current);
                    Session.setD(current);
                } else {
                    Session.setId(current);
                }
                batas++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("nilai n : " + this.n);
        System.out.println("nilai d : " + this.d);
        System.out.println("id : " + Session.getId());
    }
    private void saveDecryption (byte[] dataDecrypt) throws IOException {
    Path path = Paths.get(this.fileNameDecrypt);
    Files.write(path, dataDecrypt);
    System.out.println("File Berhasil Di Dekripsi, Lihat di Directory :" + this.fileNameDecrypt);
}
    public void setFileDecrypt (String directory, String filename, String extens){
    this.fileNameDecrypt = directory + "/" + "Documment_" + filename + "." + extens;
   // lokasi = fileNameDecrypt;
    System.out.println(fileNameDecrypt);
}
    public static BufferedImage resize(BufferedImage img, int 
        newW, int newH) {
               int w = img.getWidth();
               int h = img.getHeight();
               BufferedImage dimg = dimg = new BufferedImage(newW, newH,
               img.getType());
               Graphics2D g = dimg.createGraphics();
               g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
               RenderingHints.VALUE_INTERPOLATION_BILINEAR);
               g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
               g.dispose();
               return dimg;
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
            java.util.logging.Logger.getLogger(retrieve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(retrieve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(retrieve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(retrieve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new retrieve().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar Loading;
    private javax.swing.JProgressBar Loading1;
    private javax.swing.JProgressBar Loading2;
    private javax.swing.JButton btnbatalr;
    private javax.swing.JButton btnkeluarr;
    private javax.swing.JButton btnpilihgambar;
    private javax.swing.JButton btnpilihgambar1;
    private javax.swing.JButton btnpilihkeyr;
    private javax.swing.JButton btnpilihr;
    private javax.swing.JButton btnretriever;
    private javax.swing.JButton btnsimpanr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtpenyimpanan;
    private javax.swing.JTextField txtpenyimpanan1;
    private javax.swing.JTextField txtpenyimpananr;
    private javax.swing.JTextField txtpilihgambar;
    private javax.swing.JTextField txtpilihgambar1;
    private javax.swing.JTextField txtpilihprivatekeyr;
    private javax.swing.JTextField txtpilihpublickey;
    private javax.swing.JTextField txtpilihpublickey1;
    private javax.swing.JTextField txtpilihvideo;
    private javax.swing.JTextField txtpilihvideo1;
    private javax.swing.JTextField txtpilihvideor;
    // End of variables declaration//GEN-END:variables

    private void Clear() {
        Loading2.setIndeterminate (false);
        txtpilihvideor.setText("");
        txtpilihprivatekeyr.setText("");
        txtpenyimpananr.setText("");
    }
}
