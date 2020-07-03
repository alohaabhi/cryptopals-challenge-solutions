(defn calculateXorCombinationForBinaryCharacters
  [binaryCharacter1 binaryCharacter2]
  (if (and (not= binaryCharacter1 binaryCharacter2) (or (= binaryCharacter2 \1) (= binaryCharacter1 \1))) \1 \0))

(defn calculateXorCombinationForBinaryStrings
  [binaryString1 binaryString2]
  (reduce str (map calculateXorCombinationForBinaryCharacters binaryString1 binaryString2)))