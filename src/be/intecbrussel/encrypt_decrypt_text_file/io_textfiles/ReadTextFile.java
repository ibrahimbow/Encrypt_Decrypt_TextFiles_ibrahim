package be.intecbrussel.encrypt_decrypt_text_file.io_textfiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {
    //-----------------------Declaration-----------------------------
    private File file;
    private String fileName;

    //------------------------CONSTRUCTOR-----------------------------
    // use this constructor to get the name of the file when the object is created
    public ReadTextFile(String fileName) {
        this.fileName = fileName;
    }

    //------------------------METHODS-----------------------------
    // This method to get the text from the file and return it as String
    public String getTheString()throws IOException {
        this.file = new File(this.fileName);

            BufferedReader reader = new BufferedReader(new FileReader(file));
            //using stringBuilder to get the text back in string
            StringBuilder stringBuilder = new StringBuilder();

            char[] buffer = new char[(int) file.length()];
            while (reader.read(buffer) != -1) {
                stringBuilder.append(new String(buffer));
                buffer = new char[(int) file.length()];
            }
            reader.close();

            String content = stringBuilder.toString();
            //This is the only way to avoid (ENTER-KEY) inside the text file

            //which is problem to recognize it as character
            if (content.contains("\r") && content.contains("\n")) {
                return content.replaceAll("\r", " ").replaceAll("\n", " ");
            } else {
                return content;
            }


    }

}
