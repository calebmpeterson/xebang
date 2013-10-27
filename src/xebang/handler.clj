(ns xebang.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :refer [redirect]]
            [xebang.views :as views]
            [xebang.apps :as apps]))

(defroutes app-routes
  (GET "/" [] (views/index apps/catalog))
  (GET "/browser" [] (views/browser))
  (GET "/q/" [query] (redirect (apps/process apps/catalog query)))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
