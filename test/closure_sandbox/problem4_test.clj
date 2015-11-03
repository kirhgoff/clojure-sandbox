(ns closure-sandbox.core-test
  (:require [clojure.test :refer :all]))

(deftest problem4
  (testing "digits"
    (is (= [1 3] (digits 13)))
  )
)