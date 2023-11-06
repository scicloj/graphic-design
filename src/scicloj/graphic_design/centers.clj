(ns scicloj.graphic-design.centers
  (:require [scicloj.graphic-design.view :as view]))

(defn clay [{:keys [palette width]}]
  [:circle {:id   "gray ball of clay"
            :fill (palette 9)
            :r    (/ width 4.0)
            :cx   0
            :cy   0}])
(comment (view/icon [clay]))

(defn kindly [{:keys [palette]}]
  [:g {:id        "heart"
       :transform "translate(-120,-120) scale(10)"}
   [:path {:fill (palette 5)
           :d    "M 12.0 7.2 C 10.5 5.6 8.1 5.2 6.3 6.7 C 4.5 8.1 4.2 10.6 5.7 12.4 L 12.0 18.3 L 18.3 12.4 C 19.7 10.6 19.5 8.1 17.7 6.7 C 15.8 5.2 13.4 5.6 12.0 7.2 Z"}]])
(comment (view/icon [kindly]))

(defn tmd1 [{:keys [palette]}]
  [:g {:id "grid of data with header"}
   [:rect {:fill         (palette 8)
           :stroke       (palette 10)
           :stroke-width 8
           :x            -75
           :y            -50
           :width        150
           :height       100}]
   [:rect {:stroke       (palette 10)
           :fill         (palette 10)
           :stroke-width 8
           :x            -75
           :y            -50
           :width        150
           :height       25}]
   [:rect {:stroke       (palette 10)
           :stroke-width 8
           :x            -75
           :y            0
           :width        150
           :height       25}]
   [:rect {:stroke       (palette 10)
           :stroke-width 8
           :x            -25
           :y            -50
           :width        50
           :height       100}]])
(comment (view/icon [tmd1]))

(defn tmd2 [{:keys [palette]}]
  (let [width 150.0
        w2 (/ width 2.0)
        height 100.0
        h2 (/ height 2.0)
        cols 3
        rows 4]
    (into [:g {:id           "grid of data"
               :stroke       (palette 10)
               :stroke-width 8}
           [:rect {:fill   (palette 8)
                   :x      (- w2)
                   :y      (- h2)
                   :width  width
                   :height height}]]
          (concat
            (for [y (range (- h2) (inc h2) (/ height rows))]
              [:line {:x1 (- w2) :y1 y :x2 w2 :y2 y}])
            (for [x (range (- w2) (inc w2) (/ width cols))]
              [:line {:x1 x :y1 (- h2) :x2 x :y2 h2}])))))
(comment (view/icon [tmd2]))

(defn tmd3 [{:keys [palette]}]
  (let [width 150.0
        w2 (/ width 2.0)
        height 90.0
        h2 (/ height 2.0)
        cols 3
        rows 3]
    (into [:g {:id           "grid of data"
               :stroke       (palette 6)
               :stroke-width 8}
           [:rect {:fill   (palette 7)
                   :x      (- w2)
                   :y      (- h2)
                   :width  width
                   :height height}]]
          (concat
            (for [y (range (- h2) (inc h2) (/ height rows))]
              [:line {:x1 (- w2) :y1 y :x2 w2 :y2 y}])
            (for [x (range (- w2) (inc w2) (/ width cols))]
              [:line {:x1 x :y1 (- h2) :x2 x :y2 h2}])))))
(comment (view/icon [tmd3]))

(defn clj-dlj [{:keys [palette]}]
  (let [x1 -64
        col1 (range -32 33 32)
        x2 0
        col2 (range -64 65 32)
        x3 64
        col3 (range -16 17 32)
        r 14]
    [:g {:id "net"}
     [:g {:stroke-width 4
          :stroke       (palette 8)}
      (into [:g]
            (for [a col1
                  b col2]
              [:line {:x1 x1 :y1 a :x2 x2 :y2 b}]))
      (into [:g]
            (for [a col2
                  b col3]
              [:line {:x1 x2 :y1 a :x2 x3 :y2 b}]))]
     (into [:g {:fill (palette 6)}]
           (for [y col1]
             [:circle {:r r :cx -64 :cy y}]))
     (into [:g {:fill (palette 7)}]
           (for [y col2]
             [:circle {:r r :cx 0 :cy y}]))
     (into [:g {:fill (palette 5)}]
           (for [y col3]
             [:circle {:r r :cx 64 :cy y}]))]))
