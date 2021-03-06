(ns closure-sandbox.core-test
  (:require [clojure.test :refer :all]))

(deftest basic-tests :default
  (is (= [1 1 2] (limited-fibonacci 3)))
  (is (= [1 1 2 3] (limited-fibonacci 4)))
  (is (= [2 8] (even-limited-fibonacci 10)))
  (is (= 10 (sum-even-limited-fibonacci 10)))
)
