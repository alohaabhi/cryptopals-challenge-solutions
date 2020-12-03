(require '[clojure.string :as string])

(defn getFrequencyScoreForCharacter
  [character]
  (case character
    \space 15.0
    \a 8.167
    \b 1.492
    \c 2.782
    \d 4.253
    \e 12.702
    \f 2.228
    \g 2.015
    \h 6.094
    \i 6.966
    \j 0.153
    \k 0.772
    \l 4.052
    \n 6.740
    \o 7.507
    \p 1.929
    \q 0.095
    \r 5.987
    \s 6.327
    \t 9.056
    \u 2.758
    \v 0.978
    \w 2.360
    \x 0.150
    \y 1.974
    \z 0.074
    0))

(defn getCharacterFrequencyScoreForSentence
  [sentence]
  (reduce + (map #(getFrequencyScoreForCharacter %) sentence)))

(defn getDecryptedSentenceBasedOnKey
  [key, input]
  (reduce str (map (fn [y] (char (Integer/parseInt (calculateXorCombinationForBinaryStrings (Integer/toBinaryString key) (reduce str y)) 2))) (partition 8 (getBinaryStringForHexString input)))))

(defn getListOfDecryptedSentencesWithAllPossibleKeys
  [input]
  (map (fn [x] (hash-map :key x :sentence (getDecryptedSentenceBasedOnKey x input))) (range 0 255)))

(defn getDecryptedSentence
  [input]
  (reduce
   (fn [result input]
     (cond
       (< (result :score) (input :score)) input
       :else result)) (map (fn [x] (assoc x :score (getCharacterFrequencyScoreForSentence (x :sentence)))) (getListOfDecryptedSentencesWithAllPossibleKeys input))))

(defn getSolutionToS1C3
  []
  (getDecryptedSentence "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736"))