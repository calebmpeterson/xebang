(ns xebang.controllers.bangs)

;; TODO strip the bang from the input after determining
;;      that it is indeed present and save all of the
;;      leading ! in the top-level catalog

;; TODO Use recursive bang catalogs for sub commands

(defn !bang [bangs ^String raw-query]
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