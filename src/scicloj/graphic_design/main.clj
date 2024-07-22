(ns scicloj.graphic-design.main
  (:require [clojure.java.io :as io]
            [dali.io :as dio]
            [hiccup2.core :as hiccup2]
            [scicloj.clay.v2.api :as clay]
            [scicloj.graphic-design.config :as config]
            [scicloj.graphic-design.projects :as projects]
            [scicloj.graphic-design.view :as view]))

;; TODO: dali.io requires a different top level flag
(defn render-icon [icon dir filename]
  (doto icon
    (dio/render-svg (doto (io/file dir (str filename ".svg"))
                      (io/make-parents)))
    (dio/render-png (io/file dir (str filename ".png")))))

(defn render-icons []
  (doseq [[project-name components] projects/projects]
    (spit (doto (io/file "icons" (str project-name ".svg"))
            (io/make-parents))
          (hiccup2/html (view/icon components (update config/*config* :attrs assoc :width 256 :height 256)))))
  (spit (io/file "icons" "all.svg")
        (hiccup2/html (projects/all))))

(defn -main [& args]
  (render-icons)
  (clay/make! {:show false})
  (System/exit 0))

(comment
  (-main))
