/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proses_Aplikasi;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import static java.rmi.server.RemoteServer.getLog;
import java.util.Arrays;
import java.util.Random;
public class Proses_Generate {
    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger phi;
    private BigInteger e;
    private BigInteger d;
    private final int BITLENGTH = 6;
    private String direc;
    private String directory;
    private String Id;
    private String[] log = new String [6];
    private Random r;
    
public Proses_Generate(){
    r = new Random();
    p = BigInteger.probablePrime(BITLENGTH, r);
    q = BigInteger.probablePrime(BITLENGTH, r);
    n = p.multiply(q);
    phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
    e = BigInteger.probablePrime(BITLENGTH / 2,r);
    while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0){
        e = e.add(BigInteger.ONE);
    }
    d = e.modInverse(phi);
    
    //================= Setting Nilai Log ==================//
    log [0] = "p :" + String.valueOf(p);
    log [1] = "q :" + String.valueOf(q);
    log [2] = "n :" + String.valueOf(n);
    log [3] = "phi :" + String.valueOf(phi);
    log [4] = "e :" + String.valueOf(e);
    log [5] = "d :" + String.valueOf(d);
    
    getLog();
}
/**
 * 
 * @param directorypubik
 */

public void setDir (String directorypubik){
    this.directory = directorypubik; //Fungsi Untuk Menyimpan Public Key
}
/**
 * 
 * @param directoryprivate
 */
public void setDirec (String directoryprivate){
    this.direc = directoryprivate; // Fungsi Untuk Menyimpan Private Key
}
/**
 * 
 * @param Id
 */
public void setId (String Id){
    this.Id = Id;
}
public void createpublic() throws IOException {
   try{
       String fileNamePublic = this.Id + ".PublicKey";
       File filePublic = new File (this.directory + fileNamePublic);
       if (!filePublic.exists()){
           filePublic.createNewFile();
       }
       FileWriter fwPublic = new FileWriter (filePublic.getAbsoluteFile());
       BufferedWriter bwPublic = new BufferedWriter(fwPublic);
       
       //================= Prose Penulisan Kunci Untuk Ke NotePad ============//
       bwPublic.write(Id);
       bwPublic.write("\n");
       bwPublic.write(String.valueOf(this.n));
       bwPublic.write("\n");
       bwPublic.write(String.valueOf(this.e));
       Session.setN(String.valueOf(this.n));
       Session.setE(String.valueOf(this.e));
       
       bwPublic.close();
       System.out.println("Sukses Membuat Kunci Public, Silahkan Anda Lihat di :"
       +this.directory + fileNamePublic);
   } catch (IOException e){
      }
}
public void createprivate() throws IOException {
   try{
       String fileNamePrivate = this.Id + ".PrivateKey";
       File filePrivate = new File (this.directory + fileNamePrivate);
       if (!filePrivate.exists()){
           filePrivate.createNewFile();
       }
       FileWriter fwPublic = new FileWriter (filePrivate.getAbsoluteFile());
       BufferedWriter bwPrivate = new BufferedWriter(fwPublic);
       
       //================= Prose Penulisan Kunci Untuk Ke NotePad ============//
       bwPrivate.write(Id);
       bwPrivate.write("\n");
       bwPrivate.write(String.valueOf(this.n));
       bwPrivate.write("\n");
       bwPrivate.write(String.valueOf(this.d));//Ini Nantinya Akan di dekrip
       bwPrivate.close();
       Session.setD(String.valueOf(this.d));
       System.out.println("Sukses Membuat Kunci Private, Silahkan Anda Lihat di :"
       +this.directory + fileNamePrivate);
   } catch (IOException ex){
      }
}
public void createKeys () throws Exception {
    this.createpublic();
    this.createprivate();
}

public void getLog (){
    System.out.println(Arrays.toString(log));
}

class Array {
    public Array(){
        
    }
}
    
}
