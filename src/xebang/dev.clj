(ns xebang.dev
  (:require [clojure.test]))

(defn reload-self []
  (require '[xebang.dev :refer :all] :reload :verbose))

(defn autotest []
  (require '[xebang.test.handler]
           '[xebang.test.apps]
           :reload :verbose)
  (clojure.test/run-tests 'xebang.test.router
                          'xebang.test.apps))