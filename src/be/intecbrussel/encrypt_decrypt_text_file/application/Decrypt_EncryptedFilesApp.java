package be.intecbrussel.encrypt_decrypt_text_file.application;

import be.intecbrussel.encrypt_decrypt_text_file.decryption.DecryptTextFile;
import be.intecbrussel.encrypt_decrypt_text_file.io_textfiles.ReadTextFile;
import be.intecbrussel.encrypt_decrypt_text_file.io_textfiles.WriteTextFile;

import java.io.IOException;

public class Decrypt_EncryptedFilesApp {
    public static void main(String[] args) throws IOException{

        //==============================DECRYPTION===================================
        // Read the Encrypted File
        ReadTextFile readEncryptedTextFile =  new ReadTextFile("EncryptedFile.txt");

        //Decrypt the TextFile
        DecryptTextFile getBackWhatsMine = new DecryptTextFile();
        getBackWhatsMine.setTextFileToBeDecrypted(readEncryptedTextFile.getTheString());

        // Write the DecryptedFile
        WriteTextFile writeDecryptedTextFile = new WriteTextFile();
        writeDecryptedTextFile.writeDecryptedTextToFile(getBackWhatsMine.decryptedText());

        //-------------Show the result of the Original Text File Encryption and Decryption on screen------------
        System.out.println("Original Text File : "  + new ReadTextFile("TextFile.txt").getTheString());
        System.out.println();
        System.out.println("ENCRYPTED Text File : " + readEncryptedTextFile.getTheString());
        System.out.println();
        System.out.println("DECRYPTED Text File: " + getBackWhatsMine.decryptedText());
    }
}
