import java.util.ArrayList;
import java.util.List;

public class FormarConverter {

  private static final char[] toBase64 = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
      'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
      'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
      '9', '+', '/' };

  String binaryToHex(String binaryString) {
    String hexString = "";
    for (int index = 0; index < binaryString.length(); index += 4) {
      hexString += getHexCharacterForBinaryString(binaryString.substring(index, index + 4));
    }
    return hexString;
  }

  String hexToBinary(String hexString) {
    char[] charactersFromHexString = hexString.toCharArray();
    String binaryString = "";
    int index = 0;
    while (index < charactersFromHexString.length) {
      binaryString += getBinaryStringForHexCharacter(charactersFromHexString[index]);
      index += 1;
    }
    return binaryString;
  }

  String binaryToBase64(String binaryString) {
    String base64String = "";
    String paddedBinaryString = getPaddedBinaryStringForBase64Conversion(binaryString);

    List<String> listOfSixBitGroups = new ArrayList<String>();
    for (int i = 0; i < paddedBinaryString.length(); i = i + 6) {
      listOfSixBitGroups.add(paddedBinaryString.substring(i, i + 6));
    }

    for (int i = 0; i < listOfSixBitGroups.size(); i = i + 1) {
      base64String += getBase64CharForDecimalValue(Integer.parseInt(listOfSixBitGroups.get(i), 2));
    }
    return base64String;
  }

  private char getBase64CharForDecimalValue(int decimalValue) {
    return toBase64[decimalValue];
  }

  private String getPaddedBinaryStringForBase64Conversion(String unpaddedString) {
    if (unpaddedString.length() % 6 == 0) {
      return unpaddedString;
    }

    int numberOfDigitsNeededToMakeLengthDivisibleBySix = unpaddedString.length() - (unpaddedString.length() % 6);
    String paddedBinaryString = unpaddedString;
    for (int i = 1; i <= numberOfDigitsNeededToMakeLengthDivisibleBySix; i++) {
      paddedBinaryString += "0";
    }
    return paddedBinaryString;
  }

  private String getBinaryStringForHexCharacter(char hexCharacter) {
    switch (hexCharacter) {
      case '0':
        return ("0000");
      case '1':
        return ("0001");
      case '2':
        return ("0010");
      case '3':
        return ("0011");
      case '4':
        return ("0100");
      case '5':
        return ("0101");
      case '6':
        return ("0110");
      case '7':
        return ("0111");
      case '8':
        return ("1000");
      case '9':
        return ("1001");
      case 'A':
      case 'a':
        return ("1010");
      case 'B':
      case 'b':
        return ("1011");
      case 'C':
      case 'c':
        return ("1100");
      case 'D':
      case 'd':
        return ("1101");
      case 'E':
      case 'e':
        return ("1110");
      case 'F':
      case 'f':
        return ("1111");
      default:
        // throw exception here
        return ("");
    }
  }

  private Character getHexCharacterForBinaryString(String binaryString) {
    Integer decimalValue = Integer.parseInt(binaryString, 2);
    if (decimalValue <= 9) {
      return Character.forDigit(decimalValue, 10);
    }
    switch (binaryString) {
      case ("1010"):
        return ('a');
      case ("1011"):
        return ('b');
      case ("1100"):
        return ('c');
      case ("1101"):
        return ('d');
      case ("1110"):
        return ('e');
      case ("1111"):
        return ('f');
      default:
        // throw exception here
        return (' ');
    }
  }
}