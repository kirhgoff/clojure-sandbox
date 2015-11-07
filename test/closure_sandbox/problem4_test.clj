(ns closure-sandbox.core-test
  (:require [clojure.test :refer :all]))

(deftest problem4
  (testing "digits"
    (is (= [1 2 3] (digits 123)))
    (is (= [6 7 9] (digits 679)))
    (is (= [0 0 2] (ensure-three-digits 2))) 
    (is (= 123 (make-number [1 2 3])))
    (is (= 1 (make-number [1])))
    (is (= 12 (make-number [1 2])))
    (is (= 123 (twin 321)))
    (is (= 123456 (twin 654321)))
    (is (= 1 (twin 100)))
    (is (= 100 (twin 1)))
  )
)