(comment (view/icon [net]))

(defn metamorph [{:keys [palette font-family]}]
  [:g {:id "tilde"}
   [:text {:fill  (palette 6)
           :x     -74
           :y     64
           :style {:font        "250px sans-serif"
                   :font-family font-family}}
    "~"]])
(comment (view/icon [metamorph]))

(defn metamorph2 [{:keys [palette font-family]}]
  (let [m "M -55 55 L -55 -55 -18 -55 -18 55 18 55 18 -55 55 -55 55 55"]
    [:g {:id           "tilde"
         :stroke       (palette 6)
         :stroke-width 20
         :stroke-linecap "square"}
     [:path {:stroke       (palette 7)
             :stroke-width 30
             :d m}]
     [:path {:d m}]
     [:path {:stroke (palette 7)
             :stroke-width 10
             :stroke-linecap "round"
             :d "M -67 65 L -43 65"}]
     [:path {:stroke (palette 7)
             :stroke-width 10
             :stroke-linecap "round"
             :d "M 67 65 L 43 65"}]
     [:path {:stroke (palette 7)
             :stroke-width 10
             :stroke-linecap "round"
             :d "M -30 -20 L -6 -20"}]
     [:path {:stroke (palette 7)
             :stroke-width 10
             :stroke-linecap "round"
             :d "M 30 20 L 6 20"}]]))
(comment (view/icon [metamorph2])
         (require '[scicloj.kind-portal.v1.api])
         (scicloj.kind-portal.v1.api/kindly-submit-context
           {:value (view/icon [scicloj.graphic-design.backgrounds/on-white
                               scicloj.graphic-design.borders/octo
                               metamorph2])}))

(defn ml [{:keys [palette]}]
  [:g {:id     "robot head"
       :stroke (palette 4)
       :fill   (palette 4)}
   [:path {:stroke-width 20
           :d            "M -64 -20 L 64 -20 55 40 -55 40 z"}]
   [:line {:stroke-width 10
           :x1           0 :y1 0 :x2 0 :y2 -64}]
   [:circle {:stroke "none"
             :cx     0 :cy -64 :r 10}]
   [:g {:fill         (palette 10)
        :stroke       (palette 10)
        :stroke-width 10}
    [:circle {:cx -32 :cy 0 :r 8}]
    [:circle {:cx 32 :cy 0 :r 8}]
    [:line {:x1 -16 :y1 30 :x2 16 :y2 30}]]])
(comment (view/icon [ml]))

(defn cookbook [{:keys [palette]}]
  [:g {:id     "cooking pot"
       :stroke (palette 10)
       :fill   (palette 10)}
   [:g {:id "lid"}
    [:line {:stroke-width 10
            :x1           -10
            :y1           -65
            :x2           10
            :y2           -65}]
    [:line {:stroke-width 10
            :x1           0
            :y1           -65
            :x2           0
            :y2           -55}]
    [:path {:stroke-width 10
            :d            "M -68 -38 L 68 -38 25 -50 -25 -50 z"}]]
   [:g {:id "pot"}
    [:rect {:stroke-width 10
            :x            -80
            :y            -10
            :width        10
            :height       1}]
    [:rect {:stroke-width 10
            :x            70
            :y            -10
            :width        10
            :height       1}]
    [:path {:stroke-width 20
            :d            "M -64 -20 L 64 -20 55 40 -55 40 z"}]]])

(comment (view/icon [cookbook]))

(def all (view/fns))
