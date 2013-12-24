(ns xebang.router
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :refer [redirect]]
            [xebang.views :as views]
            [xebang.views.bangs :as views-bangs]
            [xebang.views.landing :as views-landing]
            [xebang.controllers.bangs :as controllers-bangs]
            [xebang.models.bangs :as models-bangs]))


;; TODO an /echo?msg=... for a default "hello world" !bang (testing and teaching)

(defroutes app-routes
  (GET  "/info"          []      (System/getenv "MONGOHQ_URL"))
  (GET  "/landing"       []      (views-landing/index))
  (GET  "/"              []      (views/index models-bangs/catalog))
  (GET  "/browser"       []      (views/browser))
  (GET  "/q/"            [query] (controllers-bangs/handle-bang models-bangs/catalog query))
  (GET  "/config"        []      (views-bangs/show models-bangs/mock-config))
  (GET  "/config/new"    []      (views-bangs/edit "New !Bang" nil))
  (GET  "/config/edit"   []      (views-bangs/edit "Edit" (first (:bangs models-bangs/mock-config))))
  (POST "/config/update" params  (controllers-bangs/update! (:form-params params)))
  (route/resources "/")
  (route/not-found "Not Found"))

(def site-routes (handler/site app-routes))
