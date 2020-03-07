
package Interface;

import Proses_Aplikasi.*;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;

public class Algo_EOF {
    private String filename;
    private String directory;
    private String publicFile;
    private BigInteger n;
    private Integer e;
    private Integer d;
    private String fileNameDecrypt;
    private String fileNameEncrypt,lokasi;
    private String extension;
    private File SecretF;
    private File StegoF;
    private String fileName;
    private String filenamee;
    String strChiper ="", mypathout_1="";
    
    	public static final byte[] TANDA_BYTE = {'0','9','-','0','9','-','9','4'};       
	private static String value, NamaSecret, message, extensionSecret, path;
	private static int 	   PanjangCover, PanjangStego, i, j, PanjangPesanRahasia;					
	private static byte        byteArrayIn[];       
	private static ByteArrayOutputStream byteOut;  //digunakan untuk menuliskan stream menjadi byte array.        
	private static byte[] EXT_SECRET;       
      //deklarasi File fixSecret
	public static File fixSecret = null;
        
        
    //untuk pemberian nama Video
        public void setFile(String directory, String filename, String extens) {
        
        this.fileNameEncrypt = directory + "/" + "Embed_" + filename+ "." + extens;
        this.filenamee = filename+"."+extens;
            System.out.println("fileNameEncrypt="+fileNameEncrypt);//D:/Lat/en.Sistem Berjalan.doc
     }
    public String getFilenamee() {
        return this.filenamee;
    }

