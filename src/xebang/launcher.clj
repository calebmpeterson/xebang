(ns xebang.launcher
  (:require [ring.adapter.jetty :as jetty]
            [xebang.handler :refer [app]]))

(defn -main [port]
  (jetty/run-jetty app {:port (Integer. port) :join? false}))