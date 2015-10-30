(ns closure-sandbox.core
  (:gen-class)
  (import java.lang.Math)
  (:require [clojure.math.numeric-tower :as math]))

;; The prime factors of 13195 are 5, 7, 13 and 29.
;; What is the largest prime factor of the number 600851475143 ?

(defn ceil-sqrt [target] (long (math/ceil (math/sqrt target))))
(defn is-prime? [target] (or (= 2 target) (not-any? #(= 0 (mod target %)) (cons 2 (range 3 target)))))
(defn is-prime-divisor? [target] (and () (is-prime? )))

(defn prime-divisor-candidates [target] 
  (filter #(is-prime? %) (reverse (range 2 (+ 1 (quot target 2))))))

(defn divisors [target] (filter #(= 0 (mod target %)) (prime-divisor-candidates target)))
(defn max-divisor [target] (reduce max (divisors target)))
;; too long

(defn bits-count [number] 
  (loop [i 0 value number]
  (if (> value 0) (recur (inc i) (bit-shift-right value 1)) i)))

;;http://stackoverflow.com/questions/2022911/idiomatic-clojure-for-progress-reporting
(defn seq-counter 
  "calls callback after every n'th entry in sequence is evaluated. 
  Optionally takes another callback to call once the seq is fully evaluated."
  ([sequence n callback]
     (map #(do (if (= (rem %1 n) 0) (callback)) %2) (iterate inc 1) sequence))
  ([sequence n callback finished-callback]
     (drop-last (lazy-cat (seq-counter sequence n callback) 
                  (lazy-seq (cons (finished-callback) ()))))))

(defn max-divisor2 [target] (reduce max (seq-counter (divisors target) 1 #(print %))))

(defn max-divisor3 [target] 
  (loop [i (quot target 2)]
    (println (str "Processing " i))
    (if (and (= 0 (mod target i)) (is-prime? i)) 
      (println (str "Found solution: " i))
      (recur (dec i)) 
    )
  )
)

;; Fermi method
(defn fermi-divisors [jobs divisors]
  ;;(println (str "Running jobs=" jobs " divisors=" divisors))
  (if (empty? jobs) 
    (println (str "Divisors are " (sort divisors)))
    (do (def n (first jobs))
      (def m (math/floor (math/sqrt n)))
      (println (str "Running n=" n ", m=" m))
      (if (is-prime? n) 
        (fermi-divisors (rest jobs) (cons n divisors))
        (loop [x 1]
          (def q (- (math/expt (+ m x) 2) n)) ;;q(x) = (m + x)^2 - n
          (def sqrt-q (math/sqrt q))
          (println (str "Iteration " x " q=" q " sqrt(q)=" sqrt-q))
          (if (= (math/floor sqrt-q) sqrt-q) 
            (do (def mx (+ m x))
              (def div1 (int (+ mx sqrt-q)))
              (def div2 (int (- mx sqrt-q)))
              (println (str "Found divisors " div1 " * " div2))
              (fermi-divisors (concat [div1 div2] (rest jobs)) divisors)
            )
            (recur (inc x)) 
          )
        )
      )
    )
  )
)

;;(defn solution [] (bits-count 600851475143))
;;(defn solution [] (max-divisor3 600851475143))
;;(defn solution [] (max-divisor3 100))

;;Found divisors: 1234169.0 * 486847.0
;;(defn solution [] (fermi-divisors 600851475143))
;;600851475143 = 1234169 * 486847 = 1471 * 839 * 6857 * 71
;;(defn solution [] (fermi-divisors [998001] []))
(defn solution [] (fermi-divisors [600851475143] []))



