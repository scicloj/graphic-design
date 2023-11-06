(ns scicloj.graphic-design.config
  (:require [scicloj.graphic-design.palette :as pal]))

(def clojure-font "'Open Sans',sans-serif;")

(def ^:dynamic *config*
  {:width       256
   :height      256
   :palette     #'pal/scicloj-palette
   :font-family clojure-font
   :attrs       {:fill            "none"
                 :stroke-linecap  "round"
                 :stroke-linejoin "round"
                 :stroke-width    32}})
