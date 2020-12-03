(defn getSolutionToS1C4
  []
  (with-open [rdr (clojure.java.io/reader "./resources/S1C4.txt")]
    (reduce
     (fn
       [result input]
       (cond
         (< (result :score) (input :score)) input
         :else result)) (map-indexed (fn [index x] (assoc (getDecryptedSentence x) :index index)) (line-seq rdr)))))