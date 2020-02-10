package be.intecbrussel.encrypt_decrypt_text_file.io_textfiles;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;

public class WriteTextFile {
    //-----------------------DECLARATION-----------------------------
    private Path path;

    //-------------------------METHODS-------------------------------
    // THIS METHOD TO WRITE ENCRYPTED TEXT FILE
    public void writeEncryptedTextToFile(String encryptedText) throws IOException {
            //Define path
            path = Paths.get(".\\EncryptedFile.txt");
            //create parent directories
            Files.createDirectories(path.getParent());
            //create if not exit
            if(Files.notExists(path)){
                Files.createFile(path);
                System.out.println("file is created");
            }else{
                System.out.println("File already exits");
            }

            //Retrieve attributes of file
            DosFileAttributes attr = Files.readAttributes(path,DosFileAttributes.class);
            FileWriter file = new FileWriter("EncryptedFile.txt");
            file.write(encryptedText);
            file.flush();


            System.out.println("The File is Encrypted.. :)");
            System.out.println("Size : " + attr.size());
            System.out.println("CreationTime is: "+attr.creationTime());
            System.out.println("---------------------------------------------");

    }

    // THIS METHOD IS TO WRITE DECRYPTED TEXT FILE
    public void writeDecryptedTextToFile(String encryptedText) throws IOException, InterruptedException {
            //Define path
            path = Paths.get(".\\DecryptedFile.txt");
            //create parent directories
            Files.createDirectories(path.getParent());
            //create if not exit
            if(Files.notExists(path)){
                Files.createFile(path);
                System.out.println("file is created");
            }else{
                System.out.println("File already exits");
            }

            //Retrieve attributes of file
            DosFileAttributes attr = Files.readAttributes(path,DosFileAttributes.class);
            FileWriter file = new FileWriter("DecryptedFile.txt");
            file.write(encryptedText);
            file.flush();


            System.out.println("The File is Decrypted.. ;)");
            System.out.println("Size : " + attr.size());
            System.out.println("CreationTime is: "+attr.creationTime());
            System.out.println("---------------------------------------------");


    }

}
