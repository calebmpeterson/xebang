(ns xebang.test.apps
  (:require [clojure.test :refer :all]
            [xebang.apps :as apps]))

(def bangs
  {'!weather "http://www.weather.com/weather/hourbyhour/graph/{{{s}}}"})

(deftest test-process
  (testing "custom bang"
    (is (= (apps/process bangs "!weather 76137")
           "http://www.weather.com/weather/hourbyhour/graph/76137")))
  (testing "fallback to DuckDuckGo's bangs"
    (is (= (apps/process {} "!g foo bar")
           "https://duckduckgo.com/?q=!g foo bar")))
  (testing "fallback to default search provider"
    (is (= (apps/process {} "foo bar")
           "https://duckduckgo.com/?q=foo bar"))))