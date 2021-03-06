(ns xebang.models.bangs)

(def catalog
  {'!bible      "http://www.bible.com/search/bible?q={{{s}}}"
   '!kidsinmind "http://www.kids-in-mind.com/cgi-bin/search/search.pl?q={{{s}}}"
   '!movies     "http://www.google.com/movies?hl=en&near={{{s}}}"
   '!weather    "http://www.wunderground.com/cgi-bin/findweather/hdfForecast?query={{{s}}}"
   '!w          "http://www.wunderground.com/cgi-bin/findweather/hdfForecast?query={{{s}}}"
   '!syn        "http://thesaurus.com/browse/{{{s}}}"
   '!def        "http://dictionary.com/browse/{{{s}}}"
   '!values     "http://0to255.com/{{{s}}}"
   '!devdocs    "http://devdocs.io/#q={{{s}}}"
   '!js         "http://devdocs.io/#q=js {{{s}}}"
   '!css        "http://devdocs.io/#q=css {{{s}}}"
   '!html       "http://devdocs.io/#q=html {{{s}}}"
   '!http       "http://devdocs.io/#q=http {{{s}}}"
   '!jquery     "http://devdocs.io/#q=jquery {{{s}}}"
   '!underscore "http://devdocs.io/#q=underscore {{{s}}}"
   '!backbone   "http://devdocs.io/#q=backbone {{{s}}}"
   '!markdown   "http://daringfireball.net/projects/markdown/syntax#{{{s}}}"
   '!namecheap  "http://www.namecheap.com/domains/domain-name-search/results.aspx?domain={{{s}}}&tlds=&searchall=&type=single&"
   '!email      "mailto:{{{s}}}"
   '!downloads  "chrome://downloads/"
   '!history    "chrome://settings/"})

(def mock-config
  {:default-search-pattern "http://duckduckgo.com/?q={{{s}}}"
   :bangs [{:bang "!bible"      :name "Bible"        :url-pattern "http://www.bible.com/search?q={{{s}}}"}
                   {:bang "!kidsinmind" :name "Kids in Mind" :url-pattern "http://www.kids-in-mind.com/cgi-bin/search/search.pl?q={{{s}}}"}
                   {:bang "!weather"    :name "WeatherSpark" :url-pattern "http://weatherspark.com/#!dashboard;q={{{s}}}"}
                   {:bang "!devdocs"    :name "DevDocs.io"   :url-pattern "http://devdocs.io/#q={{{s}}}"}
                   {:bang "!js"         :name "JavaScript"   :url-pattern "http://devdocs.io/#q=js {{{s}}}"}
                   {:bang "!css"        :name "CSS"          :url-pattern "http://devdocs.io/#q=css {{{s}}}"}
                   {:bang "!html"       :name "HTML"         :url-pattern "http://devdocs.io/#q=html {{{s}}}"}
                   {:bang "!namecheap"  :name "Domain Search"
                    :url-pattern "http://www.namecheap.com/domains/domain-name-search/results.aspx?domain={{{s}}}&tlds=&searchall=&type=single&"}]})
