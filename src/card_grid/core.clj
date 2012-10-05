(ns card-grid.core
  (:use [quil.core])
  (:gen-class))

(def grid-width 4)

(def grid-height 5)

(def content
  [{:title "Card one"}
   {:title "Card two"}])

(defn get-content [content x y]
  (let [i (+ x (* y grid-height))]
    (get content i)))

(defn setup [])

(defn render-card [x y w h]
  (no-fill)
  (rect x y w h)
  (let [text-x (+ x 10)
    	text-y (+ y 20)]
    (fill 0)
    (text "HEJ!" text-x text-y)))

(defn grid [x-steps y-steps]
  (let [m 10
        w (/ (- (width) (* m 2)) x-steps)
        h (/ (- (height) (* m 2)) y-steps)]
	  (doseq [x (range 0 x-steps)
              y (range 0 y-steps)]
        (let [rect-x (+ m (* x w))
              rect-y (+ m (* y h))]
	        (render-card rect-x rect-y w h)))))

(defn draw []
  (background 240 240 230)
  (grid grid-width grid-height)
  (line 10 300 10 500))

(defn start []
  (defsketch example
          :title "Card Grid"
          :size [600 800]
          :setup setup
          :draw draw))

(defn -main []
  (start))