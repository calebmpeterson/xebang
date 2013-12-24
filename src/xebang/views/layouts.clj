(ns xebang.views.layouts
  (:use [hiccup core page]))


(defn page [title & content]
  (html5
   [:head
    [:title title]
    [:link {:rel "shortcut icon" :href "/img/favicon.png"}]
    [:link {:rel "search" :href "/opensearch.xml" :type "application/opensearchdescription+xml" :title "Xebang Without Suggestions"}]
    (include-css "/libs/bootstrap/css/bootstrap.spacelab.min.css")
    (include-css "/css/main.css")
    (include-js "/libs/jquery/jquery-1.9.1.min.js")
    (include-js "/libs/bootstrap/js/bootstrap.min.js")
    (include-js "/js/script.js")]
   [:body
    [:div#wrapper
     [:div.container content]
     [:div#push]]
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