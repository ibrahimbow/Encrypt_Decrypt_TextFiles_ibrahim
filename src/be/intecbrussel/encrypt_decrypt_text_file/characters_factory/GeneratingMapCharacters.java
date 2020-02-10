package be.intecbrussel.encrypt_decrypt_text_file.characters_factory;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class GeneratingMapCharacters extends MapCharacters{

    private final static int START_CHARACTER_ASCII = 32;
    private final static int END_CHARACTER_ASCII = 128;

     {
        initMapCharacter();
    }

    //--------------------------METHODS-------------------------------------
    //Initializing Map characters
    private void initMapCharacter(){
        // in case you want to try the random ThreadLocalRandom use this methods
//        generateRandomMapCharacter(getFirstMapChar());
//        generateRandomMapCharacter(getSecondMapChar());
//        generateRandomMapCharacter(getThirdMapChar());

        generateRandomFixedCharacters(getFirstMapChar());
        generateRandomFixedCharacters(getSecondMapChar());
        generateRandomFixedCharacters(getThirdMapChar());

    }

    //HERE IS THE FACTORY OF GENERATING THE RANDOM CHARACTERS
    private Map<Character,Character> generateRandomMapCharacters(Map<Character, Character> mapRandomGenerated) {
        for (int i = START_CHARACTER_ASCII; i < END_CHARACTER_ASCII; i++) {
            while(true) {
                char charRandom = (char) ThreadLocalRandom.current().nextInt(START_CHARACTER_ASCII,END_CHARACTER_ASCII);
                if (!mapRandomGenerated.containsValue(charRandom)) {
                    mapRandomGenerated.put((char) (i), charRandom);
                    //System.out.print(" " + charRandom);  // to show the result for test
                    break;
                }
            }
        }
        return mapRandomGenerated;
    }

    private Map<Character,Character> generateRandomFixedCharacters(Map<Character, Character> mapRandomCharacters){
        for (int i = 0; i < 96; i++) {
            mapRandomCharacters.put((char) (i+START_CHARACTER_ASCII)  , generateCharacterArray()[i]);
            }
            return mapRandomCharacters;
        }

    // Here I created this method to get the generated fixed randomized Character made by my idea
    private char[] generateCharacterArray(){
            char[] characterArray = new char[96];
            for (int i = 0; i < 96; i++) {
                if (i % 2 != 0) {
                    characterArray[i] = (char) (i + START_CHARACTER_ASCII);
                    int temp = characterArray[i];
                    characterArray[i] = characterArray[characterArray.length - i - 1];
                    characterArray[(characterArray.length - i) - 1] = (char) temp;
                }
            }

            for (int j = 0,  charIndex =0; j <characterArray.length && charIndex <characterArray.length ;charIndex++ , j++) {
                if ( characterArray[j] == 0) {
                    characterArray[j] = (char) ((charIndex-1) + START_CHARACTER_ASCII);
                }
            }

            return characterArray;
        }

}
