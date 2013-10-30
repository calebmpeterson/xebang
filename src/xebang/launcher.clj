(ns xebang.launcher
  (:require [ring.adapter.jetty :as jetty]
            [xebang.router :refer [site-routes]]))

(defn -main [port]
  (jetty/run-jetty site-routes {:port (Integer. port) :join? false}))