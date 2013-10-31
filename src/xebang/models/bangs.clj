(ns xebang.models.bangs)

(def catalog
  {'!bible   "http://www.bible.com/search?q={{{s}}}"
   '!weather "http://weatherspark.com/#!dashboard;q={{{s}}}"
   '!devdocs "http://devdocs.io/#q={{{s}}}"
   '!js      "http://devdocs.io/#q=js {{{s}}}"
   '!css     "http://devdocs.io/#q=css {{{s}}}"
   '!html    "http://devdocs.io/#q=html {{{s}}}"})