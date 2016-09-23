import edu.duke.*;
public class TestCaesarCipher {
    public int [] countLetters(String input) {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int [] counts =  new int [26];
        for (int k=0; k < input.length(); k++) {
            char ch = Character.toLowerCase(input.charAt(k));
            int index = alph.indexOf(ch);
            if (index != -1) {
                counts[index] += 1;
            }
        }
        return counts;
    }
    public int maxIndex(int[] vals){
        int maxDex = 0;
        for (int k=0; k < vals.length; k++) {
            if (vals[k] > vals[maxDex]) {
                maxDex = k;
            }
        }
        return maxDex;
    }
    public String breakCaesar(String encrypted) {
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4-maxDex);
        }
        CaesarCipher cc = new CaesarCipher(26-dkey);
        encrypted = cc.encrypt(encrypted);
        return encrypted;
    }
    public void simpleTests() {
        //FileResource file = new FileResource();
        //String input = file.asString();
        CaesarCipher cc = new CaesarCipher(15);
        String input = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String encryptPut = cc.encrypt(input);
        System.out.println(encryptPut);
//         CaesarCipher ccd = new CaesarCipher(18);
//         String decryptPut = ccd.decrypt(encryptPut);
//         System.out.println (breakCaesar(encryptPut));
    }
}
