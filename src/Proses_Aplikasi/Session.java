/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proses_Aplikasi;


public class Session {
    private static String Username;
    private static String n;
    private static String e;
    private static String d;
    private static String Id;
    private static String namauser;
    private static String Password;
    
    public static void setnamauser (String nama){
    namauser = nama;
}

public static String getnamauser(){
        return namauser;
}

public static void cetak(){
    System.out.println(namauser);
}

public static String getN(){
    return n;
}

 public static void setN(String n) {
        Session.n = n;
    }
 
public static String getE() {
        return e;
    }

public static void setE(String e) {
        Session.e = e;
    }

public static String getD() {
        return d;
    }

public static void setD(String d) {
        Session.d = d;
    }

public static String getId() {
        return Id;
    }

public static void setId(String id) {
        Session.Id = id;
    }
public static String getUser() {
        return Username;
    }
public static void setUser(String user) {
        Username = user;
    }  

public static String getPass() {
        return Password;
    }

public static void setPass(String password) {
        Password = password;
    }
    
}
