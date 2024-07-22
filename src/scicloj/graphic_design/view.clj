(ns scicloj.graphic-design.view
  "Helpers for making scicloj styled project icons"
  (:require [scicloj.graphic-design.config :as config]
            [scicloj.kindly.v4.kind :as kind]))

(defn grid [n rows]
  (kind/hiccup
    (into [:div {:style {:display               "grid"
                         :grid-template-columns (str "repeat(" n ", 1fr)")
                         :gap                   10
                         :align-items           "center"
                         :justify-content       "center"
                         :text-align            "center"}}]
          (for [column rows]
            [:div column]))))

(defn hex [elements]
  (let [n (count elements)
        n2 (int (Math/ceil (Math/sqrt n)))]
    (kind/hiccup
      (into [:svg {:xmlns   "http://www.w3.org/2000/svg"
                   :viewBox (str "-128 -128 " (+ 128 (* 275 n2)) " " (* 256 n2))}]
            (map-indexed
              (fn [idx element]
                (let [col (rem idx n2)
                      row (quot idx n2)
                      x (+ (* 275 col) (if (even? row) 128 0))
                      y (* 230 row)]
                  [:g {:transform (str "translate(" x "," y ")")}
                   element])))
            elements))))

(defn color-card [idx [color description text-color]]
  [:div {:style {:padding          10
                 :background-color color
                 :color            text-color}}
   [:div idx]
   [:div color]
   [:div description]])

(defn fns []
  (-> (ns-interns *ns*)
      (dissoc 'all)
      (update-vals deref)
      (update-keys name)))

(defn deref-var [x]
  (if (var? x)
    @x
    x))

(defn apply-fn [x config]
  (if (fn? x)
    (x config)
    x))

(defn icon
  "Icons consist of components such as background, border, center.
  Components are either SVG hiccup fragments,
  or functions that produce SVG hiccup fragments from configuration."
  ([components]
   (icon components config/*config*))
  ([components config]
   (let [{:keys [width height attrs]} config
         attrs (into {:viewBox [(- (/ width 2)) (- (/ width 2)) width height]
                      :xmlns   "http://www.w3.org/2000/svg"}
                     attrs)]
     (->> (map #(-> % (deref-var) (apply-fn config)) components)
          (remove nil?)
          (into [:svg attrs])
          (kind/hiccup)))))

(def checkerboard-style
  {:background-image    "linear-gradient(45deg, #DDDDDD 25%, transparent 25%),
                         linear-gradient(-45deg, #DDDDDD 25%, transparent 25%),
                         linear-gradient(45deg, transparent 75%, #DDDDDD 75%),
                         linear-gradient(-45deg, transparent 75%, #DDDDDD 75%)"
   :background-size     "20px 20px"
   :background-position " 0 0, 0 10px, 10px -10px, -10px 0px"})

(defn icon-only [[style-name components]]
  [:div (icon components)])

(defn icon-card [[style-name components]]
  (kind/hiccup
    [:div
     [:h4 (name style-name)]
     [:div {:style checkerboard-style}
      (icon components)]]))

(defn component-card [[style-name component]]
  (icon-card [style-name [component]]))

(defn icon-g
  "Icons consist of components such as background, border, center.
  Components are either SVG hiccup fragments,
  or functions that produce SVG hiccup fragments from configuration."
  [components config attrs]
  (->> (map #(-> % (deref-var) (apply-fn config)) components)
       (remove nil?)
       (into [:g (merge (:attrs config) attrs)])
       (kind/hiccup)))
