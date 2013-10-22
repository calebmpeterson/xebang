(ns xebang.apps)

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
  {'!weather "http://www.weather.com/weather/hourbyhour/graph/{{{s}}}"})