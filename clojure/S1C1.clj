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

(defn getBinaryStringForHexString
  [hexString]
  (reduce str (map #(getBinaryStringForHexCharacter %) hexString)))

(defn getBase64StringForHex
  [hexString]
  (getBinaryStringForHexString hexString))
