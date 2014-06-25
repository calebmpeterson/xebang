(ns xebang.views.bangs
  (:use [hiccup core page form])
  (:require [xebang.views.layouts :refer [page]]
            [xebang.views.tags :refer :all]
            [xebang.util :as util]))


(defn- tr-bang [bang-def]
  [:tr [:td.monospace (:bang bang-def)]
       [:td (abbr (:name bang-def) 25)]
       [:td {:title (:url-pattern bang-def) :data-toggle "tooltip"} [:code (util/elide 50 (:url-pattern bang-def))]]
       [:td
        [:a.pull-right.action {:href "#" :title "Delete"} [:i.icon-remove]]
        [:span.pull-right "&nbsp;&nbsp;"]
        [:a.pull-right.action {:href "#" :title "Edit"} [:i.icon-edit]]]])


(defn show [config]
  (page "Configure !Xebang"
        [:div.row [:div.spacer20]]
        (navbar)
        [:div.row [:div.span10.offset1 [:h3 "Configuration"]]]
        [:div.row [:div.span10.offset1 [:hr]]]
        [:div.row
         [:div.span10.offset1 [:h4 "Default Search Engine"]]]
        [:div.row
         [:div.span10.offset1
          [:p "The search engine used when there isn't a leading ! in the query. Use a "
              [:code "{{{s}}}"] " to indicate where the search phrase goes in the URL. "
              "e.g. " [:code "http://duckduckgo.com/?q={{{s}}}"]]]]
        [:div.row
         [:div.span10.offset1
          (form-to {:class "form-inline"}
                   [:post "/bangs/default-search-engine"]
                   [:input {:type "hidden" :name "config-id" :value (:id config)}]
                   [:input.span9 {:type "text" :name "default-search-engine" :value (:default-search-pattern config)}]
                   (submit-button {:class "btn pull-right"} "Update"))]]
        [:div.row [:div.span10.offset1 [:hr]]]
        [:div.row
         [:div.span9.offset1 [:h4 "Bangs"]]
         [:div.span1 [:div.spacer20] [:a.btn.pull-right.create {:href "/config/new" :title "Define a bang"} [:i.icon-plus]]]]
        [:div.row
         [:div.span10.offset1
          [:table.table
           [:thead [:tr [:th "!bang"] [:th "Name"] [:th "URL Pattern"] [:th]]]
           [:tbody (doall (map tr-bang (:bangs config)))]]]]))


(defn edit [title bang-def]
  (page (str title " " (:bang bang-def))
        [:div.row [:div.spacer20]]
        (navbar)
        [:div.row [:div.span10.offset1 [:h3 title]]]
        [:div.row [:div.span10.offset1 [:hr]]]
        [:div.row
         [:div.span10.offset1
          (form-to {:class "form-horizontal"}
                   [:post "/config/update"]
                   [:input {:type "hidden" :name ":id" :value (:id bang-def)}]
                   [:div.control-group
                    [:label.control-label {:for ":bang"} "Bang:"]
                    [:div.controls [:input.input-xxlarge {:type "text" :name ":bang" :value (:bang bang-def) :autofocus "true"}]]]
                   [:div.control-group
                    [:label.control-label {:for ":name"} "Name:"]
                    [:div.controls [:input.input-xxlarge {:type "text" :name ":name" :value (:name bang-def)}]]]
                   [:div.control-group
                    [:label.control-label {:for ":url-pattern"} "URL:"]
                    [:div.controls
                     [:input.input-xxlarge {:type "text" :name ":url-pattern" :spellcheck "false" :value (:url-pattern bang-def)}]
                     [:span.help-block "Use a " [:code "{{{s}}}"] " to indicate where the search phrase goes in the URL. "
                      [:br] "e.g. " [:code "http://duckduckgo.com/?q={{{s}}}"]]]]
                   [:div.form-actions
                    [:a.btn {:href "/config"} "Cancel"]
                    "&nbsp;"
                    (submit-button {:class "btn btn-primary"} "Save")])]]))