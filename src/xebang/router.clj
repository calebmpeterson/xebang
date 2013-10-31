(ns xebang.router
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :refer [redirect]]
            [xebang.views :as views]
            [xebang.controllers.bangs :as controllers-bangs]
            [xebang.models.bangs :as models-bangs]))

(defroutes app-routes
  (GET "/" [] (views/index models-bangs/catalog))
  (GET "/browser" [] (views/browser))
  (GET "/q/" [query] (redirect (controllers-bangs/!bang models-bangs/catalog query)))
  (route/resources "/")
  (route/not-found "Not Found"))

(def site-routes (handler/site app-routes))
