(in-ns 'closure-sandbox.core)

;; Each new term in the Fibonacci sequence is generated 
;; by adding the previous two terms. By starting with 1 and 2, 
;; the first 10 terms will be:
;; 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
;; By considering the terms in the Fibonacci sequence 
;; whose values do not exceed four million, 
;; find the sum of the even-valued terms

(defn fibonacci [a b] (cons a (lazy-seq (fibonacci b (+ b a)))))
(defn limited-fibonacci [limit] (take-while #(< % limit) (fibonacci 1 1)))
(defn even-limited-fibonacci [limit] 
  (filter #(= 0 (rem % 2)) (limited-fibonacci limit))
)

(defn sum-even-limited-fibonacci [limit] 
  (reduce + (even-limited-fibonacci limit))
)

(defn solution2 [limit] 
  (println "Sum of even-valued fibonacci numbers limited by " limit " is "
    (sum-even-limited-fibonacci limit))
)