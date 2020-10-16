(ns grant-tracker-ui.pages.timeline
    (:require
      [reagent.core :as r]
      ))


(def timelines [
  {:grant-name "Grant 1" :dates [
    {:name "Date 1" :days-from-now "-1"}
    {:name "Date 2" :days-from-now "7"}
    {:name "Date 3" :days-from-now "12"}
  ]}
  {:grant-name "Grant 2" :dates [
    {:name "Date 1" :days-from-now "-1"}
    {:name "Date 2" :days-from-now "7"}
    {:name "Date 3" :days-from-now "12"}]}
  {:grant-name "Grant 3" :dates [
    {:name "Date 1" :days-from-now "-1"}
    {:name "Date 2" :days-from-now "7"}
    {:name "Date 3" :days-from-now "12"}]}
])

(defn draw-line [start-pct end-pct] 
  [:div {:class "timeline-line" }])


(defn calc-left-pad [days-from-now timeline-scale] 
   (+ (* (/ days-from-now timeline-scale) 100) 25))

(defn draw-date [date]
  [:div 
    {:class "date-circle" 
    ;TODO This is using the wrong percentage... Change pane padding to see
      :style {:margin-left (str "" (calc-left-pad (date :days-from-now) 28) "%")}}
    [:div {:class "date-name"} (date :name)]])

(defn render-timeline-item [timeline-list-item]
  [:li {:key (timeline-list-item :grant-name) :class "timeline-item"} 
    (timeline-list-item :grant-name)
    (draw-line 0 100)
    (map draw-date (timeline-list-item :dates))])

(defn render-timeline-list [timeline-list] 
  (map render-timeline-item timeline-list))

(defn timeline []
  [:section {:class "content timeline-section"}
    [:header {:id 'content-header'} "Timeline"]
    [:div {:id 'timeline-options'} "Options"]
    [:div {:id 'timeline-pane'}
      [:ul (map render-timeline-item timelines)]
     ]])