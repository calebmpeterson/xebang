(ns xebang.test.router
  (:use clojure.test
        ring.mock.request
        xebang.router))

(deftest test-app
  (testing "main route"
    (let [response (site-routes (request :get "/"))]
      (is (= (:status response) 200))))

  (testing "tell your browser"
    (let [response (site-routes (request :get "/browser"))]
      (is (= (:status response) 200))))

  (testing "!bang"
    (let [response (site-routes (request :get "/q/?query=!html%20array"))]
      (is (= (:status response) 302))))

  (testing "not-found route"
    (let [response (site-routes (request :get "/invalid"))]
      (is (= (:status response) 404)))))