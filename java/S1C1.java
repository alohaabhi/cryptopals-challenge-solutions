public class S1C1 {
  public static void main(String args[]) {
    String hexString = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
    System.out.println("Hex = " + hexString);

    FormarConverter converter = new FormarConverter();

    String binaryString = converter.hexToBinary(hexString);
    System.out.println("Binary = " + binaryString);

    String base64String = converter.binaryToBase64(binaryString);
    System.out.println("Base64 = " + base64String);
  }
}
