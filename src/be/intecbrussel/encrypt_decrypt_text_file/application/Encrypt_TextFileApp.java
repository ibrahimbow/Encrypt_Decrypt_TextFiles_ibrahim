package be.intecbrussel.encrypt_decrypt_text_file.application;

import be.intecbrussel.encrypt_decrypt_text_file.encryption.EncryptTextFile;
import be.intecbrussel.encrypt_decrypt_text_file.io_textfiles.ReadTextFile;
import be.intecbrussel.encrypt_decrypt_text_file.io_textfiles.WriteTextFile;

public class Encrypt_TextFileApp {
    public static void main(String[] args) throws Exception {

        // Read the Text File
        ReadTextFile readTextFile =  new ReadTextFile("TextFile.txt");

        //==============================ENCRYPTION===================================
        // Encrypt the Text File
        EncryptTextFile encryptTextFile = new EncryptTextFile();
        encryptTextFile.setTextFileToBeEncrypted(readTextFile.getTheString());

        // Write the EncryptedFile
        WriteTextFile writeTextFile = new WriteTextFile();
        writeTextFile.writeEncryptedTextToFile(encryptTextFile.encryptedText());

        //-----------------Show the result of Encryption on screen---------------
        System.out.println("Original Text File : "  + readTextFile.getTheString());
        System.out.println();
        System.out.println("ENCRYPTED Text File : " + encryptTextFile.encryptedText());

    }
}
