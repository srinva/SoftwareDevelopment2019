package main.java.app.controllers;

public class Crypto {

    public static String encryptPassword(String password) {
        String alphabete = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

        String encrypt = "";
        int i;
        for(i = 0; i < password.length(); i++){
            int index = alphabete.indexOf(password.substring(i, i+1));
            String check = alphabete.substring((index + 23) % 62, ((index + 23) %62)+1);
            encrypt = encrypt + check;

        }
        return encrypt;
    }

    public static String decryptPassword(String password) {
        String alphabetd = "opqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmn";

        String decrypt = "";
        int b;
        for(b = 0; b < password.length(); b++){
            int index2 = alphabetd.indexOf(password.substring(b, b+1));
            String check2 = alphabetd.substring((index2 + 39) % 62, ((index2 + 39) % 62)+1);
            decrypt = decrypt + check2;

        }
        return decrypt;
    }

}
