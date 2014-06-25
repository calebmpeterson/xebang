(ns xebang.views
  (:use [hiccup core page])
  (:require [xebang.views.layouts :refer [page]]
            [xebang.views.tags :refer :all]))


(defn datalist-option [item]
  [:option {:value (str item)}])

(defn datalist [id items]
  [:datalist {:id id}
   (map datalist-option items)])


(defn index [catalog-of-bangs]
  (page "!Xebang | Custom URL Bangs"
   [:div {:style "width: 100%; height: 300px;"}]
   [:div.row
    [:div.span6.offset3
     [:h1 [:img {:src "img/xebang-48.png"}] "ebang" [:small " custom search !bangs"]]]]
   [:div.row
    [:div.span6.offset3
     [:form.form-inline {:id "command" :method "GET" :action "/q/"}
      [:div.input-append
       [:input.span5 {:id "input" :name "query" :type "text" :placeholder "!bang bang" :autofocus true :autocomplete true :list "bangs"}]
       (datalist "bangs" (map #(str % " ") (keys catalog-of-bangs)))
       [:button#go.btn.btn-primary [:i.icon-search.icon-white]]]]]]
   [:div.row
    [:div.span6.offset3
     [:small "Enter a bang. Perform a search. "
      [:a.underlined {:href "/config"} "Configure"] ". "
      [:a.underlined {:href "/browser"} "Tell your browser"] "!"]]]))


(defn browser []
  (page "Tell Your Browser About !Xebang"
        [:div.row [:div.spacer20]]
        (navbar)
        [:div.row
         [:div.span10.offset1
          [:h3 "Tell Your Browser"]]]
        [:div.row
         [:div.span10.offset1
          [:p "!Xebang can be configured as your default search engine simply by pointing your browser at: "]
          [:pre "http://xebang.cubicle6.com/q/?query=%s"]
          [:p "Where " [:code "%s"] " is the bang or search term."]]]))