(ns closure-sandbox.core
  (:gen-class))

(defn is-multiple-of [x, y] (= (rem x y) 0))
(defn is-multiple-of-3-or-5 [x] (or (is-multiple-of x 3) (is-multiple-of x 5)))
(defn only-multiples-of-3-or-5 [limit] 
  (filter #(is-multiple-of-3-or-5 %) (range 1 (inc limit))))

(defn multiples-of-3-and-5
  "Calculates sum of all numbers that are multiples of 3 or 5"
  [limit]
  (println (str "Calculating multiples sum for " limit " (including)"))
  (println (reduce + (only-multiples-of-3-or-5 limit)))
)

(defn -main
  "Main function"
  [& args]
  (multiples-of-3-and-5 999))

