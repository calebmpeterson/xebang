(ns xebang.apps)

;; TODO strip the bang from the input after determining
;;      that it is indeed present and save all of the
;;      leading ! in the top-level catalog

;; TODO Use recursive bang catalogs for sub commands

(defn process [bangs ^String raw-query]
  (let [words (.split raw-query " ")
        bang  (-> words first symbol)
        query (->> words
                   (rest)
                   (interpose " ")
                   (apply str))]
      (cond
       (contains? bangs bang) (.replace (bangs bang) "{{{s}}}" query)
       (.startsWith raw-query "!") (.replace "https://duckduckgo.com/?q={{{s}}}" "{{{s}}}" raw-query)
       :else (.replace "https://duckduckgo.com/?q={{{s}}}" "{{{s}}}" raw-query))))

(def catalog
  {'!bible   "http://www.bible.com/search?q={{{s}}}"
   '!weather "http://www.weather.com/weather/hourbyhour/graph/{{{s}}}"
   '!devdocs "http://devdocs.io/#q={{{s}}}"
   '!js      "http://devdocs.io/#q=js {{{s}}}"
   '!css     "http://devdocs.io/#q=css {{{s}}}"
   '!html    "http://devdocs.io/#q=html {{{s}}}"})