(ns xebang.views
  (:use [hiccup core page]))


(defn datalist-option [item]
  [:option {:value (str item)}])

(defn datalist [id items]
  [:datalist {:id id}
   (map datalist-option items)])

(defn index [catalog-of-bangs]
  (html5
   [:head
    [:title "!Xebang - Custom URL Bangs"]
    [:link {:href "/img/favicon.png" :rel "shortcut icon"}]
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
        [:h1 "!xebang" [:small " custom url bangs"]]]]
      [:div.row
       [:div.span6.offset3
        [:form.form-inline {:id "command" :method "GET" :action "/q/"}
         [:div.input-append
          [:input.span5 {:id "input" :name "query" :type "text" :placeholder "bang bang!" :autocomplete true :list "bangs" :autofocus true}]
          (datalist "bangs" (map #(str % " ") (keys catalog-of-bangs)))
          [:button#go.btn.btn-primary [:i.icon-search.icon-white]]]]]]
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
        [:div.span12.text-center
         [:small "Built by "
          [:a {:href "http://www.cubicle6.com"} "Caleb Peterson"] " | "
          [:a {:href "mailto:caleb.peterson@cubicle6.com"} "E-mail Me"] " | "
          "Inspired by " [:a {:href "http://www.duckduckgoog.com/"} "DuckDuckGoog"] " | "
          [:a {:href "https://github.com/calebmpeterson/xebang"} "Source on GitHub"] " | "
          "Soli Deo Gloria"]]]]]]))