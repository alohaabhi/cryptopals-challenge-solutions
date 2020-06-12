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

(defn getHashMapForDecimalToBase64Conversion
  []
  [\A, \B, \C, \D, \E, \F, \G, \H, \I, \J, \K, \L, \M
   \N, \O, \P, \Q, \R, \S, \T, \U, \V, \W, \X, \Y, \Z
   \a, \b, \c, \d, \e, \f, \g, \h, \i, \j, \k, \l, \m
   \n, \o, \p, \q, \r, \s, \t, \u, \v, \w, \x, \y, \z
   \0, \1, \2, \3, \4, \5, \6, \7, \8, \9, \+, \/])

(defn getBase64StringFromDecimalSequence
  [decimalSequence]
  (reduce str (map #(get (getHashMapForDecimalToBase64Conversion) %) decimalSequence)))

(defn getBase64StringForHex
  [hexString]
  (getBase64StringFromDecimalSequence (getSequenceOfDecimalValuesFromBinary (getSequenceOf6CharStringsFromLengthyString (getPaddedBinaryStringForBase64Conversion (getBinaryStringForHexString hexString))))))

(defn getSolutionToS1C1
  []
  (getBase64StringForHex "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d"))