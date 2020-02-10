package be.intecbrussel.encrypt_decrypt_text_file.encryption;

import be.intecbrussel.encrypt_decrypt_text_file.characters_factory.GeneratingMapCharacters;

public class EncryptTextFile extends GeneratingMapCharacters {
    //------------------------DECLARATION----------------------------------
    private String textFileToBeEncrypted;

    //--------------------------GETTERS-------------------------------------
    private String getTextFileToBeEncrypted() {
        return textFileToBeEncrypted;
    }

    //--------------------------SETTERS-------------------------------------
    public void setTextFileToBeEncrypted(String textFileToBeEncrypted) {
        this.textFileToBeEncrypted = textFileToBeEncrypted;
    }

    //---------------------------METHODS------------------------------------
    //Encrypt TEXT... we just use this method to encrypt the text file through (MapCharacters)
    private char[] firstMapEncrypted() {
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
        for (int i = 0; i < mediumString.length ; i++) {
            while(true) {
                if (getSecondMapChar().containsKey(mediumString[i])) {
                    mediumString[i] = getSecondMapChar().get(mediumString[i]);
                    break;
                }
            }
        }
        return mediumString;

    }

    private String thirdMapEncrypted(char[] largeString) {
        for (int i = 0; i < largeString.length ; i++) {
            while(true) {
                if (getThirdMapChar().containsKey(largeString[i])) {
                    largeString[i] = getThirdMapChar().get(largeString[i]);
                    break;
                }
            }
        }

        return new String(largeString);
    }

    public String encryptedText(){
        return thirdMapEncrypted(secondMapEncrypted(firstMapEncrypted()))
                + thirdMapEncrypted(secondMapEncrypted(firstMapEncrypted())) ;
    }

}
