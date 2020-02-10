package be.intecbrussel.encrypt_decrypt_text_file.encryption;

import be.intecbrussel.encrypt_decrypt_text_file.characters_factory.GeneratingMapCharacters;

import java.io.IOException;

public class EncryptTextFile extends GeneratingMapCharacters {
    //------------------------DECLARATION----------------------------------
    private String textFileToBeEncrypted;

    //------------------------CONSTRUCTION----------------------------------
    public EncryptTextFile() {
        // initiate the generating of MapCharacters
        initMapCharacter();
    }

    //--------------------------GETTERS-------------------------------------
    public String getTextFileToBeEncrypted() {
        return textFileToBeEncrypted;
    }

    //--------------------------SETTERS-------------------------------------
    public void setTextFileToBeEncrypted(String textFileToBeEncrypted) {
        this.textFileToBeEncrypted = textFileToBeEncrypted;
    }

    //---------------------------METHODS------------------------------------
    //Encrypt TEXT... we just use this method to encrypt the text file through (MapCharacters)
    private char[] firstMapEncrypted() throws IOException {
        char[] inputText = getTextFileToBeEncrypted().toCharArray();
        for (int i = 0; i <inputText.length ; i++) {
            while(true) {
                if (getFirstMapChar().containsKey(inputText[i])) {
                    inputText[i] = getFirstMapChar().get(inputText[i]);
                    break;
                }
            }
        }
        return inputText;
    }

    private char[] secondMapEncrypted(char[] mediumString) {
        char[] inputText = mediumString;
        for (int i = 0; i <inputText.length ; i++) {
            while(true) {
                if (getSecondMapChar().containsKey(inputText[i])) {
                    inputText[i] = getSecondMapChar().get(inputText[i]);
                    break;
                }
            }
        }
        return inputText;

    }

    private String thirdMapEncrypted(char[] largeString) {
        char[] inputText = largeString;
        for (int i = 0; i <inputText.length ; i++) {
            while(true) {
                if (getThirdMapChar().containsKey(inputText[i])) {
                    inputText[i] = getThirdMapChar().get(inputText[i]);
                    break;
                }
            }
        }

        //use stringBuilder to convert the char array to be string
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new String(inputText));
        String content = stringBuilder.toString();

        return content;
    }

    public String encryptedText()throws IOException{
        return thirdMapEncrypted(secondMapEncrypted(firstMapEncrypted()))
                + thirdMapEncrypted(secondMapEncrypted(firstMapEncrypted())) ;
    }

}
