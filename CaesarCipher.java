
public class CaesarCipher {
    private String upperAlphabet;
    private String lowerAlphabet;
    private String shiftedUpperAlphabet;
    private String shiftedLowerAlphabet;
    private int mainKey;
    public CaesarCipher(int key) {
        upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftedUpperAlphabet = upperAlphabet.substring(key) + upperAlphabet.substring(0,key);
        shiftedLowerAlphabet = lowerAlphabet.substring(key) + lowerAlphabet.substring(0,key);
        mainKey = key;
    }
    public String encrypt(String input) {
        StringBuilder encrypting = new StringBuilder(input);
        for (int i=0; i < input.length(); ++i) {
            char currentCharacter = encrypting.charAt(i);
            int uLocation = upperAlphabet.indexOf(currentCharacter);
            int lowLocation = lowerAlphabet.indexOf(currentCharacter);
            if (uLocation != -1) {
                encrypting.setCharAt(i, shiftedUpperAlphabet.charAt(uLocation));
            }
            if (lowLocation != -1) {
                encrypting.setCharAt(i, shiftedLowerAlphabet.charAt(lowLocation));
            }
        }
        input = encrypting.toString();
        return input;
    }
    public String decrypt(String encrypted) {
        CaesarCipher cc = new CaesarCipher(26-mainKey);
        return cc.encrypt(encrypted);
    }
}
