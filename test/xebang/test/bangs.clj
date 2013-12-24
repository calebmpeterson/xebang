(ns xebang.test.bangs
  (:require [clojure.test :refer :all]
            [xebang.controllers.bangs :as bangs]))


;;
;; How I really think I want bangs to be structured
;; * some params
;; * some static
;; * some nesting
;; * some flat
;; * some nested
;;

(def catalog
  {'bible   {'root "http://www.bible.com/search?q={{{s}}}"}
   'weather {'root "http://www.weather.com/weather/hourbyhour/graph/{{{s}}}"}
   'clojure {'root "http://clojure.org/cheatsheet"
             'docs "http://clojuredocs.org/search?q={{{s}}}"}
   'play {'root        "http://www.playframework.com/documentation/1.2.7/home"
          'controllers "http://www.playframework.com/documentation/1.2.7/cheatsheet/controllers"
          'templates   "http://www.playframework.com/documentation/1.2.7/cheatsheet/templates"
          'tags        "http://www.playframework.com/documentation/1.2.7/tags"
          'models      "http://www.playframework.com/documentation/1.2.7/cheatsheet/model"
          'modules     "http://www.playframework.com/modules"}
   'html {'root "http://devdocs.io/#q=html {{{s}}}"}
   'css  {'root "http://devdocs.io/#q=css {{{s}}}"}
   'js   {'root "http://devdocs.io/#q=js {{{s}}}"}})