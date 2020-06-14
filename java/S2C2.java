public class S2C2 {
  public static void main(String args[]) {
    String input1Hex = "1c0111001f010100061a024b53535009181c";
    System.out.println("input 1 (hex)- " + input1Hex);
    String input2Hex = "686974207468652062756c6c277320657965";
    System.out.println("input 2 (hex)- " + input2Hex);

    FormarConverter formarConverter = new FormarConverter();

    String input1Binary = formarConverter.hexToBinary(input1Hex);
    System.out.println("input 1 (binary)- " + input1Binary);
    String input2Binary = formarConverter.hexToBinary(input2Hex);
    System.out.println("input 2 (binary)- " + input2Binary);

    XorCalculator xorCalculator = new XorCalculator();

    String xorCombinationBinary = xorCalculator.calculateXorCombination(input1Binary, input2Binary);
    System.out.println("xor combination (binary)- " + xorCombinationBinary);
    String xorCombinationHex = formarConverter.binaryToHex(xorCombinationBinary);
    System.out.println("xor combination (hex)- " + xorCombinationHex);
  }
}