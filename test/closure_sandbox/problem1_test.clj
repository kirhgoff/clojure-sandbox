(ns closure-sandbox.core-test
  (:require [clojure.test :refer :all]))

(deftest is-multiple-of-test
  (testing "checking is-multiple"
    (is (= true (is-multiple-of 3 3)))
    (is (= true (is-multiple-of 6 3)))
    (is (= false (is-multiple-of 7 3))))

  (testing "checking is-multiple-both"
    (is (= true (is-multiple-of-3-or-5 3)))
    (is (= true (is-multiple-of-3-or-5 5)))
    (is (= true (is-multiple-of-3-or-5 15)))
    (is (= false (is-multiple-of-3-or-5 7)))
    (is (= false (is-multiple-of-3-or-5 14))))

  (testing "only-multiples-filter"
    (is (= [3 5 6 9] (only-multiples-of-3-or-5 9)))
    (is (= [] (only-multiples-of-3-or-5 2)))
    (is (= [3] (only-multiples-of-3-or-5 3)))
    (is (= [3 5] (only-multiples-of-3-or-5 5)))
  )
)
