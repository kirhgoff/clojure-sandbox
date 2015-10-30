(ns closure-sandbox.problem4
  (:require [clojure.test :refer :all]
            [closure-sandbox.problem4 :refer :all]))

(deftest problem4
  (testing "digits"
    (is (= [1 3] (digits 13)))
  )

)