(ns xebang.models.db
  (:require [somnium.congomongo :as m]))

(def conn (m/make-connection (System/getenv "MONGOHQ_URL")))

(m/set-connection! conn)