(defproject xebang "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [ring/ring-jetty-adapter "1.2.0"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.3"]
                 [congomongo "0.4.1"]]
  :plugins [[lein-ring "0.8.5"]]
  :ring {:handler xebang.router/site-routes}
  :uberjar-name "xebang-standalone.jar"
  ;; Warns users of earlier versions of Leiningen.
  :min-lein-version "2.0.0"
  :repl-options {:init-ns xebang.dev}
  :profiles {:dev {:dependencies [[ring-mock "0.1.5"]]}})
