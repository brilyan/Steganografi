
package Proses_Aplikasi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JProgressBar;
import org.apache.commons.lang3.StringUtils;

public class EnkripsiFile {
    private String filename;
    private String directory;
    private BigInteger n;
    private Integer e;
   // private String fileNameEncrypt;
    private String fileNameEncrypt,lokasi;
    private String extension;
    String UkuranFile = null;
    String UkuranEnkripsi = null;
    private String filenamee;
    public static final double SPACE_KB = 1024;
      public static final double SPACE_MB = 1024 * SPACE_KB;
      private int progressCout;
      private int maxProgress;
      JProgressBar dpb;
      
      public void setFile (String directory, String filename, String extens){
          this.fileNameEncrypt = directory + "/" + "En_" + filename+ "." + extens;
        this.filenamee = filename+"."+extens;
            System.out.println("fileNameEncrypt="+fileNameEncrypt);
          /*this.fileNameEncrypt = directory + "/" + "EN_" + filename+ "." + extens;
          lokasi= fileNameEncrypt;*/
         
      }
       public void setFilenamee(String filenamee) {
        this.filenamee = filenamee;
    }

      /**
       * Untuk Mengambil Nilai N dan E
       * Yang di ambil dari file kunci Public
       */
      public void setPublicKey (String filePublic) throws IOException{
        BufferedReader br = null;
        try{
            int batas = 0;
            String current;
            br = new BufferedReader (new FileReader(filePublic));
            
            while ((current = br.readLine()) != null) {
            if (batas == 1){
            //================ Set Nilai Modulu dari File Kunci Publik ===============//
                this.n = new BigInteger (current);
                Session.setN(current);
            } else if (batas == 2){
            //============= Set Nilai eksponen E dari file kunci publik ============//
                this.e = new Integer (current);
                Session.setE (current);
            }else{
                Session.setId(current);
            }
            batas ++;
        }
        } catch (IOException e){
            e.printStackTrace();
        } finally{
            try{
                if (br != null) {br.close();}
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
        System.out.println("Nilai N :" + this.n);
        System.out.println ("Nilai E :" +this.e);
        System.out.println("id : " + Session.getId());
      }
      /**
       * Untuk Melakukan penulisan file
       * yang telah dienkripsi
       * @param dataEncrypt
       */
      private void saveEncryption (String dataEncrypt){
          try{
              String content = dataEncrypt;
              File file = new File (this.fileNameEncrypt);
              System.out.println(this.fileNameEncrypt);
              if (!file.exists()) {
               file.createNewFile();
              }
              
           FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
               System.out.println("File Berhasil di Enkripsi ! Lihat di :" +this.fileNameEncrypt);
               long UkuranFileByte = file.getAbsolutePath().length();
               UkuranEnkripsi = bytes2String (UkuranFileByte);
      } catch (IOException e)   {
          e.printStackTrace();
      }
      }
      public void encrypt(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        byte[] data = Files.readAllBytes(path); //membaca semua bytes yang ada di object
      
     //================= mengubah byte[] data array ke string =============//
        String[] data1 = new String[data.length];
        for(int i=0; i < data.length; i++) {
            data1[i] = String.valueOf(data[i] & 0xff); //unsigned integer
         }
        
      //============== proses enkripsi RSA =========================//
        BigInteger[] data2 = new BigInteger[data1.length];
        for (int i = 0; i < data1.length; i++) {
             data2[i] = (new BigInteger(data1[i])).pow(this.e);
             data2[i] = data2[i].mod(this.n);
            
           }
       
        //=============== mengubah value chipertetxt ke string ===============//
        String[] x = new String[data2.length];
        for(int i = 0; i < data2.length; i++) {
            x[i] = String.valueOf(data2[i]);
                        
        }
        
        //================= data5 adalah nilai yang akan di masukan kedalam file ============//
        String data5 = StringUtils.join(x, " ");//menggabungkan file dengan spasi
                
        // penyimpanan file enkripsi
//        this.saveEncryption(data5);
//        String hasilRSA=data5; 
//        //===================== Compresi LZW ===============//           
//        Algoritma_LZW zz=new Algoritma_LZW();
//        List<Short> compressed = zz.compress(hasilRSA);
//        String kompress="";
//        Iterator<Short> compressIterator = compressed.iterator();
//        while (compressIterator.hasNext()){
//        String sch=compressIterator.next().toString();
//        int in=Integer.parseInt(sch);
//        char ch=(char)in;
//        kompress=kompress+ch; 
//    }
//     saveEncryption(kompress);
      }
      public static String bytes2String(long sizeInBytes){
        NumberFormat nf = new DecimalFormat();
        nf.setMaximumFractionDigits(2);
        try{
            if (sizeInBytes < SPACE_KB){
                return nf.format(sizeInBytes)+ "Bytes(s)";
            } else if (sizeInBytes < SPACE_MB){
                return nf.format(sizeInBytes/SPACE_KB)+ "KB";
            } else if (sizeInBytes < SPACE_MB){
                return nf.format(sizeInBytes/SPACE_KB)+ "KB";
            }
        }catch (Exception e){
            return sizeInBytes+ "Byte(s)";
        }
        return null;
    }
    public String getFileNameEncrypt() {
        return fileNameEncrypt;
    }

    public static void main(String[] args) throws IOException {
    }
}
