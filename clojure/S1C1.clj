(defn getBinaryStringForHexCharacter
  [hexChar]
  (case hexChar
    \0 "0000"
    \1 "0001"
    \2 "0010"
    \3 "0011"
    \4 "0100"
    \5 "0101"
    \6 "0110"
    \7 "0111"
    \8 "1000"
    \9 "1001"
    (\A \a) "1010"
    (\B \b) "1011"
    (\C \c) "1100"
    (\D \d) "1101"
    (\E \e) "1110"
    (\F \f) "1111"
    ""))

(defn getPaddedBinaryStringForBase64Conversion
  [unpaddedString]
  (if (= (mod (count unpaddedString) 6) 0)
    unpaddedString
    (reduce str (concat unpaddedString (repeat (- 6 (mod (count unpaddedString) 6)) \0)))))

(defn getBinaryStringForHexString
  [hexString]
  (reduce str (map #(getBinaryStringForHexCharacter %) hexString)))

(defn getSequenceOf6CharStringsFromLengthyString
  [lengthyString]
  (map (partial apply str) (partition-all 6 lengthyString)))

(defn getDecimalValueForBinaryString
  [binaryString]
  (Integer/parseInt binaryString 2))

(defn getSequenceOfDecimalValuesFromBinary
  [sequenceOfBinaryStrings]
  (map #(getDecimalValueForBinaryString %) sequenceOfBinaryStrings))

(defn getBase64StringForHex
  [hexString]
  (getSequenceOfDecimalValuesFromBinary (getSequenceOf6CharStringsFromLengthyString (getPaddedBinaryStringForBase64Conversion (getBinaryStringForHexString hexString)))))
