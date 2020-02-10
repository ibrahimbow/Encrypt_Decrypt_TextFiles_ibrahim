package be.intecbrussel.encrypt_decrypt_text_file.decryption;

import be.intecbrussel.encrypt_decrypt_text_file.characters_factory.GeneratingMapCharacters;

import java.util.Map;

public class DecryptTextFile extends GeneratingMapCharacters  {
    //------------------------DECLARATION---------------------------------
    private String textFileToBeDecrypted;

    //------------------------CONSTRUCTOR---------------------------------
    public DecryptTextFile() {
        // initiate the generating of MapCharacters
        initMapCharacter();
    }

    //---------------------------GETTER------------------------------------
    public String getTextFileToBeDecrypted() {
        // HERE WE RETURN THE NORMAL SIZE OF TEXT
        // BY REMOVING THE EXTRA TEXT THAT WE ADDED IT WHILE WE ENCRYPT THE TEXT FILE ;)
        return textFileToBeDecrypted.substring(textFileToBeDecrypted.length()/2,textFileToBeDecrypted.length());
    }

    //---------------------------SETTER------------------------------------
    public void setTextFileToBeDecrypted(String textFileToBeDecrypted) {
        this.textFileToBeDecrypted = textFileToBeDecrypted;
    }

    //---------------------------METHODS------------------------------------
    //Decrypt .. We just started from the Third to the First Map.. reverse of encryption
    private char[] thirdMapDecrypted() {
        char[] inputText = getTextFileToBeDecrypted().toCharArray();
        for (int i = 0; i <inputText.length ; i++) {
          // We use (Map.Entry) in order to be able to get the key from the MAP and so on in other methods
            for(Map.Entry<Character, Character> entry : getThirdMapChar().entrySet()){
                if (entry.getValue().equals(inputText[i])) {
                    inputText[i] = entry.getKey();
                    break;
                }
            }
        }
        return inputText;
    }

    private char[] secondMapDecrypted(char[] mediumArray) {
        char[] inputText = mediumArray;
        for (int i = 0; i <inputText.length ; i++) {
            for(Map.Entry<Character, Character> entry : getSecondMapChar().entrySet()){
                if (entry.getValue().equals(inputText[i])) {
                    inputText[i] = entry.getKey();
                    break;
                }
            }
        }
        return inputText;
    }

    private String firstMapDecrypted(char[] smallArray) {
        char[] inputText = smallArray;
        for (int i = 0; i <inputText.length ; i++) {
            for(Map.Entry<Character, Character> entry : getFirstMapChar().entrySet()){
                if (entry.getValue().equals(inputText[i])) {
                    inputText[i] = entry.getKey();
                    break;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new String(inputText));
        String content = stringBuilder.toString();
        return content;
    }

    // This method is to call all the methods that responsible of decryption the text and return the result as string
    public String decryptedText(){
        return firstMapDecrypted(secondMapDecrypted(thirdMapDecrypted()));
    }
}

