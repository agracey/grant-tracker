(ns grant-tracker-ui.core
    (:require
      [reagent.core :as r]
      [reagent.dom :as d]
      [secretary.core :as secretary :refer-macros [defroute]]
      [grant-tracker-ui.layout.main :refer [build-main-layout]]
      [grant-tracker-ui.pages.timeline :refer [timeline]]
      ))

;; -------------------------
;; Initialize app




(def route-list [
  {:title "Timelines" :path "/" :content timeline :sub-menu []}
  {:title "Tracking" :path "/tracking" :sub-menu [
    {:title "Ideas" :path "/tracking/ideas" }
    {:title "Researching" :path "/tracking/research" }
    {:title "Parked" :path "/tracking/parked" }
    {:title "Inflight" :path "/tracking/inflight" }
    ]}
  {:title "Rejected" :path "/rejected" :sub-menu []}
  {:title "Active" :path "/active" :sub-menu []}
])

(def main-layout (build-main-layout route-list))

(secretary/set-config! :prefix "#")

(def application
  (js/document.getElementById "app"))

(defn set-html! [el layout content]
  (d/render (layout content) el))

(defroute root-path "*" []
  (set-html! application main-layout timeline))


(defroute timeline-path "/timeline" []
  (set-html! application main-layout timeline))

(defn getHash [] 
  (clojure.string/replace-first js/window.location.hash "#" ""))

(js/console.log (getHash))
(secretary/dispatch! (getHash))
