(ns closure-sandbox.core
  (:require [closure-sandbox.problem3 :as problem3])
  (:gen-class))

(defn -main
  "Main function"
  [& args]
  ;;(problem1/multiples-of-3-and-5 999))
  ;;(problem2/solution 4000000)
  (println (problem3/solution))
)


