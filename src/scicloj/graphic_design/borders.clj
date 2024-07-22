(ns scicloj.graphic-design.borders
  (:require [scicloj.graphic-design.view :as view]))

(defn circular [{:keys [palette]}]
  [:g {:stroke-linecap "butt"}
   [:path {:stroke (palette 1)
           :d      "M 0,-112 A 112 112 0 0 0 0,112"}]
   [:path {:stroke (palette 2)
           :d      "M 0,112 A 112 112 0 0 0 0,-112"}]])
(comment (view/icon [circular]))

(defn parens [{:keys [palette]}]
  [:g {:stroke-linecap "butt"}
   [:path {:stroke (palette 1)
           :d      "M -12,-112 C -146,-112 -146,112 -12,112"}]
   [:path {:stroke (palette 2)
           :d      "M 12,112 C 146,112 146,-112 12,-112"}]])
(comment (view/icon [parens]))

(defn squashed [{:keys [palette]}]
  [:g
   [:path {:stroke (palette 1)
           :d      "M -32,-112 Q -112,-112 -112,0 -112,112 -32,112"}]
   [:path {:stroke (palette 2)
           :d      "M 32,112 Q 112,112 112,0 112,-112 32,-112"}]])
(comment (view/icon [squashed]))

(defn tilted [{:keys [palette]}]
  [:g {:stroke-linecap "butt"}
   [:path {:stroke (palette 1)
           :d      "M -128,0 Q -112,0 -112,20 -100,100 -20,112 0,112 0,128"}]
   [:path {:stroke (palette 2)
           :d      "M 128,0 Q 112,0 112,-20 100,-100 20,-112  0,-112 0,-128"}]])
(comment (view/icon [tilted]))

(defn tilted2 [config]
  [:g {:transform "rotate(90)"}
   (tilted config)])
(comment (view/icon [tilted2]))

(defn tilted3 [config]
  [:g {:transform "rotate(180)"}
   (tilted config)])
(comment (view/icon [tilted2]))

(defn tilted4 [config]
  [:g {:transform "rotate(270)"}
   (tilted config)])
(comment (view/icon [tilted2]))

(defn gtlt [{:keys [palette]}]
  [:g
   [:path {:stroke (palette 1)
           :d      "M -112,0 L -80,80 0,112 80,80"}]
   [:path {:stroke (palette 2)
           :d      "M 112,0 L 80,-80 0,-112 -80,-80"}]])
(comment (view/icon [gtlt]))

(defn gtlt2 [config]
  [:g {:transform "rotate(90)"}
   (gtlt config)])
(comment (view/icon [gtlt2]))

(defn octo [{:keys [palette]}]
  [:g {:stroke-linecap "butt"
       :transform      "rotate(-45) scale(1.1)"}
   [:path {:stroke (palette 1)
           :d      "M -12,-112 C -146,-112 -146,112 -12,112"}]
   [:path {:stroke (palette 2)
           :d      "M 12,112 C 146,112 146,-112 12,-112"}]])
(comment (view/icon [octo]))

(def all (view/fns))
