(ns closure-sandbox.core
  (import java.io.File)
  (import java.awt.Color)
  (import java.awt.image.BufferedImage)
  (import javax.imageio.ImageIO)
  (import java.lang.Math)

  (:require [clojure.math.numeric-tower :as math])

  (:gen-class))

(load "problem1")
(load "problem2")
(load "problem3")
(load "problem4")

  
(defn -main
  "Main function"
  [& args]
  ;;(problem1/multiples-of-3-and-5 999))
  ;;(solution3)
  ;;(println (solution 2))
  (solution4)
)



