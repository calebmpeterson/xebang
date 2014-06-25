(ns xebang.test.util
  (:use [clojure.test]
        [xebang.util]))

(deftest string-ellision
  (testing "short strings are untouched"
    (is (= (elide 10 "012345678") "012345678"))
    (is (= (elide 10 "") ""))
    (is (= (elide 10 nil) nil)))
  (testing "long strings are elided"
    (is (= (elide 6 "0123456") "012..."))))