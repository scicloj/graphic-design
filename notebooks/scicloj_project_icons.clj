^:kindly/hide-code?
(ns scicloj-project-icons
  "Helpers for making scicloj styled project icons"
  (:require [scicloj.graphic-design.backgrounds :as bac]
            [scicloj.graphic-design.borders :as bor]
            [scicloj.graphic-design.centers :as cen]
            [scicloj.graphic-design.config :as config]
            [scicloj.graphic-design.palette :as pal]
            [scicloj.graphic-design.projects :as projects]
            [scicloj.graphic-design.view :as view]
            [scicloj.kindly.v4.kind :as kind]))

;; # Scicloj themed icons
;;
;; Scicloj libraries would benefit from a common style for their icons and logos.
;; A common style gives a sense of community and composition.
;; Herein are recommendations for creating a common style based off the current Scicloj logo.
;;
;; ![The Scicloj logo](https://scicloj.github.io/sci-cloj-logo-transparent.png)
;;
;; Observing the large icon we notice that the central object is a graph.
;; Below the graph 3 gray bars form the base (plug) of a light bulb,
;; where the graph is the bulb.
;; Around the light bulb are blue and green parenthesis.
;;
;; ## Recommendations
;;
;; > 1. Adopt a **common border** around the edge
;; > 2. Choose **unique inner objects** that represent projects
;; > 3. Use the same background
;; > 4. Use a common palette of colors based on the Clojure logo
;; > 5. Use the same font as the Clojure website

^:kindly/hide-code?
(view/grid 7 [(view/component-card ["background" bac/on-white])
              [:strong "+"]
              (view/component-card ["parens" bor/tilted])
              [:strong "+"]
              (view/component-card ["heart" cen/kindly])
              [:strong "="]
              (view/icon-card ["kindly" [bac/on-white bor/tilted cen/kindly]])])

;; ## Goals
;;
;; These recommendations are intended as a starting point to help you be creative.
;; Variations on these themes are encouraged.
;; Our goal is harmony above standardization.
;;
;; ## Styling
;;
;; To achieve a consistent theme we share SVG configuration:

^:kindly/hide-code?
config/*config*

;; ### Palette

^:kindly/hide-code?
(view/grid 3 (map-indexed view/color-card pal/scicloj-palette-descriptions))

;; The existing Scicloj icon uses a different green and blue from Clojure.
;; The ClojureScript icon uses a different green as well.
;; Choosing to use the exact Clojure colors simplifies the choice
;; and emphasizes the Clojure connection.
;;
;; ### Font family
;;
;; Prefer the Clojure website font when displaying text beside or as part of a logo.

^:kindly/hide-code?
(kind/hiccup
  [:div {:style {:padding    10
                 :color      (pal/scicloj-palette 0)
                 :background (pal/scicloj-palette 8)}}
   [:div {:style {:text-align  "center"
                  :font-size   "2em"
                  :font-family (str "font-family: " config/clojure-font)
                  :background  (pal/scicloj-palette 2)}}
    "Clojure"]
   [:br]
   [:div {:style {
                  :text-align  "center"
                  :font-size   "2em"
                  :font-family (str "font-family: " config/clojure-font)
                  :background  (pal/scicloj-palette 1)}}
    "Scicloj"]])

;; ### Dimensions
;;
;; Icon should be squares, with simple graphics that can be recognized when they appear as a favicon.
;; Dimensions should be 256x256 so that it can be converted to favicon formats.
;;
;; A logo may be larger than an icon, but should share a similar theme.
;;
;; ## Icon components
;;
;; Icons are SVG images with border, center, and background components.
;; The border is the green and blue parens.
;; The center is a project specific shape.
;; The background is a white circle.
;;
;; ### Backgrounds

^:kindly/hide-code?
(view/grid 4 (map view/component-card bac/all))

;; ### Borders

^:kindly/hide-code?
(view/grid 4 (map view/component-card bor/all))

;; ### Centers

^:kindly/hide-code?
(view/grid 4 (map view/component-card cen/all))

;; ### Project preferences

^:kindly/hide-code?
(view/grid 3 (map view/icon-only projects/projects))

(projects/all)

^:kindly/hide-code?
(view/icon-card ["Noj" [bac/on-white cen/noj bor/tilted]])
