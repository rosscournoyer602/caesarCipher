import edu.duke.*;
public class TestCaesarCipherTwo {
    private int [] countLetters(String input) {
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
    private int maxIndex(int[] vals){
        int maxDex = 0;
        for (int k=0; k < vals.length; k++) {
            if (vals[k] > vals[maxDex]) {
                maxDex = k;
            }
        }
        return maxDex;
    }
    private int getKey(String s) {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int counts[] = countLetters(s);
        int maxDex = maxIndex(counts);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4-maxDex);
        }
        return dkey;
    }
    private String halfOfString(String message, int start) {
        StringBuilder halved = new StringBuilder();
        for (int k=start; k < message.length(); k++) {
            char currCh = message.charAt(k);
            if (start % 2 == 0 && k % 2 == 0) {
                halved.append(currCh);
            }
            if (start % 2 != 0 && k % 2 != 0) {
                halved.append(currCh);
            }
        }
        message = halved.toString();
        return message;
    }
    public String breakCaesar(String input) {
        String firstHalf = halfOfString(input,0);
        String secondHalf = halfOfString(input,1);
        int key1 = getKey(firstHalf);
        int key2 = getKey(secondHalf);
        System.out.println("Key 1 is " + key1);
        System.out.println("Key 2 is " + key2);
        CaesarCipherTwo cc = new CaesarCipherTwo(key1, key2);
        input = cc.decrypt(input);
        return input;
    }
    public void simpleTests() {
        FileResource file = new FileResource();
       String input = file.asString();
        //CaesarCipherTwo cc = new CaesarCipherTwo(14, 24);
        //String input = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        //String encryptPut = cc.encrypt(input);
        //System.out.println(encryptPut);
        //CaesarCipherTwo ccd = new CaesarCipherTwo(14,24);
        //System.out.println(cc.decrypt("Hfs cpwewloj loks cd Hoto kyg Cyy."));
        //String decryptPut = ccd.decrypt(encryptPut);
        //System.out.println(decryptPut);
        System.out.println (breakCaesar(input));
    }
}