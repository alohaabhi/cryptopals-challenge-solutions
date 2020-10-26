import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class S1C3 {
    public static void main(String args[]) {

        Map<Character, Double> letterFrequencyPercentageMap = new HashMap<Character, Double>() {{
            put(' ', 15.0);
            put('a', 8.167);
            put('b', 1.492);
            put('c', 2.782);
            put('d', 4.253);
            put('e', 12.702);
            put('f', 2.228);
            put('g', 2.015);
            put('h', 6.094);
            put('i', 6.966);
            put('j', 0.153);
            put('k', 0.772);
            put('l', 4.052);
            put('n', 6.740);
            put('o', 7.507);
            put('p', 1.929);
            put('q', 0.095);
            put('r', 5.987);
            put('s', 6.327);
            put('t', 9.056);
            put('u', 2.758);
            put('v', 0.978);
            put('w', 2.360);
            put('x', 0.150);
            put('y', 1.974);
            put('z', 0.074);
        }};
        String hexString = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736";
        System.out.println("Hex = " + hexString);

        FormarConverter converter = new FormarConverter();

        String binaryString = converter.hexToBinary(hexString);
        System.out.println("Binary = " + binaryString);

        XorCalculator xorCalculator = new XorCalculator();

        Map<Integer, String> decryptedMessageMap = new HashMap<>();
        Map<Integer, Double> decryptedMessageScoreMap = new HashMap<>();
        for (int key = 0; key <= 255; key = key + 1) {
            String binaryKey = Integer.toBinaryString(key);
            String decryptedString = "";
            Double score = 0.0;
            for (int i = 0; i < binaryString.length(); i = i + 8) {
                char decryptedCharacter = (char) Integer.parseInt(xorCalculator.calculateXorCombination(binaryString.substring(i, i + 8), binaryKey), 2);
                decryptedString = decryptedString + decryptedCharacter;
                score = score + letterFrequencyPercentageMap.getOrDefault(decryptedCharacter, 0.0);
            }
            decryptedMessageMap.put(key, decryptedString);
            decryptedMessageScoreMap.put(key, score);
        }

        Integer keyWithMaximumScore = Collections.max(decryptedMessageScoreMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Key = " + keyWithMaximumScore);
        System.out.println("Message = " + decryptedMessageMap.get(keyWithMaximumScore));
    }
}