(in-ns 'closure-sandbox.core)

;; The prime factors of 13195 are 5, 7, 13 and 29.
;; What is the largest prime factor of the number 600851475143 ?

(defn ceil-sqrt [target] (long (math/ceil (math/sqrt target))))
(defn is-prime? [target] (or (= 2 target) (not-any? #(= 0 (mod target %)) (cons 2 (range 3 target)))))
(defn is-prime-divisor? [target] (and () (is-prime? )))

(defn prime-divisor-candidates [target] 
  (filter #(is-prime? %) (reverse (range 2 (+ 1 (quot target 2))))))

(defn divisors [target] (filter #(= 0 (mod target %)) (prime-divisor-candidates target)))
(defn max-divisor [target] (reduce max (divisors target)))
(defn primes-till [target] (filter #(is-prime? %) (range 2 target)))

(defn bits-count [number] 
  (loop [i 0 value number]
  (if (> value 0) (recur (inc i) (bit-shift-right value 1)) i)))

;; ferma method
(defn ferma-divisors [jobs divisors]
  ;;(println (str "Running jobs=" jobs " divisors=" divisors))
  (if (empty? jobs) 
    (println (str "Divisors are " (sort divisors)))
    (do (def n (first jobs))
      (def m (math/floor (math/sqrt n)))
      (println (str "Running n=" n ", m=" m))
      (if (is-prime? n) 
        (ferma-divisors (rest jobs) (cons n divisors))
        (loop [x 1]
          (def q (- (math/expt (+ m x) 2) n)) ;;q(x) = (m + x)^2 - n
          (def sqrt-q (math/sqrt q))
          (println (str "Iteration " x " q=" q " sqrt(q)=" sqrt-q))
          (if (= (math/floor sqrt-q) sqrt-q) 
            (do (def mx (+ m x))
              (def div1 (int (+ mx sqrt-q)))
              (def div2 (int (- mx sqrt-q)))
              (println (str "Found divisors " div1 " * " div2))
              (ferma-divisors (concat [div1 div2] (rest jobs)) divisors)
            )
            (recur (inc x)) 
          )
        )
      )
    )
  )
)

(defn ferma-ex2 [target] target)

(defn ferma-ex [target] 
  (def simple-primes (primes-till (if (> target 100) 100 target)))
  ;;(print (str simple-primes))
  (loop [value target divisors [] candidates simple-primes]
    (if (empty? candidates)
      [value divisors]
      (do
        (def divisor (first candidates))
        (def remainder (mod value divisor))
        (if (= 0 remainder)
          (recur (quot value divisor) (cons divisor divisors) (rest candidates))
          (recur value divisors (rest candidates))
        )
      )
    )
  )
)

;;(defn solution [] (bits-count 600851475143))
;;(defn solution [] (max-divisor3 600851475143))
;;(defn solution [] (max-divisor3 100))

;;Found divisors: 1234169.0 * 486847.0
;;(defn solution [] (ferma-divisors 600851475143))
;;600851475143 = 1234169 * 486847 = 1471 * 839 * 6857 * 71
;;(defn solution [] (ferma-divisors [998001] []))
(defn solution3 [] (ferma-divisors [600851475143] []))



