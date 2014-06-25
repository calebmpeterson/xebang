(ns xebang.test.apps
  (:require [clojure.test :refer :all]
            [xebang.controllers.bangs :as bangs]))

(def catalog
  {'!weather "http://www.weather.com/weather/hourbyhour/graph/{{{s}}}"})

(deftest test-process
  (testing "custom bang"
    (is (= (bangs/!bang catalog "!weather 76137")
           "http://www.weather.com/weather/hourbyhour/graph/76137")))
  (testing "fallback to DuckDuckGo's bangs"
    (is (= (bangs/!bang {} "!g foo bar")
           "https://duckduckgo.com/?q=!g foo bar")))
  (testing "fallback to default search provider"
    (is (= (bangs/!bang {} "foo bar")
           "https://duckduckgo.com/?q=foo bar"))))