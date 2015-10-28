(ns closure-sandbox.problem3
  (:gen-class)
  (import java.lang.Math)
  (:require [clojure.math.numeric-tower :as math]))

;; The prime factors of 13195 are 5, 7, 13 and 29.
;; What is the largest prime factor of the number 600851475143 ?

(defn ceil-sqrt [target] (long (math/ceil (math/sqrt target))))
(defn is-prime? [target] (or (= 2 target) (not-any? #(= 0 (mod target %)) (cons 2 (range 3 target)))))
(defn prime-divisor-candidates [target] (filter #(is-prime? %) (range 2 (+ 1 (quot target 2)))))
(defn divisors [target] (filter #(= 0 (mod target %)) (prime-divisor-candidates target)))
(defn max-divisor [target] (reduce max (divisors target)))
;; too long

(defn bits-count [number] 
  (loop [i 0 value number]
  (if (> value 0) (recur (inc i) (bit-shift-right value 1)) i)))



(defn solution [] (bits-count 600851475143))





