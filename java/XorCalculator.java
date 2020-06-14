public class XorCalculator {
  String calculateXorCombination(String binaryString1, String binaryString2) {
    String output = "";
    for (int index = 0; index < binaryString1.length(); index++) {
      output += calculateXorCombination(binaryString1.charAt(index), binaryString2.charAt(index));
    }
    return output;
  }

  Character calculateXorCombination(Character binaryChar1, Character binaryChar2) {
    if ((binaryChar1 == '1' || binaryChar2 == '1') && (binaryChar1 != binaryChar2)) {
      return '1';
    }
    return '0';
  }
}