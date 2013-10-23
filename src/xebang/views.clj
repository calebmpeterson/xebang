(ns xebang.views
  (:use [hiccup core page]))

(defn index []
  (html5
   [:head
    [:title "Xebang! - Custom URL Bangs"]
    [:link {:rel "search" :type "application/opensearchdescription+xml" :href "/opensearch.xml" :title "Xebang Without Suggestions"}]
    (include-css "/libs/bootstrap/css/bootstrap.spacelab.min.css")
    (include-css "/css/main.css")
    (include-js "/libs/jquery/jquery-1.9.1.min.js")
    (include-js "/libs/bootstrap/js/bootstrap.min.js")
    (include-js "/js/script.js")]
   [:body
    [:div#wrapper
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
       [:div.span6.offset3
        [:small "Enter a bang. Perform a search. "
         [:a {:href "/help"} "View the docs"] ". "
         [:a {:href "/browser"} "Tell your browser"] "!"]]]]
     [:div.push]]
    [:div.footer-top-trim]
    [:footer
     [:div.container
      [:div.spacer20]
      [:div.row
        [:div.span6.offset3.text-center
         [:small "Built by "
          [:a {:href "http://www.cubicle6.com"} "Caleb Peterson"] " | "
          [:a {:href "mailto:caleb.peterson@cubicle6.com"} "E-mail Me"] " | "
          "Soli Deo Gloria"]]]]]]))