(ns xebang.views.tags
  (:use [hiccup core page element])
  (:require [xebang.util :as util]))


(defn navbar []
  [:div.row
   [:div.span10.offset1
    [:div.navbar
     [:div.navbar-inner
      [:a.brand {:href "/"} (image "/img/xebang-24.png") "ebang"]]]]])

(defn abbr [text max-length]
  [:abbr {:title text} (util/elide max-length text)])