    public void setFilenamee(String filenamee) {
        this.filenamee = filenamee;
    }
    public String getFileNameEncrypt() {
        return fileNameEncrypt;
    }
    public void setPublicKey(String filePublic) throws IOException {
        BufferedReader br = null;
        try {
            int batas = 0;
            String current;
            br = new BufferedReader(new FileReader(filePublic));
            while ((current = br.readLine()) != null) {
                if (batas == 1) {
                    // set nilai modulo dari file kunci publik
                    this.n = new BigInteger(current);
                } else if (batas == 2) {
                    // set nilai eksponen e dari file kunci publik
                    this.e = new Integer(current);
                }
                batas++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {br.close();}
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void setPrivateKey (String filePrivate) throws FileNotFoundException {
    BufferedReader br = null;
    try{
        int batas = 0;
        String current;
        br = new BufferedReader (new FileReader (filePrivate));
        while ((current =  br.readLine()) != null){
        if (batas ==1){
            this.n = new BigInteger(current);
            Session.setN(current);
        }else if (batas == 2){
            this.d = new Integer(current);
            Session.setD(current);
        }else{
            Session.setId(current);
        }
        batas ++;
    }
    } catch (IOException e){
        e.printStackTrace();
    } finally{
        try{
             if (br != null) {
                    br.close();
            }
        
    } catch (IOException ex){
        ex.printStackTrace();
    }
    }
    }

        Algo_EOF() //object
	{
		System.out.println("Aplikasi Steganografi ...");
	}
	
	public static String getMessage()
	{
		return message;
	}
	
	public static String getPath()
	{
		path = fixSecret.getAbsolutePath();
		return path;
	}
	
	//Proses Embed File
        //disini lupa gw dimananya 
	public boolean EncodeFile(File CoverF, String Output, File SecretF)
	{
		//Mengambil panjang data File Cover dan File Secret
		PanjangPesanRahasia = (int) SecretF.length();
		PanjangCover = (int) CoverF.length();
		
		try
		{
			//Mengambil nama File Secret
			NamaSecret = SecretF.getName();
			
			//Mengambil Extension File pada Nama Secret
			extensionSecret = NamaSecret.substring(NamaSecret.length()-4, NamaSecret.length());
			
			//Memanggil Method buatArrayExt untuk mengisi nilai EXT_SECRET
			buatArrayExt();
			
			//Instalasi variable byteOut
                        //digunakan untuk menuliskan stream menjadi byte array.
			byteOut = new ByteArrayOutputStream();
			
			//Membuat sebuah array byte panjang yang sama dengan ukuran file Cover
			byteArrayIn = new byte[PanjangCover];
			
			// Membuka dan membaca semua byte array file Cover dalam byteArrayIn
                        //Stream input yang berisi method-method untuk membaca tipe data standar yang terdapat dalam Java
			DataInputStream baca= new DataInputStream(new FileInputStream(CoverF));
			baca.read(byteArrayIn, 0, PanjangCover);
			baca.close();
			
			//Menulis semua byte array dari file Cover ke dalam byteOut
			byteOut.write(byteArrayIn, 0, PanjangCover);
			
			//Menulis dan menambahkan TANDA_BYTE dalam byteOut
			tulisBytes(TANDA_BYTE);
			tulisBytes(EXT_SECRET);
                        
                       //Path path = Paths.get(fileName);
                        Path pat = Paths.get(SecretF.getPath());
                        byte[] data = Files.readAllBytes(pat);
                       
                        //mengubah byte[] data array ke string ascii
                         String[] data1 = new String[data.length];
                         for(int i=0; i < data.length; i++) {
                         data1[i] = String.valueOf(data[i] & 0xff);
                         }
                         //proses enkripsi RSA
                        BigInteger[] data2 = new BigInteger[data1.length];
                        for (int i = 0; i < data1.length; i++) {
                             data2[i] = (new BigInteger(data1[i])).pow(this.e);
                             data2[i] = data2[i].mod(this.n);
                           }

                        //mengubah value chipertetxt ke string
                        String[] x = new String[data2.length];
                        for(int i = 0; i < data2.length; i++) {
                            x[i] = String.valueOf(data2[i]);
                        }
                         String data5 = StringUtils.join(x, " ");
                        //this.saveEncryption(data5);
                        
			// Membaca data kedalam fileArray
			byte []fileArray= new byte[PanjangPesanRahasia];
			baca= new DataInputStream(new FileInputStream(SecretF));
			baca.read(fileArray, 0, PanjangPesanRahasia);
			baca.close();
			
			//Menulis dan menambahkan byte dari SecretF dalam byteOut
			//tulisBytes(fileArray);
                        tulisBytes(data5.getBytes());  
                        String filename = CoverF.getName();
                        String fileoutput = Output;
                        int dot = filename.lastIndexOf(".");
                        int sep = filename.replace("\\", "/").lastIndexOf("/"); 
                        this.setFile(fileoutput.replace("\\", "/"), filename.substring(sep + 1, dot), filename.substring(dot + 1)  );
            
                       /* String dir = "D:/Tes_Stegano";
                        new File (dir).mkdir();
                        File f = new File(filename.toString());
                        DataOutputStream out = new DataOutputStream(new FileOutputStream(dir + "/" + f));
                        byteOut.writeTo(out);
                        out.close();*/
                        Path path = Paths.get(this.fileNameEncrypt);
                        Files.write(path, byteOut.toByteArray());
		
			AwalNull();
		}
		catch(EOFException e)
		{
		}
		catch(Exception e)
		{
                    e.printStackTrace(); 
                    JOptionPane.showMessageDialog(null,"Proses encode gagal", "Pesan",JOptionPane.INFORMATION_MESSAGE);   
                     
                     return false;
		}
                
		System.out.println("Hasil file enkripsi berhasil disisipkan dalam Video '"+ CoverF.getName());
                JOptionPane.showMessageDialog(null," Hasil file enkripsi "+ SecretF.getName() +" berhasil disisipkan dalam Video "+ CoverF.getName(), "Pesan",JOptionPane.INFORMATION_MESSAGE);
		
		return true;
	}
        
	
	public boolean DecodeFile(File Output, File dataSecret)
	{
		//Mengambil panjang data File Stego
		PanjangStego = (int) Output.length();
		String valueExt="";
		
		try
		{
			//Instalasi variable byteOut
			byteOut = new ByteArrayOutputStream();
			
			//Membuat sebuah array byte panjang yang sama dengan ukuran file Stego
			byteArrayIn = new byte[PanjangStego];
			
			// Membuka dan membaca semua byte array file Stego dalam byteArrayIn                      
                        Path path = Paths.get(Output.getPath());
                        byteArrayIn = Files.readAllBytes(path);
			
			//Menampung isi byteArrayIn ke dalam variable value
			value = new String(byteArrayIn);
			
			//Memanggil Method tulisByteSecret dengan isi byteArrayIn dan mulai dari nilai value.indexOf
			tulisBytesSecret(byteArrayIn, value.lastIndexOf("09-09-94")+12);
			
                        //Mengambil Extension File dari variable value
			valueExt = value.substring(value.indexOf("09-09-94")+8, value.indexOf("09-09-94")+8+4);
                        System.out.println(valueExt);
                        //ini yang di edit
			String[] extensionS = {"docx","xlsx",".pdf",".doc",".xls",".txt",".jpeg",".png",".jpg",".mp3"};
			
			//Looping untuk mencari extension File Secret yang cocok dengan variable valueExt
			for(int l=0; l<extensionS.length; l++)
			{       //ini yang di edit
				if(valueExt.toLowerCase().contains(extensionS[l].toLowerCase()))
				{
                                        
					if(extensionS[l].substring(0,1).equals(".")){
                                                
						fixSecret = new File(dataSecret.getAbsolutePath()+extensionS[l]);
                                                 
                                        }
                                        else{
						fixSecret = new File(dataSecret.getAbsolutePath()+"."+extensionS[l]);
                                                
                                        }
				}
			}
                        System.out.println(fixSecret.getAbsolutePath());
                        DataOutputStream fileSecret = new DataOutputStream(new FileOutputStream(fixSecret));
                       byteOut.writeTo(fileSecret);
                       fileSecret.close();			
			AwalNull();
		}
		
		catch(EOFException e)
		{
		}
		catch(Exception e)
		{
			message= "Silahkan Isi Form Terlebih Dahulu";
			e.printStackTrace();
			return false;
		}
	
		message= "File " + Output.getName()+" Berhasil Dilakukan Retrieve\nFile File Disimpan di Folder "+dataSecret.getName();
               
		return true;
	}
           private void saveDecryption(byte[] dataDecrypt) throws IOException {
        Path path = Paths.get(this.fileNameDecrypt);
        Files.write(path, dataDecrypt);
        System.out.println("File Berhasil di dekripsi ! lihat di : " + mypathout_1);
   }
	
	//Method untuk menulis byte kedalam output array (Array Stego)
	private static void tulisBytes(byte[] bytes)
	{
		int size= bytes.length;

		for(int i=0; i< size; i++)
		{
			byteOut.write(bytes[i]);
		}
	}
	
	//Method untuk menulis byte kedalam output array (Array Secret) dengan awal index byte : variable mulai
	private static void tulisBytesSecret(byte[] bytes,int mulai)
	{
		int size= bytes.length;

		for(int i=mulai; i< size; i++)
		{
			byteOut.write(bytes[i]);
		}
	}
	
	//Method untuk membuat isi array byte EXT_SECRET
	private static void buatArrayExt()
	{
		if(extensionSecret.equalsIgnoreCase("docx"))
		{
			EXT_SECRET = new byte[] {'d','o','c','x'};
		}
		else if(extensionSecret.equalsIgnoreCase("xlsx"))
		{
			EXT_SECRET = new byte[] {'x','l','s','x'};
		}
		else if(extensionSecret.equalsIgnoreCase(".pdf"))
		{
			EXT_SECRET = new byte[] {'.','p','d','f'};
		}
		if(extensionSecret.equalsIgnoreCase(".doc"))
		{
			EXT_SECRET = new byte[] {'.','d','o','c'};
		}
		else if(extensionSecret.equalsIgnoreCase(".xls"))
		{
			EXT_SECRET = new byte[] {'.','x','l','s'};
		}
		else if(extensionSecret.equalsIgnoreCase(".txt"))
		{
			EXT_SECRET = new byte[] {'.','t','x','t'};
		}
                else if(extensionSecret.equalsIgnoreCase(".png"))
		{
			EXT_SECRET = new byte[] {'.','p','n','g'};
		}
                else if(extensionSecret.equalsIgnoreCase(".jpg"))
		{
			EXT_SECRET = new byte[] {'.','j','p','g'};
		}
                else if(extensionSecret.equalsIgnoreCase(".jpeg"))
		{
			EXT_SECRET = new byte[] {'.','j','p','e','g'};
		}
	}
	
	public static void AwalNull()
	{
		PanjangCover = 0;
		PanjangPesanRahasia = 0;
		PanjangStego = 0;
		byteArrayIn = null;
		byteOut = null;
	} 

 public String getFileNameDecrypt() {
        return fileNameDecrypt;
    }
    void DecodeFile(String Output, File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
