(defn getMapOfAllCharacters
  []
  (range 0 255))

(defn hello
  []
  (map #(Inte %) (getMapOfAllCharacters)))