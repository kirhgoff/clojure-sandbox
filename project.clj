(defproject closure-sandbox "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
    [org.clojure/clojure "1.7.0"]
    [org.clojure/math.numeric-tower "0.0.4"]
  ]
  :main ^:skip-aot closure-sandbox.core
  :target-path "target/%s"
  :test-paths ["test"]  
  :profiles {:uberjar {:aot :all}}
  :jvm-opts ["-Xmx4G" "-Djava.awt.headless=true"]
)
