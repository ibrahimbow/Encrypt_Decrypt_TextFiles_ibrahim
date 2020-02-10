package be.intecbrussel.encrypt_decrypt_text_file.decryption;

import be.intecbrussel.encrypt_decrypt_text_file.characters_factory.GeneratingMapCharacters;

import java.util.Map;

public class DecryptTextFile extends GeneratingMapCharacters  {
    //------------------------DECLARATION---------------------------------
    private String textFileToBeDecrypted;

    //---------------------------GETTER------------------------------------
    private String getTextFileToBeDecrypted() {
        // HERE WE RETURN THE NORMAL SIZE OF TEXT
        // BY REMOVING THE EXTRA TEXT THAT WE ADDED IT WHILE WE ENCRYPTED THE TEXT FILE ;)
        return textFileToBeDecrypted.substring(textFileToBeDecrypted.length()/2);
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
        for (int i = 0; i < mediumArray.length ; i++) {
            for(Map.Entry<Character, Character> entry : getSecondMapChar().entrySet()){
                if (entry.getValue().equals(mediumArray[i])) {
                    mediumArray[i] = entry.getKey();
                    break;
                }
            }
        }
        return mediumArray;
    }

    private String firstMapDecrypted(char[] smallArray) {
        for (int i = 0; i < smallArray.length ; i++) {
            for(Map.Entry<Character, Character> entry : getFirstMapChar().entrySet()){
                if (entry.getValue().equals(smallArray[i])) {
                    smallArray[i] = entry.getKey();
                    break;
                }
            }
        }

        return  new String(smallArray);
    }

    // This method is to call all the methods that responsible of decryption the text and return the result as string
    public String decryptedText(){
        return firstMapDecrypted(secondMapDecrypted(thirdMapDecrypted()));
    }
}

