(ns grant-tracker-ui.layout.main
    (:require
      [reagent.core :as r]
      [grant-tracker-ui.layout.header :refer [page-header]]
      [grant-tracker-ui.layout.menu :refer [page-menu]]))


(defn main-layout [content route-list]
  [:div.layout
    (page-header)
    (page-menu route-list)
    (content)])

    
(defn build-main-layout [route-list]
  (fn [content] (main-layout content route-list)))