(ns xebang.views
  (:use [hiccup core page])
  (:require [xebang.views.layouts :refer [page]]))


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
     [:h1 "!Xebang" [:small " custom url bangs"]]]]
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
      [:a {:href "/browser"} "Tell your browser"] "!"]]]))


(defn browser []
  (page "Tell Your Browser | !Xebang"
        [:div.row
         [:div.span6.offset3
          [:h3 "Tell Your Browser"]]]
        [:div.row
         [:div.span6.offset3
          [:p "Xebang can be configured as your default search engine simply by pointing your browser at: "]
          [:pre "/q/?query=%1"]
          [:p "Where " [:code "%1"] " is the bang or search term."]]]))