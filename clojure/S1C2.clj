(require '[clojure.string :as string])

(defn calculateXorCombinationForBinaryCharacters
  [binaryCharacter1 binaryCharacter2]
  (if (and (not= binaryCharacter1 binaryCharacter2) (or (= binaryCharacter2 \1) (= binaryCharacter1 \1))) \1 \0))

(defn calculateXorCombinationForBinaryStrings
  [binaryString1 binaryString2]
  (reduce str (map calculateXorCombinationForBinaryCharacters (str (string/join (repeat (- (max (count binaryString1) (count binaryString2)) (count binaryString1)) "0")) binaryString1) (str (string/join (repeat (- (max (count binaryString1) (count binaryString2)) (count binaryString2)) "0")) binaryString2))))

(defn calculateXorCombinationForHexStrings
  [hexString1 hexString2]
  (calculateXorCombinationForBinaryStrings (getBinaryStringForHexString hexString1) (getBinaryStringForHexString hexString2)))

  (defn getHexCharacterForBinaryString
    [binaryString]
    (case binaryString
      "0000" \0
      "0001" \1
      "0010" \2 
      "0011" \3 
      "0100" \4 
      "0101" \5 
      "0110" \6 
      "0111" \7 
      "1000" \8 
      "1001" \9 
      "1010" \a
      "1011" \b
      "1100" \c
      "1101" \d
      "1110" \e
      "1111" \f
      ""))

(defn getStringPrefixedToMakeLengthAMultipleOffour
  [unpaddedString]
  (if (= (mod (count unpaddedString) 4) 0)
  unpaddedString
  (reduce str (concat (repeat (- 4 (mod (count unpaddedString) 4)) \0) unpaddedString))))

(defn getSetsOfFourCharactersFromBinaryString
  [binaryString]
  (map #(reduce str %) (partition 4 binaryString)))

(defn getHexStringForBinaryString
  [binaryString]
  (reduce str (map getHexCharacterForBinaryString (getSetsOfFourCharactersFromBinaryString (getStringPrefixedToMakeLengthAMultipleOffour binaryString)))))

  (defn getSolutionToS2C2
    []
    (getHexStringForBinaryString (calculateXorCombinationForBinaryStrings (getBinaryStringForHexString "1c0111001f010100061a024b53535009181c") (getBinaryStringForHexString "686974207468652062756c6c277320657965"))))