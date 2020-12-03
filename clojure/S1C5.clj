(defn getBinaryValueForCharacter
  [character]
  (Integer/toBinaryString (int character)))

(defn getListOfBinaryEncryptionKeys
  []
  (map #(getBinaryValueForCharacter %) (list \I \C \E)))

(defn getHexEncryptedString
  [input]
  (reduce str (map #(getHexStringForBinaryString %) (map (fn [x y] (calculateXorCombinationForBinaryStrings x y)) (cycle (getListOfBinaryEncryptionKeys)) (map #(getBinaryValueForCharacter %) input)))))

(defn getSolutionToS1C5
  []
  (println (getHexEncryptedString "Burning 'em, if you ain't quick and nimble\nI go crazy when I hear a cymbal")))