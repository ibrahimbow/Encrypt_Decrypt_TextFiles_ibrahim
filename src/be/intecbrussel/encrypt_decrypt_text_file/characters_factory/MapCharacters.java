package be.intecbrussel.encrypt_decrypt_text_file.characters_factory;

import java.util.HashMap;
import java.util.Map;

public abstract class MapCharacters {

    //------------------------DECLARATION---------------------------------
    private   Map<Character,Character> firstMapChar = new HashMap<>();
    private   Map<Character,Character> secondMapChar = new HashMap<>();
    private   Map<Character,Character> thirdMapChar = new HashMap<>();

    //--------------------------GETTERS------------------------------------
    public Map<Character, Character> getFirstMapChar() {
        return firstMapChar;
    }

    public Map<Character, Character> getSecondMapChar() {
        return secondMapChar;
    }

    public Map<Character, Character> getThirdMapChar() {
        return thirdMapChar;
    }

}
