(in-ns 'closure-sandbox.core)

;; A palindromic number reads the same both ways. 
;; The largest palindrome made from the product of two 2-digit numbers 
;; is 9009 = 91 × 99.
;; Find the largest palindrome made from the product of two 3-digit numbers.

(defn digits [number] 
  (loop [current number result []] 
    (if (< current 10)
      (cons current result)
      (recur (quot current 10) (cons (mod current 10) result))
    )
  )
)

(defn ensure-three-digits [x] 
  (def digits-list (digits x))
  (loop [current digits-list]
    (if (>= (count current) 3)
      current
      (recur (cons 0 current))
    )
  )  
)

(defn make-number 
  ([digits]
    (if (empty? digits) 
      0
      (do 
        (def tenth (math/expt 10 (count (rest digits))))
        (+ (* (first digits) tenth) (make-number (rest digits)))
      )
    ) 
  )
)

(defn twin [x] (make-number (reverse (ensure-three-digits x))))

(defn all-six-digit-palindromes [] 
  (filter #(> % 100000 ) (map #(+ (* 1000 (twin %)) %) (range 0 999))))

(defn palindrome-candidates []
  (filter 
    ;;(fn [x] (let [[remainder divisors] x] (remainder < 1000))) 
    #(< (first %) 1000)
    (map #(sieve %) (all-six-digit-palindromes))
  )
)

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
      (doseq [x (range 0 999)]
        (.fillOval g x (twin x) 5 5))
        ;;(println x))
      (ImageIO/write bi "png" (File. file)))))

(defn solution4 [] 
  ;;(println (str "Digits are: " (digits 789)))
  ;;(println (str "Number is: " (make-number [1 2 3])))
  ;;(println (str "Twin is: " (twin 123)))
  ;;(draw-3-digit-palindromes "/Users/kirilllastovirya/projects/clojure-sandbox/palindromes.png")
  ;;(println (divisors-fermi 779977))

  (doseq [x (palindrome-candidates)] (println x))
)