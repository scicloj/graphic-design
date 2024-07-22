(ns scicloj.graphic-design.projects
  (:require [scicloj.graphic-design.backgrounds :as bac]
            [scicloj.graphic-design.borders :as bor]
            [scicloj.graphic-design.centers :as cen]
            [scicloj.graphic-design.config :as config]
            [scicloj.graphic-design.view :as view]
            [scicloj.kindly.v4.kind :as kind]))

(def projects
  (array-map
    "Clay" [#'bac/on-white #'bor/tilted #'cen/clay]
    "Kindly" [#'bac/on-white #'bor/tilted #'cen/kindly]
    "Cookbook" [#'bac/on-white #'bor/tilted #'cen/cookbook]
    "clj-djl" [#'bac/on-white #'bor/tilted #'cen/clj-dlj]
    "Metamorph" [#'bac/on-white #'bor/tilted #'cen/metamorph2]
    "scicloj.ml" [#'bac/on-white #'bor/tilted #'cen/ml]
    "TMD" [#'bac/on-white #'bor/tilted #'cen/tmd2]
    "Noj" [#'bac/on-white #'bor/tilted #'cen/noj]))

(def project-positions
  (array-map
    "Clay" [1 0]
    "Kindly" [3 0]
    "Cookbook" [0 1]
    "clj-djl" [2 1]
    "Metamorph" [4 1]
    "scicloj.ml" [1 2]
    "TMD" [3 2]
    "Noj" [2 3]))

(defn all []
  (into
    (kind/hiccup
      [:svg {:xmlns   "http://www.w3.org/2000/svg"
             :viewBox (str "-135 -130 " (* 135 6) " " (+ 30 (* 230 4)))}])
    (for [[k components] projects]
      (let [[x y] (get project-positions k)]
        (view/icon-g components
                     config/*config*
                     {:transform (str "translate(" (* 135 x) "," (* 230 y) ")")})))))
