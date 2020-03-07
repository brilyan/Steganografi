
package Proses_Aplikasi;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;

public class SecretStego {
    private static String 	
        check,
	valueCheck;
	
private static byte byteArray[];
private static int  panjangCheck, tanda;
private byte features;
public byte   getFeatures() { return features; }
private SecretStego()
	{
            new SecretStego();
	}
	
	//===== Method GET hasil variable check ========//
	public static String getCheck()
	{
		return check;
	}
	
	//========= Method GET hasil variable tanda ===========//
	public static int getTanda()
	{
		return tanda;
	}
	
public static boolean setCheck(File Output)
  {
    panjangCheck = (int) Output.length();
		
    try
	{
//==========Membuat sebuah array byte panjang yang sama dengan ukuran file Stego ===============/
	byteArray = new byte[panjangCheck];
			
//=========  Membuka dan membaca semua byte array file Stego dalam byteArrayIn ===========//
	DataInputStream bacaCheck= new DataInputStream(new FileInputStream(Output));
	bacaCheck.read(byteArray, 0, panjangCheck);
	bacaCheck.close();
			
	//=============== Menampung isi byteArrayIn ke dalam variable value ===========//
	valueCheck = new String(byteArray);
			
	//================ Kondisi ketersediaan TANDA_BYTE ==============//
	if(valueCheck.contains("09-09-94"))
			{
	//================= Isi variable check dan tanda ===============//
	check = "TERSEDIA";
	tanda = valueCheck.length() - valueCheck.indexOf("09-09-94")+8;	
		}
			else
		{
			check = "TIDAK TERSEDIA";
			tanda = 0;	
			}
			
	}
	catch(EOFException e)
	{
		}
	catch(Exception e)
		{
	e.printStackTrace();
	return false;
		}
		
	return true;
	}
}
