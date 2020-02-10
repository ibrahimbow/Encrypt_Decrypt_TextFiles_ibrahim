package be.intecbrussel.encrypt_decrypt_text_file.io_textfiles;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.IsoFields;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.Locale;

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
            DosFileAttributes attribute = Files.readAttributes(path,DosFileAttributes.class);
            FileWriter file = new FileWriter("EncryptedFile.txt");
            file.write(encryptedText);
            file.flush();

            System.out.println("The File is Encrypted.. :)");
            System.out.println("Size : " + attribute.size()); //It shows size 0 when the first time is created
            System.out.println("CreationTime is : " + dateTime(attribute));
            System.out.println("---------------------------------------------");

    }

    // THIS METHOD IS TO WRITE DECRYPTED TEXT FILE
    public void writeDecryptedTextToFile(String encryptedText) throws IOException {
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
            DosFileAttributes attribute = Files.readAttributes(path,DosFileAttributes.class);
            FileWriter file = new FileWriter("DecryptedFile.txt");
            file.write(encryptedText);
            file.flush();

            System.out.println("The File is Decrypted.. ;)");
            System.out.println("Size : " + attribute.size());  //It shows size 0 when the first time is created
            System.out.println("CreationTime is: " + dateTime(attribute));
            System.out.println("---------------------------------------------");


    }

    // change the style output of date and time
    private String dateTime(DosFileAttributes changeStyle){
        // This way is to change the style of date and time for creationTime() method . change hour and minutes !!!
        Instant time = changeStyle.creationTime().toInstant();
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.of("+02:14"));

        return formatter.format( time );
    }

}
