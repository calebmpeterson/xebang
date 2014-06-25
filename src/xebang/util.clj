(ns xebang.util)

(defn elide "Ellipsify strings longer than n" [n s]
  (if (>= (count s) n)
    (apply str (.substring s 0 (- n 3)) "...")
    s))
