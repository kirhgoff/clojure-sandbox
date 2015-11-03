(ns closure-sandbox.core-test
  (:require [clojure.test :refer :all]))

(deftest basic-tests
  (is (= 2 (ceil-sqrt 4)))
  (is (= 3 (ceil-sqrt 5)))
  (is (= 4 (ceil-sqrt 10)))
  (is (= 5 (ceil-sqrt 25)))
  (is (= 3 (ceil-sqrt 6)))
  (is (= true (is-prime? 2)))
  (is (= true (is-prime? 3)))
  (is (= false (is-prime? 4)))
  (is (= true (is-prime? 5)))
  (is (= false (is-prime? 6)))
  (is (= true (is-prime? 7)))
  (is (= false (is-prime? 8)))
  (is (= false (is-prime? 9)))
  (is (= false (is-prime? 10)))
  (is (= true (is-prime? 11)))
  (is (= false (is-prime? 12)))
  (is (= true (is-prime? 13)))
  (is (= [2 3 5] (prime-divisor-candidates 10)))
  (is (= [2 3 5 7 11] (prime-divisor-candidates 25)))
  (is (= [2 3] (prime-divisor-candidates 6)))
  (is (= [2 3 5 7] (prime-divisor-candidates 14)))  
  (is (= [2 3] (divisors 6)))
  (is (= [2 3] (divisors 12)))
  (is (= [2 7] (divisors 14)))
  (is (= 3 (max-divisor 12)))
  (is (= 7 (max-divisor 14)))
  (is (= 13 (max-divisor 26)))
  (is (= 1 (bits-count 1)))  
  (is (= 2 (bits-count 2)))
  (is (= 2 (bits-count 3)))
  (is (= 3 (bits-count 4)))
  (is (= 3 (bits-count 7)))
  (is (= 4 (bits-count 8)))
)
