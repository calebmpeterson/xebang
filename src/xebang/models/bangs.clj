(ns xebang.models.bangs)

(def catalog
  {'!bible      "http://www.bible.com/search?q={{{s}}}"
   '!kidsinmind "http://www.kids-in-mind.com/cgi-bin/search/search.pl?q={{{s}}}"
   '!weather    "http://weatherspark.com/#!dashboard;q={{{s}}}"
   '!w          "http://weatherspark.com/#!dashboard;q={{{s}}}"
   '!syn        "http://thesaurus.com/browse/{{{s}}}"
   '!def        "http://dictionary.com/browse/{{{s}}}"
   '!devdocs    "http://devdocs.io/#q={{{s}}}"
   '!js         "http://devdocs.io/#q=js {{{s}}}"
   '!css        "http://devdocs.io/#q=css {{{s}}}"
   '!html       "http://devdocs.io/#q=html {{{s}}}"
   '!jquery     "http://devdocs.io/#q=jquery {{{s}}}"
   '!underscore "http://devdocs.io/#q=underscore {{{s}}}"
   '!namecheap  "http://www.namecheap.com/domains/domain-name-search/results.aspx?domain={{{s}}}&tlds=&searchall=&type=single&"})

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
