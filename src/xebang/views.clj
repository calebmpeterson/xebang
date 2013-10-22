(ns xebang.views
  (:use [hiccup core page]))

(defn index []
  (html5
   [:head
    [:title "Xebang! - Custom URL Bangs"]
    (include-css "/libs/bootstrap/css/bootstrap.cyborg.css")
    (include-css "/css/main.css")
    (include-js "/libs/jquery/jquery-1.9.1.min.js")
    (include-js "/libs/bootstrap/js/bootstrap.min.js")
    (include-js "/js/script.js")]
   [:body
    [:div.container
     [:div {:style "width: 100%; height: 300px;"}]
     [:div.row
      [:div.span6.offset3
       [:h1 "xebang!" [:small " custom url bangs"]]]]
     [:div.row
      [:div.span6.offset3
       [:form.form-inline {:id "command" :method "GET" :action "/q/"}
        [:div.input-append
         [:input.span5 {:id "input" :name "query" :type "text" :placeholder "bang bang!" :autofocus true}]
         [:button.btn.btn-primary [:i.icon-search.icon-white]]]]]]
     [:div.row
      [:div.span6.offset3 "Enter a bang. Perform a search. "
       [:a {:href "/help"} "View the docs"] ". "
       [:a {:href "/browser"} "Tell your browser"] "!"]]]]))