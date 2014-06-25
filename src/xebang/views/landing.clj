(ns xebang.views.landing
  (:use [hiccup core page form element])
  (:require [xebang.views.layouts :refer [page]]
            [xebang.views.tags :refer :all]
            [xebang.util :as util]))

(defn index []
  (page "!Xebang | Custom Search !Bangs"
        [:div.masthead
         [:ul.nav.nav-pills.pull-right
          [:li.active [:a {:href "#"} "Home"]]
          [:li [:a {:href "mailto:caleb@xebang.com"} "Contact"]]]
         [:h3 (image "img/xebang-32.png") "ebang"]]

        [:div.row
         [:div.span12
          [:div.jumbotron.text-center
           [:h1 "Custom Search !Bangs"]
           [:p.lead "DuckDuckGo !bangs are awesome. Make them your own!"]]]]
        [:div.row [:div.span12 [:hr.padded]]]

        [:div.spacer20]

        [:div.row
         [:div.span8
          [:img.img-polaroid {:src "/img/customize.png"}]]
         [:div.span4
          [:h3 "Customizable !Bangs"]
          [:p "Want to use a different site for checking the weather or news? " [:em "Create a new !bang."]]
          [:p "DuckDuckGo's default JavaScript documentation not your favorite? " [:em "Customize it!"]]]]

        [:div.spacer-feature]

        [:div.row
         [:div.span4
          [:h3 "Fallback to DuckDuckGo"]
          [:p "!Xebang will fallback to any of the " [:strong "thousands"] " of public DuckDuckGo !bangs when a custom one is not defined."]]
         [:div.span8
          [:img.img-polaroid {:src "/img/duckduckgo-bangs.png"}]]]

        [:div.spacer-feature]

        [:div.row
         [:div.span8
          [:img.img-polaroid {:src "/img/default-search.png"}]]
         [:div.span4
          [:h3 "Default Search Engine"]
          [:p "Use your favorite search engine; whether you prefer Google, Bing, Yahoo, DuckDuckGo, or another, !Xebang works."]]]

        [:div.spacer-feature]

        [:div.row
         [:div.span4
          [:h3 "Use Your Browser"]
          [:p "!Xebang integrates with your preferred browser's search functionality."]]
         [:div.span8
          [:img.img-polaroid {:src "/img/browsers.png"}]]]

        [:div.spacer-feature]

        [:div.row
         [:div.span8
          [:img.img-polaroid {:src "/img/workflow.png"}]]
         [:div.span4
          [:h3 "Fit Your Workflow"]
          [:p "!Xebang also plays nicely with application accelerators such as Launchy."]]]

        [:div.spacer-feature]

        [:div.row [:div.span12 [:hr.padded]]]

        [:div.row
         [:div.span7.text-right.jumbotron.lower
          [:h1 [:img {:src "img/xebang-64.png"}] "ebang"]]
         [:div.span5 [:p.pitch "Customizable" [:br] "Search !Bangs"]]]

        [:div.row
         [:div.span10.offset3.text-left
          (form-to {:class "form-inline"}
                   [:post "/landing/sign-up"]
                   [:div.input-append
                    [:input.span3 {:type "text" :name "e-mail" :placeholder "Your e-mail address"}
                     (submit-button {:class "btn btn-primary"} "E-mail me when !Xebang launches")]])]]


        [:div.row [:div.span12 [:hr.padded]]]

        [:div.row [:div.span12.text-center [:p [:small "!Xebang is in no way affiliated with or endorsed by DuckDuckGo, Google, Yahoo, Bing or Launchy."]]]]

        [:div.spacer40]
        [:div.spacer40]))