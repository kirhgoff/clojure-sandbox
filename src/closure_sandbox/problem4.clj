(ns clojure-sandbox.problem4
  (import java.io.File)
  (import java.awt.Color)
  (import java.awt.image.BufferedImage)
  (import javax.imageio.ImageIO))

(defn digits [number] 
  (cons (mod number 10) (lazy-seq (digits (quot number 10)))))

(defn draw-3-digit-palindromes
  "Take width, height, and the map of mines. Save to a file.
  Supposed to take a generate-random-map{,-perc} mapping."
  [file]
  (def ^:const width 1000)
  (def ^:const height 1000)
  (let [bi (BufferedImage. width height BufferedImage/TYPE_INT_ARGB)
        g (.createGraphics bi)]
    (do
      (.setColor g Color/white)
      (.fillRect g 0 0 width height)
      (.setColor g Color/black)      
      (doseq [[x] (range 0 999)]
        (def y x)
        (.drawLine g x y x y))
      (ImageIO/write bi "png" (File. file)))))

(defn solution [x] 
  (println "Nothing"))