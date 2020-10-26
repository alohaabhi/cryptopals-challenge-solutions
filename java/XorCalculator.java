public class XorCalculator {
  String calculateXorCombination(String binaryString1, String binaryString2) {
    String output = "";
    int finalLengthOfEachInput = binaryString1.length() > binaryString2.length() ? binaryString1.length(): binaryString1.length();
    String prefixedString1 = prefixWithZeroesToIncreaseLength(binaryString1, finalLengthOfEachInput);
    String prefixedString2 = prefixWithZeroesToIncreaseLength(binaryString2, finalLengthOfEachInput);
    for (int index = 0; index < binaryString1.length(); index++) {
      output += calculateXorCombination(prefixedString1.charAt(index), prefixedString2.charAt(index));
    }
    
    return output;
  }

  Character calculateXorCombination(Character binaryChar1, Character binaryChar2) {
    if ((binaryChar1 == '1' || binaryChar2 == '1') && (binaryChar1 != binaryChar2)) {
      return '1';
    }
    return '0';
  }

  private String prefixWithZeroesToIncreaseLength(String input, int finalLength) {
    String result = input;
    for (int i = finalLength - input.length(); i > 0; i = i - 1) {
      result = "0" + result;
    }
    return result;
  }
}