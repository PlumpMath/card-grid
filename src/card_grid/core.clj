(ns card-grid.core
  (:use [quil.core])
  (:gen-class))

(def grid-width 4)

(def grid-height 4)

(def content
  [{:title "Card one" :text "This is some text below the title"}
   {:title "Card two" :text "Hej!"}
   {:title "Card threeeee"}
   {:title "A new card"}])

(defn get-content [content x y]
  (let [i (+ x (* y grid-width))]
    (get content i)))

(defn setup [])

(defn render-card [x-pos y-pos w h content]
  (no-fill)
  (rect x-pos y-pos w h)
  (let [padding 10
        text-x (+ x-pos padding)
    	text-y (+ y-pos padding)]
    (fill 0)
    (text-align :left :top)
    (text (get content :title "-") text-x text-y)
    (text (get content :text "") text-x (+ text-y 30) 
          (- w (* padding 2)) h)))

(defn grid [x-steps y-steps]
  (let [m 5
        w (/ (- (width) (* m 2)) x-steps)
        h (/ (- (height) (* m 2)) y-steps)]
	  (doseq [x (range 0 x-steps)
              y (range 0 y-steps)]
        (let [rect-x (+ m (* x w))
              rect-y (+ m (* y h))]
	        (render-card rect-x rect-y w h (get-content content x y))))))

(defn draw []
  (background 240 240 230)
  (grid grid-width grid-height))

(defn start []
  (defsketch example
          :title "Card Grid"
          :size [600 800]
          :setup setup
          :draw draw))

(defn -main []
  (start))