(require '[clojure.string :as string])

(defn getSolutionToS1C3
  []
  (map (fn [x] (reduce str (map (fn [y] (char (Integer/parseInt (calculateXorCombinationForBinaryStrings (Integer/toBinaryString x) (reduce str y)) 2))) (partition 8 (getBinaryStringForHexString "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736"))))) (range 0 255)))