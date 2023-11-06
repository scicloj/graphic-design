(ns scicloj.graphic-design.projects
  (:require [scicloj.graphic-design.backgrounds :as bac]
            [scicloj.graphic-design.borders :as bor]
            [scicloj.graphic-design.centers :as cen]))

(def projects
  {"Clay"       [bac/on-white bor/tilted cen/clay]
   "Kindly"     [bac/on-white bor/tilted cen/kindly]
   "Cookbook"   [bac/on-white bor/parens cen/cookbook]
   "clj-djl"    [bac/on-white bor/parens cen/clj-dlj]
   "Metamorph"  [bac/on-white bor/octo cen/metamorph2]
   "scicloj.ml" [bac/on-white bor/octo cen/ml]
   "TMD"        [bac/on-white bor/parens cen/tmd2]})
