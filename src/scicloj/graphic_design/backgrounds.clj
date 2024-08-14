(ns scicloj.graphic-design.backgrounds
  (:require [scicloj.graphic-design.view :as view]))

(defn on-white [{:keys [width height palette]}]
  [:circle {:fill   (palette 0)
            :r      (/ (min width height) 2)
            :cx     0
            :cy     0
            :stroke "none"}])
(comment (view/icon [on-white]))

(defn clear [_]
  nil)
(comment (view/icon [clear]))

(defn on-dark [{:keys [width height palette]}]
  [:circle {:fill   (palette 10)
            :r      (/ (min width height) 2)
            :cx     0
            :cy     0
            :stroke "none"}])
(comment (view/icon [on-dark]))

(defn on-gold [{:keys [width height palette]}]
  [:circle {:fill   (palette 6)
            :r      (/ (min width height) 2)
            :cx     0
            :cy     0
            :stroke "none"}])
(comment (view/icon [on-gold]))

(def all (view/fns))
