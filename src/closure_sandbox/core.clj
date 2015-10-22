(ns closure-sandbox.core
  (:require [closure-sandbox.problem2 :as problem2])
  (:gen-class))

(defn -main
  "Main function"
  [& args]
  ;;(problem1/multiples-of-3-and-5 999))
  (problem2/solution 4000000)
)


