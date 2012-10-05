(ns card-grid.core
  (:use [quil.core])
  (:gen-class))

(def content
  [{:title "Card one"}
   {:title "Card two"}])

(defn setup [])

(defn grid [x-steps y-steps]
  (no-fill)
  (let [m 10
        w (/ (- (width) (* m 2)) x-steps)
        h (/ (- (height) (* m 2)) y-steps)]
	  (doseq [x (range 0 x-steps)
              y (range 0 y-steps)]
    	(rect (+ m (* x w)) (+ m (* y h)) w h))))

(defn draw []
  (background 240 240 230)
  (grid 5 6)
  (line 10 300 10 500))

(defn start []
  (defsketch example
          :title "Card Grid"
          :size [600 800]
          :setup setup
          :draw draw))

(defn -main []
  (start))