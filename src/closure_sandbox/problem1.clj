(ns closure-sandbox.core
  (:gen-class))

;; If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
;; Find the sum of all the multiples of 3 or 5 below 1000.

(defn is-multiple-of [x, y] (= (rem x y) 0))
(defn is-multiple-of-3-or-5 [x] (or (is-multiple-of x 3) (is-multiple-of x 5)))
(defn only-multiples-of-3-or-5 [limit] 
  (filter #(is-multiple-of-3-or-5 %) (range 1 (inc limit))))

(defn multiples-of-3-and-5
  "Calculates sum of all numbers that are multiples of 3 or 5"
  [limit]
  (println (str "Multiples sum for " limit " (including) is " 
    (reduce + (only-multiples-of-3-or-5 limit)))
  )
)