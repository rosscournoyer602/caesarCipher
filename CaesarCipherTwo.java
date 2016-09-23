import edu.duke.*;

public class CaesarCipherTwo {
    private String upperAlphabet;
    private String lowerAlphabet;
    private String shiftedUpperAlphabet1;
    private String shiftedLowerAlphabet1;
    private String shiftedUpperAlphabet2;
    private String shiftedLowerAlphabet2;
    private int key1;
    private int key2;
    public CaesarCipherTwo(int firstKey, int secondKey) {
        key1 = firstKey;
        key2 = secondKey;
        upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftedUpperAlphabet1 = upperAlphabet.substring(key1) + upperAlphabet.substring(0,key1);
        shiftedLowerAlphabet1 = lowerAlphabet.substring(key1) + lowerAlphabet.substring(0,key1);
        shiftedUpperAlphabet2 = upperAlphabet.substring(key2) + upperAlphabet.substring(0,key2);
        shiftedLowerAlphabet2 = lowerAlphabet.substring(key2) + lowerAlphabet.substring(0,key2);
    }
    public String encrypt(String input) {
       StringBuilder encrypting = new StringBuilder(input);
       for (int i=0; i < input.length(); ++i) {
           char currentCharacter = input.charAt(i);
           int uLocation = upperAlphabet.indexOf(currentCharacter);
           int lowLocation = lowerAlphabet.indexOf(currentCharacter);
           if (uLocation != -1) {
               if (i % 2 == 0) {
                   encrypting.setCharAt(i, shiftedUpperAlphabet1.charAt(uLocation));
               }
               else {
                   encrypting.setCharAt(i, shiftedUpperAlphabet2.charAt(uLocation));
               }
            }
           if (lowLocation != -1) {
               if (i % 2 == 0) {
                   encrypting.setCharAt(i, shiftedLowerAlphabet1.charAt(lowLocation));
               }
               else {
                   encrypting.setCharAt(i, shiftedLowerAlphabet2.charAt(lowLocation));
               }
           }
       }
       input = encrypting.toString();
       return input;
    }
    public String decrypt(String encrypted) {
        CaesarCipherTwo cc = new CaesarCipherTwo(26-key1,26-key2);
        return cc.encrypt(encrypted);
    }
}
